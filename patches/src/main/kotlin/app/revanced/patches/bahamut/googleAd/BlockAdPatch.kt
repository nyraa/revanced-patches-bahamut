package app.revanced.patches.bahamut.googleAd

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

@Suppress("unused")
val hideAdsPatch = bytecodePatch(
    name = "Block Google ad loader",
    description = "This patch blocks the Google ad loader.",
) {
    compatibleWith("tw.com.gamer.android.activecenter")

    execute {
        googleAdLoader1Fingerprint.method.addInstructions(
            0,
            """
                return-void
            """,  
        )
        googleAdLoader2Fingerprint.method.addInstructions(
            0,
            """
                return-void
            """,
        )
        googleAdLoader3Fingerprint.method.addInstructions(
            0,
            """
                return-void
            """,
        )
    }
}