package apcsa;
import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 700, 600);
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				
				switch (Board.getSlot(i, j)) {
				case 1:
					g.setColor(Color.RED);
					break;
				case 5:
					g.setColor(Color.BLUE);
					break;
				default:
					g.setColor(Color.black);
				}
				g.fillOval(i * 100, j * 100, 100, 100);
			}
		}
	}
	
	public static void main (String[] args) {
		Canvas canvas = new Canvas();
		JFrame frame = new JFrame("connect four");
		frame.add(canvas);
		frame.setSize(704, 626);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
