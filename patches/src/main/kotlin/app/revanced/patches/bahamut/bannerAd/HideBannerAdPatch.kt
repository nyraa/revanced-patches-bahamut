package app.revanced.patches.bahamut.bannerAd

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

@Suppress("unused")
val hideBannerAdPatch = bytecodePatch(
    name = "Hide Banner Ad",
    description = "This patch hides the banner ad.",
) {
    compatibleWith("tw.com.gamer.android.activecenter")

    execute {
        bannerAdFingerprint.method.addInstructions(
            0,
            """
                return-void
            """,
        )
    }
}