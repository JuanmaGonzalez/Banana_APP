package com.netmind.models;

import java.util.Date;

public class tareas {
	private int tid;
	private int uid;
	private int pid;
	private String tarea;
	private Date fecha;
	
	public tareas(int tid, int uid, int pid, String tarea, Date fecha) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.pid = pid;
		this.tarea = tarea;
		this.fecha = fecha;
	}
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}