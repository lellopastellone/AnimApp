package it.unibs.pajc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;

import javax.swing.JPanel;

public class PnlAnimation extends JPanel {
	private int xpos;
	public PnlAnimation() {
		Timer t = new Timer(10, e -> stepNext());
		t.start();
	}
	
	int dx = 10;
	public void stepNext() {
		xpos += dx;
		//xpos = Math.min(xpos + 10, getWidth() - 100);
		
		if(xpos + 100 > getWidth()) dx = -10;
		if(xpos <= 0) dx = 10;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth();
		int h = getHeight();
		
		g2.setColor(Color.RED);
		g2.fillRect(xpos, h/2, 100, 50);
	}
}
