package player;

import colours.Colour;

public abstract class Player
{
    Colour colour;
    String name;
    
    public Player(Colour colour, String name)
    {
        this.colour = colour;
        this.name = name;
    }
    
    public Colour getColour()
    {
        return colour;
    }
    
    public String getName()
    {
        return name;
    }
}
