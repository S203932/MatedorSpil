package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tax39Test {

    @Test
    void rent() {
        Tax39 tax39 = new Tax39();
        Player player = new Player();
        player.setPosition(39);
        player.getAccount().setAccount(5000);
        tax39.rent(player);
        assertEquals(39, player.getPosition());
        assertEquals(3000, player.getAccount().getAmount());

    }
}
