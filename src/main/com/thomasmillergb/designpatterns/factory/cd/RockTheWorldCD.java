package com.thomasmillergb.designpatterns.factory.cd;

import com.thomasmillergb.designpatterns.factory.AbstractCD;
import com.thomasmillergb.designpatterns.factory.track.TrackV1;
import com.thomasmillergb.designpatterns.factory.track.TrackV2;
import com.thomasmillergb.designpatterns.factory.track.TrackV3;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public class RockTheWorldCD extends AbstractCD
{
    @Override
    protected void createCD()
    {
        trackList_.add(new TrackV1());
        trackList_.add(new TrackV2());
        trackList_.add(new TrackV3());
    }
}
