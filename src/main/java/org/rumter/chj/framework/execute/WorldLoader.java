package org.rumter.chj.framework.execute;

import java.io.InputStream;
import java.util.Properties;

import org.rumter.chj.App;
import org.rumter.chj.framework.execute.profiling.ProfileManager;
import org.rumter.chj.framework.geom.Point;
import org.rumter.chj.framework.model.base.World;
import org.rumter.chj.framework.model.special.coords.Axis;

public class WorldLoader {

	private static final String PROPERTIES_FOLDER = "/properties";

	private static final String APP_PROPERTIES = PROPERTIES_FOLDER + "/app.properties";

	private void loadAppProperties() {
		try {
			Properties props = new Properties();

			InputStream in = getClass().getResourceAsStream(APP_PROPERTIES);
			props.load(in);

			project = "org.rumter.chj.models." + props.getProperty("project") + "." + props.getProperty("project");

			isUseLight = Boolean.parseBoolean(props.getProperty("is.use.light"));

			isUseShadow = Boolean.parseBoolean(props.getProperty("is.use.shadow"));

			isUseAxis = Boolean.parseBoolean(props.getProperty("is.use.axis"));

			startModelPositionX = Float.parseFloat(props.getProperty("start.model.position.x"));
			startModelPositionY = Float.parseFloat(props.getProperty("start.model.position.y"));
			startModelPositionZ = Float.parseFloat(props.getProperty("start.model.position.z"));

			startLookPositionX = Float.parseFloat(props.getProperty("start.look.position.x"));
			startLookPositionY = Float.parseFloat(props.getProperty("start.look.position.y"));
			startLookPositionZ = Float.parseFloat(props.getProperty("start.look.position.z"));

			startLookRotateX = Float.parseFloat(props.getProperty("start.look.rotate.x"));
			startLookRotateY = Float.parseFloat(props.getProperty("start.look.rotate.y"));

			in.close();
		} catch (Exception e) {
			System.out.println("невозможно получить свойства приложения");
			e.printStackTrace();
		}
	}

	private String project = "org.rumter.chj.models.ExampleWorld.ExampleWorld";
	private boolean isUseLight = true;
	private boolean isUseShadow = false;
	private boolean isUseAxis = true;

	private float startModelPositionX = 0;
	private float startModelPositionY = 0;
	private float startModelPositionZ = 0;

	private float startLookPositionX = 0;
	private float startLookPositionY = 1.5f;
	private float startLookPositionZ = -100;

	private float startLookRotateX = 0;
	private float startLookRotateY = 0;

	private World world;
	private ProfileManager profileManager;
	private Axis axis;

	public WorldLoader() {

		loadAppProperties();

		try {
			world = (World) Class.forName(project).getConstructor(float.class, float.class, float.class)
					.newInstance(startModelPositionX, startModelPositionY, startModelPositionZ);
		} catch (Exception e) {
			e.printStackTrace();
		}

		App.lightManager.initLight0(new Point(startModelPositionX, startModelPositionY, startModelPositionZ));
		//App.shadowManager.initShadowMatrix(App.lightManager.getPosition0());

		profileManager = new ProfileManager();

		if (isUseAxis) {
			axis = new Axis();
		}

		App.motionManager.setPosition(startLookPositionX, startLookPositionY, startLookPositionZ, startLookRotateX,
				startLookRotateY);
	}

	public World getCurrentWorld() {
		return world;
	}

	public void displayWorld() {
		profileManager.startTimer();
		App.motionManager.display();
		App.lightManager.display0();
		world.display();
		profileManager.saveResult();
		if (isUseAxis) {
			axis.display();
		}
	}

	public void printProfilingResult() {
		System.out.println("average display time = " + profileManager.getAverageResult() + "ms");
		System.out.println("memory used = " + profileManager.getMemoryUsed() + "MB");
	}

}
