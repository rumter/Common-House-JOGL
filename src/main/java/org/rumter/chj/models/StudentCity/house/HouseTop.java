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

	public HouseTop(float x, float y, float z) {
		super(x, y, z);

		models = new ArrayList<Model>();

		models.add(new Block(x, // x
				y + HouseSizes.TOP_START_H, // y
				z + HouseSizes.BLOCK_SEPARATOR_LW, // z
				HouseSizes.HOUSE_L, // wx
				- HouseSizes.HOUSE_W, // wz
				HouseSizes.TOP_H, // h
				"house/houseTop" // tex
		));
	}

	private ArrayList<Model> models;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
	}
}
