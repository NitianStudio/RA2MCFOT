package io.github.nitianstudio.ra2mcfot.services;

import io.github.nitianstudio.ra2mcfot.Constants;
import io.github.nitianstudio.ra2mcfot.services.platform.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T load = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", load, clazz);
        return load;
    }
}
