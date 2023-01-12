package Fields;

import SupportClasses.DiceCup;
import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoJailTest {

    @Test
    void goToJail() {
        GoJail goJail = new GoJail();
        Player player = new Player();
        player.setFreejail(1);
        goJail.GoToJail(player);
        assertEquals(0, player.getFreejail());
        player.setPosition(10);
        player.setJail(0);
        goJail.GoToJail(player);
        assertEquals(1, player.getJail());
        player.setJail(1);
        goJail.GoToJail(player);
        assertEquals(0, player.getJail());
    }
    @Test
    void PayOutOfJail(){
        GoJail goJail = new GoJail();
        Player player = new Player();
        player.setJail(1);
        player.getAccount().setAccount(2000);
        goJail.PayOutOfJail(player);
        assertEquals(1000, player.getAccount().getAmount());
    }

    @Test
    void HitOutOfJail(){
        GoJail goJail = new GoJail();
        Player player = new Player();
        DiceCup dice = new DiceCup(2);
        int[] dieValues = new int[2];
        dieValues[0] = dice.getIndexDie(0);
        dieValues[1] = dice.getIndexDie(1);
        player.setJail(1);
        dieValues[0] = dieValues[1];
        goJail.HitOutOfJail(player, dice);
        assertEquals(0, player.getJail());
    }
}