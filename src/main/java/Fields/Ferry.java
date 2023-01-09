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

    public void rent(Player player, FieldList fieldList) {
        System.out.println("Owner name" +super.getPlayer().getPlayerName());
        System.out.println("Turn name" +player.getPlayerName());
        int f=0;
        System.out.println("Player name" +player.getPlayerName());
        //  for(int i=0; i<lenght; i++){
        if (!((Ferry) fieldList.getFieldIndex(5)).getAvailability() &&
                ((Ferry) fieldList.getFieldIndex(5)).getPlayer().getPlayerName()==super.getPlayer().getPlayerName() ){
            System.out.println("Ferry 5 owned by" +((Ferry) fieldList.getFieldIndex(5)).getPlayer().getPlayerName());
            f++;} else {System.out.println("Ferry 5 is unowned or owned someone else");}

        if (!((Ferry) fieldList.getFieldIndex(15)).getAvailability() &&
                ((Ferry) fieldList.getFieldIndex(15)).getPlayer().getPlayerName()==super.getPlayer().getPlayerName()){
            System.out.println("Ferry 15 owned by" +((Ferry) fieldList.getFieldIndex(15)).getPlayer().getPlayerName());
            f++;} else {System.out.println("Ferry 15 is unowned or owned someone else");}

        if (!((Ferry) fieldList.getFieldIndex(25)).getAvailability() &&
                ((Ferry) fieldList.getFieldIndex(25)).getPlayer().getPlayerName()==super.getPlayer().getPlayerName()){
            System.out.println("Ferry 25 owned by" +((Ferry) fieldList.getFieldIndex(25)).getPlayer().getPlayerName());
            f++; } else {System.out.println("Ferry 25 is unowned or owned someone else");}

        if (!((Ferry) fieldList.getFieldIndex(35)).getAvailability() &&
                ((Ferry) fieldList.getFieldIndex(35)).getPlayer().getPlayerName()==super.getPlayer().getPlayerName()){
            System.out.println("Ferry 35 owned by" +((Ferry) fieldList.getFieldIndex(35)).getPlayer().getPlayerName());
            f++;} else {System.out.println("Ferry 25 is unowned or owned someone else");}


        System.out.println("Player    "+ super.getPlayer().getPlayerName() +"  owns "+f);

        if(f == 1) {
            player.getAccount().subtractionAccount(500);
            super.getPlayer().getAccount().additionAccount(500);
        } else if (f == 2) {
            player.getAccount().subtractionAccount(1000);
            super.getPlayer().getAccount().additionAccount(1000);
        } else if (f == 3) {
            player.getAccount().subtractionAccount(2000);
            super.getPlayer().getAccount().additionAccount(2000);
        } else if (f == 4) {
            player.getAccount().subtractionAccount(2000);
            super.getPlayer().getAccount().additionAccount(2000);
        } else {
            System.out.println("An error has occured.");
        }
    }
/*    public void rent(Player player) {
        int ferryCounter = 0;
        for(int i = 0; i < super.getPlayer().getProperty().length; i++) {
            if (super.getPlayer().getProperty()[i].getClass().equals(Ferry.class)) {
                ferryCounter++;
            }
                if(ferryCounter == 1) {
                    player.getAccount().subtractionAccount(500);
                    super.getPlayer().getAccount().additionAccount(500);
                } else if (ferryCounter == 2) {
                    player.getAccount().subtractionAccount(1000);
                    super.getPlayer().getAccount().additionAccount(1000);
                } else if (ferryCounter == 3) {
                    player.getAccount().subtractionAccount(2000);
                    super.getPlayer().getAccount().additionAccount(2000);
                } else if (ferryCounter == 4) {
                    player.getAccount().subtractionAccount(4000);
                    super.getPlayer().getAccount().additionAccount(4000);
                } else {
                    System.out.println("An error has occured.");
            }
        }
    }*/
}