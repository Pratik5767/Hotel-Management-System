package Hotel.management.system;

import javax.swing.JFrame;

public class Checkout extends JFrame {

	Checkout() {
		setLayout(null);
		setBounds(400, 200, 700, 500);
		
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Checkout();
	}

}
