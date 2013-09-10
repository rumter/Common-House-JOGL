package org.rumter.common_house_jogl.utils;

/**
 * плоскость
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Plane {
	private float A;
	private float B;
	private float C;
	private float D;
	private Point N;

	public Plane(Point a, Point b, Point c) {
		N = Point.vectorMul(b.sub(a), c.sub(a));
		A = N.x;
		B = N.y;
		C = N.z;
		D = -A * a.x - B * a.y - C * a.z;
	}

	public float distance(Point p) {
		return (float) (Math.abs(A * p.x + B * p.y + C * p.z + D) / Math.sqrt(A
				* A + B * B + C * C));
	}

	public Point projection(Point p) {
		return p.add(N.normal().mul(-distance(p)));
	}
}
