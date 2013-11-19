package org.rumter.chj.framework.model.primitives;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.Model;

public class SkyBox implements Model {

	private String texture = null;

	private Block box = null;

	private double texW = (double) 1 / (double) 4;
	private double tex2W = (double) 1 / (double) 2;
	private double tex3W = (double) 3 / (double) 4;
	private double tex4W = (double) 1;
	private double texH = (double) 1 / (double) 3;
	private double tex3H = (double) 1;
	private double tex2H = (double) 2 / (double) 3;

	public SkyBox(Point center, float R, String texture) {
		this.texture = texture;

		Point start = new Point(-R, -R, -R).add(center);
		Point v1 = new Point(2 * R, 0, 0);
		Point v2 = new Point(0, 0, 2 * R);

		box = new Block(new Quad(start, v1, v2), 2 * R);
	}

	private void drawTex(Quad q, double x1, double y1, double x2, double y2) {
		GL2 gl = App.gl;
		gl.glTexCoord2d(x1, y2);
		gl.glVertex3fv(q.getVertexArray()[0], 0);
		gl.glTexCoord2d(x1, y1);
		gl.glVertex3fv(q.getVertexArray()[1], 0);
		gl.glTexCoord2d(x2, y1);
		gl.glVertex3fv(q.getVertexArray()[2], 0);
		gl.glTexCoord2d(x2, y2);
		gl.glVertex3fv(q.getVertexArray()[3], 0);
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay(texture);
		GL2 gl = App.gl;
		gl.glBegin(GL2.GL_QUADS);
		double eps = 0.001;
		drawTex(box.getTopSide(), texW + eps, eps, tex2W - eps, texH + eps);
		drawTex(box.getLeftSide(), 0, texH + eps, texW, tex2H);
		drawTex(box.getFrontSide(), texW, texH + eps, tex2W, tex2H);
		drawTex(box.getRightSide(), tex2W, texH + eps, tex3W, tex2H);
		drawTex(box.getBackSide(), tex3W, texH + eps, tex4W, tex2H);
		drawTex(box.getBottomSide(), texW, tex2H, tex2W, tex3H);
		gl.glEnd();
	}
}
