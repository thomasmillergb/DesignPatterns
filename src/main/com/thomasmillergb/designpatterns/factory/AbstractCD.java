package com.thomasmillergb.designpatterns.factory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public abstract class AbstractCD implements CD{
    protected List<Track> trackList_;

    public AbstractCD() {
        trackList_ = new LinkedList<>();
        createCD();
    }

    protected abstract void createCD();

    public List<Track> getTrackList() {
        return trackList_;
    }

    @Override
    public String toString() {
        return trackList_.toString();
    }
}
