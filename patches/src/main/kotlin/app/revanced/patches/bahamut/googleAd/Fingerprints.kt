package app.revanced.patches.bahamut.googleAd

import app.revanced.patcher.fingerprint

internal val googleAdLoader1Fingerprint = fingerprint {
    returns("V")
    parameters("Lcom/google/android/gms/ads/AdRequest;")
    custom { methodDef, classDef ->
        classDef.type == "Lcom/google/android/gms/ads/AdLoader;" && methodDef.name == "loadAd"
    }
}

internal val googleAdLoader2Fingerprint = fingerprint {
    returns("V")
    parameters("Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;")
    custom { methodDef, classDef ->
        classDef.type == "Lcom/google/android/gms/ads/AdLoader;" && methodDef.name == "loadAd"
    }
}

internal val googleAdLoader3Fingerprint = fingerprint {
    returns("V")
    parameters("Lcom/google/android/gms/ads/AdRequest;I")
    custom { methodDef, classDef ->
        classDef.type == "Lcom/google/android/gms/ads/AdLoader;" && methodDef.name == "loadAds"
    }
}