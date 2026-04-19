package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u008c\u0001\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\u0007¢\u0006\u0002\b\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003ø\u0001\u0000¢\u0006\u0002\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyGrid(androidx.compose.ui.Modifier r36, final androidx.compose.foundation.lazy.grid.LazyGridState r37, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.grid.LazyGridSlots> r38, androidx.compose.foundation.layout.PaddingValues r39, boolean r40, final boolean r41, androidx.compose.foundation.gestures.FlingBehavior r42, final boolean r43, final androidx.compose.foundation.layout.Arrangement.Vertical r44, final androidx.compose.foundation.layout.Arrangement.Horizontal r45, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-649335720);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649335720, $changed, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:138)");
            }
            LazyGridItemProvider itemProvider = function0.invoke();
            if (itemProvider.getItemCount() > 0) {
                LazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.ScrollPositionUpdater.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                LazyGridKt.ScrollPositionUpdater(function0, state, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState state, final Function2<? super Density, ? super Constraints, LazyGridSlots> function2, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1292704639);
        ComposerKt.sourceInformation($composer, "C(rememberLazyGridMeasurePolicy)P(3,6,5!1,4,2)173@6918L8458:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontalArrangement2 = (i & 64) != 0 ? null : horizontalArrangement;
        Arrangement.Vertical verticalArrangement2 = (i & 128) != 0 ? null : verticalArrangement;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292704639, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:156)");
        }
        Object[] keys$iv = {state, function2, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalArrangement2, verticalArrangement2};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical = verticalArrangement2;
            final Arrangement.Horizontal horizontal = horizontalArrangement2;
            value$iv$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m615invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r0v42, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* JADX WARN: Type inference failed for: r0v43, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m615invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) throws Throwable {
                    int i2;
                    int i3;
                    int i4;
                    float spacing;
                    int iM5168getMaxWidthimpl;
                    final long visualItemOffset;
                    Snapshot this_$iv$iv;
                    Snapshot previous$iv$iv;
                    int firstVisibleLineIndex;
                    int firstVisibleLineScrollOffset;
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    CheckScrollableContainerConstraintsKt.m188checkScrollableContainerConstraintsK40F9xA(containerConstraints, isVertical ? Orientation.Vertical : Orientation.Horizontal);
                    if (isVertical) {
                        i2 = $this$null.mo320roundToPx0680j_4(contentPadding.mo432calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i2 = $this$null.mo320roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int startPadding = i2;
                    if (isVertical) {
                        i3 = $this$null.mo320roundToPx0680j_4(contentPadding.mo433calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i3 = $this$null.mo320roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int endPadding = i3;
                    int topPadding = $this$null.mo320roundToPx0680j_4(contentPadding.getTop());
                    int bottomPadding = $this$null.mo320roundToPx0680j_4(contentPadding.getBottom());
                    final int totalVerticalPadding = topPadding + bottomPadding;
                    final int totalHorizontalPadding = startPadding + endPadding;
                    boolean z = isVertical;
                    int totalMainAxisPadding = z ? totalVerticalPadding : totalHorizontalPadding;
                    if (z && !reverseLayout) {
                        i4 = topPadding;
                    } else if (z && reverseLayout) {
                        i4 = bottomPadding;
                    } else {
                        i4 = (z || reverseLayout) ? endPadding : startPadding;
                    }
                    final int beforeContentPadding = i4;
                    final int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
                    long contentConstraints = ConstraintsKt.m5184offsetNN6EwU(containerConstraints, -totalHorizontalPadding, -totalVerticalPadding);
                    final LazyGridItemProvider itemProvider = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = itemProvider.getSpanLayoutProvider();
                    final LazyGridSlots resolvedSlots = function2.invoke($this$null, Constraints.m5156boximpl(containerConstraints));
                    int slotsPerLine = resolvedSlots.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(slotsPerLine);
                    state.setDensity$foundation_release($this$null);
                    state.setSlotsPerLine$foundation_release(slotsPerLine);
                    if (isVertical) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    float spaceBetweenLinesDp = spacing;
                    final int spaceBetweenLines = $this$null.mo320roundToPx0680j_4(spaceBetweenLinesDp);
                    final int itemsCount = itemProvider.getItemCount();
                    if (isVertical) {
                        iM5168getMaxWidthimpl = Constraints.m5167getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    } else {
                        iM5168getMaxWidthimpl = Constraints.m5168getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    }
                    int mainAxisAvailableSize = iM5168getMaxWidthimpl;
                    if (!reverseLayout || mainAxisAvailableSize > 0) {
                        visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
                    } else {
                        boolean z2 = isVertical;
                        visualItemOffset = IntOffsetKt.IntOffset(z2 ? startPadding : startPadding + mainAxisAvailableSize, z2 ? topPadding + mainAxisAvailableSize : topPadding);
                    }
                    final boolean z3 = isVertical;
                    final boolean z4 = reverseLayout;
                    final ?? r0 = new LazyGridMeasuredItemProvider(itemProvider, $this$null, spaceBetweenLines, z3, z4, beforeContentPadding, afterContentPadding, visualItemOffset) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$this_null = $this$null;
                            this.$isVertical = z3;
                            this.$reverseLayout = z4;
                            this.$beforeContentPadding = beforeContentPadding;
                            this.$afterContentPadding = afterContentPadding;
                            this.$visualItemOffset = visualItemOffset;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        public LazyGridMeasuredItem createItem(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, null);
                        }
                    };
                    final boolean z5 = isVertical;
                    final ?? r02 = new LazyGridMeasuredLineProvider(z5, resolvedSlots, itemsCount, spaceBetweenLines, r0, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z5, resolvedSlots, itemsCount, spaceBetweenLines, r0, spanLayoutProvider);
                            this.$isVertical = z5;
                            this.$resolvedSlots = resolvedSlots;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    state.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int line) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(line);
                            int index = lineConfiguration.getFirstItemIndex();
                            int slot = 0;
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r02;
                            int index$iv = 0;
                            int size = spans.size();
                            while (index$iv < size) {
                                Object item$iv = spans.get(index$iv);
                                long it = ((GridItemSpan) item$iv).getPackedValue();
                                int span = GridItemSpan.m600getCurrentLineSpanimpl(it);
                                arrayList.add(TuplesKt.to(Integer.valueOf(index), Constraints.m5156boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m621childConstraintsJhjzzOo$foundation_release(slot, span))));
                                index++;
                                slot += span;
                                index$iv++;
                                lineConfiguration = lineConfiguration;
                            }
                            return arrayList;
                        }
                    });
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    LazyGridState lazyGridState = state;
                    Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                    try {
                        Snapshot previous$iv$iv2 = snapshot$iv.makeCurrent();
                        int firstVisibleLineIndex2 = 0;
                        try {
                            int index = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, lazyGridState.getFirstVisibleItemIndex());
                            if (index < itemsCount || itemsCount <= 0) {
                                try {
                                    firstVisibleLineIndex = spanLayoutProvider.getLineIndexOfItem(index);
                                } catch (Throwable th) {
                                    th = th;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv = previous$iv$iv2;
                                }
                                try {
                                    firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                                } catch (Throwable th2) {
                                    th = th2;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv = previous$iv$iv2;
                                    firstVisibleLineIndex2 = firstVisibleLineIndex;
                                    try {
                                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        snapshot$iv.restoreCurrent(previous$iv$iv2);
                                        snapshot$iv.dispose();
                                        LazyGridMeasureResult it = LazyGridMeasureKt.m616measureLazyGridZRKPzZ8(itemsCount, (LazyGridMeasuredLineProvider) r02, (LazyGridMeasuredItemProvider) r0, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines, firstVisibleLineIndex, firstVisibleLineScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, vertical, horizontal, reverseLayout, $this$null, state.getPlacementAnimator(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                                Intrinsics.checkNotNullParameter(placement, "placement");
                                                return $this$null.layout(ConstraintsKt.m5182constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m5181constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                                            }
                                        });
                                        state.applyMeasureResult$foundation_release(it);
                                        return it;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv = previous$iv$iv2;
                                    firstVisibleLineIndex2 = firstVisibleLineIndex;
                                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                }
                            } else {
                                try {
                                    firstVisibleLineIndex = spanLayoutProvider.getLineIndexOfItem(itemsCount - 1);
                                    firstVisibleLineScrollOffset = 0;
                                    Unit unit2 = Unit.INSTANCE;
                                    snapshot$iv.restoreCurrent(previous$iv$iv2);
                                    snapshot$iv.dispose();
                                    LazyGridMeasureResult it2 = LazyGridMeasureKt.m616measureLazyGridZRKPzZ8(itemsCount, (LazyGridMeasuredLineProvider) r02, (LazyGridMeasuredItemProvider) r0, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines, firstVisibleLineIndex, firstVisibleLineScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, vertical, horizontal, reverseLayout, $this$null, state.getPlacementAnimator(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                        }

                                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                            Intrinsics.checkNotNullParameter(placement, "placement");
                                            return $this$null.layout(ConstraintsKt.m5182constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m5181constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                                        }
                                    });
                                    state.applyMeasureResult$foundation_release(it2);
                                    return it2;
                                } catch (Throwable th6) {
                                    th = th6;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv = previous$iv$iv2;
                                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            this_$iv$iv = snapshot$iv;
                            previous$iv$iv = previous$iv$iv2;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                    snapshot$iv.dispose();
                    throw th;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function22;
    }
}
