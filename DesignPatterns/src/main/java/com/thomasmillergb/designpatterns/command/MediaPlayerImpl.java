package com.thomasmillergb.designpatterns.command;

import com.thomasmillergb.designpatterns.factory.CD;
import com.thomasmillergb.designpatterns.factory.CDFactory;
import com.thomasmillergb.designpatterns.factory.Track;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by milleth on 13/12/2016.
 *
 * @author milleth
 */

public class MediaPlayerImpl implements MediaPlayer {
    private CD cd_;
    private int currentTrackPos_ = 0;
    private Track currentTrack_;
    private boolean loop_ = false;


    public MediaPlayerImpl() {
        cd_ = CDFactory.createCD("MUSE");
    }


    // TODO add threading
    @Override
    public void play() {
        if (currentTrackPos_ == 0) {
            currentTrack_ = null;
        }
        if (currentTrack_ == null) {
            if (cd_.getTrackList().size() != 0) {
                currentTrack_ = cd_.getTrackList().get(0);
                currentTrackPos_ = 1;
                play();
            }
        } else {
            System.out.println("playing: " + currentTrackPos_ + " " + currentTrack_);
            next();
        }
    }

    @Override
    public void next() {
        List<Track> trackList = cd_.getTrackList();
        if (trackList.size() > currentTrackPos_) {
            currentTrackPos_++;
            getCurrentTrack(trackList);
            play();
        } else if (loop_) {
            currentTrackPos_ = 1;
            getCurrentTrack(trackList);
            play();
        } else {
            currentTrackPos_ = 0;
            System.out.println("end of cd");
        }
    }

    private void getCurrentTrack(List<Track> trackList) {
        currentTrack_ = trackList.get(currentTrackPos_ - 1);
    }

    @Override
    public void prev() {
        List<Track> trackList = cd_.getTrackList();
        ListIterator<Track> trackListIterator = trackList.listIterator();
        if (currentTrackPos_ > 1) {
            currentTrackPos_--;
            currentTrack_ = trackListIterator.next();
        } else {
            currentTrackPos_ = trackList.size();
            getCurrentTrack(trackList);
        }
        play();
    }

    public CD getCd() {
        return cd_;
    }

    public void setCd(CD cd) {
        cd_ = cd;
    }

    public Track getCurrentTrack() {
        return currentTrack_;
    }
}
