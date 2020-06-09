package apcsa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	public Canvas () {
		addMouseListener(this);
	}

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
	    
	    while (Board.win == 0) {
	    	frame.repaint();
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {	// only one that matters
		System.out.println("(" + e.getX() + ", " + e.getY() + ")");
		Board.setSlot(1, 1, 5);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
