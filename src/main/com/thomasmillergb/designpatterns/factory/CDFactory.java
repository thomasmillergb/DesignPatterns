package com.thomasmillergb.designpatterns.factory;

import com.thomasmillergb.designpatterns.factory.cd.MixCD;
import com.thomasmillergb.designpatterns.factory.cd.MuseCD;
import com.thomasmillergb.designpatterns.factory.cd.RockTheWorldCD;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public class CDFactory {
    public static CD createCD(String cdName) {
        CD cd = null;
        switch (cdName) {
            case "MUSE":
                cd = new MuseCD();
                break;
            case "RockTheWorld":
                cd = new RockTheWorldCD();
                break;
            case "Mix":
                cd = new MixCD();
                break;
        }
        return cd;
    }
}
