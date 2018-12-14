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
	private String[] list = { "물(1000)", "콜라(2000)", "캔맥주(3000)", "새우깡(1500)" };
	private Vector vec;
	private JList jlist;
	private String selection;
	private Seat seat;
	public static int waterLeft = 2, cokeLeft = 2, beerLeft = 2, snackLeft = 2;

	public Snack(Seat seat) {
		this.seat = seat;
		add(new Label("Snack"));// ,1366,720)
		this.setBounds(683 - 150 + 220, 360 - 75, 0, 0);
		this.setTitle(seat.getSeatNum() + "번방 스낵추가");
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
			if (selection.equals("물(1000)")) {
				if (waterLeft == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없습니다.");
				} 
				else {
					seat.waterCount++;
					waterLeft--;
					seat.itemstring1 = "물 " + seat.waterCount;
					seat.price += 1000;
				}
			}
			if (selection.equals("콜라(2000)")) {
				if (cokeLeft == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없습니다.");
				} else {
					seat.cokeCount++;
					cokeLeft--;
					seat.itemstring2 = "콜라 " + seat.cokeCount;
					seat.price += 2000;
				}
			}
			if (selection.equals("캔맥주(3000)")) {
				if (beerLeft == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없습니다.");
				} else {
					seat.beerCount++;
					beerLeft--;
					seat.itemstring3 = "캔맥주 " + seat.beerCount;
					seat.price += 3000;
				}
			}
			if (selection.equals("새우깡(1500)")) {
				if (snackLeft == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없습니다.");
				} else {
					seat.snackCount++;
					snackLeft--;
					seat.itemstring4 = "새우깡 " + seat.snackCount;
					seat.price += 1500;
				}
			}

		}
	}

}
