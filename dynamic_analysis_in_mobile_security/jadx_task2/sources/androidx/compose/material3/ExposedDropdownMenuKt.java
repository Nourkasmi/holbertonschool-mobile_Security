package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\bH\u0002\u001aE\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuDescription", "", "expandedDescription", "collapsedDescription", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m4873constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0197 A[LOOP:0: B:69:0x0194->B:71:0x0197, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0355  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ExposedDropdownMenuBox(final boolean r23, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier expandable(Modifier modifier, final boolean z, final Function0<Unit> function0, String str, String str2, String str3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1006563320);
        ComposerKt.sourceInformation(composer, "C(expandable)P(1,4,3,2)1017@60116L38,1018@60190L31,1019@60258L32,1020@60315L365,1030@60691L187:ExposedDropdownMenu.kt#uh7d8r");
        final String strM1465getStringNWtq28 = (i2 & 4) != 0 ? Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1442getExposedDropdownMenuadMyvUU(), composer, 6) : str;
        String strM1465getStringNWtq282 = (i2 & 8) != 0 ? Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1444getMenuExpandedadMyvUU(), composer, 6) : str2;
        String strM1465getStringNWtq283 = (i2 & 16) != 0 ? Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1443getMenuCollapsedadMyvUU(), composer, 6) : str3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006563320, i, -1, "androidx.compose.material3.expandable (ExposedDropdownMenu.kt:1014)");
        }
        Unit unit = Unit.INSTANCE;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(function0);
        ExposedDropdownMenuKt$expandable$1$1 exposedDropdownMenuKt$expandable$1$1RememberedValue = composer.rememberedValue();
        if (zChanged || exposedDropdownMenuKt$expandable$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            exposedDropdownMenuKt$expandable$1$1RememberedValue = new ExposedDropdownMenuKt$expandable$1$1(function0, null);
            composer.updateRememberedValue(exposedDropdownMenuKt$expandable$1$1RememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) exposedDropdownMenuKt$expandable$1$1RememberedValue);
        Object[] objArr = {Boolean.valueOf(z), strM1465getStringNWtq282, strM1465getStringNWtq283, strM1465getStringNWtq28, function0};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged2 = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged2 |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final String str4 = strM1465getStringNWtq282;
            final String str5 = strM1465getStringNWtq283;
            objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setStateDescription(semantics, z ? str4 : str5);
                    SemanticsPropertiesKt.setContentDescription(semantics, strM1465getStringNWtq28);
                    final Function0<Unit> function02 = function0;
                    SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            function02.invoke();
                            return true;
                        }
                    }, 1, null);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue, 1, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierSemantics$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        view.getWindowVisibleDisplayFrame(new Rect());
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - r0.top, (r0.bottom - r0.top) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
    }
}
