import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MovieBook extends JFrame{
	private Container c = getContentPane();
	public int movietheaterselect = 0;
	public int moviedataselect = 0;
	public JPanel submovietimePanel = new JPanel();
	
	public MovieBook() {
		setTitle("MovieBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setBackground(new Color(255, 255, 255));
		c.setLayout(new BorderLayout());
		c.add(new MovieSelect());
		
		//setResizable(false);
		setVisible(true);
		setSize(1120, 950);
	}

	public static void main(String[] args) {
		new MovieBook();
	}

}
