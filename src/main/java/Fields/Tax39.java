package Fields;
import SupportClasses.Player;

public class Tax39 extends Tax {

    public void rent(Player player){
        if(player.getPosition()==39){
            player.getAccount().subtractionAccount(2000);
        }
    }
}

