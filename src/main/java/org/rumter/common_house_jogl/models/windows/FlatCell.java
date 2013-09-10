package org.rumter.common_house_jogl.models.windows;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.models.SimpleModel;
import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

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

	protected final Window factoryWindow(Class<?> c) {
		if (c == WindowsBlock.class) {
			return new WindowsBlock(x, y + blueLineH, z);
		} else if (c == WashRoomWindow.class) {
			return new WashRoomWindow(x, y + blueLineH, z);
		} else if (c == MainStairsWindow.class) {
			isMainStairsWindow = true;
			return new MainStairsWindow(x, y, z);
		} else if (c == BlackStairsWindow.class) {
			return new BlackStairsWindow(x, y + blueLineH, z);
		}
		return null;
	}

	public FlatCell(float x, float y, float z, Class<?> c) {
		super(x, y, z);

		this.w = factoryWindow(c);
		this.l = w.getL();
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
	public void drawBlueLine() {
		if (!isMainStairsWindow) {
			if (y >= FlatCell.h) {
				App.TexUtils.prepareForDisplay("blueLine");
			} else {
				App.TexUtils.prepareForDisplay("blueLineBottom");
			}
			DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(l, 0, 0),
					new Point(0, blueLineH, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		}
	}

	/**
	 * нарисовать белую полосу
	 */
	public void drawWhiteLine() {
		// if ( ! isMainStairsWindow) {
		App.TexUtils.prepareForDisplay("whiteLine");
		DrawUtils.drawRectangleTex(new Point(x, y + h - whiteLineH, z),
				new Point(l, 0, 0), new Point(0, whiteLineH, 0),
				DrawUtils.TEXTURE_MODE_REPEAT);
		// }
	}

	@Override
	public void display() {
		w.display();
		drawBlueLine();
		drawWhiteLine();
	}
}
