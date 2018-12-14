package behavior;

import java.awt.Label;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.panel.Seat;

public class XSnack extends JFrame implements ListSelectionListener {
	private String[] list = { "�� ���", "�ݶ� ���", "ĵ���� ���", "����� ���" };
	private Vector vec;
	private JList jlist;
	private String selection;
	private Seat seat;

	public XSnack(Seat seat) {
		this.seat = seat;
		add(new Label("Snack"));// ,1366,720)
		this.setBounds(683 - 150 + 220, 360 - 75, 0, 0);
		this.setTitle(seat.getSeatNum() + "���� �����߰�");
		vec = new Vector();
		jlist = new JList();
		for (int i = 0; i < list.length; i++)
			vec.addElement(list[i]);

		jlist.setListData(vec);

		add(new JScrollPane(jlist), "Center");

		jlist.addListSelectionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(220, 120);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (!lse.getValueIsAdjusting()) {
			String selection = (String) jlist.getSelectedValue();
			if (selection.equals("�� ���")) {
				if (seat.waterCount == 0) {
					JOptionPane.showMessageDialog(null, "����� ���� �����ϴ�.");
				} 
				else if(seat.waterCount == 1){
					seat.waterCount--;
					Snack.waterLeft++;
					seat.itemstring1 ="";
					seat.price -= 1000;
				}
				else {
					seat.waterCount--;
					Snack.waterLeft++;
					seat.itemstring1 = "�� " + seat.waterCount;
					seat.price -= 1000;
				}
			}
			if (selection.equals("�ݶ� ���")) {
				if (seat.cokeCount == 0) {
					JOptionPane.showMessageDialog(null, "����� �ݶ� �����ϴ�.");
				} 
				else if(seat.cokeCount == 1){
					seat.cokeCount--;
					Snack.cokeLeft++;
					seat.itemstring2 ="";
					seat.price -= 2000;
				}
				else {
					seat.cokeCount--;
					Snack.cokeLeft++;
					seat.itemstring2 = "�ݶ� " + seat.cokeCount;
					seat.price -= 2000;
				}
			}
			if (selection.equals("ĵ���� ���")) {
				if (seat.beerCount == 0) {
					JOptionPane.showMessageDialog(null, "����� ���ְ� �����ϴ�.");
				} 
				else if(seat.beerCount == 1){
					seat.beerCount--;
					Snack.beerLeft++;
					seat.itemstring3 ="";
					seat.price -= 3000;
				}
				else {
					seat.beerCount--;
					Snack.beerLeft++;
					seat.itemstring3 = "ĵ���� " + seat.beerCount;
					seat.price -= 3000;
				}
			}
			if (selection.equals("����� ���")) {
				if (seat.snackCount == 0) {
					JOptionPane.showMessageDialog(null, "����� ������� �����ϴ�.");
				} 
				else if(seat.snackCount == 1){
					seat.snackCount--;
					Snack.snackLeft++;
					seat.itemstring4 ="";
					seat.price -= 1500;
				}
				else {
					seat.snackCount--;
					Snack.snackLeft++;
					seat.itemstring4 = "����� " + seat.snackCount;
					seat.price -= 1500;
				}
			}

		}
	}

}

