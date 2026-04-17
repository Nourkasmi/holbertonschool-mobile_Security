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
    public static /* synthetic */ Modifier m363paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM();
        }
        return m362paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m362paddingFrom4j6BHR0(Modifier paddingFrom, final AlignmentLine alignmentLine, final float before, final float after) {
        Intrinsics.checkNotNullParameter(paddingFrom, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetDpElement(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
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
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("paddingFrom");
                $this$null.getProperties().set("alignmentLine", alignmentLine);
                $this$null.getProperties().set("before", Dp.m5210boximpl(before));
                $this$null.getProperties().set("after", Dp.m5210boximpl(after));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m365paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        long jM5404getUnspecifiedXSAIIZE;
        long jM5404getUnspecifiedXSAIIZE2;
        if ((i & 2) == 0) {
            jM5404getUnspecifiedXSAIIZE = j;
        } else {
            jM5404getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m5404getUnspecifiedXSAIIZE();
        }
        if ((i & 4) == 0) {
            jM5404getUnspecifiedXSAIIZE2 = j2;
        } else {
            jM5404getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m5404getUnspecifiedXSAIIZE();
        }
        return m364paddingFromY_r0B1c(modifier, alignmentLine, jM5404getUnspecifiedXSAIIZE, jM5404getUnspecifiedXSAIIZE2);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m364paddingFromY_r0B1c(Modifier paddingFrom, final AlignmentLine alignmentLine, final long before, final long after) {
        Intrinsics.checkNotNullParameter(paddingFrom, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetTextUnitElement(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
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
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("paddingFrom");
                $this$null.getProperties().set("alignmentLine", alignmentLine);
                $this$null.getProperties().set("before", TextUnit.m5383boximpl(before));
                $this$null.getProperties().set("after", TextUnit.m5383boximpl(after));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m366paddingFromBaselineVpY3zN4(Modifier paddingFromBaseline, float top, float bottom) {
        Modifier.Companion companionM363paddingFrom4j6BHR0$default;
        Modifier.Companion companionM363paddingFrom4j6BHR0$default2;
        Intrinsics.checkNotNullParameter(paddingFromBaseline, "$this$paddingFromBaseline");
        if (!Dp.m5217equalsimpl0(top, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM())) {
            companionM363paddingFrom4j6BHR0$default = m363paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0.0f, 4, null);
        } else {
            companionM363paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = paddingFromBaseline.then(companionM363paddingFrom4j6BHR0$default);
        if (!Dp.m5217equalsimpl0(bottom, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM())) {
            companionM363paddingFrom4j6BHR0$default2 = m363paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, bottom, 2, null);
        } else {
            companionM363paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM363paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m367paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM();
        }
        return m366paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m369paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m5404getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m5404getUnspecifiedXSAIIZE();
        }
        return m368paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m368paddingFromBaselinewCyjxdI(Modifier paddingFromBaseline, long top, long bottom) {
        Intrinsics.checkNotNullParameter(paddingFromBaseline, "$this$paddingFromBaseline");
        return paddingFromBaseline.then(!TextUnitKt.m5411isUnspecifiedR2X_6o(top) ? m365paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0L, 4, null) : Modifier.INSTANCE).then(!TextUnitKt.m5411isUnspecifiedR2X_6o(bottom) ? m365paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, bottom, 2, null) : Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m361alignmentLineOffsetMeasuretjqqzMA(MeasureScope $this$alignmentLineOffsetMeasure_u2dtjqqzMA, final AlignmentLine alignmentLine, final float before, float after, Measurable measurable, long constraints) {
        final int width;
        final int height;
        final Placeable placeable = measurable.mo4183measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0) : Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0));
        int it = placeable.get(alignmentLine);
        if (it == Integer.MIN_VALUE) {
            it = 0;
        }
        int linePosition = it;
        int axis = getHorizontal(alignmentLine) ? placeable.getHeight() : placeable.getWidth();
        int axisMax = getHorizontal(alignmentLine) ? Constraints.m5167getMaxHeightimpl(constraints) : Constraints.m5168getMaxWidthimpl(constraints);
        final int paddingBefore = RangesKt.coerceIn((!Dp.m5217equalsimpl0(before, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM()) ? $this$alignmentLineOffsetMeasure_u2dtjqqzMA.mo320roundToPx0680j_4(before) : 0) - linePosition, 0, axisMax - axis);
        final int paddingAfter = RangesKt.coerceIn(((!Dp.m5217equalsimpl0(after, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM()) ? $this$alignmentLineOffsetMeasure_u2dtjqqzMA.mo320roundToPx0680j_4(after) : 0) - axis) + linePosition, 0, (axisMax - axis) - paddingBefore);
        if (!getHorizontal(alignmentLine)) {
            width = Math.max(paddingBefore + placeable.getWidth() + paddingAfter, Constraints.m5170getMinWidthimpl(constraints));
        } else {
            width = placeable.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            height = Math.max(paddingBefore + placeable.getHeight() + paddingAfter, Constraints.m5169getMinHeightimpl(constraints));
        } else {
            height = placeable.getHeight();
        }
        return MeasureScope.layout$default($this$alignmentLineOffsetMeasure_u2dtjqqzMA, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
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
                int x;
                int y;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    x = 0;
                } else {
                    x = !Dp.m5217equalsimpl0(before, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM()) ? paddingBefore : (width - paddingAfter) - placeable.getWidth();
                }
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    y = !Dp.m5217equalsimpl0(before, Dp.INSTANCE.m5232getUnspecifiedD9Ej5fM()) ? paddingBefore : (height - paddingAfter) - placeable.getHeight();
                } else {
                    y = 0;
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable, x, y, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine $this$horizontal) {
        return $this$horizontal instanceof HorizontalAlignmentLine;
    }
}
