package script.update.jar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class Main {
	public static void main(String... args) throws IOException {
	System.out.println(Locale.CHINA);
	URL url = new URL("");
	HttpURLConnection http = (HttpURLConnection)url.openConnection();
	http.setRequestMethod("POST");
	}
}

