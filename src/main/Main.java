package main;

import view.LoginFrame;
import view.ManageFrame;
import view.panel.LoginAgain;

public class Main {

	public LoginFrame frameLogin;
	public static ManageFrame manage;

	public static void main(String[] args) {
		Main main = new Main();
		main = new Main();
		main.frameLogin = new LoginFrame();
		main.frameLogin.setMain(main);
	}

	public void showManageFrame(LoginFrame frameLogin) {
		frameLogin.setVisible(false);
		manage = new ManageFrame();
		LoginAgain.manage = manage;
		LoginAgain.login = frameLogin;
	}

}
