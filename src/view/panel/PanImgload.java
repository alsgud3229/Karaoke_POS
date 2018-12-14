package view.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanImgload extends JPanel{
	
	private Image image;
	
	public PanImgload(String path){
		image=Toolkit.getDefaultToolkit().createImage(path);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(image, 0, 0, this);
	}	
}