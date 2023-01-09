package Fields;
import SupportClasses.DiceCup;
import SupportClasses.Player;

public class Brewery extends Property {
    private Player player;
    public void buyProperty(Player player){
        super.buyProperty(player);
    }
    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageProperty(player, mortgagePrice);
    }

        public int[] dieTotal(DiceCup dice){
        int[] dieValues = int[2];
        dieValues[0] = dice.getIndexDie(0);
        dieValues[1] = dice.getIndexDie(1);
        return dieValues;
        }
        public void rent(Player player, Brewery){
        int breweryCounter = 0;
        for(int i = 0; i < super.getPlayer().getProperty().length; i++) {
            if (super.getPlayer().getProperty()[i].getClass().equals(Brewery.class)) {
            breweryCounter++;
        }
            if(breweryCounter == 1){
                int breweryRent = player.getAccount().getAmount() + dieTotal() * 100;
                player.getAccount().setAccount(breweryRent);
            } else if(breweryCounter == 2) {
                int breweryRent = player.getAccount().getAmount() + dieTotal() * 200;
                player.getAccount().setAccount(breweryRent);
            } else {
                System.out.println("An error has occured. There is no brewery registered to this player.");
            }
        }
    }
}
