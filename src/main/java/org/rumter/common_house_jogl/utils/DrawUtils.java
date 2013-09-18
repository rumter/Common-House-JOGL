package org.rumter.common_house_jogl.utils;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUquadric;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;
import org.rumter.common_house_jogl.geom.Quad;

/**
 * методы для рисования
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class DrawUtils {

	public DrawUtils() {
	}

	public static final int TEXTURE_MODE_REPEAT = 0;
	public static final int TEXTURE_MODE_STRETCH = 1;

	private void drawTex(Quad q, float w, float h) {
		GL2 gl = App.gl;
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0.0f, 0.0f);
		gl.glVertex3fv(q.getVertexArray()[0], 0);
		gl.glTexCoord2f(0.0f, h);
		gl.glVertex3fv(q.getVertexArray()[1], 0);
		gl.glTexCoord2f(w, h);
		gl.glVertex3fv(q.getVertexArray()[2], 0);
		gl.glTexCoord2f(w, 0.0f);
		gl.glVertex3fv(q.getVertexArray()[3], 0);
		gl.glEnd();
	}

	public void drawQuad(Color c, Quad q) {
		GL2 gl = App.gl;
		if (App.shadowManager.isShadowMode()) {
			c = Color.BLACK;
		}
		float[] cv = { c.getRed(), c.getGreen(), c.getBlue(), 0.0f };
		float[] black = { 0f, 0f, 0f };
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3fv(cv, 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, cv, 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, cv, 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, cv, 0);
		gl.glMateriali(GL.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 4);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_EMISSION, black, 0);
		float[][] vertex = q.getVertexArray();
		for (int i = 0; i < vertex.length; ++i) {
			gl.glVertex3fv(vertex[i], 0);
		}
		gl.glEnd();
	}

	public void drawQuadTex(Quad q, int mode) {
		if (App.shadowManager.isShadowMode()) {
			drawQuad(Color.BLACK, q);
		} else {
			if (mode == TEXTURE_MODE_REPEAT) {
				drawTex(q, q.getW(), q.getH());
			} else {
				drawTex(q, 1.0f, 1.0f);
			}
		}
	}

	public void drawCylinder(Color c, Point p, float r, float h) {
		GL2 gl = App.gl;
		if (App.shadowManager.isShadowMode()) {
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

	public void drawSphere(Color c, Point p, float r) {
		GL2 gl = App.gl;
		if (App.shadowManager.isShadowMode()) {
			c = Color.BLACK;
		}
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y + r, p.z);
		gl.glColor3f(c.getRed(), c.getGreen(), c.getBlue());
		GLUquadric glq = App.glu.gluNewQuadric();
		App.glu.gluSphere(glq, r, 10, 10);
		gl.glPopMatrix();
	}

}