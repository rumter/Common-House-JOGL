package org.rumter.chj.models.StudentCity.ground;

import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;

public class HozCorp extends SimpleModel {

	private Block blockSouth;
	private Block blockNorth;

	public HozCorp(Point position) {
		super(position);
	}

	public HozCorp(float x, float y, float z) {
		this(new Point(x, y, z));

		Quad baseS = new Quad(new Point(x - 8, 0, z + 21), new Point(- 60, 0, 0), new Point(0, 0, 200));
		Quad baseN = new Quad(new Point(x - 61, 0, z + 79), new Point(- 100, 0, 0), new Point(0, 0, 100));

		blockSouth = new Block(baseS, 15);
		blockNorth = new Block(baseN, 15.1f);
		blockNorth.setSideTexture("ground/white_brick");
		blockSouth.setSideTexture("ground/hozcs");
	}

	@Override
	public void display() {
		blockNorth.display();
		blockSouth.display();
	}

}
