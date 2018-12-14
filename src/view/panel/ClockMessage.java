 package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockMessage extends JPanel implements Runnable{
	
	private int i = Calendar.getInstance().get(Calendar.AM_PM);
	private String[] ampm = {"AM", "PM"};
	private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	private String time = sdf.format(new Date());
	private JLabel timeLabel, ampmLabel;
	
	public ClockMessage() {
		this.setLayout(null);
		
		timeLabel = new JLabel(time);
		timeLabel.setBounds(0,0,100,20);
		timeLabel.setForeground(Color.black);
		timeLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
	
		ampmLabel = new JLabel(ampm[i]);
		ampmLabel.setBounds(15,20,100,30);
		ampmLabel.setForeground(Color.black);
		ampmLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
	
		add(timeLabel);
		add(ampmLabel);
	}

	@Override
	public void run() {
		do{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeLabel.setText(sdf.format(new Date()));
		}while(true);
	}
}