class Deck {

    private Card[] deck;
    private int cardsUsed;

    public Deck(){
            deck = new Card[52];
            int cardCount = 0;
            for(int suit = 0; suit <= 3; suit++){
                for(int value = 1; value <= 13; value++){
                    deck[cardCount] = new Card(value,suit);
                    cardCount++;
                }
            }
            cardsUsed = 0;
        }//deck()

    public void shuffle(){
        for(int i = deck.length-1; i > 0; i--){
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }//shuffle


    public Card dealCard(){
        if(cardsUsed == deck.length)
            throw new IllegalStateException("Deck is empty");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }//dealCard

}//Card class


