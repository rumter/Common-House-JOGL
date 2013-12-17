package org.rumter.chj.framework.model.base;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;

public abstract class SimpleTransparentModel extends SimpleModel implements TransparentModel {

	public SimpleTransparentModel(Point p) {
		super(p);
	}

	public SimpleTransparentModel(float x, float y, float z) {
		super(x, y, z);
	}

	protected abstract void _display();

	public void display() {
		App.gl.glEnable(GL2.GL_BLEND); // Turn Blending On
		App.gl.glDisable(GL2.GL_DEPTH_TEST); // Turn Depth Testing Off
		_display();
		App.gl.glDisable(GL2.GL_BLEND); // Turn Blending Off
		App.gl.glEnable(GL2.GL_DEPTH_TEST); // Turn Depth Testing On
	}

}
