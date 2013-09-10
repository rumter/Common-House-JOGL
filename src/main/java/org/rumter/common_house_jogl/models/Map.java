package org.rumter.common_house_jogl.models;

import java.util.ArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.fixedfunc.GLLightingFunc;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Light;
import org.rumter.common_house_jogl.utils.Point;
import org.rumter.common_house_jogl.utils.Wall;

/**
 * карта
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Map extends SimpleModel {

	private Model house;

	public Map(float x, float y, float z) {
		super(x, y, z);
		house = new House(x - 4.4f, y, z - 145.2f);
	}

	@Override
	public ArrayList<Wall> getWalls() {
		return house.getWalls();
	}

	/**
	 * источник света
	 */
	private Light l0;
	/**
	 * позиция источника света
	 */
	private float[] position = new float[] { x - 4.4f, y + 100,
			z - 145.2f - 10, 0 };
	private float[] drawPosition = new float[] { position[0], position[1] - 5,
			position[2] - 100, 0 };

	@Override
	public void display() {
		GL2 gl = App.gl;

		l0 = new Light(0, 90, 0.0f, position, new float[] { 0, 0, 1 },
				new float[] { 1.0f, 1.0f, 1.0f, 1.0f }, new float[] { 0.0f,
						0.0f, 0.0f, 1.0f }, drawPosition);

		float sz = 1000;

		// делаем тени
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_DST_ALPHA);
		gl.glDisable(GLLightingFunc.GL_LIGHTING);
		gl.glColor4f(0f, 0f, 0f, 0.9f);
		gl.glPushMatrix();
		// проецируем тень
		DrawUtils.setShadow(true);
		gl.glMultMatrixf(getShadowMatrix(), 0);
		drawScene(gl, sz);
		DrawUtils.setShadow(false);
		gl.glPopMatrix();
		gl.glEnable(GLLightingFunc.GL_LIGHTING);
		gl.glDisable(GL.GL_BLEND);
		drawScene(gl, sz);
	}

	/**
	 * отрисовка сцены
	 */
	private void drawScene(GL2 gl, float sz) {
		if (!DrawUtils.isShadow()) {
			l0.display();
		}
		house.display();
		if (!DrawUtils.isShadow()) {
			App.TexUtils.prepareForDisplay("window");
			DrawUtils
					.drawRectangleTex(new Point(-sz, -sz),
							new Point(0, sz + sz), new Point(sz + sz, 0),
							DrawUtils.TEXTURE_MODE_REPEAT);
		}
	}

	/**
	 * получить теневую матрицу
	 */
	private float[] getShadowMatrix() {
		float plane[] = new float[] { 0, 1, 0, 0 };
		float lightpos[] = position;

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