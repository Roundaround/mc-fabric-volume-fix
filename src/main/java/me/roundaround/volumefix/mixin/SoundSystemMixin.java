package me.roundaround.volumefix.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import me.roundaround.volumefix.client.sound.SoundRange;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
  @ModifyArg(
      method = "play(Lnet/minecraft/client/sound/SoundInstance;)V",
      at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"),
      index = 0
  )
  private float useRangeInsteadOfVolume(float volume, @Local(argsOnly = true) SoundInstance sound) {
    return sound instanceof SoundRange soundRange ? soundRange.getRange() : volume;
  }
}
