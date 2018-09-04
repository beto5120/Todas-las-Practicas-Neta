package net.netasystems.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author NetaSystems / Jose Alberto Fuentes Loredo
 * 
 * En esta clase se asignas variables privadas y se generan Getters y Setters
 *
 */
public class CatTipoFabrica implements Serializable {
	
	public CatTipoFabrica(long idCatTipoFabrica, String nombre, char status, Date fechaModificacion, long idUsuario) {
		super();
		this.idCatTipoFabrica = idCatTipoFabrica;
		this.nombre = nombre;
		this.status = status;
		this.fechaModificacion = fechaModificacion;
		this.idUsuario = idUsuario;
	}
	
	public CatTipoFabrica() {
	}
	
	private long idCatTipoFabrica;
	private String nombre;
	private Character status;
	private Date fechaModificacion;
	private Long idUsuario;

	/**
	 *Obtiene el valor
	 * @return the idCatTipoFabrica
	 */
	public long getIdCatTipoFabrica() {
		return idCatTipoFabrica;
	}

	/**
	 *Asigna el valor 
	 * @param idCatTipoFabrica the idCatTipoFabrica to set
	 */
	public void setIdCatTipoFabrica(long idCatTipoFabrica) {
		this.idCatTipoFabrica = idCatTipoFabrica;
	}

	/**
	 *Obtiene el valor
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *Asigna el valor 
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *Obtiene el valor
	 * @return the status
	 */
	public Character getStatus() {
		return status;
	}

	/**
	 *Asigna el valor 
	 * @param status the status to set
	 */
	public void setStatus(Character status) {
		this.status = status;
	}

	/**
	 *Obtiene el valor
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 *Asigna el valor 
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 *Obtiene el valor
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 *Asigna el valor 
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaModificacion == null) ? 0 : fechaModificacion.hashCode());
		result = prime * result + (int) (idCatTipoFabrica ^ (idCatTipoFabrica >>> 32));
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatTipoFabrica other = (CatTipoFabrica) obj;
		if (fechaModificacion == null) {
			if (other.fechaModificacion != null)
				return false;
		} else if (!fechaModificacion.equals(other.fechaModificacion))
			return false;
		if (idCatTipoFabrica != other.idCatTipoFabrica)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CatTipoFabrica [idCatTipoFabrica=" + idCatTipoFabrica + ", nombre=" + nombre + ", status=" + status
				+ ", fechaModificacion=" + fechaModificacion + ", idUsuario=" + idUsuario + "]";
	}
	
	
	
}