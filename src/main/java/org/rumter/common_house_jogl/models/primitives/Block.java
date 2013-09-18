package org.rumter.common_house_jogl.models.primitives;

import java.awt.Color;

import org.rumter.common_house_jogl.App;
import org.rumter.common_house_jogl.geom.Point;
import org.rumter.common_house_jogl.geom.Quad;
import org.rumter.common_house_jogl.models.base.SimpleModel;
import org.rumter.common_house_jogl.utils.DrawUtils;

/**
 * Блок
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Block extends SimpleModel {

	/**
	 * текстура кирпичной стены
	 */
	private String texture;
	/**
	 * цвет нижней и верхней границы
	 */
	private Color sideColor;
	/**
	 * стороны блока
	 */
	Quad topSide, bottomSide, frontSide, backSide, leftSide, rightSide;

	public Block(float x, float y, float z, float wx, float wz, float h,
			String texPath) {
		super(x, y, z);

		this.texture = texPath;
		this.sideColor = Color.DARK_GRAY;

		this.frontSide = new Quad(new Point(x, y, z), new Point(0, h, 0),
				new Point(wx, 0, 0));
		this.backSide = new Quad(new Point(x, y, z + wz), new Point(0, h, 0),
				new Point(wx, 0, 0));
		this.leftSide = new Quad(new Point(x, y, z), new Point(0, h, 0),
				new Point(0, 0, wz));
		this.rightSide = new Quad(new Point(x + wx, y, z), new Point(0, h, 0),
				new Point(0, 0, wz));
		this.topSide = new Quad(new Point(x, y, z), new Point(0, 0, wz),
				new Point(wx, 0, 0));
		this.bottomSide = new Quad(new Point(x, y + h, z), new Point(0, 0, wz),
				new Point(wx, 0, 0));
	}

	@Override
	public void display() {
		App.texUtils.prepareForDisplay(texture);
		App.drawUtils.drawQuadTex(frontSide, DrawUtils.TEXTURE_MODE_REPEAT);
		App.drawUtils.drawQuadTex(backSide, DrawUtils.TEXTURE_MODE_REPEAT);
		App.drawUtils.drawQuadTex(leftSide, DrawUtils.TEXTURE_MODE_REPEAT);
		App.drawUtils.drawQuadTex(rightSide, DrawUtils.TEXTURE_MODE_REPEAT);
		App.drawUtils.drawQuad(sideColor, topSide);
		App.drawUtils.drawQuad(sideColor, bottomSide);
	}
}