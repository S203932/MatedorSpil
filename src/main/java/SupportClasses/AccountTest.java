package SupportClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void subtractionAccount() {
        Player player = new Player();
        player.getAccount().setAccount(1000);
        player.getAccount().subtractionAccount(500);
        assertEquals(500, player.getAccount().getAmount());
    }

    @Test
    void additionAccount() {
        Player player = new Player();
        player.getAccount().setAccount(1000);
        player.getAccount().additionAccount(500);
        assertEquals(1500, player.getAccount().getAmount());
    }
}