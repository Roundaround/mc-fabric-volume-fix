package me.roundaround.volumefix.client.sound;

import me.roundaround.gradle.api.annotation.InjectedInterface;

@InjectedInterface
public interface SoundRange {
  default float volumefix$getRange() {
    return 1f;
  }
}
