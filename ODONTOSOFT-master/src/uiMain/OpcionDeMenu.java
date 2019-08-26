package uiMain;

import java.util.HashMap;
import java.util.Map;

import BaseDatos.Data;

public abstract class OpcionDeMenu {//Metodo abstracto del cual se derivan todas las opciones de men� que iran en los men�s de consola
	
	private String key;
	
	protected OpcionDeMenu() {//Constructor por default
	}
	
	protected OpcionDeMenu(String key){//Le asigna una Key a la opci�n de men� la cual se usar� luego para organizarla dentro del men� de usuario que le corresponde
		this.key = key;
	}
	
	public String getKey() {//Hace un get de la Key de la opci�n de men� y retorna su valor "String"
		return key;
	}

	public void setKey(String key) {//Permite asignarle una Key a la opci�n de men�
		this.key = key;
	}

	public abstract void ejecutar ();//Metodo abstracto que se redefine en todas las opciones de men� y en el se describen todas las funcionalidades que y operaciones que realizara la opci�n de Men�
	
	public abstract String toString ();//Metodo ToString Definido en todas las opciones de Men�, se hace uso para imprimir un mensaje en el men� de consola
	
	public static void seeAllOperations() {//Sirve para listar todas las operaciones definidas que pueden ir en los Men�s de usuario
		int i = 1;
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : Data.operations.entrySet()) {
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
	public static void seeAllOperations1() {//Lista de manera Explicita y sin ambig�edades de orden entre las opciones de Men�, usada por la clase A�adir una funcionalidad a un usuario
		System.out.println("Ver funciones de un usuario (1)");
		System.out.println("A�adir funciones a un usuario (2)");
		System.out.println("Quitar funciones a un usuario (3)");
		System.out.println("A�adir nuevo admin(4)");
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
}
