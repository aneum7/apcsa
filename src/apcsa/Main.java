package apcsa;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Main {
	
	static GraphicsConfiguration gc;
	public static void main(String[] args) {
		JFrame frame= new JFrame(gc);	
		frame.setTitle("connect four");
		frame.setSize(800,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
}
