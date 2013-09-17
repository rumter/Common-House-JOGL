package org.rumter.common_house_jogl.utils.light;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.fixedfunc.GLLightingFunc;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;

public class LightManager {

	private float[] l0Position;
	private float[] l0DrawPosition;

	public LightManager() {
	}

	public float[] getPosition0() {
		return l0Position;
	}

	public void initLight0(Point startPosition) {
		l0Position = new float[] { startPosition.x - 4.4f,
				startPosition.y + 100, startPosition.z - 145.2f - 10, 0 };
		l0DrawPosition = new float[] { l0Position[0], l0Position[1] + 1,
				l0Position[2], 0 };

		GL2 gl = App.gl;
		int alpha = 90;
		float attenuation = 0.5f;
		float[] direction = new float[] { 0, 0, -1 };
		float[] ambient = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };
		float[] specular = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };
		float[] diffuse = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };

		gl.glEnable(GLLightingFunc.GL_LIGHTING);
		//gl.glLightModelf(GL2.GL_LIGHT_MODEL_, GL2.GL_TRUE);
		//gl.glEnable(GLLightingFunc.GL_NORMALIZE);
		gl.glEnable(GLLightingFunc.GL_LIGHT0);
		gl.glLighti(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPOT_CUTOFF,
				alpha);
		gl.glLightf(GLLightingFunc.GL_LIGHT0,
				GLLightingFunc.GL_CONSTANT_ATTENUATION, attenuation);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT,
				ambient, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR,
				specular, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE,
				diffuse, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION,
				l0Position, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0,
				GLLightingFunc.GL_SPOT_DIRECTION, direction, 0);

	}

	public void display0() {
		if (!App.shadowManager.isShadowMode()) {
			GL2 gl = App.gl;
			float[] white = { 1f, 1f, 1f };
			float[] emission = { 1f, 1f, 1f };
			gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, white, 0);
			gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, white, 0);
			gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, white, 0);
			gl.glMateriali(GL.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 128);
			gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_EMISSION, emission, 0);
			App.drawUtils.drawSphere(Color.green, new Point(l0DrawPosition[0],
					l0DrawPosition[1], l0DrawPosition[2]), 1f);
		}
	}

	public void stopLighiting() {
		App.gl.glDisable(GLLightingFunc.GL_LIGHTING);
	}

}
