package Fields;
import SupportClasses.DiceCup;
import SupportClasses.Die;
import SupportClasses.Player;

public class GoJail extends Field {
    private int position;
    private String name;
    private int moveTo;

    // Position for active field for sending player to jail
    public GoJail() {
        setPosition(30);
        setName("De fængsles");
        setMoveTo(10);
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

        }

    }

    public void PayOutOfJail(Player player) {
        if (player.getJail() == 1) {
            player.getAccount().subtractionAccount(1000);
        }
    }
        public void HitOutOfJail(Player player, DiceCup dice){
            int[] dieValues = new int[2];
            dieValues[0] = dice.getIndexDie(0);
            dieValues[1] = dice.getIndexDie(1);
            if (player.getJail() == 1 && dieValues[0]==dieValues[1]) {
                        player.setJail(0);
                    }
            }
    }