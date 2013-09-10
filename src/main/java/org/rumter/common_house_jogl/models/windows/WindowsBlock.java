package org.rumter.common_house_jogl.models.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

/**
 * Блок из двух окон
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class WindowsBlock extends Window {
	/**
	 * отступ слева и справа
	 */
	protected static final float a = 0.20f;
	/**
	 * ширина подоконника
	 */
	protected static final float b = 0.20f;
	/**
	 * высота подоконника
	 */
	protected static final float c = 0.05f;
	/**
	 * длина перегородки между окнами
	 */
	protected static final float d = 0.10f;
	/**
	 * высота блока
	 */
	protected static final float h = Window3.h + c;
	/**
	 * длина блока
	 */
	protected static final float l = Window3.l * 2 + a * 2 + d;

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

	public WindowsBlock(float x, float y, float z) {
		super(x, y, z);

		window1 = new Window3(x + a, y + c, z);
		window2 = new Window3(x + l - a - Window3.l, y + c, z);
	}

	/**
	 * окна
	 */
	protected Window3 window1, window2;

	/**
	 * рисуем отступы
	 */
	protected void drawIndents() {
		App.TexUtils.prepareForDisplay("indent");
		DrawUtils.drawRectangleTex(new Point(x, y + c, z), new Point(a, 0, 0),
				new Point(0, (h - c), 0), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + l - a, y + c, z), new Point(a,
				0, 0), new Point(0, (h - c), 0), DrawUtils.TEXTURE_MODE_REPEAT);
	}

	/**
	 * рисуем перегородку между окнами
	 */
	protected void drawSeparator() {
		App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(new Point(x + a + Window3.l, y + c, z),
				new Point(d, 0, 0), new Point(0, (h - c), 0),
				DrawUtils.TEXTURE_MODE_REPEAT);
	}

	/**
	 * рисуем подоконник
	 */
	protected void drawSill() {
		App.TexUtils.prepareForDisplay("window");
		DrawUtils.drawRectangleTex(new Point(x + a, y, z + b), new Point(l - a
				* 2f, 0, 0), new Point(0, 0, -b - b),
				DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + a, y + c, z + b), new Point(l
				- a * 2f, 0, 0), new Point(0, 0, -b - b),
				DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + a, y, z + b), new Point(0, c,
				0), new Point(-b - b, 0, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + l - a, y, z + b), new Point(0,
				c, 0), new Point(-b - b, 0, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + a, y, z + b), new Point(l - a
				* 2f, 0, 0), new Point(0, c, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + a, y, z - b - b), new Point(l
				- a * 2f, 0, 0), new Point(0, c, 0),
				DrawUtils.TEXTURE_MODE_REPEAT);
	}

	@Override
	public void display() {
		// отступы
		drawIndents();
		// перегородка между окнами
		drawSeparator();
		// окна
		window1.display();
		window2.display();
		// подоконник
		drawSill();
	}
}
