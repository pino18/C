package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Data;
import gestorAplicacion.users.User;

public class MenuDeConsola {
	
	private User user;
	private ArrayList<OpcionDeMenu> options = new ArrayList<OpcionDeMenu> ();//ArrayList que guarda las opciones de menú
	
	public MenuDeConsola(ArrayList<OpcionDeMenu> options){
		this.options = options;
	}
	
	public MenuDeConsola(User user, ArrayList<OpcionDeMenu> options){
		this.user = user;
		this.options = options;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public ArrayList<OpcionDeMenu> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<OpcionDeMenu> options) {
		this.options = options;
	}
	
	public String[] getOperations() {//Accede y retorna las opciones de menú que están asignadas a un usuario
		String [] opt = new String[options.size()];
		int i = 0;
		for (OpcionDeMenu opcionDeMenu : options) {
			opt[i] = opcionDeMenu.getKey();
			i++;
		}
		return opt;
	}

	public void lanzarMenu(){//Ejecuta el menú de usuario correspondiente
		Scanner leer = new Scanner(System.in);
		
		System.out.println();
		int i = 1;
		for (OpcionDeMenu option : options) {
			
			System.out.println(i+" "+option);
			i++;
		}
		//Opcion para terminar el programa, hecho con un try catch.
		System.out.println(i+" Terminar programa");
		
		System.out.print("Ingrese la opcion: ");
		int opt = leer.nextInt();
		options.get((opt-1)).ejecutar();
		
	}
	
	public static void newMenu(User user, String [] operations) {//le asigna un menú de consola a un usuario, ademas los guarda en el HashMap, menus de la clase Data
		ArrayList<OpcionDeMenu> operationsMenu = new ArrayList<OpcionDeMenu>();
		for (String opt : operations) {
			operationsMenu.add(Data.operations.get(opt));
		}
		MenuDeConsola menu = new MenuDeConsola(user, operationsMenu);
		user.setMenu(menu);
		Data.menus.put(user.getUsername(), menu);
	}
	
	public void seeOpt() {//Imprime las opciones y les asigna un numero para accederlas en el menú
		int i = 1;
		for (OpcionDeMenu opcionDeMenu : options) {
			System.out.println(i + " "+opcionDeMenu);
			i++;
		}
	}
	
	public void removeOpt(int index) {//Borra una opción
		options.remove(index-1);
	}
	
	public void añadirOpcion(String opt) {//Añade una opción
		options.add(Data.operations.get(opt));
	}
}
