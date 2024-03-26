package org.example;

public class Mecanico {

		private String nombre;
		private int id;
		private static int numSig = 1;
		
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
