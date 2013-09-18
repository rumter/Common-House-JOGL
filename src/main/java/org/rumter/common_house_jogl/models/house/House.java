package org.rumter.common_house_jogl.models.house;

import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.models.base.SimpleModel;

/**
 * корпус общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class House extends SimpleModel {
	/**
	 * ширина корпуса по оси OX
	 */
	public static final float w = 15.4f;
	/**
	 * длина корпуса по оси OZ
	 */
	public static final float l = 59.4f;

	public House(float x, float y, float z) {
		super(x, y, z);
		mainPart = new MainHousePart(x, y, z);
		houseTop = new HouseTop(x, y, z);
		bottomPart = new BottomHousePart(x, y, z);
	}

	private Model mainPart, houseTop, bottomPart;

	@Override
	public void display() {
		mainPart.display();
		houseTop.display();
		bottomPart.display();
	}
}