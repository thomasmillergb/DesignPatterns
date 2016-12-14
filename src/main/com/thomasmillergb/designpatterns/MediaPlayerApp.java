package com.thomasmillergb.designpatterns;

import com.thomasmillergb.designpatterns.statemachine.MediaPlayerEvents;
import com.thomasmillergb.designpatterns.statemachine.MediaPlayerStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * Created by milleth on 14/12/2016.
 *
 * @author milleth
 */
@SpringBootApplication
public class MediaPlayerApp implements CommandLineRunner
{

    @Autowired
    private StateMachine<MediaPlayerStates, MediaPlayerEvents> mediaPlayerStateMachine_;

    public static void main(String[] args)
    {
        SpringApplication.run(MediaPlayerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        mediaPlayerStateMachine_.sendEvent(MediaPlayerEvents.PLAYING);
        mediaPlayerStateMachine_.sendEvent(MediaPlayerEvents.STOP);
    }
}
