package app.revanced.patches.bahamut.nativeAd

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val AbsTopicAdapterCtorFingerprint = fingerprint {
    returns("V")
    opcodes(
        Opcode.IPUT_BOOLEAN,
        Opcode.IPUT_OBJECT,
        Opcode.NEW_INSTANCE,
        Opcode.CONST_4,
        Opcode.CONST_4,
        Opcode.CONST_4,
        Opcode.CONST_4,
        Opcode.CONST_16,
        Opcode.CONST_4,
        Opcode.MOVE_OBJECT,
    )
    custom { methodDef, classDef ->
        classDef.type == "Ltw/com/gamer/android/adapter/forum/AbsTopicAdapter;"
    }
}