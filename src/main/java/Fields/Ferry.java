package Fields;
import SupportClasses.Player;

public class Ferry extends Property{
    public void buyProperty(Player player){
        super.buyProperty(player);
    }
    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageProperty(player, mortgagePrice);
    }
    public void rent(Player player){
        player.getAccount().subtractionAccount(5000);
        super.getPlayer().getAccount().additionAccount(5000);

    }
}
