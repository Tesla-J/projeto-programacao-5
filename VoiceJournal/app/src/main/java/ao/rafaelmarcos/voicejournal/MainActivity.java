package ao.rafaelmarcos.voicejournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ao.rafaelmarcos.voicejournal.player.Player;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mRecordFab;
    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordFab = findViewById(R.id.record_fab);
        mRecordFab.setOnClickListener((v) -> {
            Intent intent = new Intent(this, RecordingActivity.class);
            startActivity(intent);
        });

        mPlayer = new Player();
    }

    @Override
    public void onStart(){
        super.onStart();

        if(RecordingActivity.AUDIO_FILE != null)
            mPlayer.play(RecordingActivity.AUDIO_FILE);
    }

    @Override
    public void onStop(){
        super.onStop();

        if(mPlayer.isPlaying())
            mPlayer.stop();
    }
}