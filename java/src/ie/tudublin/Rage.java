package ie.tudublin;

import processing.core.PApplet;

public class Rage extends PApplet
{
    private float redMist;
    private float x;
    private float y;
    private float height;
    private float length;
    private UI ui;

    public Rage(UI ui, float redMist, float x, float y, float length, float height)
    {
        this.ui = ui;
        this.redMist = redMist;
        this.x = x;
        this.y = y;
        this.height = height;
        this.length = length;
    }

    public void render()
    {
        ui.strokeWeight(2);
        ui.stroke(255,0,0);
        ui.fill(145,0,0);
        ui.rect(x,y,362,50);
        ui.fill(255,0,0);
        ui.rect(x,y,length,height);
        ui.fill(255);
        ui.textSize(30);
        ui.text("RAGE METER", x + 10, y + 21);
    }

    public void update()
    {
        if(ui.checkKey(' '))
        {
            length++;
            if(length > 362)
            {
                length = 362;
            }
        }
        else
        {
            length--;
            if(length < 0)
            {
                length = 0;
            }
        }
    }

    /**
     * @return the redMist
     */
    public float getRedMist() {
        return redMist;
    }

    /**
     * @param redMist the redMist to set
     */
    public void setRedMist(float redMist) {
        this.redMist = redMist;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param length the width to set
     */
    public void setWidth(float length) {
        this.length = length;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}