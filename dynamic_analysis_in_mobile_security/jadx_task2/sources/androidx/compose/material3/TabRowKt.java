package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u009d\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0093\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowPadding", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m4873constructorimpl(90);
    private static final float ScrollableTabRowPadding = Dp.m4873constructorimpl(52);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1509TabRowpAZo6Ak(final int r25, androidx.compose.ui.Modifier r26, long r27, long r29, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m1509TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118  */
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1508ScrollableTabRowsKfQg0A(final int r27, androidx.compose.ui.Modifier r28, long r29, long r31, float r33, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m1508ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
