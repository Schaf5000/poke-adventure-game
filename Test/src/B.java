import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import org.newdawn.slick.Image;

public class B 
{
	static Image Karte;
	
	static float länge;
	static int l;
	static float höhe;
	static int h;
	static int x;
	static int y;
	
	public static void main(String argv)
	{
			try {
				Karte = new Image("/Users/Linus Erhard/Documents/Informatik/Java-Eclipse/Test/test2.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		länge=Karte.getWidth();
		höhe=Karte.getHeight();
		
		int i;
		int t;
		for(i=0;i<länge;i++)
		{
			Image feld= Karte.getSubImage(x, y, 32, 32);
			Color h = feld.getColor(x, y);
			
			//textureExample.karte[i][t]=
		}
	}
}
