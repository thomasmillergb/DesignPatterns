package com.thomasmillergb.designpatterns.factory;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public abstract  class AbstractTrack implements Track{
    private String name_ = "No Track Name";
    private String band_ = "No Band Name";

    protected AbstractTrack(String name, String band) {
        name_ = name;
        band_ = band;
    }

    @Override
    public String getName() {
        return name_;
    }

    @Override
    public String getBand() {
        return band_;
    }

    @Override
    public String toString() {
        return "\n name: " + name_ + " band: " + band_;
    }
}
