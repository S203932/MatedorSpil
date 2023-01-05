package Fields;
import SupportClasses.Player;

public class Tax5 extends Tax {

    public void rent(Player player) {
            player.getAccount().subtractionAccount(4000);
            int percentageTax = player.getAccount().getPengebeholdning() - player.getAccount().getPengebeholdning() / 10;

            player.getAccount().setAccount(percentageTax);

        }
}
