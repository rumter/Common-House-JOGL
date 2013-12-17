package org.rumter.chj.framework.motion;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Plane;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.primitives.PlaneWall;

/**
 * движение в 3D пространстве
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class MotionManager {

	private final float step = 1.0f;
	private final float stepH = 10.0f;

	public float rotateX = 0;
	public float rotateY = 0;
	private Point position = new Point(0, 0, 0);

	public MotionManager() {
	}

	public void setPosition(float posX, float posY, float posZ, float rotateX, float rotateY) {
		position = new Point(posX, posY, posZ);
		this.rotateX = rotateX;
		this.rotateY = rotateY;
	}

	public Point getPosition() {
		return position;
	}

	public void display() {
		GL2 gl = App.gl;
		gl.glRotatef(rotateX, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(rotateY, 0.0f, 1.0f, 0.0f);
		gl.glTranslatef(-position.x, -position.y, -position.z);
	}

	/**
	 * Проверка, что нахождение в точке экрана допустимо
	 * 
	 * @param p
	 * @return
	 */
	public boolean isCorrectPosition(Point p) {
		float wallWidth = 10 * step;
		float groundHeight = 0;
		// стены
		for (PlaneWall wall : App.worldLoader.getCurrentWorld().getWalls()) {
			Plane pl = wall.getPlane();
			if (pl.distance(p) <= wallWidth && wall.contains(pl.projection(p))) {
				return false;
			}
		}
		// пол
		if (p.y <= groundHeight) {
			return false;
		}
		return true;
	}

	/**
	 * вперёд
	 */
	public void go(float k) {
		Point newPosition = position.add(new Point(0, 0, -step * k).rotateXZ(rotateY));
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}

	/**
	 * вправо
	 */
	public void right(float k) {
		Point newPosition = position.add(new Point(step * k, 0, 0).rotateXZ(rotateY));
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}

	/**
	 * назад
	 */
	public void back(float k) {
		Point newPosition = position.sub(new Point(0, 0, -step * k).rotateXZ(rotateY));
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}

	/**
	 * влево
	 */
	public void left(float k) {
		Point newPosition = position.sub(new Point(step * k, 0, 0).rotateXZ(rotateY));
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}

	/**
	 * повернуться горизонтально на угол alpha
	 * 
	 * @param alpha
	 */
	public void rotateHorizontal(float alpha) {
		rotateY += alpha / 2.0;
	}

	/**
	 * повернуться вертикально на угол alpha
	 * 
	 * @param alpha
	 */
	public void rotateVertical(float alpha) {
		rotateX += alpha / 2.0;
		rotateX = Math.min(Math.max(-90, rotateX), 90);
	}

	/**
	 * подняться выше
	 */
	public void up() {
		Point newPosition = position.clone();
		newPosition.y += stepH;
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}

	/**
	 * опуститься ниже
	 */
	public void down() {
		Point newPosition = position.clone();
		newPosition.y -= stepH;
		if (isCorrectPosition(newPosition)) {
			position = newPosition;
		}
	}
}
