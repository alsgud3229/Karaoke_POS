package view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.Host;

public class ShowTotalBill extends JButton implements ActionListener{
	
	public ShowTotalBill(String path) {
		super(new ImageIcon(path));
		this.setLayout(null);
		addActionListener(this);
	}
	
	public void appear() {
		setBounds(1366-100-50, 720-100-50, 90, 60); //1366,720
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Icon icon;
		icon = new ImageIcon("img/money.png");
		String price=String.format("%,d", Host.totalBill);
		JOptionPane.showMessageDialog(null, "오늘의 매출 : "+price+"원 ", "오늘의 매출", CENTER, icon);		
	}
	
}
