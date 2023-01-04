package Fields;
import SupportClasses.Player;

import java.awt.*;

public abstract class Field {
    private String name;
    private int position;
    private Color color;
    private int type;

    public Field(){
        setName("Noname");
        setPosition(-1);
        setColor(Color.black);
        setType(-1);
    }

    public void setType(int type) {this.type=type;}
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public String setName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void rent(Player player){};

    @Override
    public String toString(){
        return "This field is a : " + this.getClass().getSimpleName();
    }
}
