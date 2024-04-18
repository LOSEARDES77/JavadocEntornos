package org.example;

/**
 * Clase abstracta Vehículo para la gestión de vehículos
 */

public abstract class Vehiculo {

	private String matricula;
	private String marca;
	private String modelo;
	private Cliente propietario;


	/**
	 * Tiene checks si la matricula o el modelo son nulos o estan vacios
	 * @param matricula Matrícula del coche (ej. 2938GFJ)
	 * @param marca Marca del coche (ej. Audi)
	 * @param modelo Modelo del coche (ej. A3)
	 * @param propietario Nombre del propietario del coche
	 * @throws ObjetoErroneo Si la matricula o el modelo son nulos o estan vacios
	 */
	public Vehiculo(String matricula, String marca, String modelo, Cliente propietario) throws ObjetoErroneo {

		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = propietario;
		if (matricula == null || matricula.trim().length() == 0 || marca == null || marca.trim().length() == 0
				|| modelo == null || modelo.trim().length() == 0 || propietario == null) {
			throw new ObjetoErroneo();
		}
	}

	@Override
	public String toString() {
		return "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", propietario=" + propietario ;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula.toUpperCase();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehiculo)) {
			return false;
		}
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		return true;
	}

}
