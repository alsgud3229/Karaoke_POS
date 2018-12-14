package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import behavior.Snack;

public class StockTable extends JFrame{
	
	private JTable table;
	private JScrollPane scroll;
	private String[][] data;
	private String[] title = {"��ǰ", "��� ����"};

	public StockTable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		data = new String[4][2];
		data[0][0] = "��";
		data[0][1] = Integer.toString(Snack.waterLeft);
		data[1][0] = "�ݶ�";
		data[1][1] = Integer.toString(Snack.cokeLeft);
		data[2][0] = "����";
		data[2][1] = Integer.toString(Snack.beerLeft);
		data[3][0] = "�����";
		data[3][1] = Integer.toString(Snack.snackLeft);
		
		table = new JTable(data, title);
		scroll = new JScrollPane(table);
		this.add(scroll);
		this.setBounds(683-150 , 360-50, 300, 130);
		this.setVisible(true);
	}
	
}
