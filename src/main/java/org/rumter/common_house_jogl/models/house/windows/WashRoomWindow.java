package org.rumter.common_house_jogl.models.house.windows;

import java.util.ArrayList;
import java.util.List;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;
import org.rumter.common_house_jogl.geom.Quad;
import org.rumter.common_house_jogl.utils.DrawUtils;

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

	public WashRoomWindow(float x, float y, float z, float stepZ) {
		super(x, y, z, stepZ);

		quads = new ArrayList<Quad>();
		quadTex = new ArrayList<String>();
		generateQuads(x + a, y + c, z);
		generateQuads(x + l - Window3.l - a, y + c, z);
	}

	/**
	 * нарисовать окно
	 */
	private List<Quad> quads;
	private List<String> quadTex;

	private void generateQuads(float x, float y, float z) {// всё окно
		quadTex.add("window");
		quads.add(new Quad(new Point(x, y, z), new Point(Window3.l, 0, 0),
				new Point(0, Window3.h, 0)));
		float quadLineW = 0.01f;
		for (int i = 0; i < countH; ++i) {
			for (int j = 0; j < countG; ++j) {
				float xi = x + Window3.w2 + j * qw;
				float yi = y + Window3.w1 + i * qh;
				quadTex.add("quadBg");
				quads.add(new Quad(new Point(xi, yi, z), new Point(qw, 0, 0),
						new Point(0, qh, 0)).moveZ(0.01f));
			}
		}
		for (int i = 0; i < countH; ++i) {
			for (int j = 0; j < countG; ++j) {
				float xi = x + Window3.w2 + j * qw;
				float yi = y + Window3.w1 + i * qh;
				quadTex.add("quad");
				quads.add(new Quad(
						new Point(xi + quadLineW, yi + quadLineW, z),
						new Point(qw - quadLineW - quadLineW, 0, 0), new Point(
								0, qh - quadLineW - quadLineW, 0)).moveZ(0.02f));
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
		for (int i = 0; i < quads.size(); ++i) {
			App.texUtils.prepareForDisplay(quadTex.get(i));
			App.drawUtils.drawQuadTex(quads.get(i),
					DrawUtils.TEXTURE_MODE_REPEAT);
		}
		// подоконник
		drawSill();
	}
}
