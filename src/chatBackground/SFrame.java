package chatBackground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SFrame extends JFrame implements ActionListener, Runnable{
	private JButton button , bt_input;
	private JTextArea ta;
	private JTextField tf; 
	
	static ServerSocket serverSocket = null;
	static Socket clientSocket =null;
	static PrintWriter out;
	static BufferedReader in;
	static String inputLine, outputLine;
	
	public SFrame(){
		this.setBounds(1066, 420, 350, 260);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("킹스애비뉴 노래방");
		
		//패널1
		JPanel panel = new JPanel();
		ta = new JTextArea(10, 30);
		tf = new JTextField(10);

		bt_input = new JButton("전송");
		bt_input.addActionListener(this);
		
		panel.add(ta);
		panel.add(tf);
		panel.add(bt_input);
		add(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s;
		s="카운터 : "+tf.getText(); 
		if(e.getSource()==bt_input){
			ta.append(s+"\n");
			out.println(s);
			tf.setText("");
		}
	}

	@Override
	public void run() {
		
		try{
			if(serverSocket==null)
				serverSocket = new ServerSocket(5555);
		}catch(IOException e){
			System.exit(1);
		}
		
		clientSocket = null;
		try{
			clientSocket = serverSocket.accept();
		}catch(IOException e){
			System.exit(1);
		}
		
		try {
			out = new PrintWriter(clientSocket.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		outputLine = "";		
		
		try {
			while((inputLine = in.readLine())!=null){
				String s =inputLine+"\n";
				ta.append(s);
				if(outputLine.equals("quit"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

