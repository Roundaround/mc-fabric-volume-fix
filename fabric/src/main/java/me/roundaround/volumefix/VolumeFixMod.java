package me.roundaround.volumefix;

import me.roundaround.allay.api.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint(Entrypoint.CLIENT)
public final class VolumeFixMod implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // Mixin-only client mod: nothing to register; Trove's Fabric core self-bootstraps.
  }
}
