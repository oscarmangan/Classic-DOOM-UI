package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{
    boolean[] keys = new boolean[1024];
    Button b;

    float buttonHeight = 35;
    float buttonWidth = 90;

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
    Circle c1;
    Circle c2;
    Circle c3;
    Circle c4;

    public void setup()
    {
       // b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, 680, height / 5, 50);
        c1 = new Circle(this, 2, 740, 250, 30, 2);
        c2 = new Circle(this, 2, 740, 300, 30, 2);
        c3 = new Circle(this, 2, 740, 350, 30, 2);
        c4 = new Circle(this, 2, 740, 400, 30, 2);
        loadCSV();
        printCSV();
    }

    public void drawMouse()
    {
        line(mouseX, mouseY, mouseX + width, mouseY);
        line(mouseX, mouseY, mouseX - width, mouseY);
        line(mouseX, mouseY, mouseX, mouseY + height);
        line(mouseX, mouseY, mouseX, mouseY - height);
        noCursor();
    }
    public void drawDemonButtons()
    {
        textSize(40);
        fill(255);
        text("DOOM CODEX", 40, 60);
        stroke(255,85,0);
        textSize(13);
        for(int i = 0; i < demons.size(); i++)
        {
            Demon dem = demons.get(i);
            float x = 43 + (i * (buttonWidth)); //puts buttons in a row
            float y = 90;
            fill(205,0,0);
            rect(x,y,buttonWidth,buttonHeight); //draws each button
            textAlign(LEFT, CENTER);
            fill(255);
            text(dem.getName(), x + 10, y + buttonHeight * 0.5f);
        }
    }

    public void drawImageFrame()
    {
        textSize(25);
        fill(255);
        text("SNAPSHOT:", 42, 150);
        stroke(255,0,0);
        noFill();
        rect(43, 180, 202, 202);
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
        drawMouse();

        //Radar
        radar.update();
        radar.render();

        //Animated circles
        c1.render();
        c1.updateY();
        c2.render();
        c2.updateY();
        c3.render();
        c3.updateY();
        c4.render();
        c4.updateY();

        drawDemonButtons();
        drawImageFrame();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
    private ArrayList<Demon> demons = new ArrayList<Demon>();
}

