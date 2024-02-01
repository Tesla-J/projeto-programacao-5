package ao.rafaelmarcos.voicejournal.microphone;

import android.media.MediaRecorder;
import android.os.Build;

import java.io.File;
public class MicrophoneManager {
    private MediaRecorder recorder;

    public void startRecording(String file){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(file); // API 26 and further
        recorder.start();
    }

    public void stopRecording(){
        if(recorder != null){
            recorder.stop();
            recorder.release();
            recorder = null;
        }
    }
}
