package app.revanced.patches.bahamut.fullscreenAd

import app.revanced.patcher.fingerprint

internal val fullscreenAdFingerprint = fingerprint {
    returns("Z")
    parameters()
    custom { methodDef, classDef -> 
        classDef.type == "Ltw/com/gamer/android/activity/base/BahamutActivity;" && methodDef.name == "isFullScreenAdEnable"
    }
}