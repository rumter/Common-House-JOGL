package org.rumter.common_house_jogl.models;

import java.awt.Color;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;
import org.rumter.common_house_jogl.geom.Quad;
import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.models.base.SimpleModel;
import org.rumter.common_house_jogl.models.house.House;

/**
 * карта
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Map extends SimpleModel {

	private float mapSize = 1000;

	private Quad ground;

	private Model house;

	public Map(float x, float y, float z) {
		super(x, y, z);
		ground = new Quad(new Point(-mapSize, -mapSize), new Point(0, mapSize
				+ mapSize), new Point(mapSize + mapSize, 0));
		house = new House(x - 4.4f, y, z - 145.2f);
		walls = house.getWalls();
		App.lightManager.initLight0(new Point(x, y, z));
		// App.shadowManager.initShadowMatrix(App.lightManager.getPosition0());
	}

	@Override
	public void display() {
		/*
		 * App.shadowManager.beginDrawShadow(); drawScene();
		 * App.shadowManager.endDrawShadow();
		 */
		drawScene();
	}

	private void drawScene() {
		App.lightManager.display0();
		house.display();
		if (!App.shadowManager.isShadowMode()) {
			App.texUtils.prepareForDisplay("window");
			App.drawUtils.drawQuad(Color.white, ground);
		}
	}

}