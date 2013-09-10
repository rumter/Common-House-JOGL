package org.rumter.common_house_jogl.models.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

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

	public Window3(float x, float y, float z) {
		super(x, y, z);

		vw = new Point[] { new Point(x, y, z), new Point(l, 0, 0),
				new Point(0, h, 0) };

		vg1 = new Point[] { new Point(x + w2, y + w1, z), new Point(gl1, 0, 0),
				new Point(0, gh, 0) };

		vg2 = new Point[] { new Point(x + w2 + gl1 + w2, y + w1, z),
				new Point(gl2, 0, 0), new Point(0, gh, 0) };

		vg3 = new Point[] { new Point(x + l - w2 - gl1, y + w1, z),
				new Point(gl1, 0, 0), new Point(0, gh, 0) };
	}

	private Point[] vw, vg1, vg2, vg3;

	@Override
	public void display() {
		// всё окно
		App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(vw[0], vw[1], vw[2],
				DrawUtils.TEXTURE_MODE_REPEAT);
		// стёкла
		App.TexUtils.prepareForDisplay("glass");
		DrawUtils.drawRectangleTex(vg1[0], vg1[1], vg1[2],
				DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(vg2[0], vg2[1], vg2[2],
				DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(vg3[0], vg3[1], vg3[2],
				DrawUtils.TEXTURE_MODE_REPEAT);
	}
}
