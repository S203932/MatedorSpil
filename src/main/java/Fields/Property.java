package Fields;
// Class is written by Kristian Urban 163301 and Zainab Hameed s204747

import SupportClasses.Player;

import java.awt.*;


public class Property extends Field {
    //

    private int value;
    private boolean availability;
    private int type;

    private Player player;

    public Property() {
        setValue(0);
        setAvailability(true);
        setType(-1);
        setColor(Color.black);
        setPlayer(player);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public int getType() {
        return this.type;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void buyProperty(Player player){
        this.availability = false;
        player.getAccount().subtractionAccount(this.value);
        this.player = player;
    }
    public void PayRentProperty(Player player){
            player.getAccount().subtractionAccount(this.value);
            this.player.getAccount().additionKonto(this.value);
    }

    public String toString(){
        return "Position: "+getPosition();
    }
}