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

import ao.rafaelmarcos.voicejournal.microphone.MicrophoneManager;

public class RecordingActivity extends AppCompatActivity {
    public static String AUDIO_FILE;

    private TextView mTimerTextView;
    private FloatingActionButton mStopFab;

    private final int AUDIO_PERMISSION_REQUEST_CODE = 200; //WHY 200?
    private boolean mHasRecodingPermission;

    private MicrophoneManager mMicrophoneManager;

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

        mTimerTextView = findViewById(R.id.timer); // TODO update with a timer in another thread
        mStopFab = findViewById(R.id.stop_fab);
        mStopFab.setOnClickListener((v) -> {
            mMicrophoneManager.stopRecording();
            finish();
        });

        // Request recording permission
        String[] recordingPermission = {Manifest.permission.RECORD_AUDIO};
        ActivityCompat.requestPermissions(this, recordingPermission, AUDIO_PERMISSION_REQUEST_CODE);

        // TODO don't rely on it
        // Set default filename (testing purpose)
        RecordingActivity.AUDIO_FILE = getFilesDir() + "/" + "audio.amr";

        mMicrophoneManager = new MicrophoneManager();
    }


    @Override
    public void onStart(){
        super.onStart();

        mMicrophoneManager.startRecording(RecordingActivity.AUDIO_FILE);
    }

    @Override
    public void onStop(){
        super.onStop();

        mMicrophoneManager.stopRecording();
    }
}