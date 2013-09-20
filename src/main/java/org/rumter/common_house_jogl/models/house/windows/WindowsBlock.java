package org.rumter.common_house_jogl.models.house.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;

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

	public WindowsBlock(float x, float y, float z, float stepZ) {
		super(x, y, z);

		window1 = new Window3(x + a, y + c, z, stepZ);
		window2 = new Window3(x + l - a - Window3.l, y + c, z, stepZ);

		indent1 = new Quad(new Point(x, y + c, z), new Point(a, 0, 0),
				new Point(0, (h - c), 0));
		indent2 = new Quad(new Point(x + l - a, y + c, z), new Point(a, 0, 0),
				new Point(0, (h - c), 0));

		separator = new Quad(new Point(x + a + Window3.l, y + c, z), new Point(
				d, 0, 0), new Point(0, (h - c), 0));

		sillQuads = new Quad[] {
				new Quad(new Point(x + a, y, z + b),
						new Point(l - a * 2f, 0, 0), new Point(0, 0, -b - b)),
				new Quad(new Point(x + a, y + c, z + b), new Point(l - a * 2f,
						0, 0), new Point(0, 0, -b - b)),
				new Quad(new Point(x + a, y, z + b), new Point(0, c, 0),
						new Point(-b - b, 0, 0)),
				new Quad(new Point(x + l - a, y, z + b), new Point(0, c, 0),
						new Point(-b - b, 0, 0)),
				new Quad(new Point(x + a, y, z + b),
						new Point(l - a * 2f, 0, 0), new Point(0, c, 0)),
				new Quad(new Point(x + a, y, z - b - b), new Point(l - a * 2f,
						0, 0), new Point(0, c, 0)) };
	}

	/**
	 * окна
	 */
	protected Window3 window1, window2;

	/**
	 * рисуем отступы
	 */
	protected Quad indent1, indent2;

	protected void drawIndents() {
		App.texUtils.prepareForDisplay("indent");
		App.drawUtils.drawQuadTex(indent1);
		App.drawUtils.drawQuadTex(indent2);
	}

	/**
	 * рисуем перегородку между окнами
	 */
	protected Quad separator;

	protected void drawSeparator() {
		App.texUtils.prepareForDisplay("window");
		App.drawUtils.drawQuadTex(separator);
	}

	/**
	 * рисуем подоконник
	 */
	protected Quad[] sillQuads;

	protected void drawSill() {
		App.texUtils.prepareForDisplay("window");
		for (int i = 0; i < sillQuads.length; ++i) {
			App.drawUtils.drawQuadTex(sillQuads[i]);
		}
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
