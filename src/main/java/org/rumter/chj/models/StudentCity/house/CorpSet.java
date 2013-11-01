package org.rumter.chj.models.StudentCity.house;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.framework.model.base.SimpleModel;

public class CorpSet extends SimpleModel {

	private final int TRACK_COORD_X = 0;
	private final int TRACK_COORD_Z = 1;

	private int nums[] = { 10, 8, 7, 9, 11 };
	private float coords[][] = { { -283, 48 }, { -405, 159 }, { -405, 207 }, { -283, 249 }, { -159, 291 } };

	private List<BricksBlock> corpList;

	private House house;

	private final float W = 16;
	private final float L = 101;
	private final float H = 50;

	private final float yLevel = 0f;

	public CorpSet(float x, float y, float z) {
		super(x, y, z);

		corpList = new ArrayList<BricksBlock>();
		for (int i = 0; i < nums.length; ++i) {
			float c[] = coords[i];
			corpList.add(new BricksBlock(x + c[TRACK_COORD_X], yLevel, z + c[TRACK_COORD_Z], W, H, H));
		}

		house = new House(x, y, z);
	}

	@Override
	public void display() {
		// for (BricksBlock b : corpList) {
		// b.display();
		// }
		house.display();
	}

}