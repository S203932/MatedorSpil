package Fields;

import SupportClasses.Player;

import static java.lang.Math.round;


public abstract class Property extends Field {

    private int price;
    private boolean mortgage;
    private boolean availability;
    private Player player;

    public Property() {
        setPrice(0);
        setMortgage(false);
        setAvailability(true);
        setPlayer(player);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMortgage(boolean mortgage){
        this.mortgage=mortgage;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    public void setPlayer(Player player){
        this.player = player;
    }

    public int getPrice() {
        return this.price;
    }
    public boolean getMortgage(){
        return this.mortgage;
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public Player getPlayer() {
        return this.player;
    }

    // Method for buying af Property such as RealEstate, Brewery or Ferry
    public void buyProperty(Player player){
        this.availability = false;
        player.getAccount().subtractionAccount(this.price);
        this.player = player;
    }
    // Method for mortgage players property
  /*  public void mortgageProperty(Player player){
       int mortgagePrice=round(getPrice()/2);
       if(player.getPlayerName().equals(this.player.getPlayerName())){
        this.player.getAccount().additionAccount(mortgagePrice);}
        this.player = player;
        this.mortgage=true;
    }*/
    public void mortgageProperty(Player player) {
        if (!mortgage) {
            player.getAccount().additionAccount(price / 2);
            this.mortgage = true;
        }
    }
 //   public abstract void rent(Player player,);


    public String toString(){
        return "Position: "+getPosition();
    }
}