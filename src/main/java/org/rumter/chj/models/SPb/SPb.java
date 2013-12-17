package org.rumter.chj.models.SPb;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.tex.TextureSet;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.World;
import org.rumter.chj.framework.model.primitives.Block;
import org.rumter.chj.framework.model.primitives.Cylinder;

public class SPb extends World {

	private Quad ground;
	private Block house;
	private Block kub;
	private Block stup1;
	private Block stup2;
	private Block stup3;
	private Block stup4;
	private Cylinder kolon1;
	private Cylinder kolon2;
	private Cylinder kolon3;
	private Cylinder kolon4;
	private Cylinder kolon5;
	private Cylinder kolon6;
	private Cylinder kolon7;
	private Cylinder kolon8;
	private Cylinder kolon9;
	private Cylinder kolon10;
	private Cylinder kolon11;
	private Cylinder kolon12;
	private Cylinder kolon13;
	private Cylinder kolon14;
	private Cylinder kolon15;
	private Cylinder kolon16;
	// комент для теста коммита
	public SPb(float x, float y, float z) {
		super(x, y, z);

		ground = new Quad(new Point(x - 1000, y, z - 1000), new Point(2000, 0, 0), new Point(0, 0, 2000));
		//house = new Block(x, y, z, 10, 10, 10);
		//house.setSideTexture("example/metal");

		//walls.add(new PlaneWall(x, z, x, z + 10, 10));
		//walls.add(new PlaneWall(x + 10, z, x + 10, z + 10, 10));
		//walls.add(new PlaneWall(x, z, x + 10, z, 10));
		//walls.add(new PlaneWall(x, z + 10, x + 10, z + 10, 10));
		
		
		//понеслось
		kub = new Block(x, 4, z, 45, 85, 30);
		//ступеньки
		stup1 = new Block(-4, y, -9, 53, 103, 1);
		stup2 = new Block(-3, 1, -8, 51, 101, 1);
		stup3 = new Block(-2, 2, -7, 49, 99, 1);
		stup4 = new Block(-1, 3, -6, 47, 97, 1);
		stup1.setSideTexture("example/stup");
		stup2.setSideTexture("example/stup");
		stup3.setSideTexture("example/stup");
		stup4.setSideTexture("example/stup");
	
		kub.setSideTexture("example/kirp");
		kub.setSideTexture("example/kirp");
		//колонны боковые
		
		kolon1 =new Cylinder(4, 4, 88, 1, 16, 270,0); 
		kolon1.setSideTexture("example/stup");
		kolon2 =new Cylinder(9, 4, 88, 1, 16, 270,0); 
		kolon2.setSideTexture("example/stup");
		kolon3 =new Cylinder(14, 4, 88, 1, 16, 270,0); 
		kolon3.setSideTexture("example/stup");
		kolon4 =new Cylinder(19, 4, 88, 1, 16, 270,0); 
		kolon4.setSideTexture("example/stup");
		kolon5 =new Cylinder(27, 4, 88, 1, 16, 270,0); 
		kolon5.setSideTexture("example/stup");
		kolon6 =new Cylinder(32, 4, 88, 1, 16, 270,0); 
		kolon6.setSideTexture("example/stup");
		kolon7 =new Cylinder(37, 4, 88, 1, 16, 270,0); 
		kolon7.setSideTexture("example/stup");
		kolon8 =new Cylinder(42, 4, 88, 1, 16, 270,0); 
		kolon8.setSideTexture("example/stup");
		kolon9 =new Cylinder(4, 4, -3, 1, 16, 270,0); 
		kolon9.setSideTexture("example/stup");
		kolon10 =new Cylinder(9, 4, -3, 1, 16, 270,0); 
		kolon10.setSideTexture("example/stup");
		kolon11 =new Cylinder(14, 4, -3, 1, 16, 270,0); 
		kolon11.setSideTexture("example/stup");
		kolon12 =new Cylinder(19, 4, -3, 1, 16, 270,0); 
		kolon12.setSideTexture("example/stup");
		kolon13 =new Cylinder(27, 4, -3, 1, 16, 270,0); 
		kolon13.setSideTexture("example/stup");
		kolon14 =new Cylinder(32, 4, -3, 1, 16, 270,0); 
		kolon14.setSideTexture("example/stup");
		kolon15 =new Cylinder(37, 4, -3, 1, 16, 270,0); 
		kolon15.setSideTexture("example/stup");
		kolon16 =new Cylinder(42, 4, -3, 1, 16, 270,0); 
		kolon16.setSideTexture("example/stup");
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("example/asphalt");
		
		App.drawUtils.drawQuadTex(ground);
		
		App.texUtils.prepareForDisplay("example/kirp");

		//house.display();
		kub.display();
		App.texUtils.prepareForDisplay("example/stup");
		stup1.display();
		stup2.display();
		stup3.display();
		stup4.display();
		kolon1.display();
		kolon2.display();
		kolon3.display();
		kolon4.display();
		kolon5.display();
		kolon6.display();
		kolon7.display();
		kolon8.display();
		kolon9.display();
		kolon10.display();
		kolon11.display();
		kolon12.display();
		kolon13.display();
		kolon14.display();
		kolon15.display();
		kolon16.display();
	}

	@Override
	protected void loadTextures() {
		TextureSet ts = new TextureSet();

		ts.globalFolder("SPb");

		ts.folder("example");
		ts.add(new String[] { "asphalt", "metal", "kirp", "stup" });
		
		ts.folder("axis");
		ts.add(new String[] { "metal" });

		App.texUtils.loadTexures(ts);
	}

}
