package org.rumter.chj.framework.model.base;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;

/**
 * 3D-модель
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public abstract class SimpleModel implements Model, SortableByLook {

	/**
	 * начальные координаты (левый нижний угол)
	 */
	protected float x, z, y;
	protected Point position;

	public SimpleModel(float x, float y, float z) {
		this.x = x;
		this.z = z;
		this.y = y;
		this.position = new Point(x, y, z);
	}

	@Override
	public float getQDistanceToLook() {
		Point pos = App.motionManager.getPosition();
		Point v = pos.sub(position);
		return v.x * v.x + v.y * v.y + v.z * v.z;
	}

}
