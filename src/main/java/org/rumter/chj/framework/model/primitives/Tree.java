package org.rumter.chj.framework.model.primitives;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureUtils.TextureMode;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleTransparentModel;

public class Tree extends SimpleTransparentModel {

	private Quad q1, q2;
	private String tex;

	public Tree(float x, float y, float z, float w, float h, String texture) {
		super(x, y, z);
		Point vx = new Point(w / 2f, 0, 0);
		Point vz = new Point(0, 0, w / 2f);
		Point vy = new Point(0, h, 0);
		q1 = new Quad(new Point(x, y, z).sub(vx), vy, vx.add(vx));
		q2 = new Quad(new Point(x, y, z).sub(vz), vy, vz.add(vz));
		tex = texture;
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay(tex);
		App.drawUtils.drawQuadTex(q1, TextureMode.STRETCH);
		App.drawUtils.drawQuadTex(q2, TextureMode.STRETCH);
	}

}
