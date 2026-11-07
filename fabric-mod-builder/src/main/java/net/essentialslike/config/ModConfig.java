package net.essentialslike.config;

/**
 * 全設定のデータクラス。Gson で config/essentials_like.json に保存・読込する。
 * 数値はすべて setter 相当の clamp を ConfigManager 側で適用する。
 */
public class ModConfig {
    // ---- 機能ON/OFF（推奨デフォルト準拠）----
    public boolean oreBreakerEnabled = true;
    public boolean stoneBreakerEnabled = true;
    public boolean sandBreakerEnabled = true;
    public boolean treeBreakerEnabled = true;
    public boolean leavesBreakerEnabled = false;
    public boolean cropBreakerEnabled = true;
    public boolean cropReplantingEnabled = true;
    public boolean treeReplantingEnabled = true;
    public boolean lavaReflowEnabled = true;
    public boolean breakableSpawnerEnabled = true;
    public boolean autoUpdatingMapEnabled = false;
    public boolean privateDeathWaypointEnabled = false;
    public boolean lockableChestEnabled = false;
    public boolean chunkBorderHudEnabled = false;

    // ---- 反転・危険設定 ----
    public boolean sneakInverted = false;
    public boolean obsidianInStoneBreaker = true;
    public boolean treeBreakerFixedDurability = true;
    public boolean disenchanterRemovesCurse = true;

    // ---- 数値パラメータ ----
    /** 範囲 1〜3 */
    public int breakerRange = 1;
    /** 速度制限 0〜20（0 = TPS に応じて自動調整） */
    public int breakerSpeedLimit = 0;
    /** デスウェイポイントのタイムアウト（分）20〜600 */
    public int deathWaypointTimeoutMinutes = 360;
    /** ワールドアンカーのチャンク半径 10/20/30/40 */
    public int anchorChunkRadius = 10;
    /** 食料情報の詳細度 0〜3 */
    public int foodInfoDetail = 1;
}
