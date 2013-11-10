package script.update;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Starter {
	public static void main(String[] args){
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource(".");
			System.out.println(url.getPath());
			
			StringBuilder commond = new StringBuilder();
			commond.append("java");
			//-classpath part
			commond.append(" -classpath ");
			commond.append(url.getPath());
			commond.append(";");
			commond.append(".");
			//-Dkey=value part
			
			commond.append(" -Dsun.java2d.opengl=True");
			commond.append(" -Dsun.java2d.trace=log");
			
			//assert
			//commond.append(" -esa");
			//main class part
			commond.append(" script.assertcode.Main");
			Process process = Runtime.getRuntime().exec(commond.toString());
			
			int exitValue = process.waitFor();
			//process.
			InputStream in = null;
			if(exitValue==0){
				in = process.getInputStream();
			}else{
				in = process.getErrorStream();
			}
			Scanner scanner = new Scanner(in,System.getProperty("sun.jnu.encoding"));
			while(scanner.hasNextLine()){
				System.out.println(scanner.nextLine());
			}
			in.close();
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}