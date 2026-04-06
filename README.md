![Volume Fix](https://imgur.com/P4uQjtt.png)

![](https://img.shields.io/badge/Loader-Fabric-313e51?style=for-the-badge)
![](https://img.shields.io/badge/MC-26.1--26.1.1%20|%201.21%20|%201.20%20|%201.19-313e51?style=for-the-badge)
![](https://img.shields.io/badge/Side-Client-313e51?style=for-the-badge)

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/volume-fix?style=flat&logo=modrinth&color=00AF5C)](https://modrinth.com/mod/volume-fix)
[![GitHub Repo stars](https://img.shields.io/github/stars/Roundaround/mc-fabric-volume-fix?style=flat&logo=github)](https://github.com/Roundaround/mc-fabric-volume-fix)

[![Support me on Ko-fi](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/donate/kofi-singular-alt_vector.svg)](https://ko-fi.com/roundaround)

---

Fix volume controls in Minecraft to work as intended. In particular, very loud sounds (thunder, jukeboxes, fireworks) should now react properly to changes in the appropriate volume sliders!

## The why (technical)

In vanilla Minecraft, will only play for players within a certain distance. The distance is based on the volume of the sound being played. This means loud sounds (i.e. thunder) are set to an absurd volume in order to be heard from anywhere. The side effect of this is that no matter what you set your weather volume slider to, the thunder sound will always be played at 100% volume. Some other loud sounds like jukeboxes and fireworks suffer from the same problem, though not as extreme (the volume slider does nothing for them until it gets really low).

In order to fix this, I've capped all the internal volumes to 100%, then used the original volume value to determine the range like normal. This results in sounds being audible from the expected range, but the actual volume level scaling correctly with the slider.
