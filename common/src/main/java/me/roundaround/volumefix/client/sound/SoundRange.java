package me.roundaround.volumefix.client.sound;

import me.roundaround.allay.api.InjectedInterface;

@InjectedInterface
public interface SoundRange {
  default float volumefix$getRange() {
    return 1f;
  }
}
