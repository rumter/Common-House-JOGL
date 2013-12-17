package org.rumter.chj.models.StudentCity;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureSet;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.base.World;
import org.rumter.chj.framework.model.primitives.SimpleModelContainer;
import org.rumter.chj.framework.model.primitives.SkyBox;
import org.rumter.chj.models.StudentCity.fence.FenceSet;
import org.rumter.chj.models.StudentCity.ground.Ground;
import org.rumter.chj.models.StudentCity.ground.HozCorp;
import org.rumter.chj.models.StudentCity.ground.TreeSet;
import org.rumter.chj.models.StudentCity.house.CorpSet;

/**
 * студенческий городок
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class StudentCity extends World {

	private Ground ground;
	private HozCorp hozCorp;
	private FenceSet fenceSet;
	private CorpSet corpSet;
	private TreeSet treeSet;
	// private KlumbSet klumbSet;
	private SkyBox skybox;
	private SimpleModelContainer simpleModelContainer;

	public StudentCity(float x, float y, float z) {
		super(x, y, z);

		ground = new Ground(x, y, z);
		hozCorp = new HozCorp(x, y, z);

		simpleModelContainer = new SimpleModelContainer();

		fenceSet = new FenceSet(x, y, z);
		corpSet = new CorpSet(x, y, z);
		treeSet = new TreeSet(x, y, z);
		// klumbSet = new KlumbSet(x, y, z);
		skybox = new SkyBox(new Point(-250, 0, 100), 300, "sky/skybox1");

		simpleModelContainer.addAll(fenceSet.getFences());
		simpleModelContainer.addAll(corpSet.getCorps());
		simpleModelContainer.add(hozCorp);
		// simpleModelContainer.addAll(klumbSet.getKlumbs());
		simpleModelContainer.addAll(treeSet.getTrees());
	}

	@Override
	public void display() {
		skybox.display();
		ground.display();
		simpleModelContainer.display();
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

		ts.folder("sky");
		ts.add(new String[] { "skybox1" });

		ts.folder("ground");
		ts.add(new String[] { "ground_1", "asphalt_1", "asphalt_25", "track1", "track_side", "fund_side",
				"fund_top", "klumb_side", "klumb_top", "black", "fence_side", "fence_top", "green", "tree",
				"white_brick", "hozcs" });

		App.texUtils.loadTexures(ts);
	}

}
