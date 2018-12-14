package view;

import java.awt.Label;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.panel.Seat;
import behavior.Chat;
import behavior.Pay;
import behavior.Service;
import behavior.Snack;
import behavior.XSnack;
public class Listbox extends JFrame implements ListSelectionListener {
	private String[] list = {"채팅", "서비스 주기", "스낵 추가", "스낵 취소", "계산하기"};
	private Vector vec;
	private JList jlist;
	private Seat seat;
	private Chat chat;
	private Thread ChatingThread ;
	private Service service;
	private Snack snack;
	private XSnack xsnack;
	private Pay pay;
	
	public Listbox(Seat seat) {
	this.seat=seat;
	add(new Label("ListBox"));
	this.setBounds(683-150,360-75,0,0);
	this.setTitle(seat.getSeatNum()+"번방 이벤트처리");
	vec = new Vector();
	jlist = new JList();
	for(int i=0; i<list.length;i++)
		vec.addElement(list[i]);
	jlist.setListData(vec);
	
	add(new JScrollPane(jlist),"Center");
	
	jlist.addListSelectionListener(this);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setSize(220,120);
	setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if(!lse.getValueIsAdjusting()){
			String selection = (String) jlist.getSelectedValue();
			if(selection.equals("채팅")){
				chat = new Chat(seat);
				ChatingThread = new Thread(chat);
				ChatingThread.start();
			}
			if(selection.equals("서비스 주기")){
				service = new Service(seat);
			}
			if(selection.equals("스낵 추가")){
				snack = new Snack(seat);
			}
			
			if(selection.equals("스낵 취소")){
				xsnack = new XSnack(seat);
			}
			
			if(selection.equals("계산하기")){
				pay = new Pay(seat);
			}
				
		}
		
	}



}
