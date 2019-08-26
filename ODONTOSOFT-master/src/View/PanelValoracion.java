package View;

import java.awt.*;
import javax.swing.*;
import Control.ControlOption;
import Control.ControlValoracion;
public class PanelValoracion extends JPanel {

	JButton volver;
	JButton enviar;
	public static JTextArea COM;
	public static JTextField VAL;
	public PanelValoracion() {
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(0, 7));
		JPanel P1 = new JPanel();
		P1.add(new JLabel("Valoración"));
		JPanel P2 = new JPanel();
		P2.add(new JLabel("Permite dar una valoracion al servicio prestado por la entidad al usiario de manera anonima"));
		JPanel P3 = new JPanel();
		P3.setLayout(new BorderLayout(0, 7));
		JPanel P4 = new JPanel();
		P4.setLayout(new GridLayout(4, 1, 0, 5));
		P4.add(new JLabel("Por favor ingrese una valoración del 1 al 5 utiliando el punto para denotar decimales"));
		VAL = new JTextField();
		P4.add(VAL);
		P4.add(new JLabel("Por favor ingrese un comentario"));
		COM = new JTextArea();
		P4.add(COM);
		P3.add(P4, BorderLayout.CENTER);
		JPanel P5 = new JPanel();
		P5.setLayout(new GridLayout(1, 2, 0, 5));
		enviar = new JButton(InterfazVista.ENVIAR);
		enviar.addActionListener(new ControlValoracion());
		volver = new JButton(InterfazVista.VOLVER);
		volver.addActionListener(new ControlOption());
		P5.add(enviar);//FALTA EL CONTROLADOR
		P5.add(volver);
		P3.add(P5, BorderLayout.SOUTH);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
}
