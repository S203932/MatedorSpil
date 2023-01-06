package Fields;
import SupportClasses.Player;
import jdk.jfr.ContentType;

public class Ferry extends Property {
    public void buyProperty(Player player) {
        super.buyProperty(player);
    }

    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageProperty(player, mortgagePrice);
    }


    public void rent(Player player) {
        int ferryCounter = 0;
        for(int i = 0; i < super.getPlayer().getProperty().length; i++) {
            if (super.getPlayer().getProperty()[i].getClass().equals(Ferry.class)) {
                ferryCounter++;
            }
                if(ferryCounter == 1) {
                    player.getAccount().subtractionAccount(500);
                } else if (ferryCounter == 2) {
                    player.getAccount().subtractionAccount(1000);
                } else if (ferryCounter == 3) {
                    player.getAccount().subtractionAccount(2000);
                } else if (ferryCounter == 4) {
                    player.getAccount().subtractionAccount(4000);
                } else {
                    System.out.println("An error has occured.");
            }
        }
    }
}