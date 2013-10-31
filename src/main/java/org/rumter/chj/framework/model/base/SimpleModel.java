package org.rumter.chj.framework.model.base;

/**
 * 3D-модель
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public abstract class SimpleModel implements Model {

	/**
	 * начальные координаты (левый нижний угол)
	 */
	protected float x, z, y;

	public SimpleModel(float x, float y, float z) {
		this.x = x;
		this.z = z;
		this.y = y;
	}

}
