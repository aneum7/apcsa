package apcsa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CustomPaintComponent extends Component {
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		// here we paint
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 700, 600);
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				
				switch (Board.getSlot(i, j)) {
				case 1:
					g2d.setColor(Color.RED);
					break;
				case 5:
					g2d.setColor(Color.BLUE);
					break;
				default:
					g2d.setColor(Color.black);
				}
				g2d.fillOval(i * 100, j * 100, 100, 100);
			}
		}
	}

}
