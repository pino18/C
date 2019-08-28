package View;

import java.awt.*;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControlOption;
import Control.ControlRemoveOpt;
import Control.ControlSolicitarCita;
import View.FieldPanel.FieldPanel;

public class PanelSolicitarCita extends JPanel {
	public static FieldPanel field;
	JButton volver;
	JButton verificar;
	public static JComboBox<String> lugar;
	public static JComboBox<String> consulta;
	
	public PanelSolicitarCita() {
		JPanel PP=new JPanel();
		PP.setLayout(new BorderLayout());
		
		
		JPanel PI=new JPanel();
		PI.add(new JLabel("Solicitar Cita"));
		PP.add(PI,BorderLayout.NORTH);
		
		
		JPanel PM=new JPanel();
		PM.setLayout(new BorderLayout(10,10));
		ArrayList<String>formu = new ArrayList();
		formu.add("Ingrese nuevamente su nombre de usuario: ");
		formu.add("Ingrese la fecha de la cita (DD/MM/AAAA): ");
		formu.add("Ingrese la hora de la cita (hh:00 o hh:30)(24h): ");
		
		PM.add(field=new FieldPanel("Datos", formu, "Rellenar", null, null),BorderLayout.NORTH);
		
		
		JPanel PMM=new JPanel();
		PMM.setLayout(new GridLayout(1,1,10,10));
		PMM.add(new JLabel("Seleccione una de Nuestras Sedes: "));
		lugar= new JComboBox();
		lugar.addItem("---");
		lugar.addItem("Laureles");
		lugar.addItem("Poblado");
		PMM.add(lugar);
		
		PM.add(PMM,BorderLayout.CENTER);
		
		JPanel PMB=new JPanel();
		PMB.setLayout(new GridLayout(1,1,10,10));
		PMM.add(new JLabel("Seleccione el Tipo de Consulta: "));
		consulta= new JComboBox();
		consulta.addItem("---");
		consulta.addItem("General");
		consulta.addItem("Prioritaria");
		PMM.add(consulta);
		
		PM.add(PMB,BorderLayout.SOUTH);
		
		PP.add(PM,BorderLayout.CENTER);
		
		JPanel PF=new JPanel();
		PF.setLayout(new GridLayout(1,1));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		PP.add(PF, BorderLayout.SOUTH);
		
		volver.addActionListener(new ControlOption());
		verificar.addActionListener(new ControlSolicitarCita());
		
		
		this.add(PP);
	}


}