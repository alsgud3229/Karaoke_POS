package view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.StockTable;

public class Stock extends JButton implements ActionListener{

	public Stock() {
		super(new ImageIcon("img/Stock.png"));
		this.setLayout(null);
		addActionListener(this);
	}
	
	public void appear() {
		setBounds(1366-100-400-50, 720-100-50, 90, 60);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		StockTable table = new StockTable();
	}

}
