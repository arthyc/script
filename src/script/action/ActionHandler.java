package script.action;

public class ActionHandler {
	private ActionHandler(){};
	public static ActionHandler INSTANCE = new ActionHandler();
	
	public void handleAttack(){
		System.out.println("A");
	}
	
	public void handleSpell(){
		System.out.println("S");
	}
	
	public void handleMove(){
		System.out.println("M");
	}
}
