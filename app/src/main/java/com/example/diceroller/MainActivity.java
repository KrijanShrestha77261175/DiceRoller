package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/**
 * This activity allows a user to roll a dice and view the result
 * on the screen.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    Random random = new Random();
    private TextView resultTextView;




    /**
     *  This method is called when the Activity is created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView in the layout
        resultTextView = findViewById(R.id.textView);


        // Find the Button in the layout
        button = findViewById(R.id.rollButton);
        // Set a click listener on the button to roll the dice when the user taps the button
        button.setOnClickListener(this);
    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }

    /**
     * This method rolls the dice on clicking the roll button
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        // Calls the function to roll the dice else show exception
        try {
            rollDice();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generate a toast after the dice is rolled.
        if (view.getId() == R.id.rollButton) {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private void rollDice() {
        // Generate a random number from 1 to 6
        int dice1 = random.nextInt(6) + 1;


        //Update the screen with the dice roll
        resultTextView.setText("" + dice1);

    }
}