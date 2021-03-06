package org.rumter.chj.models.StudentCity.fence;

import java.util.ArrayList;
import java.util.List;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;
import org.rumter.chj.framework.model.primitives.Cylinder;

public class FenceSegment extends SimpleModel {

	/**
	 * фундамент
	 */
	private Block base;
	/**
	 * список линий
	 */
	private List<Quad> lines;
	/**
	 * основные столбцы
	 */
	private List<Cylinder> cols1;
	/**
	 * обычные столбцы
	 */
	private List<Quad> cols2;

	public FenceSegment(float x, float y, float z, Point _p1, Point _p2, boolean isDrawMainCol1, boolean isDrawMainCol2) {
		super(x, y, z);

		Point p1 = _p1.add(p);
		Point p2 = _p2.add(p);
		Point vectD = p2.sub(p1);

		base = new Block(new Quad(p1, vectD, FenceSizes.BASE_D), FenceSizes.BASE_H);
		base.setSideTexture("ground/fence_side");
		base.setTopTexture("ground/fence_top");

		cols1 = new ArrayList<Cylinder>();
		if (isDrawMainCol1) {
			Point pCyl = p1.add(new Point(0, FenceSizes.COL1_START_H, 0));
			Cylinder cyl = new Cylinder(pCyl.x, pCyl.y, pCyl.z, FenceSizes.COL1_R, FenceSizes.COL1_H, -90, 0);
			cyl.setSideTexture("ground/black");
			cols1.add(cyl);
		}
		if (isDrawMainCol2) {
			Point pCyl = p2.add(new Point(0, FenceSizes.COL1_START_H, 0));
			Cylinder cyl = new Cylinder(pCyl.x, pCyl.y, pCyl.z, FenceSizes.COL1_R, FenceSizes.COL1_H, -90, 0);
			cyl.setSideTexture("ground/black");
			cols1.add(cyl);
		}

		lines = new ArrayList<Quad>();
		Quad qLine = new Quad(p1, new Point(0, FenceSizes.LINE_H, 0), vectD);
		lines.add(qLine.moveY(FenceSizes.LINE_1_START_H));
		lines.add(qLine.moveY(FenceSizes.LINE_2_START_H));
		lines.add(qLine.moveY(FenceSizes.LINE_3_START_H));

		int countCols2 = (int) Math.ceil((vectD.distance() - FenceSizes.D_BETWEEN_COLS - FenceSizes.COL1_R * 2)
				/ (FenceSizes.COL2_D + FenceSizes.D_BETWEEN_COLS));
		cols2 = new ArrayList<Quad>();
		Point vectDN = vectD.normal();
		for (int i = 0; i < countCols2; ++i) {
			Point p = p1.add(vectDN.mul(i * FenceSizes.COL2_D + (i + 1) * FenceSizes.D_BETWEEN_COLS));
			float h = (i % 2 == 0 ? FenceSizes.COL2_BH : FenceSizes.COL2_SH);
			cols2.add(new Quad(p, new Point(0, h, 0), vectDN.mul(FenceSizes.COL2_D)).moveY(FenceSizes.COL2_START_H));
		}
	}

	@Override
	public void display() {
		base.display();
		for (Cylinder cyl : cols1) {
			cyl.display();
		}
		App.texUtils.prepareForDisplay("ground/black");
		for (Quad line : lines) {
			App.drawUtils.drawQuadTex(line);
		}
		for (Quad col : cols2) {
			App.drawUtils.drawQuadTex(col);
		}
	}

}
