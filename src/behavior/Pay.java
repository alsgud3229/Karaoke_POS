package behavior;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.Host;
//import view.OffListener;
//import view.OnListener;
import view.panel.Seat;

public class Pay {
	private Icon icon;
	private Seat seat;
	private String path;

	public Pay(Seat seat) {
		this.seat = seat;
		Host.totalBill += seat.price;

		seat.stop = true;
		path = "img/seat/SeatOff_" + Integer.toString(seat.getSeatNum()) + ".png";
		icon = new ImageIcon(path);
		seat.setIcon(icon);
		seat.removeActionListener(seat.on);
		seat.addActionListener(seat.off);
	}
}
