package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyListItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J<\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u001bJ\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002JE\u0010(\u001a\u00020\u001b*\u00020\u000e26\u0010)\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001b0*H\u0082\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "()V", "activeKeys", "", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "placeableIndex", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Set<Object> activeKeys = new LinkedHashSet();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyListMeasuredItem item, int mainAxisOffset) {
        long jM4987copyiSbpLlY$default;
        long jM590getOffsetBjo55l4 = item.m590getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            jM4987copyiSbpLlY$default = IntOffset.m4987copyiSbpLlY$default(jM590getOffsetBjo55l4, 0, mainAxisOffset, 1, null);
        } else {
            jM4987copyiSbpLlY$default = IntOffset.m4987copyiSbpLlY$default(jM590getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        }
        int placeablesCount = item.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(item.getParentData(i));
            if (node != null) {
                long jM590getOffsetBjo55l42 = item.m590getOffsetBjo55l4(i);
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jM590getOffsetBjo55l42) - IntOffset.m4991getXimpl(jM590getOffsetBjo55l4), IntOffset.m4992getYimpl(jM590getOffsetBjo55l42) - IntOffset.m4992getYimpl(jM590getOffsetBjo55l4));
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

    private final void forEachNode(LazyListMeasuredItem lazyListMeasuredItem, Function2<? super Integer, ? super LazyLayoutAnimateItemModifierNode, Unit> function2) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                function2.invoke(Integer.valueOf(i), node);
            }
        }
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyListMeasuredItem> positionedItems, LazyListMeasuredItemProvider itemProvider, boolean isVertical) {
        long jIntOffset;
        int i;
        List<LazyListMeasuredItem> positionedItems2 = positionedItems;
        Intrinsics.checkNotNullParameter(positionedItems2, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        int size = positionedItems.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                if (this.activeKeys.isEmpty()) {
                    reset();
                    return;
                }
            } else if (getHasAnimations(positionedItems2.get(i2))) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = this.firstVisibleIndex;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = itemProvider.getKeyIndexMap();
        int i4 = isVertical ? layoutHeight : layoutWidth;
        if (isVertical) {
            jIntOffset = IntOffsetKt.IntOffset(0, consumedScroll);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(consumedScroll, 0);
        }
        this.movingAwayKeys.addAll(this.activeKeys);
        int size2 = positionedItems.size();
        int i5 = 0;
        while (i5 < size2) {
            LazyListMeasuredItem lazyListMeasuredItem2 = positionedItems2.get(i5);
            this.movingAwayKeys.remove(lazyListMeasuredItem2.getKey());
            if (getHasAnimations(lazyListMeasuredItem2)) {
                if (!this.activeKeys.contains(lazyListMeasuredItem2.getKey())) {
                    this.activeKeys.add(lazyListMeasuredItem2.getKey());
                    int index = lazyLayoutKeyIndexMap.getIndex(lazyListMeasuredItem2.getKey());
                    if (index == -1 || lazyListMeasuredItem2.getIndex() == index) {
                        long jM590getOffsetBjo55l4 = lazyListMeasuredItem2.m590getOffsetBjo55l4(0);
                        initializeNode(lazyListMeasuredItem2, lazyListMeasuredItem2.getIsVertical() ? IntOffset.m4992getYimpl(jM590getOffsetBjo55l4) : IntOffset.m4991getXimpl(jM590getOffsetBjo55l4));
                    } else if (index < i3) {
                        this.movingInFromStartBound.add(lazyListMeasuredItem2);
                    } else {
                        this.movingInFromEndBound.add(lazyListMeasuredItem2);
                    }
                    i = size2;
                } else {
                    int placeablesCount = lazyListMeasuredItem2.getPlaceablesCount();
                    int i6 = 0;
                    while (i6 < placeablesCount) {
                        LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem2.getParentData(i6));
                        int i7 = size2;
                        if (node != null && !IntOffset.m4990equalsimpl0(node.getRawOffset(), LazyLayoutAnimateItemModifierNode.INSTANCE.m628getNotInitializednOccac())) {
                            long rawOffset = node.getRawOffset();
                            node.m627setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(rawOffset) + IntOffset.m4991getXimpl(jIntOffset), IntOffset.m4992getYimpl(rawOffset) + IntOffset.m4992getYimpl(jIntOffset)));
                        }
                        i6++;
                        size2 = i7;
                    }
                    i = size2;
                    startAnimationsIfNeeded(lazyListMeasuredItem2);
                }
            } else {
                i = size2;
                this.activeKeys.remove(lazyListMeasuredItem2.getKey());
            }
            i5++;
            size2 = i;
            positionedItems2 = positionedItems;
        }
        List<LazyListMeasuredItem> list = this.movingInFromStartBound;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list2 = this.movingInFromStartBound;
        int size3 = list2.size();
        int size4 = 0;
        for (int i8 = 0; i8 < size3; i8++) {
            LazyListMeasuredItem lazyListMeasuredItem3 = list2.get(i8);
            size4 += lazyListMeasuredItem3.getSize();
            initializeNode(lazyListMeasuredItem3, 0 - size4);
            startAnimationsIfNeeded(lazyListMeasuredItem3);
        }
        List<LazyListMeasuredItem> list3 = this.movingInFromEndBound;
        if (list3.size() > 1) {
            CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list4 = this.movingInFromEndBound;
        int size5 = list4.size();
        int size6 = 0;
        for (int i9 = 0; i9 < size5; i9++) {
            LazyListMeasuredItem lazyListMeasuredItem4 = list4.get(i9);
            int i10 = i4 + size6;
            size6 += lazyListMeasuredItem4.getSize();
            initializeNode(lazyListMeasuredItem4, i10);
            startAnimationsIfNeeded(lazyListMeasuredItem4);
        }
        for (Object obj : this.movingAwayKeys) {
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.activeKeys.remove(obj);
            } else {
                LazyListMeasuredItem andMeasure = itemProvider.getAndMeasure(index2);
                int placeablesCount2 = andMeasure.getPlaceablesCount();
                boolean z = false;
                for (int i11 = 0; i11 < placeablesCount2; i11++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(andMeasure.getParentData(i11));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z = true;
                    }
                }
                if (!z && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.activeKeys.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(andMeasure);
                } else {
                    this.movingAwayToEndBound.add(andMeasure);
                }
            }
        }
        List<LazyListMeasuredItem> list5 = this.movingAwayToStartBound;
        if (list5.size() > 1) {
            CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list6 = this.movingAwayToStartBound;
        int size7 = list6.size();
        int size8 = 0;
        for (int i12 = 0; i12 < size7; i12++) {
            LazyListMeasuredItem lazyListMeasuredItem5 = list6.get(i12);
            size8 += lazyListMeasuredItem5.getSize();
            lazyListMeasuredItem5.position(0 - size8, layoutWidth, layoutHeight);
            positionedItems.add(lazyListMeasuredItem5);
            startAnimationsIfNeeded(lazyListMeasuredItem5);
        }
        List<LazyListMeasuredItem> list7 = this.movingAwayToEndBound;
        if (list7.size() > 1) {
            CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list8 = this.movingAwayToEndBound;
        int size9 = list8.size();
        int size10 = 0;
        for (int i13 = 0; i13 < size9; i13++) {
            LazyListMeasuredItem lazyListMeasuredItem6 = list8.get(i13);
            int i14 = i4 + size10;
            size10 += lazyListMeasuredItem6.getSize();
            lazyListMeasuredItem6.position(i14, layoutWidth, layoutHeight);
            positionedItems.add(lazyListMeasuredItem6);
            startAnimationsIfNeeded(lazyListMeasuredItem6);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem item) {
        int placeablesCount = item.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(item.getParentData(i));
            if (node != null) {
                long jM590getOffsetBjo55l4 = item.m590getOffsetBjo55l4(i);
                long rawOffset = node.getRawOffset();
                if (!IntOffset.m4990equalsimpl0(rawOffset, LazyLayoutAnimateItemModifierNode.INSTANCE.m628getNotInitializednOccac()) && !IntOffset.m4990equalsimpl0(rawOffset, jM590getOffsetBjo55l4)) {
                    node.m624animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jM590getOffsetBjo55l4) - IntOffset.m4991getXimpl(rawOffset), IntOffset.m4992getYimpl(jM590getOffsetBjo55l4) - IntOffset.m4992getYimpl(rawOffset)));
                }
                node.m627setRawOffsetgyyYBs(jM590getOffsetBjo55l4);
            }
        }
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyListMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }
}
