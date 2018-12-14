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

public class Snack extends JFrame implements ListSelectionListener {
	private String[] list = { "��(1000)", "�ݶ�(2000)", "ĵ����(3000)", "�����(1500)" };
	private Vector vec;
	private JList jlist;
	private String selection;
	private Seat seat;
	public static int waterLeft = 2, cokeLeft = 2, beerLeft = 2, snackLeft = 2;

	public Snack(Seat seat) {
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
			if (selection.equals("��(1000)")) {
				if (waterLeft == 0) {
					JOptionPane.showMessageDialog(null, "��� �����ϴ�.");
				} 
				else {
					seat.waterCount++;
					waterLeft--;
					seat.itemstring1 = "�� " + seat.waterCount;
					seat.price += 1000;
				}
			}
			if (selection.equals("�ݶ�(2000)")) {
				if (cokeLeft == 0) {
					JOptionPane.showMessageDialog(null, "��� �����ϴ�.");
				} else {
					seat.cokeCount++;
					cokeLeft--;
					seat.itemstring2 = "�ݶ� " + seat.cokeCount;
					seat.price += 2000;
				}
			}
			if (selection.equals("ĵ����(3000)")) {
				if (beerLeft == 0) {
					JOptionPane.showMessageDialog(null, "��� �����ϴ�.");
				} else {
					seat.beerCount++;
					beerLeft--;
					seat.itemstring3 = "ĵ���� " + seat.beerCount;
					seat.price += 3000;
				}
			}
			if (selection.equals("�����(1500)")) {
				if (snackLeft == 0) {
					JOptionPane.showMessageDialog(null, "��� �����ϴ�.");
				} else {
					seat.snackCount++;
					snackLeft--;
					seat.itemstring4 = "����� " + seat.snackCount;
					seat.price += 1500;
				}
			}

		}
	}

}
