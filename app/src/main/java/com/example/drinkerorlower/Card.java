package com.example.drinkerorlower;

import android.util.Log;

import com.example.drinkerorlower.R.drawable;

public class Card {

    int rank;
    int suit;
    int pic;
    private final String[] suits = {"Clubs","Spades","Diamonds","Hearts"};
    private final String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queens","King","Ace"};
    private final int[] value = new int[13];
    private final int[] pics = {drawable.c2, drawable.c3, drawable.c4, drawable.c5, drawable.c6,
            drawable.c7, drawable.c8, drawable.c9, drawable.c10, drawable.cj,drawable.cq, drawable.ck,
            drawable.ca,drawable.s2, drawable.s3, drawable.s4, drawable.s5, drawable.s6, drawable.s7,
            drawable.s8, drawable.s9, drawable.s10, drawable.sj,drawable.sq, drawable.sk,drawable.as,
            drawable.d2, drawable.d3, drawable.d4, drawable.d5, drawable.d6,drawable.d7, drawable.d8,
            drawable.d9, drawable.d10, drawable.dj,drawable.dq, drawable.dk, drawable.da,drawable.h2,
            drawable.h3, drawable.h4, drawable.h5, drawable.h6,drawable.h7, drawable.h8, drawable.h9,
            drawable.h10, drawable.hj,drawable.hq,drawable.hk, drawable.ha
    };

    public Card(int r, int s, int p) {
        int ii;
        this.rank = r;
        this.suit = s;
        // define number values
        for (ii = 0; ii < 9; ii++) {
            value[ii] = ii + 2;
        }
        // define picture cards
        for (ii = 9; ii < 12; ii++) {
            value[ii] = 10;
        }
        // define ace
        value[12] = 11;
        this.pic = pics[p];
        Log.i("DEBUG", "New card " + p + " r " + ranks[r] + " of " + suits[s]);
        Log.i("DEBUG", "Cards in deck " + pics.length);

    }

//    public String getRank(){
//        return ranks[this.rank];
//    }
//
//    public String getSuit() {
//        return suits[this.suit];
//    }

//    public int getPic() {
//        return this.pic;
//    }

//    public void setPic (int r, int s) {
//        if ((r < ranks.length) && (s < suits.length)) {
//            this.pic = pics[s * suits.length + r];
//        }
//    }
//
//    public void setRank(int n) {
//        if (n < (ranks.length * suits.length)) {
//            this.rank = n % suits.length;
//        }
//    }
//    public void setSuit(int n) {
//        if (n < (ranks.length * suits.length)) {
//            this.suit = n / suits.length;
//        }
//    }


}

