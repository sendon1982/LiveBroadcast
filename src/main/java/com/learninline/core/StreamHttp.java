package com.learninline.core;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

/**
 * Created by mjiang on 12/05/16 -- JM
 */
public class StreamHttp {

    public static void main(String[] args) throws Exception {

        String media = "https://www.youtube.com/watch?v=NilASeqRsjw";
        String options = formatHttpStream("127.0.0.1", 5555);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        mediaPlayer.playMedia(media, options);

        // Don't exit
        Thread.currentThread().join();
    }

    private static String formatHttpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#duplicate{dst=std{access=http,mux=ts,");
        sb.append("dst=");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append("}}");
        return sb.toString();
    }
}
