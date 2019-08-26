package View.FieldPanel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class FieldPanel extends JPanel {
	private static final String CENTER = null;
	private String T1;
	private String T2;
	private ArrayList<String> V1;
	private ArrayList<String> V2;
	private ArrayList<Boolean> HAB;
	private Byte NroBotones;
	int i;

	public FieldPanel(String T1, ArrayList<String> V1, String T2, ArrayList<String> V2, ArrayList<Boolean> HAB, Byte NroBotones) {
		JPanel PP = new JPanel();
		PP.setLayout(new GridLayout(V1.size(), 2, 10, 10));
		PP.add(new JLabel(T1));
		PP.add(new JLabel(T2));

		/* Si todos están habilitado para cambios */

		if (HAB == null) {
			if (V2 == null) {
				for (i = 0; i < V1.size(); i++) {
					PP.add(new JLabel(V1.get(i)));
					PP.add(new JTextField());
				}
			} else {
				for (i = 0; i < V1.size(); i++) {
					if (V2.get(i) != null) {
						PP.add(new JLabel(V1.get(i)));
						PP.add(new JTextField(V2.get(i)));
					} else {
						PP.add(new JLabel(V1.get(i)));
						PP.add(new JTextField());
					}
				}
			}
		}
		/* Si no todos están habilitados para cambios */
		else {
			if (V2 == null) {
				for (i = 0; i < V1.size(); i++) {
					if (HAB.get(i) == true) {
						PP.add(new JLabel(V1.get(i)));
						PP.add(new JTextField());
					} else {
						PP.add(new JLabel(V1.get(i)));
						PP.add(new JTextField());// no lo puede cambiar
					}

				}
			} else {
				for (i = 0; i < V1.size(); i++) {
					if (V2.get(i) != null) {
						if (HAB.get(i) == true) {
							PP.add(new JLabel(V1.get(i)));
							PP.add(new JTextField(V2.get(i)));
						} else {
							PP.add(new JLabel(V1.get(i)));
							PP.add(new JTextField(V2.get(i)));// no lo puede cambiar
						}
					}else {
						if (HAB.get(i) == true) {
							PP.add(new JLabel(V1.get(i)));
							PP.add(new JTextField());
						} else {
							PP.add(new JLabel(V1.get(i)));
							PP.add(new JTextField());// no lo puede cambiar
						}
					}
				}
			}
		}
		JPanel P2 = new JPanel();
		P2.setLayout(new BorderLayout());
		if(NroBotones==2) {
			JButton A = new JButton("Aceptar");
			//A.addActionListener(new elcontroladorqueyovayaaponer());
			P2.add(A,BorderLayout.CENTER);
			JButton B = new JButton("Borrar");
			//B.addActionListener(new elcontroladorqueyovayaaponer());
			P2.add(B,BorderLayout.CENTER);
		}
		if(NroBotones == 1) {
			JButton A = new JButton("UNBOTON");
			//A.addActionListener(new elcontroladorqueyovayaaponer());
			P2.add(A,BorderLayout.CENTER);
			
		}
		this.setLayout(new BorderLayout(7,25));
		this.add(PP, BorderLayout.CENTER);
		this.add(P2, BorderLayout.SOUTH);
				
	}
}
