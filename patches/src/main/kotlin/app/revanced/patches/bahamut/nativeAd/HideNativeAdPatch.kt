package app.revanced.patches.bahamut.nativeAd

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

@Suppress("unused")
val hideNativeAdPatch = bytecodePatch(
    name = "Hide native AD",
    description = "This patch hides the native ad in article list.",
) {
    compatibleWith("tw.com.gamer.android.activecenter")

    execute {
        AbsTopicAdapterCtorFingerprint.method.addInstructions(
            AbsTopicAdapterCtorFingerprint.patternMatch!!.startIndex,
            """
            const/4 p5, 0x0
            """,
        )
    }
}