package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.ControlOption;

public class PanelInicio extends JPanel{
	
	//Componentes de la ventana
	private JLabel L1;
	private JButton Change;
	private JTextField user;
	private JPasswordField password;
	private JButton iniciar;
	private JButton registrar;
	private JButton valora;
	
	public PanelInicio(){
		
		JPanel PanelPP = new JPanel();
		PanelPP.setLayout(new BorderLayout(5,5));
		JPanel P1 = new JPanel();
		L1 = new JLabel("Bienvenidos a ODONTOSOFT");
		Change = new JButton("Haga click para ver fotos de los autores del sistema");
		Change.addMouseListener(null);
		L1.addMouseListener(new OyenteMouseLabel());
		P1.setLayout(new GridLayout(2,1));
		P1.add(L1);
		P1.add(Change);
		PanelPP.add(P1, BorderLayout.WEST);
		
		JPanel P2 = new JPanel();
		user = new JTextField("admin");
		password = new JPasswordField("12345");
		iniciar = new JButton(InterfazVista.INICIAR);
		iniciar.setActionCommand(InterfazVista.INICIAR);
		//El ActionListener se cambia de null apenas se tenga el actionCommand en el controlador
		iniciar.addActionListener(new ControlOption());
		
		registrar = new JButton(InterfazVista.REGISTRAR);
		registrar.setActionCommand(InterfazVista.REGISTRAR);
		registrar.addActionListener(null);
		
		valora = new JButton(InterfazVista.VALORACION);
		valora.setActionCommand(InterfazVista.VALORACION);
		valora.addActionListener(new ControlOption());
		P2.setLayout(new GridLayout(3,1));
		P2.add(user);
		P2.add(password);
		P2.add(iniciar);
		P2.add(registrar);
		P2.add(valora);
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
			L1.setForeground(Color.BLUE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			L1.setForeground(Color.black);
			
		}

	}
}
