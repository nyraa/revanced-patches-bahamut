package app.revanced.patches.bahamut.bannerAd

import app.revanced.patcher.fingerprint

internal val bannerAdFingerprint = fingerprint {
    returns("V")
    parameters("Ljava/lang/String;")
    custom { methodDef, classDef -> 
        classDef.type == "Ltw/com/gamer/android/view/BannerAdView;" && methodDef.name == "loadBanner"
    }
}