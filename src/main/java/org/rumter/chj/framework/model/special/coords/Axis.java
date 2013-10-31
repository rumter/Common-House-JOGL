package org.rumter.chj.framework.model.special.coords;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.base.Model;

public class Axis implements Model {

	private final float size = 2000f;
	private final float width = 1f;
	private final float yWidth = 1f;
	private final float h = 100;
	private final float arrowSize = 5f;

	private Point x1 = new Point(-size / 2f, h, 0);
	private Point x2 = new Point(size / 2f, h, 0);
	private Point z1 = new Point(0, h, -size / 2f);
	private Point z2 = new Point(0, h, size / 2f);
	private Point y1 = new Point(0, 0, 0);
	private Point y2 = new Point(0, 0, h * 2);

	public Axis() {
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("axis/metal");
		App.drawUtils.drawCylinder(x1, width / 2f, size, 0, 90);
		App.drawUtils.drawCylinder(x2, width / 2f, arrowSize, 0, -45);
		App.drawUtils.drawCylinder(x2, width / 2f, arrowSize, 0, -135);
		App.drawUtils.drawCylinder(z2, width / 2f, size, 0, 180);
		App.drawUtils.drawCylinder(z2, width / 2f, arrowSize, 0, -135);
		App.drawUtils.drawCylinder(z2, width / 2f, arrowSize, 0, 135);
		App.drawUtils.drawCylinder(y1, yWidth / 2f, h * 2, -90, 0);
	}

}
