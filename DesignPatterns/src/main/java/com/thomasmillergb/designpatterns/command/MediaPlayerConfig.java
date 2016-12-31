package com.thomasmillergb.designpatterns.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Thomas
 *         Created by Thomas on 31/12/2016.
 */
@Configuration
public class MediaPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer() {
        return new MediaPlayerImpl();
    }

    @Bean
    public MediaPlayerCommandFactory mediaPlayerCommands(MediaPlayer mediaPlayer) {
        return new MediaPlayerCommandFactory(mediaPlayer);
    }

}
