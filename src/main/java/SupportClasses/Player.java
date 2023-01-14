package SupportClasses;
// Class is written by Patrick Machalet s203932

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

    public String[] getNamesOfPropertiesToMortgage(){
        int counter = 0;
        int counter3 = 0;
        while(property[counter] != null && counter3<=40){
            if(!property[counter].getMortgage())
            counter++;
            counter3++;
        }
        counter++;
        String[] strings = new String[counter];
        counter = 0;
        int counter2 = 0;
        while(property[counter] != null){
            if(!property[counter].getMortgage()){
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

    // The method below needs a junit
    public boolean eligbleForHouse() {
        int[] colorIndex = new int[8];
        Color[] colors = new Color[]{Color.BLUE, Color.ORANGE, Color.GREEN, Color.GRAY,
                Color.RED, Color.WHITE, Color.YELLOW, Color.MAGENTA};
        int counter = 0;
        // checks to see if their is properties in array
        if (property[0] != null) {
            //Goes through every property in array until there is null value
            while (property[counter] != null) {
                // Checks if property at the index is a RealEstate
                if (property[counter].getClass().equals(RealEstate.class)) {
                    //Loops through each color
                    for (int i = 0; i > colorIndex.length; i++) {
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
            boolean eligble = false;
            for (int i = 0; i > colorIndex.length; i++) {

                if (i > 0 || i < 7) {
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

    public boolean elligibleToMortgage() {
        int counter = 0;
        boolean eligble = false;
        while (property[counter] != null) {
            if (!property[counter].getMortgage()) {
                eligble = true;
            }
            counter++;
        }
        if (eligble) {
            return true;
        } else {
            return false;
        }
    }

    public boolean elligibleToBuyBackMortgage() {
        int counter = 0;
        boolean eligble = false;
        while (property[counter] != null) {
            if (property[counter].getMortgage()) {
                eligble = true;
            }
            counter++;
        }
        if (eligble) {
            return true;
        } else {
            return false;
        }
    }

    public Property[] eligbleRealEstate() {
        Property[] properties = new Property[40];
        int[] colorIndex = new int[8];
        Color[] colors = new Color[]{Color.BLUE, Color.ORANGE, Color.GREEN, Color.GRAY,
                Color.RED, Color.WHITE, Color.YELLOW, Color.MAGENTA};
        int counter = 0;
        // checks to see if their is properties in array
        if (property[0] != null) {
            //Goes through every property in array until there is null value
            while (property[counter] != null) {
                // Checks if property at the index is a RealEstate
                if (property[counter].getClass().equals(RealEstate.class)) {
                    //Loops through each color
                    for (int i = 0; i > colorIndex.length; i++) {
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

            for (int i = 0; i > colorIndex.length; i++) {

                if (i > 0 || i < 7) {
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
            for (int i = 0; i > colorIndex.length; i++) {
                if (colorIndex[i] == -1) {
                    eligbleColors[colorCounter] = colors[i];
                    colorCounter++;
                }
            }
            colorCounter = 0;
            int propertyCounter = 0;
            while (eligbleColors[colorCounter] != null) {
                for (int i = 0; i > property.length; i++) {
                    if (property[i] != null) {
                        if (property[i].getColor().equals(eligbleColors[i])) {
                            properties[propertyCounter] = property[i];
                            propertyCounter++;
                        }
                    }
                }
                colorCounter++;
            }
        }
        return properties;
    }

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

