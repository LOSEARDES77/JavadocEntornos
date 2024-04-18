package org.example;

import java.util.Arrays;

/**
 * Documentado por Victor
 */
public class Util<T> {
	T t1;

	/**
	 * Invierte un array de cualquier tipo
	 * @param array Array que se desea invertir
	 */
	public void invertir(T[] array) {
		T t1;
		for (int i = 0; i < array.length / 2; i++) {
			t1 = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = t1;
		}
	}

	/**
	 * Muestra todos los elementos del array
	 * @param array el array a imprimir
	 */
	public void imprime(T[] array) {
		for (T integer : array) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	/**
	 * Inserta un elemento en el array
	 * @param array el array a copiar y insertar otro elemento
	 * @param t2 elemento a insertar
	 * @return Un array mas grande con el valor que se le alla puesto en t2
	 */
	public T[] inserta(T[] array, T t2) {
		if (t2 != null) {
			array = Arrays.copyOf(array, array.length + 1); // Crea un array más grande
			array[array.length - 1] = t2; // Inserta el valor nuevo
		}
		return array;
	}

	/**
	 * Elimina un elemento del array
	 * @param array el array a copiar y eliminar un elemento
	 * @param t2 elemento a eliminar
	 * @return Un array más pequeño con el valor que se le alla quitado en t2
	 */
	public T[] elimina(T[] array, T t2) {
		if (t2 != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(t2)) {
					for (int j = i; j < array.length - 1; j++) {
						array[j] = array[j + 1]; // Desplaza los elementos
					}
					array = Arrays.copyOf(array, array.length - 1); // Crea un array más pequeño
					break;
				}
			}
		}
		return array;
		
		
	}

	/**
	 * Inserta un elemento en el array si no existe
	 * @param array el array a copiar e insertar otro elemento
	 * @param t2 elemento a insertar
	 * @return Un array más grande con el valor que se le alla puesto en t2
	 */
	public T[] insertaNorepetido(T[] array, T t2) {
		if (t2 != null) {
			boolean existe = false;
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(t2)) {
					existe = true;
				}
			}
			if(!existe) {
				array = Arrays.copyOf(array, array.length + 1);
				array[array.length - 1 ] = t2;			
			}
		}
		return array;
	}

	/**
	 * Busca un elemento en el array
	 * @param a el array a buscar
	 * @param texto elemento a buscar
	 * @return true si el elemento esta en el array, false si no esta
	 */
	public T escoge(T[] a, String texto) {
		int pos = 0;
		for (T asi : a) {
			System.out.println(pos + " " + asi);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > a.length) {
			pos = Leer.entero(texto);
		}
		return a[pos];
	}

	/**
	 * Busca un elemento en el array
	 * @param a el array a buscar
	 * @param a1 elemento a buscar
	 * @return true si el elemento esta en el array, false si no esta
	 */
	public boolean busca(T[] a, T a1) {
		for (T asi : a) {
			if (asi.equals(a1)) {
				return true;
			}
		}
		return false;
	}

}
