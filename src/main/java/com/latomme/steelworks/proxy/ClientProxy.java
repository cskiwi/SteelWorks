package com.latomme.steelworks.proxy;

import com.latomme.steelworks.init.ModItems;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class ClientProxy implements CommonProxy {
    @Override
    public void init() {
        ModItems.registerRenders();
    }
}
