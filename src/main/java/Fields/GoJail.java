package Fields;
// Class is written by Daniel Stensen s211449 and Fayyad Mahmoud S224266
import SupportClasses.Player;

public class GoJail extends Field {
    private int position;
    private String name;
    private int moveTo;

    // Position for active field for sending player to jail
    public GoJail() {
        setPosition(31);
        setName("De fængsles");
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
    public void GoToJail(Player player) {
        //Checks if player has a "Get out of jail free" - card.
        if (player.getFreejail() == 1) {
            player.setFreejail(0);
        } else {
            player.setPosition(10);
            if (player.getJail() == 0) {
                player.setJail(1);
            } else {
                player.setJail(0);
            }

            //Transfers amount from player account for exiting jail
            player.getAccount().subtractionAccount(1000);

        }
    }
}