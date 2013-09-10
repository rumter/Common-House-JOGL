package org.rumter.common_house_jogl.models;

import java.awt.Color;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.utils.DrawUtils;
import org.rumter.common_house_jogl.utils.Point;

/**
 * Блок
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Block extends SimpleModel {

	public Block(float x, float y, float z, float wx, float wz, float h,
			String texPath) {
		super(x, y, z);

		this.wx = wx;
		this.wz = wz;
		this.h = h;

		this.brickTexture = texPath;
		this.sideColor = Color.DARK_GRAY;
	}

	/**
	 * текстура кирпичной стены
	 */
	private String brickTexture;
	/**
	 * цвет нижней и верхней границы
	 */
	private Color sideColor;

	/**
	 * размеры блока
	 */
	private float wx, wz, h;

	@Override
	public void display() {
		// передняя и задняя стороны
		App.TexUtils.prepareForDisplay(brickTexture);
		DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(0, h, 0),
				new Point(wx, 0, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x, y, z + wz), new Point(0, h, 0),
				new Point(wx, 0, 0), DrawUtils.TEXTURE_MODE_REPEAT);
		// левая и правая стороны
		DrawUtils.drawRectangleTex(new Point(x, y, z), new Point(0, h, 0),
				new Point(0, 0, wz), DrawUtils.TEXTURE_MODE_REPEAT);
		DrawUtils.drawRectangleTex(new Point(x + wx, y, z), new Point(0, h, 0),
				new Point(0, 0, wz), DrawUtils.TEXTURE_MODE_REPEAT);
		// верхняя и нижняя стороны
		DrawUtils.drawRectangle(sideColor, new Point(x, y, z), new Point(0, 0,
				wz), new Point(wx, 0, 0));
		DrawUtils.drawRectangle(sideColor, new Point(x, y + h, z), new Point(0,
				0, wz), new Point(wx, 0, 0));
	}
}
