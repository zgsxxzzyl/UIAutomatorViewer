package com.android.uiautomator.actions;

import com.android.uiautomator.OpenDialog;
import com.android.uiautomator.UiAutomatorModel;
import com.android.uiautomator.UiAutomatorViewer;
import java.io.File;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

public class OpenFilesAction extends Action {
	private UiAutomatorViewer mViewer;

	public OpenFilesAction(UiAutomatorViewer viewer) {
		super("&Open");

		this.mViewer = viewer;
	}

	public ImageDescriptor getImageDescriptor() {
		return ImageHelper.loadImageDescriptorFromResource("images/open-folder.png");
	}

	public void run() {
		OpenDialog d = new OpenDialog(Display.getDefault().getActiveShell());
		if (d.open() != 0) {
			return;
		}
		UiAutomatorModel model;
		try {
			model = new UiAutomatorModel(d.getXmlDumpFile());
		} catch (Exception e) {
			return;
		}
		Image img = null;
		File screenshot = d.getScreenshotFile();
		if (screenshot != null) {
			try {
				ImageData[] data = new ImageLoader().load(screenshot.getAbsolutePath());
				if (data.length < 1) {
					throw new RuntimeException("Unable to load image: " + screenshot.getAbsolutePath());
				}
				img = new Image(Display.getDefault(), data[0]);
			} catch (Exception e) {
				return;
			}
		}
		this.mViewer.setModel(model, d.getXmlDumpFile(), img);
	}
}