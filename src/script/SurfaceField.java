package script;

import java.io.Serializable;

public class SurfaceField implements Serializable{
	private static final long serialVersionUID = 1L;

	private final BoundingRectangle boundingBox;

	public SurfaceField(int width, int height) {
		super();
		this.boundingBox = new BoundingRectangle(0, 0, width, height);
	}

	public BoundingRectangle getBoundingBox() {
		return boundingBox;
	}

	public int getWidth() {
		return (int) boundingBox.width;
	}

	public void setWidth(int newWidth) {
		boundingBox.width = newWidth;
	}

	public int getHeight() {
		return (int) boundingBox.height;
	}

	public void setHeight(int newHeight) {
		boundingBox.height = newHeight;
	}
}
