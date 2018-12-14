package chatBackground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener {
	private JButton button, but_input;
	private JTextArea ta;
	private JTextField tf;
	private int num;
	static PrintWriter out = null;
	static BufferedReader in = null;

	public ClientFrame(int num) {
		this.num=num;
		this.setBounds(1066, 0, 350, 260);
		setTitle(num+"번방 채팅");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 패널1
		JPanel panel = new JPanel();

		ta = new JTextArea(10, 30);
		tf = new JTextField(10);
		but_input = new JButton("전송");
		but_input.addActionListener(this);

		panel.add(ta);
		panel.add(tf);
		panel.add(but_input);
		add(panel);
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == but_input) {
			String s = num+"번방 : " + tf.getText();
			ta.append(s+"\n");
			out.println(s);
			tf.setText("");
		}
	}

	public void client() throws IOException {
		Socket socket = null;

		try {
			socket = new Socket("localhost", 5555);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

		} catch (UnknownHostException e) {
			System.exit(1);
		} catch (IOException eg) {
			System.exit(1);
		}
		

		String fromServer;
		

		while ((fromServer = in.readLine()) != null) {
			
			String s =fromServer+"\n";
			ta.append(s);
			if (fromServer.equals("quit"))
				break;
		}
		out.close();
		in.close();
		socket.close();
	}

}
