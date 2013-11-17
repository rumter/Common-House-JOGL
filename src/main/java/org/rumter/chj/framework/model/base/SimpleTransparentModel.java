package org.rumter.chj.framework.model.base;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;

public abstract class SimpleTransparentModel extends SimpleModel implements TransparentModel {

	protected Point position;

	public SimpleTransparentModel(float x, float y, float z) {
		super(x, y, z);
		position = new Point(x, y, z);
	}

	@Override
	public float getQDistanceToLook() {
		Point pos = App.motionManager.getPosition();
		Point v = pos.sub(position);
		return v.x * v.x + v.y * v.y + v.z * v.z;
	}

}
