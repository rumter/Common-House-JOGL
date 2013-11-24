package org.rumter.chj.framework.model.primitives;

import java.awt.Color;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.SimpleModel;

/**
 * Блок
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public class Block extends SimpleModel {

	private static final Color DEFAULT_COLOR = Color.BLACK;

	private Color topColor = null;
	private Color bottomColor = null;
	private Color frontColor = null;
	private Color backColor = null;
	private Color leftColor = null;
	private Color rightColor = null;

	private String topTexture = null;
	private String bottomTexture = null;
	private String frontTexture = null;
	private String backTexture = null;
	private String leftTexture = null;
	private String rightTexture = null;

	private float kTopX = 0, kTopY = 0;

	/**
	 * стороны блока
	 */
	private Quad topSide, bottomSide, frontSide, backSide, leftSide, rightSide;

	public Block(float x, float y, float z, float wx, float wz, float h) {
		this(new Quad(new Point(x, y, z), new Point(0, 0, wz), new Point(wx, 0, 0)), h);
	}

	public Block(Quad base, float h) {
		super(base.getP1());
		this.bottomSide = base;
		this.topSide = base.moveY(h);

		Point bp1 = this.bottomSide.getP1();
		Point bp2 = this.bottomSide.getP2();
		Point bp3 = this.bottomSide.getP3();
		Point bp4 = this.bottomSide.getP4();
		Point tp1 = this.topSide.getP1();
		Point tp2 = this.topSide.getP2();
		Point tp3 = this.topSide.getP3();
		Point tp4 = this.topSide.getP4();

		this.frontSide = new Quad(bp1, tp1, tp4, bp4);
		this.backSide = new Quad(bp3, tp3, tp2, bp2);
		this.rightSide = new Quad(bp4, tp4, tp3, bp3);
		this.leftSide = new Quad(bp2, tp2, tp1, bp1);
	}

	private void displaySide(Quad sideQuad, String sideTex, Color sideColor) {
		if (sideTex != null) {
			App.texUtils.prepareForDisplay(sideTex);
			App.drawUtils.drawQuadTex(sideQuad);
		} else {
			App.drawUtils.drawQuad(sideQuad, sideColor != null ? sideColor : DEFAULT_COLOR);
		}
	}

	@Override
	public void display() {
		displaySide(frontSide, frontTexture, frontColor);
		displaySide(backSide, backTexture, backColor);
		displaySide(leftSide, leftTexture, leftColor);
		displaySide(rightSide, rightTexture, rightColor);

		if (kTopX != 0 && kTopY != 0) {
			App.texUtils.prepareForDisplay(topTexture);
			App.drawUtils.drawQuadTexKRepeat(topSide, kTopX, kTopY);
		} else {
			displaySide(topSide, topTexture, topColor);
		}

		displaySide(bottomSide, bottomTexture, bottomColor);
	}

	/**
	 * текстура боковой стороны
	 * 
	 * @param sideTexture
	 */
	public void setSideTexture(String sideTexture) {
		setRightTexture(sideTexture);
		setLeftTexture(sideTexture);
		setFrontTexture(sideTexture);
		setBackTexture(sideTexture);
	}

	/**
	 * цвет боковой стороны
	 * 
	 * @param sideTexture
	 */
	public void setSideColor(Color sideColor) {
		setRightColor(sideColor);
		setLeftColor(sideColor);
		setFrontColor(sideColor);
		setBackColor(sideColor);
	}

	public Color getTopColor() {
		return topColor;
	}

	public void setTopColor(Color topColor) {
		this.topColor = topColor;
	}

	public Color getBottomColor() {
		return bottomColor;
	}

	public void setBottomColor(Color bottomColor) {
		this.bottomColor = bottomColor;
	}

	public Color getFrontColor() {
		return frontColor;
	}

	public void setFrontColor(Color frontColor) {
		this.frontColor = frontColor;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public Color getLeftColor() {
		return leftColor;
	}

	public void setLeftColor(Color leftColor) {
		this.leftColor = leftColor;
	}

	public Color getRightColor() {
		return rightColor;
	}

	public void setRightColor(Color rightColor) {
		this.rightColor = rightColor;
	}

	public String getTopTexture() {
		return topTexture;
	}

	public void setTopTexture(String topTexture) {
		this.topTexture = topTexture;
	}

	public void setTopTexture(String topTexture, float kX, float kY) {
		this.topTexture = topTexture;
		this.kTopX = kX;
		this.kTopY = kY;
	}

	public String getBottomTexture() {
		return bottomTexture;
	}

	public void setBottomTexture(String bottomTexture) {
		this.bottomTexture = bottomTexture;
	}

	public String getFrontTexture() {
		return frontTexture;
	}

	public void setFrontTexture(String frontTexture) {
		this.frontTexture = frontTexture;
	}

	public String getBackTexture() {
		return backTexture;
	}

	public void setBackTexture(String backTexture) {
		this.backTexture = backTexture;
	}

	public String getLeftTexture() {
		return leftTexture;
	}

	public void setLeftTexture(String leftTexture) {
		this.leftTexture = leftTexture;
	}

	public String getRightTexture() {
		return rightTexture;
	}

	public void setRightTexture(String rightTexture) {
		this.rightTexture = rightTexture;
	}

	public Quad getTopSide() {
		return topSide;
	}

	public void setTopSide(Quad topSide) {
		this.topSide = topSide;
	}

	public Quad getBottomSide() {
		return bottomSide;
	}

	public void setBottomSide(Quad bottomSide) {
		this.bottomSide = bottomSide;
	}

	public Quad getFrontSide() {
		return frontSide;
	}

	public void setFrontSide(Quad frontSide) {
		this.frontSide = frontSide;
	}

	public Quad getBackSide() {
		return backSide;
	}

	public void setBackSide(Quad backSide) {
		this.backSide = backSide;
	}

	public Quad getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(Quad leftSide) {
		this.leftSide = leftSide;
	}

	public Quad getRightSide() {
		return rightSide;
	}

	public void setRightSide(Quad rightSide) {
		this.rightSide = rightSide;
	}

}
