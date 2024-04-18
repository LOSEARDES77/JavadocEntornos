package org.example;

/**
 * Clase Mecánico para la gestión de mecánicos
 */

public class Mecanico {

		private String nombre;
		private int id;
		private static int numSig = 1;

		/**
		 * Tiene checks si el nombre es nulo o está vacio
		 * @param nombre Nombre del mecánico
		 * @throws ObjetoErroneo Si el nombre es nulo o está vacio
		 */
		public Mecanico(String nombre) throws ObjetoErroneo {
			if (!setNombre(nombre)) {
				throw new ObjetoErroneo();
			}
			id = numSig;
			numSig++;
		}

		public String getNombre() {
			return nombre;
		}

		/**
		 * Cambia el nombre del mecánico
		 * @param nombre Nombre del mecánico
		 * @return true si se ha cambiado el nombre, false si no se ha cambiado
		 */
		public boolean setNombre(String nombre) {
			if (!(nombre == null || nombre.trim().length()==0)) {
				this.nombre = nombre;
				return true;
			}
			return false;
		}

		public int getId() {
			return id;
		}

		public static int getNumSig() {
			return numSig;
		}
		
		@Override
		public String toString() {
			return "Mecanico [nombre=" + nombre + ", id=" + id + "]";
		}
		
}
