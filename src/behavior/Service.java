package behavior;

import view.panel.Seat;

public class Service {
	private Seat seat;

	public Service(Seat seat) {
		this.seat = seat;
		seat.price -= 1000;
	}
}
