package Fields;
import SupportClasses.Player;
import java.util.Scanner;

public class Tax5 extends Tax {
    //Creating options for tax pay on tax field 5.
    public void rent(Player player, int optionTax) {
        int playertotal = 0;
        int tomp = 0;
        int counter = 0;
        if (optionTax==2){
            player.getAccount().subtractionAccount(4000);
        } else if (optionTax == 1) {

            while(player.getProperty()[counter]!= null){
                if (player.getProperty()[counter].getClass().equals(RealEstate.class)){
                    tomp = ((RealEstate)player.getProperty()[counter]).getUpgrade();
                    playertotal += tomp*((RealEstate) player.getProperty()[counter]).getUpgradeValue();
                    playertotal += player.getProperty()[counter].getPrice();
                }
            }
            playertotal += player.getAccount().getAmount();
            player.getAccount().subtractionAccount(playertotal / 10);
            }

        }
    }

