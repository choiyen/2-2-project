import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ScreenPanel extends Panel {
	String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
	
	public ScreenPanel(boolean[][] select_seat) {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		JLabel l = new JLabel("SCREEN"); // 스크린
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				for (int j = 0; j < 14; j++) {
					for (int i = 0; i < 25; i++) {
						if (select_seat[i][j] == true)
							System.out.println(s[j] + "열 " + i + "번쨰 자리");
					}
				}
			}
		});

		l.setHorizontalAlignment(JLabel.CENTER);
		l.setFont(new Font("Airal", Font.PLAIN, 15));
		l.setBackground(Color.LIGHT_GRAY);
		// layout에 따라 크기 지정이 안되는데 그 점 보완
		l.setPreferredSize(new Dimension(800, 20));
		l.setOpaque(true);
		add(l);

	}
}
