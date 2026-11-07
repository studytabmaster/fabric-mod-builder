package net.essentialslike.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.essentialslike.EssentialsLikeMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/** config/essentials_like.json の読み込み・保存。存在しなければデフォルトを生成する。 */
public final class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = FabricLoader.getInstance().getConfigDir()
            .resolve(EssentialsLikeMod.MOD_ID + ".json");

    private ConfigManager() {}

    public static ModConfig load() {
        ModConfig config = null;
        if (Files.exists(PATH)) {
            try {
                config = GSON.fromJson(Files.readString(PATH, StandardCharsets.UTF_8), ModConfig.class);
            } catch (IOException | RuntimeException e) {
                EssentialsLikeMod.LOGGER.error("設定の読込に失敗しました。デフォルトを使用します", e);
            }
        }
        if (config == null) {
            config = new ModConfig();
        }
        clamp(config);
        save(config);
        return config;
    }

    public static void save(ModConfig config) {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, GSON.toJson(config), StandardCharsets.UTF_8);
        } catch (IOException e) {
            EssentialsLikeMod.LOGGER.error("設定の保存に失敗しました", e);
        }
    }

    /** 範囲外の値を許容範囲に丸める。 */
    static void clamp(ModConfig c) {
        c.breakerRange = clamp(c.breakerRange, 1, 3);
        c.breakerSpeedLimit = clamp(c.breakerSpeedLimit, 0, 20);
        c.deathWaypointTimeoutMinutes = clamp(c.deathWaypointTimeoutMinutes, 20, 600);
        c.foodInfoDetail = clamp(c.foodInfoDetail, 0, 3);
        if (c.anchorChunkRadius != 10 && c.anchorChunkRadius != 20
                && c.anchorChunkRadius != 30 && c.anchorChunkRadius != 40) {
            c.anchorChunkRadius = 10;
        }
    }

    private static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(max, v));
    }
}
