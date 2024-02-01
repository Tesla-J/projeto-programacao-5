package ao.rafaelmarcos.voicejournal.player;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class Player {
    private MediaPlayer player;

    public void play(String filePath){
        if(player != null)
            player.start();
        else{
            player = new MediaPlayer();
            try{
                player.setDataSource(filePath);
                player.prepare();
                player.start();
            }
            catch(IOException ioe){
                Log.e("PLAY AUDIO FAILED", "Failed to play audio");
                ioe.printStackTrace();
            }
        }
    }

    public void pause(){
        if(player != null)
            player.pause();
    }

    public void stop(){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }

    public boolean isPlaying(){
        return player != null;
    }
}
