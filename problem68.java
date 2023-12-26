import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import acm.program.GraphicsProgram;

public class problem68 extends GraphicsProgram{
	
	private JTextField textField;
	
	public void init(){
		textField = new JTextField(40);
		add(textField, SOUTH);
		
		textField.addActionListener(this);
	}
	
	public void run(){
		
	}
	
	@override
	public void actionPerformed(ActionEvent e){
		println("here");
	}
}
