package org.rumter.chj.framework.model.special.coords;

import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.base.Model;
import org.rumter.chj.framework.model.primitives.Cylinder;

public class Axis implements Model {

	private final float size = 2000f;
	private final float width = 1f;
	private final float yWidth = 1f;
	private final float h = 100;
	private final float arrowSize = 5f;

	private Point x1 = new Point(-size / 2f, h, 0);
	private Point x2 = new Point(size / 2f, h, 0);
	// private Point z1 = new Point(0, h, -size / 2f);
	private Point z2 = new Point(0, h, size / 2f);
	private Point y1 = new Point(0, 0, 0);
	// private Point y2 = new Point(0, 0, h * 2);

	private Cylinder cX = new Cylinder(x1.x, x1.y, x1.z, width / 2f, size, 0, 90);
	private Cylinder cXArr1 = new Cylinder(x2.x, x2.y, x2.z, width / 2f, arrowSize, 0, -45);
	private Cylinder cXArr2 = new Cylinder(x2.x, x2.y, x2.z, width / 2f, arrowSize, 0, -135);
	private Cylinder cZ = new Cylinder(z2.x, z2.y, z2.z, width / 2f, size, 0, 180);
	private Cylinder cZArr1 = new Cylinder(z2.x, z2.y, z2.z, width / 2f, arrowSize, 0, -135);
	private Cylinder cZArr2 = new Cylinder(z2.x, z2.y, z2.z, width / 2f, arrowSize, 0, 135);
	private Cylinder cY = new Cylinder(y1.x, y1.y, y1.z, yWidth / 2f, h * 2, -90, 0);

	public Axis() {
		cX.setSideTexture("axis/metal");
		cXArr1.setSideTexture("axis/metal");
		cXArr2.setSideTexture("axis/metal");
		cZ.setSideTexture("axis/metal");
		cZArr1.setSideTexture("axis/metal");
		cZArr2.setSideTexture("axis/metal");
		cY.setSideTexture("axis/metal");
	}

	@Override
	public void display() {
		cX.display();
		cXArr1.display();
		cXArr2.display();
		cZ.display();
		cZArr1.display();
		cZArr2.display();
		cY.display();
	}

}
