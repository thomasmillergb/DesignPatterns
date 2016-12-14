package com.thomasmillergb.designpatterns.factory;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Thomas
 *         Created by Thomas on 10/12/2016.
 */
public class CDFactoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createMuseCD() throws Exception {
        CD muse = CDFactory.createCD("MUSE");
        System.out.println(muse);
    }
    @Test
    public void createRockTheWorldCD() throws Exception {
        CD muse = CDFactory.createCD("RockTheWorld");
        System.out.println(muse);
    }
    @Test
    public void createMixCD() throws Exception {
        CD muse = CDFactory.createCD("Mix");
        System.out.println(muse);
    }

}