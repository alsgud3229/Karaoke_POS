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
	private String[] list = { "물 취소", "콜라 취소", "캔맥주 취소", "새우깡 취소" };
	private Vector vec;
	private JList jlist;
	private String selection;
	private Seat seat;

	public XSnack(Seat seat) {
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
			if (selection.equals("물 취소")) {
				if (seat.waterCount == 0) {
					JOptionPane.showMessageDialog(null, "취소할 물이 없습니다.");
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
					seat.itemstring1 = "물 " + seat.waterCount;
					seat.price -= 1000;
				}
			}
			if (selection.equals("콜라 취소")) {
				if (seat.cokeCount == 0) {
					JOptionPane.showMessageDialog(null, "취소할 콜라가 없습니다.");
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
					seat.itemstring2 = "콜라 " + seat.cokeCount;
					seat.price -= 2000;
				}
			}
			if (selection.equals("캔맥주 취소")) {
				if (seat.beerCount == 0) {
					JOptionPane.showMessageDialog(null, "취소할 맥주가 없습니다.");
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
					seat.itemstring3 = "캔맥주 " + seat.beerCount;
					seat.price -= 3000;
				}
			}
			if (selection.equals("새우깡 취소")) {
				if (seat.snackCount == 0) {
					JOptionPane.showMessageDialog(null, "취소할 새우깡이 없습니다.");
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
					seat.itemstring4 = "새우깡 " + seat.snackCount;
					seat.price -= 1500;
				}
			}

		}
	}

}

