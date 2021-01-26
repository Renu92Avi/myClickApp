package com.example.myclickapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PlayersDataAdapter mAdapter;
    SwipeController swipeController = null;
    Canvas canvas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPlayersDataAdapter();
        setupRecyclerView();
    }

    private void setPlayersDataAdapter() {
        List<Player> players = new ArrayList<>();
        Player player = new Player();
        player.setName("abcd");player.setNationality("indian");player.setClub("abc");player.setRating(9);player.setAge(14);

        Player player1 = new Player();
        player1.setName("xyz");player.setNationality("japan");player.setClub("hjj");player.setRating(6);player.setAge(16);

        Player player2 = new Player();
        player2.setName("bjjk");player.setNationality("china");player.setClub("attybc");player.setRating(8);player.setAge(15);

        Player player3 = new Player();
        player3.setName("vfxfgcg");player.setNationality("US");player.setClub("kipoou");player.setRating(7);player.setAge(16);

        Player player4 = new Player();
        player4.setName("nkkl");player.setNationality("UK");player.setClub("hhj");player.setRating(7);player.setAge(17);

        Player player5 = new Player();
        player5.setName("abojlkcd");player.setNationality("indian");player.setClub("ggugi");player.setRating(5);player.setAge(15);

        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

        mAdapter = new PlayersDataAdapter(players);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
//                mAdapter.players.remove(position);
//                mAdapter.notifyItemRemoved(position);
//                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
                showCancelAppointmentDialog(position);
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                canvas = c;
                swipeController.onDraw(c);
            }
        });
    }

    private void showCancelAppointmentDialog(int position) {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rectangle_round_white);
        dialog.setContentView(R.layout.dialog_layout);

        dialog.show();

        TextView noBtn = dialog.findViewById(R.id.no_btn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        TextView yesBtn = dialog.findViewById(R.id.yes_btn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.players.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Cancel Appointment", Toast.LENGTH_SHORT).show();
            }
        });
    }

}