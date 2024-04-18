package org.example;


/**
 * Clase Industrial para la gestión de vehículos industriales
 */
public class Industrial extends Vehiculo {
	
	private String tipo;
	private int peso;
	private int actividad;

	/**
	 * Constructor de Industrial
	 * @param matricula Matrícula del vehículo
	 * @param marca Marca del vehículo
	 * @param modelo Modelo del vehículo
	 * @param propietario Propietario del vehículo
	 * @param tipo Tipo de vehículo
	 * @param peso Peso del vehículo
	 * @param actividad Actividad del vehículo
	 * @throws ObjetoErroneo Si la matrícula, la marca, el modelo, el propietario, el tipo, el peso o la actividad son nulos o están vacios
	 */
	public Industrial(String matricula, String marca, String modelo, Cliente propietario, String tipo, int peso,
			int actividad) throws ObjetoErroneo {
		super(matricula, marca, modelo, propietario);
		this.tipo = tipo;
		this.peso = peso;
		this.actividad = actividad;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public int getActividad() {
		return actividad;
	}


	public void setActividad(int actividad) {
		this.actividad = actividad;
	}


	@Override
	public String toString() {
		return super.toString() + "tipo=" + tipo + ", peso=" + peso + ", actividad=" + actividad + "/";
	}
	
	
	
}
