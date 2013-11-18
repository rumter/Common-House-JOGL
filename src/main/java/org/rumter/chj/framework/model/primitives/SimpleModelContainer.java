package org.rumter.chj.framework.model.primitives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.rumter.chj.framework.model.base.SimpleModel;

public class SimpleModelContainer {

	private List<SimpleModel> modelList;

	public SimpleModelContainer() {
		modelList = new ArrayList<>();
	}

	public void addAll(List<? extends SimpleModel> someModelList) {
		modelList.addAll(someModelList);
	}

	public void add(SimpleModel model) {
		modelList.add(model);
	}

	public void display() {
		SimpleModel[] modelArr = modelList.toArray(new SimpleModel[0]);

		Arrays.sort(modelArr, new Comparator<SimpleModel>() {

			@Override
			public int compare(SimpleModel o1, SimpleModel o2) {
				float d1 = o1.getQDistanceToLook();
				float d2 = o2.getQDistanceToLook();
				return d1 < d2 ? 1 : (d1 > d2 ? -1 : 0);
			}

		});

		for (SimpleModel model : modelArr) {
			model.display();
		}
	}

}
