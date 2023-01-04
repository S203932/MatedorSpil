package Fields;
// Class is written by Kristian Urban 163301 and Zainab Hameed s204747
import java.awt.*;

public class Field {
    private int position;
    private String name;

    private Color color;

    public Field(){
        setName("Noname");
        setPosition(-1);
        setColor(Color.black);
    }

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

    @Override
    public String toString(){
        return "This field is a : " + this.getClass().getSimpleName();
    }
}
