package io.github.nitianstudio.ra2mcfot;

import io.github.nitianstudio.ra2mcfot.services.Services;

public class Ra2McFot {
    public static void init() {
        Constants.LOG.info("Common init on {},we are currently in a {} environment.", Services.PLATFORM.loader(), Services.PLATFORM.getEnvironmentName());



        if (Services.PLATFORM.modLoaded(Constants.MODID)) {
            Constants.LOG.info("{} is loaded", Constants.MODID);
        }
    }
}
