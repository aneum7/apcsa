package apcsa;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Main {
	
	static GraphicsConfiguration gc;
	public static void main(String[] args) {
		JFrame frame= new JFrame(gc);	
		frame.setTitle("connect four");
		frame.setSize(704,626);
		frame.setLocationRelativeTo(null);	// center window spawn
		
		frame.add(new CustomPaintComponent());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
}
