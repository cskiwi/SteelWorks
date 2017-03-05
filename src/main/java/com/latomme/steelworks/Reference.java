package com.latomme.steelworks;

/**
 * Created by Glenn Latomme on 3/3/2017.
 */
public class Reference {
    public static final String MOD_ID = "sw";
    public static final String NAME = "SteelWorks";
    public static final String VERSION = "0.0.1-alpha";
    public static final String ACCEPTED_VERSIONS = "[1.11.2]";

    public static final String CLIENT_PROXY_CLASS = "com.latomme.steelworks.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.latomme.steelworks.proxy.ServerProxy";
    public static final Double PIXEL_DISTANCE = 0.0625;

    public enum SteelWorksItems {
        CHEESE("item_cheese", "item_cheese");

        private String unlocalizedName;
        private String registeryName;

        SteelWorksItems(String unlocalizedName, String registeryName){
            this.unlocalizedName = unlocalizedName;
            this.registeryName = registeryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegisteryName() {
            return registeryName;
        }


    }
    public enum SteelWorksBlocks {
        CHEESE("block_cheese", "block_cheese"),
        JAR("block_jar", "block_jar");

        private String unlocalizedName;
        private String registeryName;

        SteelWorksBlocks(String unlocalizedName, String registeryName){
            this.unlocalizedName = unlocalizedName;
            this.registeryName = registeryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegisteryName() {
            return registeryName;
        }


    }
}
