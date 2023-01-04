package Fields;
// Class is written by Nataliia Khaiko s224295 and Patrick Machalet s203932
public class NeutralFields extends Field{
    private int position;
    private String name;

    public NeutralFields(){
        initializePosition();
        initializeName();
    }

    public void initializePosition(){
        this.position = -1;
    }

    public void initializeName(){
        this.name = "No name entered";
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "The name of the field is: "+this.name+" and the position is: "+this.position;
    }
}
