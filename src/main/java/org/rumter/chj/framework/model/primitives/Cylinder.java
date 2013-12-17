package org.rumter.chj.framework.model.primitives;

import java.awt.Color;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUquadric;

import org.rumter.chj.App;
import org.rumter.chj.framework.model.base.SimpleModel;

public class Cylinder extends SimpleModel {

	private static final Color DEFAULT_COLOR = Color.BLACK;

	private float r, h;
	private int rotateX, rotateY;
	private GLUquadric glq;

	private int slices = 20;
	private int stacks = 20;

	private Color sideColor = null;
	private String sideTexture = null;

	public Cylinder(float x, float y, float z, float r, float h, int rotateX, int rotateY) {
		super(x, y, z);
		this.r = r;
		this.h = h;
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		glq = App.glu.gluNewQuadric();
	}

	@Override
	public void display() {
		GL2 gl = App.gl;
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y, p.z);
		gl.glRotatef(rotateX, 1, 0, 0);
		gl.glRotatef(rotateY, 0, 1, 0);

		if (sideTexture != null) {
			App.texUtils.prepareForDisplay(sideTexture);
			App.glu.gluQuadricTexture(glq, true);
		} else {
			Color c = (sideColor != null ? sideColor : DEFAULT_COLOR);
			gl.glColor3f(c.getRed(), c.getGreen(), c.getBlue());
			App.glu.gluQuadricTexture(glq, false);
		}

		App.glu.gluCylinder(glq, r, r, h, slices, stacks);
		gl.glPopMatrix();
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	public void setStacks(int stacks) {
		this.stacks = stacks;
	}

	public void setSideColor(Color sideColor) {
		this.sideColor = sideColor;
	}

	public void setSideTexture(String sideTexture) {
		this.sideTexture = sideTexture;
	}

}
