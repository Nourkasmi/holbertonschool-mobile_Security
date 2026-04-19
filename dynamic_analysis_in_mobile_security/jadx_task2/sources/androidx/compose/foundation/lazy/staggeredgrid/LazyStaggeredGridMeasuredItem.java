package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u001e\u0010>\u001a\u0002092\u0006\u00103\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\b\u0010@\u001a\u00020AH\u0016J.\u0010B\u001a\u00020&*\u00020&2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030DH\u0082\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001a\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u001f\u0010-\u001a\u00020.X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b/\u0010)R\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u001b\u00103\u001a\u00020\u0003*\u00020&8BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u00105R\u0019\u0010!\u001a\u00020\u0003*\u00020\b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "()I", "crossAxisSize", "getCrossAxisSize", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "maxMainAxisOffset", "minMainAxisOffset", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "sizeWithSpacings", "getSizeWithSpacings", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int sizeWithSpacings;
    private final int span;

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getSpan() {
        return this.span;
    }

    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridMeasuredItem(int i, Object key, List<? extends Placeable> placeables, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj) {
        Integer numValueOf;
        long jIntSize;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.index = i;
        this.key = key;
        this.placeables = placeables;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj;
        int i7 = 1;
        this.isVisible = true;
        Integer num = null;
        if (placeables.isEmpty()) {
            numValueOf = null;
        } else {
            Placeable placeable = (Placeable) placeables.get(0);
            numValueOf = Integer.valueOf(z ? placeable.getHeight() : placeable.getWidth());
            int lastIndex = CollectionsKt.getLastIndex(placeables);
            if (1 <= lastIndex) {
                int i8 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) placeables.get(i8);
                    Integer numValueOf2 = Integer.valueOf(this.isVertical ? placeable2.getHeight() : placeable2.getWidth());
                    numValueOf = numValueOf2.compareTo(numValueOf) > 0 ? numValueOf2 : numValueOf;
                    if (i8 == lastIndex) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        this.mainAxisSize = iIntValue;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(iIntValue + i2, 0);
        List<Placeable> list = this.placeables;
        if (!list.isEmpty()) {
            Placeable placeable3 = list.get(0);
            Integer numValueOf3 = Integer.valueOf(this.isVertical ? placeable3.getWidth() : placeable3.getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list.get(i7);
                    Integer numValueOf4 = Integer.valueOf(this.isVertical ? placeable4.getWidth() : placeable4.getHeight());
                    numValueOf3 = numValueOf4.compareTo(numValueOf3) > 0 ? numValueOf4 : numValueOf3;
                    if (i7 == lastIndex2) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            num = numValueOf3;
        }
        Integer num3 = num;
        int iIntValue2 = num3 != null ? num3.intValue() : 0;
        this.crossAxisSize = iIntValue2;
        this.mainAxisLayoutSize = -1;
        if (this.isVertical) {
            jIntSize = IntSizeKt.IntSize(iIntValue2, this.mainAxisSize);
        } else {
            jIntSize = IntSizeKt.IntSize(this.mainAxisSize, iIntValue2);
        }
        this.size = jIntSize;
        this.offset = IntOffset.INSTANCE.m5001getZeronOccac();
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        long jIntOffset;
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
        if (this.isVertical) {
            jIntOffset = IntOffsetKt.IntOffset(crossAxis, mainAxis);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(mainAxis, crossAxis);
        }
        this.offset = jIntOffset;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m4991getXimpl(getOffset()) : IntOffset.m4992getYimpl(getOffset());
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m670getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4992getYimpl(j) : IntOffset.m4991getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m669copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int iM4991getXimpl = this.isVertical ? IntOffset.m4991getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m4991getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int iM4992getYimpl = IntOffset.m4992getYimpl(j);
        if (z) {
            iM4992getYimpl = function1.invoke(Integer.valueOf(iM4992getYimpl)).intValue();
        }
        return IntOffsetKt.IntOffset(iM4991getXimpl, iM4992getYimpl);
    }

    public String toString() {
        return super.toString();
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasureContext context) {
        int iM4991getXimpl;
        int iM4992getYimpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mainAxisLayoutSize == -1) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
            int i2 = this.maxMainAxisOffset;
            long offset = getOffset();
            Object parentData = getParentData(i);
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (lazyLayoutAnimateItemModifierNode != null) {
                long jM625getPlacementDeltanOccac = lazyLayoutAnimateItemModifierNode.m625getPlacementDeltanOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(offset) + IntOffset.m4991getXimpl(jM625getPlacementDeltanOccac), IntOffset.m4992getYimpl(offset) + IntOffset.m4992getYimpl(jM625getPlacementDeltanOccac));
                if ((m670getMainAxisgyyYBs(offset) <= height && m670getMainAxisgyyYBs(jIntOffset) <= height) || (m670getMainAxisgyyYBs(offset) >= i2 && m670getMainAxisgyyYBs(jIntOffset) >= i2)) {
                    lazyLayoutAnimateItemModifierNode.cancelAnimation();
                }
                offset = jIntOffset;
            }
            if (context.getReverseLayout()) {
                if (this.isVertical) {
                    iM4991getXimpl = IntOffset.m4991getXimpl(offset);
                } else {
                    iM4991getXimpl = (this.mainAxisLayoutSize - IntOffset.m4991getXimpl(offset)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                }
                if (!this.isVertical) {
                    iM4992getYimpl = IntOffset.m4992getYimpl(offset);
                } else {
                    iM4992getYimpl = (this.mainAxisLayoutSize - IntOffset.m4992getYimpl(offset)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                }
                offset = IntOffsetKt.IntOffset(iM4991getXimpl, iM4992getYimpl);
            }
            long contentOffset = context.getContentOffset();
            Placeable.PlacementScope.m3925placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(offset) + IntOffset.m4991getXimpl(contentOffset), IntOffset.m4992getYimpl(offset) + IntOffset.m4992getYimpl(contentOffset)), 0.0f, null, 6, null);
        }
    }
}
