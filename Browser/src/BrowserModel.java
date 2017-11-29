import java.util.Stack;

public class BrowserModel {

	private BrowserView view;
	private Stack<Integer> backStack, fwdStack;
	private Integer home;
	private Integer lineNum;

	BrowserModel(BrowserView view) {
		this.view = view;
		home();
	}

	public void back() {
		if (hasBack()) {
			backStack.push(lineNum);
			lineNum = backStack.pop();
			view.update(lineNum);
		}
	}

	public void forward() {
		
	}

	public void home() {
		followLink(0);
		backStack.clear();
	}

	public void followLink(int n) {
		fwdStack.clear();
		backStack.push(lineNum);
		lineNum = n;
		view.update(n);
	}

	public boolean hasBack() {
		return !backStack.isEmpty();
	}

	public boolean hasForward() {
		return !fwdStack.isEmpty();
	}

}
