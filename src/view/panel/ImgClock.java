package view.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImgClock extends JPanel{
	
	private Image img;
	
	public ImgClock() {
		img = Toolkit.getDefaultToolkit().createImage("img/Clock.png");
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, this);
	}

}