package Fields;

import SupportClasses.DiceCup;
import SupportClasses.Player;

public class Brewery extends Property {
    private Player player;
    public void buyProperty(Player player){
        super.buyProperty(player);
    }
    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageEstimation(player, mortgagePrice);
    }
    public void rent(Player player){
    }

}
