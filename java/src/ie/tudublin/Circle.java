package ie.tudublin;



public class Circle
{
    protected float rotation;
    protected float x;
    protected float y;
    protected float diameter;
    protected float speed;
    protected UI ui;

    public Circle(UI ui, float rotation, float x, float y, float diameter, float speed)
    {
        this.rotation = rotation;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.ui = ui;
        this.speed = speed;
    }

    public void render()
    {
        ui.pushMatrix();
        ui.stroke(255,0,0);
        ui.noFill();
        ui.ellipse(x, y, diameter, diameter);
        ui.fill(255,0,0);
        ui.ellipse(x, y, diameter / 3, diameter / 3);
        ui.rotate(rotation);
        ui.popMatrix();
    }

    public void updateY()
    {
        y += speed;
        if ((y > ui.height - diameter - 30 || (y < 230)))
        {
            speed *= -1;
        }
    }
    
}