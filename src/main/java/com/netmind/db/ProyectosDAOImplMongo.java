package com.netmind.db;

import java.util.List;

import com.netmind.models.Proyecto;

public final class ProyectosDAOImplMongo extends ProyectosDAO {
	
	private static ProyectosDAOImplMongo instance = null;

	public static ProyectosDAOImplMongo getInstance() {
		if (instance == null) {
			instance = new ProyectosDAOImplMongo();
		}
		return instance;
	}
	
	@Override
	public Proyecto getMaquillaje(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> getUserMaquillajes(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> getMaquillajes() {
		// TODO Auto-generated method stub
		return null;
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

}
