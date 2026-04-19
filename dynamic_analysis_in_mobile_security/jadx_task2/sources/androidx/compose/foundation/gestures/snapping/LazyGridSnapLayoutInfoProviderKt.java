package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyGridSnapLayoutInfoProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "positionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "offsetOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "sizeOnMainAxis", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState lazyGridState, SnapPositionInLayout snapPositionInLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPositionInLayout = SnapPositionInLayout.INSTANCE.getCenterToCenter();
        }
        return SnapLayoutInfoProvider(lazyGridState, snapPositionInLayout);
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyGridState lazyGridState, final SnapPositionInLayout positionInLayout) {
        Intrinsics.checkNotNullParameter(lazyGridState, "lazyGridState");
        Intrinsics.checkNotNullParameter(positionInLayout, "positionInLayout");
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            private final LazyGridLayoutInfo getLayoutInfo() {
                return lazyGridState.getLayoutInfo();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(Density density, float f) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                float fCoerceAtLeast = RangesKt.coerceAtLeast(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay(density), 0.0f, f)) - calculateSnapStepSize(density), 0.0f);
                return fCoerceAtLeast == 0.0f ? fCoerceAtLeast : fCoerceAtLeast * Math.signum(f);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private final java.util.List<androidx.compose.foundation.lazy.grid.LazyGridItemInfo> getSingleAxisItems() {
                /*
                    r9 = this;
                    androidx.compose.foundation.lazy.grid.LazyGridState r0 = r1
                    androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r0 = r0.getLayoutInfo()
                    java.util.List r0 = r0.getVisibleItemsInfo()
                    androidx.compose.foundation.lazy.grid.LazyGridState r1 = r1
                    java.util.ArrayList r2 = new java.util.ArrayList
                    int r3 = r0.size()
                    r2.<init>(r3)
                    int r3 = r0.size()
                    r4 = 0
                L1a:
                    if (r4 >= r3) goto L45
                    java.lang.Object r5 = r0.get(r4)
                    r6 = r5
                    androidx.compose.foundation.lazy.grid.LazyGridItemInfo r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r6
                    androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r7 = r1.getLayoutInfo()
                    androidx.compose.foundation.gestures.Orientation r7 = r7.getOrientation()
                    androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.Orientation.Horizontal
                    if (r7 != r8) goto L36
                    int r6 = r6.getRow()
                    if (r6 != 0) goto L42
                    goto L3c
                L36:
                    int r6 = r6.getColumn()
                    if (r6 != 0) goto L42
                L3c:
                    r6 = r2
                    java.util.Collection r6 = (java.util.Collection) r6
                    r6.add(r5)
                L42:
                    int r4 = r4 + 1
                    goto L1a
                L45:
                    java.util.List r2 = (java.util.List) r2
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.AnonymousClass1.getSingleAxisItems():java.util.List");
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(Density density, float f) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                List<LazyGridItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
                SnapPositionInLayout snapPositionInLayout = positionInLayout;
                int size = visibleItemsInfo.size();
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(density, LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), lazyGridItemInfo.getIndex(), snapPositionInLayout);
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f2) {
                        f2 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                }
                return SnapFlingBehaviorKt.calculateFinalOffset(f, f2, f3);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(Density density) {
                int iM5033getWidthimpl;
                Intrinsics.checkNotNullParameter(density, "<this>");
                if (!(!getSingleAxisItems().isEmpty())) {
                    return 0.0f;
                }
                int i = 0;
                if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
                    List<LazyGridItemInfo> singleAxisItems = getSingleAxisItems();
                    int size = singleAxisItems.size();
                    iM5033getWidthimpl = 0;
                    while (i < size) {
                        iM5033getWidthimpl += IntSize.m5032getHeightimpl(singleAxisItems.get(i).getSize());
                        i++;
                    }
                } else {
                    List<LazyGridItemInfo> singleAxisItems2 = getSingleAxisItems();
                    int size2 = singleAxisItems2.size();
                    iM5033getWidthimpl = 0;
                    while (i < size2) {
                        iM5033getWidthimpl += IntSize.m5033getWidthimpl(singleAxisItems2.get(i).getSize());
                        i++;
                    }
                }
                return iM5033getWidthimpl / getSingleAxisItems().size();
            }
        };
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        Intrinsics.checkNotNullParameter(lazyGridLayoutInfo, "<this>");
        if (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical) {
            return IntSize.m5032getHeightimpl(lazyGridLayoutInfo.mo594getViewportSizeYbymL2g());
        }
        return IntSize.m5033getWidthimpl(lazyGridLayoutInfo.mo594getViewportSizeYbymL2g());
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        Intrinsics.checkNotNullParameter(lazyGridItemInfo, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            return IntSize.m5032getHeightimpl(lazyGridItemInfo.getSize());
        }
        return IntSize.m5033getWidthimpl(lazyGridItemInfo.getSize());
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        Intrinsics.checkNotNullParameter(lazyGridItemInfo, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            return IntOffset.m4992getYimpl(lazyGridItemInfo.getOffset());
        }
        return IntOffset.m4991getXimpl(lazyGridItemInfo.getOffset());
    }
}
