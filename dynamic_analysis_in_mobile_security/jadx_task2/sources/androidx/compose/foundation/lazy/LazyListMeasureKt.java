package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001aB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001aî\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042/\u0010.\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3\u0012\u0004\u0012\u0002040/H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-CD5nmq0", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;ILjava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: measureLazyList-CD5nmq0, reason: not valid java name */
    public static final LazyListMeasureResult m587measureLazyListCD5nmq0(int i, LazyListMeasuredItemProvider measuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, List<Integer> headerIndexes, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyListItemPlacementAnimator placementAnimator, int i8, List<Integer> pinnedItems, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i9;
        String str;
        int i10;
        int i11;
        int i12;
        int sizeWithSpacings;
        int i13;
        int i14;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i15;
        List<LazyListMeasuredItem> list;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(pinnedItems, "pinnedItems");
        Intrinsics.checkNotNullParameter(layout, "layout");
        String str2 = "Failed requirement.";
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i <= 0) {
            return new LazyListMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m4831getMinWidthimpl(j)), Integer.valueOf(Constraints.m4830getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int i18 = i6;
        if (i18 >= i) {
            i18 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int iRoundToInt = MathKt.roundToInt(f);
        int i19 = i9 - iRoundToInt;
        if (i18 == 0 && i19 < 0) {
            iRoundToInt += i19;
            i19 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i20 = -i3;
        int i21 = i20 + (i5 < 0 ? i5 : 0);
        int sizeWithSpacings2 = i19 + i21;
        int iMax = 0;
        while (sizeWithSpacings2 < 0 && i18 > 0) {
            int i22 = i18 - 1;
            LazyListMeasuredItem andMeasure = measuredItemProvider.getAndMeasure(i22);
            arrayDeque.add(0, andMeasure);
            iMax = Math.max(iMax, andMeasure.getCrossAxisSize());
            sizeWithSpacings2 += andMeasure.getSizeWithSpacings();
            i18 = i22;
        }
        if (sizeWithSpacings2 < i21) {
            iRoundToInt += sizeWithSpacings2;
            sizeWithSpacings2 = i21;
        }
        int i23 = sizeWithSpacings2 - i21;
        int i24 = i2 + i4;
        int i25 = iMax;
        int i26 = i18;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i24, 0);
        int sizeWithSpacings3 = -i23;
        ArrayDeque arrayDeque2 = arrayDeque;
        int sizeWithSpacings4 = i23;
        int size = arrayDeque2.size();
        int i27 = i26;
        for (int i28 = 0; i28 < size; i28++) {
            i27++;
            sizeWithSpacings3 += ((LazyListMeasuredItem) arrayDeque2.get(i28)).getSizeWithSpacings();
        }
        int iMax2 = i25;
        int sizeWithSpacings5 = sizeWithSpacings3;
        int i29 = i27;
        while (i29 < i && (sizeWithSpacings5 < iCoerceAtLeast || sizeWithSpacings5 <= 0 || arrayDeque.isEmpty())) {
            int i30 = iCoerceAtLeast;
            LazyListMeasuredItem andMeasure2 = measuredItemProvider.getAndMeasure(i29);
            sizeWithSpacings5 += andMeasure2.getSizeWithSpacings();
            if (sizeWithSpacings5 <= i21) {
                i16 = i21;
                if (i29 != i - 1) {
                    i17 = i29 + 1;
                    sizeWithSpacings4 -= andMeasure2.getSizeWithSpacings();
                }
                i29++;
                i26 = i17;
                iCoerceAtLeast = i30;
                i21 = i16;
            } else {
                i16 = i21;
            }
            int iMax3 = Math.max(iMax2, andMeasure2.getCrossAxisSize());
            arrayDeque.add(andMeasure2);
            iMax2 = iMax3;
            i17 = i26;
            i29++;
            i26 = i17;
            iCoerceAtLeast = i30;
            i21 = i16;
        }
        if (sizeWithSpacings5 < i2) {
            int i31 = i2 - sizeWithSpacings5;
            int i32 = sizeWithSpacings5 + i31;
            int i33 = i26;
            sizeWithSpacings = sizeWithSpacings4 - i31;
            while (sizeWithSpacings < i3 && i33 > 0) {
                int i34 = i29;
                int i35 = i33 - 1;
                String str3 = str2;
                LazyListMeasuredItem andMeasure3 = measuredItemProvider.getAndMeasure(i35);
                arrayDeque.add(0, andMeasure3);
                iMax2 = Math.max(iMax2, andMeasure3.getCrossAxisSize());
                sizeWithSpacings += andMeasure3.getSizeWithSpacings();
                i33 = i35;
                i29 = i34;
                str2 = str3;
            }
            str = str2;
            i10 = i29;
            int i36 = iRoundToInt + i31;
            if (sizeWithSpacings < 0) {
                i11 = i32 + sizeWithSpacings;
                i12 = i36 + sizeWithSpacings;
                i13 = i33;
                sizeWithSpacings = 0;
            } else {
                i11 = i32;
                i12 = i36;
                i13 = i33;
            }
        } else {
            str = "Failed requirement.";
            i10 = i29;
            i11 = sizeWithSpacings5;
            i12 = iRoundToInt;
            sizeWithSpacings = sizeWithSpacings4;
            i13 = i26;
        }
        int i37 = iMax2;
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i12) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i12)) ? f : i12;
        if (sizeWithSpacings < 0) {
            throw new IllegalArgumentException(str.toString());
        }
        int i38 = -sizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            int size2 = arrayDeque.size();
            LazyListMeasuredItem lazyListMeasuredItem3 = lazyListMeasuredItem2;
            int i39 = sizeWithSpacings;
            int i40 = 0;
            while (i40 < size2) {
                int i41 = size2;
                int sizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque.get(i40)).getSizeWithSpacings();
                if (i39 == 0 || sizeWithSpacings6 > i39) {
                    break;
                }
                i14 = i38;
                if (i40 == CollectionsKt.getLastIndex(arrayDeque2)) {
                    break;
                }
                i39 -= sizeWithSpacings6;
                i40++;
                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.get(i40);
                i38 = i14;
                size2 = i41;
            }
            i14 = i38;
            lazyListMeasuredItem = lazyListMeasuredItem3;
            i15 = i39;
        } else {
            lazyListMeasuredItem = lazyListMeasuredItem2;
            i15 = sizeWithSpacings;
            i14 = i38;
        }
        List<LazyListMeasuredItem> listCreateItemsBeforeList = createItemsBeforeList(i13, measuredItemProvider, i8, pinnedItems);
        int iMax4 = i37;
        int i42 = 0;
        for (int size3 = listCreateItemsBeforeList.size(); i42 < size3; size3 = size3) {
            iMax4 = Math.max(iMax4, listCreateItemsBeforeList.get(i42).getCrossAxisSize());
            i42++;
        }
        List<LazyListMeasuredItem> listCreateItemsAfterList = createItemsAfterList(arrayDeque2, measuredItemProvider, i, i8, pinnedItems);
        int size4 = listCreateItemsAfterList.size();
        for (int i43 = 0; i43 < size4; i43++) {
            iMax4 = Math.max(iMax4, listCreateItemsAfterList.get(i43).getCrossAxisSize());
        }
        boolean z3 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty();
        int iM4843constrainWidthK40F9xA = ConstraintsKt.m4843constrainWidthK40F9xA(j, z ? iMax4 : i11);
        if (z) {
            iMax4 = i11;
        }
        int iM4842constrainHeightK40F9xA = ConstraintsKt.m4842constrainHeightK40F9xA(j, iMax4);
        float f3 = f2;
        int i44 = i10;
        final List<LazyListMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque2, listCreateItemsBeforeList, listCreateItemsAfterList, iM4843constrainWidthK40F9xA, iM4842constrainHeightK40F9xA, i11, i2, i14, z, vertical, horizontal, z2, density);
        int i45 = i11;
        LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem;
        placementAnimator.onMeasured((int) f3, iM4843constrainWidthK40F9xA, iM4842constrainHeightK40F9xA, listCalculateItemsOffsets, measuredItemProvider, z);
        final LazyListMeasuredItem lazyListMeasuredItemFindOrComposeLazyListHeader = headerIndexes.isEmpty() ^ true ? LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, measuredItemProvider, headerIndexes, i3, iM4843constrainWidthK40F9xA, iM4842constrainHeightK40F9xA) : null;
        boolean z4 = i44 < i || i45 > i2;
        MeasureResult measureResultInvoke = layout.invoke(Integer.valueOf(iM4843constrainWidthK40F9xA), Integer.valueOf(iM4842constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$5
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
            public final void invoke2(Placeable.PlacementScope invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                List<LazyListMeasuredItem> list2 = listCalculateItemsOffsets;
                LazyListMeasuredItem lazyListMeasuredItem5 = lazyListMeasuredItemFindOrComposeLazyListHeader;
                int size5 = list2.size();
                for (int i46 = 0; i46 < size5; i46++) {
                    LazyListMeasuredItem lazyListMeasuredItem6 = list2.get(i46);
                    if (lazyListMeasuredItem6 != lazyListMeasuredItem5) {
                        lazyListMeasuredItem6.place(invoke);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem7 = lazyListMeasuredItemFindOrComposeLazyListHeader;
                if (lazyListMeasuredItem7 != null) {
                    lazyListMeasuredItem7.place(invoke);
                }
            }
        });
        if (z3) {
            list = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList = new ArrayList(listCalculateItemsOffsets.size());
            int size5 = listCalculateItemsOffsets.size();
            for (int i46 = 0; i46 < size5; i46++) {
                LazyListMeasuredItem lazyListMeasuredItem5 = listCalculateItemsOffsets.get(i46);
                LazyListMeasuredItem lazyListMeasuredItem6 = lazyListMeasuredItem5;
                if ((lazyListMeasuredItem6.getIndex() >= ((LazyListMeasuredItem) arrayDeque.first()).getIndex() && lazyListMeasuredItem6.getIndex() <= ((LazyListMeasuredItem) arrayDeque.last()).getIndex()) || lazyListMeasuredItem6 == lazyListMeasuredItemFindOrComposeLazyListHeader) {
                    arrayList.add(lazyListMeasuredItem5);
                }
            }
            list = arrayList;
        }
        return new LazyListMeasureResult(lazyListMeasuredItem4, i15, z4, f3, measureResultInvoke, list, i20, i24, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2) {
        int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i2, i - 1);
        int index = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(index));
                if (index == iMin) {
                    break;
                }
                index++;
            }
        }
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iIntValue = list2.get(i3).intValue();
            if (iIntValue > iMin) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(iIntValue));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(i3));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = list.get(i4).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyListMeasuredItemProvider.getAndMeasure(iIntValue));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr2[i8] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size2 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        size2 = (i6 - size2) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(size2, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int sizeWithSpacings = i5;
            for (int i9 = 0; i9 < size3; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i9);
                sizeWithSpacings -= lazyListMeasuredItem2.getSizeWithSpacings();
                lazyListMeasuredItem2.position(sizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size4 = list.size();
            int sizeWithSpacings2 = i5;
            for (int i10 = 0; i10 < size4; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i10);
                lazyListMeasuredItem3.position(sizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                sizeWithSpacings2 += lazyListMeasuredItem3.getSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i11 = 0; i11 < size5; i11++) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i11);
                lazyListMeasuredItem4.position(sizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                sizeWithSpacings2 += lazyListMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
