package script;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import clojure.lang.RT;
import clojure.lang.Var;

public class Main {
	
	static {
		System.out.println("RT.");
		//RT.init();
		System.out.println("RT inited.");
	}
	public static void main(String[] args) {
			//RT.load("abc");
			try {
				//clojure.lang.Compiler.
				//RT.load("abc.clj");
				RT.loadResourceScript("abc.clj");
				Var x = RT.var("script", "x");
				Var abc = RT.var("script","abc");
				
				System.out.println(x.get());
				
				RT.var("script", "x",Lists.newArrayList("cc","aa","bb"));
				
				Object o = abc.invoke();
				System.out.println(o);
			} catch (IOException /**| ClassNotFoundException**/ e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}

