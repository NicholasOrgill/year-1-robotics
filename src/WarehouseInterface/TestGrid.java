package WarehouseInterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class TestGrid extends JPanel{

	public static void main(String[] args)
	{
		JFrame pane = new JFrame("Test");
		pane.setSize(500,500);
		pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GridComponent comp = new GridComponent(5, 5, (double)pane.getWidth(), (double)pane.getHeight());
		
		pane.add(comp);
		
		pane.setVisible(true);
		
	}
}
