package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar
{
    private float radius;
    private PVector pos;
    private float frequency;
    private UI ui;
    private float theta = 0;

    public Radar(UI ui, float frequency, float x, float y, float radius)
    {
        this.ui = ui;
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255, 0, 0);
        ui.strokeWeight(2);
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        ui.ellipse(pos.x, pos.y, radius * 3, radius * 3);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.cos(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
        ui.line(pos.x, pos.y, pos.x + 75, pos.y);
        ui.line(pos.x, pos.y, pos.x - 75, pos.y);
        ui.line(pos.x, pos.y, pos.x, pos.y + 75);
        ui.line(pos.x, pos.y, pos.x, pos.y - 75);
    }

    float timeDelta = 0.5f / 60.0f;

    public void update()
    {
        theta += PApplet.TWO_PI * timeDelta * frequency;
        if(ui.checkKey(' '))
        {
            theta += 0.5f;
        }
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    
}