package com.android.uiautomator.actions;

import com.android.uiautomator.UiAutomatorView;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class ExpandAllAction extends Action {
	UiAutomatorView mView;

	public ExpandAllAction(UiAutomatorView view) {
		super("&Expand All");
		this.mView = view;
	}

	public ImageDescriptor getImageDescriptor() {
		return ImageHelper.loadImageDescriptorFromResource("images/expandall.png");
	}

	public void run() {
		this.mView.expandAll();
	}
}