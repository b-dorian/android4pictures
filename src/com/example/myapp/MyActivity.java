package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private FourPictures game;
    ArrayList <Button> buttons;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        String [] pictures = {"Paris1.jpg","Paris2.jpg","Paris3.jpg","Paris4.jpg"};
        game = new FourPictures("paris", "pysitrla", pictures);

        InputStream imageFile1 = null;
        InputStream imageFile2 = null;
        InputStream imageFile3 = null;
        InputStream imageFile4 = null;

        try {
            imageFile1 = getAssets().open("Paris1.jpg");
            imageFile2 = getAssets().open("Paris2.jpg");
            imageFile3 = getAssets().open("Paris3.jpg");
            imageFile4 = getAssets().open("Paris4.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap b1 = BitmapFactory.decodeStream(imageFile1);
        Bitmap b2 = BitmapFactory.decodeStream(imageFile2);
        Bitmap b3 = BitmapFactory.decodeStream(imageFile3);
        Bitmap b4 = BitmapFactory.decodeStream(imageFile4);


        ImageView p1 = (ImageView) findViewById(R.id.imageView);
        p1.setImageBitmap(b1);
        ImageView p2 = (ImageView) findViewById(R.id.imageView2);
        p2.setImageBitmap(b2);
        ImageView p3 = (ImageView) findViewById(R.id.imageView3);
        p3.setImageBitmap(b3);
        ImageView p4 = (ImageView) findViewById(R.id.imageView4);
        p4.setImageBitmap(b4);


        final TextView revealedWord = (TextView) findViewById(R.id.revealedWord);
        revealedWord.setText(game.getRevealedWord());

        final LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main);

        final GridLayout buttonsGrid = (GridLayout) findViewById(R.id.buttonLayout);
        buttonsGrid.setRowCount(2);
        buttonsGrid.setColumnCount(game.getLetters().length() / 2);

        final TextView correct = new TextView(this);

        correct.setText("Correct!");

        View.OnClickListener asd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button temp = (Button)v;
                game.processCharacter(temp.getText().toString());
                revealedWord.setText(game.getRevealedWord());
                if (game.getGameWon() == 1){
                   buttonsGrid.removeAllViews();
                    buttonsGrid.addView(correct);

                }





            }
        };


         buttons = new ArrayList<>();
        for (int i = 0; i < game.getLetters().length(); ++i){
          Button temp = new Button(this);
            temp.setText("" + game.getLetters().charAt(i));
            buttons.add(temp);


            buttonsGrid.addView(buttons.get(i));

            buttons.get(i).setOnClickListener(asd);
        }















    }




}
