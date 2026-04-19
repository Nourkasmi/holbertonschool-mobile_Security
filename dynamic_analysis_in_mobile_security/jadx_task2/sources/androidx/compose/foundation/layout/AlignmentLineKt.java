package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aA\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlignmentLineKt {
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m362paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM();
        }
        return m361paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m361paddingFrom4j6BHR0(Modifier paddingFrom, final AlignmentLine alignmentLine, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(paddingFrom, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set("before", Dp.m4871boximpl(f));
                inspectorInfo.getProperties().set("after", Dp.m4871boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m364paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE();
        }
        return m363paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m363paddingFromY_r0B1c(Modifier paddingFrom, final AlignmentLine alignmentLine, final long j, final long j2) {
        Intrinsics.checkNotNullParameter(paddingFrom, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetTextUnitElement(alignmentLine, j, j2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set("before", TextUnit.m5044boximpl(j));
                inspectorInfo.getProperties().set("after", TextUnit.m5044boximpl(j2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m366paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM();
        }
        return m365paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m365paddingFromBaselineVpY3zN4(Modifier paddingFromBaseline, float f, float f2) {
        Modifier.Companion companionM362paddingFrom4j6BHR0$default;
        Modifier.Companion companionM362paddingFrom4j6BHR0$default2;
        Intrinsics.checkNotNullParameter(paddingFromBaseline, "$this$paddingFromBaseline");
        if (!Dp.m4878equalsimpl0(f, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM())) {
            companionM362paddingFrom4j6BHR0$default = m362paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            companionM362paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = paddingFromBaseline.then(companionM362paddingFrom4j6BHR0$default);
        if (!Dp.m4878equalsimpl0(f2, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM())) {
            companionM362paddingFrom4j6BHR0$default2 = m362paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            companionM362paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM362paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m368paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE();
        }
        return m367paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m367paddingFromBaselinewCyjxdI(Modifier paddingFromBaseline, long j, long j2) {
        Intrinsics.checkNotNullParameter(paddingFromBaseline, "$this$paddingFromBaseline");
        return paddingFromBaseline.then(!TextUnitKt.m5072isUnspecifiedR2X_6o(j) ? m364paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null) : Modifier.INSTANCE).then(!TextUnitKt.m5072isUnspecifiedR2X_6o(j2) ? m364paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null) : Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m360alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int iMax;
        int height;
        final Placeable placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo3866measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? placeableMo3866measureBRTryo0.getHeight() : placeableMo3866measureBRTryo0.getWidth();
        int iM4828getMaxHeightimpl = (getHorizontal(alignmentLine) ? Constraints.m4828getMaxHeightimpl(j) : Constraints.m4829getMaxWidthimpl(j)) - height2;
        final int iCoerceIn = RangesKt.coerceIn((!Dp.m4878equalsimpl0(f, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM()) ? measureScope.mo319roundToPx0680j_4(f) : 0) - i, 0, iM4828getMaxHeightimpl);
        final int iCoerceIn2 = RangesKt.coerceIn(((!Dp.m4878equalsimpl0(f2, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM()) ? measureScope.mo319roundToPx0680j_4(f2) : 0) - height2) + i, 0, iM4828getMaxHeightimpl - iCoerceIn);
        if (getHorizontal(alignmentLine)) {
            iMax = placeableMo3866measureBRTryo0.getWidth();
        } else {
            iMax = Math.max(placeableMo3866measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m4831getMinWidthimpl(j));
        }
        final int i2 = iMax;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(placeableMo3866measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m4830getMinHeightimpl(j));
        } else {
            height = placeableMo3866measureBRTryo0.getHeight();
        }
        final int i3 = height;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                int width;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                int height3 = 0;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    width = 0;
                } else {
                    width = !Dp.m4878equalsimpl0(f, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i2 - iCoerceIn2) - placeableMo3866measureBRTryo0.getWidth();
                }
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    height3 = !Dp.m4878equalsimpl0(f, Dp.INSTANCE.m4893getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i3 - iCoerceIn2) - placeableMo3866measureBRTryo0.getHeight();
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3866measureBRTryo0, width, height3, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }
}
