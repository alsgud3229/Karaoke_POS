package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Host;
import main.Main;
import view.panel.LoginAgain;

public class LoginFrame extends JFrame implements ActionListener {

	private BufferedImage img = null;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JButton bt;
	private Main main;
	private static int count;
	
	public LoginFrame() {
		setTitle("�α��� �׽�Ʈ");
		setSize(1366,720);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		//�̹��� �޾ƿ���
		try {
			img = ImageIO.read(new File("img/login.png"));
		} catch (IOException e) {
			System.out.println("���� �ҷ����� ����");
			System.exit(0);
		}
		//���̾ƿ� ����
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1366, 720);
		layeredPane.setLayout(null);
		//�г�1
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1366, 720);
		//�α���
		loginTextField = new JTextField(15);
		loginTextField.setBounds(511, 295, 260, 30);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.black);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		layeredPane.add(loginTextField);
		//��й�ȣ
		passwordField = new JPasswordField(15);
		passwordField.setBounds(511, 370, 260, 30);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.black);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		layeredPane.add(passwordField);
		
		//�α��ι�ư �߰�
		bt = new JButton(new ImageIcon("img/LoginBt.png"));
		bt.setBounds(560, 430, 104, 48);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setContentAreaFilled(false);
		bt.addActionListener(this);
		
		layeredPane.add(bt);
		
		//������ �߰���
		layeredPane.add(panel);
		add(layeredPane);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paint(Graphics g){
			 g.drawImage(img, 0, 0, null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = loginTextField.getText();
		char[] password = passwordField.getPassword();
		String pw = new String(password);
		
		if(id.equals("") || pw.equals("")){
			//�޼���
			JOptionPane.showMessageDialog(null, "��ĭ�� ���ԵǾ� �ֽ��ϴ�.");
		}
		else{
			//�α��� ������ �����Ǵ�
			boolean login = Host.loginTest(id, pw);
			if(login){
				count++;
				if(count==1){
					JOptionPane.showMessageDialog(null, "�α��� ����.");
					main.showManageFrame(this);
					loginTextField.setText("");
					passwordField.setText("");
				}
				if(count>=2){
					JOptionPane.showMessageDialog(null, "�α��� ����.");
					Main.manage.setVisible(true);
					LoginAgain.login.setVisible(false);
					loginTextField.setText("");
					passwordField.setText("");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�.");
			}
		}	
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
}
