package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Testing tax field 5 subtraction methods
class Tax5Test {

    @Test
    void rent() {
        Tax5 tax5 = new Tax5();
        Player player = new Player();
        player.getAccount().setAccount(5000);
        tax5.rent(player, 2);
        assertEquals(1000, player.getAccount().getAmount());

        player.getAccount().setAccount(5000);
        tax5.rent(player, 1);
        assertEquals(4500, player.getAccount().getAmount());
    }
}
