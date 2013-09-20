package org.rumter.common_house_jogl.framework.draw;

import java.awt.Color;

/**
 * Освещаемый материал
 * 
 * @author ilya
 * 
 */
public class Material {

	private float[] ambient;
	private float[] diffuse;
	private float[] specular;
	private int shininess;
	private float[] emission;

	public Material(Color ambient, Color diffuse, Color specular,
			int shininess, Color emission) {
		this.ambient = ambient.getRGBComponents(null);
		this.diffuse = diffuse.getRGBComponents(null);
		;
		this.specular = specular.getRGBComponents(null);
		this.shininess = shininess;
		this.emission = emission.getRGBComponents(null);
	}

	public static final int SIMPLE_SHININESS = 4;
	public static final int SUN_SHININESS = 128;

	public static Material factorySimpleMaterial(Color c) {
		return new Material(c, c, c, SIMPLE_SHININESS, Color.white);
	}

	public static Material factorySunMaterial(Color c) {
		return new Material(c, c, c, SUN_SHININESS, Color.white);
	}

	public float[] getAmbient() {
		return ambient;
	}

	public void setAmbient(Color ambient) {
		this.ambient = ambient.getRGBComponents(null);
	}

	public float[] getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(Color diffuse) {
		this.diffuse = diffuse.getRGBComponents(null);
	}

	public float[] getSpecular() {
		return specular;
	}

	public void setSpecular(Color specular) {
		this.specular = specular.getRGBComponents(null);
	}

	public int getShininess() {
		return shininess;
	}

	public void setShininess(int shininess) {
		this.shininess = shininess;
	}

	public float[] getEmission() {
		return emission;
	}

	public void setEmission(Color emission) {
		this.emission = emission.getRGBComponents(null);
	}

}
