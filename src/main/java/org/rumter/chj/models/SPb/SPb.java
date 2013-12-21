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
	private Block polos;
	private Block polos2;
	private Block polos3;
	private Block kub;
	private Block stup1;
	private Block stup2;
	private Block stup3;
	private Block stup4;
	private Block stup5;
	private Block stup6;
	private Block stup7;
	private Block stup8;
	private Cylinder kolon;
	private Cylinder kolo1;
	private Cylinder kolo2;
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
	private Cylinder kolon17;
	private Cylinder kolon18;
	private Cylinder kolon19;
	private Cylinder kolon20;
	private Cylinder kolon21;
	private Cylinder kolon22;
	private Cylinder kolon23;
	private Cylinder kolon24;
	private Cylinder kolon25;
	private Cylinder kolon26;
	private Cylinder kolon27;
	private Cylinder kolon28;
	private Cylinder kolon29;
	private Cylinder kolon30;
	private Cylinder kolon31;
	private Cylinder kolon32;
	private Cylinder kolon33;
	private Cylinder kolon34;
	private Cylinder kolon35;
	private Cylinder kolon36;
	private Cylinder kolon37;
	private Cylinder kolon38;
	private Cylinder kolon39;
	private Cylinder kolon40;
	private Cylinder kolon41;
	private Cylinder kolon42;
	private Cylinder kolon43;
	private Cylinder kolon44;
	private Cylinder kolon45;
	private Cylinder kolon46;
	private Cylinder kolon47;
	private Cylinder kolon48;
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
		kolon =new Cylinder(23.5f, 34, 42.5f, 11, 25, 270,0); 	
		kolon.setSideTexture("example/kolon");
		kolo1 =new Cylinder(23.5f, 34, 42.5f, 13, 2, 270,0);
		kolo1.setSideTexture("example/kolon");
		kolo2 =new Cylinder(23.5f, 36, 42.5f, 12, 3, 270,0);
		kolo2.setSideTexture("example/kirp2");
		
		
		polos=new Block(-1, 20, -6, 47, 97, 2);
		polos2=new Block(-20, 20, 23, 85, 40, 2);
		polos3=new Block(-1, 34, -1, 47, 87, 1);
		//ступеньки
		stup1 = new Block(-4, y, -9, 53, 103, 1);
		stup2 = new Block(-3, 1, -8, 51, 101, 1);
		stup3 = new Block(-2, 2, -7, 49, 99, 1);
		stup4 = new Block(-1, 3, -6, 47, 97, 1);
		stup1.setSideTexture("example/stup2");
		stup2.setSideTexture("example/stup2");
		stup3.setSideTexture("example/stup2");
		stup4.setSideTexture("example/stup2");
		
		
	
		polos.setSideTexture("example/polos");
		polos2.setSideTexture("example/polos");
		polos3.setSideTexture("example/polos");
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
		//фасад
		stup5 = new Block(-23, y, 20, 91, 46, 1);
		stup6 = new Block(-22, 1, 21, 89, 44, 1);
		stup7 = new Block(-21, 2, 22, 87, 42, 1);
		stup8 = new Block(-20, 3, 23, 85, 40, 1);
		stup5.setSideTexture("example/stup2");
		stup6.setSideTexture("example/stup2");
		stup7.setSideTexture("example/stup2");
		stup8.setSideTexture("example/stup2");
		kolon17 =new Cylinder(-7, 4, 25, 1, 16, 270,0); 
		kolon17.setSideTexture("example/stup");
		kolon18 =new Cylinder(-12, 4, 25, 1, 16, 270,0); 
		kolon18.setSideTexture("example/stup");
		kolon19 =new Cylinder(-17, 4, 25, 1, 16, 270,0); 
		kolon19.setSideTexture("example/stup");
		kolon20 =new Cylinder(-7, 4, 35, 1, 16, 270,0); 
		kolon20.setSideTexture("example/stup");
		kolon21 =new Cylinder(-12, 4, 35, 1, 16, 270,0); 
		kolon21.setSideTexture("example/stup");
		kolon22 =new Cylinder(-17, 4, 35, 1, 16, 270,0); 
		kolon22.setSideTexture("example/stup");
		kolon23 =new Cylinder(-7, 4, 60, 1, 16, 270,0); 
		kolon23.setSideTexture("example/stup");
		kolon24 =new Cylinder(-12, 4, 60, 1, 16, 270,0); 
		kolon24.setSideTexture("example/stup");
		kolon25 =new Cylinder(-17, 4, 60, 1, 16, 270,0); 
		kolon25.setSideTexture("example/stup");
		kolon26 =new Cylinder(-7, 4, 50, 1, 16, 270,0); 
		kolon26.setSideTexture("example/stup");
		kolon27 =new Cylinder(-12, 4, 50, 1, 16, 270,0); 
		kolon27.setSideTexture("example/stup");
		kolon28 =new Cylinder(-17, 4, 50, 1, 16, 270,0); 
		kolon28.setSideTexture("example/stup");
		kolon30 =new Cylinder(-17, 4, 45, 1, 16, 270,0); 
		kolon30.setSideTexture("example/stup");
		kolon29 =new Cylinder(-17, 4, 40, 1, 16, 270,0); 
		kolon29.setSideTexture("example/stup");
		kolon31 =new Cylinder(-17, 4, 55, 1, 16, 270,0); 
		kolon31.setSideTexture("example/stup");
		kolon32 =new Cylinder(-17, 4, 30, 1, 16, 270,0); 
		kolon32.setSideTexture("example/stup");
		
		kolon33 =new Cylinder(61, 4, 45, 1, 16, 270,0); 
		kolon33.setSideTexture("example/stup");
		kolon34 =new Cylinder(61, 4, 40, 1, 16, 270,0); 
		kolon34.setSideTexture("example/stup");
		kolon35 =new Cylinder(61, 4, 55, 1, 16, 270,0); 
		kolon35.setSideTexture("example/stup");
		kolon36 =new Cylinder(61, 4, 30, 1, 16, 270,0); 
		kolon36.setSideTexture("example/stup");
		
		kolon37 =new Cylinder(61, 4, 25, 1, 16, 270,0); 
		kolon37.setSideTexture("example/stup");
		kolon38 =new Cylinder(56, 4, 25, 1, 16, 270,0); 
		kolon38.setSideTexture("example/stup");
		kolon39 =new Cylinder(51, 4, 25, 1, 16, 270,0); 
		kolon39.setSideTexture("example/stup");
		kolon40 =new Cylinder(61, 4, 35, 1, 16, 270,0); 
		kolon40.setSideTexture("example/stup");
		kolon41 =new Cylinder(56, 4, 35, 1, 16, 270,0); 
		kolon41.setSideTexture("example/stup");
		kolon42 =new Cylinder(51, 4, 35, 1, 16, 270,0); 
		kolon42.setSideTexture("example/stup");
		kolon43 =new Cylinder(61, 4, 60, 1, 16, 270,0); 
		kolon43.setSideTexture("example/stup");
		kolon44 =new Cylinder(56, 4, 60, 1, 16, 270,0); 
		kolon44.setSideTexture("example/stup");
		kolon45 =new Cylinder(51, 4, 60, 1, 16, 270,0); 
		kolon45.setSideTexture("example/stup");
		kolon46 =new Cylinder(61, 4, 50, 1, 16, 270,0); 
		kolon46.setSideTexture("example/stup");
		kolon47 =new Cylinder(56, 4, 50, 1, 16, 270,0); 
		kolon47.setSideTexture("example/stup");
		kolon48 =new Cylinder(51, 4, 50, 1, 16, 270,0); 
		kolon48.setSideTexture("example/stup");
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay("example/asphalt");
		
		App.drawUtils.drawQuadTex(ground);
		
		App.texUtils.prepareForDisplay("example/tri");
		App.drawUtils.drawTextre(new Point(-1, 22, -6), new Point(46, 22, -6),new Point(23.5f, 30, -6));
		App.drawUtils.drawTextre(new Point(-1, 22, 91), new Point(46, 22, 91),new Point(23.5f, 30, 91));
		
		App.texUtils.prepareForDisplay("example/kirp2");
		kolo2.display();
		
		//house.display();
		App.texUtils.prepareForDisplay("example/kirp");
		kub.display();
		App.drawUtils.drawSphere(new Point(23.5f, 59, 42.5f), 11);
	
		App.texUtils.prepareForDisplay("example/kolon");
		kolon.display();
		kolo1.display();
		App.texUtils.prepareForDisplay("example/polos");
		polos.display();
		polos2.display();
		polos3.display();
		App.texUtils.prepareForDisplay("example/stup2");
		stup1.display();
		stup2.display();
		stup3.display();
		stup4.display();
		stup5.display();
		stup6.display();
		stup7.display();
		stup8.display();
		
		
		App.texUtils.prepareForDisplay("example/stup");
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
		kolon17.display();
		kolon18.display();
		kolon19.display();
		kolon20.display();
		kolon21.display();
		kolon22.display();
		kolon23.display();
		kolon24.display();
		kolon25.display();
		kolon26.display();
		kolon27.display();
		kolon28.display();
		kolon29.display();
		kolon30.display();
		kolon31.display();
		kolon32.display();
		kolon33.display();
		kolon34.display();
		kolon35.display();
		kolon36.display();
		kolon37.display();
		kolon38.display();
		kolon39.display();
		kolon40.display();
		kolon41.display();
		kolon42.display();
		kolon43.display();
		kolon44.display();
		kolon45.display();
		kolon46.display();
		kolon47.display();
		kolon48.display();
	}

	@Override
	protected void loadTextures() {
		TextureSet ts = new TextureSet();

		ts.globalFolder("SPb");

		ts.folder("example");
		ts.add(new String[] { "asphalt", "tri", "metal", "kirp","kirp2","polos", "stup", "stup2","kolon" });
		
		ts.folder("axis");
		ts.add(new String[] { "metal" });

		App.texUtils.loadTexures(ts);
	}

}
