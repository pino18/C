package View;

import java.awt.*;
import javax.swing.*;

import Control.ControlPagarRecibo;
import Control.ControlValoracion;

public class PanelPagarRecibo extends JPanel {
	JButton aceptar;
	JButton cancelar;
	JButton pagar;
	public static JTextField Mon;
	public static JTextField NroR;

	public PanelPagarRecibo() {
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(0, 7));
		JPanel P1 = new JPanel();
		P1.add(new JLabel("Pagar Recibo"));
		JPanel P2 = new JPanel();
		P2.add(new JLabel("Permite al usuario cancelar o abonar a un recibo"));
		JPanel P3 = new JPanel();
		P3.setLayout(new GridLayout(1,2,5,0));
		P3.add(new JLabel("Ingrese el numero del recibo"));
		NroR = new JTextField();
		P3.add(NroR);
		JPanel P4 = new JPanel();
		P4.setLayout(new GridLayout(1,2,5,0));
		aceptar = new JButton(InterfazVista.ACEPTAR);
		aceptar.addActionListener(new ControlPagarRecibo());
		cancelar = new JButton(InterfazVista.CANCELAR);
		cancelar.addActionListener(new ControlPagarRecibo());
		P4.add(aceptar);P4.add(cancelar);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.NORTH);
		PP.add(P3, BorderLayout.CENTER);
		PP.add(P4, BorderLayout.SOUTH);
		this.add(PP);
	}
	public PanelPagarRecibo(String ID, int M) {
		Nro = ID;
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(0, 7));
		JPanel P1 = new JPanel();
		P1.add(new JLabel("Pagar Recibo"));
		JPanel P2 = new JPanel();
		P2.add(new JLabel("Permite al usuario cancelar o abonar a un recibo"));
		JPanel P3 = new JPanel();
		P3.setLayout(new GridLayout(2,2,10,10));
		P3.add(new JLabel("El recibo "+Nro+" tiene un valor de "));
		P3.add(new JTextArea(Integer.toString(M)));
		P3.add(new JLabel("Ingrese el monto a pagar"));
		Mon = new JTextField();
		P3.add(Mon);
		JPanel P4 = new JPanel();
		P4.setLayout(new GridLayout(1,2,5,0));
		pagar = new JButton(InterfazVista.PAGAR);
		pagar.addActionListener(new ControlPagarRecibo());
		cancelar = new JButton(InterfazVista.CANCELAR);
		cancelar.addActionListener(new ControlPagarRecibo());
		P4.add(pagar);P4.add(cancelar);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.NORTH);
		PP.add(P3, BorderLayout.CENTER);
		PP.add(P4, BorderLayout.SOUTH);
		this.add(PP);
	}
}
