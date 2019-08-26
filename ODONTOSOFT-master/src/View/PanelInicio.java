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

public class PanelInicio extends JPanel{
	
	//Componentes de la ventana
	private JLabel L1;
	private JLabel L2;
	private JLabel L3;
	private JLabel L4;
	private JButton Change;
	private JTextField user;
	private JTextArea texto;
	private JPasswordField password;
	private JButton iniciar;
	private JButton Salir;
	private JButton registrar;
	private JButton valora;
	private ImageIcon imagen;
	private Icon icono;
	
	public PanelInicio(){
		
		JPanel PanelPP = new JPanel();
		PanelPP.setLayout(new BorderLayout(40,40));
		JPanel P1 = new JPanel();
		L1 = new JLabel("Bienvenidos a ODONTOSOFT");
		Change = new JButton();
		Change.setBounds(0,0,200,200);
		Change.addMouseListener(new OyenteMouseLabel());
		L1.addMouseListener(new OyenteMouseLabel());
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
		user = new JTextField("");
		password = new JPasswordField();
		texto = new JTextArea("Hola",10,30);
		iniciar = new JButton(InterfazVista.INICIAR);
		Salir = new JButton("Salir");
		iniciar.setActionCommand(InterfazVista.INICIAR);
		L2 = new JLabel("Ingrese su usuario y contraseña: ");
		L3 = new JLabel("Usuario : ");
		L4 = new JLabel("Contraseña: ");
		//El ActionListener se cambia de null apenas se tenga el actionCommand en el controlador
		iniciar.addActionListener(new ControlOption());
		
		registrar = new JButton(InterfazVista.REGISTRAR);
		registrar.setActionCommand(InterfazVista.REGISTRAR);
		registrar.addActionListener(null);
		
		valora = new JButton(InterfazVista.VALORACION);
		valora.setActionCommand(InterfazVista.VALORACION);
		valora.addActionListener(new ControlOption());
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
		P5.add(registrar);
		P5.add(valora);
		PanelPP.add(P2, BorderLayout.EAST);
		this.add(PanelPP);
	}
	
	public String getUser() {
		return user.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	//Oyente para cambiar el color del label
	class OyenteMouseLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			L1.setForeground(Color.BLUE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			L1.setForeground(Color.black);
			
		}

	}class OyenteFoto implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
