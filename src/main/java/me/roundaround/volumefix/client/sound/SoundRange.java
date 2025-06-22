package me.roundaround.volumefix.client.sound;

public interface SoundRange {
  default float volumefix$getRange() {
    return 1f;
  }
}
