package com.thomasmillergb.designpatterns.statemachine;

import com.thomasmillergb.designpatterns.command.MediaPlayer;
import com.thomasmillergb.designpatterns.command.MediaPlayerCommandFactory;
import com.thomasmillergb.designpatterns.command.MediaPlayerCommandKey;
import com.thomasmillergb.designpatterns.command.MediaPlayerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * Created by milleth on 14/12/2016.
 *
 * @author milleth
 */
@Configuration
@EnableStateMachine
public class MediaPlayerStateMachineConfig  extends StateMachineConfigurerAdapter<MediaPlayerStates, MediaPlayer>
{
    MediaPlayerCommandFactory mediaPlayerCommandFactory_;
    public MediaPlayerStateMachineConfig() {
        mediaPlayerCommandFactory_ = MediaPlayerCommandFactory.init(new MediaPlayerImpl());
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<MediaPlayerStates, MediaPlayer> config)
        throws Exception {
        config
            .withConfiguration()
            .autoStartup(true)
            .listener(listener());

    }

    @Override
    public void configure(StateMachineStateConfigurer<MediaPlayerStates, MediaPlayer> states)
        throws Exception {
        states
            .withStates()
            .initial(MediaPlayerStates.STARTUP)
            .end(MediaPlayerStates.OFF)
            .states(EnumSet.allOf(MediaPlayerStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MediaPlayerStates, MediaPlayer> transitions)
        throws Exception {
        transitions
            .withExternal()
            .source(MediaPlayerStates.STARTUP).target(MediaPlayerStates.PLAYING).event(mediaPlayerCommandFactory_.executeCommand(MediaPlayerCommandKey.PLAY))
            .and()
            .withExternal()
            .source(MediaPlayerStates.PLAYING).target(MediaPlayerStates.STOP).event(mediaPlayerCommandFactory_.executeCommand(MediaPlayerCommandKey.BACKWARDS));

    }

    @Bean
    public StateMachineListener<MediaPlayerStates, MediaPlayer> listener() {
        return new StateMachineListenerAdapter<MediaPlayerStates, MediaPlayer>() {
            @Override
            public void stateChanged(State<MediaPlayerStates, MediaPlayer> from, State<MediaPlayerStates, MediaPlayer> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

}
