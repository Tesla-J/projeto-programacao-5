package ao.rafaelmarcos.voicejournal;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class RecordingActivity extends AppCompatActivity {
    private TextView mTimerTextView;
    private FloatingActionButton mStopFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        mTimerTextView = findViewById(R.id.timer);
        mStopFab = findViewById(R.id.stop_fab);
        mStopFab.setOnClickListener((v) -> {
            // TODO stop recoding and save file
            String timerText = String.format(getString(R.string.timer), 99);
            mTimerTextView.setText(timerText);
        });
    }
}