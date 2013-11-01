package org.rumter.chj.models.StudentCity.ground;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleModel;

/**
 * Ландшафт
 * 
 * @author ilya
 * 
 */
public class Ground extends SimpleModel {

	private final static float size = 2000f;
	private final static float yLevel = 0;
	private Quad q;

	private TrackSet trackSet;

	public Ground(float x, float y, float z) {
		super(x, y, z);
		q = new Quad(new Point(x - size / 2f, y + yLevel, z - size / 2f), new Point(size, 0, 0), new Point(0, 0, size));
		trackSet = new TrackSet(x, y, z);
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("ground/ground_");
		App.drawUtils.drawQuadTex(q);
		trackSet.display();
	}

}
