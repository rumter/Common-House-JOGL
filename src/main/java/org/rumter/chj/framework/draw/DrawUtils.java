package org.rumter.chj.framework.draw;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLUquadric;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureUtils.TextureMode;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.light.ShadowManager;

/**
 * методы для рисования
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class DrawUtils {

	public DrawUtils() {
	}

	public void setMaterial(Material m) {
		GL2 gl = App.gl;
		gl.glColor3fv(m.getDiffuse(), 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, m.getAmbient(), 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, m.getDiffuse(), 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, m.getSpecular(), 0);
		gl.glMateriali(GL.GL_FRONT_AND_BACK, GL2.GL_SHININESS, m.getShininess());
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_EMISSION, m.getEmission(), 0);
	}

	private void drawTex(Quad q, float w, float h) {
		GL2 gl = App.gl;
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0, h);
		gl.glVertex3fv(q.getVertexArray()[0], 0);
		gl.glTexCoord2f(0, 0);
		gl.glVertex3fv(q.getVertexArray()[1], 0);
		gl.glTexCoord2f(w, 0);
		gl.glVertex3fv(q.getVertexArray()[2], 0);
		gl.glTexCoord2f(w, h);
		gl.glVertex3fv(q.getVertexArray()[3], 0);
		gl.glEnd();
	}

	public void drawQuad(Quad q, Color c) {
		GL2 gl = App.gl;
		if (App.shadowManager.isShadowMode()) {
			c = ShadowManager.SHADOW_COLOR;
		}
		setMaterial(Material.factorySimpleMaterial(c));
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3fv(q.getVertexArray()[0], 0);
		gl.glVertex3fv(q.getVertexArray()[1], 0);
		gl.glVertex3fv(q.getVertexArray()[2], 0);
		gl.glVertex3fv(q.getVertexArray()[3], 0);
		gl.glEnd();
	}

	public void drawQuadTex(Quad q, TextureMode mode) {
		if (App.shadowManager.isShadowMode()) {
			drawQuad(q, ShadowManager.SHADOW_COLOR);
		} else {
			if (mode == TextureMode.REPEAT) {
				drawTex(q, q.getW(), q.getH());
			} else {
				drawTex(q, 1.0f, 1.0f);
			}
		}
	}

	public void drawQuadTexRepeat(Quad q, float cntX, float cntY) {
		if (App.shadowManager.isShadowMode()) {
			drawQuad(q, ShadowManager.SHADOW_COLOR);
		} else {
			drawTex(q, cntX, cntY);
		}
	}

	public void drawQuadTex(Quad q) {
		drawQuadTex(q, TextureMode.REPEAT);
	}

	/*public void drawCylinder(Point p, float r, float h, int rotateX, int rotateY) {
		GL2 gl = App.gl;
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y, p.z);
		gl.glRotatef(rotateX, 1, 0, 0);
		gl.glRotatef(rotateY, 0, 1, 0);
		GLUquadric glq = App.glu.gluNewQuadric();
		App.glu.gluQuadricTexture(glq, true);
		App.glu.gluCylinder(glq, r, r, h, 20, 20);
		gl.glPopMatrix();
	}*/

	public void drawSphere(Point p, float r) {
		GL2 gl = App.gl;
		gl.glPushMatrix();
		gl.glTranslatef(p.x, p.y, p.z);
		GLUquadric glq = App.glu.gluNewQuadric();
		App.glu.gluQuadricTexture(glq, true);
		App.glu.gluSphere(glq, r, 10, 10);
		gl.glPopMatrix();
	}

}