package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import Control.ControlOption;
import Control.ControlPanelInicio.ControlMouseLabel;
import Control.ControlPanelInicio.ControlSalir;
import Control.ControlPanelInicio.ControlChangeButton;

public class PanelInicio extends JPanel{
	
	//Componentes de la ventana
	public static JLabel L1;
	private JLabel L2;
	private JLabel L3;
	private JLabel L4;
	public static JButton Change;
	private JTextField user;
	private JTextArea texto;
	private JPasswordField password;
	private JButton iniciar;
	private JButton iniciar2;
	private JButton Salir;
	private JButton registrar;
	private JScrollPane scroll;
	public static String nombrefoto = "imagen1.png";
	public static ImageIcon imagen;
	public static Icon icono;
	
	
	public PanelInicio(){
		JPanel PanelPP = new JPanel();
		PanelPP.setLayout(new BorderLayout(50,50));
		JPanel P1 = new JPanel();
		L1 = new JLabel("Bienvenidos a ODONTOSOFT");
		Change = new JButton();
		Change.addMouseListener(new ControlChangeButton());
		Change.setBounds(30,150,250,250	);
		imagen = new ImageIcon(nombrefoto);
		icono = new ImageIcon(imagen.getImage().getScaledInstance(Change.getWidth(), Change.getHeight(),Image.SCALE_DEFAULT));
		Change.setIcon(icono);
		L1.addMouseListener(new ControlMouseLabel());
		L1.setHorizontalAlignment(SwingConstants.CENTER);
		P1.setLayout(new BorderLayout(0,20));
		P1.add(L1,BorderLayout.NORTH);
		P1.add(Change,BorderLayout.SOUTH);
		PanelPP.add(P1, BorderLayout.WEST);
		JPanel P2 = new JPanel();
		JPanel P3 = new JPanel();
		JPanel P4 = new JPanel();
		JPanel P5 = new JPanel();
		JPanel P6 = new JPanel();
		JPanel P7 = new JPanel();
		JPanel P8 = new JPanel();
		user = new JTextField("admin");
		password = new JPasswordField("12345");
		texto = new JTextArea("ODONTOSOFT. La finalidad de este sistema de información sería que todas las personas directamente asociadas a la entidad pudieran utilizarla para llevar a cabo los diferentes procesos que se pueden hacer entro de una entidad de este tipo, para que se dejara de lado tanto papeleo por la parte administrativa y de los médicos, y para evitar tanto tiempo que pierden los pacientes a la espera de que otra persona le haga cosas simples como agendar una cita medica o pagar un recibo, que las mismas personas pueden hacer, sin necesidad de intermediarios y más cómodo\n" + 
				"A raíz de esto planteamos la idea de crear dos tipos de perfiles los cuales son los protagonistas de nuestro sistema de información: por un lado, está el perfil médico y por otro el perfil paciente. Cada uno con las operaciones pertinentes, como solicitar una cita por parte de el paciente, o modificar la historia clínica de un paciente por parte de un médico. \n" + 
				"Al ser una entidad del sector salud nos vimos en la necesidad de crear clases que son propias de este sector, como lo son cita, procedimiento, Paciente, entre otras.\n" + 
				"Como este es un ejemplo el cual se puede decir que vivimos día a día fue fácil plantear los atributos y las propias clases del problema, sin embargo, en el camino nos fuimos dando cuenta que teníamos huecos o que algunas cosas sobraban, que en nuestro modelo de entidad no servían.\n" + 
				"Luego de este modelado empezamos a desarrollar la capa lógica, en la cual no se tuvo ningún problema, pues eran cosas similares a lo que anteriormente habíamos programado, y los problemas tenían soluciones simples usando diferentes estructuras de datos.\n" + 
				"El verdadero problema se presento cuando empezamos a trabajar el menú de consola y los diferentes usuarios que íbamos a tener, pues esto era algo con lo que nunca habíamos trabajado, y menos con tener que guardar los archivos para que todo fuera consistente, a la final implementamos los métodos sugeridos por el monitor, y con ayuda de lo programado en la capa lógica y alguna documentación y sacaron las opciones de menú y los usuarios\n" + 
				"El problema más grande dentro de todo el trabajo fue trabajar con los archivos de texto de base de datos, pues en diferentes momentos a lo largo del desarrollo se nos dañaban, aunque a la final supimos sortear todos los obstáculos.\n" + 
				"",10,30);
		texto.setLineWrap(true);
		scroll = new JScrollPane(texto ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		iniciar = new JButton(InterfazVista.INICIARADMIN);
		Salir = new JButton("Salir");
		Salir.addMouseListener(new ControlSalir());
		iniciar.setActionCommand(InterfazVista.INICIARADMIN);
		L2 = new JLabel("Ingrese su usuario y contraseÃ±a: ");
		L3 = new JLabel("Usuario : ");
		L4 = new JLabel("ContraseÃ±a: ");
		//El ActionListener se cambia de null apenas se tenga el actionCommand en el controlador
		iniciar.addActionListener(new ControlOption());
		
		
		
		iniciar2 = new JButton(InterfazVista.INICIARUSER);
		iniciar2.setActionCommand(InterfazVista.INICIARUSER);
		iniciar2.addActionListener(new ControlOption());
		
		registrar = new JButton(InterfazVista.REGISTRAR);
		registrar.setActionCommand(InterfazVista.REGISTRAR);
		registrar.addActionListener(new ControlOption());
		P2.add(P3);
		P2.add(P4);
		P4.add(P5);
		P4.add(P6);
		P4.add(P7);
		P4.add(P8);
		P7.setLayout(new GridLayout(2,2,5,5));
		P5.setLayout(new GridLayout(1,1,4,2));
		P4.setLayout(new GridLayout(4,1,10,10));
		P2.setLayout(new GridLayout(2,1,10,20));
		P3.add(scroll);
		P6.add(L2);
		P7.add(L3);
		P7.add(user);
		P7.add(L4);
		P7.add(password);
		P8.add(Salir);
		P5.add(iniciar);
		P5.add(iniciar2);
		P5.add(registrar);
		
		PanelPP.add(P2, BorderLayout.EAST);
		this.add(PanelPP);
	}
	
	public String getUser() {
		return user.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	public static void CambiarImagen(String nombre){
		Change.setBounds(30,150,250,250);
		imagen = new ImageIcon(nombre);
		icono = new ImageIcon(imagen.getImage().getScaledInstance(Change.getWidth(), Change.getHeight(),Image.SCALE_DEFAULT));
		Change.setIcon(icono);
	}
	
}

