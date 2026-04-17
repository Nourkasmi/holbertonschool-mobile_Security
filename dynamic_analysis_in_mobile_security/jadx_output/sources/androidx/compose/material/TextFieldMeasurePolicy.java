package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean singleLine, float animationProgress, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = singleLine;
        this.animationProgress = animationProgress;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo12measure3p2s80s(final MeasureScope measure, List<? extends Measurable> list, long constraints) {
        Object next;
        Object next2;
        Object next3;
        int it;
        long textFieldConstraints;
        Object next4;
        Iterable measurables = list;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final int topPaddingValue = measure.mo320roundToPx0680j_4(this.paddingValues.getTop());
        int bottomPaddingValue = measure.mo320roundToPx0680j_4(this.paddingValues.getBottom());
        final int topPadding = measure.mo320roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long looseConstraints = Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0);
        Iterator<T> it2 = measurables.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            Measurable it3 = (Measurable) next;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) next;
        final Placeable leadingPlaceable = measurable != null ? measurable.mo4183measureBRTryo0(looseConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        Iterator<T> it4 = measurables.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it4.next();
            Measurable it5 = (Measurable) next2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it5), "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) next2;
        final Placeable trailingPlaceable = measurable2 != null ? measurable2.mo4183measureBRTryo0(ConstraintsKt.m5185offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally, 0, 2, null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        long labelConstraints = ConstraintsKt.m5184offsetNN6EwU(looseConstraints, -occupiedSpaceHorizontally2, -bottomPaddingValue);
        Iterator it6 = measurables.iterator();
        while (true) {
            if (!it6.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it6.next();
            Measurable it7 = (Measurable) next3;
            Iterator it8 = it6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it7), "Label")) {
                break;
            }
            it6 = it8;
        }
        Measurable measurable3 = (Measurable) next3;
        final Placeable labelPlaceable = measurable3 != null ? measurable3.mo4183measureBRTryo0(labelConstraints) : null;
        if (labelPlaceable != null) {
            it = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
            if (it == Integer.MIN_VALUE) {
                it = labelPlaceable.getHeight();
            }
        } else {
            it = 0;
        }
        int lastBaseline = it;
        final int effectiveLabelBaseline = Math.max(lastBaseline, topPaddingValue);
        int verticalConstraintOffset = labelPlaceable != null ? ((-bottomPaddingValue) - topPadding) - effectiveLabelBaseline : (-topPaddingValue) - bottomPaddingValue;
        int lastBaseline2 = lastBaseline;
        long textFieldConstraints2 = ConstraintsKt.m5184offsetNN6EwU(Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0), -occupiedSpaceHorizontally2, verticalConstraintOffset);
        Iterable $this$first$iv = measurables;
        for (Object element$iv : $this$first$iv) {
            Measurable it9 = (Measurable) element$iv;
            final int lastBaseline3 = lastBaseline2;
            long looseConstraints2 = looseConstraints;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it9), "TextField")) {
                final Placeable textFieldPlaceable = ((Measurable) element$iv).mo4183measureBRTryo0(textFieldConstraints2);
                long placeholderConstraints = Constraints.m5158copyZbe2FdA(textFieldConstraints2, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(textFieldConstraints2) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(textFieldConstraints2) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(textFieldConstraints2) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(textFieldConstraints2) : 0);
                Iterator<T> it10 = measurables.iterator();
                while (true) {
                    if (!it10.hasNext()) {
                        textFieldConstraints = textFieldConstraints2;
                        next4 = null;
                        break;
                    }
                    next4 = it10.next();
                    Measurable it11 = (Measurable) next4;
                    textFieldConstraints = textFieldConstraints2;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it11), "Hint")) {
                        break;
                    }
                    textFieldConstraints2 = textFieldConstraints;
                }
                Measurable measurable4 = (Measurable) next4;
                final Placeable placeholderPlaceable = measurable4 != null ? measurable4.mo4183measureBRTryo0(placeholderConstraints) : null;
                final int width = TextFieldKt.m1253calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), constraints);
                final int height = TextFieldKt.m1252calculateHeightO3s9Psw(textFieldPlaceable.getHeight(), labelPlaceable != null, effectiveLabelBaseline, TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), constraints, measure.getDensity(), this.paddingValues);
                return MeasureScope.layout$default(measure, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$measure$1
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
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        if (labelPlaceable == null) {
                            TextFieldKt.placeWithoutLabel(layout, width, height, textFieldPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, this.singleLine, measure.getDensity(), this.paddingValues);
                        } else {
                            int labelEndPosition = RangesKt.coerceAtLeast(topPaddingValue - lastBaseline3, 0);
                            TextFieldKt.placeWithLabel(layout, width, height, textFieldPlaceable, labelPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, this.singleLine, labelEndPosition, effectiveLabelBaseline + topPadding, this.animationProgress, measure.getDensity());
                        }
                    }
                }, 4, null);
            }
            measurables = list;
            lastBaseline2 = lastBaseline3;
            looseConstraints = looseConstraints2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy.maxIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(w));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy.minIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(w));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy.maxIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(h));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy.minIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(h));
            }
        });
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> $this$first$iv = measurables;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) element$iv), "TextField")) {
                int textFieldWidth = intrinsicMeasurer.invoke(element$iv, Integer.valueOf(height)).intValue();
                Iterator<T> it = measurables.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable it2 = (IntrinsicMeasurable) next;
                int labelWidth = it2 != null ? intrinsicMeasurer.invoke(it2, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it3 = measurables.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable it4 = (IntrinsicMeasurable) next2;
                int trailingWidth = it4 != null ? intrinsicMeasurer.invoke(it4, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it5 = measurables.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable it6 = (IntrinsicMeasurable) next3;
                int leadingWidth = it6 != null ? intrinsicMeasurer.invoke(it6, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it7 = measurables.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    Object next4 = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), "Hint")) {
                        obj = next4;
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj;
                int placeholderWidth = it8 != null ? intrinsicMeasurer.invoke(it8, Integer.valueOf(height)).intValue() : 0;
                return TextFieldKt.m1253calculateWidthVsPV1Ek(leadingWidth, trailingWidth, textFieldWidth, labelWidth, placeholderWidth, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> list, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> $this$first$iv = list;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) element$iv), "TextField")) {
                int textFieldHeight = function2.invoke(element$iv, Integer.valueOf(width)).intValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable it2 = (IntrinsicMeasurable) next;
                int labelHeight = it2 != null ? function2.invoke(it2, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable it4 = (IntrinsicMeasurable) next2;
                int trailingHeight = it4 != null ? function2.invoke(it4, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable it6 = (IntrinsicMeasurable) next3;
                int leadingHeight = it6 != null ? function2.invoke(it6, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it7 = list.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    Object next4 = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), "Hint")) {
                        obj = next4;
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj;
                int placeholderHeight = it8 != null ? function2.invoke(it8, Integer.valueOf(width)).intValue() : 0;
                return TextFieldKt.m1252calculateHeightO3s9Psw(textFieldHeight, labelHeight > 0, labelHeight, leadingHeight, trailingHeight, placeholderHeight, TextFieldImplKt.getZeroConstraints(), $this$intrinsicHeight.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
