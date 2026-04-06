package me.roundaround.volumefix.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import me.roundaround.volumefix.client.sound.SoundRange;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SoundEngine.class)
public abstract class SoundEngineMixin {
  @ModifyArg(
      method = "play(Lnet/minecraft/client/resources/sounds/SoundInstance;)Lnet/minecraft/client/sounds/SoundEngine$PlayResult;",
      at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"),
      index = 0
  )
  private float useRangeInsteadOfVolume(float volume, @Local(argsOnly = true) SoundInstance sound) {
    return sound instanceof SoundRange soundRange ? soundRange.volumefix$getRange() : volume;
  }
}
