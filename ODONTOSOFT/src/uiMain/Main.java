package uiMain;

import gestorAplicacion.users.User;
import uiMain.operations.AddOpt;
import uiMain.operations.Login;
import uiMain.operations.NewAdmin;
import uiMain.operations.RemoveOpt;
import uiMain.operations.SeeOpt;
import uiMain.operations.SignOut;
import uiMain.operations.SignUp;

import java.util.ArrayList;

import BaseDatos.Data;

public class Main {

	public static User user;
	
	public static MenuDeConsola menuGuestUser;
	
	public static void main(String[] args) {
		Main.startConfigs();
		while(true) {
			
			try {
				if(Main.user != null){
					Main.user.getMenu().lanzarMenu();
				}else {
					Main.menuGuestUser.lanzarMenu();
				}
			
			}
			catch(Exception e){
				//Si ocurre una excepcion al ejecutar el programa, lo terminara.
				
				//Al terminar el programa ejecutara el guardado
				Data.saveData();
				
				System.out.println("Adios en el main");
				System.exit(0);
			}
		}
	}
	
	public static void startConfigs() {
		//Cargar las opciones del programa primero
		
		//Operaciones administrativas
		Data.operations.put("1", new SeeOpt("1"));
		Data.operations.put("2", new AddOpt("2"));
		Data.operations.put("3", new RemoveOpt("3"));
		Data.operations.put("4", new NewAdmin("4"));
		
		//Operaciones de mis usuarios
		Data.operations.put("5", new SignOut("5"));
		
		//Cargar los datos
		Data.loadData();
		
		
		//Usuario invitado o menu invitado(por defecto)
		
		//Operaciones de mi usuario por defecto
		@SuppressWarnings("serial")
		ArrayList<OpcionDeMenu> guestOptions = new ArrayList<OpcionDeMenu>(){
			{
				add(new Login());
				add(new SignUp());
			}
		};
		
		Main.menuGuestUser = new MenuDeConsola(guestOptions);
	}

}
