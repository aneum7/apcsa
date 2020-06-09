package apcsa;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CustomPaintComponent extends Component {
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		// here we paint
		
		g2d.drawRect(0, 0, 50, 100);
	}

}
