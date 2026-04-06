package me.roundaround.volumefix.mixin;

import me.roundaround.volumefix.client.sound.SoundRange;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractSoundInstance.class)
public abstract class AbstractSoundInstanceMixin implements SoundRange {
  @Shadow
  protected float volume;

  @Shadow
  protected Sound sound;

  @Final
  @Shadow
  protected RandomSource random;

  @Inject(method = "getVolume", at = @At("HEAD"), cancellable = true)
  private void getVolume(CallbackInfoReturnable<Float> info) {
    info.setReturnValue(Mth.clamp(this.calculateVolume(), 0f, 1f));
  }

  @Override
  public float volumefix$getRange() {
    return this.calculateVolume();
  }

  @Unique
  private float calculateVolume() {
    return this.volume * this.sound.getVolume().sample(this.random);
  }
}
