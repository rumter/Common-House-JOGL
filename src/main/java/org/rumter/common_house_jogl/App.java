package org.rumter.common_house_jogl;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;

import org.rumter.common_house_jogl.models.Map;
import org.rumter.common_house_jogl.models.base.Model;
import org.rumter.common_house_jogl.utils.MotionManager;
import org.rumter.common_house_jogl.utils.draw.DrawUtils;
import org.rumter.common_house_jogl.utils.draw.TextureUtils;
import org.rumter.common_house_jogl.utils.light.LightManager;
import org.rumter.common_house_jogl.utils.light.ShadowManager;

import com.jogamp.opengl.util.Animator;

public class App implements GLEventListener, KeyListener, MouseMotionListener {
	public static GLU glu = new GLU();

	public static GLProfile glp = GLProfile.getDefault();
	public static GLCapabilities caps = new GLCapabilities(glp);
	public static GLCanvas canvas = new GLCanvas(caps);

	public static Frame frame = new Frame("Jogl Common House");
	public static Animator animator = new Animator(canvas);

	public static TextureUtils texUtils;
	public static DrawUtils drawUtils;
	public static MotionManager motionManager;
	public static LightManager lightManager;
	public static ShadowManager shadowManager;

	public static Model world;

	public static GL2 gl;

	private static ArrayList<Long> t = new ArrayList<Long>();

	@Override
	public void display(GLAutoDrawable gLDrawable) {
		gl = gLDrawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		long t1 = System.currentTimeMillis();
		motionManager.display();
		world.display();
		t.add(System.currentTimeMillis() - t1);
	}

	public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
	}

	@Override
	public void init(GLAutoDrawable gLDrawable) {
		gl = gLDrawable.getGL().getGL2();
		gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
		gl.glClearColor(0.2f, 0.5f, 0.75f, 1.0f);
		// gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

		((Component) gLDrawable).addKeyListener(this);
		((Component) gLDrawable).addMouseMotionListener(this);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage("xparent.gif");
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new java.awt.Point(0, 0), "");
		frame.setCursor(blankCursor);

		texUtils = new TextureUtils();
		drawUtils = new DrawUtils();
		motionManager = new MotionManager();
		lightManager = new LightManager();
		shadowManager = new ShadowManager();
		world = new Map(0, 0, 0);
	}

	@Override
	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
		GL2 gl = gLDrawable.getGL().getGL2();
		if (height <= 0) {
			height = 1;
		}
		float h = (float) width / (float) height;
		gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(50.0f, h, 1.0, 1000.0);
		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			exit();
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			motionManager.go();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			motionManager.back();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			motionManager.right();
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			motionManager.left();
			break;
		case KeyEvent.VK_PAGE_UP:
			motionManager.up();
			break;
		case KeyEvent.VK_PAGE_DOWN:
			motionManager.down();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent me) {
	}

	float mouseX = 0, mouseY = 0;
	boolean isMouseMove = false;

	@Override
	public void mouseMoved(MouseEvent me) {
		if (isMouseMove) {
			motionManager.rotateHorizontal(me.getX() - mouseX);
			motionManager.rotateVertical(me.getY() - mouseY);
		}
		mouseX = me.getX();
		mouseY = me.getY();
		isMouseMove = true;
	}

	public static void exit() {
		Long sum = 0L;
		Long cnt = 0L;
		for (Long _t : t) {
			sum += _t;
			++cnt;
		}
		long result = 0;
		if (cnt > 0) {
			result = sum / cnt;
		}
		System.out.println("average display time = " + result + "ms");
		System.out.println("memory used = "
				+ ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024) + "MB");
		// average display time = 16ms
		// memory used = 30MB

		animator.stop();
		frame.dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		canvas.addGLEventListener(new App());
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setUndecorated(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		frame.setVisible(true);
		animator.start();
		canvas.requestFocus();
	}

	@Override
	public void dispose(GLAutoDrawable gLDrawable) {
		// do nothing
	}
}