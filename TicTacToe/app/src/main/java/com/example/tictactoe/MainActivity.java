package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView p1_score, p2_score, p_win;
    private Button [] buttons = new Button[9];
    private Button reset_Game;

    private int p1_count, p2_count,match_count;
    boolean activePlayer;

    //p1 -> 0; p2 -> 1; empty ->0
    int [] gamestate = {2,2,2,2,2,2,2,2,2};
    //win positions
    int [][] winningPosition = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1_score = findViewById(R.id.tv_score_p1);
        p2_score = findViewById(R.id.tv_score_p2);
        p_win = findViewById(R.id.tv_winner);

        reset_Game = findViewById(R.id.bt_reset);

        for(int i = 0; i<buttons.length; i++ ){
            String buttonID = "bt_" + i;
            int resourceID = getResources().getIdentifier(buttonID,"id",getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this::onClick);
        };

        match_count =0;
        p1_count= 0;
        p2_count=0;
        activePlayer = true;

    }

    @Override
    public void onClick(View view) {
        if (!((Button)view).getText().toString().equals("")){
            return;
        }
        String buttonIDs = view.getResources().getResourceEntryName(view.getId());
        int gamestater = Integer.parseInt(buttonIDs.substring(buttonIDs.length()-1, buttonIDs.length()));
        if(activePlayer){
            ((Button)view).setText("X");
            ((Button)view).setTextColor(Color.parseColor("#FFC34A"));
            gamestate[gamestater] = 0;
        }else {
            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#70FFEA"));
            gamestate[gamestater] = 1;
        }
        match_count++;

        if(chechWhoWin()) {
            if (activePlayer) {
                p1_count++;
                updatePlayerScore();
                Toast.makeText(this, "Player 1 won !", Toast.LENGTH_SHORT).show();
                playAgain();
            } else {
                p2_count++;
                updatePlayerScore();
                Toast.makeText(this, "Player 2 won !", Toast.LENGTH_SHORT).show();
                playAgain();
            }
        }else if(match_count == 9){
            playAgain();
            Toast.makeText(this,"PLayer 2 won !!!", Toast.LENGTH_LONG).show();
        }else{
            activePlayer = !activePlayer;
        }

        if(p1_count > p2_count){
            p_win.setText("Player 1 won !!!");
        }else if(p2_count>p1_count){
            p_win.setText("Player 2 won !!!");
        }else{
            p_win.setText("");
        }

        reset_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
                p1_count=0;
                p2_count=0;
                p_win.setText("");
                updatePlayerScore();
            }
        });

    }

    public boolean chechWhoWin(){
        boolean winnerWho = false;
        for(int [] winningPosition:winningPosition){
            if(gamestate[winningPosition[0]]== gamestate[winningPosition[1]]
            && gamestate[winningPosition[1]] == gamestate[winningPosition[2]]
            && gamestate[winningPosition[0]] != 2){
                winnerWho = true;
            }
        }
        return winnerWho;
    }

    public void updatePlayerScore(){
        p1_score.setText(Integer.toString(p1_count));
        p2_score.setText(Integer.toString(p2_count));
    }

    public void playAgain(){
        match_count = 0;
        activePlayer = true;
        for (int i=0; i<buttons.length;i++){
            gamestate[i]= 2;
            buttons[i].setText("");
        }
    }

}