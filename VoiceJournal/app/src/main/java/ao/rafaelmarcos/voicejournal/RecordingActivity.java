package ao.rafaelmarcos.voicejournal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.widget.TextView;
import android.widget.Toast;

public class RecordingActivity extends AppCompatActivity {
    private TextView mTimerTextView;
    private FloatingActionButton mStopFab;

    private final int AUDIO_PERMISSION_REQUEST_CODE = 200; //WHY 200?
    private boolean mHasRecodingPermission;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission, grantResults);

        if(requestCode == AUDIO_PERMISSION_REQUEST_CODE){
            mHasRecodingPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            if(!mHasRecodingPermission)
                finish();
        }
    }

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

        // Request recording permission
        String[] recordingPermission = {Manifest.permission.RECORD_AUDIO};
        ActivityCompat.requestPermissions(this, recordingPermission, AUDIO_PERMISSION_REQUEST_CODE);
    }

    private void startRecording(){
        // TODO record audio
        Toast.makeText(this, "Recording", Toast.LENGTH_SHORT).show();
    }
}