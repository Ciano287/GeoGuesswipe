package com.example.geoguesswipe;

class GeoGuessObject {

    private int geoImageName;
    private String geoName;
    private int yesOrNo;

    int getYesOrNo() {
        return yesOrNo;
    }



    GeoGuessObject(int geoImageName, String geoName, int yesOrNo) {
        this.geoImageName = geoImageName;
        this.geoName = geoName;
        this.yesOrNo = yesOrNo;
    }

    int getGeoImageName() {
        return geoImageName;
    }


    String getGeoName() {
        return geoName;
    }


    final static int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };
    final static String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    final static int[] PRE_DEFINED_YES_OR_NO = {
            1,
            0,
            0,
            1,
            0,
            1,
            1,
            0
                };
}