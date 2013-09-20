package org.rumter.common_house_jogl.models.house;

import java.util.ArrayList;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.framework.draw.TextureUtils.TextureMode;
import org.rumter.common_house_jogl.framework.geom.Point;
import org.rumter.common_house_jogl.framework.geom.Quad;
import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.models.base.SimpleModel;
import org.rumter.common_house_jogl.models.house.windows.FlatCell;
import org.rumter.common_house_jogl.models.house.windows.Window3;
import org.rumter.common_house_jogl.models.primitives.Block;

/**
 * Вход и столовая
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
class BottomHousePart extends SimpleModel {
	/**
	 * длина
	 */
	public static final float wx = 29.3f;
	/**
	 * ширина
	 */
	public static final float wz = 22f;
	/**
	 * высота
	 */
	public static final float h = FlatCell.h;
	/**
	 * отступы
	 */
	private static final float ax = 1.5f, az = 3, bz = 1.5f, h1 = 0.40f,
			h2 = 0.5f, w1 = 0.3f, w2 = 3f;
	/**
	 * колонны
	 */
	private static Point p1, p2, p3;

	public BottomHousePart(float x, float y, float z) {
		super(x, y, z);

		models = new ArrayList<Model>();

		// фундамент и крыша
		models.add(new Block(x - ax, y, z + az, wx, -wz, h1, "beton"));
		models.add(new Block(x - ax, y + h - h1, z + az, wx, -wz, h2, "kr1"));

		// здание
		models.add(new Block(x, y + h1, z, wx - ax, -wz + az + bz, h - h1,
				"build1"));
		models.add(new Block(x + wx - ax - w1, y, z, w1, w2, h - h2 + 0.1f,
				"build2"));

		// колонны
		p1 = new Point(x + 2f, y + h1, z + 1f);
		p2 = new Point(x + 9f, y + h1, z + 1f);
		p3 = new Point(x + 18f, y + h1, z + 1f);

		// окна
		models.add(new Window3(x + 4f, y + h1 + 0.2f, z, 0.01f));
		models.add(new Window3(x + 20f, y + h1 + 0.2f, z, 0.01f));

		// дверь
		doorQuad = new Quad(new Point(x + 12f, y + h1, z + 0.01f), new Point(0,
				2.5f, 0.01f), new Point(4f, 0, 0.01f));

		// табличка над общагой
		titleQuad = new Quad(new Point(x + 10.5f, y + h - h1 + 0.05f, z + az
				+ 0.01f), new Point(0, h1, 0), new Point(6f, 0, 0));
	}

	private ArrayList<Model> models;

	private Quad doorQuad, titleQuad;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
		App.texUtils.prepareForDisplay("doors");
		App.drawUtils.drawQuadTex(doorQuad, TextureMode.STRETCH);
		App.texUtils.prepareForDisplay("title8");
		App.drawUtils.drawQuadTex(titleQuad, TextureMode.STRETCH);
		App.texUtils.prepareForDisplay("cylinder");
		App.drawUtils.drawCylinder(p1, 0.5f, h - h1 - h2 + 0.2f);
		App.drawUtils.drawCylinder(p2, 0.5f, h - h1 - h2 + 0.2f);
		App.drawUtils.drawCylinder(p3, 0.5f, h - h1 - h2 + 0.2f);
	}
}