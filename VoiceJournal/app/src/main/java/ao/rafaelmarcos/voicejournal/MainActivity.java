package ao.rafaelmarcos.voicejournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mRecordFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordFab = findViewById(R.id.record_fab);
        mRecordFab.setOnClickListener((v) -> {
            Intent intent = new Intent(this, RecordingActivity.class);
            startActivity(intent);
        });
    }
}