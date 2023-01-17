package SupportClasses;


import Fields.FieldList;
import Fields.Property;
import Fields.RealEstate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends Property {

    @Test
    void diceRollPosition() {
        Player player = new Player();
        player.getAccount().setAccount(1000);
        player.setPosition(39);
        player.diceRollPosition(5);
        assertEquals(5000, player.getAccount().getAmount());
    }

    @Test
    void eligbleForHouse() {
        Player player = new Player();
        FieldList fieldList = new FieldList();
        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        player.eligbleForHouse();
        assert (player.eligbleForHouse());
    }

    @Test
    void eligbleRealEstateForHouses() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        assert (player.eligbleForHouse());
        Property[] property = player.eligbleRealEstateForHouses();
        assertEquals("Rødovrevej", property[0].getName());
        assertEquals("Hvidovrevej", property[1].getName());
    }

    @Test
    void hasProperties() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        player.hasProperties();
        assert (player.hasProperties());
    }

    @Test
    void propertiesWithHousesOnThem() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        ((RealEstate) fieldList.getFieldIndex(1)).setUpgrade(4);
        ((RealEstate) fieldList.getFieldIndex(3)).setUpgrade(4);
        Property[] property = player.propertiesWithHousesOnThem();
        assertEquals("Rødovrevej", property[0].getName());
        assertEquals("Hvidovrevej", property[1].getName());
    }

    @Test
    void getNamesOfPropertiesToMortgage() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));

        String[] estateNames = player.getNamesOfPropertiesToMortgage();
        assertEquals("Rødovrevej", estateNames[0]);
        assertEquals("Hvidovrevej", estateNames[1]);
    }

    @Test
    void getPropertiesToBuyBack() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        ((RealEstate) fieldList.getFieldIndex(1)).setMortgage(true);
        ((RealEstate) fieldList.getFieldIndex(3)).setMortgage(true);
        Property[] property = player.getPropertiesToBuyBack();
        assertEquals("Rødovrevej", property[0].getName());
        assertEquals("Hvidovrevej", property[1].getName());
    }

    @Test
    void getPropertiesThatCanMortgage() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        ((RealEstate) fieldList.getFieldIndex(1)).setMortgage(false);
        ((RealEstate) fieldList.getFieldIndex(3)).setMortgage(false);
        Property[] property = player.getPropertiesThatCanMortgage();
        assertEquals("Rødovrevej", property[0].getName());
        assertEquals("Hvidovrevej", property[1].getName());

    }

    @Test
    void getNamesOfPropertiesWithHouses() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        ((RealEstate) fieldList.getFieldIndex(1)).setUpgrade(4);
        ((RealEstate) fieldList.getFieldIndex(3)).setUpgrade(4);

        String[] estateNames = player.getNamesOfPropertiesWithHouses();
        assertEquals("Rødovrevej", estateNames[0]);
        assertEquals("Hvidovrevej", estateNames[1]);
    }

    @Test
    void getPropertiesToBuyBackNames() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));
        ((RealEstate) fieldList.getFieldIndex(1)).setUpgrade(4);
        ((RealEstate) fieldList.getFieldIndex(3)).setUpgrade(4);

        String[] estateNames = player.getNamesOfPropertiesWithHouses();
        assertEquals("Rødovrevej", estateNames[0]);
        assertEquals("Hvidovrevej", estateNames[1]);
    }

    @Test
    void getNamesOfPropertiesToBuyHouse() {
        Player player = new Player();
        FieldList fieldList = new FieldList();

        fieldList.setupField("Dansk.txt");
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));

        String[] estateNames = player.getNamesOfPropertiesToBuyHouse();
        assertEquals("Rødovrevej", estateNames[0]);
        assertEquals("Hvidovrevej", estateNames[1]);
    }
}
