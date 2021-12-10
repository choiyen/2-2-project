package models;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class seatBean {
	private String name;
	private Border border;
	private Color BackColor;
	private Color BorderColor;
	public seatBean(Color color, String name, Color BackColor) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.BackColor = BackColor;
		border =  BorderFactory.createLineBorder(color, 3);
		BorderColor = color;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBorder(Color color) {
		border =  BorderFactory.createLineBorder(color, 3);
		BorderColor = color;
	}
	
	public String getName() {
		return name;
	}
	public Border getBorder() {
		return border;
	}	

	public Color getBorderColor() {
		return BorderColor;
	}	
	public Color getBackColor() {
		return BackColor;
	}
}
