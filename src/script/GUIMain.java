package script;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GUIMain {

	public static void main(String[] args) {
		try {
			Desktop.getDesktop().browse(new URI("www.baidu.com"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
