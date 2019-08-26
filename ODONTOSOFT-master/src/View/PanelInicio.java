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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import Control.ControlOption;
import Control.ControlPanelInicio.ControlMouseLabel;

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
	
	private ImageIcon imagen;
	private Icon icono;
	
	public PanelInicio(){
		
		JPanel PanelPP = new JPanel();
		PanelPP.setLayout(new BorderLayout(40,40));
		JPanel P1 = new JPanel();
		L1 = new JLabel("Bienvenidos a ODONTOSOFT");
		Change = new JButton();
		Change.setBounds(0,0,200,200);
		//Change.addMouseListener(new ControlMouseLabel());
		L1.addMouseListener(new ControlMouseLabel());
		P1.setLayout(new GridLayout(2,1,0,100));
		P1.add(L1);
		imagen = new ImageIcon("tux.png");
		icono = new ImageIcon(imagen.getImage().getScaledInstance(Change.getWidth(), Change.getHeight(),Image.SCALE_DEFAULT));
		Change.setIcon(icono);
		P1.add(Change);
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
		texto = new JTextArea("Hola",10,30);
		iniciar = new JButton(InterfazVista.INICIARADMIN);
		Salir = new JButton("Salir");
		iniciar.setActionCommand(InterfazVista.INICIARADMIN);
		L2 = new JLabel("Ingrese su usuario y contraseña: ");
		L3 = new JLabel("Usuario : ");
		L4 = new JLabel("Contraseña: ");
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
		P3.add(texto);
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
	
}
