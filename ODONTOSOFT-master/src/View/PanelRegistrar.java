package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControlOption;
import Control.ControlRegistrar;
import Control.ControlRegistrarOpt;
import View.FieldPanel.FieldPanel;

public class PanelRegistrar extends JPanel {
	
	JLabel title;
	JComboBox<String> option;
	public static JPanel PP;
	public static FieldPanel Field = new FieldPanel();
	JButton registrar;
	JButton volver;
	
	public PanelRegistrar() {
		
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(2,1,5,5));
		title = new JLabel("Registrarse");
		P1.add(title);
		
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("Indique el tipo de usuario:   "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Paciente");
		option.addItem("Acompañante");
		option.addItemListener(new ControlRegistrarOpt());
		PCENTER.add(option);
		
		P1.add(PCENTER);
		
		JPanel buttons = new JPanel();
		registrar = new JButton(InterfazVista.REGISTRAR);
		registrar.addActionListener(new ControlRegistrar());
		volver = new JButton(InterfazVista.VOLVER);
		volver.addActionListener(new ControlOption());
		buttons.add(registrar);
		buttons.add(volver);
		
		PP.add(P1, BorderLayout.NORTH);
		PP.add(Field, BorderLayout.CENTER);
		PP.add(buttons, BorderLayout.SOUTH);
		this.add(PP);
	}
}
