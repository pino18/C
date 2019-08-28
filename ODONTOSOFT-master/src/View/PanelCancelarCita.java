package View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import Control.ControlCancelarCita;
import Control.ControlCancelarCitaenviar;
import Control.ControlMenu;
import Control.ControlOption;
import Control.ControlRegistrar;
import Control.ControlRemoveOpt;
import View.FieldPanel.FieldPanel;

import javax.swing.JLabel;


public class PanelCancelarCita extends JPanel{
	JButton volver;
	JButton verificar;
	JComboBox<String> option;
	JLabel title;
	public static JPanel PP;
	public static FieldPanel Field = new FieldPanel();
	public static JPanel PF;
	public static String como; 
	public PanelCancelarCita() {
//se crea una ventana principal en la cual habitaran otras 3 ventanas repartidas en norte,centro y sur
//se hace uso del combobox para desplegar un menu dependiendo de la opcion escogida en este 		
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(new JLabel("Cancelar Cita"),BorderLayout.NORTH);
		PP.add(title, BorderLayout.NORTH);
		
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("Indique Como Cancelará Su Cita: "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Por Fecha");
		option.addItem("Por numero");
		option.addItemListener(new ControlCancelarCita());
		PCENTER.add(option);
		title.add(PCENTER);

		
		
		PF=new JPanel();
		PF.setLayout(new GridLayout(1,2));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		verificar.addActionListener(new ControlRemoveOpt());
		volver.setActionCommand(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		
		
		PP.add(title, BorderLayout.NORTH);
		PP.add(Field,BorderLayout.CENTER);
		PP.add(PF,BorderLayout.SOUTH);
		this.add(PP);
		
		
	}
}
