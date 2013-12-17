package org.rumter.chj.models.StudentCity.ground;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;

/**
 * Дорожки
 * 
 * @author ilya
 * 
 */
public class TrackSet extends SimpleModel {

	private final int TRACK_COORD_X = 0;
	private final int TRACK_COORD_Z = 1;
	private final int TRACK_COUNT = 26;
	/**
	 * в trackCoords[1] - первая дорожка
	 */
	private final float trackCoords[][][] = { { { 0, 0 }, { 0, 0 } }, { { -70, 29 }, { -293, 101 } },
			{ { -170, 61 }, { -302, 58 } }, { { -165, 119 }, { -204.6f, 118.7f } }, { { -204, 119 }, { -244, 59 } },
			{ { -165, 152 }, { -293, 152 } }, { { -176, 152 }, { -265.4f, 208.5f } }, { { -78, 200 }, { -202, 201 } },
			{ { -38, 256 }, { -293.5f, 170 } }, { { -53, 254 }, { -180.7f, 257 } },
			{ { -53, 250.5f }, { -53, 254.8f } }, { { -38, 255 }, { -38, 356 } }, { { -38, 313 }, { -178.7f, 310 } },
			{ { -180, 257 }, { -178, 310 } }, { { -110, 200 }, { -128, 256 } }, { { -230, 80 }, { -234, 190 } },
			{ { -263, 59 }, { -265, 208 } }, { { -207, 114 }, { -293, 114 } }, { { -239, 114 }, { -264.5f, 152 } },
			{ { -293, 101 }, { -293, 170 } }, { { -292.3f, 101 }, { -419, 101 } }, { { -293, 119 }, { -406, 119 } },
			{ { -327, 151 }, { -410, 151 } }, { { -293, 170 }, { -418, 170 } }, { { -327, 101 }, { -327, 170 } },
			{ { -358, 101 }, { -358, 170 } }, { { -390, 101 }, { -390, 170 } } };

	private final float TRACK_1_WIDTH = 3.0f;
	private final float TRACK_2_WIDTH = 1.5f;
	/**
	 * дорожки могут быть двух типов:<br />
	 * - 1 тип - широкие, с плиткой<br />
	 * - 2 тип - узкие, тротуар<br />
	 */
	private final int track1Indexes[] = { 1, 20, 8, 23 };

	private int getTrackType(int i) {
		for (int j = 0; j < track1Indexes.length; ++j) {
			if (track1Indexes[j] == i) {
				return 1;
			}
		}
		return 0;
	}

	private final float Y_LEVEL1 = 0.1f;
	private final float Y_LEVEL2 = 0.09f;

	private List<Block> trackList;

	public TrackSet(float x, float y, float z) {
		super(x, y, z);

		Point startPoint = new Point(x, y, z);

		trackList = new ArrayList<Block>();

		for (int i = 1; i <= TRACK_COUNT; ++i) {
			float c1[] = trackCoords[i][0];
			float c2[] = trackCoords[i][1];

			int type = getTrackType(i);

			float yLevel = (type == 1 ? Y_LEVEL1 : Y_LEVEL2);

			Point beginCenter = new Point(c1[TRACK_COORD_X], 0, c1[TRACK_COORD_Z]).add(startPoint);
			Point endCenter = new Point(c2[TRACK_COORD_X], 0, c2[TRACK_COORD_Z]).add(startPoint);

			float width = (type == 1 ? TRACK_1_WIDTH : TRACK_2_WIDTH);

			Quad q = new Quad(beginCenter, endCenter.sub(beginCenter), width);

			if (type == 1) {
				q = q.moveZ((float) (Math.random() * 0.1));
			}

			Block block = new Block(q, yLevel);
			block.setSideTexture("ground/track_side");
			if (type == 1) {
				block.setTopTexture("ground/track1", 0.33f, 0.5f);
			} else {
				block.setTopTexture("ground/asphalt_1");
			}
			trackList.add(block);
		}
	}

	@Override
	public void display() {
		for (Block block : trackList) {
			block.display();
		}
	}

}
