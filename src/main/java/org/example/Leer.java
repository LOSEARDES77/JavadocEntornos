package org.example;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Clase para leer datos de teclado
 */
public class Leer {

	/**
	 * Lee un entero
	 * @param texto Texto que se muestra al usuario
	 * @return El entero que ha introducido el usuario
	 */
	public static int entero(String texto) {
		int valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Integer.parseInt(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error de datos");
			} 
		}
	}

	/**
	 * Lee una cadena
	 * @param texto Texto que se muestra al usuario
	 * @return La cadena que ha introducido el usuario
	 */
	public static String cadena(String texto) {
		Scanner teclado = new Scanner(System.in);
		String valor;
		System.out.println(texto);
		valor = teclado.nextLine();
		return valor;
	}

	/**
	 * Lee una cadena con una expresión regular
	 * @param regex Expresión regular
	 * @param texto Texto que se muestra al usuario
	 * @return La cadena que ha introducido el usuario
	 */
	public static String cadena(String regex, String texto) {
		Scanner teclado = new Scanner(System.in);
		String valor;
		System.out.println(texto);
		valor = teclado.nextLine();
		try {
			while (!valor.matches(regex)) {
				System.out.println(texto);
				valor = teclado.nextLine();
			}
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println(regex + " No es una expresi�n regular");
			return null;
		}
		return valor;
	}

	/**
	 * Lee un real
	 * @param texto Texto que se muestra al usuario
	 * @return El real que ha introducido el usuario
	 */
	public static float real(String texto) {
		float valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Float.parseFloat(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error de datos reales");
			} 
		}
		
	}

	/**
	 * Lee un doble
	 * @param texto Texto que se muestra al usuario
	 * @return El doble que ha introducido el usuario
	 */
	public static double doble(String texto) {
		double valor;
		String var;
		while (true) {
			var = cadena(texto);
			try {
				valor = Double.parseDouble(var);
				return valor;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en los datos tecleados");
			} 
		}
	}

	/**
	 * Muestra un menú
	 * @param menu Array con las opciones del menú
	 * @return La opción que ha elegido el usuario
	 */
	public static int menu(String[] menu) {
		int opcion = -1;
		for (int i = 1; i < menu.length; i++) {
			System.out.println(i + ".-" + menu[i]);
		}
		System.out.println("0.-" + menu[0]);
		while (opcion < 0 || opcion >= menu.length) {
			opcion = entero("Elije opci�n");
		}
		return opcion;
	}
}
