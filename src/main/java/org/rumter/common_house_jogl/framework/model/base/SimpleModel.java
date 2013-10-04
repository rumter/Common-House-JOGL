package org.rumter.common_house_jogl.framework.model.base;

import java.util.ArrayList;

import org.rumter.common_house_jogl.framework.model.primitives.Wall;

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
	protected ArrayList<Wall> walls;

	public SimpleModel(float x, float y, float z) {
		this.x = x;
		this.z = z;
		this.y = y;
		this.walls = new ArrayList<Wall>();
	}

	@Override
	public ArrayList<Wall> getWalls() {
		return walls;
	}
}
