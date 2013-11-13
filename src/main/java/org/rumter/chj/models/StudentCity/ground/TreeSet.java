package org.rumter.chj.models.StudentCity.ground;

import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Tree;

public class TreeSet extends SimpleModel {

	private final int TREE_COORD_X = 0;
	private final int TREE_COORD_Z = 1;

	private final float TREE_W = 3;
	private final float TREE_H = 4;
	private final float TREE_Y = 0;

	private Tree[] trees;

	public TreeSet(float x, float y, float z) {
		super(x, y, z);
		float[][] coords = new float[][] { { -182, 148 }, { -217, 84 }, { -219, 71 }, { -385, 145 }, { -386, 124 },
				{ -367, 138 }, { -375, 160 }, { -372, 112 }, { -336, 159 }, { -347, 108 }, { -337, 131 },
				{ -347, 133 }, { -320, 159 }, { -309, 151 }, { -309, 133 }, { -278, 164 }, { -209, 185 } };
		trees = new Tree[coords.length];
		for (int i = 0; i < coords.length; ++i) {
			float sx = coords[i][TREE_COORD_X];
			float sz = coords[i][TREE_COORD_Z];
			trees[i] = new Tree(sx + x, TREE_Y + y, sz + z, TREE_W, TREE_H, "ground/tree");
		}
	}

	@Override
	public void display() {
		for (Tree t : trees) {
			t.display();
		}
	}

}
