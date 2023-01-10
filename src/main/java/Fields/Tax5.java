package Fields;
import SupportClasses.Player;
import java.util.Scanner;

public class Tax5 extends Tax {
    //Creating options for tax pay on tax field 5.
    public void rent(Player player, int optionTax) {
        if (optionTax==2){
            player.getAccount().subtractionAccount(4000);
        } else if (optionTax == 1) {
            player.getAccount().subtractionAccount(player.getAccount().getAmount() / 10);
        }
    }
}
