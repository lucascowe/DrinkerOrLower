package com.example.drinkerorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button higherButton;
    Button lowerButton;
    ImageView cardImageView;
    Deck deck = new Deck();

    public void onClickHigher(View view) {
        Deck.EHL result;
        if (deck.nextCard()) {
            Toast.makeText(this,"Deck Shuffled", Toast.LENGTH_SHORT).show();
        }
        result = deck.highLowEqual();
        cardImageView.setImageResource(deck.cardPic());
        if (Deck.EHL.HIGHER == result) {
            Toast.makeText(this, "Correct, opponent drinks!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","Correct, HIGHER");
        } else if (Deck.EHL.EQUAL == result) {
            Toast.makeText(this, "Equal, both drink!!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","EQUAL");
        } else {
            Toast.makeText(this, "Wrong, drink!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","Wrong, LOWER");
        }
    }

    public void onClickLower(View view) {
        Deck.EHL result;
        if (deck.nextCard()) {
            Toast.makeText(this,"Deck Shuffled", Toast.LENGTH_SHORT).show();
        }
        result = deck.highLowEqual();
        cardImageView.setImageResource(deck.cardPic());
        if (Deck.EHL.LOWER == result) {
            Toast.makeText(this, "Correct, opponent drinks!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","Correct, LOWER");
        } else if (Deck.EHL.EQUAL == result) {
            Toast.makeText(this, "Equal, both drink!!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","Equal");
        } else {
            Toast.makeText(this, "Wrong, drink!", Toast.LENGTH_SHORT).show();
            Log.i("DEBUG","Wrong, HIGHER");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        higherButton = findViewById(R.id.btnHigher);
        lowerButton = findViewById(R.id.btnLower);
        cardImageView = findViewById(R.id.cardImageView);
        cardImageView.setImageResource(deck.cards[0].pic);

    }
}
