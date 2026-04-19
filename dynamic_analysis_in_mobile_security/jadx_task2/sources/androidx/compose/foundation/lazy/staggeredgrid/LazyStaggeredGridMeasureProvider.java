package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH&J#\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020!ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "(ZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "requestedSlot", "", "requestedSpan", "childConstraints-JhjzzOo", "(II)J", "createItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "lane", "span", "key", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyStaggeredGridMeasureProvider {
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridSlots resolvedSlots;

    public abstract LazyStaggeredGridMeasuredItem createItem(int index, int lane, int span, Object key, Object contentType, List<? extends Placeable> placeables);

    public LazyStaggeredGridMeasureProvider(boolean z, LazyStaggeredGridItemProvider itemProvider, LazyLayoutMeasureScope measureScope, LazyStaggeredGridSlots resolvedSlots) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(resolvedSlots, "resolvedSlots");
        this.isVertical = z;
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.resolvedSlots = resolvedSlots;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo, reason: not valid java name */
    private final long m667childConstraintsJhjzzOo(int requestedSlot, int requestedSpan) {
        int i;
        int length = this.resolvedSlots.getSizes().length;
        int iCoerceAtMost = RangesKt.coerceAtMost(requestedSlot, length - 1);
        int iCoerceAtMost2 = RangesKt.coerceAtMost(requestedSpan, length - iCoerceAtMost);
        if (iCoerceAtMost2 == 1) {
            i = this.resolvedSlots.getSizes()[iCoerceAtMost];
        } else {
            int i2 = this.resolvedSlots.getPositions()[iCoerceAtMost];
            int i3 = (iCoerceAtMost + iCoerceAtMost2) - 1;
            i = (this.resolvedSlots.getPositions()[i3] + this.resolvedSlots.getSizes()[i3]) - i2;
        }
        if (this.isVertical) {
            return Constraints.INSTANCE.m4839fixedWidthOenEA2s(i);
        }
        return Constraints.INSTANCE.m4838fixedHeightOenEA2s(i);
    }

    /* JADX INFO: renamed from: getAndMeasure-jy6DScQ, reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m668getAndMeasurejy6DScQ(int index, long span) {
        int i = (int) (span >> 32);
        int i2 = ((int) (span & 4294967295L)) - i;
        return createItem(index, i, i2, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), this.measureScope.mo638measure0kLqBqw(index, m667childConstraintsJhjzzOo(i, i2)));
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
