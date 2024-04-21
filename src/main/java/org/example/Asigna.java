package org.example;


/**
 * Clase Asigna para la gestión de asignaciones de mecánicos a reparaciones
 */
public class Asigna {
	/**
	 * Clase Asigna
	 * @param reparacion
	 * @param mecanico
	 * @throws ObjetoErroneo
	 */
	private Reparacion reparacion;
	private Mecanico mecanico;
	private int horas;

	public Asigna(Reparacion reparacion, Mecanico mecanico) throws ObjetoErroneo {
		this.reparacion = reparacion;
		this.mecanico = mecanico;
		if (mecanico == null || reparacion == null) {
			throw new ObjetoErroneo();
		}
		horas = 0;
	}

	public Reparacion getReparacion() {
		return reparacion;
	}

	public void setReparacion(Reparacion reparacion) {
		this.reparacion = reparacion;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public int getHoras() {
		return horas;
	}

	public void sumaHoras(int horas) {
		if (this.horas + horas >= 0) {
			this.horas += horas;		
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Asigna)) {
			return false;
		}
		Asigna other = (Asigna) obj;
		if (mecanico == null) {
			if (other.mecanico != null) {
				return false;
			}
		} else if (!mecanico.equals(other.mecanico)) {
			return false;
		}
		if (reparacion == null) {
			if (other.reparacion != null) {
				return false;
			}
		} else if (!reparacion.equals(other.reparacion)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Asigna [reparacion=" + reparacion.getNumero() + " " + reparacion.getDescripcion() + ", mecanico=" + mecanico + ", horas=" + horas + "]";
	}

}
