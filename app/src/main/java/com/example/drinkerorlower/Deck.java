package com.example.drinkerorlower;

import android.util.Log;
import android.widget.ListPopupWindow;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.*;

public class Deck {
    public Card[] cards = new Card[52];
    private int deckLocation;

    enum EHL {
        EQUAL,
        LOWER,
        HIGHER
    }

    public void shuffle(){
        deckLocation = 0;
        Random rand = new Random();
        for (int ii = 0; ii < this.cards.length; ii++) {
            int index = rand.nextInt(cards.length);
            Card temp = this.cards[ii];
            this.cards[ii] = this.cards[index];
            this.cards[index] = temp;
        }
    }

    public Deck() {
        // set up deck
        for (int ss = 0; ss < 4; ss++) {
            for (int rr = 0; rr < 13; rr++) {
                int temp = ss * 13 + rr;
                this.cards[temp] = new Card(rr,ss,temp);
            }
        }
        testDeck();
        shuffle();
        deckLocation = 0;
        testDeck();
    }

    public void testDeck() {
        for (int ii = 0; ii < cards.length; ii++) {
            Log.i("DEBUG","Card " + ii);
//            + " " + this.cards[ii].suit + " of " +
//                    this.cards[ii].rank +  " pic " + this.cards[ii].pic);
        }
    }

//    public void logCard () {
//        Log.i("DEBUG","Card " + deckLocation);
////        + " " + this.cards[deckLocation].suit +
////                " of " + this.cards[deckLocation].rank +  " pic " + this.cards[deckLocation].pic);
//    }

    public boolean nextCard() {
        deckLocation++;
        Log.i("INFO","Card " + deckLocation + " / " + cards.length);
        if (deckLocation == cards.length) {
            shuffle();
            return true;
        }
//        logCard();
        return false;
    }

    public int cardPic() {
        return this.cards[deckLocation].pic;
    }

    public EHL highLowEqual () {
        EHL result = EHL.EQUAL;
        if (deckLocation > 0) {
            Log.i("INFO", "C1 Rank = " + cards[deckLocation].rank + " C2 rank " + cards[deckLocation - 1].rank);
            if (cards[deckLocation].rank == cards[deckLocation - 1].rank) {
                result = EHL.EQUAL;
            } else if (cards[deckLocation].rank > cards[deckLocation - 1].rank) {
                result = EHL.HIGHER;
            } else {
                result = EHL.LOWER;
            }
        }
        Log.i("INFO","Result is " + result.toString());
        return result;
    }
}
