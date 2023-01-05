package Fields;
import SupportClasses.Player;

public class Tax39 extends Tax {
//Rent method for subtracting tax pay on field 39.
    public void rent(Player player){
        if(player.getPosition()==39){
            player.getAccount().subtractionAccount(2000);
        }
    }
}

