plugins {
  id("roundalib")
}

loom {
  interfaceInjection {
    getIsEnabled().set(true)
  }
}
