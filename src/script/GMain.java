package script;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GMain {

	public static void main(String[] args) {
//		Rectangle virtualBounds = new Rectangle();
//		GraphicsEnvironment ge = GraphicsEnvironment
//				.getLocalGraphicsEnvironment();
//		GraphicsDevice[] gs = ge.getScreenDevices();
//		for (int j = 0; j < gs.length; j++) {
//			GraphicsDevice gd = gs[j];
//			GraphicsConfiguration[] gc = gd.getConfigurations();
//			for (int i = 0; i < gc.length; i++) {
//				System.out.println(gc[i].toString());
//				virtualBounds = virtualBounds.union(gc[i].getBounds());
//				Frame f = new Frame(gc[i]);  // where gc is a GraphicsConfiguration
//			    Rectangle bounds = gc[i].getBounds();
//			    f.setLocation(10 + bounds.x, 10 + bounds.y);
//			    f.setVisible(true);
//			    f.
//			}
//		}
		UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo laf: lafs){
			System.out.println(laf.getClassName());
		}
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**Frame*/
		JFrame main = new JFrame();
		//main.setUndecorated(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(true);
		
		/**Content panel*/
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("EAST"),BorderLayout.EAST);
		
		/**ViewPanel*/
		JPanel viewPanel = new JPanel();
		viewPanel.setPreferredSize(new Dimension(800, 600));
		//viewPanel.setLayout(null);
		//viewPanel.setBackground(Color.red);
		//viewPanel
		
		/**View**/
		//Canvas view = new Canvas();
		Surface view = new Surface();
		//view.setBounds(viewPanel.getBounds());
		view.setPreferredSize(new Dimension(800, 600));
		view.setBackground(Color.BLACK);
		
		
		viewPanel.add(view);
		contentPane.add(viewPanel,BorderLayout.CENTER);
		main.setContentPane(contentPane);
		
		//c.add(view,BorderLayout.CENTER);
		//System.out.println(c.getLayout().getClass().getName());
		
		main.pack();
		main.setVisible(true);
		

	}

}
