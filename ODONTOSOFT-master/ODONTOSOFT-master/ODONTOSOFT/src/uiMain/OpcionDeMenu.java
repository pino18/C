package uiMain;

import java.util.HashMap;
import java.util.Map;

import BaseDatos.Data;

public abstract class OpcionDeMenu {
	
	private String key;
	
	protected OpcionDeMenu() {
	}
	
	protected OpcionDeMenu(String key){
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public abstract void ejecutar ();
	
	public abstract String toString ();
	
	public static void seeAllOperations() {
		int i = 1;
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : Data.operations.entrySet()) {
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
	public static void seeAllOperations1() {
		System.out.println("Ver funciones de un usuario (1)");
		System.out.println("Añadir funciones a un usuario (2)");
		System.out.println("Quitar funciones a un usuario (3)");
		System.out.println("Añadir nuevo admin(4)");
		System.out.println("crear nuevo empleado(5)");
		System.out.println("Solicitar cita(6)");
		System.out.println("Cancelar cita (7)");
		System.out.println("Pagar recibo (8)");
		System.out.println("Retirar EPS (9)");
		System.out.println("Consultar Historia Clinica (10)");
		System.out.println("Renunciar (11)");
	}
}
