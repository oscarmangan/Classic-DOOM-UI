package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 600);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(P3D); 
    }

    Radar radar;

    public void setup()
    {
       // b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, 680, height / 5, 50);
    }

    public void draw()
    {
        background(85,0,0);
        stroke(255, 0, 0);
        line(30, 30, 710, 30);
        line(710, 30, 770, 90);
        line(30, 30, 30, 510);
        line(30, 510, 90, 570);
        line(90, 570, 770, 570);
        line(770, 570, 770, 90);

        //Mouse cursor
        line(mouseX, mouseY, mouseX + width, mouseY);
        line(mouseX, mouseY, mouseX - width, mouseY);
        line(mouseX, mouseY, mouseX, mouseY + height);
        line(mouseX, mouseY, mouseX, mouseY - height);

        radar.update();
        radar.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

