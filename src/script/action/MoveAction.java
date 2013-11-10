package script.action;

public class MoveAction implements Action {

	@Override
	public void execute() {
		ActionHandler.INSTANCE.handleMove();
	}

}
