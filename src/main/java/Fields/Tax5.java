package Fields;
import SupportClasses.Player;
import java.util.Scanner;

public class Tax5 extends Tax {

    public void rent(Player player, int optionTax) {
        if (optionTax==2){
            player.getAccount().subtractionAccount(4000);
        } else if (optionTax == 1) {
            int percentageTax = player.getAccount().getAmount() - player.getAccount().getAmount() / 10;
            player.getAccount().setAccount(percentageTax);
        }
    }
}
