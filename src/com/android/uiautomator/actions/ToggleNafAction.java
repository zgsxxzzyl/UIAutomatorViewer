package com.android.uiautomator.actions;

import com.android.uiautomator.UiAutomatorView;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class ToggleNafAction extends Action {
	private UiAutomatorView mView;

	public ToggleNafAction(UiAutomatorView view) {
		super("&Toggle NAF Nodes", 2);
		setChecked(view.shouldShowNafNodes());

		this.mView = view;
	}

	public ImageDescriptor getImageDescriptor() {
		return ImageHelper.loadImageDescriptorFromResource("images/warning.png");
	}

	public void run() {
		this.mView.toggleShowNaf();
		this.mView.redrawScreenshot();
		setChecked(this.mView.shouldShowNafNodes());
	}
}