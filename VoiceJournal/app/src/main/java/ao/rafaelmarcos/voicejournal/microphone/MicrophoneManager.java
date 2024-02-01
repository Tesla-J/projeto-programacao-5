package ao.rafaelmarcos.voicejournal.microphone;

import android.media.MediaRecorder;
import android.os.Build;

import java.io.File;
public class MicrophoneManager {
    private MediaRecorder recorder;

    public void startRecording(File file){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            recorder.setOutputFile(file); // API 26 and further
        }
        else{
            recorder.setOutputFile(file.getPath());
        }
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
