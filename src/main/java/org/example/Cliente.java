package org.example;
/*
 * La clase Cliente se encarga de gestionar los datos de los clientes.
*/
public class Cliente {
	/**
	 * Clase Cliente
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @throws ObjetoErroneo
	 */
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private int numCliente;
	private static int numSiguiente = 1;

	public Cliente(String dni, String nombre, String apellidos, String telefono) throws ObjetoErroneo {
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		if (isNull()) {
			throw new ObjetoErroneo();
		}
		this.telefono = telefono;
		numCliente = numSiguiente;
		numSiguiente++;
	}

	public String getDni() {
		return dni;
	}

	public boolean setDni(String dni) {
		final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";// Letras ordenadas de la �ltima posici�n del dni
		final String NUMEROS = "0123456789", NUMEROS2 = "XYZ0123456789";// N�meros
		int n = 0;// N�mero convertido a partir del n�mero en String
		String numero = "";// Para tratar la parte num�rica
		if (dni == null || dni.length() != 9) {// comprueba la longitud del dni
			return false;
		}
		dni = dni.toUpperCase();
		if (!NUMEROS2.contains(dni.substring(0, 1))) {// compruebo el primer car�cter
			return false;
		}
		for (int i = 1; i < dni.length() - 1; i++) {
			if (!NUMEROS.contains(dni.substring(i, i + 1))) {// En cada car�cter compruebo si es n�mero
				return false;
			}
		}
		if (!LETRAS.contains(dni.substring(8))) {// Compruebo que la �ltima posici�n es una de las letras posibles
			return false;
		}
		if (NUMEROS.contains(dni.substring(0, 1))) {// Creo el n�mero para hacer la validaci�n de la letra
			numero = dni.substring(0, 8);// Esto para el dni
		} else {// Esto para el NIE
			switch (dni.substring(0, 1)) {// asigno primera posici�n nu�rica en funci�n de XYZ
			case "X":
				numero = dni.substring(1, 8);
				break;
			case "Y":
				numero = "1" + dni.substring(1, 8);
				break;
			case "Z":
				numero = "2" + dni.substring(1, 8);
				break;
			}
		}
		n = Integer.valueOf(numero);// Convierto el String en int
		if (!LETRAS.substring(n % 23, n % 23 + 1).equals(dni.substring(8))) {// Valido la letra correcta
			return false;
		}
		this.dni = dni;
		return true;// devuelvo el mensaje
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && nombre.trim().length() > 0) {
			this.nombre = nombre;
		}
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos != null && apellidos.trim().length() > 0) {
			this.apellidos = apellidos;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getNumCliente() {
		return numCliente;
	}

	public static int getNumSiguiente() {
		return numSiguiente;
	}

	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", numCliente=" + numCliente;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		return true;
	}

	public boolean isNull() {
		if (dni == null || nombre == null || apellidos == null) {
			return true;
		}
		return false;
	}
}
