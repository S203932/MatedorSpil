package SupportClasses;

import Fields.Property;
import Fields.RealEstate;

import java.awt.*;

public class Player {
    private String name;
    private Account account;

    private Property[] property;

    private int position;
    private int jail;

    private int Freejail;

    private int forfeit;

    public Player() {
        setPlayerName("Player one");
        startAccount();
        setPosition(0);
        instantiateProperty();
        setJail(0);
        setFreejail(0);
        setForfeit(0);

    }

    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }

    public int getForfeit() {
        return forfeit;
    }

    public void setJail(int jail) {
        this.jail = jail;
    }

    public int getFreejail() {
        return Freejail;
    }

    public void setFreejail(int freejail) {
        this.Freejail = freejail;
    }

    public int getJail() {
        return jail;
    }

    public int getPosition() {
        return position;
    }

    public void diceRollPosition(int diceRoll) {
        int oldPosition = this.position;
        int newPosition = oldPosition + diceRoll;
        if ((newPosition) >= 40) {
            this.position = newPosition - 40;
            this.account.additionAccount(4000);
        } else if (newPosition == 0 && oldPosition != -1) {
            this.account.additionAccount(4000);
        } else {
            this.position = newPosition;
        }
    }

    public void setPosition(int position) {
        int oldPosition = this.position;
        this.position = position;
        if (position < oldPosition) {
            this.account.additionAccount(4000);
        }
    }

    public void setPlayerName(String navn) {
        this.name = navn;
    }

    public void startAccount() {
        this.account = new Account();
    }


    public Account getAccount() {
        return account;
    }

    public String getPlayerName() {
        return name;
    }

    public Property[] getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        int indexValue = 0;
        while (this.property[indexValue] != null) {
            indexValue++;
        }
        this.property[indexValue] = property;
    }

    public void instantiateProperty() {
        this.property = new Property[40];

    }

    public String getNamesOfProperties() {
        String string = "";
        int counter = 0;
        if (property[0] == null) {
            string = "De ejer ingen grunde";
        } else {
            while (property[counter] != null) {
                int i = 1;
                string = string + property[counter].getName() + " - position " + property[counter].getPosition() + " på brættet" + "\n";
                counter++;
            }
        }
        return string;
    }


   // Method returns an array of names on the properties that the players own and can mortgage. Last index is "Ingen af overstående"
    public String[] getNamesOfPropertiesToMortgage() {
        int counter = 0;
        int counter3 = 0;
        while (property[counter3] != null) {
            if (!property[counter3].getMortgage()) {
                counter++;
            }
            counter3++;
        }
        counter++;
        String[] strings = new String[counter];
        counter = 0;
        int counter2 = 0;
        while (property[counter] != null) {
            if (!property[counter].getMortgage()) {
                strings[counter2] = property[counter].getName();
                counter2++;
            }
            counter++;
        }
        strings[counter2] = "Ingen af overstående";
        return strings;
    }

    public String getPropertyName(int i) {
        String PropertyName = property[i].getName();
        return PropertyName;
    }



    //Method returns a boolean that indicates wether the player can buy houses or not
    public boolean eligbleForHouse() {
        int[] colorIndex = new int[8];
        Color[] colors = new Color[]{Color.BLUE, Color.ORANGE, Color.GREEN, Color.GRAY,
                Color.RED, Color.WHITE, Color.YELLOW, Color.MAGENTA};
        int counter = 0;
        // checks to see if there is properties in array
        if (property[0] != null) {
            //Goes through every property in array until there is null value
            while (property[counter] != null) {
                // Checks if property at the index is a RealEstate
                if (property[counter].getClass().equals(RealEstate.class)) {
                    //Loops through each color
                    for (int i = 0; i < colorIndex.length; i++) {
                        //Checks if the RealEstate share a color with the colors in the color array
                        // if it is the case then it ticks up that place in colorIndex array
                        if (property[counter].getColor().equals(colors[i])) {
                            colorIndex[i]++;
                        }
                    }
                }
                counter++;
            }
            //Checks colorIndex to see if there is 2 of the first or last or three of the rest of the colors.
            boolean eligble = false;
            for (int i = 0; i < colorIndex.length; i++) {

                if (i > 0 && i < 7) {
                    if (colorIndex[i] > 2) {
                        eligble = true;
                    }
                } else if (i == 0 || i == 7) {
                    if (colorIndex[i] > 1) {
                        eligble = true;
                    }
                }
            }
            if (eligble) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    //Method returns an array of properties the player can build houses on
    public Property[] eligbleRealEstateForHouses() {
        Property[] properties = new Property[40];
        int[] colorIndex = new int[8];
        Color[] colors = new Color[]{Color.BLUE, Color.ORANGE, Color.GREEN, Color.GRAY,
                Color.RED, Color.WHITE, Color.YELLOW, Color.MAGENTA};
        int counter = 0;
        Property[] eligibleProperties = new Property[40];
        // checks to see if there is properties in array
        if (property[0] != null) {
            //Goes through every property in array until there is null value
            while (property[counter] != null) {
                // Checks if property at the index is a RealEstate
                if (property[counter].getClass().equals(RealEstate.class)) {
                    //Loops through each color
                    for (int i = 0; i < colorIndex.length; i++) {
                        //Checks if the RealEstate share a color with the colors in the color array
                        // if it is the case then it ticks up that place in colorIndex array
                        if (!property[counter].getMortgage()) {
                            if (property[counter].getColor().equals(colors[i])) {
                                colorIndex[i]++;
                            }
                        }
                    }
                }
                counter++;
            }
            //Checks colorIndex to see if there is 2 of the first or last or three of the rest of the colors.

            for (int i = 0; i < colorIndex.length; i++) {

                if (i > 0 && i < 7) {
                    if (colorIndex[i] > 2) {
                        colorIndex[i] = -1;

                    }
                } else if (i == 0 || i == 7) {
                    if (colorIndex[i] > 1) {
                        colorIndex[i] = -1;
                    }
                }
            }

            // Reverts the color index to colors
            Color[] eligbleColors = new Color[8];
            int colorCounter = 0;
            for (int i = 0; i < colorIndex.length; i++) {
                if (colorIndex[i] == -1) {
                    eligbleColors[colorCounter] = colors[i];
                    colorCounter++;
                }
            }
            colorCounter = 0;
            int propertyCounter = 0;
            while (eligbleColors[colorCounter] != null) {
                for (int i = 0; i < property.length; i++) {
                    if (property[i] != null) {
                        if (property[i].getColor().equals(eligbleColors[colorCounter])) {
                            //if (((RealEstate) property[i]).getUpgrade() < 5) {
                                properties[propertyCounter] = property[i];
                                propertyCounter++;
                            //}
                        }
                    }
                }
                colorCounter++;
            }
            counter = 0;
            int upgrade = -1;
            int identicalUpgrade = 0;
            // Runs through all the eligible colors
            for (int i = 0; i < eligbleColors.length; i++) {
                // runs through all the properties
                for (int j = 0; j < properties.length; j++) {
                    if (properties[j] != null) {
                        // Checks if the properties is of the current color
                        if (properties[j].getColor().equals(eligbleColors[i])) {
                            if (((RealEstate) properties[j]).getUpgrade() == upgrade) {
                                identicalUpgrade++;
                            }
                            // checks if the upgrade value is the highest one so far
                            if (((RealEstate) properties[j]).getUpgrade() > upgrade) {
                                upgrade = ((RealEstate) properties[j]).getUpgrade();
                            }
                        }
                    }

                }
                for (int j = 0; j < properties.length; j++) {
                    if (properties[j] != null) {
                        if (properties[j].getColor().equals(eligbleColors[i])) {
                            if (((RealEstate) properties[j]).getUpgrade() < upgrade || ((identicalUpgrade == 1) &&
                                    (eligbleColors[i].equals(Color.BLUE) || eligbleColors[i].equals(Color.MAGENTA))) ||
                                    (identicalUpgrade == 2)) {
                                if (((RealEstate) properties[j]).getUpgrade() < 5) {
                                    eligibleProperties[counter] = properties[j];
                                    counter++;
                                }
                            }
                        }
                    }

                }

            }
        }
        return eligibleProperties;
    }


    //Method to get the names of the properties where the player can buy houses, last index is "Ingen af overstående"
    public String[] getNamesOfPropertiesToBuyHouse() {
        int counter = 0;
        Property[] properties = eligbleRealEstateForHouses();
        while (properties[counter] != null) {
            counter++;
        }
        counter++;
        String[] strings = new String[counter];
        counter = 0;
        while (properties[counter] != null) {
            strings[counter] = properties[counter].getName();
            counter++;
        }
        strings[counter] = "Ingen af overstående";
        return strings;
    }

    //Method returns a boolean wether or not the player has houses to sell
    public boolean eligibleToSellHouse() {
        int counter = 0;
        boolean eligible = false;
        while (property[counter] != null) {
            if (property[counter].getClass().equals(RealEstate.class)) {
                if (((RealEstate) property[counter]).getUpgrade() > 0) {
                    eligible = true;
                }
            }
            counter++;
        }
        return eligible;


    }

    // method that returns the properties, where the player can buy back their mortgage
    public Property[] getPropertiesToBuyBack() {
        int counter = 0;
        int counter2 = 0;
        Property[] properties = new Property[40];
        while (property[counter] != null) {
            if (property[counter].getMortgage()) {
                properties[counter2] = property[counter];
                counter2++;
            }
            counter++;
        }
        return properties;
    }

    // method that returns the names of the properties that the player can buy back
    public String[] getPropertiesToBuyBackNames() {
        Property[] properties = getPropertiesToBuyBack();
        int counter = 0;
        while (properties[counter] != null) {
            counter++;
        }
        counter++;
        String[] strings = new String[counter];
        counter = 0;
        while (properties[counter] != null) {
            strings[counter] = properties[counter].getName();
            counter++;
        }
        strings[counter] = "Ingen af overstående";
        return strings;
    }


    //method that returns the properties with houses on them
    public Property[] propertiesWithHousesOnThem() {
        int counter = 0;
        int counter2 = 0;
        Property[] properties = new Property[40];
        while (property[counter] != null) {
            if (property[counter].getClass().equals(RealEstate.class)) {
                if (((RealEstate) property[counter]).getUpgrade() > 0) {
                    properties[counter2] = property[counter];
                    counter2++;
                }
            }
            counter++;
        }
        return properties;
    }

    // Method that returns the names of properties which are upgraded, last index is "Ingen af overstående"
    public String[] getNamesOfPropertiesWithHouses() {
        int counter = 0;
        Property[] properties = propertiesWithHousesOnThem();
        while (properties[counter] != null) {
            counter++;
        }
        counter++;
        String[] strings = new String[counter];
        counter = 0;
        while (properties[counter] != null) {
            strings[counter] = properties[counter].getName();
            counter++;
        }
        strings[counter] = "Ingen af overstående";
        return strings;
    }

    public Property[] getPropertiesThatCanMortgage() {
        int counter = 0;
        int counter2 = 0;
        Property[] properties = new Property[40];
        while (property[counter] != null) {
            if (!property[counter].getMortgage()) {
                properties[counter2] = property[counter];
                counter2++;
            }
            counter++;
        }
        return properties;
    }

    // Method to see if the player has properties
    public boolean hasProperties() {
        boolean ownsProperty = false;
        if (property[0] != null) {
            ownsProperty = true;
        }
        return ownsProperty;
    }


    public String toString() {
        int counter = 0;
        String string = "Player's name: " + name + "\n";
        string = string + name + "'s position: " + position + "\n";
        string = string + name + "'s balance: " + account.getAmount() + "\n";
        string = string + name + "'s jail value: " + jail + "\n";
        string = string + name + "'s forfeit value: " + forfeit + "\n";
        if (property[0] == null) {
            string = string + name + " has no properties";
        } else {
            while (property[counter] != null) {
                string = string + name + " has the property \" " + property[counter].getName() + "\"" +
                        " which is at postion: " + property[counter].getPosition() + " on the board \n";
                counter++;
            }
        }
        return string;
    }
}

