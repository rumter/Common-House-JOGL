package org.rumter.common_house_jogl.utils;

import java.awt.Color;

import javax.media.opengl.GL2;
import javax.media.opengl.fixedfunc.GLLightingFunc;

import org.rumter.common_house_jogl.App;

/**
 * источник света
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Light {

	int num, alpha;
	float attenuation;
	float[] position, direction, drawPosition;
	float[] diffuse, specular;

	public Light(int num, int alpha, float attenuation, float[] position,
			float[] direction, float[] diffuse, float[] specular,
			float[] drawPosition) {
		GL2 gl = App.gl;
		this.num = num;
		this.alpha = alpha;
		this.attenuation = attenuation;
		this.position = position;
		this.drawPosition = drawPosition;
		this.direction = direction;
		this.specular = specular;
		this.diffuse = diffuse;

		gl.glEnable(GLLightingFunc.GL_LIGHTING);
		gl.glEnable(GLLightingFunc.GL_LIGHT0);
		gl.glLighti(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPOT_CUTOFF,
				alpha);
		// gl.glLightf(GLLightingFunc.GL_LIGHT0,
		// GLLightingFunc.GL_LINEAR_ATTENUATION, attenuation);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE,
				diffuse, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR,
				specular, 0);

		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION,
				position, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0,
				GLLightingFunc.GL_SPOT_DIRECTION, direction, 0);
	}

	public void display() {
		// float[] v = {1f, 1f, 1f, 128f};
		// gl.glMaterialfv(gl.GL_FRONT_AND_BACK, gl.GL_SHININESS, v, 0);
		DrawUtils.drawSphere(Color.green, new Point(drawPosition[0],
				drawPosition[1], drawPosition[2]), 1f);
	}
}
