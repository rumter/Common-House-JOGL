package org.rumter.chj.framework.model.primitives;

import org.rumter.chj.framework.geom.Plane;
import org.rumter.chj.framework.geom.Point;

/**
 * стена - прямоугольник
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class PlaneWall {
	private float x1, z1, x2, z2, h;
	private Point point1, point2, point3, point4, v1, v2;

	public PlaneWall(float x1, float z1, float x2, float z2, float h) {
		this.x1 = x1;
		this.z1 = z1;
		this.x2 = x2;
		this.z2 = z2;
		this.h = h;
		v1 = new Point(x2 - x1, 0, z2 - z1);
		v2 = new Point(0, h, 0);
		point1 = new Point(x1, 0, z1);
		point2 = point1.add(v1);
		point3 = point1.add(v2);
		point4 = point2.add(v2);
	}

	public PlaneWall(Point a, Point b, float h) {
		this(a.x, a.z, b.x, b.z, h);
	}

	public Plane getPlane() {
		return new Plane(point1, point2, point3);
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public Point getPoint4() {
		return point4;
	}

	private static boolean in(float x, float a, float b) {
		return Math.min(a, b) <= x && x <= Math.max(a, b);
	}

	public boolean contains(Point p) {
		return in(p.x, x1, x2) && in(p.z, z1, z2) && 0 <= p.y && p.y <= h;
	}
}
