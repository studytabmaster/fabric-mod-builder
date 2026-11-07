package net.essentialslike;

import net.essentialslike.config.ConfigManager;
import net.essentialslike.config.ModConfig;
import net.essentialslike.feature.FeatureRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EssentialsLikeMod implements ModInitializer {
    public static final String MOD_ID = "essentials_like";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static ModConfig config;

    @Override
    public void onInitialize() {
        config = ConfigManager.load();
        FeatureRegistry.initCommon(config);
        LOGGER.info("EssentialsLike loaded");
    }

    public static ModConfig getConfig() {
        return config;
    }
}
