package com.thomasmillergb.designpatterns.factory.cd;

import com.thomasmillergb.designpatterns.factory.AbstractCD;
import com.thomasmillergb.designpatterns.factory.track.Track1;
import com.thomasmillergb.designpatterns.factory.track.Track2;
import com.thomasmillergb.designpatterns.factory.track.Track3;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public class MuseCD extends AbstractCD {
    @Override
    protected void createCD() {
        trackList_.add(new Track1());
        trackList_.add(new Track2());
        trackList_.add(new Track3());
    }
}
