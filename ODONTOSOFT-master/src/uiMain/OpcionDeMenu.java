package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import BaseDatos.Data;

public abstract class OpcionDeMenu {//Metodo abstracto del cual se derivan todas las opciones de menú que iran en los menús de consola
	
	private String key;
	
	protected OpcionDeMenu() {//Constructor por default
	}
	
	protected OpcionDeMenu(String key){//Le asigna una Key a la opción de menú la cual se usará luego para organizarla dentro del menú de usuario que le corresponde
		this.key = key;
	}
	
	public String getKey() {//Hace un get de la Key de la opción de menú y retorna su valor "String"
		return key;
	}

	public void setKey(String key) {//Permite asignarle una Key a la opción de menú
		this.key = key;
	}

	public abstract void ejecutar ();//Metodo abstracto que se redefine en todas las opciones de menú y en el se describen todas las funcionalidades que y operaciones que realizara la opción de Menú
	
	public abstract String toString ();//Metodo ToString Definido en todas las opciones de Menú, se hace uso para imprimir un mensaje en el menú de consola
	
	public static void seeAllOperations() {//Sirve para listar todas las operaciones definidas que pueden ir en los Menús de usuario
		int i = 1;
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : Data.operations.entrySet()) {
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
	public static void seeAllOperations1() {//Lista de manera Explicita y sin ambigüedades de orden entre las opciones de Menú, usada por la clase Añadir una funcionalidad a un usuario
		System.out.println("Ver funciones de un usuario (1)");
		System.out.println("Añadir funciones a un usuario (2)");
		System.out.println("Quitar funciones a un usuario (3)");
		System.out.println("Añadir nuevo admin(4)");
		System.out.println("crear nuevo empleado(5)");
		System.out.println("Solicitar cita(6)");
		System.out.println("Cancelar cita (7)");
		System.out.println("Pagar recibo (8)");
		System.out.println("Ver activos actuales (9)");
		System.out.println("Consultar Historia Clinica (10)");
		System.out.println("Renunciar (11)");
		System.out.println("Modifica Historia (12)");
		System.out.println("Modificar cita (13)");
	}
	//Retorna un arraylist con todas las opciones de menu exitentes
	public static ArrayList<String> seeAllOperations2() {
		ArrayList<String> A = new ArrayList();
		A.add("Ver funciones de un usuario");
		A.add("Añadir funciones a un usuario ");
		A.add("Quitar funciones a un usuario");
		A.add("Crear nuevo usuario admin");
		A.add("Crear nuevo usuario empleado");
		A.add("Solicitar cita");
		A.add("Cancelar Cita");
		A.add("pagar recibo");
		A.add("Activos Actuales");
		A.add("Historia Clinica");
		A.add("Renunciar");
		A.add("Modificar Historia Clinica");
		A.add("Modificar Cita");
		return A;
	}
}
