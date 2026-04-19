package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
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
        Placeable placeable;
        final Placeable placeableMo3866measureBRTryo0;
        Object next4;
        Object next5;
        Object obj;
        Object next6;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int i = measure.mo319roundToPx0680j_4(this.paddingValues.getTop());
        int i2 = measure.mo319roundToPx0680j_4(this.paddingValues.getBottom());
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
        if (measurable3 != null) {
            placeable = placeableMo3866measureBRTryo03;
            placeableMo3866measureBRTryo0 = measurable3.mo3866measureBRTryo0(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, -iWidthOrZero2, 0, 2, null));
        } else {
            placeable = placeableMo3866measureBRTryo03;
            placeableMo3866measureBRTryo0 = null;
        }
        int iWidthOrZero3 = iWidthOrZero2 + TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo0);
        int iMax3 = Math.max(iMax2, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo0));
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
        final Placeable placeableMo3866measureBRTryo04 = measurable4 != null ? measurable4.mo3866measureBRTryo0(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, -iWidthOrZero3, 0, 2, null)) : null;
        int iWidthOrZero4 = iWidthOrZero3 + TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo04);
        int iMax4 = Math.max(iMax3, TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo04));
        int i3 = -iWidthOrZero4;
        long jM4845offsetNN6EwU = ConstraintsKt.m4845offsetNN6EwU(jM4820copyZbe2FdA$default, i3, -i2);
        Iterator it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it5.next();
            Iterator it6 = it5;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next5), TextFieldImplKt.LabelId)) {
                break;
            }
            it5 = it6;
        }
        Measurable measurable5 = (Measurable) next5;
        Placeable placeableMo3866measureBRTryo05 = measurable5 != null ? measurable5.mo3866measureBRTryo0(jM4845offsetNN6EwU) : null;
        int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo05) + i;
        long jM4845offsetNN6EwU2 = ConstraintsKt.m4845offsetNN6EwU(Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i3, (-iHeightOrZero) - i2);
        Iterator it7 = list.iterator();
        while (true) {
            final int i4 = i;
            if (it7.hasNext()) {
                Measurable measurable6 = (Measurable) it7.next();
                Iterator it8 = it7;
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.TextFieldId)) {
                    final Placeable placeableMo3866measureBRTryo06 = measurable6.mo3866measureBRTryo0(jM4845offsetNN6EwU2);
                    long jM4820copyZbe2FdA$default2 = Constraints.m4820copyZbe2FdA$default(jM4845offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                    Iterator it9 = list.iterator();
                    while (true) {
                        if (!it9.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next7 = it9.next();
                        Iterator it10 = it9;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next7), TextFieldImplKt.PlaceholderId)) {
                            obj = next7;
                            break;
                        }
                        it9 = it10;
                    }
                    Measurable measurable7 = (Measurable) obj;
                    Placeable placeableMo3866measureBRTryo07 = measurable7 != null ? measurable7.mo3866measureBRTryo0(jM4820copyZbe2FdA$default2) : null;
                    long jM4820copyZbe2FdA$default3 = Constraints.m4820copyZbe2FdA$default(ConstraintsKt.m4846offsetNN6EwU$default(jM4820copyZbe2FdA$default, 0, -Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo06), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo07)) + iHeightOrZero + i2), 1, null), 0, 0, 0, 0, 11, null);
                    Iterator<T> it11 = list.iterator();
                    while (true) {
                        if (!it11.hasNext()) {
                            next6 = null;
                            break;
                        }
                        next6 = it11.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next6), TextFieldImplKt.SupportingId)) {
                            break;
                        }
                    }
                    Measurable measurable8 = (Measurable) next6;
                    final Placeable placeableMo3866measureBRTryo08 = measurable8 != null ? measurable8.mo3866measureBRTryo0(jM4820copyZbe2FdA$default3) : null;
                    int iHeightOrZero2 = TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo08);
                    final int iM1549calculateWidthyeHjK3Y = TextFieldKt.m1549calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo02), TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo04), placeableMo3866measureBRTryo06.getWidth(), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo05), TextFieldImplKt.widthOrZero(placeableMo3866measureBRTryo07), j);
                    final int iM1548calculateHeightmKXJcVc = TextFieldKt.m1548calculateHeightmKXJcVc(placeableMo3866measureBRTryo06.getHeight(), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo05), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo02), TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo04), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo07), TextFieldImplKt.heightOrZero(placeableMo3866measureBRTryo08), this.animationProgress == 1.0f, j, measure.getDensity(), this.paddingValues);
                    int i5 = iM1548calculateHeightmKXJcVc - iHeightOrZero2;
                    for (Measurable measurable9 : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), TextFieldImplKt.ContainerId)) {
                            final Placeable placeableMo3866measureBRTryo09 = measurable9.mo3866measureBRTryo0(ConstraintsKt.Constraints(iM1549calculateWidthyeHjK3Y != Integer.MAX_VALUE ? iM1549calculateWidthyeHjK3Y : 0, iM1549calculateWidthyeHjK3Y, i5 != Integer.MAX_VALUE ? i5 : 0, i5));
                            final Placeable placeable2 = placeableMo3866measureBRTryo05;
                            final Placeable placeable3 = placeableMo3866measureBRTryo07;
                            final Placeable placeable4 = placeableMo3866measureBRTryo02;
                            final Placeable placeable5 = placeable;
                            return MeasureScope.layout$default(measure, iM1549calculateWidthyeHjK3Y, iM1548calculateHeightmKXJcVc, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                    Placeable placeable6 = placeable2;
                                    if (placeable6 == null) {
                                        TextFieldKt.placeWithoutLabel(layout, iM1549calculateWidthyeHjK3Y, iM1548calculateHeightmKXJcVc, placeableMo3866measureBRTryo06, placeable3, placeable4, placeable5, placeableMo3866measureBRTryo0, placeableMo3866measureBRTryo04, placeableMo3866measureBRTryo09, placeableMo3866measureBRTryo08, this.singleLine, measure.getDensity(), this.paddingValues);
                                        return;
                                    }
                                    int i6 = iM1549calculateWidthyeHjK3Y;
                                    int i7 = iM1548calculateHeightmKXJcVc;
                                    Placeable placeable7 = placeableMo3866measureBRTryo06;
                                    Placeable placeable8 = placeable3;
                                    Placeable placeable9 = placeable4;
                                    Placeable placeable10 = placeable5;
                                    Placeable placeable11 = placeableMo3866measureBRTryo0;
                                    Placeable placeable12 = placeableMo3866measureBRTryo04;
                                    Placeable placeable13 = placeableMo3866measureBRTryo09;
                                    Placeable placeable14 = placeableMo3866measureBRTryo08;
                                    boolean z = this.singleLine;
                                    int i8 = i4;
                                    TextFieldKt.placeWithLabel(layout, i6, i7, placeable7, placeable6, placeable8, placeable9, placeable10, placeable11, placeable12, placeable13, placeable14, z, i8, i8 + placeable2.getHeight(), this.animationProgress, measure.getDensity());
                                }
                            }, 4, null);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                it7 = it8;
                i = i4;
            } else {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicHeight.1
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
        return intrinsicHeight(intrinsicMeasureScope, measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicHeight.1
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
        return intrinsicWidth(measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicWidth.1
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
        return intrinsicWidth(measurables, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicWidth.1
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
    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        List<? extends IntrinsicMeasurable> list = measurables;
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.TextFieldId)) {
                int iIntValue = intrinsicMeasurer.invoke(obj2, Integer.valueOf(height)).intValue();
                Iterator<T> it = list.iterator();
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
                int iIntValue2 = intrinsicMeasurable != null ? intrinsicMeasurer.invoke(intrinsicMeasurable, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it2 = list.iterator();
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
                int iIntValue3 = intrinsicMeasurable2 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable2, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable3, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable4, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) next5;
                int iIntValue6 = intrinsicMeasurable5 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable5, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it6 = list.iterator();
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
                return TextFieldKt.m1549calculateWidthyeHjK3Y(iIntValue6, iIntValue3, iIntValue4, iIntValue5, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable6, Integer.valueOf(height)).intValue() : 0, TextFieldImplKt.getZeroConstraints());
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
                return TextFieldKt.m1548calculateHeightmKXJcVc(iIntValue, iIntValue2, iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue7, intrinsicMeasurable7 != null ? function2.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue() : 0, this.animationProgress == 1.0f, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
