package view;

import java.awt.Label;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import behavior.Chat;
import behavior.Pay;
import behavior.Service;
import behavior.Snack;

public class ShowSM extends JFrame implements ListSelectionListener {
	private String[] list = {"물(10) 입고", "콜라(10) 입고", "맥주(10) 입고", "새우깡(10) 입고"};
	private Vector vec;
	private JList jlist;
	
	public ShowSM() {
		add(new Label("ShowSM"));
		this.setBounds(683-150,360-75,0,0);
		this.setTitle("재고 관리");
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
			if(selection.equals("물(10) 입고")){
				Snack.waterLeft+=10;
			}
			if(selection.equals("콜라(10) 입고")){
				Snack.cokeLeft+=10;
			}
			if(selection.equals("맥주(10) 입고")){
				Snack.beerLeft+=10;
			}
			if(selection.equals("새우깡(10) 입고")){
				Snack.snackLeft+=10;
			}		
		}
	}

}
