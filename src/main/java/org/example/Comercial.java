package org.example;

/**
 * Clase Comercial para la gestión de vehículos comerciales
 */

public class Comercial extends Vehiculo {

	private String tipo;
	private String combustible;
	private int potencia;
	
	public Comercial(String matricula, String marca, String modelo, Cliente propietario, String tipo,
			String combustible, int potencia) throws ObjetoErroneo {
		super(matricula, marca, modelo, propietario);
		this.tipo = tipo;
		this.combustible = combustible;
		this.potencia = potencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString() + "tipo=" + tipo + ", combustible=" + combustible + ", potencia=" + potencia + "/";
	}

}
