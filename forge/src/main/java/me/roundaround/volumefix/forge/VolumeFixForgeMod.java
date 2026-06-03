package me.roundaround.volumefix.forge;

import me.roundaround.trove.forge.TroveForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("volumefix")
public final class VolumeFixForgeMod {
  public VolumeFixForgeMod(FMLJavaModLoadingContext context) {
    TroveForge.bootstrap(context);
    // Mixin-only client mod: nothing else to register.
  }
}
