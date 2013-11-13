package org.rumter.chj.framework.model.primitives;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureUtils.TextureMode;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.Model;

public class Tree implements Model {

	private Quad q1, q2;
	private String tex;

	public Tree(float x, float y, float z, float w, float h, String texture) {
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
		App.gl.glEnable(GL2.GL_BLEND); // Turn Blending On
		App.gl.glDisable(GL2.GL_DEPTH_TEST); // Turn Depth Testing Off
		App.drawUtils.drawQuadTex(q1, TextureMode.STRETCH);
		App.drawUtils.drawQuadTex(q2, TextureMode.STRETCH);
		App.gl.glDisable(GL2.GL_BLEND); // Turn Blending Off
		App.gl.glEnable(GL2.GL_DEPTH_TEST); // Turn Depth Testing On
	}

}
