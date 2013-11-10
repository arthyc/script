package script.action;

public class SpellAction implements Action {

	@Override
	public void execute() {
		ActionHandler.INSTANCE.handleSpell();
	}

}
