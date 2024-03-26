package org.example;

public class Industrial extends Vehiculo {
	
	private String tipo;
	private int peso;
	private int actividad;
	
	
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
