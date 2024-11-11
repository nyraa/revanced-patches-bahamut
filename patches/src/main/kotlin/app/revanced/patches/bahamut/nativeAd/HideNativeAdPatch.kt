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
        absTopicAdapterCtorFingerprint.method.addInstructions(
            absTopicAdapterCtorFingerprint.patternMatch!!.startIndex,
            """
            const/4 p5, 0x0
            """,
        )
        baseFeedFragmentListFingerprint.method.addInstructions(
            baseFeedFragmentListFingerprint.patternMatch!!.startIndex + 1,
            """
            const/4 v10, 0x0
            """,
        )
    }
}