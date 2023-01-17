package Fields;

import SupportClasses.Player;

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

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getMortgage() {
        return this.mortgage;
    }

    public void setMortgage(boolean mortgage) {
        this.mortgage = mortgage;
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // Method for buying af Property such as RealEstate, Brewery or Ferry
    public void buyProperty(Player player) {
        this.availability = false;
        player.getAccount().subtractionAccount(this.price);
        this.player = player;
    }

    // Method for mortgage players property
    public void mortgageProperty(Player player) {
        if (!mortgage) {
            player.getAccount().additionAccount(price / 2);
            this.mortgage = true;
        }
    }

    public void buyBackMortgage(Player player) {
        if (mortgage) {
            player.getAccount().subtractionAccount(price / 2);
            this.mortgage = false;
        }
    }

    public String toString() {
        return "Position: " + getPosition();
    }
}