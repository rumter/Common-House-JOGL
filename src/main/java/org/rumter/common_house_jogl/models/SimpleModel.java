package org.rumter.common_house_jogl.models;

import java.util.ArrayList;

import org.rumter.common_house_jogl.utils.Wall;

/**
 * 3D-модель, через которую можно проходить
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public abstract class SimpleModel implements Model {

	public SimpleModel(float x, float y, float z) {
		this.x = x;
		this.z = z;
		this.y = y;
	}

	/**
	 * начальные координаты (левый нижний угол)
	 */
	protected float x, z, y;

	@Override
	public ArrayList<Wall> getWalls() {
		return new ArrayList<Wall>();
	}
}
