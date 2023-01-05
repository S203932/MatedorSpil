package Fields;
// Class is written by Daniel Stensen s211449 and Fayyad Mahmoud S224266
import SupportClasses.Player;

public class GoJail extends Field{
    private int position;
    private String name;
    private int moveTo;
    //Position for active fields for moving player to jail
    public GoJail() {
        setPosition(31);
        setName("De Fængsles");
        setMoveTo(11);
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

    public int getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(int moveTo) {
        this.moveTo = moveTo;
    }

    // Function for having the player in jail
    public void GoToJail(Player player){
        player.setPosition(11);
        if(player.getJail()==0){
            player.setJail(1);
        }else{
            player.setJail(0);
        }

        //Deduction from players account for getting out
        player.getAccount().subtractionAccount(1000);

    }
}
