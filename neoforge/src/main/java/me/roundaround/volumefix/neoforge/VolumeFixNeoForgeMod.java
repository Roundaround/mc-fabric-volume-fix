package me.roundaround.volumefix.neoforge;

import me.roundaround.trove.neoforge.TroveNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod("volumefix")
public final class VolumeFixNeoForgeMod {
  public VolumeFixNeoForgeMod(IEventBus modBus, ModContainer container) {
    TroveNeoForge.bootstrap(modBus, container);
    // Mixin-only client mod: nothing else to register.
  }
}
