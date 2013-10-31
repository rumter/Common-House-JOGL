package org.rumter.chj.framework.geom;

/**
 * точка
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Point implements Cloneable {
	public float x, y, z;

	public Point() {
		x = 0;
		y = 0;
		z = 0;
	}

	public Point(float x, float z) {
		this.x = x;
		this.y = 0;
		this.z = z;
	}

	public Point(double x, double z) {
		this((float) x, (float) z);
	}

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point(double x, double y, double z) {
		this((float) x, (float) y, (float) z);
	}

	public Point add(Point p) {
		return new Point(x + p.x, y + p.y, z + p.z);
	}

	public Point sub(Point p) {
		return new Point(x - p.x, y - p.y, z - p.z);
	}

	@Override
	public int hashCode() {
		float m1 = 123141;
		float m2 = 1231;
		return Math.round(x * m1 + y * m2 + z);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point p = (Point) obj;
		return p.x == x && p.y == y && p.z == z;
	}

	/**
	 * длина вектора
	 */
	public float distance() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * нормализовать вектор
	 */
	public Point normal() {
		float d = distance();
		return new Point(x / d, y / d, z / d);
	}

	/**
	 * повернуть вектор в плоскости XOZ
	 */
	public Point rotateXZ(float alpha) {
		alpha = (float) Math.toRadians(alpha);
		float newx = (float) (x * (float) Math.cos(alpha) - z
				* (float) Math.sin(alpha));
		float newz = (float) (x * (float) Math.sin(alpha) + z
				* (float) Math.cos(alpha));
		return new Point(newx, y, newz);
	}
	
	/**
	 * повернуть вектор в плоскости YOZ
	 */
	public Point rotateYZ(float alpha) {
		alpha = (float) Math.toRadians(alpha);
		float newy = (float) (y * (float) Math.cos(alpha) - z
				* (float) Math.sin(alpha));
		float newz = (float) (y * (float) Math.sin(alpha) + z
				* (float) Math.cos(alpha));
		return new Point(x, newy, newz);
	}

	public Point clone() {
		return new Point(x, y, z);
	}

	/**
	 * определитель второго порядка
	 */
	public static double det(double a11, double a12, double a21, double a22) {
		return a11 * a22 - a12 * a21;
	}

	/**
	 * векторное произведение векторов
	 */
	public static Point vectorMul(Point a, Point b) {
		return new Point((float) det(a.y, a.z, b.y, b.z), -(float) det(a.x,
				a.z, b.x, b.z), (float) det(a.x, a.y, b.x, b.y));
	}

	/**
	 * умножить вектор на число
	 */
	public Point mul(float n) {
		return new Point(x * n, y * n, z * n);
	}
}
