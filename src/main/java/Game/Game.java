package Game;

import Fields.FieldList;
import Fields.Property;
import Fields.RealEstate;
import GUIController.GUIController;
import SupportClasses.Bot;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    public static void main(String[] args) throws InterruptedException {


        GUIController guiController = new GUIController();

        String language = "Dansk.txt";

        System.out.println(language);

        FieldList fieldList = new FieldList();
        fieldList.setupField(language);

        guiController.GUIController(language, fieldList);
        int amountPlayers = guiController.getGui().getUserInteger("Indsat antal spiller", 2, 6);
        Player[] players = new Player[amountPlayers];
        GUI_Player[] gui_players;
        if (amountPlayers == 2) {
            Player player = new Player();
            Bot bot = new Bot();
            players = new Player[]{player, bot};
            gui_players = guiController.setupBot(players);

        } else {
            gui_players = guiController.setupPlayers(players);
        }

        int end = 0;
        while (end != 1) {
            for (int j = 0; j < players.length; j++) {
                gui_players[j].setBalance(players[j].getAccount().getAmount());
            }
            for (int i = 0; i < players.length; i++) {
                if (players[i].getForfeit() == 0) {
                    if (players[i].getClass().equals(Bot.class)) {
                        ((Bot) players[i]).BotTakeTurn(players[i], guiController.getGui(), gui_players[i], fieldList, guiController.getGUI_Fields(), players);
                    } else {


                        gui_players[0].setBalance(players[0].getAccount().getAmount());


                        guiController.takeTurn(players[i], guiController.getGui(), gui_players[i], fieldList, guiController.getGUI_Fields(), players);
                        endMenu(players[i], guiController.getGui(), gui_players[i], fieldList, guiController.getGUI_Fields(), players);
                    }
                    System.out.println(players[i].toString());

                    for (int j = 0; j < players.length; j++) {
                        gui_players[j].setBalance(players[j].getAccount().getAmount());
                    }
                }


                if (players[i].getAccount().getAmount() <= 0) {
                    end = 1;
                    break;
                }
            }

        }
        guiController.getGui().showMessage("Game is over.");

    }


    //The method below is the menu for the player after they've rolled the dice
    //It is supposed to offer the player option to do, mortgage, buy house/hotel and end turn
    // Mortgage, buy house/hotel and endturn should each have their own method
    public static void endMenu(Player player, GUI gui, GUI_Player gui_player, FieldList fieldList, GUI_Field[] fields, Player[] players) {


        // This menu is if the player is eligible to buy house
        if (player.eligbleForHouse()) {
            String option = "";
            while (!option.equalsIgnoreCase("Afslut tur")) {
                option = gui.getUserButtonPressed("Du har følgende valgmuligheder:", "Pantsæt en ejendom",
                        "Køb tilbage pantsætning", "Køb hus", "Sælg hus", "Afslut tur");
                String option2 = "";
                if (!option.equalsIgnoreCase("Afslut tur")) {
                    if (option.equalsIgnoreCase("Pantsæt en ejendom")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.getPropertiesThatCanMortgage();
                            String[] propertyNames = player.getNamesOfPropertiesToMortgage();
                            option2 = gui.getUserSelection("Vælg en ejendom at pantsætte", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        properties[i].mortgageProperty(player);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }

                            }
                        }
                    } else if (option.equalsIgnoreCase("Køb tilbage pantsætning")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.getPropertiesToBuyBack();
                            String[] propertyNames = player.getPropertiesToBuyBackNames();
                            option2 = gui.getUserSelection("Vælg en ejendom at tilbagekøbe fra banken", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        properties[i].buyBackMortgage(player);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }
                            }
                        }
                    } else if (option.equalsIgnoreCase("Køb hus")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.eligbleRealEstateForHouses();
                            String[] propertyNames = player.getNamesOfPropertiesToBuyHouse();
                            option2 = gui.getUserSelection("Vælg en ejendom du ønsker at opgradere", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        ((RealEstate) properties[i]).upgradeProperty(player);
                                        GUIController.setHouseGraphic(properties[i], gui);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }
                            }
                        }
                    } else if (option.equalsIgnoreCase("Sælg hus")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.propertiesWithHousesOnThem();
                            String[] propertyNames = player.getNamesOfPropertiesWithHouses();
                            option2 = gui.getUserSelection("Vælg en ejendom du ønsker at nedgradere:", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        ((RealEstate) properties[i]).downgradeProperty(player);
                                        GUIController.setHouseGraphic(properties[i], gui);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }
                            }
                        }
                    }
                }
            }


            // This menu is if the player can buy back a property and has a property to mortgage
        } else if (player.hasProperties()) {
            String option = "";
            while (!option.equalsIgnoreCase("Afslut tur")) {
                option = gui.getUserButtonPressed("Du har følgende valgmuligheder:", "Pantsæt en ejendom",
                        "Køb tilbage pantsætning", "Afslut tur");
                String option2 = "";
                if (!option.equalsIgnoreCase("Afslut tur")) {
                    if (option.equalsIgnoreCase("Pantsæt en ejendom")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.getPropertiesThatCanMortgage();
                            String[] propertyNames = player.getNamesOfPropertiesToMortgage();
                            option2 = gui.getUserSelection("Vælg en ejendom at pantsætte", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        properties[i].mortgageProperty(player);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }

                            }
                        }
                    } else if (option.equalsIgnoreCase("Køb tilbage pantsætning")) {
                        while (!option2.equalsIgnoreCase("Ingen af overstående")) {
                            Property[] properties = player.getPropertiesToBuyBack();
                            String[] propertyNames = player.getPropertiesToBuyBackNames();
                            option2 = gui.getUserSelection("Vælg en ejendom at tilbagekøbe fra banken", propertyNames);
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i] != null) {
                                    if (properties[i].getName().equalsIgnoreCase(option2)) {
                                        properties[i].buyBackMortgage(player);
                                        gui_player.setBalance(player.getAccount().getAmount());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // This menu is if the player can only end their turn
        } else {
            gui.getUserButtonPressed("Du har desværre ikke mange muligheder hva.", "Afslut tur");

        }
    }
}
