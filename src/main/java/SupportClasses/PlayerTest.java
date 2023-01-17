package SupportClasses;

import Fields.Field;
import Fields.FieldList;
import Fields.Property;
import Fields.RealEstate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends Property{

    @Test
    void diceRollPosition() {
        Player player = new Player();
        player.getAccount().setAccount(1000);
        player.setPosition(39);
        player.diceRollPosition(5);
        assertEquals(5000, player.getAccount().getAmount());
    }

    @Test
    void eligbleForHouse(){
        Player player = new Player();
        FieldList fieldList = new FieldList();
        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        player.eligbleForHouse();
        assert(player.eligbleForHouse());
    }
    @Test
    void eligbleRealEstateForHouses(){
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        assert(player.eligbleForHouse());
        Property[] property = player.eligbleRealEstateForHouses();
        assertEquals("Rødovrevej", property[0].getName());
        assertEquals("Hvidovrevej", property[1].getName());
    }

}