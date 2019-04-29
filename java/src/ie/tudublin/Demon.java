package ie.tudublin;

import processing.data.TableRow;

public class Demon
{
    private String name;
    private int health;
    private int attack;
    private String special;
    private String origin;



    //Getters and setters
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setHealth (int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    public void setAttack (int attack)
    {
        this.attack = attack;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setSpecial(String special)
    {
        this.special = special;
    }

    public String getString()
    {
        return special;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getOrigin()
    {
        return origin;
    }

    public String toString()
    {
        return name + "\t" + health + "\t" + attack + "\t" + special + "\t" + origin;  
    }

    public Demon(TableRow row)
    {
        name = row.getString("Name");
        health = row.getInt("Health");
        attack = row.getInt("Attack");
        special = row.getString("Special");
        origin = row.getString("Origin");
    }

    public Demon() 
    {

    }
}