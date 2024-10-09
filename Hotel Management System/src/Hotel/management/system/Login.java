package Hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	JButton login, cancel;

	Login() {
		setLayout(null);
		
		setBounds(500, 200, 600, 300);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel user = new JLabel("User Name");
		user.setBounds(40, 20, 100, 30);
		add(user);
		
		JTextField userTextField = new JTextField();
		userTextField.setBounds(150, 20, 150, 30);
		add(userTextField);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);
		
		JTextField passTextField = new JTextField();
		passTextField.setBounds(150, 70, 150, 30);
		add(passTextField);
		
		login = new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/second.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(350, 10, 200, 200);
		add(image);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			
		} else if(e.getSource() == cancel) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		new Login();

	}

}
