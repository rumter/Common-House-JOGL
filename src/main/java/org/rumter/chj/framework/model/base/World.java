package org.rumter.chj.framework.model.base;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.framework.model.primitives.PlaneWall;

public abstract class World extends SimpleModel {

	protected List<PlaneWall> walls;

	public World(float x, float y, float z) {
		super(x, y, z);
		loadTextures();
		walls = new ArrayList<PlaneWall>();
	}

	protected abstract void loadTextures();

	public List<PlaneWall> getWalls() {
		return walls;
	}

}
