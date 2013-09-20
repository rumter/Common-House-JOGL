package org.rumter.common_house_jogl.models.house.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;

/**
 * окно напротив чёрной лестницы
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class BlackStairsWindow extends Window {
	/**
	 * высота окна
	 */
	protected static final float h = Window3.h;
	/**
	 * длина окна
	 */
	protected static final float l = 1.5f;

	private static final float w1 = Window3.w1;
	private static final float w2 = Window3.w2;

	public static float getsH() {
		return h;
	}

	public static float getsL() {
		return l;
	}

	public float getH() {
		return h;
	}

	public float getL() {
		return l;
	}

	/**
	 * длина стекла
	 */
	private static final float gw = (l - w2 * 3f) / 2f;
	/**
	 * высота стекла
	 */
	private static final float gh = h - w1 * 2f;

	public BlackStairsWindow(float x, float y, float z, float stepZ) {
		super(x, y, z);

		window1 = new Quad(new Point(x, y, z), new Point(l, 0, 0), new Point(0,
				h, 0));
		glass = new Quad(new Point(x + w2, y + w1, z), new Point(gw + w2 + gw,
				0, 0), new Point(0, gh, 0)).moveZ(stepZ);
		window2 = new Quad(new Point(x + w2 + gw, y + w1, z), new Point(w2, 0,
				0), new Point(0, gh, 0)).moveZ(stepZ * 2);
	}

	private Quad window1, glass, window2;

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("window");
		App.drawUtils.drawQuadTex(window1);
		App.texUtils.prepareForDisplay("glass");
		App.drawUtils.drawQuadTex(glass);
		App.texUtils.prepareForDisplay("window");
		App.drawUtils.drawQuadTex(window2);
	}
}
