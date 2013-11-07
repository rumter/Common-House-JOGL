package org.rumter.chj.models.StudentCity.house;

import java.util.ArrayList;

import org.rumter.chj.App;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.geom.Quad;
import org.rumter.chj.framework.model.base.Model;
import org.rumter.chj.framework.model.base.SimpleModel;
import org.rumter.chj.framework.model.primitives.Block;

/**
 * Жилая часть общежития
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
class MainHousePart extends SimpleModel {

	private Block factoryBricksBlock(float x, float y, float z, float wx, float wz, float h) {
		Block block = new Block(x, y, z, wx, wz, h);
		block.setSideTexture("house/bricks");
		return block;
	}

	/**
	 * если type = 1, то вход слева<br />
	 * если type = 2, то вход справа<br/>
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param type
	 */
	public MainHousePart(float x, float y, float z, int type) {
		super(x, y, z);

		bricks = new ArrayList<Block>();
		washRoomsWindows = new ArrayList<Quad>();
		blackStairsWindows = new ArrayList<Quad>();
		blackStairsBottomWindows = new ArrayList<Quad>();
		mainStairsWindows = new ArrayList<Quad>();
		blockWindows = new ArrayList<Quad>();
		blockBottomWindows = new ArrayList<Quad>();

		// left side
		{
			float startY = (type == 1 ? y + HouseSizes.FLOOR_H : y);
			int countFloors = (type == 1 ? 9 : 10);

			bricks.add(factoryBricksBlock(x, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wz
					countFloors * HouseSizes.FLOOR_H // h
			));
			bricks.add(factoryBricksBlock(x, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW - HouseSizes.HOUSE_HALF_W - HouseSizes.SIDE_WINDOW_W, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wz
					countFloors * HouseSizes.FLOOR_H // h
			));
			bricks.add(factoryBricksBlock(x + HouseSizes.SIDE_WINDOW_L, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW - HouseSizes.HOUSE_HALF_W + HouseSizes.BLOCK_SEPARATOR_LW, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wz
					countFloors * HouseSizes.FLOOR_H // h
			));
		}

		// right side
		{
			float startY = (type == 2 ? y + HouseSizes.FLOOR_H : y);
			int countFloors = (type == 2 ? 9 : 10);

			bricks.add(factoryBricksBlock(x + HouseSizes.HOUSE_L - HouseSizes.HOUSE_INDENT_L, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wx
					countFloors * HouseSizes.FLOOR_H // h
			));
			bricks.add(factoryBricksBlock(x + HouseSizes.HOUSE_L - HouseSizes.HOUSE_INDENT_L, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW - HouseSizes.HOUSE_HALF_W - 1f, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wz
					countFloors * HouseSizes.FLOOR_H // h
			));
			bricks.add(factoryBricksBlock(
					x + HouseSizes.HOUSE_L - HouseSizes.HOUSE_INDENT_L - HouseSizes.SIDE_WINDOW_L, // x
					startY, // y
					z + HouseSizes.BLOCK_SEPARATOR_LW - HouseSizes.HOUSE_HALF_W + HouseSizes.BLOCK_SEPARATOR_LW, // z
					HouseSizes.HOUSE_INDENT_L, // wx
					-HouseSizes.HOUSE_HALF_W - HouseSizes.BLOCK_SEPARATOR_LW, // wz
					countFloors * HouseSizes.FLOOR_H // h
			));
		}

		// separators
		{
			int iFirstCutFloor = (type == 1 ? 1 : 6);
			int iLastCutFloor = (type == 1 ? 4 : 9);
			int iFirstFullFloor = (type == 1 ? 5 : 1);
			int iLastFullFloor = (type == 1 ? 9 : 5);

			for (int i = iFirstCutFloor; i <= iLastCutFloor; ++i) {
				float xStart = x + HouseSizes.HOUSE_INDENT_L + i * HouseSizes.BLOCK_STEP_L
						- HouseSizes.BLOCK_SEPARATOR_LW;
				if (type == 2) {
					xStart += HouseSizes.BLACK_STAIRS_L - HouseSizes.BLOCK_L;
				}

				bricks.add(factoryBricksBlock(xStart, // x
						y + HouseSizes.FLOOR_H, // y
						z + HouseSizes.BLOCK_SEPARATOR_LW, // z
						HouseSizes.BLOCK_SEPARATOR_LW, // wx
						-HouseSizes.BLOCK_SEPARATOR_LW * 2 - HouseSizes.HOUSE_HALF_W * 2 - HouseSizes.SIDE_WINDOW_W, // wz
						9 * HouseSizes.FLOOR_H // h
				));
			}
			for (int i = iFirstFullFloor; i <= iLastFullFloor; ++i) {
				float xStart = x + HouseSizes.HOUSE_INDENT_L + i * HouseSizes.BLOCK_STEP_L
						- HouseSizes.BLOCK_SEPARATOR_LW;
				if (type == 2) {
					xStart += HouseSizes.BLACK_STAIRS_L - HouseSizes.BLOCK_L;
				}

				bricks.add(factoryBricksBlock(xStart, // x
						y, // y
						z + HouseSizes.BLOCK_SEPARATOR_LW, // z
						HouseSizes.BLOCK_SEPARATOR_LW, // wx
						-HouseSizes.BLOCK_SEPARATOR_LW * 2 - HouseSizes.HOUSE_HALF_W * 2 - HouseSizes.SIDE_WINDOW_W, // wz
						10 * HouseSizes.FLOOR_H // h
				));
			}
		}

		Point vh1 = new Point(0, HouseSizes.FLOOR_H, 0);
		Point vh9 = new Point(0, HouseSizes.FLOOR_H * 9, 0);
		Point vw = new Point(HouseSizes.BLOCK_L, 0, 0);
		Point vw2 = new Point(HouseSizes.BLACK_STAIRS_L, 0, 0);

		float backZ = z - HouseSizes.HOUSE_HALF_W - 1f - HouseSizes.HOUSE_HALF_W;

		setFlatsConfig(type);

		// wash
		{
			float startX = HouseSizes.HOUSE_INDENT_L + HouseSizes.BLOCK_STEP_L * wash
					+ (wash > blackStairs ? -HouseSizes.BLOCK_L + HouseSizes.BLACK_STAIRS_L : 0);
			washRoomsWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, z), vh9, vw));
			blockWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, backZ), vh9, vw));
		}

		// block
		for (int i = 0; i < block.length; ++i) {
			float startX = HouseSizes.HOUSE_INDENT_L + HouseSizes.BLOCK_STEP_L * block[i]
					+ (wash > blackStairs ? -HouseSizes.BLOCK_L + HouseSizes.BLACK_STAIRS_L : 0);
			blockWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, z), vh9, vw));
			blockWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, backZ), vh9, vw));
		}

		// main stairs
		{
			float startX = HouseSizes.HOUSE_INDENT_L + HouseSizes.BLOCK_STEP_L * mainStairs
					+ (wash > blackStairs ? -HouseSizes.BLOCK_L + HouseSizes.BLACK_STAIRS_L : 0);
			mainStairsWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, z), vh9, vw));
			blockWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, backZ), vh9, vw));
		}

		// block bottom
		for (int i = 0; i < blockBottom.length; ++i) {
			float startX = HouseSizes.HOUSE_INDENT_L + HouseSizes.BLOCK_STEP_L * blockBottom[i]
					+ (wash > blackStairs ? -HouseSizes.BLOCK_L + HouseSizes.BLACK_STAIRS_L : 0);
			blockBottomWindows.add(new Quad(new Point(x + startX, y, z), vh1, vw));
			blockBottomWindows.add(new Quad(new Point(x + startX, y, backZ), vh1, vw));
		}

		// black stairs
		{
			float startX = HouseSizes.HOUSE_INDENT_L + HouseSizes.BLOCK_STEP_L * blackStairs;
			blackStairsWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, z), vh9, vw2));
			blackStairsWindows.add(new Quad(new Point(x + startX, y + HouseSizes.FLOOR_H, backZ), vh9, vw2));
			blackStairsBottomWindows.add(new Quad(new Point(x + startX, y, z), vh1, vw2));
			blackStairsBottomWindows.add(new Quad(new Point(x + startX, y, backZ), vh1, vw2));
		}

	}

	private int wash;
	private int block[];
	private int mainStairs;
	private int blockBottom[];
	private int blackStairs;

	private void setFlatsConfig(int type) {
		if (type == 1) {
			wash = 0;
			block = new int[] { 1, 2, 4, 5, 6, 7, 8 };
			mainStairs = 3;
			blockBottom = new int[] { 4, 5, 6, 7, 8 };
			blackStairs = 9;
		} else {
			wash = 9;
			block = new int[] { 1, 2, 3, 4, 5, 7, 8 };
			mainStairs = 6;
			blockBottom = new int[] { 1, 2, 3, 4, 5 };
			blackStairs = 0;
		}
	}

	/**
	 * модели для рисования
	 */
	private ArrayList<Block> bricks;
	private ArrayList<Quad> washRoomsWindows;
	private ArrayList<Quad> blackStairsWindows;
	private ArrayList<Quad> blackStairsBottomWindows;
	private ArrayList<Quad> mainStairsWindows;
	private ArrayList<Quad> blockWindows;
	private ArrayList<Quad> blockBottomWindows;

	@Override
	public void display() {
		for (Model m : bricks) {
			m.display();
		}
		App.texUtils.prepareForDisplay("house/WashRoomWindow");
		for (Quad q : washRoomsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("house/BlackStairsWindow");
		for (Quad q : blackStairsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("house/BlackStairsWindow2");
		for (Quad q : blackStairsBottomWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 1);
		}
		App.texUtils.prepareForDisplay("house/MainStairsWindow");
		for (Quad q : mainStairsWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("house/WindowsBlock");
		for (Quad q : blockWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 9);
		}
		App.texUtils.prepareForDisplay("house/WindowsBlock2");
		for (Quad q : blockBottomWindows) {
			App.drawUtils.drawQuadTexRepeat(q, 1, 1);
		}
	}
}