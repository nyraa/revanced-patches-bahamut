package app.revanced.patches.bahamut.nativeAd

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val absTopicAdapterCtorFingerprint = fingerprint {
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

internal val baseFeedFragmentListFingerprint = fingerprint {
    returns("Ljava/util/ArrayList;")
    opcodes(
        Opcode.IGET_BOOLEAN,
        Opcode.IF_EQZ,
        Opcode.IF_EQ,
        Opcode.REM_INT_LIT8,
        Opcode.IF_NEZ,
        Opcode.NEW_INSTANCE,
        Opcode.MOVE_OBJECT,
        Opcode.CONST_4,
        Opcode.CONST_4,
    )
    custom { methodDef, classDef ->
        classDef.type == "Ltw/com/gamer/android/fragment/wall/BaseFeedFragment;"
    }
}