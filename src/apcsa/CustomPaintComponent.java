package apcsa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CustomPaintComponent extends Component {
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		// here we paint
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 700, 600);
		g2d.setColor(Color.WHITE);
		
		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < 6; k++) {
				g2d.drawRect(i * 100, k * 100, 100, 100);
			}
		}
	}

}
