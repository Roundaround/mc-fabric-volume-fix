plugins {
  id("me.roundaround.allay")
}

allay {
  displayName.set("Volume Fix")
  description.set("Fix volume controls in Minecraft to work as intended.")
  authors.set(listOf("Roundaround"))
  license.set("MIT")
  homepage.set("https://modrinth.com/mod/volume-fix")
  repository.set("https://github.com/Roundaround/mc-volume-fix")
  issues.set("https://github.com/Roundaround/mc-volume-fix/issues")
  logoFile.set("assets/volumefix/banner.png")

  modrinth {
    projectId.set("volume-fix")
  }

  curseforge {
    projectId.set(1506338)
  }

  release {
    versionType.set("release")
    sourcesJar.set(true)
  }
}
