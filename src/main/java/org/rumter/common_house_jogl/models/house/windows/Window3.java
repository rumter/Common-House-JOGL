package org.rumter.common_house_jogl.models.house.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;

/**
 * Окно с тремя окнами
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Window3 extends Window {
	protected static final float h = 2;
	protected static final float l = 3;

	public float getH() {
		return h;
	}

	public float getL() {
		return l;
	}

	/**
	 * ширина рамки
	 */
	public static final float w1 = 0.15f;
	/**
	 * ширина внутренней рамки
	 */
	public static final float w2 = 0.15f;
	/**
	 * высота стекла
	 */
	private static final float gh = h - w1 * 2f;
	/**
	 * длина боковых стекол
	 */
	private static final float gl1 = (l - w2 * 4f) / 3f + 0.20f;
	/**
	 * длина центрального стекла
	 */
	private static final float gl2 = (l - w2 * 4f) / 3f - 0.40f;

	/**
	 * высота внутренней части
	 */
	public static float getInnerHeight() {
		return h - w1 - w1;
	}

	/**
	 * длина внутренней части
	 */
	public static float getInnerWidth() {
		return l - w2 - w2;
	}

	public Window3(float x, float y, float z, float stepZ) {
		super(x, y, z);

		vw = new Point[] { new Point(x, y, z), new Point(l, 0, 0),
				new Point(0, h, 0) };

		vg1 = new Point[] { new Point(x + w2, y + w1, z), new Point(gl1, 0, 0),
				new Point(0, gh, 0) };

		vg2 = new Point[] { new Point(x + w2 + gl1 + w2, y + w1, z),
				new Point(gl2, 0, 0), new Point(0, gh, 0) };

		vg3 = new Point[] { new Point(x + l - w2 - gl1, y + w1, z),
				new Point(gl1, 0, 0), new Point(0, gh, 0) };

		window = new Quad(vw[0], vw[1], vw[2]).moveZ(stepZ);
		glass1 = new Quad(vg1[0], vg1[1], vg1[2]).moveZ(stepZ * 2);
		glass2 = new Quad(vg2[0], vg2[1], vg2[2]).moveZ(stepZ * 2);
		glass3 = new Quad(vg3[0], vg3[1], vg3[2]).moveZ(stepZ * 2);
	}

	private Point[] vw, vg1, vg2, vg3;

	private Quad window, glass1, glass2, glass3;

	@Override
	public void display() {
		// всё окно
		App.texUtils.prepareForDisplay("house/window");
		App.drawUtils.drawQuadTex(window);
		// стёкла
		App.texUtils.prepareForDisplay("house/glass");
		App.drawUtils.drawQuadTex(glass1);
		App.drawUtils.drawQuadTex(glass2);
		App.drawUtils.drawQuadTex(glass3);
	}
}
