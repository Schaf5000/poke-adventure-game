import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;




public class A 
{
	
	/** The texture that will hold the image details */
	private Texture texture;
	private Texture person;
	
	public int[][] karte;
	
	private boolean gehen;
	
	private String richtung;
	
	float x=0, y=0;
	
	/**
	 * Start the example
	 */
	public void start() {
		initGL(1024,640);
		init();
		
		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			render();
			
			move();
			
			Display.update();
			Display.sync(50);

			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}
	}
	
	private void move()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			richtung="links";
			x--;
			if(gehen)
			{
				gehen=false;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareL-G1.png");
			}
			else
			{
				gehen=true;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareL-G2.png");
			}
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			richtung="rechts";
			x++;
			if(gehen)
			{
				gehen=false;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareR-G1.png");
			}
			else
			{
				gehen=true;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareR-G2.png");
			}
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			richtung="oben";
			y--;
			if(gehen)
			{
				gehen=false;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareO-G1.png");
			}
			else
			{
				gehen=true;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareO-G2.png");
			}
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			richtung="unten";
			y++;
			if(gehen)
			{
				gehen=false;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareU-G1.png");
			}
			else
			{
				gehen=true;
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareU-G2.png");
			}
		}
		else
		{
			if(richtung=="rechts")
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareR-S.png");
			else if(richtung=="links")
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareL-S.png");
			else if(richtung=="oben")
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareO-S.png");
			else
				personbestimmen("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareU-S.png");
		}
		
		try {
			Thread.sleep(75);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x*32,y*32);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x*32+32, y*32);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x*32+32, y*32+32);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x*32, y*32+32);
		GL11.glEnd();
			
	}
	
	/**
	 * Initialise the GL display
	 * 
	 * @param width The width of the display
	 * @param height The height of the display
	 */
	private void initGL(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);               
        
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
        
        	// enable alpha blending
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        	GL11.glViewport(0,0,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	/**
	 * Initialise resources
	 */
	public void init() {
		
		try {
			// load texture from PNG file
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/test2.png"));
			person = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/FrauBlaueHaareR-S.png"));
			richtung="rechts";
			
			System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture width: "+texture.getTextureWidth());
			System.out.println(">> Texture height: "+texture.getTextureHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * draw a quad with the image on it
	 */
	public void render() {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(0,0);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(texture.getTextureWidth(),0);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(texture.getTextureWidth(),texture.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(0,texture.getTextureHeight());
		GL11.glEnd();
	}
	
	private void personbestimmen(String s)
	{
		try {
			person = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	private void kartemachen()
	{
		karte=new int[32][20];
		
	}*/
	/**
	 * Main Class
	 */
	public static void main(String[] argv) {
		A textureExample = new A();
		textureExample.start();
	}
}
