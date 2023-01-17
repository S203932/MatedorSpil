package Fields;

import ChanceCardsAndDeck.CardDeck;

public class Chance extends Field {
    private String name;
    private int position;
    private CardDeck cardDeck;

    public Chance() {
        initializePosition();
        initializeName();
        initializeCardDeck();
    }

    public void initializePosition() {
        this.position = -1;
    }

    public void initializeName() {
        this.name = "No name has been entered";
    }

    public void initializeCardDeck() {
        this.cardDeck = new CardDeck();
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String string = "";
        return "The name of the field is: " + this.name + " and the position is: " + this.position + "and contains card deck"; //+this.cardDeck.toString
    }
}

