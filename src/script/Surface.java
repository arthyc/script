package script;

import static java.lang.Math.min;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;


public class Surface extends Canvas {
	private static final long serialVersionUID = -7955795076036095086L;

	
	// The battle and surfaceField,
	private SurfaceField surfaceField;
	private boolean initialized;
	private double scale = 1.0;
	
	private int numBuffers = 2; // defaults to double buffering

	private RenderingHints renderingHints;
	
	// Fonts and the like
	private Font smallFont;
	private FontMetrics smallFontMetrics;
	
	private BufferStrategy bufferStrategy;
	
	public Surface() {
		surfaceField = new SurfaceField(800, 600);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		//final ITurnSnapshot lastSnapshot = windowManager.getLastSnapshot();
		final Object snapshot = new Object();
		if (snapshot != null) {
			update(snapshot);
		} else {
			paintLogo((Graphics2D) g);
		}
	}

	private void update(Object snapshot) {
		if (!initialized) {
			initialize();
		}

		//if (/**windowManager.isIconified() || **/!isDisplayable() || (getWidth() <= 0) || (getHeight() <= 0)) {
		//	return;
		//}

		if (bufferStrategy != null) {
			try {
				Graphics2D g2 = (Graphics2D) bufferStrategy.getDrawGraphics();

				if (g2 != null) {
					do {
						try {
							g2.setRenderingHints(renderingHints);
							drawSomething(g2);
							//drawBattle(g2, snapshot);
						} finally {
							g2.dispose();
						}
						bufferStrategy.show();
					} while (bufferStrategy.contentsLost());
	
					Toolkit.getDefaultToolkit().sync(); // Update like... now!
				}
			} catch (NullPointerException e) {}
		}
	}

	private void loadDisplayOptions() {
		//renderingHints = props.getRenderingHints();
		//numBuffers = props.getOptionsRenderingNoBuffers();
	}

	private void reinitialize() {
		initialized = false;
		bufferStrategy = null;
	}

	private void initialize() {
		loadDisplayOptions();

		if (bufferStrategy == null) {
			createBufferStrategy(numBuffers);
			bufferStrategy = getBufferStrategy();
		}

		// If we are scaled...
		if (getWidth() < surfaceField.getWidth() || getHeight() < surfaceField.getHeight()) {
			// Use the smaller scale.
			// Actually we don't need this, since
			// the RobocodeFrame keeps our aspect ratio intact.

			scale = min((double) getWidth() / surfaceField.getWidth(), (double) getHeight() / surfaceField.getHeight());
		} else {
			scale = 1;
		}

		// Scale font
		smallFont = new Font("Dialog", Font.PLAIN, (int) (10 / scale));
		smallFontMetrics = bufferStrategy.getDrawGraphics().getFontMetrics();

		// Initialize ground image
//		if (drawGround) {
//			createGroundImage();
//		} else {
//			groundImage = null;
//		}

		initialized = true;
	}
	

	private void paintLogo(Graphics2D g) {
		setBackground(Color.BLACK);
		g.clearRect(0, 0, getWidth(), getHeight());

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.transform(AffineTransform.getTranslateInstance((getWidth() - 320) / 2.0, (getHeight() - 46) / 2.0));
		g.setColor(new Color(0, 0x40, 0));
		

		Font font = new Font("Dialog", Font.BOLD, 14);

		g.setTransform(new AffineTransform());
		g.setFont(font);
		g.setColor(new Color(0, 0x50, 0));
		g.drawString("HHHHHHHHHHHHHHHHHHHH", (float) (getWidth() / 2.0), (float) (getHeight() / 2.0 + 50));
	}
	
	public void drawSomething(Graphics2D g){
		g.setBackground(Color.black);
		g.setColor(Color.white);
		g.drawString("SSSSSSSSSS", 100, 100);
	}
}
