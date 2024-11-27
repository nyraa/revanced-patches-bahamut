package app.revanced.patches.bahamut.CPageCopyLink


import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions

@Suppress("unused")
val cPageLinkPatch = bytecodePatch(
    name = "Copy link in pc format",
    description = "This patch changes the copy topic link to forum.gamer.com.tw/C.php"
) {
    compatibleWith("tw.com.gamer.android.activecenter")

    execute {
        cPageLinkFingerprint.method.replaceInstructions(
            cPageLinkFingerprint.patternMatch!!.endIndex + 1,
            """
            invoke-static {v2, v3, v4, v5, v6}, Ltw/com/gamer/android/function/service/ForumKt;->createPcCxUrl(JJLjava/lang/String;)Ljava/lang/String;
            """
        )
        cPageLinkFingerprint.method.addInstructions(
            cPageLinkFingerprint.patternMatch!!.endIndex,
            """
            const-string v6, ""
            """
        )
    }
}