package com.netmind.db;

import java.util.List;

import com.netmind.models.Proyecto;

public abstract class ProyectosDAO extends DAO {
	public abstract Proyecto getMaquillaje(int mid);
	public abstract List<Proyecto> getUserMaquillajes(int uid);
	public abstract List<Proyecto> getMaquillajes();
	public abstract boolean delMaquillaje(int mid);
	public abstract boolean insertMaquillaje(Proyecto cosmetico);
	public abstract boolean updateMaquillaje(Proyecto cosmetico);
}
