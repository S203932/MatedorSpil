package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest1 extends Property {

    @Test
    void buyProperty() {
        Player player = new Player();
        player.getAccount().setAccount(5000);
        player.setPlayerName("Thomas");
        Property property = new RealEstate();
        property.setPrice(2500);
        property.buyProperty(player);
        assertEquals(2500, player.getAccount().getAmount());
        assertEquals("Thomas",property.getPlayer().getPlayerName());


    }
    @Test
    void mortgageProperty() {
        Player player = new Player();
        setPrice(4000);
        player.getAccount().setAccount(5000);
        mortgageProperty(player);
        assertEquals(7000, player.getAccount().getAmount());
    }

  /*  @Test
    void mortgageProperty() {
        Player player = new Player();
        Ferry ferry = new Ferry();
        FieldList fieldList = new FieldList();
        RealEstate realEstate = new RealEstate();

        this.getPlayer().setProperty(ferry);
        fieldList.setupField("Dansk.txt");
        ((Ferry)fieldList.getFieldIndex(5).
        property.setMortgage(true);
        player.getAccount().setAccount(5000);
        property.mortgageProperty(player);
        assertEquals(7000, player.getAccount().getAmount());


    }*/
}