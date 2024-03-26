package org.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Reparacion {

	private int numero;
	private static int numSiguiente = 1;
	private String descripcion;
	private String[] piezas;
	private Float[] precios;
	private Vehiculo coche;
	private Calendar fecha;
	private boolean cerrado;
	private static Util<String> p = new Util<>();
	private static Util<Float> f = new Util<>();

	public Reparacion(String descripcion, Vehiculo coche, Calendar fecha) throws ObjetoErroneo {
		this.descripcion = descripcion;
		this.coche = coche;
		this.fecha = fecha;
		if (fecha == null || coche == null || descripcion == null || descripcion.trim().length() == 0) {
			throw new ObjetoErroneo();
		}
		numero = numSiguiente;
		numSiguiente++;
		piezas = new String[0];
		precios = new Float[0];
		cerrado = false;

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean agregaPiezas(String pieza, float precio) {
		if (!cerrado && pieza != null && pieza.trim().length() > 0 && precio >= 0.0) {
			piezas = p.inserta(piezas, pieza);
			precios = f.inserta(precios, precio);
			return true;
		}
		return false;
	}

	public void cierra() {
		cerrado = true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd - MMMMM - yyyy");
		return "Reparacion [numero=" + numero + ", descripcion=" + descripcion + ", piezas=" + Arrays.toString(piezas)
				+ ", precios=" + Arrays.toString(precios) + ", coche=" + coche + ", fecha=" + sdf.format(fecha.getTime()) + ", cerrado="
				+ cerrado + "]";
	}
	
	public String listado() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd - MMMMM - yyyy");
		String texto = "";
		for (int i = 0; i < piezas.length; i++) {
			texto = texto  + "\n" + piezas[i] + " precio " + precios[i];
		}
		return "Reparacion n�mero=" + numero + ", descripci�n=" + descripcion  + ", fecha= " + sdf.format(fecha.getTime()) + (cerrado?", cerrada":", abierta")
				+ "\ncoche: " + coche.toString()  + texto;
	}

	public Vehiculo getCoche() {
		return coche;
	}

	public void setCoche(Vehiculo coche) {
		this.coche = coche;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public static int getNumSiguiente() {
		return numSiguiente;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reparacion)) {
			return false;
		}
		Reparacion other = (Reparacion) obj;
		if (coche == null) {
			if (other.coche != null) {
				return false;
			}
		} else if (!coche.equals(other.coche)) {
			return false;
		}
		if (fecha == null) {
			if (other.fecha != null) {
				return false;
			}
		} else if (!fecha.equals(other.fecha)) {
			return false;
		}
		return true;
	}

}
