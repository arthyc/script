package script.action;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ActionStub {

	static {
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName() + ": " + e.getMessage());
			}
		};

		Thread.currentThread().setUncaughtExceptionHandler(handler);
	}

	public static void main(String[] args) throws MalformedURLException{
		Map<String, Action> actions = new HashMap<String, Action>();
		actions.put("A", new AttackAction());
		actions.put("M", new MoveAction());
		actions.put("S", new SpellAction());

		Random r = new Random();

		actions.get("A").execute();
		actions.get("M").execute();
		actions.get("S").execute();
		
		//System.out.println(100/0);
		//throw new RuntimeException("abcd eee");
		
		URL url = new URL("abc");

	}

}
