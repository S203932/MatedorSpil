package GUIController;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295
import ChanceCardsAndDeck.CardDeck;
import ChanceCardsAndDeck.ChanceCards;
import CreateAndWriteToAndFromTXT.ReadFile;
import Fields.*;
import SupportClasses.DiceCup;
import SupportClasses.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class GUIController {
    GUI_Field[] fields = setupGUIFields();
    private GUI gui = new GUI(fields);
    private DiceCup dice = new DiceCup(2);
    private GUI_Car car = new GUI_Car();
    private Player[] player;

    public GUI_Field[] setupGUIFields() {
        GUI_Field[] field = {
                new GUI_Start(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Tax(),

                new GUI_Shipping(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

                new GUI_Jail(), new GUI_Street(), new GUI_Brewery(), new GUI_Street(), new GUI_Street(),

                new GUI_Shipping(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

                new GUI_Refuge(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

                new GUI_Shipping(), new GUI_Street(), new GUI_Street(), new GUI_Brewery(), new GUI_Street(),

                new GUI_Jail(), new GUI_Street(), new GUI_Street(), new GUI_Chance(), new GUI_Street(),

                new GUI_Shipping(), new GUI_Chance(), new GUI_Street(), new GUI_Tax(), new GUI_Street()
        };
        return field;
    }

    //
    public GUI_Player[] setupBot(Player[] player) {
        GUI_Player[] GUI_player = new GUI_Player[player.length];
        GUI_Car tractor = new GUI_Car(Color.black, Color.white, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.CHECKERED);
        GUI_Car racecar = new GUI_Car(Color.red, Color.black, GUI_Car.Type.RACECAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Car ufo = new GUI_Car(Color.WHITE, Color.gray, GUI_Car.Type.UFO, GUI_Car.Pattern.DIAGONAL_DUAL_COLOR);
        GUI_Car car = new GUI_Car(Color.MAGENTA, Color.yellow, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car tractor1 = new GUI_Car(Color.ORANGE, Color.BLUE, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.DIAGONAL_DUAL_COLOR);
        GUI_Car ufo1 = new GUI_Car(Color.GREEN, Color.RED, GUI_Car.Type.UFO, GUI_Car.Pattern.DOTTED);
        GUI_Car[] vehicles = new GUI_Car[]{tractor, racecar, ufo, car, tractor1, ufo1};

        if ((player.length) == 2) {
            String[] nameArray = new String[2];
                int counter = 0;
                String playerName = "";
                if (counter == 0) {
                    playerName = gui.getUserString("Indtast spillerens navn");
                    player[0].setPlayerName(playerName);
                    player[0].getAccount().setAccount(30000);
                    GUI_player[0] = new GUI_Player(player[0].getPlayerName(), 30000, vehicles[0]);
                    gui.addPlayer(GUI_player[0]);
                    counter++;
                }
                while (counter == 1) {
                    String botName = gui.getUserString("Indtast Bottens navn (Må ikke være det samme som tidligere indtastet)");
                    if (!playerName.equalsIgnoreCase(botName)) {
                        player[1].setPlayerName(botName);
                        player[1].getAccount().setAccount(30000);
                        GUI_player[1] = new GUI_Player(player[1].getPlayerName(), 30000, vehicles[1]);
                        gui.addPlayer(GUI_player[1]);
                        return GUI_player;
                    } else {
                        gui.showMessage("navnet er optaget. Indtast nyt navn");
                    }
                }
            }
        return GUI_player;
    }
    public GUI_Player[] setupPlayers(Player[] player) {
        GUI_Player[] GUI_player = new GUI_Player[player.length];
        GUI_Car tractor = new GUI_Car(Color.black, Color.white, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.CHECKERED);
        GUI_Car racecar = new GUI_Car(Color.red, Color.black, GUI_Car.Type.RACECAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Car ufo = new GUI_Car(Color.WHITE, Color.gray, GUI_Car.Type.UFO, GUI_Car.Pattern.DIAGONAL_DUAL_COLOR);
        GUI_Car car = new GUI_Car(Color.MAGENTA, Color.yellow, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car tractor1 = new GUI_Car(Color.ORANGE, Color.BLUE, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.DIAGONAL_DUAL_COLOR);
        GUI_Car ufo1 = new GUI_Car(Color.GREEN, Color.RED, GUI_Car.Type.UFO, GUI_Car.Pattern.DOTTED);
        GUI_Car[] vehicles = new GUI_Car[]{tractor, racecar,ufo,car,tractor1,ufo1};
        if ((player.length) == 3) {
            String[] nameArray = new String[3];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : " + i);
                player[i] = new Player();
                String playerName = gui.getUserString("Indtast navn");
                int repeat = 0;
                for (int j = 0; j < nameArray.length; j++) {
                    if (playerName.equalsIgnoreCase(nameArray[j])) {
                        repeat = 1;
                        System.out.println("Navnet er optaget. Indtast nyt navn");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(30000);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 30000,vehicles[i]);
                gui.addPlayer(GUI_player[i]);
                if (repeat == 1) {
                    i = i - 1;
                }
            }
        } else if ((player.length) == 4) {
            String[] nameArray = new String[4];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : " + i);
                player[i] = new Player();
                String playerName = gui.getUserString("Indtast navn");
                int repeat = 0;
                for (int j = 0; j < nameArray.length; j++) {
                    if (playerName.equalsIgnoreCase(nameArray[j])) {
                        repeat = 1;
                        System.out.println("Navnet er  optaget. Indtast nyt navn");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(30000);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 30000, vehicles[i]);
                gui.addPlayer(GUI_player[i]);
                if (repeat == 1) {
                    i = i - 1;
                }
            }
        } else if ((player.length) == 5) {
            String[] nameArray = new String[5];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : " + i);
                player[i] = new Player();
                String playerName = gui.getUserString("Indtast navn");
                int repeat = 0;
                for (int j = 0; j < nameArray.length; j++) {
                    if (playerName.equalsIgnoreCase(nameArray[j])) {
                        repeat = 1;
                        System.out.println("Navnet er optaget. Indtast nyt navn");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(30000);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 30000, vehicles[i]);
                gui.addPlayer(GUI_player[i]);
                if (repeat == 1) {
                    i = i - 1;
                }
            }
        } else if ((player.length) == 6) {
            String[] nameArray = new String[6];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : " + i);
                player[i] = new Player();
                String playerName = gui.getUserString("Indtast navn");
                int repeat = 0;
                for (int j = 0; j < nameArray.length; j++) {
                    if (playerName.equalsIgnoreCase(nameArray[j])) {
                        repeat = 1;
                        System.out.println("Navnet er optaget. Indtast nyt navn");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(30000);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 30000, vehicles[i]);
                gui.addPlayer(GUI_player[i]);
                if (repeat == 1) {
                    i = i - 1;
                }
            }
        }
        return GUI_player;
    }

    public void takeTurn(Player player, GUI gui, GUI_Player gui_player, FieldList fieldList, GUI_Field[] fields, Player[] players) {
        String rollDie = gui.getUserButtonPressed("Det er " + player.getPlayerName() + "s tur.",
                "Tryk for at kaste med tegninger", "Tryk for at give op");
        if (rollDie.equalsIgnoreCase("Tryk for at kaste med tegninger")) {
            System.out.println("Dice has been rolled");
            dice.rollDice();
            gui.setDice(dice.getIndexDie(0), dice.getIndexDie(1));
            player.diceRollPosition(dice.result());
            GUI_Field field = gui.getFields()[player.getPosition()];
            gui_player.getCar().setPosition(field);

            int position=player.getPosition();
            // Check availability and buying free Property such as RealEstate, Ferry and Brewery
            if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(RealEstate.class) ||
                    fieldList.getFieldIndex(player.getPosition()).getClass().equals(Ferry.class) ||
                    fieldList.getFieldIndex(player.getPosition()).getClass().equals(Brewery.class)) {
                System.out.println("Field is a property");
                if (((Property) fieldList.getFieldIndex(player.getPosition())).getAvailability()) {
                    System.out.println("property is not owned");
                    String buy = gui.getUserButtonPressed("Grund " + fieldList.getFieldIndex(player.getPosition()).getName() +
                            " er til salg", "Køb grund", "Nej Tak");
                    //   gui.showMessage("The field is an unowned property, press the button to buy it.");
                    if (buy.equalsIgnoreCase("Køb grund")) {
                        ((Property) fieldList.getFieldIndex(player.getPosition())).buyProperty(player);
                        player.setProperty(((Property) fieldList.getFieldIndex(player.getPosition())));
                        fields[player.getPosition()].setSubText(player.getPlayerName());
                        gui_player.setBalance(player.getAccount().getAmount());
                    }

                    // Pay rent for owned RealEstate
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(RealEstate.class)&&
                        !((Property) fieldList.getFieldIndex(position)).getMortgage()) {           //Checking if property is pawned
                    System.out.println("RealEstate is owned");
                    gui.showMessage("Denne ejendomme er ejet. Tryk på knappen for at betale leje.");
                    ((RealEstate) fieldList.getFieldIndex(player.getPosition())).rent(player);

                    // Pay rent for owned Ferry
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Ferry.class)&&
                        !((Property) fieldList.getFieldIndex(position)).getMortgage()) {           //Checking if property is pawned
                    System.out.println("Ferry is owned");
                    gui.showMessage("Færge er ejet. Tryk på knappen for at betale leje,");
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);

                    // Pay rent for owned Brewery
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Brewery.class)&&
                        !((Property) fieldList.getFieldIndex(position)).getMortgage()) {        //Checking if property is pawned
                    System.out.println("Brewery is owned");
                    gui.showMessage("Bryggeri er ejet. Tryk på knappen for at betale leje.");
                    ((Brewery) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList, dice);
                }
            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Chance.class)) {


                //cardDeck.initilalizeCard();
                //cardDeck.cards();
                System.out.println("Field is a chance field");
                Chance chance = new Chance();
                CardDeck cardDeck = chance.getCardDeck();
                int randomNumber = (int) (Math.random() * 19) + 0;
                cardDeck.setCards();
                ChanceCards chanceCard = cardDeck.getCard(randomNumber);
                System.out.println(chanceCard.getDescription());
                chanceCard.cardAction(player, gui, fieldList, fields, gui_player, players);


            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Neutral.class)) {
                System.out.println("Field is of type Neutral");
                gui.showMessage("Tag' det roligt. Her sker ikke så meget \n" +
                        "Tryk på knappen for at gå vidder.");

            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax5.class) ||
                    fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax39.class)) {
                System.out.println("Field is of type Tax");

                if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax5.class)) {
                    System.out.println("Field is of type TAX5");
                    String choice = gui.getUserButtonPressed("Vælg om de ønsker at betale 10% af deres nuværende" +
                            " pengebeholdning eller om de ønsker at betale 4000 kr.", "Betal 10%", "Betal 4000 kr.");
                    if (choice.equalsIgnoreCase("Betal 10%")) {
                        ((Tax5) fieldList.getFieldIndex(player.getPosition())).rent(player, 1);
                        gui_player.setBalance(player.getAccount().getAmount());
                    } else {
                        ((Tax5) fieldList.getFieldIndex(player.getPosition())).rent(player, 2);
                        gui_player.setBalance(player.getAccount().getAmount());
                    }
                } else {
                    System.out.println("Field is of type TAX39");
                    ((Tax39) fieldList.getFieldIndex(player.getPosition())).rent(player);
                }

            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(GoJail.class)) {
                System.out.println("Field is of type GoJail");
                gui.showMessage("Beklager. De skal fængsel.");
                GoJail goJail = new GoJail();
                goJail.GoToJail(player);
                if (player.getJail() == 1) {
                    player.getAccount().additionAccount(-1);
                }
                player.setPosition(10);
                gui_player.getCar().setPosition(fields[10]);
            }
        } else {
            player.setForfeit(1);
            gui.showMessage("De er fallit. Deres ejendomme forbliver købte,\n"
                    + "men De kan ikke længere deltage i spillet.");
        }
        //Graphics setup to show players properties and show ability of pawning property
        String list = gui.getUserButtonPressed("Du ejer følgende Ejendomme:\n"
                + player.getNamesOfProperties(), "Afslut tur", "Pansætte ejedom");
        int end = 0;
        while (end == 0) {
            if (list.equalsIgnoreCase("Pansætte ejedom")) {
                if (player.getNamesOfProperties() == player.getNamesOfProperties()) {
                    String noPropertie = gui.getUserButtonPressed(player.getNamesOfProperties() + ""
                            + player.getNamesOfProperties(), "Afslut tur", "Tryk for at give op");
                    break;
                }
                int pawning = gui.getUserInteger("Vælg ejendommens position for at pansætte \n"
                        + player.getNamesOfProperties(), 1, 40);
                if ((fieldList.getFieldIndex(pawning - 1).getClass().equals(RealEstate.class)||
                        fieldList.getFieldIndex(pawning - 1).getClass().equals(Brewery.class)||
                        fieldList.getFieldIndex(pawning - 1).getClass().equals(Ferry.class))&&
                        !((Property) fieldList.getFieldIndex(pawning - 1)).getMortgage()&&
                        !((Property) fieldList.getFieldIndex(pawning-1)).getAvailability()) {
                    ((Property) fieldList.getFieldIndex(pawning - 1)).mortgageProperty(player);
                    end = 1;
                } else {
                    gui.showMessage("Denne ejedom kan ikke pantsættes. Vælg en anden ejedom");
                    continue;
                }
            } else {break;}
        }

    }





    public void GUIController(String filename, FieldList fieldlist) {
        ReadFile readFile = new ReadFile();
        ArrayList<String> stringArrayList = readFile.ReadFile(filename);
        int counter = 0;
        ((GUI_Start)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Start)gui.getFields()[counter]).setBackGroundColor(new Color(204, 0, 0));
        ((GUI_Start)gui.getFields()[counter]).setSubText("This is subtext");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris" +((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(0, 0, 255));
        //((GUI_Street)gui.getFields()[counter]).setHouses(3);
        //((GUI_Street)gui.getFields()[counter]).setHotel(true);
        counter++;

        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Chance)gui.getFields()[counter]).setSubText("Prøv Lykken");
        counter++;


        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris" +((RealEstate) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(0, 0, 255));
        counter++;

        ((GUI_Tax)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Tax)gui.getFields()[counter]).setSubText("Betal indkomstskat: 10% eller 4000 kr.");
        ((GUI_Tax)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 204));
        counter++;


        ((GUI_Shipping)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Shipping)gui.getFields()[counter]).setSubText("Pris" +((Ferry) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Shipping)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+".</strong></font><br>\n" +
                "Leje &emsp; &emsp; &emsp; &emsp;&emsp;kr.   "+((Ferry) fieldlist.getFieldIndex(counter)).getPrice()/8+" <br>\n" +
                "2 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/4+"<br>\n" +
                "3 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"<br>\n" +
                "4 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;


        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 102, 0));
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;


        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Chance)gui.getFields()[counter]).setSubText("Prøv Lykken");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 102, 0));
        counter++;


        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 102, 0));
        counter++;

        ((GUI_Jail)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Jail)gui.getFields()[counter]).setSubText(fieldlist.getFieldIndex(counter).getName());
        counter++;


        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        gui.getFields()[counter].setBackGroundColor(new Color(102, 255, 102));
        counter++;

        ((GUI_Brewery)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Brewery)gui.getFields()[counter]).setSubText("Pris: "+((Brewery) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Brewery)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong> Tuborg Squash.</strong></font>\n" +
                "<br>Ejes en virksomhed betales 100 gange hvad øjnene viser. <br><br>\n" +
                "Ejes Tuborg Squash og Coca-Cola, betales 200 gange øjenenes værdi.<br>\n" +
                "Pantværdi &emsp; kr. 1500<br><br><br></p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(102, 255, 102));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[14]).setBackGroundColor(new Color(102, 255, 102));
        counter++;

        ((GUI_Shipping)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Shipping)gui.getFields()[counter]).setSubText("Pris" +((Ferry) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Shipping)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+".</strong></font><br>\n" +
                "Leje &emsp; &emsp; &emsp; &emsp;&emsp;kr.   "+((Ferry) fieldlist.getFieldIndex(counter)).getPrice()/8+" <br>\n" +
                "2 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/4+"<br>\n" +
                "3 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"<br>\n" +
                "4 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(153, 153, 153));
        counter++;

        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Chance)gui.getFields()[counter]).setSubText("Prøv Lykken");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[18]).setBackGroundColor(new Color(153, 153, 153));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(153, 153, 153));
        counter++;

        ((GUI_Refuge)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Refuge)gui.getFields()[counter]).setSubText(((Neutral)fieldlist.getFieldIndex(counter)).getName());
        ((GUI_Refuge)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 204));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 0, 0));
        counter++;

        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(23));
        ((GUI_Chance)gui.getFields()[counter]).setSubText("Prøv Lykken");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 0, 0));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 0, 0));
        counter++;

        ((GUI_Shipping)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Shipping)gui.getFields()[counter]).setSubText("Pris" +((Ferry) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Shipping)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+".</strong></font><br>\n" +
                "Leje &emsp; &emsp; &emsp; &emsp;&emsp;kr.   "+((Ferry) fieldlist.getFieldIndex(counter)).getPrice()/8+" <br>\n" +
                "2 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/4+"<br>\n" +
                "3 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"<br>\n" +
                "4 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 255));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 255));
        counter++;

        ((GUI_Brewery)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Brewery)gui.getFields()[counter]).setSubText("Pris: "+((Brewery) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Brewery)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong> Tuborg Squash.</strong></font>\n" +
                "<br>Ejes en virksomhed betales 100 gange hvad øjnene viser. <br><br>\n" +
                "Ejes Tuborg Squash og Coca-Cola, betales 200 gange øjenenes værdi.<br>\n" +
                "Pantværdi &emsp; kr. 1500<br><br><br></p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 255));
        counter++;

        ((GUI_Jail)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Jail)gui.getFields()[counter]).setSubText(((GoJail)fieldlist.getFieldIndex(counter)).getName());
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 0));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 0));
        counter++;

        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Chance)gui.getFields()[counter]).setSubText(fieldlist.getFieldIndex(counter).getName());
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 0));
        counter++;

        ((GUI_Shipping)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Shipping)gui.getFields()[counter]).setSubText("Pris" +((Ferry) fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Shipping)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+".</strong></font><br>\n" +
                "Leje &emsp; &emsp; &emsp; &emsp;&emsp;kr.   "+((Ferry) fieldlist.getFieldIndex(counter)).getPrice()/8+" <br>\n" +
                "2 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/4+"<br>\n" +
                "3 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"<br>\n" +
                "4 rederier ejes\t &emsp; >>  "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((Ferry)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        counter++;

        ((GUI_Chance)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Chance)gui.getFields()[counter]).setSubText(fieldlist.getFieldIndex(counter).getName());
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(102, 0, 153));
        counter++;

        ((GUI_Tax)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Tax)gui.getFields()[counter]).setSubText("Betal 2000 kr.");
        ((GUI_Tax)gui.getFields()[counter]).setBackGroundColor(new Color(255, 255, 204));
        counter++;

        ((GUI_Street)gui.getFields()[counter]).setTitle(stringArrayList.get(counter+1));
        ((GUI_Street)gui.getFields()[counter]).setSubText("Pris: "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()+" kr.");
        ((GUI_Street)gui.getFields()[counter]).setDescription("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><font size=\"+1\"><strong>"+fieldlist.getFieldIndex(counter).getName()+"</strong></font><br>\n" +
                "Leje af grund &emsp; &emsp;kr.   "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent0()+" <br>\n" +
                "m/ 1 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent1()+"<br>\n" +
                ">> 2 hus\t&emsp;\t&emsp; &emsp; >>  "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent2()+"<br>\n" +
                ">> 3 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent3()+"<br>\n" +
                ">> 4 hus\t&emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent4()+"<br>\n" +
                ">> hotel &emsp;\t&emsp; &emsp; >> "+((RealEstate)fieldlist.getFieldIndex(counter)).getRent5()+"<br>\n" +
                "Opgraderingspris &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getUpgradeValue()+"<br>\n" +
                "Pantværdi &emsp; kr. "+((RealEstate)fieldlist.getFieldIndex(counter)).getPrice()/2+"</p> \n" +
                "</body>\t\n" +
                "</html>");
        ((GUI_Street)gui.getFields()[counter]).setBackGroundColor(new Color(102, 0, 153));
        counter++;


    }



    public GUI getGui(){
     return this.gui;
    }

    public GUI_Field[] getGUI_Fields(){
        return fields;
    }

     }

