package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import com.netmind.models.Tarea;
import com.netmind.models.Proyecto;

public final class TareasDAOImpl extends TareasDAO {
	private static Logger logger = Logger.getLogger("CompraDAOImpl");

	private static TareasDAOImpl instance = null;

	public static TareasDAOImpl getInstance() {
		if (instance == null) {
			instance = new TareasDAOImpl();
		}
		return instance;
	}

	@Override
	public Tarea getCompra(int cid) {
		Tarea compraADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT c.* FROM compra c WHERE c.cid=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			
			UsuarioDAO uDAO=(UsuarioDAO)UsuarioDAOImpl.getInstance();
			ProyectosDAO mDAO=(ProyectosDAO)ProyectosDAOImpl.getInstance();

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				compraADevolver = new Tarea(cid,
						uDAO.getUsuario(rs.getInt("usuario")),
						mDAO.getMaquillaje(rs.getInt("cosmetico")), 
						rs.getInt("cantidad"), 
						rs.getDate("fecha"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			compraADevolver = null;
		}

		return compraADevolver;
	}

	@Override
	public boolean delCompra(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCompra(Tarea nuevaCompra) {
		boolean exito = false;

		try {

			Connection conn = this.datasource.getConnection();

			try {
				conn.setAutoCommit(false);

				// INSERTAR EN COMPRA
				String sql = "INSERT INTO compra VALUES(NULL,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getUsuario().getUid());
				pstm.setInt(2, nuevaCompra.getCosmetico().getMid());
				pstm.setInt(3, nuevaCompra.getCantidad());

				SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
				pstm.setString(4, sdfr.format(nuevaCompra.getFecha()));

				int rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR SALDO DE USUARIO
				sql = "UPDATE usuario u SET u.saldo=u.saldo-? WHERE u.uid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getCosmetico().getPrecio() * nuevaCompra.getCantidad());
				pstm.setInt(2, nuevaCompra.getUsuario().getUid());
				rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR EXISTENCIAS DE MAQUILLAJE
				sql = "UPDATE maquillaje m SET m.existencias=m.existencias-? WHERE m.mid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getCantidad());
				pstm.setInt(2, nuevaCompra.getCosmetico().getMid());
				rows = pstm.executeUpdate();

				pstm.close();

				conn.commit();

				conn.close();

				logger.info("Inserción exitosa");
				exito = rows > 0 ? true : false;

			} catch (Exception e) {
				conn.rollback();
				logger.severe("Transacción fallida:" + e.getMessage());
				exito = false;
			}

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e.getMessage());
			exito = false;
		}

		return exito;
	}

	@Override
	public boolean updateCompra(Tarea compra) {
		// TODO Auto-generated method stub
		return false;
	}
}
