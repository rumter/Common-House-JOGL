package org.rumter.common_house_jogl.utils.light;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.fixedfunc.GLLightingFunc;

import org.rumter.common_house_jogl.App;

public class ShadowManager {

	private float[] shadowMatrix;

	private boolean isShadowMode = false;

	public static final Color SHADOW_COLOR = new Color(0f, 0f, 0f, 0.9f);
	public static final float[] SHADOW_COLOR_fv = new float[] { 0f, 0f, 0f,
			0.9f };

	public ShadowManager() {
	}

	public boolean isShadowMode() {
		return isShadowMode;
	}

	public void initShadowMatrix(float[] lightPosition) {
		shadowMatrix = getShadowMatrix(lightPosition);
	}

	public void beginDrawShadow() {
		GL2 gl = App.gl;
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_DST_ALPHA);
		gl.glDisable(GLLightingFunc.GL_LIGHTING);
		gl.glColor4fv(SHADOW_COLOR_fv, 0);
		gl.glPushMatrix();
		gl.glTranslatef(0, 0.01f, 0);
		this.isShadowMode = true;
		gl.glMultMatrixf(shadowMatrix, 0);
	}

	public void endDrawShadow() {
		GL2 gl = App.gl;
		this.isShadowMode = false;
		gl.glPopMatrix();
		gl.glEnable(GLLightingFunc.GL_LIGHTING);
		gl.glDisable(GL.GL_BLEND);
	}

	/**
	 * получить теневую матрицу
	 */
	private float[] getShadowMatrix(float[] lightpos) {
		float plane[] = new float[] { 0, 1, 0, 0 };

		float det = plane[0] * lightpos[0] + plane[1] * lightpos[1] + plane[2]
				* lightpos[2] + plane[3] * lightpos[3];

		float matrix[][] = new float[4][4];
		matrix[0][0] = det - lightpos[0] * plane[0];
		matrix[1][0] = 0f - lightpos[0] * plane[1];
		matrix[2][0] = 0f - lightpos[0] * plane[2];
		matrix[3][0] = 0f - lightpos[0] * plane[3];

		matrix[0][1] = 0f - lightpos[1] * plane[0];
		matrix[1][1] = det - lightpos[1] * plane[1];
		matrix[2][1] = 0f - lightpos[1] * plane[2];
		matrix[3][1] = 0f - lightpos[1] * plane[3];

		matrix[0][2] = 0f - lightpos[2] * plane[0];
		matrix[1][2] = 0f - lightpos[2] * plane[1];
		matrix[2][2] = det - lightpos[2] * plane[2];
		matrix[3][2] = 0f - lightpos[2] * plane[3];

		matrix[0][3] = 0f - lightpos[3] * plane[0];
		matrix[1][3] = 0f - lightpos[3] * plane[1];
		matrix[2][3] = 0f - lightpos[3] * plane[2];
		matrix[3][3] = det - lightpos[3] * plane[3];

		float[] res = new float[16];
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				res[i * 4 + j] = matrix[i][j];

		return res;
	}

}
