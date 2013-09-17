package org.rumter.common_house_jogl.models.house;

import java.util.ArrayList;

import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.models.base.SimpleModel;
import org.rumter.common_house_jogl.models.house.windows.FlatCell;
import org.rumter.common_house_jogl.models.primitives.Block;

/**
 * крыша общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
class HouseTop extends SimpleModel {

	public static final float height = FlatCell.h * 10;

	public HouseTop(float x, float y, float z) {
		super(x, y, z);

		models = new ArrayList<Model>();

		models.add(new Block(x, y + height, z + 0.5f, 65, -18, 3, "houseTop"));
	}

	private ArrayList<Model> models;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
	}
}
