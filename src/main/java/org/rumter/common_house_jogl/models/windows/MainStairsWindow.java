package org.rumter.common_house_jogl.models.windows;

import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

/**
 * окно напротив основной лестницы
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class MainStairsWindow extends Window {
	protected static final float h = WindowsBlock.getsH() + 1.2f;
	protected static final float l = WindowsBlock.getsL();

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
	 * количество плиток по высоте
	 */
	private static final int countH = 5;
	/**
	 * количество плиток по длине
	 */
	private static final int countL = 6;
	/**
	 * отступ
	 */
	private static final float a = 0.10f;
	/**
	 * длина плитки
	 */
	private static final float qw = (l - a - a) / countL;
	/**
	 * высота плитки
	 */
	private static final float qh = (h - a - a) / countH;
	/**
	 * линия плитки
	 */
	private static final float ql = 0.10f;

	public MainStairsWindow(float x, float y, float z) {
		super(x, y, z);
	}

	private void drawQuad(float x, float y, float z, int type) {
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(qw, 0, 0),
				new Point(0, qh, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("glass");
		DrawUtils.drawRectangleTex(new Point(x + ql, y + ql, z), new Point(qw
				- ql - ql, 0, 0), new Point(0, qw - ql - ql, 0),
				DrawUtils.TEXTURE_MODE_REPEAT);
		float cx = (qw - ql * 3f) / 2f;
		float cy = (qh - ql * 3f) / 2f;
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("window");
		if (type == 1) {
			DrawUtils.drawRectangleTex(new Point(x + ql + cx, y + ql, z),
					new Point(ql, 0, 0), new Point(0, qw - ql - ql, 0),
					DrawUtils.TEXTURE_MODE_REPEAT);
		} else {
			DrawUtils.drawRectangleTex(new Point(x + ql, y + ql + cy, z),
					new Point(qw - ql - ql, 0, 0), new Point(0, ql, 0),
					DrawUtils.TEXTURE_MODE_REPEAT);
		}
	}

	@Override
	public void display() {
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(l, 0, 0),
				new Point(0, h, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		for (int i = 0; i < countL; ++i)
			for (int j = 0; j < countH; ++j)
				drawQuad(x + i * qw, y + j * qh, z, 1 - (i + j) % 2);
	}
}
