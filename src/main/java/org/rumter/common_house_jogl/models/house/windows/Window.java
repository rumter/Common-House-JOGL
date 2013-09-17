package org.rumter.common_house_jogl.models.house.windows;

import org.rumter.common_house_jogl.models.base.SimpleModel;

/**
 * окно
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public abstract class Window extends SimpleModel {
	public abstract float getH();

	public abstract float getL();

	public Window(float x, float y, float z) {
		super(x, y, z);

		/*
		 * this.glassColor = new Color (0.5f, 0.5f, 0.5f); this.windowColor =
		 * new Color (1f, 1f, 1f, 1f); this.indentColor = new Color (0f, 0f, 0f,
		 * 0f); this.separatorColor = new Color (1f, 1f, 1f); this.sillColor =
		 * new Color (1f, 1f, 1f); this.quadBgColor = Color.GREEN;
		 * this.quadColor = Color.CYAN;
		 */
	}
}
