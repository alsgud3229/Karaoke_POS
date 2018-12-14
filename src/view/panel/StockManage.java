package view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.ShowSM;

public class StockManage extends JButton implements ActionListener{
	
	public StockManage() {
		super(new ImageIcon("img/StockManage.png"));
		this.setLayout(null);
		addActionListener(this);
	}
	
	public void appear(){
		setBounds(1366-100-400-200-50, 720-100-50, 90, 60);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ShowSM show = new ShowSM();
	}
	
}
