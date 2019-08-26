package BaseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.documents.Procedimiento;
import gestorAplicacion.documents.Recibo;
import gestorAplicacion.users.Acompaniante;
import gestorAplicacion.users.AdminUser;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Data {
	//Tablas Hash en las cuales se guardan toda la información.
	public static HashMap<String, User> users = new HashMap<String, User>();
	public static HashMap<String, MenuDeConsola> menus = new HashMap<String, MenuDeConsola>();
	public static HashMap<String, OpcionDeMenu> operations = new HashMap<String, OpcionDeMenu>();
	public static HashMap<String, Procedimiento> proced = new HashMap<String, Procedimiento>();
	public static HashMap<String, Recibo> reci = new HashMap<String, Recibo>();
	public static HashMap<String, Cita> citas = new HashMap<String, Cita>();
	public static HashMap<String, Cita> citasByN = new HashMap<String, Cita>();
	public static HashMap<String, HistoriaClinica> historias = new HashMap<String, HistoriaClinica>();
	public static HashMap<Integer, String> valora = new HashMap<Integer, String>();

	
	public static void loadData() {
		createFilesAndDirs();
		String ruta = System.getProperty("user.dir") + "\\src\\temp\\";
		//Metodos que cargan la información de la ruta especificada
		loadUsers(ruta);
		loadAdminUsers(ruta);
		loadPaciUsers(ruta);
		loadAcomUsers(ruta);
		loadEmpleUsers(ruta);
		loadMenus(ruta);
		loadProcedimientos(ruta);
		loadRecibos(ruta);
		loadCitas(ruta);
		loadHistorias(ruta);
		loadValora(ruta);
	}
	//Metodos Load Hacen lectura de los archivos.txt y ponen la información en las tablas Hash
	//Metodos Save hacen escritura de los archivos txt poniendole la información ejecutada en el programa y guardada en las tablas hash
	private static void loadValora(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "valoraciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					valora.put(valora.size()+1,line);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}
	
	private static void loadHistorias(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "historias.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String ID = user[0];
					Paciente P = (Paciente) users.get(user[1]);
					int NCR= Integer.parseInt(user[2]);
					String I = user[3];

					new HistoriaClinica(ID,P,NCR,I);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}
	
	private static void loadCitas(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "citas.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String NroCita = user[0];
					String Fecha = user[1];
					String Hora = user[2];
					String Lugar = user[3];
					Paciente Paciente = (Paciente) users.get(user[4]);
					String TipoConsulta = user[5];
					String Estado = user[6];
					Procedimiento Procedimiento = proced.get(user[7]);
					String Empleado =user[8];

					new Cita(NroCita,Fecha,Hora,Lugar,Paciente,TipoConsulta,Estado,Procedimiento,Empleado);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}
	
	
	private static void loadProcedimientos(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "proced.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String Tipo = user[0];
					int valor = Integer.parseInt(user[1]);
					new Procedimiento(Tipo, valor);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadRecibos(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "recibos.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String ID = user[0];
					String Estado = user[1];
					String PRO = user[2];
					Procedimiento p= proced.get(PRO);
					new Recibo(ID, Estado,p);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadUsers(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "users.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String username = user[0];
					String identificacion = user[1];
					String fullname = user[2];
					String edad = user[3];
					String telefono = user[4];
					String sexo = user[5];
					String email = user[6];
					String password = user[7];
					new User(identificacion, fullname, edad, telefono, sexo, username, email, password);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadPaciUsers(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "paciUsers.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String username = user[0];
					String identificacion = user[1];
					String fullname = user[2];
					String edad = user[3];
					String telefono = user[4];
					String sexo = user[5];
					String email = user[6];
					String password = user[7];
					new Paciente(identificacion, fullname, edad, telefono, sexo, username, email, password);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadAcomUsers(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "acompUsers.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String username = user[0];
					String identificacion = user[1];
					String fullname = user[2];
					String edad = user[3];
					String telefono = user[4];
					String sexo = user[5];
					String email = user[6];
					String password = user[7];
					String usurpa = user[9];
					String parentezco = user[8];
					User.newUser(new Acompaniante(usurpa, parentezco), identificacion, fullname, edad, telefono, sexo,
							username, email, password);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}
	
	private static void loadEmpleUsers(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "empleUsers.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String username = user[0];
					String identificacion = user[1];
					String fullname = user[2];
					String edad = user[3];
					String telefono = user[4];
					String sexo = user[5];
					String email = user[6];
					String password = user[7];
					String contrato = user[8];
					String cargo = user[9];
					int sueldo = Integer.parseInt(user[10]);
					String horario = user[11];
					User.newUser(new Empleado(contrato, cargo, sueldo, horario), identificacion, fullname, edad, telefono, sexo,
							username, email, password);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadAdminUsers(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "adminUsers.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] user = line.split(";");
					String username = user[0];
					String identificacion = user[1];
					String fullname = user[2];
					String edad = user[3];
					String telefono = user[4];
					String sexo = user[5];
					String email = user[6];
					String password = user[7];
					new AdminUser(identificacion, fullname, edad, telefono, sexo, username, email, password);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	private static void loadMenus(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "usersMenus.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] menu = line.split(";");
					User user = User.getUserByUsername(menu[0]);
					// slice de arrays
					String[] operations = Arrays.copyOfRange(menu, 1, menu.length);
					MenuDeConsola.newMenu(user, operations);
				}
			}
			br.close();
		} catch (Exception e) {
			// Error al leer
		}
	}

	public static void saveData() {
		createFilesAndDirs();
		String ruta = System.getProperty("user.dir") + "\\src\\temp\\";
		saveUsers(ruta);
		saveMenus(ruta);
		saveRecibos(ruta);
		saveCitas(ruta);
		saveHistorias(ruta);
		saveValora(ruta);
	}
	
	private static void saveValora(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "valoraciones.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Map.Entry<Integer, String> valoraciones : valora.entrySet()) {
				String line = valoraciones.getValue();
				pw.println(line);
			}
			pw.close();

		} catch (IOException ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}
	
	private static void saveHistorias(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "historias.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Map.Entry<String, HistoriaClinica> HistoriaClinica : historias.entrySet()) {
				HistoriaClinica HObj = HistoriaClinica.getValue();
				String line = HObj.getID() + ";";
				line += HObj.getPaciente().getUsername()+";";
				line += HObj.getNroCitasRealizadas() + ";";
				line += HObj.getInformacion();
				
				pw.println(line);
			}
			pw.close();

		} catch (IOException ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}
	
	
	private static void saveCitas(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "citas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Map.Entry<String, Cita> Cita : citas.entrySet()) {
				Cita CObj = Cita.getValue();
				String line = CObj.getNroCita() + ";";
				line += CObj.getFecha() + ";";
				line += CObj.getHora()+";";
				line += CObj.getLugar()+";";
				line += CObj.getPaciente().getUsername()+";";
				line += CObj.getTipoConsulta()+";";
				line += CObj.getEstado()+";";
				line += CObj.getProcedimiento().getTipo()+";";
				line += CObj.getEmpleado();
				//System.out.print(line);
				pw.println(line);
			}
			pw.close();

		} catch (Exception ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}
	
	private static void saveRecibos(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "recibos.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Map.Entry<String, Recibo> Recibo : reci.entrySet()) {
				Recibo RObj = Recibo.getValue();
				String line = RObj.getID() + ";";
				line += RObj.getEstado() + ";";
				line += RObj.getProcedimiento().getTipo();
				pw.println(line);
			}
			pw.close();

		} catch (IOException ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}
	
	private static void saveUsers(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "users.txt");
			FileWriter fwAdmin = new FileWriter(ruta + "adminUsers.txt");
			FileWriter fwAcom = new FileWriter(ruta + "acompUsers.txt");
			FileWriter fwPa = new FileWriter(ruta + "paciUsers.txt");
			FileWriter fwEm = new FileWriter(ruta + "empleUsers.txt");
			PrintWriter pw = new PrintWriter(fw);
			PrintWriter pwAdmin = new PrintWriter(fwAdmin);
			PrintWriter pwAcom = new PrintWriter(fwAcom);
			PrintWriter pwPa = new PrintWriter(fwPa);
			PrintWriter pwEm = new PrintWriter(fwEm);
			for (Map.Entry<String, User> user : users.entrySet()) {
				User userObj = user.getValue();
				String line = userObj.getUsername() + ";";
				line += userObj.getIdentificacion() + ";";
				line += userObj.getFullname() + ";";
				line += userObj.getEdad() + ";";
				line += userObj.getTelefono() + ";";
				line += userObj.getSexo() + ";";
				line += userObj.getEmail() + ";";
				line += userObj.getPassword();
				if (userObj instanceof AdminUser) {
					pwAdmin.println(line);

				} else if (userObj instanceof Acompaniante) {
					line += ";" + ((Acompaniante) userObj).getParentezco() + ";";
					line += ((Acompaniante) userObj).getPaciente().getUsername();
					pwAcom.println(line);
				} else if (userObj instanceof Empleado) {
					line += ";" + ((Empleado) userObj).getContrato() + ";";
					line += ((Empleado) userObj).getCargo() + ";";
					line += ((Empleado) userObj).getSueldo() + ";";
					line += ((Empleado) userObj).getHorario() + ";";
					pwEm.println(line);
				} else if (userObj instanceof Paciente) {
					pwPa.println(line);
				} else {
					pw.println(line);
				}
			}
			pw.close();
			pwAdmin.close();
			pwAcom.close();
			pwPa.close();
			pwEm.close();

		} catch (IOException ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}

	private static void saveMenus(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "usersMenus.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (Map.Entry<String, MenuDeConsola> menu : menus.entrySet()) {
				MenuDeConsola menuObj = menu.getValue();
				String line = menuObj.getUser().getUsername() + ";";
				for (String opt : menuObj.getOperations()) {
					line += opt + ";";
				}
				// Correccion por el ; extra
				pw.println(line.substring(0, (line.length() - 1)));
			}
			pw.close();

		} catch (IOException ioObj) {
			// Ocurrio algo al guardar en txt los datos
		}
	}

	private static void createFilesAndDirs() {
		try {
			String ruta = System.getProperty("user.dir") + "\\src\\temp\\";
			File directory = new File(ruta);
			if (!directory.exists()) {
				directory.mkdir();
				File usersRegisteredFile = new File(ruta + "users.txt");
				File adminUsersFile = new File(ruta + "adminUsers.txt");
				File acompUsersFile = new File(ruta + "acompUsers.txt");
				File paciUsersFile = new File(ruta + "paciUsers.txt");
				File usersMenus = new File(ruta + "usersMenus.txt");
				usersRegisteredFile.createNewFile();
				adminUsersFile.createNewFile();
				acompUsersFile.createNewFile();
				usersMenus.createNewFile();
				paciUsersFile.createNewFile();
			}
		} catch (IOException e) {
			// Ocurrio algo al crear las carpetas y los archivos
		}
	}
}
