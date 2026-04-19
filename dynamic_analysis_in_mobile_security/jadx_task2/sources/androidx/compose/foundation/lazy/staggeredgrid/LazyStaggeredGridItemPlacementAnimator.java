package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010*\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0,H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyStaggeredGridMeasuredItem item, int mainAxisOffset) {
        long jM4987copyiSbpLlY$default;
        long jMo654getOffsetnOccac = item.getOffset();
        if (item.getIsVertical()) {
            jM4987copyiSbpLlY$default = IntOffset.m4987copyiSbpLlY$default(jMo654getOffsetnOccac, 0, mainAxisOffset, 1, null);
        } else {
            jM4987copyiSbpLlY$default = IntOffset.m4987copyiSbpLlY$default(jMo654getOffsetnOccac, mainAxisOffset, 0, 2, null);
        }
        int placeablesCount = item.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(item.getParentData(i));
            if (node != null) {
                long jMo654getOffsetnOccac2 = item.getOffset();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jMo654getOffsetnOccac2) - IntOffset.m4991getXimpl(jMo654getOffsetnOccac), IntOffset.m4992getYimpl(jMo654getOffsetnOccac2) - IntOffset.m4992getYimpl(jMo654getOffsetnOccac));
                node.m627setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jM4987copyiSbpLlY$default) + IntOffset.m4991getXimpl(jIntOffset), IntOffset.m4992getYimpl(jM4987copyiSbpLlY$default) + IntOffset.m4992getYimpl(jIntOffset)));
            }
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object obj) {
        if (obj instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) obj;
        }
        return null;
    }

    private final void forEachNode(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> function1) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem.getParentData(i));
            if (node != null) {
                function1.invoke(node);
            }
        }
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyStaggeredGridMeasuredItem> positionedItems, LazyStaggeredGridMeasureProvider itemProvider, boolean isVertical, int laneCount) {
        long jIntOffset;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap;
        int i;
        List<LazyStaggeredGridMeasuredItem> list;
        int i2;
        int i3;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap2;
        int i4;
        List<LazyStaggeredGridMeasuredItem> positionedItems2 = positionedItems;
        int i5 = laneCount;
        Intrinsics.checkNotNullParameter(positionedItems2, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        int size = positionedItems.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                if (this.keyToItemInfoMap.isEmpty()) {
                    reset();
                    return;
                }
            } else if (getHasAnimations(positionedItems2.get(i6))) {
                break;
            } else {
                i6++;
            }
        }
        int i7 = this.firstVisibleIndex;
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : 0;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap3 = this.keyIndexMap;
        this.keyIndexMap = itemProvider.getKeyIndexMap();
        int i8 = isVertical ? layoutHeight : layoutWidth;
        if (isVertical) {
            jIntOffset = IntOffsetKt.IntOffset(0, consumedScroll);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(consumedScroll, 0);
        }
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = positionedItems.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = positionedItems2.get(i9);
            this.movingAwayKeys.remove(lazyStaggeredGridMeasuredItem2.getKey());
            if (getHasAnimations(lazyStaggeredGridMeasuredItem2)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem2.getKey());
                if (itemInfo == null) {
                    i3 = size2;
                    this.keyToItemInfoMap.put(lazyStaggeredGridMeasuredItem2.getKey(), new ItemInfo(lazyStaggeredGridMeasuredItem2.getLane(), lazyStaggeredGridMeasuredItem2.getSpan(), lazyStaggeredGridMeasuredItem2.getCrossAxisOffset()));
                    int index = lazyLayoutKeyIndexMap3.getIndex(lazyStaggeredGridMeasuredItem2.getKey());
                    if (index == -1 || lazyStaggeredGridMeasuredItem2.getIndex() == index) {
                        long jMo654getOffsetnOccac = lazyStaggeredGridMeasuredItem2.getOffset();
                        initializeNode(lazyStaggeredGridMeasuredItem2, lazyStaggeredGridMeasuredItem2.getIsVertical() ? IntOffset.m4992getYimpl(jMo654getOffsetnOccac) : IntOffset.m4991getXimpl(jMo654getOffsetnOccac));
                    } else if (index < i7) {
                        this.movingInFromStartBound.add(lazyStaggeredGridMeasuredItem2);
                    } else {
                        this.movingInFromEndBound.add(lazyStaggeredGridMeasuredItem2);
                    }
                    lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                    i4 = i8;
                } else {
                    i3 = size2;
                    int placeablesCount = lazyStaggeredGridMeasuredItem2.getPlaceablesCount();
                    int i10 = 0;
                    while (i10 < placeablesCount) {
                        LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem2.getParentData(i10));
                        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap4 = lazyLayoutKeyIndexMap3;
                        int i11 = i8;
                        if (node != null && !IntOffset.m4990equalsimpl0(node.getRawOffset(), LazyLayoutAnimateItemModifierNode.INSTANCE.m628getNotInitializednOccac())) {
                            long rawOffset = node.getRawOffset();
                            node.m627setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(rawOffset) + IntOffset.m4991getXimpl(jIntOffset), IntOffset.m4992getYimpl(rawOffset) + IntOffset.m4992getYimpl(jIntOffset)));
                        }
                        i10++;
                        i8 = i11;
                        lazyLayoutKeyIndexMap3 = lazyLayoutKeyIndexMap4;
                    }
                    lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                    i4 = i8;
                    itemInfo.setLane(lazyStaggeredGridMeasuredItem2.getLane());
                    itemInfo.setSpan(lazyStaggeredGridMeasuredItem2.getSpan());
                    itemInfo.setCrossAxisOffset(lazyStaggeredGridMeasuredItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem2);
                }
            } else {
                i3 = size2;
                lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                i4 = i8;
                this.keyToItemInfoMap.remove(lazyStaggeredGridMeasuredItem2.getKey());
            }
            i9++;
            size2 = i3;
            i8 = i4;
            positionedItems2 = positionedItems;
            i5 = laneCount;
            lazyLayoutKeyIndexMap3 = lazyLayoutKeyIndexMap2;
        }
        int i12 = i5;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap5 = lazyLayoutKeyIndexMap3;
        int i13 = i8;
        int[] iArr = new int[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            iArr[i14] = 0;
        }
        if (!this.movingInFromStartBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list2 = this.movingInFromStartBound;
            if (list2.size() > 1) {
                lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
                CollectionsKt.sortWith(list2, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())));
                    }
                });
            } else {
                lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
            }
            List<LazyStaggeredGridMeasuredItem> list3 = this.movingInFromStartBound;
            int size3 = list3.size();
            for (int i15 = 0; i15 < size3; i15++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = list3.get(i15);
                int lane = lazyStaggeredGridMeasuredItem3.getLane();
                iArr[lane] = iArr[lane] + lazyStaggeredGridMeasuredItem3.getMainAxisSize();
                initializeNode(lazyStaggeredGridMeasuredItem3, 0 - iArr[lazyStaggeredGridMeasuredItem3.getLane()]);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem3);
            }
            ArraysKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
        } else {
            lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
        }
        if (!this.movingInFromEndBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list4 = this.movingInFromEndBound;
            if (list4.size() > 1) {
                CollectionsKt.sortWith(list4, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list5 = this.movingInFromEndBound;
            int size4 = list5.size();
            for (int i16 = 0; i16 < size4; i16++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = list5.get(i16);
                int i17 = i13 + iArr[lazyStaggeredGridMeasuredItem4.getLane()];
                int lane2 = lazyStaggeredGridMeasuredItem4.getLane();
                iArr[lane2] = iArr[lane2] + lazyStaggeredGridMeasuredItem4.getMainAxisSize();
                initializeNode(lazyStaggeredGridMeasuredItem4, i17);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem4);
            }
            ArraysKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM668getAndMeasurejy6DScQ = itemProvider.m668getAndMeasurejy6DScQ(index2, SpanRange.m673constructorimpl(itemInfo2.getLane(), itemInfo2.getSpan()));
                int placeablesCount2 = lazyStaggeredGridMeasuredItemM668getAndMeasurejy6DScQ.getPlaceablesCount();
                boolean z = false;
                for (int i18 = 0; i18 < placeablesCount2; i18++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(lazyStaggeredGridMeasuredItemM668getAndMeasurejy6DScQ.getParentData(i18));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z = true;
                    }
                }
                if (!z && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.keyToItemInfoMap.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(lazyStaggeredGridMeasuredItemM668getAndMeasurejy6DScQ);
                } else {
                    this.movingAwayToEndBound.add(lazyStaggeredGridMeasuredItemM668getAndMeasurejy6DScQ);
                }
            }
        }
        if (!this.movingAwayToStartBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list6 = this.movingAwayToStartBound;
            if (list6.size() > 1) {
                CollectionsKt.sortWith(list6, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list7 = this.movingAwayToStartBound;
            int size5 = list7.size();
            for (int i19 = 0; i19 < size5; i19++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = list7.get(i19);
                int lane3 = lazyStaggeredGridMeasuredItem5.getLane();
                iArr[lane3] = iArr[lane3] + lazyStaggeredGridMeasuredItem5.getMainAxisSize();
                lazyStaggeredGridMeasuredItem5.position(0 - iArr[lazyStaggeredGridMeasuredItem5.getLane()], ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyStaggeredGridMeasuredItem5.getKey())).getCrossAxisOffset(), i13);
                positionedItems.add(lazyStaggeredGridMeasuredItem5);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem5);
            }
            i = i13;
            list = positionedItems;
            i2 = 0;
            ArraysKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
        } else {
            i = i13;
            list = positionedItems;
            i2 = 0;
        }
        if (!this.movingAwayToEndBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list8 = this.movingAwayToEndBound;
            if (list8.size() > 1) {
                CollectionsKt.sortWith(list8, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list9 = this.movingAwayToEndBound;
            int size6 = list9.size();
            for (int i20 = i2; i20 < size6; i20++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = list9.get(i20);
                int i21 = i + iArr[lazyStaggeredGridMeasuredItem6.getLane()];
                int lane4 = lazyStaggeredGridMeasuredItem6.getLane();
                iArr[lane4] = iArr[lane4] + lazyStaggeredGridMeasuredItem6.getMainAxisSize();
                lazyStaggeredGridMeasuredItem6.position(i21, ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyStaggeredGridMeasuredItem6.getKey())).getCrossAxisOffset(), i);
                list.add(lazyStaggeredGridMeasuredItem6);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem6);
            }
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem item) {
        int placeablesCount = item.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(item.getParentData(i));
            if (node != null) {
                long jMo654getOffsetnOccac = item.getOffset();
                long rawOffset = node.getRawOffset();
                if (!IntOffset.m4990equalsimpl0(rawOffset, LazyLayoutAnimateItemModifierNode.INSTANCE.m628getNotInitializednOccac()) && !IntOffset.m4990equalsimpl0(rawOffset, jMo654getOffsetnOccac)) {
                    node.m624animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jMo654getOffsetnOccac) - IntOffset.m4991getXimpl(rawOffset), IntOffset.m4992getYimpl(jMo654getOffsetnOccac) - IntOffset.m4992getYimpl(rawOffset)));
                }
                node.m627setRawOffsetgyyYBs(jMo654getOffsetnOccac);
            }
        }
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyStaggeredGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }
}
