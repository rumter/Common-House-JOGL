package org.rumter.chj.models.StudentCity.house;

/**
 * Все размеры
 * 
 * длина, L - расстояние по оси OX
 * 
 * высота, H - расстояние по оси OY
 * 
 * ширина, W - расстояние по оси OZ
 * 
 * @author ilya
 * 
 */
public interface HouseSizes {

	/**
	 * длина и ширина разделителя, между парами комнат (блок = пара комнат)
	 */
	float BLOCK_SEPARATOR_LW = 0.40f;
	/**
	 * длина блока комнат
	 */
	float BLOCK_L = 6.5f;
	/**
	 * длина проёма чёрной лестницы
	 */
	float BLACK_STAIRS_L = 1.5f;
	/**
	 * длина шага блока (используется при подсчёте длины нескольких блоков с
	 * разделителями)
	 */
	float BLOCK_STEP_L = BLOCK_L + BLOCK_SEPARATOR_LW;
	/**
	 * длина шага проёма чёрной лестницы (используется при подсчёте длины
	 * нескольких блоков с разделителями)
	 */
	float BLACK_STAIRS_STEP_L = BLACK_STAIRS_L + BLOCK_SEPARATOR_LW;

	/**
	 * половина ширины дома (расстояние до окна по центру)
	 */
	float HOUSE_HALF_W = 8f;
	/**
	 * ширина бокового окна
	 */
	float SIDE_WINDOW_W = 1f;
	/**
	 * глубина бокового окна
	 */
	float SIDE_WINDOW_L = 0.3f;

	/**
	 * высота синей полосы
	 */
	float BLUE_LINE_H = 1.0f;
	/**
	 * высота белой полосы
	 */
	float WHITE_LINE_H = 0.20f;
	/**
	 * высота окна этажа
	 */
	float FLOOR_WINDOW_H = 2.05f;
	/**
	 * высота этажа
	 */
	float FLOOR_H = FLOOR_WINDOW_H + BLUE_LINE_H;

	/**
	 * длина кирпичной границы в начале дома
	 */
	float HOUSE_INDENT_L = 0.60f;
	/**
	 * полная длина общаги
	 */
	float HOUSE_L = HOUSE_INDENT_L * 2 + BLOCK_STEP_L * 9 + BLACK_STAIRS_L;
	/**
	 * полная ширина общаги (с шириной разделителей)
	 */
	float HOUSE_W = 2 * HOUSE_HALF_W + 2 * BLOCK_SEPARATOR_LW + SIDE_WINDOW_W;

	/**
	 * стартовая высота крыши
	 */
	float TOP_START_H = FLOOR_H * 10;
	/**
	 * высота крыши
	 */
	float TOP_H = 3f;

}
