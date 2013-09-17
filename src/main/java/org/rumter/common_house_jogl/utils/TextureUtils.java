package org.rumter.common_house_jogl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.media.opengl.GL;
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
	public TextureUtils() {
		String allTex[] = { "glass", "window", "indent", "bricks", "quad",
				"quadBg", "blueLine", "whiteLine", "kr1", "beton", "build1",
				"build2", "houseTop", "betonLine", "blueLineBottom", "doors" };
		mapTex = new TreeMap<>();
		for (String s : allTex) {
			mapTex.put(s, factory(s));
		}
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
			InputStream stream = getClass().getResourceAsStream(
					"/tex/" + filePath + ".png");
			TextureData data = TextureIO.newTextureData(App.glp, stream, false,
					"png");
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

		float[] white = { 1f, 1f, 1f };
		float[] black = { 1f, 1f, 1f };
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, white, 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, white, 0);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, white, 0);
		gl.glMateriali(GL.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 4);
		gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL2.GL_EMISSION, black, 0);

		tex.enable(gl);
		tex.bind(gl);

		tex.setTexParameterf(gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
		tex.setTexParameterf(gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
	}

	/**
	 * подготовить текстуру к рисованию
	 * 
	 * @param tex
	 * @param gl
	 */
	public void prepareForDisplay(String tex) {
		try {
			prepareForDisplay(mapTex.get(tex));
		} catch (Exception e) {
			System.out.println("Не удалось найти текстуру : " + tex);
		}
	}
}
