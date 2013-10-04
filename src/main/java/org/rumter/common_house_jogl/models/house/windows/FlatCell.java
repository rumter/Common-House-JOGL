package org.rumter.common_house_jogl.models.house.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;
import org.rumter.common_house_jogl.framework.model.base.SimpleModel;

/**
 * ячейка этажа
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class FlatCell extends SimpleModel {
	/**
	 * высота синей полосы
	 */
	public static final float blueLineH = 1.0f;
	/**
	 * высота белой полосы
	 */
	public static final float whiteLineH = 0.20f;
	/**
	 * высота
	 */
	public static final float h = WindowsBlock.h + blueLineH;

	protected final Window factoryWindow(Class<?> c, float stepZ) {
		if (c == WindowsBlock.class) {
			return new WindowsBlock(x, y + blueLineH, z, stepZ);
		} else if (c == WashRoomWindow.class) {
			return new WashRoomWindow(x, y + blueLineH, z, stepZ);
		} else if (c == MainStairsWindow.class) {
			isMainStairsWindow = true;
			return new MainStairsWindow(x, y, z);
		} else if (c == BlackStairsWindow.class) {
			return new BlackStairsWindow(x, y + blueLineH, z, stepZ);
		}
		return null;
	}

	public FlatCell(float x, float y, float z, Class<?> c, float stepZ) {
		super(x, y, z);

		this.w = factoryWindow(c, stepZ);
		this.l = w.getL();
		blueLine = new Quad(new Point(x, y, z), new Point(l, 0, 0), new Point(
				0, blueLineH, 0));
		whiteLine = new Quad(new Point(x, y + h - whiteLineH, z), new Point(l,
				0, 0), new Point(0, whiteLineH, 0));
	}

	protected boolean isMainStairsWindow = false;
	/**
	 * длина
	 */
	protected float l;
	/**
	 * окно
	 */
	protected Window w;

	/**
	 * нарисовать синюю полосу
	 */
	protected Quad blueLine;

	public void drawBlueLine() {
		if (!isMainStairsWindow) {
			if (y >= FlatCell.h) {
				App.texUtils.prepareForDisplay("house/blueLine");
			} else {
				App.texUtils.prepareForDisplay("house/blueLineBottom");
			}
			App.drawUtils.drawQuadTex(blueLine);
		}
	}

	/**
	 * нарисовать белую полосу
	 */
	protected Quad whiteLine;

	public void drawWhiteLine() {
		// if ( ! isMainStairsWindow) {
		App.texUtils.prepareForDisplay("house/whiteLine");
		App.drawUtils.drawQuadTex(whiteLine);
		// }
	}

	@Override
	public void display() {
		w.display();
		drawBlueLine();
		drawWhiteLine();
	}
}
