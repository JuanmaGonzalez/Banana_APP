package com.netmind.db;

import java.util.List;

import com.netmind.models.Maquillaje;

public final class MaquillajeDAOImplMongo extends MaquillajeDAO {
	
	private static MaquillajeDAOImplMongo instance = null;

	public static MaquillajeDAOImplMongo getInstance() {
		if (instance == null) {
			instance = new MaquillajeDAOImplMongo();
		}
		return instance;
	}
	
	@Override
	public Maquillaje getMaquillaje(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maquillaje> getUserMaquillajes(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maquillaje> getMaquillajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delMaquillaje(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMaquillaje(Maquillaje cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMaquillaje(Maquillaje cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

}
