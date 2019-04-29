package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{
    boolean[] keys = new boolean[1024];
    PImage img1, img2, img3, img4, img5, img6;
    Button b;

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
    
    public void loadCSV()
    {
        Table table = loadTable("codex.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Demon demon = new Demon(row);
            demons.add(demon);
        }
    }

    public void printCSV() {
        for (Demon demon : demons) {
            System.out.println(demon);
        }
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
        loadCSV();
        printCSV();
        img1 = loadImage("imp.png");
        img2 = loadImage("baron.png");
        img3 = loadImage("possessed.png");
        img4 = loadImage("revenant.png");
        img5 = loadImage("cacodemon.png");
        img6 = loadImage("hellghast.png");
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

        image(img2, 80, 100, width / 4, height / 4);


        //Mouse cursor
        line(mouseX, mouseY, mouseX + width, mouseY);
        line(mouseX, mouseY, mouseX - width, mouseY);
        line(mouseX, mouseY, mouseX, mouseY + height);
        line(mouseX, mouseY, mouseX, mouseY - height);
        noCursor();

        //UI Title
        textSize(40);
        text("DOOM CODEX", 40, 70);
        fill(255);

        //Radar
        radar.update();
        radar.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
    private ArrayList<Demon> demons = new ArrayList<Demon>();
}

