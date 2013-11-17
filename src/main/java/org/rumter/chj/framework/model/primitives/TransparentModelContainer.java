package org.rumter.chj.framework.model.primitives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.model.base.TransparentModel;

public class TransparentModelContainer {

	private List<TransparentModel> modelList;

	public TransparentModelContainer() {
		modelList = new ArrayList<>();
	}

	public void addAll(List<? extends TransparentModel> list) {
		modelList.addAll(list);
	}

	public void display() {

		TransparentModel[] modelArr = modelList.toArray(new TransparentModel[0]);

		Arrays.sort(modelArr, new Comparator<TransparentModel>() {

			@Override
			public int compare(TransparentModel o1, TransparentModel o2) {
				float d1 = o1.getQDistanceToLook();
				float d2 = o2.getQDistanceToLook();
				return d1 < d2 ? 1 : (d1 > d2 ? -1 : 0);
			}

		});

		App.gl.glEnable(GL2.GL_BLEND); // Turn Blending On
		App.gl.glDisable(GL2.GL_DEPTH_TEST); // Turn Depth Testing Off
		for (TransparentModel model : modelArr) {
			model.display();
		}
		App.gl.glDisable(GL2.GL_BLEND); // Turn Blending Off
		App.gl.glEnable(GL2.GL_DEPTH_TEST); // Turn Depth Testing On

	}

}
