package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import view.panel.ClockMessage;
import view.panel.ImgClock;
import view.panel.LoginAgain;
import view.panel.PanImgload;
import view.panel.Seat;
import view.panel.ShowTotalBill;
import view.panel.Stock;
import view.panel.StockManage;
 

public class ManageFrame extends JFrame{
	
	private JLayeredPane layeredPane = new JLayeredPane();	
	private Seat seat, seat2, seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10,seat11,seat12;
	private ArrayList<Seat> seatList = new ArrayList<Seat>();
	
	public ManageFrame(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1366,720);
		this.setTitle("ManageView");
	
		//내윈도우 화면 중앙
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		layeredPane.setBounds(0,0,1366,720);
		layeredPane.setLayout(null);		
		
		//배경
		JPanel myPanel = new PanImgload("img/ManageFrame.png");
		setPanel(myPanel).setBounds(0, -30, 1366, 720);
		
		//시계
		ImgClock imgClock = new ImgClock();
		setPanel(imgClock).setBounds(4,-18,150,150);
		
		//시계 글씨
		ClockMessage clockMessage = new ClockMessage();
		setPanel(clockMessage).setBounds(55,34,100,100);
		new Thread(clockMessage).start();
		
		//메뉴
		ShowTotalBill showBill = new ShowTotalBill("img/TotalBill.png");
		showBill.appear();
		
		LoginAgain showAgain = new LoginAgain();
		showAgain.appear();
		
		Stock stock = new Stock();
		stock.appear();
		
		StockManage stockManage = new StockManage();
		stockManage.appear();
		//좌석
		seat = new Seat("img/seat/SeatOff_1.png");
		seat.MakeSeat(seat, 155, 100, 1);
		seatList.add(seat);
		
		seat2 = new Seat("img/seat/SeatOff_2.png");
		seat2.MakeSeat(seat2, 350, 100, 2);
		seatList.add(seat2);
		
		seat3 = new Seat("img/seat/SeatOff_3.png");
		seat3.MakeSeat(seat3, 550, 100, 3);
		seatList.add(seat3);
		
		seat4 = new Seat("img/seat/SeatOff_4.png");
		seat4.MakeSeat(seat4, 750, 100, 4);
		seatList.add(seat4);
		
		seat5 = new Seat("img/seat/SeatOff_5.png");
		seat5.MakeSeat(seat5, 950, 100, 5);
		seatList.add(seat5);
		
		seat6 = new Seat("img/seat/SeatOff_6.png");
		seat6.MakeSeat(seat6, 1150, 100, 6);
		seatList.add(seat6);
		
		seat7 = new Seat("img/seat/SeatOff_7.png");
		seat7.MakeSeat(seat7, 155, 400, 7);
		seatList.add(seat7);
		
		seat8 = new Seat("img/seat/SeatOff_8.png");
		seat8.MakeSeat(seat8, 350, 400, 8);
		seatList.add(seat8);
		
		seat9 = new Seat("img/seat/SeatOff_9.png");
		seat9.MakeSeat(seat9, 550, 400, 9);
		seatList.add(seat9);
		
		seat10 = new Seat("img/seat/SeatOff_10.png");
		seat10.MakeSeat(seat10, 750, 400, 10);
		seatList.add(seat10);
		
		seat11 = new Seat("img/seat/SeatOff_11.png");
		seat11.MakeSeat(seat11, 950, 400, 11);
		seatList.add(seat11);
		
		seat12 = new Seat("img/seat/SeatOff_12.png");
		seat12.MakeSeat(seat12, 1150, 400, 12);
		seatList.add(seat12);
		
		//최종 삽입		
		for(Seat s : seatList)
			layeredPane.add(s);
		
		layeredPane.add(showBill);
		layeredPane.add(showAgain);
		layeredPane.add(stock);
		layeredPane.add(stockManage);
		add(setJLayered(myPanel, imgClock, clockMessage));
	}
	
	//Setting
	public JPanel setPanel(JPanel panel){
		panel.setLayout(null);
		panel.setOpaque(false);
		return panel;
		
	}
	
	public JLayeredPane setJLayered(Component...components){
		int i=0;
		for(Component component : components)
			layeredPane.add(component, new Integer(i++));

		return layeredPane;
	}
	
}
