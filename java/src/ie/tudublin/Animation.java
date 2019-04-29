package ie.tudublin;

public abstract class Animation
{
    protected float rotation;
    protected float speed;
    protected float position;
    protected UI ui;

    public Animation(float rotation, float speed, float position, UI ui)
    {
        this.rotation = rotation;
        this.speed = speed;
        this.position = position;
        this.ui = ui;
    }

    public abstract void update();

    public abstract void render();

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the position
     */
    public float getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(float position) {
        this.position = position;
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