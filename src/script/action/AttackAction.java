package script.action;

public class AttackAction implements Action {

	@Override
	public void execute() {
		ActionHandler.INSTANCE.handleAttack();
	}

}
