package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J/\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> onLabelMeasured, boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.onLabelMeasured = onLabelMeasured;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Placeable placeable;
        Placeable placeableMo3866measureBRTryo0;
        Placeable placeable2;
        Object next5;
        Object obj;
        Object next6;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int i = measure.mo319roundToPx0680j_4(this.paddingValues.getBottom());
        long jM4820copyZbe2FdA$default = Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list = measurables;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), TextFieldImplKt.LeadingId)) {
                break;
            }
        }
        Measurable measurable = (Measurable) next;
        Placeable placeableMo3866measureBRTryo02 = measurable != null ? measurable.mo3866measureBRTryo0(jM4820copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo02);
        int iMax = Math.max(0, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo02));
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next2), TextFieldImplKt.TrailingId)) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) next2;
        Placeable placeableMo3866measureBRTryo03 = measurable2 != null ? measurable2.mo3866measureBRTryo0(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int iWidthOrZero2 = iWidthOrZero + TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo03);
        int iMax2 = Math.max(iMax, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo03));
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next3), TextFieldImplKt.PrefixId)) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) next3;
        Placeable placeableMo3866measureBRTryo04 = measurable3 != null ? measurable3.mo3866measureBRTryo0(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, -iWidthOrZero2, 0, 2, null)) : null;
        int iWidthOrZero3 = iWidthOrZero2 + TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo04);
        int iMax3 = Math.max(iMax2, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo04));
        Iterator<T> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next4), TextFieldImplKt.SuffixId)) {
                break;
            }
        }
        Measurable measurable4 = (Measurable) next4;
        if (measurable4 != null) {
            placeable = placeableMo3866measureBRTryo03;
            placeableMo3866measureBRTryo0 = measurable4.mo3866measureBRTryo0(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, -iWidthOrZero3, 0, 2, null));
        } else {
            placeable = placeableMo3866measureBRTryo03;
            placeableMo3866measureBRTryo0 = null;
        }
        int iWidthOrZero4 = iWidthOrZero3 + TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo0);
        int iMax4 = Math.max(iMax3, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo0));
        boolean z = this.animationProgress < 1.0f;
        int i2 = measure.mo319roundToPx0680j_4(this.paddingValues.mo431calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo319roundToPx0680j_4(this.paddingValues.mo432calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int i3 = z ? (-iWidthOrZero4) - i2 : -i2;
        int i4 = -i;
        long jM4845offsetNN6EwU = ConstraintsKt.m4845offsetNN6EwU(jM4820copyZbe2FdA$default, i3, i4);
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                placeable2 = placeableMo3866measureBRTryo0;
                next5 = null;
                break;
            }
            next5 = it5.next();
            placeable2 = placeableMo3866measureBRTryo0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next5), TextFieldImplKt.LabelId)) {
                break;
            }
            placeableMo3866measureBRTryo0 = placeable2;
        }
        Measurable measurable5 = (Measurable) next5;
        final Placeable placeableMo3866measureBRTryo05 = measurable5 != null ? measurable5.mo3866measureBRTryo0(jM4845offsetNN6EwU) : null;
        if (placeableMo3866measureBRTryo05 != null) {
            this.onLabelMeasured.invoke(Size.m2447boximpl(SizeKt.Size(placeableMo3866measureBRTryo05.getWidth(), placeableMo3866measureBRTryo05.getHeight())));
        }
        int iMax5 = Math.max(TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo05) / 2, measure.mo319roundToPx0680j_4(this.paddingValues.getTop()));
        long jM4820copyZbe2FdA$default2 = Constraints.m4820copyZbe2FdA$default(ConstraintsKt.m4845offsetNN6EwU(j, -iWidthOrZero4, i4 - iMax5), 0, 0, 0, 0, 11, null);
        Iterator it6 = list.iterator();
        while (it6.hasNext()) {
            Measurable measurable6 = (Measurable) it6.next();
            Iterator it7 = it6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.TextFieldId)) {
                final Placeable placeableMo3866measureBRTryo06 = measurable6.mo3866measureBRTryo0(jM4820copyZbe2FdA$default2);
                long jM4820copyZbe2FdA$default3 = Constraints.m4820copyZbe2FdA$default(jM4820copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                Iterator it8 = list.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next7 = it8.next();
                    Iterator it9 = it8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next7), TextFieldImplKt.PlaceholderId)) {
                        obj = next7;
                        break;
                    }
                    it8 = it9;
                }
                Measurable measurable7 = (Measurable) obj;
                Placeable placeableMo3866measureBRTryo07 = measurable7 != null ? measurable7.mo3866measureBRTryo0(jM4820copyZbe2FdA$default3) : null;
                long jM4820copyZbe2FdA$default4 = Constraints.m4820copyZbe2FdA$default(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, 0, -Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo06), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo07)) + iMax5 + i), 1, null), 0, 0, 0, 0, 11, null);
                Iterator<T> it10 = list.iterator();
                while (true) {
                    if (!it10.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it10.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next6), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                }
                Measurable measurable8 = (Measurable) next6;
                Placeable placeableMo3866measureBRTryo08 = measurable8 != null ? measurable8.mo3866measureBRTryo0(jM4820copyZbe2FdA$default4) : null;
                int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo08);
                final int iM1326calculateWidthDHJA7U0 = OutlinedTextFieldKt.m1326calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo02), TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo04), TextFieldImplKt.widthOrZero(placeable2), placeableMo3866measureBRTryo06.getWidth(), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo05), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo07), z, j, measure.getDensity(), this.paddingValues);
                final int iM1325calculateHeightDHJA7U0 = OutlinedTextFieldKt.m1325calculateHeightDHJA7U0(TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo02), TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo04), TextFieldImplKt.heightOrZero(placeable2), placeableMo3866measureBRTryo06.getHeight(), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo05), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo07), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo08), j, measure.getDensity(), this.paddingValues);
                int i5 = iM1325calculateHeightDHJA7U0 - iHeightOrZero;
                for (Measurable measurable9 : list) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo3866measureBRTryo09 = measurable9.mo3866measureBRTryo0(ConstraintsKt.Constraints(iM1326calculateWidthDHJA7U0 != Integer.MAX_VALUE ? iM1326calculateWidthDHJA7U0 : 0, iM1326calculateWidthDHJA7U0, i5 != Integer.MAX_VALUE ? i5 : 0, i5));
                        final Placeable placeable3 = placeableMo3866measureBRTryo02;
                        final Placeable placeable4 = placeable;
                        final Placeable placeable5 = placeableMo3866measureBRTryo04;
                        final Placeable placeable6 = placeable2;
                        final Placeable placeable7 = placeableMo3866measureBRTryo07;
                        final Placeable placeable8 = placeableMo3866measureBRTryo08;
                        return MeasureScope.layout$default(measure, iM1326calculateWidthDHJA7U0, iM1325calculateHeightDHJA7U0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2
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
                                OutlinedTextFieldKt.place(layout, iM1325calculateHeightDHJA7U0, iM1326calculateWidthDHJA7U0, placeable3, placeable4, placeable5, placeable6, placeableMo3866measureBRTryo06, placeableMo3866measureBRTryo05, placeable7, placeableMo3866measureBRTryo09, placeable8, this.animationProgress, this.singleLine, measure.getDensity(), measure.getLayoutDirection(), this.paddingValues);
                            }
                        }, 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            it6 = it7;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i2));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.TextFieldId)) {
                int iIntValue = function2.invoke(obj2, Integer.valueOf(i)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? function2.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) next5;
                int iIntValue6 = intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it6 = list2.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next6 = it6.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next6), TextFieldImplKt.PlaceholderId)) {
                        obj = next6;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1326calculateWidthDHJA7U0(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? function2.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue() : 0, this.animationProgress < 1.0f, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.TextFieldId)) {
                int iIntValue = function2.invoke(obj2, Integer.valueOf(i)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? function2.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it5 = list2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) next5;
                int iIntValue6 = intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it6 = list2.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it6.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next6), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) next6;
                int iIntValue7 = intrinsicMeasurable6 != null ? function2.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue() : 0;
                Iterator<T> it7 = list2.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    Object next7 = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next7), TextFieldImplKt.SupportingId)) {
                        obj = next7;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1325calculateHeightDHJA7U0(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, iIntValue7, intrinsicMeasurable7 != null ? function2.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
