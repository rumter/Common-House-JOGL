package org.rumter.chj.models.StudentCity.house;

import java.util.ArrayList;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureUtils.TextureMode;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.Model;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;
import org.rumter.chj.framework.model.primitives.Cylinder;

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
	public static final float h = 3.05f;
	/**
	 * отступы
	 */
	private static final float ax = 1.5f, az = 3, bz = 1.5f, h1 = 0.40f, h2 = 0.5f, w1 = 0.4f, w2 = 3f;
	/**
	 * колонны
	 */
	private Cylinder c1, c2, c3;

	public BottomHousePart(float x, float y, float z, int type) {
		super(x, y, z);

		models = new ArrayList<Model>();

		Block block;

		// фундамент и крыша
		float startX = (type == 1 ? x - ax : x - w1);
		block = new Block(startX, y, z + az, wx, -wz, h1);
		block.setSideTexture("house/beton");
		models.add(block);
		block = new Block(startX, y + h - h1, z + az, wx, -wz, h2);
		block.setSideTexture("house/kr1");
		models.add(block);

		// здание
		block = new Block(x, y + h1, z, wx - ax, -wz + az + bz, h - h1);
		block.setSideTexture("house/build1");
		models.add(block);
		if (type == 1) {
			block = new Block(x + wx - ax - w1, y, z, w1, w2, h - h2 + 0.1f);
			block.setSideTexture("house/build2");
			models.add(block);
		} else {
			block = new Block(x - w1, y, z, w1, w2, h - h2 + 0.1f);
			block.setSideTexture("house/build2");
			models.add(block);
		}

		// колонны
		c1 = new Cylinder(x + 2f, y + h1, z + 1f, 0.5f, h - h1 - h2 + 0.2f, -90, 0);
		c2 = new Cylinder(x + 9f, y + h1, z + 1f, 0.5f, h - h1 - h2 + 0.2f, -90, 0);
		c3 = new Cylinder(x + 18f, y + h1, z + 1f, 0.5f, h - h1 - h2 + 0.2f, -90, 0);
		c1.setSideTexture("house/cylinder");
		c2.setSideTexture("house/cylinder");
		c3.setSideTexture("house/cylinder");

		// окна
		win1Quad = new Quad(new Point(x + 4f, y + h1 + 0.2f, z), new Point(0, 2, 0), new Point(3, 0, 0)).moveZ(0.01f);
		win2Quad = new Quad(new Point(x + 20f, y + h1 + 0.2f, z), new Point(0, 2, 0), new Point(3, 0, 0)).moveZ(0.01f);

		// дверь
		doorQuad = new Quad(new Point(x + 12f, y + h1, z + 0.01f), new Point(0, 2.5f, 0), new Point(4f, 0, 0));

		// табличка над общагой
		titleQuad = new Quad(new Point(x + 10.5f, y + h - h1 + 0.05f, z + az + 0.01f), new Point(0, h1, 0), new Point(
				6f, 0, 0));
	}

	private ArrayList<Model> models;

	private Quad doorQuad, titleQuad, win1Quad, win2Quad;

	@Override
	public void display() {
		for (Model m : models) {
			m.display();
		}
		App.texUtils.prepareForDisplay("house/doors");
		App.drawUtils.drawQuadTex(doorQuad, TextureMode.STRETCH);
		App.texUtils.prepareForDisplay("house/title8");
		App.drawUtils.drawQuadTex(titleQuad, TextureMode.STRETCH);
		c1.display();
		c2.display();
		c3.display();
		App.texUtils.prepareForDisplay("house/SimpleWindows");
		App.drawUtils.drawQuadTex(win1Quad, TextureMode.STRETCH);
		App.drawUtils.drawQuadTex(win2Quad, TextureMode.STRETCH);
	}
}