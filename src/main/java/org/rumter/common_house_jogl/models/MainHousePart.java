package org.rumter.common_house_jogl.models;

import java.util.ArrayList;

import org.rumter.common_house_jogl.models.windows.BlackStairsWindow;
import org.rumter.common_house_jogl.models.windows.FlatCell;
import org.rumter.common_house_jogl.models.windows.MainStairsWindow;
import org.rumter.common_house_jogl.models.windows.WashRoomWindow;
import org.rumter.common_house_jogl.models.windows.WindowsBlock;

/**
 * Жилая часть общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
class MainHousePart extends SimpleModel {
	/**
	 * длина границы
	 */
	private static final float borderL = 0.60f;
	/**
	 * длина разделителя
	 */
	private static final float separatorL = 0.40f;
	/**
	 * ширина границы
	 */
	private static final float borderW = 8f;

	/**
	 * получить несколько этажей
	 */
	private ArrayList<Model> getFlats(Class<?> c, int count, float x, float y,
			float z) {
		ArrayList<Model> ret = new ArrayList<Model>();
		for (int i = 0; i < count; ++i) {
			ret.add(new FlatCell(x, y + FlatCell.h * i, z, c));
		}
		return ret;
	}

	public MainHousePart(float x, float y, float z) {
		super(x, y, z);

		models = new ArrayList<Model>();

		float flatH = FlatCell.h;

		float step = separatorL + WindowsBlock.getsL();
		float sep = separatorL;
		float w1 = WindowsBlock.getsL();
		float w2 = BlackStairsWindow.getsL();

		models.add(new BricksBlock(x, y + flatH, z + sep, borderL, -borderW
				- sep, 9 * flatH));
		models.add(new BricksBlock(x, y + flatH, z + sep - borderW - 1f,
				borderL, -borderW - sep, 9 * flatH));
		models.add(new BricksBlock(x + 0.3f, y + flatH,
				z + sep - borderW + sep, borderL, -borderW - sep, 9 * flatH));

		models.add(new BricksBlock(x + borderL + 9 * step + w2, y, z + sep,
				borderL, -borderW - sep, 10 * flatH));
		models.add(new BricksBlock(x + borderL + 9 * step + w2, y, z + sep
				- borderW - 1f, borderL, -borderW - sep, 10 * flatH));
		models.add(new BricksBlock(x + borderL + 9 * step + w2 - 0.3f, y, z
				+ sep - borderW + sep, borderL, -borderW - sep, 10 * flatH));

		for (int i = 1; i <= 3; ++i) {
			models.add(new BricksBlock(x + borderL + i * w1 + (i - 1) * sep, y
					+ flatH, z + sep, sep, -separatorL - borderW - 1f - borderW
					- separatorL, 9 * flatH));
		}
		for (int i = 4; i <= 9; ++i) {
			models.add(new BricksBlock(x + borderL + i * w1 + (i - 1) * sep, y,
					z + sep, sep, -separatorL - borderW - 1f - borderW
							- separatorL, 10 * flatH));
		}

		Class<?>[] cls = { WashRoomWindow.class, WindowsBlock.class,
				WindowsBlock.class, MainStairsWindow.class, WindowsBlock.class,
				WindowsBlock.class, WindowsBlock.class, WindowsBlock.class,
				WindowsBlock.class, BlackStairsWindow.class };
		for (int i = 0; i < cls.length; ++i) {
			int number = (i <= 3 ? 9 : 10);
			float h = (i <= 3 ? flatH : 0);
			Class<?> c = (i == cls.length - 1 ? cls[i] : WindowsBlock.class);
			models.addAll(getFlats(cls[i], number, x + borderL + step * i, y
					+ h, z));
			models.addAll(getFlats(c, number, x + borderL + step * i, y + h, z
					- borderW - 1f - borderW));
		}

		// окна на левой стороне корпуса
		// окна на правой стороне корпуса
		// границы дома
	}

	/**
	 * модели для рисования
	 */
	private ArrayList<Model> models;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
		// рисуем границы дома
		// рисуем бетонные полосы и синий низ
	}
}