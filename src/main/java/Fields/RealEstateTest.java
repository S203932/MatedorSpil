package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealEstateTest {

    // Method for buying property is tested:
    @Test
    void buyProperty() {
        RealEstate realEstate = new RealEstate();
        realEstate.setPrice(5000);
        Player player = new Player();
        player.getAccount().setAccount(5000);
        realEstate.buyProperty(player);
        assertEquals(0, player.getAccount().getAmount());

    }

    // Method for mortgage is tested:
    @Test
    void mortgageEstimation() {
        RealEstate realEstate = new RealEstate();
        realEstate.setPrice(500);
        Player player = new Player();
        player.setPlayerName("Peter");
        realEstate.setPlayer(player);

        player.getAccount().setAccount(5000);
        realEstate.mortgageEstimation(player);
        assertEquals(5250, player.getAccount().getAmount());
    }

    // Method for paying and receiving rent on an owned property is tested:
    @Test
    void rent() {
        RealEstate realEstate = new RealEstate();
        realEstate.setUpgrade(1);
        realEstate.setRent1(5);
        Player player = new Player();
        player.getAccount().setAccount(5);
        realEstate.setPlayer(player);
        Player player2 = new Player();
        player2.getAccount().setAccount((5));
        realEstate.rent(player2);

        assertEquals(0, player2.getAccount().getAmount());
        assertEquals(10, player.getAccount().getAmount());
    }
}