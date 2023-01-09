package Fields;
import SupportClasses.DiceCup;
import SupportClasses.Player;

public class Brewery extends Property {
    private Player player;

    public void buyProperty(Player player) {
        super.buyProperty(player);
    }

    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageProperty(player, mortgagePrice);
    }

    public int[] dieTotal(DiceCup dice) {
        int[] dieValues = new int[2];
        dieValues[0] = dice.getIndexDie(0);
        dieValues[1] = dice.getIndexDie(1);
        return dieValues;
    }

    public void rent(Player player, FieldList fieldList, DiceCup dice) {
        System.out.println("Owner name" + super.getPlayer().getPlayerName());
        System.out.println("Turn name" + player.getPlayerName());
        int f = 0;
        System.out.println("Player name" + player.getPlayerName());
        if (!((Brewery) fieldList.getFieldIndex(12)).getAvailability() &&
                ((Brewery) fieldList.getFieldIndex(12)).getPlayer().getPlayerName() == super.getPlayer().getPlayerName()) {
            System.out.println("Brewery 5 owned by" + ((Brewery) fieldList.getFieldIndex(12)).getPlayer().getPlayerName());
            f++;
        } else {
            System.out.println("Brewery 12 is unowned or owned someone else");
        }

        if (!((Brewery) fieldList.getFieldIndex(28)).getAvailability() &&
                ((Brewery) fieldList.getFieldIndex(28)).getPlayer().getPlayerName() == super.getPlayer().getPlayerName()) {
            System.out.println("Brewery 15 owned by" + ((Brewery) fieldList.getFieldIndex(28)).getPlayer().getPlayerName());
            f++;
        } else {
            System.out.println("Brewery 15 is unowned or owned someone else");
        }

        System.out.println("Player    " + super.getPlayer().getPlayerName() + "  owns " + f);

        if (f == 1) {
            player.getAccount().subtractionAccount(dice.result() * 100);
            super.getPlayer().getAccount().additionAccount(dice.result() * 100);
        } else if (f == 2) {
            player.getAccount().subtractionAccount(dice.result() * 200);
            super.getPlayer().getAccount().additionAccount(dice.result() * 200);
        }
    /* public void rent(Player player) {
     }
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
    } */
    }
}
