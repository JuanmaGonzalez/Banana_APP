package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.netmind.models.Proyecto;

public final class ProyectosDAOImpl extends ProyectosDAO {
	private static Logger logger = Logger.getLogger("MaquillajeDaoImpl");
	
	private static ProyectosDAOImpl instance = null;

	public static ProyectosDAOImpl getInstance() {
		if (instance == null) {
			instance = new ProyectosDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Proyecto getMaquillaje(int mid) {
		Proyecto maquillajeADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m WHERE m.mid=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mid);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				maquillajeADevolver = new Proyecto(rs.getInt("pid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			maquillajeADevolver = null;
		}

		return maquillajeADevolver;
	}

	@Override
	public boolean delMaquillaje(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMaquillaje(Proyecto cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMaquillaje(Proyecto cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Proyecto> getUserMaquillajes(int uid) {
		List<Proyecto> listADevolver = new ArrayList<Proyecto>();

		try {
			Connection conn = this.datasource.getConnection();

			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m INNER JOIN compra c ON c.cosmetico=m.mid WHERE c.usuario=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				listADevolver.add(new Proyecto(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
			}

			pstm.close();

			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

	@Override
	public List<Proyecto> getMaquillajes() {
		List<Proyecto> listADevolver = new ArrayList<Proyecto>();

		try {
			Connection conn = this.datasource.getConnection();

			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m WHERE 1";
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				listADevolver.add(new Proyecto(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
			}

			pstm.close();

			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

}
