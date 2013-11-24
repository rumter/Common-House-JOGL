package org.rumter.chj.models.StudentCity.ground;

import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleTransparentModel;
import org.rumter.chj.framework.model.primitives.Block;

public class Klumb extends SimpleTransparentModel {

	private final float KLUMB_L = 0.5f;
	private final float KLUMB_H = 1.0f;

	private static final String SIDE_TEXTURE = "ground/klumb_side";
	private static final String TOP_TEXTURE = "ground/klumb_top";

	private Block b;

	public Klumb(Point p) {
		super(p);

		Quad base = new Quad(p, new Point(KLUMB_L, 0, 0), new Point(0, 0, KLUMB_L));
		b = new Block(base, KLUMB_H);
		b.setSideTexture(SIDE_TEXTURE);
		b.setTopTexture(TOP_TEXTURE);
	}

	public Klumb(float x, float y, float z) {
		this(new Point(x, y, z));
	}

	@Override
	protected void _display() {
		b.display();
	}

}
