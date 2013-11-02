package org.rumter.chj.models.ExampleWorld;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureSet;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.World;
import org.rumter.chj.framework.model.primitives.Block;
import org.rumter.chj.framework.model.primitives.PlaneWall;

public class ExampleWorld extends World {

	private Quad ground;
	private Block house;
	// комент для теста коммита
	public ExampleWorld(float x, float y, float z) {
		super(x, y, z);

		ground = new Quad(new Point(x - 1000, y, z - 1000), new Point(2000, 0, 0), new Point(0, 0, 2000));
		house = new Block(x, y, z, 10, 10, 10, "example/metal");

		walls.add(new PlaneWall(x, z, x, z + 10, 10));
		walls.add(new PlaneWall(x + 10, z, x + 10, z + 10, 10));
		walls.add(new PlaneWall(x, z, x + 10, z, 10));
		walls.add(new PlaneWall(x, z + 10, x + 10, z + 10, 10));
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("example/asphalt");
		App.drawUtils.drawQuadTex(ground);

		house.display();
	}

	@Override
	protected void loadTextures() {
		TextureSet ts = new TextureSet();

		ts.globalFolder("ExampleWorld");

		ts.folder("example");
		ts.add(new String[] { "asphalt", "metal" });
		
		ts.folder("axis");
		ts.add(new String[] { "metal" });

		App.texUtils.loadTexures(ts);
	}

}
