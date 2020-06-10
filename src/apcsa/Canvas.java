package apcsa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private static Boolean redTurn = true;
	
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
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    while (Board.win == 0) {
	    	frame.repaint();
	    }
	    
	    if (Board.win == 1) JOptionPane.showMessageDialog(frame, "Red wins!");
	    else JOptionPane.showMessageDialog(frame, "Blue wins!");
	    System.exit(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {	// only one that matters
		int i = e.getX() / 100;
		int j = e.getY() / 100;
		
		for (int k = 5; k >= 0; k--) {
			if (Board.getSlot(i, k) == 0) {
				if (redTurn) Board.setSlot(i, k, 1);
				else Board.setSlot(i, k, 5);
				redTurn = !redTurn;
				j = k;
				break;
			}
		}
		
		Board.checkWin(i, j);
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
