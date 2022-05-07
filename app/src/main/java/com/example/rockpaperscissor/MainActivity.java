package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playerScore = 0;
    int compScore = 0;
    ImageView playerChoice;
    ImageView compChoice;
    TextView player_score;
    TextView comp_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerChoice = (ImageView) findViewById(R.id.user_move_img);
        compChoice = (ImageView) findViewById(R.id.computer_move_img);

        player_score = (TextView) findViewById(R.id.player_score);
        comp_score = (TextView) findViewById(R.id.comp_score);

        Button button = (Button) findViewById(R.id.reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Reset Game", Toast.LENGTH_SHORT).show();
                clearScore();
            }
        });

        // when player click on rock icon.

        ImageView rock = (ImageView) findViewById(R.id.rock_btn);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set the image of player move to rock
                playerChoice.setImageDrawable(getResources().getDrawable(R.drawable.rock));

                // for comp
                // Generate a random no. from 1,2,3.
                int randomNo = randomNoGenerator();
                if (randomNo == 1) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                    Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                } else if (randomNo == 2) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                    compScore++;
                    scoreDisplayForComputer(compScore);
                    Toast.makeText(MainActivity.this, "computer win", Toast.LENGTH_SHORT).show();

                } else {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                    playerScore++;
                    scoreDisplayForPlayer(playerScore);
                    Toast.makeText(MainActivity.this, "player win", Toast.LENGTH_SHORT).show();

                }

            }
        });

        // when player click on paper icon.

        ImageView paper = (ImageView) findViewById(R.id.paper_btn);
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set the image of player move to rock
                playerChoice.setImageDrawable(getResources().getDrawable(R.drawable.paper));

                // for comp
                // Generate a random no. from 1,2,3.
                int randomNo = randomNoGenerator();
                if (randomNo == 1) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                    playerScore++;
                    scoreDisplayForPlayer(playerScore);
                    Toast.makeText(MainActivity.this, "player win", Toast.LENGTH_SHORT).show();

                } else if (randomNo == 2) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                    Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                } else {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                    compScore++;
                    scoreDisplayForComputer(compScore);
                    Toast.makeText(MainActivity.this, "computer win", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // when player click on scissors icon.

        ImageView scissors = (ImageView) findViewById(R.id.scissors_btn);
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set the image of player move to rock
                playerChoice.setImageDrawable(getResources().getDrawable(R.drawable.scissors));

                // for comp
                // Generate a random no. from 1,2,3.
                int randomNo = randomNoGenerator();
                if (randomNo == 1) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                    compScore++;
                    scoreDisplayForComputer(compScore);
                    Toast.makeText(MainActivity.this, "computer win", Toast.LENGTH_SHORT).show();

                } else if (randomNo == 2) {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                    playerScore++;
                    scoreDisplayForPlayer(playerScore);
                    Toast.makeText(MainActivity.this, "player win", Toast.LENGTH_SHORT).show();

                } else {
                    compChoice.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                    Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void clearScore() {
        playerScore = 0;
        compScore = 0;
        scoreDisplayForPlayer(0);
        scoreDisplayForComputer(0);
        playerChoice.setImageDrawable(getResources().getDrawable(R.drawable.quesmark1));
        compChoice.setImageDrawable(getResources().getDrawable(R.drawable.quesmark1));
    }

    private int randomNoGenerator() {
        int num = (1 + (int) (Math.random() * ((4 - 1) + 1)));
        return num;
    }

    /**
     * Displays the given score for player.
     */
    private void scoreDisplayForPlayer(int score) {
        player_score.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for computer.
     */
    private void scoreDisplayForComputer(int score) {
        comp_score.setText(String.valueOf(score));
    }
}