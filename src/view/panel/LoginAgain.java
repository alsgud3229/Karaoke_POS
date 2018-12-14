package view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.LoginFrame;
import view.ManageFrame;

public class LoginAgain extends JButton implements ActionListener{
	
	public static ManageFrame manage;
	public static LoginFrame login;
	
	public LoginAgain() {
		super(new ImageIcon("img/LoginAgain.png"));
		this.setLayout(null);
		addActionListener(this);
	}

	public void appear() {
		setBounds(1366-100-200-50, 720-100-50, 90, 60);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		login.setVisible(true);
		manage.setVisible(false);
	}

}
