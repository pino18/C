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
	private ArrayList<JTextField> texts = new ArrayList();
	private ArrayList<String> values = new ArrayList();
	JPanel PP;
	int i;
	
	public FieldPanel() {
		
	}
	
	public FieldPanel(String T1, ArrayList<String> V1, String T2, ArrayList<String> V2, ArrayList<Boolean> HAB) {
		PP = new JPanel();
		PP.setLayout(new GridLayout(V1.size()+1, 2, 10, 10));
		PP.add(new JLabel(T1),0);
		PP.add(new JLabel(T2),1);

		/* Si todos están habilitado para cambios */

		if (HAB == null) {
			if (V2 == null) {
				for (i = 0; i < V1.size(); i++) {
					PP.add(new JLabel(V1.get(i)));
					JTextField JTF = new JTextField("");
					PP.add(JTF);
					texts.add(JTF);
				}
			} else {
				for (i = 0; i < V1.size(); i++) {
					if (V2.get(i) != null) {
						PP.add(new JLabel(V1.get(i)));
						JTextField JTF = new JTextField(V2.get(i));
						PP.add(JTF);
						texts.add(JTF);
					} else {
						PP.add(new JLabel(V1.get(i)));
						JTextField JTF = new JTextField("");
						PP.add(JTF);
						texts.add(JTF);
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
						JTextField JTF = new JTextField("");
						PP.add(JTF);
						texts.add(JTF);
					} else {
						PP.add(new JLabel(V1.get(i)));
						JTextField JTF =new JTextField("");
						JTF.setEnabled(false);
						PP.add(JTF);// no lo puede cambiar
						texts.add(JTF);
					}

				}
			} else {
				for (i = 0; i < V1.size(); i++) {
					if (V2.get(i) != null) {
						if (HAB.get(i) == true) {
							PP.add(new JLabel(V1.get(i)));
							JTextField JTF = new JTextField(V2.get(i));
							PP.add(JTF);
							texts.add(JTF);
						} else {
							PP.add(new JLabel(V1.get(i)));
							JTextField JTF =new JTextField(V2.get(i));
							JTF.setEnabled(false);
							PP.add(JTF);// no lo puede cambiar
							texts.add(JTF);
						}
					}else {
						if (HAB.get(i) == true) {
							PP.add(new JLabel(V1.get(i)));
							JTextField JTF = new JTextField("");
							PP.add(JTF);
							texts.add(JTF);
						} else {
							PP.add(new JLabel(V1.get(i)));
							JTextField JTF =new JTextField("");
							JTF.setEnabled(false);
							PP.add(JTF);// no lo puede cambiar
							texts.add(JTF);
						}
					}
				}
			}
		}
		
		this.setLayout(new BorderLayout(7,10));
		this.add(PP, BorderLayout.CENTER);
		
		
	}
	
	public ArrayList<String> getValues() {
			for (JTextField obj: texts) {
				values.add(obj.getText());
			}
		return values;
	}
}
