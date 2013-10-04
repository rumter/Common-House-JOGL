package org.rumter.common_house_jogl.framework.model.base;

import java.util.ArrayList;

import org.rumter.common_house_jogl.framework.model.primitives.Wall;

/**
 * 3D-модель
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public interface Model {
	/**
	 * Отрисовка модели
	 */
	public void display();

	/**
	 * Получить список непроходимых стен
	 * 
	 * @return
	 */
	public ArrayList<Wall> getWalls();
}
