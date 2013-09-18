package org.rumter.common_house_jogl.models.house.windows;

import java.util.ArrayList;
import java.util.List;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;
import org.rumter.common_house_jogl.geom.Quad;

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
	private static final int countH = 3;
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

		quads = new ArrayList<Quad>();
		quadTex = new ArrayList<String>();

		quadTex.add("window");
		quads.add(new Quad(new Point(x, y, z), new Point(l, 0, 0), new Point(0,
				h, 0)));
		for (int i = 0; i < countL; ++i)
			for (int j = 0; j < countH; ++j)
				generateQuads(x + i * qw, y + j * qh, z, 1 - (i + j) % 2);
	}

	private List<Quad> quads;
	private List<String> quadTex;

	private void generateQuads(float x, float y, float z, int type) {
		quadTex.add("window");
		quads.add(new Quad(new Point(x, y, z), new Point(qw, 0, 0), new Point(
				0, qh, 0)));
		quadTex.add("glass");
		quads.add(new Quad(new Point(x + ql, y + ql, z), new Point(
				qw - ql - ql, 0, 0), new Point(0, qh - ql - ql, 0)).moveZ(0.01f));
		float cx = (qw - ql * 3f) / 2f;
		float cy = (qh - ql * 3f) / 2f;
		quadTex.add("window");
		if (type == 1) {
			quads.add(new Quad(new Point(x + ql + cx, y + ql, z), new Point(ql,
					0, 0), new Point(0, qh - ql - ql, 0)).moveZ(0.02f));
		} else {
			quads.add(new Quad(new Point(x + ql, y + ql + cy, z), new Point(qw
					- ql - ql, 0, 0), new Point(0, ql, 0)).moveZ(0.02f));
		}
	}

	@Override
	public void display() {
		for (int i = 0; i < quads.size(); ++i) {
			App.texUtils.prepareForDisplay(quadTex.get(i));
			App.drawUtils.drawQuadTex(quads.get(i));
		}
	}
}
