package ao.rafaelmarcos.voicejournal.microphone;

import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MicrophoneManager {
    private MediaRecorder recorder;

    public void startRecording(String file){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(file);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try{
            recorder.prepare();
        }
        catch (IOException ioe){
            Log.e("Recording error", "Unable to record audio");
            ioe.printStackTrace();
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
