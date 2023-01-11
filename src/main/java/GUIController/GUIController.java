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
                        fields[player.getPosition()].setDescription("Is owned by: " + player.getPlayerName());
                        gui_player.setBalance(player.getAccount().getAmount());
                    }

                    // Pay rent for owned RealEstate
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(RealEstate.class)) {
                    System.out.println("RealEstate is owned");
                    gui.showMessage("Denne ejendomme er ejet. Tryk på knappen for at betale leje.");
                    ((RealEstate) fieldList.getFieldIndex(player.getPosition())).rent(player);

                    // Pay rent for owned Ferry
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Ferry.class)) {
                    System.out.println("Ferry is owned");
                    gui.showMessage("Færge er ejet. Tryk på knappen for at betale leje,");
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);

                    // Pay rent for owned Brewery
                } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Brewery.class)) {
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
                    } else {
                        ((Tax5) fieldList.getFieldIndex(player.getPosition())).rent(player, 2);
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
        if (list.equalsIgnoreCase("Pansætte ejedom")) {
            int pawning = gui.getUserInteger("Vælg ejendommens position for at pansætte \n"
                    + player.getNamesOfProperties(), 1, 40);

            if (!((Property) fieldList.getFieldIndex(pawning - 1)).getMortgage()) {
                ((Property) fieldList.getFieldIndex(pawning - 1)).mortgageProperty(player);
            } else {
                gui.showMessage("Denne ejedom er pantsæt. Vælg en anden ejedom");
            }
        }

    }





    public void GUIController(String filename) {
        ReadFile readFile = new ReadFile();
        ArrayList<String> stringArrayList = readFile.ReadFile(filename);
        gui.getFields()[0].setTitle(stringArrayList.get(1));
        gui.getFields()[0].setBackGroundColor(new Color(204, 0, 0));

        gui.getFields()[1].setTitle(stringArrayList.get(2));
        gui.getFields()[1].setSubText("Pris: 1200 kr.");
        gui.getFields()[1].setBackGroundColor(new Color(0, 0, 255));

        gui.getFields()[2].setTitle(stringArrayList.get(3));
        gui.getFields()[2].setSubText("Prøv Lykken");

        gui.getFields()[3].setTitle(stringArrayList.get(4));
        gui.getFields()[3].setSubText("Pris: 1200 kr.");
        gui.getFields()[3].setBackGroundColor(new Color(0, 0, 255));

        gui.getFields()[4].setTitle(stringArrayList.get(5));
        gui.getFields()[4].setSubText("Betal indkomstskat: 10% eller 4000 kr.");
        gui.getFields()[4].setBackGroundColor(new Color(255, 255, 204));


        gui.getFields()[5].setTitle(stringArrayList.get(6));
        gui.getFields()[5].setSubText("Scanlines");

        gui.getFields()[6].setTitle(stringArrayList.get(7));
        gui.getFields()[6].setSubText("Pris: 2000 kr.");
        gui.getFields()[6].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[7].setTitle(stringArrayList.get(8));
        gui.getFields()[7].setSubText("Prøv Lykken");


        gui.getFields()[8].setTitle(stringArrayList.get(9));
        gui.getFields()[8].setSubText("Pris: 2000 kr.");
        gui.getFields()[8].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[9].setTitle(stringArrayList.get(10));
        gui.getFields()[9].setSubText("Pris: 2400 kr.");
        gui.getFields()[9].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[10].setTitle(stringArrayList.get(11));
        gui.getFields()[10].setSubText("På besøg");


        gui.getFields()[11].setTitle(stringArrayList.get(12));
        gui.getFields()[11].setSubText("Pris: 2800 kr.");
        gui.getFields()[11].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[12].setTitle(stringArrayList.get(13));
        gui.getFields()[12].setSubText("Pris: 3000 kr.");

        gui.getFields()[13].setTitle(stringArrayList.get(14));
        gui.getFields()[13].setSubText("Pris: 2800 kr.");
        gui.getFields()[13].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[14].setTitle(stringArrayList.get(15));
        gui.getFields()[14].setSubText("Pris: 3200 kr.");
        gui.getFields()[14].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[15].setTitle(stringArrayList.get(16));
        gui.getFields()[15].setSubText("Pris: 4000 kr.");

        gui.getFields()[16].setTitle(stringArrayList.get(17));
        gui.getFields()[16].setSubText("Pris: 3600 kr.");
        gui.getFields()[16].setBackGroundColor(new Color(153, 153, 153));

        gui.getFields()[17].setTitle(stringArrayList.get(18));
        gui.getFields()[17].setSubText("Prøv Lykken");

        gui.getFields()[18].setTitle(stringArrayList.get(19));
        gui.getFields()[18].setSubText("Pris: 3600 kr.");
        gui.getFields()[18].setBackGroundColor(new Color(153, 153, 153));

        gui.getFields()[19].setTitle(stringArrayList.get(20));
        gui.getFields()[19].setSubText("Pris: 4000 kr.");
        gui.getFields()[19].setBackGroundColor(new Color(153, 153, 153));

        gui.getFields()[20].setTitle(stringArrayList.get(21));
        gui.getFields()[20].setSubText("Gratis Parkering");
        gui.getFields()[20].setBackGroundColor(new Color(255, 255, 204));

        gui.getFields()[21].setTitle(stringArrayList.get(22));
        gui.getFields()[21].setSubText("Pris 4400 kr.");
        gui.getFields()[21].setBackGroundColor(new Color(255, 0, 0));

        gui.getFields()[22].setTitle(stringArrayList.get(23));
        gui.getFields()[22].setSubText("Prøv Lykken");

        gui.getFields()[23].setTitle(stringArrayList.get(24));
        gui.getFields()[23].setSubText("Pris: 4400 kr.");
        gui.getFields()[23].setBackGroundColor(new Color(255, 0, 0));

        gui.getFields()[24].setTitle(stringArrayList.get(25));
        gui.getFields()[24].setSubText("Pris: 4800 kr.");
        gui.getFields()[24].setBackGroundColor(new Color(255, 0, 0));

        gui.getFields()[25].setTitle(stringArrayList.get(26));
        gui.getFields()[25].setSubText("Pris: 4000 kr.");

        gui.getFields()[26].setTitle(stringArrayList.get(27));
        gui.getFields()[26].setSubText("Pris: 5200 kr.");
        gui.getFields()[26].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[27].setTitle(stringArrayList.get(28));
        gui.getFields()[27].setSubText("Pris: 5200 kr.");
        gui.getFields()[27].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[28].setTitle(stringArrayList.get(29));
        gui.getFields()[28].setSubText("Pris: 3000 kr.");

        gui.getFields()[29].setTitle(stringArrayList.get(30));
        gui.getFields()[29].setSubText("Pris: 5600 kr.");
        gui.getFields()[29].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[30].setTitle(stringArrayList.get(31));
        gui.getFields()[30].setSubText("De fængsles");

        gui.getFields()[31].setTitle(stringArrayList.get(32));
        gui.getFields()[31].setSubText("Pris: 6000 kr.");
        gui.getFields()[31].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[32].setTitle(stringArrayList.get(33));
        gui.getFields()[32].setSubText("Pris: 6000 kr.");
        gui.getFields()[32].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[33].setTitle(stringArrayList.get(34));
        gui.getFields()[33].setSubText("Prøv Lykken");

        gui.getFields()[34].setTitle(stringArrayList.get(35));
        gui.getFields()[34].setSubText("Pris: 6400 kr.");
        gui.getFields()[34].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[35].setTitle(stringArrayList.get(36));
        gui.getFields()[35].setSubText("Pris: 4000 kr.");

        gui.getFields()[36].setTitle(stringArrayList.get(37));
        gui.getFields()[36].setSubText("Prøv Lykken");

        gui.getFields()[37].setTitle(stringArrayList.get(38));
        gui.getFields()[37].setSubText("Pris: 7000 kr.");
        gui.getFields()[37].setBackGroundColor(new Color(102, 0, 153));

        gui.getFields()[38].setTitle(stringArrayList.get(39));
        gui.getFields()[38].setSubText("Ekstra ordinær statsskat: Betal 2000 kr.");
        gui.getFields()[38].setBackGroundColor(new Color(255, 255, 204));

        gui.getFields()[39].setTitle(stringArrayList.get(40));
        gui.getFields()[39].setSubText("Pris: 8000 kr.");
        gui.getFields()[39].setBackGroundColor(new Color(102, 0, 153));


    }


  /*  public int show() {
        gui.showMessage("Vælger antale af spiller ");
        int numberInput;
        //Indlæser et tal mellem 2 og 4
        numberInput = gui.getUserInteger("Indtast et tal mellem 2 og 4", 2, 4);
        return numberInput;
    }*/

    public GUI getGui(){
     return this.gui;
    }

    public GUI_Field[] getGUI_Fields(){
        return fields;
    }

     }

