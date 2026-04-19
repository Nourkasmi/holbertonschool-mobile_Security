package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RowColumnMeasurementHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Br\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0017J2\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0006H\u0002J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0002J3\u00106\u001a\u0002072\u0006\u00104\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J&\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\bJ\n\u0010\r\u001a\u00020\u0006*\u00020\u0016J\n\u0010C\u001a\u00020\u0006*\u00020\u0016R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "arrangement", "Lkotlin/Function5;", "", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangement", "()Lkotlin/jvm/functions/Function5;", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisPosition", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RowColumnMeasurementHelper {
    private final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getArrangement() {
        return this.arrangement;
    }

    /* JADX INFO: renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name and from getter */
    public final float getArrangementSpacing() {
        return this.arrangementSpacing;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation orientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, float f, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> measurables, Placeable[] placeables) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.orientation = orientation;
        this.arrangement = arrangement;
        this.arrangementSpacing = f;
        this.crossAxisSize = crossAxisSize;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = measurables;
        this.placeables = placeables;
        int size = measurables.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final int mainAxisSize(Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public final int crossAxisSize(Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m507measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        int i;
        int iM4831getMinWidthimpl;
        int iMax;
        int iCoerceAtMost;
        int i2;
        int i3;
        int i4;
        int i5;
        int iMax2;
        int i6;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        long jM449constructorimpl = OrientationIndependentConstraints.m449constructorimpl(constraints, this.orientation);
        int i10 = measureScope.mo319roundToPx0680j_4(this.arrangementSpacing);
        int i11 = endIndex - startIndex;
        float f = 0.0f;
        int i12 = 0;
        int i13 = startIndex;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int iMainAxisSize = 0;
        int i17 = 0;
        float f2 = 0.0f;
        while (true) {
            i = Integer.MAX_VALUE;
            if (i13 >= endIndex) {
                break;
            }
            Measurable measurable = this.measurables.get(i13);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i13];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > f) {
                f2 += weight;
                i16++;
                i8 = i13;
                i9 = i12;
            } else {
                int iM4829getMaxWidthimpl = Constraints.m4829getMaxWidthimpl(jM449constructorimpl);
                Placeable placeableMo3866measureBRTryo0 = this.placeables[i13];
                if (placeableMo3866measureBRTryo0 == null) {
                    i6 = iM4829getMaxWidthimpl;
                    i7 = i15;
                    i8 = i13;
                    i9 = i12;
                    placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(OrientationIndependentConstraints.m462toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m451copyyUG9Ft0$default(jM449constructorimpl, 0, iM4829getMaxWidthimpl == Integer.MAX_VALUE ? Integer.MAX_VALUE : iM4829getMaxWidthimpl - iMainAxisSize, 0, 0, 8, null), this.orientation));
                } else {
                    i6 = iM4829getMaxWidthimpl;
                    i7 = i15;
                    i8 = i13;
                    i9 = i12;
                }
                int iMin = Math.min(i10, (i6 - iMainAxisSize) - mainAxisSize(placeableMo3866measureBRTryo0));
                iMainAxisSize += mainAxisSize(placeableMo3866measureBRTryo0) + iMin;
                int iMax3 = Math.max(i7, crossAxisSize(placeableMo3866measureBRTryo0));
                int i18 = (i17 != 0 || RowColumnImplKt.isRelative(rowColumnParentData)) ? 1 : i9;
                this.placeables[i8] = placeableMo3866measureBRTryo0;
                i14 = iMin;
                i15 = iMax3;
                i17 = i18;
            }
            i13 = i8 + 1;
            i12 = i9;
            f = 0.0f;
        }
        int i19 = i12;
        int i20 = i15;
        if (i16 == 0) {
            iMainAxisSize -= i14;
            iMax = i20;
            iCoerceAtMost = i19;
        } else {
            if (f2 > 0.0f && Constraints.m4829getMaxWidthimpl(jM449constructorimpl) != Integer.MAX_VALUE) {
                iM4831getMinWidthimpl = Constraints.m4829getMaxWidthimpl(jM449constructorimpl);
            } else {
                iM4831getMinWidthimpl = Constraints.m4831getMinWidthimpl(jM449constructorimpl);
            }
            int i21 = i10 * (i16 - 1);
            int i22 = (iM4831getMinWidthimpl - iMainAxisSize) - i21;
            float f3 = f2 > 0.0f ? i22 / f2 : 0.0f;
            Iterator<Integer> it = RangesKt.until(startIndex, endIndex).iterator();
            int iRoundToInt = i19;
            while (it.hasNext()) {
                iRoundToInt += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * f3);
            }
            int i23 = i22 - iRoundToInt;
            int i24 = startIndex;
            iMax = i20;
            int iMainAxisSize2 = i19;
            while (i24 < endIndex) {
                if (this.placeables[i24] == null) {
                    Measurable measurable2 = this.measurables.get(i24);
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i24];
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (weight2 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int sign = MathKt.getSign(i23);
                    int i25 = i23 - sign;
                    int iMax4 = Math.max(i19, MathKt.roundToInt(weight2 * f3) + sign);
                    if (!RowColumnImplKt.getFill(rowColumnParentData2) || iMax4 == i) {
                        i2 = i19;
                        i3 = i25;
                    } else {
                        i3 = i25;
                        i2 = iMax4;
                    }
                    Placeable placeableMo3866measureBRTryo02 = measurable2.mo3866measureBRTryo0(OrientationIndependentConstraints.m462toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m447constructorimpl(i2, iMax4, i19, Constraints.m4828getMaxHeightimpl(jM449constructorimpl)), this.orientation));
                    iMainAxisSize2 += mainAxisSize(placeableMo3866measureBRTryo02);
                    iMax = Math.max(iMax, crossAxisSize(placeableMo3866measureBRTryo02));
                    int i26 = (i17 != 0 || RowColumnImplKt.isRelative(rowColumnParentData2)) ? 1 : i19;
                    this.placeables[i24] = placeableMo3866measureBRTryo02;
                    i23 = i3;
                    i17 = i26;
                }
                i24++;
                i = Integer.MAX_VALUE;
            }
            iCoerceAtMost = RangesKt.coerceAtMost(iMainAxisSize2 + i21, Constraints.m4829getMaxWidthimpl(jM449constructorimpl) - iMainAxisSize);
        }
        if (i17 != 0) {
            int iMax5 = i19;
            int iMax6 = iMax5;
            for (int i27 = startIndex; i27 < endIndex; i27++) {
                Placeable placeable = this.placeables[i27];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i27]);
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    Integer num = numCalculateAlignmentLinePosition$foundation_layout_release;
                    int iIntValue = num.intValue();
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = i19;
                    }
                    iMax5 = Math.max(iMax5, iIntValue);
                    int iCrossAxisSize = crossAxisSize(placeable);
                    int iIntValue2 = num.intValue();
                    if (iIntValue2 == Integer.MIN_VALUE) {
                        iIntValue2 = crossAxisSize(placeable);
                    }
                    iMax6 = Math.max(iMax6, iCrossAxisSize - iIntValue2);
                }
            }
            int i28 = iMax6;
            i5 = iMax5;
            i4 = i28;
        } else {
            i4 = i19;
            i5 = i4;
        }
        int iMax7 = Math.max(iMainAxisSize + iCoerceAtMost, Constraints.m4831getMinWidthimpl(jM449constructorimpl));
        if (Constraints.m4828getMaxHeightimpl(jM449constructorimpl) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) {
            iMax2 = Math.max(iMax, Math.max(Constraints.m4830getMinHeightimpl(jM449constructorimpl), i4 + i5));
        } else {
            iMax2 = Constraints.m4828getMaxHeightimpl(jM449constructorimpl);
        }
        int[] iArr = new int[i11];
        for (int i29 = i19; i29 < i11; i29++) {
            iArr[i29] = i19;
        }
        int[] iArr2 = new int[i11];
        for (int i30 = i19; i30 < i11; i30++) {
            Placeable placeable2 = this.placeables[i30 + startIndex];
            Intrinsics.checkNotNull(placeable2);
            iArr2[i30] = mainAxisSize(placeable2);
        }
        return new RowColumnMeasureHelperResult(iMax2, iMax7, startIndex, endIndex, i5, mainAxisPositions(iMax7, iArr2, iArr, measureScope));
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(mainAxisLayoutSize), childrenMainAxisSize, measureScope.getLayoutDirection(), measureScope, mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment crossAxisAlignment;
        if (parentData == null || (crossAxisAlignment = parentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int iCrossAxisSize = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(iCrossAxisSize, layoutDirection, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(placeableScope, "placeableScope");
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int endIndex = measureResult.getEndIndex();
        for (int startIndex = measureResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placeableScope, placeable, mainAxisPositions[startIndex - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placeableScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - measureResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }
}
