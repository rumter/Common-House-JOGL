package org.rumter.chj.models.StudentCity;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureSet;
import org.rumter.chj.framework.model.base.World;
import org.rumter.chj.models.StudentCity.fence.Fence;
import org.rumter.chj.models.StudentCity.ground.Ground;
import org.rumter.chj.models.StudentCity.ground.TreeSet;
import org.rumter.chj.models.StudentCity.house.CorpSet;

/**
 * карта
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class StudentCity extends World {

	private Ground ground;
	private Fence fence;
	private CorpSet corpSet;
	private TreeSet treeSet;

	public StudentCity(float x, float y, float z) {
		super(x, y, z);
		ground = new Ground(x, y, z);
		fence = new Fence(x, y, z);
		corpSet = new CorpSet(x, y, z);
		treeSet = new TreeSet(x, y, z);
	}

	@Override
	public void display() {
		ground.display();
		fence.display();
		corpSet.display();
		treeSet.display();
	}

	@Override
	protected void loadTextures() {
		TextureSet ts = new TextureSet();

		ts.globalFolder("StudentCity");

		ts.folder("house");
		ts.add(new String[] { "bricks", "kr1", "beton", "build1", "build2", "houseTop", "betonLine", "doors", "title8",
				"cylinder", "WashRoomWindow", "MainStairsWindow", "WindowsBlock", "WindowsBlock2", "BlackStairsWindow",
				"BlackStairsWindow2", "SimpleWindows" });

		ts.folder("axis");
		ts.add(new String[] { "metal" });

		ts.folder("ground");
		ts.add(new String[] { "ground", "ground_1", "asphalt_1", "asphalt_25", "track1", "fund_side", "fund_top",
				"urn_side", "urn_top", "black", "fence_side", "fence_top", "green", "tree" });

		App.texUtils.loadTexures(ts);
	}

}