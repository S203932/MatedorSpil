package Fields;
import SupportClasses.Player;
import java.util.Scanner;

public class Tax5 extends Tax {
    //Creating options for tax pay on tax field 5.
    public void rent(Player player, int optionTax) {
        if (optionTax==2){
            player.getAccount().subtractionAccount(4000);
        } else if (optionTax == 1) {
            int playertotal = 0;
            int tomp = 0;
            for (int i = 0; i < player.getProperty().length; i++) {
                if (player.getProperty()[i].getClass().equals(RealEstate.class)){
                    tomp = ((RealEstate)player.getProperty()[i]).getUpgrade();
                    playertotal += tomp*((RealEstate) player.getProperty()[i]).getUpgradeValue();
                    playertotal += player.getProperty()[i].getPrice();
                }
            }
            playertotal += player.getAccount().getAmount();
            player.getAccount().subtractionAccount(playertotal / 10);
        }
    }
}
