package org.example;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionTaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mecanico[] mecanicos = new Mecanico[0];
		Vehiculo[] coches = new Vehiculo[0];
		Cliente[] clientes = new Cliente[0];
		Asigna[] asignados = new Asigna[0];
		Reparacion[] reps = new Reparacion[0];
		Reparacion r1;
		Asigna a1;
		final String[] MENU = { "salir", "alta mec�nico", "alta de clientes", "alta de veh�culos",
				"alta de reparaciones", "a�adir materiales a un reparaci�n", "asignar mec�nico a una reparaci�n",
				"a�adir horas a una reparaci�n", "cierre de reparaciones", "listar costes de una reparaci�n" };
		mecanicos = cargaInicialM(mecanicos);
		clientes = cargaInicialC(clientes);
		coches = cargaInicialV(coches, clientes);
		int opcion = -1;
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				System.out.println("Crea mec�nico");
				mecanicos = creaMecanico(mecanicos);
				System.out.println(Arrays.toString(mecanicos));
				break;
			case 2:
				System.out.println("Crea cliente");
				clientes = creaCliente(clientes);
				System.out.println(Arrays.toString(clientes));
				break;
			case 3:
				System.out.println("Crea veh�culo");
				coches = creaCoche(coches, clientes);
				System.out.println(Arrays.toString(coches));
				break;
			case 4:
				System.out.println("Crea reparaci�n");
				reps = creaReparacion(coches, reps);
				System.out.println(Arrays.toString(reps));
				break;
			case 5:
				System.out.println("Asigna piezas");
				r1 = asignaPiezas(reps);
				System.out.println(r1.toString());
				break;
			case 6:
				System.out.println("Asigna Mec�nico");
				asignados = asignaMecanico(mecanicos, asignados, reps);
				System.out.println(Arrays.toString(asignados));
				break;
			case 7:
				System.out.println("Imputa horas");
				a1 = imputaHoras(asignados);
				System.out.println(a1);
				break;
			case 8:
				System.out.println("Cierre de una reparaci�n");
				r1 = escogeReparacion(reps);
				r1.cierra();
				System.out.println(r1);
				break;
			case 9:
				System.out.println("Listado de costes");
				String texto = imprimeGastos(asignados, reps); 
				System.out.println(texto);
				break;
			}
			opcion = Leer.menu(MENU);
		}
		System.out.println("Fin de programa");
	}

	private static String imprimeGastos(Asigna[] asignados, Reparacion[] reps) {//opci�n 9
		Reparacion r1;
		r1 = escogeReparacion(reps);
		String texto = r1.listado();
		int suma = 0;
		for (Asigna as : asignados) {
			if (as.getReparacion().equals(r1)) {
				suma += as.getHoras();
			}
		}
		texto += "\n horas dedicadas " + suma;
		return texto;
	}

	private static Asigna imputaHoras(Asigna[] asignados) {//opci�n 7
		Asigna a1;
		int horas;
		a1 = escogeAsignado(asignados);
		if (!a1.getReparacion().isCerrado()) {
			horas = Leer.entero("Horas a imputar a la asignaci�n");
			a1.sumaHoras(horas);
		} else {
			System.out.println("La reparaci�n est� cerrada no se pueden imputar horas");
		}
		return a1;
	}

	private static Asigna[] asignaMecanico(Mecanico[] mecanicos, Asigna[] asignados, Reparacion[] reps) {//opci�n 6
		Util<Asigna> a2 = new Util<>();
		Reparacion r1;
		Asigna a1;
		Mecanico m1;
		r1 = escogeReparacion(reps);
		if (!r1.isCerrado()) {
			m1 = escogeMecanico(mecanicos);
			try {
				a1 = new Asigna(r1, m1);
				if (buscaAsigna(asignados, a1)) {
					System.out.println("El mec�nico ya est� asignado a la reparaci�n");
				} else {
					asignados = a2.inserta(asignados, a1);
				}
			} catch (ObjetoErroneo e) {
				System.out.println("No se puede crear la asignaci�n");
			}
		} else {
			System.out.println("La reparaci�n est� cerrada no se pueden asignar mec�nicos");
		}
		return asignados;
	}

	private static Reparacion asignaPiezas(Reparacion[] reps) {//opci�n 5
		Reparacion r1;
		String pieza;
		float precio;
		r1 = escogeReparacion(reps);
		if (!r1.isCerrado()) {
			precio = Leer.real("Precio de la pieza");
			pieza = Leer.cadena("Nombre de la pieza");
			if (r1.agregaPiezas(pieza, precio)) {
				System.out.println("Pieza a�adida a la lista");
			} else {
				System.out.println("No se ha podido a�adir la pieza");
			} 
		} else {
			System.out.println("La reparaci�n est� cerrada no se pueden asignar piezas");
		}
		return r1;
	}

	private static Reparacion[] creaReparacion(Vehiculo[] coches, Reparacion[] reps) {//opci�n 4
		Util<Reparacion> r2 = new Util<>();
		Vehiculo ve1;
		String dia;
		String descripcion;
		Calendar fecha;
		ve1 = escogeVehiculo(coches);
		dia = Leer.cadena("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$",
				"Fecha de incicio de la reparaci�n (dd-mm-aaaa)");
		String[] d = dia.split("[\\/|-]");
		fecha = new GregorianCalendar(Integer.parseInt(d[2]), Integer.parseInt(d[1])-1, Integer.parseInt(d[0]));
		
		descripcion = Leer.cadena("Descripci�n de la aver�a");
		if (!buscaReparacion(reps, ve1, fecha)) {
			try {
				reps = r2.inserta(reps, new Reparacion(descripcion, ve1, fecha));
			} catch (ObjetoErroneo e) {
				System.out.println("Reparaci�n con datos err�neos");
				;
			} 
		} else {
			System.out.println("Ya existe esa reparaci�n");
		}
		return reps;
	}

	private static Mecanico[] creaMecanico(Mecanico[] mecanicos) {//opci�n 3
		Util<Mecanico> m2 = new Util<>();
		String nombre;
		nombre = Leer.cadena("Nombre del mec�nico");
		try {
			mecanicos = m2.inserta(mecanicos, new Mecanico(nombre));
		} catch (ObjetoErroneo e) {
			System.out.println("Error al insertar el mec�nico");
		}
		return mecanicos;
	}

	private static Cliente[] creaCliente(Cliente[] clientes) {//opci�n 2
		Util<Cliente> c2 = new Util<>();
		String nombre;
		String apellidos;
		String dni;
		String telefono;
		nombre = Leer.cadena("Nombre del cliente");
		apellidos = Leer.cadena("Apellidos del cliente");
		dni = Leer.cadena("[0-9XYZxyz][0-9]{7}[A-Za-z]", "Dni del cliente");
		telefono = Leer.cadena("[\\+]?[0-9 ]+", "Telefono del cliente");
		if (!buscaCliente(clientes, dni)) {
			try {
				clientes = c2.inserta(clientes, new Cliente(dni, nombre, apellidos, telefono));
			} catch (ObjetoErroneo e) {
				System.out.println("Error al insertar el cliente");
			}
		} else {
			System.out.println("Cliente repetido");
		}
		return clientes;
	}

	private static Vehiculo[] creaCoche(Vehiculo[] coches, Cliente[] clientes) {//opci�n 1
		Util<Vehiculo> v2 = new Util<>();
		Cliente c1;
		int tipoV;
		int potencia;
		int peso;
		int actividad;
		String marca;
		String modelo;
		String matricula;
		String tipo;
		String combustible;
		tipoV = Leer.entero("1.- Comercial\n2.- Industrial");
		switch (tipoV) {
		case 1:
			System.out.println("Veh�culo Comercial");
			c1 = escogeCliente(clientes);
			matricula = Leer.cadena("Matricula del coche ");
			if (!buscaVehiculo(coches, matricula)) {
				marca = Leer.cadena("Marca del coche ");
				modelo = Leer.cadena("Modelo del coche");
				tipo = Leer.cadena("Tipo de veh�culo");
				combustible = Leer.cadena("Combustible del coche");
				potencia = Leer.entero("Potencia del coche");
				try {
					coches = v2.inserta(coches,
							new Comercial(matricula, marca, modelo, c1, tipo, combustible, potencia));
				} catch (ObjetoErroneo e) {
					System.out.println("El veh�culo no se puedo crear por errores en los datos");
				}
			} else {
				System.out.println("Ya existe un coche con esa matr�cula");
			}
			break;
		case 2:
			System.out.println("Veh�culo Industrial");
			c1 = escogeCliente(clientes);
			matricula = Leer.cadena("Matricula del coche ");
			if (!buscaVehiculo(coches, matricula)) {
				marca = Leer.cadena("Marca del coche ");
				modelo = Leer.cadena("Modelo del coche");
				tipo = Leer.cadena("Tipo de veh�culo");
				actividad = Leer.entero("Actividad a la que se dedica");
				peso = Leer.entero("Peso del veh�culo");
				try {
					coches = v2.inserta(coches, new Industrial(matricula, marca, modelo, c1, tipo, peso, actividad));
				} catch (ObjetoErroneo e) {
					System.out.println("El veh�culo no se puedo crear por errores en los datos");
				}
			} else {
				System.out.println("Ya existe un coche con esa matr�cula");
			}
			break;
		default:
			System.out.println("Tipo de coche incorrecto");
			break;
		}
		return coches;
	}

	//Carga inicial
	public static Cliente[] cargaInicialC(Cliente[] c) {
		Util<Cliente> c2 = new Util<>();
		try {
			c = c2.inserta(c, new Cliente("00000013j", "Pedro", "Mart�nez", "630430342"));
			c = c2.inserta(c, new Cliente("x0000013j", "Mar�a", "G�mez", "659454341"));
			c = c2.inserta(c, new Cliente("00000014z", "Ana", "S�nchez", "677434343"));
			c = c2.inserta(c, new Cliente("x0000014z", "Luis", "P�rez", "636776342"));
		} catch (ObjetoErroneo e) {
			System.out.println("Cliente err�neo");
		}
		return c;
	}

	public static Mecanico[] cargaInicialM(Mecanico[] m) {
		Util<Mecanico> m2 = new Util<>();
		try {
			m = m2.inserta(m, new Mecanico("Antonio L�pez"));
			m = m2.inserta(m, new Mecanico("Marta S�nchez"));
		} catch (ObjetoErroneo e) {
			e.printStackTrace();
		}
		return m;
	}

	public static Vehiculo[] cargaInicialV(Vehiculo[] v, Cliente[] c) {
		Util<Vehiculo> v2 = new Util<>();

		try {
			v = v2.inserta(v, new Comercial("1234 KKG", "VolsWagen", "Polo", c[0], "Coche", "Diesel", 234));
		} catch (ObjetoErroneo e) {
			System.out.println("Coche err�neo");
		}
		return v;
	}
//Fin carga inicial
	//B�squedas
	public static boolean buscaVehiculo(Vehiculo[] v, String v1) {
		for (Vehiculo vehiculo : v) {
			if (vehiculo.getMatricula().equals(v1.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public static boolean buscaCliente(Cliente[] c, String c1) {
		for (Cliente cliente : c) {
			if (cliente.getDni().equals(c1.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public static boolean buscaReparacion(Reparacion[] r, Vehiculo v1, Calendar c) {
		for (Reparacion reparacion : r) {
			if (reparacion.getCoche().equals(v1) && reparacion.getFecha().equals(c)) {
				return true;
			}
		}
		return false;
	}

	public static boolean buscaAsigna(Asigna[] a, Asigna a1) {
		for (Asigna asigna : a) {
			if (asigna.equals(a1)) {
				return true;
			}
		}
		return false;
	}
	//Fin b�squedas
	//Escoger de la colecci�n

	public static Cliente escogeCliente(Cliente[] c) {
		int pos = 0;
		for (Cliente cliente : c) {
			System.out.println(pos + " " + cliente);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > c.length) {
			pos = Leer.entero("Escoge el cliente ");
		}
		return c[pos];
	}

	public static Vehiculo escogeVehiculo(Vehiculo[] v) {
		int pos = 0;
		for (Vehiculo vehi : v) {
			System.out.println(pos + " " + vehi);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > v.length) {
			pos = Leer.entero("Escoge el veh�culo ");
		}
		return v[pos];
	}
	
	public static Reparacion escogeReparacion(Reparacion[] r) {
		int pos = 0;
		for (Reparacion rep : r) {
			System.out.println(pos + " " + rep);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > r.length) {
			pos = Leer.entero("Escoge la reparaci�n ");
		}
		return r[pos];
	}
	
	public static Mecanico escogeMecanico(Mecanico[] m) {
		int pos = 0;
		for (Mecanico mec : m) {
			System.out.println(pos + " " + mec);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > m.length) {
			pos = Leer.entero("Escoge el mec�nico ");
		}
		return m[pos];
	}
	
	public static Asigna escogeAsignado(Asigna[] a) {
		int pos = 0;
		for (Asigna asi : a) {
			System.out.println(pos + " " + asi);
			pos++;
		}
		pos++;
		while (pos < 0 || pos > a.length) {
			pos = Leer.entero("Escoge La asignaci�n ");
		}
		return a[pos];
	}
	

	//Fin escoger
}
