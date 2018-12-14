package main;

import view.LoginFrame;

public class Host extends LoginFrame {
	public static int totalBill;
	private static String myid = "201421093";
	private static String mypassword = "0000";

	public static boolean loginTest(String id, String password) {
		boolean flag = false;
		if(myid.equals(id) && mypassword.equals(password))
			flag = true;

		return flag;
	}

}
