package org.rumter.common_house_jogl.models.windows;

import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

/**
 * окно wash room
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class WashRoomWindow extends WindowsBlock {
	/**
	 * количество плиток по вертикали
	 */
	private static final int countH = 7;
	/**
	 * количество плиток по горизонтали
	 */
	private static final int countG = 12;
	/**
	 * длина плитки
	 */
	private static final float qw = Window3.getInnerWidth() / countG;
	/**
	 * высота плитки
	 */
	private static final float qh = Window3.getInnerHeight() / countH;

	public WashRoomWindow(float x, float y, float z) {
		super(x, y, z);
	}

	/**
	 * нарисовать окно
	 */
	public void drawWindow(float x, float y, float z) {
		// всё окно
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(Window3.l, 0,
				0), new Point(0, Window3.h, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		float quadLineW = 0.01f;
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("quadBg");
		for (int i = 0; i < countH; ++i) {
			for (int j = 0; j < countG; ++j) {
				float xi = x + Window3.w2 + j * qw;
				float yi = y + Window3.w1 + i * qh;
				DrawUtils.drawRectangleTex(new Point(xi, yi, z), new Point(qw,
						0, 0), new Point(0, qh, 0),
						DrawUtils.TEXTURE_MODE_REPEAT);
			}
		}
		org.rumter.common_house_jogl.App.TexUtils.prepareForDisplay("quad");
		for (int i = 0; i < countH; ++i) {
			for (int j = 0; j < countG; ++j) {
				float xi = x + Window3.w2 + j * qw;
				float yi = y + Window3.w1 + i * qh;
				DrawUtils.drawRectangleTex(new Point(xi + quadLineW, yi
						+ quadLineW, z), new Point(qw - quadLineW - quadLineW,
						0, 0), new Point(0, qh - quadLineW - quadLineW, 0),
						DrawUtils.TEXTURE_MODE_REPEAT);
			}
		}
	}

	@Override
	public void display() {
		// отступы
		drawIndents();
		// перегородка между окнами
		drawSeparator();
		// окна
		drawWindow(x + a, y + c, z);
		drawWindow(x + l - Window3.l - a, y + c, z);
		// подоконник
		drawSill();
	}
}
