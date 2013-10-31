package org.rumter.chj.framework.draw.tex;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.media.opengl.GL2;

import org.rumter.chj.App;
import org.rumter.chj.framework.draw.Material;

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

	private static String ROOT_FOLDER = "/tex/";
	private static String EXT[] = { ".png", ".jpg", ".bmp" };

	private Material defaultMaterial;
	private Texture currentTex = null;
	private String currentTexStr = "";

	public TextureUtils() {
		defaultMaterial = Material.factorySimpleMaterial(Color.white);
	}

	public void loadTexures(TextureSet textureSet) {
		mapTex = new TreeMap<String, Texture>();
		if (textureSet.getFolderList() != null) {
			for (String folder : textureSet.getFolderList()) {
				if (textureSet.getFileList(folder) != null) {
					for (String file : textureSet.getFileList(folder)) {
						String fileId = folder + "/" + file;
						String filePath = textureSet.getGlobalFolder() + "/" + folder + "/" + file;
						mapTex.put(fileId, factory(filePath));
					}
				}
			}
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
			InputStream stream = null;
			String existsPath = null;
			String existsEXT = null;
			for (int i = 0; i < EXT.length; ++i) {
				String path = ROOT_FOLDER + filePath + EXT[i];
				stream = getClass().getResourceAsStream(path);
				if (stream != null) {
					existsPath = path;
					existsEXT = EXT[i];
					break;
				}
			}
			if (existsPath == null) {
				throw new IOException();
			}
			TextureData data = TextureIO.newTextureData(App.glp, stream, false, existsEXT);
			Texture tex = TextureIO.newTexture(data);
			tex.setTexParameterf(App.gl, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
			tex.setTexParameterf(App.gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
			tex.setTexParameterf(App.gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
			return tex;
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
