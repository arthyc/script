package script.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JViewport;

public class Main {

	public static void main(String[] args) {
		System.out.println(System.getProperties());
		JFrame main = new JFrame();
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JRootPane rP = main.getRootPane();
		//rP.setSize();
		JViewport vP = new JViewport();
		vP.setSize(160*6, 90*6);
		main.add(vP);
		//main.pack();
		main.setVisible(true);
		//JRootPane rP = main.getRootPane();

	}

}
