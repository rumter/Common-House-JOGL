package org.rumter.common_house_jogl.geom;

public class Quad {
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	private float[][] vertexArray;
	private float distanceP1P2;
	private float distanceP1P4;

	public Quad(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.vertexArray = new float[][] { new float[] { p1.x, p1.y, p1.z },
				new float[] { p2.x, p2.y, p2.z },
				new float[] { p3.x, p3.y, p3.z },
				new float[] { p4.x, p4.y, p4.z } };
		this.distanceP1P2 = p2.sub(p1).distance();
		this.distanceP1P4 = p4.sub(p1).distance();
	}

	public Quad(Point p, Point v1, Point v2) {
		this(p, p.add(v1), p.add(v1).add(v2), p.add(v2));
	}

	public Quad moveX(float stepValue) {
		return move(new Point(stepValue, 0, 0));
	}

	public Quad moveY(float stepValue) {
		return move(new Point(0, stepValue, 0));
	}

	public Quad moveZ(float stepValue) {
		return move(new Point(0, 0, stepValue));
	}

	public Quad move(Point v) {
		return new Quad(p1.add(v), p2.add(v), p3.add(v), p4.add(v));
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getP4() {
		return p4;
	}

	public void setP4(Point p4) {
		this.p4 = p4;
	}

	public float[][] getVertexArray() {
		return vertexArray;
	}

	public float getDistanceP1P2() {
		return distanceP1P2;
	}

	public float getDistanceP1P4() {
		return distanceP1P4;
	}

	public float getH() {
		return distanceP1P2;
	}

	public float getW() {
		return distanceP1P4;
	}
}
