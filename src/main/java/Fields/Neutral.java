package Fields;

public class Neutral extends Field {
    private int position;
    private String name;

    public Neutral() {
        initializePosition();
        initializeName();
    }

    public void initializePosition() {
        this.position = -1;
    }

    public void initializeName() {
        this.name = "No name entered";
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "The name of the field is: " + this.name + " and the position is: " + this.position;
    }
}
