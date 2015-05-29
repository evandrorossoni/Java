# Java
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Conversor extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox entrada, saida;
	private JTextField visores[];
	
	public Conversor() {
		setTitle("[Conversor]");
		setSize(250, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();			
		setVisible(true);
	}
	
	private void iniciarComponentes() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		visores = new  JTextField[2];
		for(int i = 0; i < visores.length; i++){
			visores[i] = new JTextField();
			visores[i].setPreferredSize(new Dimension(240,32));		
		}
			
		visores[1].setEditable(false);
		
		String temperaturas[] = {"Celsius", "Fahrenheit", "Kelvin"};
		entrada = new JComboBox(temperaturas);
		saida = new JComboBox(temperaturas);
		
		Container c = new Container();		
		c.setLayout(new GridLayout(3, 2));
		
		JButton converte = new JButton("Converter!");
		converte.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					float a = Float.parseFloat(visores[0].getText());
					int b = entrada.getSelectedIndex();
					int c = saida.getSelectedIndex();					
					if(b == c)
						visores[1].setText(a + "");
					else if(b == 0 && c == 1)
						visores[1].setText((a * 1.8 + 32) + "");
					else if(b == 0 && c == 2)
						visores[1].setText((a + 273.15) + "");
					else if(b == 1 && c == 0)
						visores[1].setText(((a - 32) / 1.8) + "");
					else if(b == 1 && c == 2)
						visores[1].setText(((a - 32) / 1.8 + 273.15) + "");
					else if(b == 2 && c == 0)
						visores[1].setText((a - 273.15) + "");
					else if(b == 2 && c == 1)
						visores[1].setText((a - 273.15 - 32)/1.8 + "");
					visores[0].setForeground(Color.BLACK);
				}
				catch (Exception e) {
					visores[0].setForeground(Color.RED);
				}
			}
		});
		
		c.add(new JLabel("De"));
		c.add(entrada);
		c.add(new JLabel("Para"));
		c.add(saida);		
		
		add(visores[0]);		
		add(c);	
		add(converte);
		add(visores[1]);		
	}
	
	public static void main(String[] args) {
		new Conversor();
	}

}

