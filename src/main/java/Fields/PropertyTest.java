package Fields;

import SupportClasses.Player;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    @org.junit.jupiter.api.Test
    void buyProperty() {
        Property property = new Property();
        property.setValue(3);
        Player player = new Player();
        player.getAccount().setAccount(3);
        property.buyProperty(player);
        assertEquals(0, player.getAccount().getPengebeholdning());
    }

    @org.junit.jupiter.api.Test
    void payRentProperty() {
        Property property = new Property();
        property.setValue(3);
        Player player = new Player();
        player.getAccount().setAccount(3);
        property.setPlayer(player);
        Player player2 = new Player();
        player2.getAccount().setAccount(3);
        property.PayRentProperty(player2);
        assertEquals(0,player2.getAccount().getPengebeholdning());
        assertEquals(6,player.getAccount().getPengebeholdning());

    }
}