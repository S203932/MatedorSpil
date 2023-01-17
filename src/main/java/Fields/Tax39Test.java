package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tax39Test {

    // Testing tax field 39 subtraction methods
    @Test
    void rent() {
        Tax39 tax39 = new Tax39();
        Player player = new Player();
        player.setPosition(38);
        player.getAccount().setAccount(5000);
        tax39.rent(player);
        assertEquals(38, player.getPosition());
        assertEquals(3000, player.getAccount().getAmount());

    }
}
