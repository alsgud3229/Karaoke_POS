package behavior;

import java.io.IOException;

import chatBackground.ClientFrame;
import chatBackground.SFrame;
import view.panel.Seat;

public class Chat implements Runnable {

	private Seat seat;
	
	public Chat(Seat seat) {
		this.seat = seat;
	}
	
	@Override
	public void run() {
		SFrame server = new SFrame();
		new Thread(server).start();
		
		ClientFrame c = new ClientFrame(seat.getSeatNum());
		try {
			c.client();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
