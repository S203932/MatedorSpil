package SupportClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void diceRollPosition() {
        Player player = new Player();
        player.getAccount().setAccount(1000);
        player.setPosition(39);
        player.diceRollPosition(5);
        assertEquals(5000, player.getAccount().getAmount());
    }
}