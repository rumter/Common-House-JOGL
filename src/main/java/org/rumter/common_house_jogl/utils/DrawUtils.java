package org.rumter.common_house_jogl.utils;

import java.awt.Color;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUquadric;

import org.rumter.common_house_jogl.App;

/**
 * методы для рисования
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class DrawUtils {
	private static void drawPoint(Point p) {
		GL2 gl = App.gl;
		gl.glVertex3f(p.x, p.y, p.z);
	}

	public static void drawRectangle(Color c, Point p, Point v1, Point v2) {
		GL2 gl = App.gl;
		if (isShadow()) {
			c = Color.BLACK;
		}
		gl.glBegin(GL2.GL_QUADS);
		float[] v = { c.getRed(), c.getGreen(), c.getBlue(), 0.0f };
		gl.glColor3fv(v, 0);
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, v, 0);
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, v, 0);
		drawPoint(p);
		drawPoint(p.add(v1));
		drawPoint(p.add(v1).add(v2));
		drawPoint(p.add(v2));
		gl.glEnd();
	}

	public static int TEXTURE_MODE_REPEAT = 0;
	public static int TEXTURE_MODE_STRETCH = 1;

	public static void drawRectangleTex(Point p, Point v1, Point v2, int mode) {
		GL2 gl = App.gl;
		if (isShadow()) {
			drawRectangle(Color.BLACK, p, v1, v2);
			return;
		}
		float dw = v2.distance();
		float dh = v1.distance();
		float w = 1.0f;
		float h = 1.0f;
		if (mode == TEXTURE_MODE_REPEAT) {
			w = dw;
			h = dh;
		}
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0.0f, 0.0f);
		drawPoint(p);
		gl.glTexCoord2f(0.0f, h);
		drawPoint(p.add(v1));
		gl.glTexCoord2f(w, h);
		drawPoint(p.add(v1).add(v2));
		gl.glTexCoord2f(w, 0.0f);
		drawPoint(p.add(v2));
		gl.glEnd();
	}

	public static void drawRectangleTex(Point p, Point v1, Point v2, int width,
			int height, int length) {
		GL2 gl = App.gl;
		if (isShadow()) {
			drawRectangle(Color.BLACK, p, v1, v2);
			return;
		}
		float w = (float) ((float) width / (float) length);
		float h = (float) ((float) height / (float) length);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0.0f, 0.0f);
		drawPoint(p);
		gl.glTexCoord2f(0.0f, h);
		drawPoint(p.add(v1));
		gl.glTexCoord2f(w, h);
		drawPoint(p.add(v1).add(v2));
		gl.glTexCoord2f(w, 0.0f);
		drawPoint(p.add(v2));
		gl.glEnd();
	}

	public static void drawCilynder(Color c, Point p, float r, float h) {
		GL2 gl = App.gl;
		if (isShadow()) {
			c = Color.BLACK;
		}
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y + h, p.z);
		gl.glRotatef(90, 1, 0, 0);
		gl.glColor3f(c.getRed(), c.getGreen(), c.getBlue());
		GLUquadric glq = App.glu.gluNewQuadric();
		App.glu.gluCylinder(glq, r, r, h, 20, 20);
		gl.glPopMatrix();
	}

	public static void drawSphere(Color c, Point p, float r) {
		GL2 gl = App.gl;
		if (isShadow()) {
			c = Color.BLACK;
		}
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y + r, p.z);
		gl.glColor3f(c.getRed(), c.getGreen(), c.getBlue());
		GLUquadric glq = App.glu.gluNewQuadric();
		App.glu.gluSphere(glq, r, 10, 10);
		gl.glPopMatrix();
	}

	private static boolean shadow = false;

	public static boolean isShadow() {
		return shadow;
	}

	public static void setShadow(boolean shadowValue) {
		shadow = shadowValue;
	}
}