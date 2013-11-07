package org.rumter.chj.models.StudentCity.fence;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.base.SimpleModel;

public class Fence extends SimpleModel {

	private List<FenceSegment> fenceSegments;

	public Fence(float x, float y, float z) {
		super(x, y, z);

		fenceSegments = new ArrayList<FenceSegment>();
		fenceSegments.add(new FenceSegment(x, y, z, new Point(0, 0, 0), new Point(-17, 0, 0), true, true));

		fenceSegments.add(new FenceSegment(x, y, z, new Point(-32, 0, 0), new Point(-100, 0, 0), true, false));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-100, 0, 0), new Point(-150, 0, 0), true, false));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-150, 0, 0), new Point(-200, 0, 0), true, false));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-200, 0, 0), new Point(-250, 0, 0), true, false));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-250, 0, 0), new Point(-300, 0, 0), true, true));

		fenceSegments.add(new FenceSegment(x, y, z, new Point(-300, 0, 0), new Point(-430, 0, 39), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-430, 0, 39), new Point(-461, 0, 39), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-461, 0, 39), new Point(-461, 0, 346), false, true));

		fenceSegments.add(new FenceSegment(x, y, z, new Point(-461, 0, 346), new Point(-400, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-400, 0, 356), new Point(-350, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-350, 0, 356), new Point(-300, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-300, 0, 356), new Point(-250, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-250, 0, 356), new Point(-200, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-200, 0, 356), new Point(-150, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-150, 0, 356), new Point(-100, 0, 356), false, true));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(-100, 0, 356), new Point(-30, 0, 356), false, true));

		fenceSegments.add(new FenceSegment(x, y, z, new Point(-15, 0, 356), new Point(4, 0, 356), true, false));
		fenceSegments.add(new FenceSegment(x, y, z, new Point(4, 0, 356), new Point(0, 0, 0), true, false));

	}

	@Override
	public void display() {
		for (FenceSegment fs : fenceSegments) {
			fs.display();
		}
	}

}
