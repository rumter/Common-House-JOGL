package org.rumter.common_house_jogl.framework.draw;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.media.opengl.GL2;

import org.rumter.common_house_jogl.App;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 * методы для работы с текстурами
 * 
 * @author Митин Илья
 * @email rumtery@yandex.ru
 */
public final class TextureUtils {

	public static enum TextureMode {
		REPEAT, STRETCH
	}

	private Material defaultMaterial;
	private Texture currentTex = null;
	private String currentTexStr = "";

	public TextureUtils() {
		String allTex[] = { "glass", "window", "indent", "bricks", "quad", "quadBg", "blueLine", "whiteLine", "kr1",
				"beton", "build1", "build2", "houseTop", "betonLine", "blueLineBottom", "doors", "title8", "cylinder",
				"WashRoomWindow", "MainStairsWindow", "WindowsBlock", "WindowsBlock2", "BlackStairsWindow",
				"BlackStairsWindow2" };
		mapTex = new TreeMap<>();
		for (String s : allTex) {
			Texture tex = factory(s);
			tex.setTexParameterf(App.gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
			tex.setTexParameterf(App.gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
			mapTex.put(s, tex);
		}

		defaultMaterial = Material.factorySimpleMaterial(Color.white);
	}

	/**
	 * ассоциативный массив всех текстур в программе
	 */
	private Map<String, Texture> mapTex;

	/**
	 * создать текстуру
	 * 
	 * @param filePath
	 *            путь к изображению
	 * @return
	 */
	public Texture factory(String filePath) {
		try {
			InputStream stream = getClass().getResourceAsStream("/tex/" + filePath + ".png");
			TextureData data = TextureIO.newTextureData(App.glp, stream, false, "png");
			return TextureIO.newTexture(data);
		} catch (IOException exc) {
			System.out.println("Texture not found: " + filePath);
		}
		return null;
	}

	/**
	 * подготовить текстуру к рисованию
	 * 
	 * @param tex
	 * @param gl
	 */
	public void prepareForDisplay(Texture tex) {
		GL2 gl = App.gl;

		if (currentTex != null) {
			currentTex.disable(gl);
		}

		App.drawUtils.setMaterial(defaultMaterial);

		tex.enable(gl);
		tex.bind(gl);
		currentTex = tex;
	}

	/**
	 * подготовить текстуру к рисованию
	 * 
	 * @param tex
	 * @param gl
	 */
	public void prepareForDisplay(String tex) {
		try {
			if (!tex.equals(currentTexStr)) {
				currentTexStr = tex;
				prepareForDisplay(mapTex.get(tex));
			}
		} catch (Exception e) {
			System.out.println("Не удалось найти текстуру : " + tex);
		}
	}
}
