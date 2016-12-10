package com.thomasmillergb.designpatterns.factory.cd;

import com.thomasmillergb.designpatterns.factory.AbstractCD;
import com.thomasmillergb.designpatterns.factory.track.*;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public class MixCD extends AbstractCD {
    @Override
    protected void createCD() {
        trackList_.add(new Track1());
        trackList_.add(new Track2());
        trackList_.add(new Track3());
        trackList_.add(new TrackV1());
        trackList_.add(new TrackV2());
        trackList_.add(new TrackV3());
    }
}
