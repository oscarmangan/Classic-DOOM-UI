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
    Rage ragelevel;
    Radar radar, radar2;
    Circle c1,c2,c3,c4,c5,c6,c7,c8;
    Spinner sp1,sp2,sp3,sp4;

    private ArrayList<Demon> demons = new ArrayList<Demon>();

    float buttonHeight = 35;
    float buttonWidth = 90;
    float buttonXBorder = 43;
    float buttonYBorder = 90;

    PImage img1, img2, img3, img4, img5, img6, uac, imgselect;

    String fetchDemon = " ";
    int t = 0;
    int z = 0;

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


    public void setup()
    {
       // b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, 680, height / 5, 50);
        radar2 = new Radar(this, -1, 120, height - height / 5, 50);
        c1 = new Circle(this, 2, 740, 250, 30, 2);
        c2 = new Circle(this, 2, 740, 300, 30, 2);
        c3 = new Circle(this, 2, 740, 350, 30, 2);
        c4 = new Circle(this, 2, 740, 400, 30, 2);
        c5 = new Circle(this, 2, 700, 250, 30, 2);
        c6 = new Circle(this, 2, 700, 300, 30, 2);
        c7 = new Circle(this, 2, 700, 350, 30, 2);
        c8 = new Circle(this, 2, 700, 400, 30, 2);

        //Loading spinner animations
        sp1 = new Spinner(this, 635, 245, 1);
        sp2 = new Spinner(this, 635, 335, 1);
        sp3 = new Spinner(this, 635, 425, 1);
        sp4 = new Spinner(this, 635, 515, 1);

        //Loading images into program
        img1 = loadImage("imp.png");
        img2 = loadImage("baron.png");
        img3 = loadImage("cacodemon.png");
        img4 = loadImage("hellghast.png");
        img5 = loadImage("revenant.png");
        img6 = loadImage("possessed.png");
        uac = loadImage("uac.png");

        //Rage meter
        ragelevel = new Rage(this, 0, 220, 410, 0, 50);

        //Loading and printing data from codex.csv
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

    public void drawXScanner()
    {
        stroke(110,0,0);
        strokeWeight(30);
        line(t,0,t,600);
        t++;
        if(t == 800)
        {
            t = 0;
        }
    }

    public void drawYScanner()
    {
        stroke(110,0,0);
        strokeWeight(30);
        line(0,z,800,z);
        z++;
        if(z == 600)
        {
            z = 0;
        }
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
            float x = buttonXBorder + (i * (buttonWidth)); //puts buttons in a row
            float y = buttonYBorder;
            fill(145,0,0);
            rect(x,y,buttonWidth,buttonHeight); //draws each button
            textAlign(LEFT, CENTER);
            fill(255);
            text(dem.getName(), x + 10, y + buttonHeight * 0.5f);
        }
    }

    public void mouseClicked()
    {
        int select = -1;

        if(mouseY > buttonYBorder && mouseY < buttonYBorder + buttonHeight)
        {
            for(int i = 0; i < demons.size(); i++)
            {
                float xButton = buttonXBorder + (i * (buttonWidth));
                if(mouseX > xButton && mouseX < xButton + buttonWidth)
                {
                    select = i;
                    break;
                }
            } 
        }

        if (select != -1) //if one of the buttons were clicked
        {
            fetchDemon = demons.get(select).toString();
        }

        if (select == 0)
        {
            imgselect = img1;
        }
        if (select == 1)
        {
            imgselect = img2;
        }
        if (select == 2)
        {
            imgselect = img3;
        }
        if (select == 3)
        {
            imgselect = img4;
        }
        if (select == 4)
        {
            imgselect = img5;
        }
        if (select == 5)
        {
            imgselect = img6;
        }
    }

    public void drawImageFrame()
    {
        textSize(25);
        fill(255);
        text("IMAGE:", 42, 150);
        stroke(255,0,0);
        fill(145, 0, 0);
        rect(43, 180, 202, 210);
    }

    public void displayDemonInfo()
    {
        textSize(25);
        fill(255);
        text("INFORMATION:", 262, 150);
        fill(145, 0, 0);
        rect(262, 180, 320, 210);
        textSize(23);
        fill(255);
        text("\nName: \nHealth: \nAttack: \nSpecial: \nOrigin: ", 272, 252);
        text(fetchDemon, 382, 270);
    }

    public void draw()
    {
        background(85,0,0);
        drawXScanner();
        drawYScanner();
        strokeWeight(3);
        stroke(255, 0, 0);
        line(30, 30, 710, 30);
        line(710, 30, 770, 90);
        line(30, 30, 30, 510);
        line(30, 510, 90, 570);
        line(90, 570, 770, 570);
        line(770, 570, 770, 90);
        fill(145,0,0);
        rect(220, 480, 362, 70);
        textSize(12);
        fill(255);
        text("Press Space to increase RAGE \nUse the mouse to select Demons", 230, 512);
        image(uac, 460, 486, width / 10, height / 10);

        //Radar
        radar.update();
        radar.render();
        radar2.update();
        radar2.render();

        //Animated circles
        c1.render();
        c1.updateY();
        c2.render();
        c2.updateY();
        c3.render();
        c3.updateY();
        c4.render();
        c4.updateY();
        c5.render();
        c5.updateY();
        c6.render();
        c6.updateY();
        c7.render();
        c7.updateY();
        c8.render();
        c8.updateY();

         //Animated spinners
         sp1.render();
         sp1.update();
         sp2.render();
         sp2.update();
         sp3.render();
         sp3.update();
         sp4.render();
         sp4.update();

        drawDemonButtons();
        drawImageFrame();
        displayDemonInfo();
        drawMouse();

        //Rage meter
        ragelevel.render();
        ragelevel.update();

        /*If loop to display the images once the user clicks on the specific demon button.
        Although messy, I used an if loop as Processing would not run any of the UI when using
        a method for this*/
        if(imgselect == img1)
        {
            image(img1, 43, 185);
        }
        if(imgselect == img2)
        {
            image(img2, 43, 185);
        }
        if(imgselect == img3)
        {
            image(img3, 43, 185);
        }
        if(imgselect == img4)
        {
            image(img4, 43, 185);
        }
        if(imgselect == img5)
        {
            image(img5, 43, 185);
        }
        if(imgselect == img6)
        {
            image(img6, 43, 185);
        }

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

