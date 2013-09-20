package org.rumter.common_house_jogl.models.house;

import java.util.ArrayList;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;
import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.models.base.SimpleModel;
import org.rumter.common_house_jogl.models.house.windows.BlackStairsWindow;
import org.rumter.common_house_jogl.models.house.windows.FlatCell;
import org.rumter.common_house_jogl.models.house.windows.WindowsBlock;
import org.rumter.common_house_jogl.models.primitives.BricksBlock;

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
	/*
	 * private ArrayList<Model> getFlats(Class<?> c, int count, float x, float
	 * y, float z, float stepZ) { ArrayList<Model> ret = new ArrayList<Model>();
	 * for (int i = 0; i < count; ++i) { ret.add(new FlatCell(x, y + FlatCell.h
	 * * i, z, c, stepZ)); } return ret; }
	 */

	public MainHousePart(float x, float y, float z) {
		super(x, y, z);

		bricks = new ArrayList<BricksBlock>();
		washRoomsWindows = new ArrayList<Quad>();
		blackStairsWindows = new ArrayList<Quad>();
		blackStairsBottomWindows = new ArrayList<Quad>();
		mainStairsWindows = new ArrayList<Quad>();
		blockWindows = new ArrayList<Quad>();
		blockBottomWindows = new ArrayList<Quad>();

		float flatH = FlatCell.h;

		float step = separatorL + WindowsBlock.getsL();
		float sep = separatorL;
		float w1 = WindowsBlock.getsL();
		float w2 = BlackStairsWindow.getsL();

		bricks.add(new BricksBlock(x, y + flatH, z + sep, borderL, -borderW - sep, 9 * flatH));
		bricks.add(new BricksBlock(x, y + flatH, z + sep - borderW - 1f, borderL, -borderW - sep, 9 * flatH));
		bricks.add(new BricksBlock(x + 0.3f, y + flatH, z + sep - borderW + sep, borderL, -borderW - sep, 9 * flatH));

		bricks.add(new BricksBlock(x + borderL + 9 * step + w2, y, z + sep, borderL, -borderW - sep, 10 * flatH));
		bricks.add(new BricksBlock(x + borderL + 9 * step + w2, y, z + sep - borderW - 1f, borderL, -borderW - sep,
				10 * flatH));
		bricks.add(new BricksBlock(x + borderL + 9 * step + w2 - 0.3f, y, z + sep - borderW + sep, borderL, -borderW
				- sep, 10 * flatH));

		for (int i = 1; i <= 3; ++i) {
			bricks.add(new BricksBlock(x + borderL + i * w1 + (i - 1) * sep, y + flatH, z + sep, sep, -separatorL
					- borderW - 1f - borderW - separatorL, 9 * flatH));
		}
		for (int i = 4; i <= 9; ++i) {
			bricks.add(new BricksBlock(x + borderL + i * w1 + (i - 1) * sep, y, z + sep, sep, -separatorL - borderW
					- 1f - borderW - separatorL, 10 * flatH));
		}

		/*
		 * Расчёт координат всех элементов окон
		 * 
		 * Class<?>[] cls = { WashRoomWindow.class, WindowsBlock.class,
		 * WindowsBlock.class, MainStairsWindow.class, WindowsBlock.class,
		 * WindowsBlock.class, WindowsBlock.class, WindowsBlock.class,
		 * WindowsBlock.class, BlackStairsWindow.class }; for (int i = 0; i <
		 * cls.length; ++i) { int number = (i <= 3 ? 9 : 10); float h = (i <= 3
		 * ? flatH : 0); Class<?> c = (i == cls.length - 1 ? cls[i] :
		 * WindowsBlock.class); models.addAll(getFlats(cls[i], number, x +
		 * borderL + step * i, y + h, z, 0.01f)); models.addAll(getFlats(c,
		 * number, x + borderL + step * i, y + h, z - borderW - 1f - borderW,
		 * -0.01f)); }
		 */

		Point vh1 = new Point(0, flatH, 0);
		Point vh9 = new Point(0, flatH * 9, 0);
		Point vw = new Point(w1, 0, 0);
		Point vw2 = new Point(w2, 0, 0);

		float backZ = z - borderW - 1f - borderW;

		washRoomsWindows.add(new Quad(new Point(x + borderL, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL, y + flatH, backZ), vh9, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step, y + flatH, backZ), vh9, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 2, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 2, y + flatH, backZ), vh9, vw));

		mainStairsWindows.add(new Quad(new Point(x + borderL + step * 3, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 3, y + flatH, backZ), vh9, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 4, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 4, y + flatH, backZ), vh9, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 4, y, z), vh1, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 4, y, backZ), vh1, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 5, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 5, y + flatH, backZ), vh9, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 5, y, z), vh1, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 5, y, backZ), vh1, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 6, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 6, y + flatH, backZ), vh9, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 6, y, z), vh1, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 6, y, backZ), vh1, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 7, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 7, y + flatH, backZ), vh9, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 7, y, z), vh1, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 7, y, backZ), vh1, vw));

		blockWindows.add(new Quad(new Point(x + borderL + step * 8, y + flatH, z), vh9, vw));
		blockWindows.add(new Quad(new Point(x + borderL + step * 8, y + flatH, backZ), vh9, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 8, y, z), vh1, vw));
		blockBottomWindows.add(new Quad(new Point(x + borderL + step * 8, y, backZ), vh1, vw));

		blackStairsWindows.add(new Quad(new Point(x + borderL + step * 9, y + flatH, z), vh9, vw2));
		blackStairsWindows.add(new Quad(new Point(x + borderL + step * 9, y + flatH, backZ), vh9, vw2));
		blackStairsBottomWindows.add(new Quad(new Point(x + borderL + step * 9, y, z), vh1, vw2));
		blackStairsBottomWindows.add(new Quad(new Point(x + borderL + step * 9, y, backZ), vh1, vw2));

	}

	/**
	 * модели для рисования
	 */
	private ArrayList<BricksBlock> bricks;
	private ArrayList<Quad> washRoomsWindows;
	private ArrayList<Quad> blackStairsWindows;
	private ArrayList<Quad> blackStairsBottomWindows;
	private ArrayList<Quad> mainStairsWindows;
	private ArrayList<Quad> blockWindows;
	private ArrayList<Quad> blockBottomWindows;

	@Override
	public void display() {
		for (Model m : bricks) {
			m.display();
		}
		App.texUtils.prepareForDisplay("WashRoomWindow");
		for (Quad q : washRoomsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("BlackStairsWindow");
		for (Quad q : blackStairsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("BlackStairsWindow2");
		for (Quad q : blackStairsBottomWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 1);
		}
		App.texUtils.prepareForDisplay("MainStairsWindow");
		for (Quad q : mainStairsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("WindowsBlock");
		for (Quad q : blockWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("WindowsBlock2");
		for (Quad q : blockBottomWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 1);
		}
	}
}