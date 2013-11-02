package org.rumter.chj.models.StudentCity.house;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.framework.model.base.SimpleModel;

public class CorpSet extends SimpleModel {

	private final int TRACK_COORD_X = 0;
	private final int TRACK_COORD_Z = 1;

	private int nums[] = { 10, 8, 7, 9, 11 };
	private float coords[][] = { { -283, 48 }, { -405, 91 }, { -405, 207 }, { -283, 249 }, { -159, 291 } };

	private List<House> corpList;

	private final float yLevel = 0f;

	public CorpSet(float x, float y, float z) {
		super(x, y, z);
		corpList = new ArrayList<House>();
		for (int i = 0; i < nums.length; ++i) {
			float c[] = coords[i];
			int type = (nums[i] == 8 || nums[i] == 10 ? 1 : 2);
			corpList.add(new House(x + c[TRACK_COORD_X], yLevel, z + c[TRACK_COORD_Z], type));
		}
	}

	@Override
	public void display() {
		for (House h : corpList) {
			h.display();
		}
	}

}
