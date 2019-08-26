package View;

import java.util.ArrayList;
import BaseDatos.Data;
import gestorAplicacion.users.User;
import uiMain.Main;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.operations.ActivosActuales;
import uiMain.operations.AddOpt;
import uiMain.operations.CancelarCita;
import uiMain.operations.ConsultarHistoria;
import uiMain.operations.Login;
import uiMain.operations.ModificarCita;
import uiMain.operations.ModificarHistoria;
import uiMain.operations.NewAdmin;
import uiMain.operations.NewEmpleado;
import uiMain.operations.PagarRecibo;
import uiMain.operations.RemoveOpt;
import uiMain.operations.Renunciar;
import uiMain.operations.SeeOpt;
import uiMain.operations.SignOut;
import uiMain.operations.SignUp;
import uiMain.operations.SolicitarCita;
import uiMain.operations.Valoracion;

public class VentanaText implements InterfazVista {
	public static MenuDeConsola menuGuestUser;
	
	@Override
	public void arranca() {
		while(true) {
			try {
				if(User.currentUser != null){
					User.currentUser.getMenu().lanzarMenu();
				}else {
					menuGuestUser.lanzarMenu();
				}
			
			}
			catch(Exception e){
				//Si ocurre una excepcion al ejecutar el programa, lo terminara.
				
				//Al terminar el programa ejecutara el guardado
				Data.saveData();
				
				System.out.println("Adios en el main.");
				System.exit(0);
			}
		}
	}
	
	public VentanaText() {
		startConfigs();
	}
	
	public void startConfigs() {//Asignación de las Keys de los menús de usuario, ademas los ingresa a la tabla hash operations que se encuentra en la clase Data
		//Cargar las opciones del programa primero
		
		//Operaciones administrativas
		Data.operations.put("1", new SeeOpt("1"));
		Data.operations.put("2", new AddOpt("2"));
		Data.operations.put("3", new RemoveOpt("3"));
		Data.operations.put("4", new NewAdmin("4"));
		Data.operations.put("5", new NewEmpleado("5"));
		
		//Operaciones de mis usuarios
		
		Data.operations.put("6", new SolicitarCita("6"));
		Data.operations.put("7", new CancelarCita("7"));
		Data.operations.put("8", new PagarRecibo("8"));
		Data.operations.put("9", new ActivosActuales("9"));
		Data.operations.put("10", new ConsultarHistoria("10"));
		Data.operations.put("11", new Renunciar("11"));
		Data.operations.put("12", new SignOut("12"));
		Data.operations.put("13", new ModificarHistoria("13"));
		Data.operations.put("14", new ModificarCita("14"));
		
		//Carga datos
		
		Data.loadData();
		
		//Usuario invitado o menu invitado(por defecto)
		
		//Operaciones de mi usuario por defecto
		@SuppressWarnings("serial")
		ArrayList<OpcionDeMenu> guestOptions = new ArrayList<OpcionDeMenu>(){//Opciones por defecto de un usuario invitado
			{
				add(new Login());
				add(new SignUp());
				add(new Valoracion());
			}
		};
		
		menuGuestUser = new MenuDeConsola(guestOptions);
	}

	
}
