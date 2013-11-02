package org.rumter.chj.models.StudentCity.house;

import org.rumter.chj.App;
import org.rumter.chj.framework.model.base.Model;
import org.rumter.chj.framework.model.base.SimpleModel;

/**
 * корпус общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class House extends SimpleModel {

	public House(float x, float y, float z, int type) {
		super(x, y, z);
		if (type == 1) {
			mainPart = new MainHousePart(0, 0, 0, 1);
			houseTop = new HouseTop(0, 0, 0);
			bottomPart = new BottomHousePart(0, 0, 0, 1);
		} else {
			mainPart = new MainHousePart(0, 0, 0, 2);
			houseTop = new HouseTop(0, 0, 0);
			bottomPart = new BottomHousePart(HouseSizes.HOUSE_INDENT_L + HouseSizes.BLACK_STAIRS_STEP_L
					+ HouseSizes.BLOCK_STEP_L * 5, 0, 0, 2);
		}
		this.type = type;
	}

	private int type;
	private Model mainPart, houseTop, bottomPart;

	@Override
	public void display() {
		App.gl.glPushMatrix();
		if (type == 1) {
			App.gl.glTranslatef(x, y, z);
		} else {
			App.gl.glTranslatef(x + HouseSizes.HOUSE_L, y, z - HouseSizes.HOUSE_W);
			App.gl.glRotatef(180, 0, 1, 0);
		}
		mainPart.display();
		houseTop.display();
		bottomPart.display();
		App.gl.glPopMatrix();
	}
}