package ie.tudublin;

public class Spinner
{
    private float x;
    private float y;
    private float HALF_PI;
    UI ui;


    public Spinner(UI ui, float x, float y, float HALF_PI)
    {
        this.x = x;
        this.y = y;
        this.HALF_PI = HALF_PI;
        this.ui = ui;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255,85,0);
        ui.strokeWeight(3);
        ui.ellipse(x,y,70,70);

        ui.stroke(255);
        ui.strokeWeight(4);
        ui.ellipse(x,y,55,55);
        ui.pushMatrix();
        ui.fill(255);
        ui.strokeWeight(1);
        ui.arc(x,y,40,40,0,HALF_PI);
        ui.popMatrix();

        ui.strokeWeight(2);
    }
}