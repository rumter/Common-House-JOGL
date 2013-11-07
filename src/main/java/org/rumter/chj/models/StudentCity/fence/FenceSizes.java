package org.rumter.chj.models.StudentCity.fence;

public interface FenceSizes {
	
	/**
	 * радиус главных столбов
	 */
	float COL1_R = 0.1f;
	/**
	 * диаметр обычных столбцов
	 */
	float COL2_D = 0.05f;
	/**
	 * высота главного столба
	 */
	float COL1_H = 2.5f;
	/**
	 * высота высокого обычного столбца
	 */
	float COL2_BH = 2.6f;
	/**
	 * высота низкого обычного столбца
	 */
	float COL2_SH = 2.4f;
	
	/**
	 * высота фундамента
	 */
	float BASE_H = 0.3f;
	/**
	 * ширина фундамента
	 */
	float BASE_D = 0.3f;
	
	/**
	 * ширина железной линии
	 */
	float LINE_H = 0.05f;
	/**
	 * стартовая высота первой линии
	 */
	float LINE_1_START_H = 0.01f + BASE_H;
	/**
	 * стартовая высота второй линии
	 */
	float LINE_2_START_H = COL2_BH - 0.015f;
	/**
	 * стартовая высота третьей линии
	 */
	float LINE_3_START_H = LINE_2_START_H - 0.03f;
	
	/**
	 * стартовая высота основного столба
	 */
	float COL1_START_H = BASE_H;
	/**
	 * стартовая высота обычного столбца
	 */
	float COL2_START_H = LINE_1_START_H + LINE_H;
	
	/**
	 * расстояние между столбцами
	 */
	float D_BETWEEN_COLS = 0.2f;

}
