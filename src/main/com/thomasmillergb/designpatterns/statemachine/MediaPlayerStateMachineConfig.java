package com.thomasmillergb.designpatterns.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
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
public class MediaPlayerStateMachineConfig  extends EnumStateMachineConfigurerAdapter<MediaPlayerStates, MediaPlayerEvents>
{
    @Override
    public void configure(StateMachineConfigurationConfigurer<MediaPlayerStates, MediaPlayerEvents> config)
        throws Exception {
        config
            .withConfiguration()
            .autoStartup(true)
            .listener(listener());

    }

    @Override
    public void configure(StateMachineStateConfigurer<MediaPlayerStates, MediaPlayerEvents> states)
        throws Exception {
        states
            .withStates()
            .initial(MediaPlayerStates.STARTUP)
            .end(MediaPlayerStates.OFF)
            .states(EnumSet.allOf(MediaPlayerStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MediaPlayerStates, MediaPlayerEvents> transitions)
        throws Exception {
        transitions
            .withExternal()
            .source(MediaPlayerStates.STARTUP).target(MediaPlayerStates.PLAYING).event(MediaPlayerEvents.PLAYING)
            .and()
            .withExternal()
            .source(MediaPlayerStates.PLAYING).target(MediaPlayerStates.STOP).event(MediaPlayerEvents.STOP);

    }

    @Bean
    public StateMachineListener<MediaPlayerStates, MediaPlayerEvents> listener() {
        return new StateMachineListenerAdapter<MediaPlayerStates, MediaPlayerEvents>() {
            @Override
            public void stateChanged(State<MediaPlayerStates, MediaPlayerEvents> from, State<MediaPlayerStates, MediaPlayerEvents> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

}
