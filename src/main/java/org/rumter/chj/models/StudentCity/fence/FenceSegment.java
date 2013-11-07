package org.rumter.chj.models.StudentCity.fence;

import java.util.List;

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

	public FenceSegment(float x, float y, float z, Point p1, Point p2, boolean isDrawMainCol1, boolean isDrawMainCOl2) {
		super(x, y, z);
	}

	@Override
	public void display() {
	}

}
