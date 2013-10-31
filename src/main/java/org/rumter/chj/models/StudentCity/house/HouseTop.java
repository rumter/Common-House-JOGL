package org.rumter.chj.models.StudentCity.house;

import java.util.ArrayList;

import org.rumter.chj.framework.model.base.Model;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;

/**
 * крыша общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
class HouseTop extends SimpleModel {

	public static final float height = 3.05f * 10;

	public static final float width = House.l + 5;

	public HouseTop(float x, float y, float z) {
		super(x, y, z);

		models = new ArrayList<Model>();

		models.add(new Block(x, y + height, z + 0.5f, width, -18, 3, "house/houseTop"));
	}

	private ArrayList<Model> models;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
	}
}
