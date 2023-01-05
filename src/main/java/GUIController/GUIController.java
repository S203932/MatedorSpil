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
    GUI_Field[] fields = {
            new GUI_Start(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Tax(),

            new GUI_Shipping(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

            new GUI_Jail(), new GUI_Street(), new GUI_Brewery(), new GUI_Street(), new GUI_Street(),

            new GUI_Shipping(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

            new GUI_Refuge(), new GUI_Street(), new GUI_Chance(), new GUI_Street(), new GUI_Street(),

            new GUI_Shipping(), new GUI_Street(), new GUI_Street(), new GUI_Brewery(), new GUI_Street(),

            new GUI_Jail(), new GUI_Street(), new GUI_Street(), new GUI_Chance(), new GUI_Street(),

            new GUI_Shipping(), new GUI_Chance(), new GUI_Street(), new GUI_Tax(), new GUI_Street()
    };
    private GUI gui = new GUI(fields);
    private DiceCup dice = new DiceCup(2);
    private GUI_Car car=new GUI_Car();
    private Player[] player;

//The following initializePlayers method won't work since it is a void method, so'
    // the players are only existing in that specific method and are "recreated"
    // everytime you call that method
    public void initialzePlayers() {
       int amountPlayers = gui.getUserInteger("Enter amount of players", 2, 4);
        Player[] player =new Player[amountPlayers];
        GUI_Player[] GUI_player=new GUI_Player[amountPlayers];
        if (amountPlayers==2){
            for (int i = 0; i < player.length; i++ ){
                player[i]=new Player();
                player[i].setPlayerName(gui.getUserString("Enter name"));
                player[i].getAccount().setAccount(20);
                GUI_player[i]=new GUI_Player(player[i].getPlayerName(),20);
                gui.addPlayer(GUI_player[i]);
            }
        } else if(amountPlayers==3){
            for (int i = 0; i < player.length; i++ ){
                player[i]=new Player();
                player[i].setPlayerName(gui.getUserString("Enter name"));
                player[i].getAccount().setAccount(18);
                GUI_player[i]=new GUI_Player(player[i].getPlayerName(),18);
                gui.addPlayer(GUI_player[i]);
            }
        } else if(amountPlayers==4){
            for (int i = 0; i < player.length; i++ ){
                player[i]=new Player();
                player[i].setPlayerName(gui.getUserString("Enter name"));
                player[i].getAccount().setAccount(16);
                GUI_player[i]=new GUI_Player(player[i].getPlayerName(),16);
                gui.addPlayer(GUI_player[i]);
            }
        }
        int turn=0;
        for(int i=0; i<amountPlayers; i++){
            Player playerNow=player[turn];
            gui.showMessage(playerNow.getPlayerName()+"'s  turn");
            dice.rollDice();
            int roll=dice.result();
            gui.setDie(dice.result());
            playerNow.setPosition((playerNow.getPosition()+roll)% fields.length);
            GUI_player[turn].getCar().setPosition(gui.getFields()[(playerNow.getPosition()+roll)% fields.length]);
            turn=((turn+1)%amountPlayers);
        }

    }

    //much of it, if not most, of the method below is from the former initialize players.
    public GUI_Player[] setupPlayers(Player[] player) {
        GUI_Player[] GUI_player = new GUI_Player[player.length];
        if ((player.length) == 2) {
            String[] nameArray = new String[2];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : "+i);
                player[i] = new Player();
                String playerName = gui.getUserString("Enter a new name");
                int repeat = 0;
                for(int j=0; j<nameArray.length;j++){
                    if(playerName.equalsIgnoreCase(nameArray[j])){
                        repeat = 1;
                        System.out.println("Name has already been entered.");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(20);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 20);
                gui.addPlayer(GUI_player[i]);
                if(repeat == 1) {
                    i = i - 1;
                }
            }
        } else if ((player.length) == 3) {
            String[] nameArray = new String[3];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : "+i);
                player[i] = new Player();
                String playerName = gui.getUserString("Enter a new name");
                int repeat = 0;
                for(int j=0; j<nameArray.length;j++){
                    if(playerName.equalsIgnoreCase(nameArray[j])){
                        repeat = 1;
                        System.out.println("Name has already been entered.");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(18);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 18);
                gui.addPlayer(GUI_player[i]);
                if(repeat == 1) {
                    i = i - 1;
                }
            }
        } else if ((player.length) == 4) {
            String[] nameArray = new String[4];
            for (int i = 0; i < player.length; i++) {
                System.out.println("i : "+i);
                player[i] = new Player();
                String playerName = gui.getUserString("Enter a new name");
                int repeat = 0;
                for(int j=0; j<nameArray.length;j++){
                    if(playerName.equalsIgnoreCase(nameArray[j])){
                        repeat = 1;
                        System.out.println("Name has already been entered.");
                    }
                }
                nameArray[i] = playerName;
                player[i].setPlayerName(playerName);
                player[i].getAccount().setAccount(16);
                GUI_player[i] = new GUI_Player(player[i].getPlayerName(), 16);
                gui.addPlayer(GUI_player[i]);
                if(repeat == 1){
                    i = i -1;
                }
            }
        }
        return GUI_player;
    }

    public void takeTurn(Player player, GUI gui, GUI_Player gui_player, FieldList fieldList,GUI_Field[] fields){
        String rollDie = gui.getUserButtonPressed(player.getPlayerName()+"'s turn. Choose an option:",
                "Press to roll the die.","Press to forefit and give in.");
        if(rollDie.equalsIgnoreCase("Press to roll the die.")){
            dice.rollDice();
            gui.setDie(dice.result());
            player.diceRollPosition(dice.result());
            GUI_Field field = gui.getFields()[player.getPosition()];
            gui_player.getCar().setPosition(field);
            if(fieldList.getFieldIndex(player.getPosition()).getClass().equals(Property.class)){
                System.out.println("Field is a property");
                if(((Property)fieldList.getFieldIndex(player.getPosition())).getAvailability()){
                    System.out.println("property is not owned");
                    gui.showMessage("The field is an unowned property, press the button to buy it.");
                    ((Property)fieldList.getFieldIndex(player.getPosition())).buyProperty(player);
                    fields[player.getPosition()].setDescription("Is owned by: "+player.getPlayerName());
                    gui_player.setBalance(player.getAccount().getAmount());

                }else{
                    ((Property)fieldList.getFieldIndex(player.getPosition())).PayRentProperty(player);
                    System.out.println("Property is owned");
                    gui.showMessage("The property is owned, press the button to pay rent.");
                }
            }else if(fieldList.getFieldIndex(player.getPosition()).getClass().equals(Chance.class)){
                //cardDeck.initilalizeCard();
                //cardDeck.cards();
                Chance chance = new Chance();
                CardDeck cardDeck = chance.getCardDeck();
                int randomNumber = (int)(Math.random() * 7) + 0;
                cardDeck.setCards();
                ChanceCards chanceCard = cardDeck.getCard(randomNumber);
                System.out.println(chanceCard.getDescription());
                chanceCard.cardAction(player,gui, fieldList.getFieldList(), fields, gui_player);
            }else if(fieldList.getFieldIndex(player.getPosition()).getClass().equals(Neutral.class)){
                gui.showMessage("Nothing worth mentioning happens on this field, press the button " +
                        "to pass the turn.");
            }else if(fieldList.getFieldIndex(player.getPosition()).getClass().equals(GoJail.class)){
                gui.showMessage("Sucks to be you. Press the button to move to jail.");
                GoJail goJail = new GoJail();
                goJail.GoToJail(player);
                if(player.getJail()==1){
                    player.getAccount().additionAccount(-1);
                }
                player.setPosition(6);
                gui_player.getCar().setPosition(fields[6]);
            }

        }else{
            player.setForfeit(1);
            gui.showMessage("You have now forfeited. Your properties will remain bought, but can " +
                    "no longer take turns.");

        }

    }



    public void GUIController(String filename) {
        ReadFile readFile = new ReadFile();
        ArrayList<String> stringArrayList = readFile.ReadFile(filename);
        gui.getFields()[0].setTitle(stringArrayList.get(1));
        gui.getFields()[0].setSubText("Modtag 2000 kr. når de passerer start");
        gui.getFields()[0].setBackGroundColor(new Color(204, 0, 0));

        gui.getFields()[1].setTitle(stringArrayList.get(2));
        gui.getFields()[1].setSubText("Pris: 1200 kr.");
        gui.getFields()[1].setBackGroundColor(new Color(0, 0, 255));

        gui.getFields()[2].setTitle(stringArrayList.get(3));
        gui.getFields()[2].setSubText("Prøv Lykken");
        gui.getFields()[2].setBackGroundColor(new Color(0, 0, 0));

        gui.getFields()[3].setTitle(stringArrayList.get(4));
        gui.getFields()[3].setSubText("Pris: 1200 kr.");
        gui.getFields()[3].setBackGroundColor(new Color(0, 0, 255));

        gui.getFields()[4].setTitle(stringArrayList.get(5));
        gui.getFields()[4].setSubText("Betal indkomstskat: 10% eller 4000 kr.");
        gui.getFields()[4].setBackGroundColor(new Color(255, 255, 204));


        gui.getFields()[5].setTitle(stringArrayList.get(6));
        gui.getFields()[5].setSubText("Scanlines");
        gui.getFields()[5].setBackGroundColor(new Color(0, 0, 155));

        gui.getFields()[6].setSubText(stringArrayList.get(7));
        gui.getFields()[6].setSubText("Pris: 2000 kr.");
        gui.getFields()[6].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[7].setTitle(stringArrayList.get(8));
        gui.getFields()[7].setSubText("Prøv Lykken");
        gui.getFields()[7].setBackGroundColor(new Color(0, 0, 0));


        gui.getFields()[8].setTitle(stringArrayList.get(9));
        gui.getFields()[8].setSubText("Pris: 2000 kr.");
        gui.getFields()[8].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[9].setTitle(stringArrayList.get(10));
        gui.getFields()[9].setSubText("Pris: 2400 kr.");
        gui.getFields()[9].setBackGroundColor(new Color(255, 102, 0));

        gui.getFields()[10].setTitle(stringArrayList.get(11));
        gui.getFields()[10].setSubText("På besøg");
        gui.getFields()[10].setBackGroundColor(new Color(0, 0, 0));


        gui.getFields()[11].setTitle(stringArrayList.get(12));
        gui.getFields()[11].setSubText("Pris: 2800 kr.");
        gui.getFields()[11].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[12].setTitle(stringArrayList.get(13));
        gui.getFields()[12].setSubText("Pris: 3000 kr.");
        gui.getFields()[12].setBackGroundColor(new Color(153, 0, 0));

        gui.getFields()[13].setTitle(stringArrayList.get(14));
        gui.getFields()[13].setSubText("Pris: 2800 kr.");
        gui.getFields()[13].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[14].setTitle(stringArrayList.get(15));
        gui.getFields()[14].setSubText("Pris: 3200 kr.");
        gui.getFields()[14].setBackGroundColor(new Color(102, 255, 102));

        gui.getFields()[15].setTitle(stringArrayList.get(16));
        gui.getFields()[15].setSubText("Pris: 4000 kr.");
        gui.getFields()[15].setBackGroundColor(new Color(0, 0, 153));

        gui.getFields()[16].setTitle(stringArrayList.get(17));
        gui.getFields()[16].setSubText("Pris: 3600 kr.");
        gui.getFields()[16].setBackGroundColor(new Color(153, 153, 153));

        gui.getFields()[17].setTitle(stringArrayList.get(18));
        gui.getFields()[17].setSubText("Prøv Lykken");
        gui.getFields()[17].setBackGroundColor(new Color(0, 0, 0));

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
        gui.getFields()[22].setBackGroundColor(new Color(0, 0, 0));

        gui.getFields()[23].setTitle(stringArrayList.get(24));
        gui.getFields()[23].setSubText("Pris: 4400 kr.");
        gui.getFields()[23].setBackGroundColor(new Color(255, 0, 0));

        gui.getFields()[24].setTitle(stringArrayList.get(25));
        gui.getFields()[24].setSubText("Pris: 4800 kr.");
        gui.getFields()[24].setBackGroundColor(new Color(255, 0, 0));

        gui.getFields()[25].setTitle(stringArrayList.get(26));
        gui.getFields()[25].setSubText("Pris: 4000 kr.");
        gui.getFields()[25].setBackGroundColor(new Color(0, 0, 153));

        gui.getFields()[26].setTitle(stringArrayList.get(27));
        gui.getFields()[26].setSubText("Pris: 5200 kr.");
        gui.getFields()[26].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[27].setTitle(stringArrayList.get(28));
        gui.getFields()[27].setSubText("Pris: 5200 kr.");
        gui.getFields()[27].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[28].setTitle(stringArrayList.get(29));
        gui.getFields()[28].setSubText("Pris: 3000 kr.");
        gui.getFields()[28].setBackGroundColor(new Color(153, 0, 0));

        gui.getFields()[29].setTitle(stringArrayList.get(30));
        gui.getFields()[29].setSubText("Pris: 5600 kr.");
        gui.getFields()[29].setBackGroundColor(new Color(255, 255, 255));

        gui.getFields()[30].setTitle(stringArrayList.get(31));
        gui.getFields()[30].setSubText("De fængsles");
        gui.getFields()[30].setBackGroundColor(new Color(0, 0, 0));

        gui.getFields()[31].setTitle(stringArrayList.get(32));
        gui.getFields()[31].setSubText("Pris: 6000 kr.");
        gui.getFields()[31].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[32].setTitle(stringArrayList.get(33));
        gui.getFields()[32].setSubText("Pris: 6000 kr.");
        gui.getFields()[32].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[33].setTitle(stringArrayList.get(34));
        gui.getFields()[33].setSubText("Prøv Lykken");
        gui.getFields()[33].setBackGroundColor(new Color(0, 0, 0));

        gui.getFields()[34].setTitle(stringArrayList.get(35));
        gui.getFields()[34].setSubText("Pris: 6400 kr.");
        gui.getFields()[34].setBackGroundColor(new Color(255, 255, 0));

        gui.getFields()[35].setTitle(stringArrayList.get(36));
        gui.getFields()[35].setSubText("Pris: 4000 kr.");
        gui.getFields()[35].setBackGroundColor(new Color(0, 0, 153));

        gui.getFields()[36].setTitle(stringArrayList.get(37));
        gui.getFields()[36].setSubText("Prøv Lykken");
        gui.getFields()[36].setBackGroundColor(new Color(0, 0, 0));

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

