package app.revanced.patches.bahamut.fullscreenAd

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

@Suppress("unused")
val fullscreenAdPatch = bytecodePatch(
    name = "Hide full screen AD",
    description = "This patch hides the full screen ad.",
) {
    compatibleWith("tw.com.gamer.android.activecenter")

    execute {
        fullscreenAdFingerprint.method.addInstructions(
            0,
            """
            const/4 v0, 0x0
            return v0
            """,
        )
    }
}