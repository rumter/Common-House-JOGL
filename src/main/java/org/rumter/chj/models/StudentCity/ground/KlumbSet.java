package org.rumter.chj.models.StudentCity.ground;

import java.util.ArrayList;
import java.util.List;

public class KlumbSet {

	private final int KLUMB_COORD_X = 0;
	private final int KLUMB_COORD_Z = 1;

	private final float KLUMB_Y = 0;

	private List<Klumb> klumbs;

	public KlumbSet(float x, float y, float z) {
		float[][] coords = new float[][] { { -386, 107 }, { -394, 107 }, { -386, 168 }, { -394, 168 }, { -260, 202 },
				{ -268, 202 }, { -260, 64 }, { -268, 64 }, { -122, 253 }, { -130, 253 }};
		klumbs = new ArrayList<Klumb>();
		for (int i = 0; i < coords.length; ++i) {
			float sx = coords[i][KLUMB_COORD_X];
			float sz = coords[i][KLUMB_COORD_Z];
			klumbs.add(new Klumb(sx + x, KLUMB_Y + y, sz + z));
		}
	}

	public List<Klumb> getKlumbs() {
		return klumbs;
	}

}