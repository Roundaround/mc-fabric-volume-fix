package me.roundaround.volumefix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.roundaround.volumefix.client.sound.SoundRange;
import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.client.sound.Sound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

@Mixin(AbstractSoundInstance.class)
public abstract class AbstractSoundInstanceMixin implements SoundRange {
  @Shadow
  protected float volume;

  @Shadow
  protected Sound sound;

  @Shadow
  protected Random random;

  @Inject(method = "getVolume", at = @At("HEAD"), cancellable = true)
  private void getVolume(CallbackInfoReturnable<Float> info) {
    info.setReturnValue(MathHelper.clamp(this.calculateVolume(), 0f, 1f));
  }

  @Override
  public float getRange() {
    return calculateVolume();
  }

  @Unique
  private float calculateVolume() {
    return this.volume * this.sound.getVolume().get(this.random);
  }
}
