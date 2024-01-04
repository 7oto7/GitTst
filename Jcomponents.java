import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.program.ConsoleProgram;

public class Jcomponents extends ConsoleProgram{
	private JTextField field;

	public void init(){
		field = new JTextField(20);
//		field.setText("pepi gcem");
		add(field, SOUTH);
		field.addActionListener(this);
		
		JButton button = new JButton("Ps me");
		add(button, SOUTH);
		addActionListeners();
	}
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		println(field.getText());
	}
}
