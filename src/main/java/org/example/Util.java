package org.example;

import java.util.Arrays;

public class Util<T> {
	T t1;

	public void invertir(T[] array) {
		T t1;
		for (int i = 0; i < array.length / 2; i++) {
			t1 = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = t1;
		}
	}

	public void imprime(T[] array) {
		for (T integer : array) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	public T[] inserta(T[] array, T t2) {
		if (t2 != null) {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = t2;
		}
		return array;
	}

	public T[] elimina(T[] array, T t2) {
		if (t2 != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(t2)) {
					for (int j = i; j < array.length - 1; j++) {
						array[j] = array[j + 1];
					}
					array = Arrays.copyOf(array, array.length - 1);
					break;
				}
			}
		}
		return array;
		
		
	}
	
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
	
	public boolean busca(T[] a, T a1) {
		for (T asi : a) {
			if (asi.equals(a1)) {
				return true;
			}
		}
		return false;
	}

}
