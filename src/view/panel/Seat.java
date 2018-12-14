package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.Listbox;

public class Seat extends JButton implements Runnable{

	private Icon icon;
	private int SeatNum;
	private int posX, posY;
	private JLabel timeLabel, priceLabel, itemLabel;
	private String sectime, mintime, time, strprice;
	private Seat seat;
	public String itemstring = "";
	public String itemstring1 = "";
	public String itemstring2 = "";
	public String itemstring3 = "";
	public String itemstring4 = "";
	public int min, sec, price;
	public Boolean stop = false;
	public OffListener off = new OffListener();
	public OnListener on = new OnListener();
	public Boolean flag = false;
	public int waterCount, cokeCount, beerCount, snackCount;

	
	public Seat(String path) {
		super(new ImageIcon(path));
		this.setLayout(null);			
		
		timeLabel = new JLabel(time);
		timeLabel.setBounds(getPosX()+30, getPosY()-20, 99, 99);
		timeLabel.setForeground(new Color(0, 0, 0));
		timeLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		
		priceLabel = new JLabel(strprice);
		priceLabel.setBounds(getPosX()+30, getPosY(), 99, 99);
		priceLabel.setForeground(new Color(0, 0, 0));
		priceLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		
		itemLabel = new JLabel(itemstring);
		itemLabel.setBounds(getPosX()+30, getPosY()+20, 99, 99);
		itemLabel.setForeground(new Color(0, 0, 0));
		itemLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		
		add(timeLabel);
		add(priceLabel);
		add(itemLabel);
	}
	
	public void MakeSeat(Seat seat, int x, int y, int num) {
		this.seat=seat;
		seat.setBounds(x, y, 99, 99);
		seat.setBorderPainted(false);
		seat.setFocusPainted(false);
		seat.setContentAreaFilled(false);
		seat.setSeatNum(num);
		
		seat.addActionListener(off);
	}
	
	@Override
	public void run() {
			do{
				try {
					Thread.sleep(200);
					sec++;
					if(sec<10){
						sectime="0"+String.valueOf(sec);
					}
					else
						sectime=String.valueOf(sec);
					if(sec==60){
						sec=0;
						min++;
						price+=1000;
					}
					if(min<10){
						mintime="0"+String.valueOf(min);
					}
					else
						mintime=String.valueOf(min);
					if(price<0)
						price=0;
					
					time=mintime+" : "+sectime;
					strprice=String.valueOf(price)+" ¿ø";
					timeLabel.setText(time);
					priceLabel.setText(strprice);
					itemstring = itemstring1+itemstring2+itemstring3+itemstring4;
					itemLabel.setText(itemstring);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}while(stop==false);
			
			if(stop==true){
				sec=0;
				min=0;
				price=0;
				itemstring1="";
				itemstring2="";
				itemstring3="";
				itemstring4="";
				time="";
				strprice="";
				itemstring="";
				timeLabel.setText(time);
				priceLabel.setText(strprice);
				itemLabel.setText(itemstring);
			}
			
}

	public int getSeatNum() {
		return SeatNum;
	}

	public void setSeatNum(int seatNum) {
		SeatNum = seatNum;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	class OffListener implements ActionListener {
		
		private Thread thread,thread2;
		private String path;
		private int count;
		
		public void actionPerformed(ActionEvent e) {
			count++;
			path = "img/seat/SeatOn_"+Integer.toString(seat.getSeatNum())+".png";
			icon = new ImageIcon(path);
			seat.setIcon(icon);
			seat.removeActionListener(off);
			seat.addActionListener(on);
			if(count==1){
				thread=new Thread(seat);
				thread.start();
			}
			if(count>1){
				thread=null;
				thread=new Thread(seat);
				thread.start();
				seat.stop=false;
			}
		}
			
	}
	class OnListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Listbox list = new Listbox(seat);
		}
	}

}
