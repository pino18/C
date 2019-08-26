package gestorAplicacion.users;

import BaseDatos.Data;
import uiMain.MenuDeConsola;


public class AdminUser extends User{//Usuario de tipo Administrador, tendrá opciones las cuales los otros usuarios no pueden desempeñar
	AdminUser(){
		super();
	}
	
	public AdminUser(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);//Añade cada usuario de tipo administrador a la Tabla Hash Users definida en la clase Data
		Data.users.put(username, this);
	}
	
	public static String newAdminUser(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password){//Crea un nuevo usuario con los parametros que se estipulan, los cuales son las credenciales ingresadas en el momento de hacer la creación del usuario administrador, el cual solo puede ser creado por otro admin
		AdminUser user = new AdminUser();
		//Validaciones de cada parametro
		user.setIdentificacion(identificacion);
		user.setFullname(fullname);
		user.setEdad(edad);
		user.setTelefono(telefono);
		user.setSexo(sexo);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		//Menu por defecto al crear un nuevo usuario administrador
		String [] operations = {"1","2","3","4","5","9"};
		MenuDeConsola.newMenu(user, operations);
		Data.users.put(username,user);
		return "Ha sido creado";
	}
}
