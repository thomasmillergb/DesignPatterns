package com.thomasmillergb.designpatterns.command;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by milleth on 13/12/2016.
 *
 * @author milleth
 */
public class MediaPlayerCommandFactory {
    private final HashMap<MediaPlayerCommandKey, MediaPlayerCommand> commands_;
    private final MediaPlayer mediaPlayer_;

    @Autowired
    public MediaPlayerCommandFactory(MediaPlayer mediaPlayer) {
        mediaPlayer_ = mediaPlayer;
        commands_ = new HashMap<>(10);
        addCommand(MediaPlayerCommandKey.PLAY, mediaPlayer_::play);
        addCommand(MediaPlayerCommandKey.NEXT, mediaPlayer_::next);
        addCommand(MediaPlayerCommandKey.PREV, mediaPlayer_::prev);

    }

    /* Factory pattern */
//    public static MediaPlayerCommandFactory init(final MediaPlayer mediaPlayer)
//    {
//        MediaPlayerCommandFactory commandFactory = new MediaPlayerCommandFactory(mediaPlayer);
//        commandFactory.addCommand(MediaPlayerCommandKey.PLAY, mediaPlayer::play);
//        commandFactory.addCommand(MediaPlayerCommandKey.NEXT, mediaPlayer::next);
//        commandFactory.addCommand(MediaPlayerCommandKey.PREV, mediaPlayer::prev);
//        return commandFactory;
//    }

    private void addCommand(MediaPlayerCommandKey name, MediaPlayerCommand command) {
        commands_.put(name, command);
    }

    public void executeCommand(MediaPlayerCommandKey key) {
        if (commands_.containsKey(key)) {
            commands_.get(key).execute();
        }
    }

    public void listCommands() {
        System.out.println("Enabled commands: " + commands_.keySet().stream().map(Enum::name).collect(Collectors.joining(", ")));
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer_;
    }
}
