package com.netmind.db;

import com.netmind.models.Tarea;

public abstract class TareasDAO extends DAO {
	public abstract Tarea getCompra(int cid);
	public abstract boolean delCompra(int cid);
	public abstract boolean insertCompra(Tarea compra);
	public abstract boolean updateCompra(Tarea compra);
}
