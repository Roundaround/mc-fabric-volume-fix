package me.roundaround.volumefix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.roundaround.volumefix.client.sound.SoundRange;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
  SoundInstance sound = null;

  @Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At(value = "HEAD"))
  private void play(SoundInstance sound, CallbackInfo info) {
    this.sound = sound;
  }

  @ModifyArg(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"), index = 0)
  private float useRangeInsteadOfVolume(float volume) {
    return this.sound != null && this.sound instanceof SoundRange
        ? ((SoundRange) this.sound).getRange()
        : volume;
  }
}
