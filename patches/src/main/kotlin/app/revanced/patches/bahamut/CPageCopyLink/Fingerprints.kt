package app.revanced.patches.bahamut.CPageCopyLink

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val cPageLinkFingerprint = fingerprint {
    returns("Ljava/lang/Object;")
    opcodes(
        Opcode.INVOKE_STATIC_RANGE,
        Opcode.GOTO,
        Opcode.INSTANCE_OF,
        Opcode.IF_EQZ,
        Opcode.IGET_WIDE,
        Opcode.IGET_WIDE,
    )
    custom { methodDef, classDef ->
        classDef.type == "Ltw/com/gamer/android/feature/topicCx/TopicCxViewModel;"
    }
}