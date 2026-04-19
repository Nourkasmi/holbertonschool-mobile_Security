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
    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyGrid(androidx.compose.ui.Modifier r35, final androidx.compose.foundation.lazy.grid.LazyGridState r36, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.grid.LazyGridSlots> r37, androidx.compose.foundation.layout.PaddingValues r38, boolean r39, final boolean r40, androidx.compose.foundation.gestures.FlingBehavior r41, final boolean r42, final androidx.compose.foundation.layout.Arrangement.Vertical r43, final androidx.compose.foundation.layout.Arrangement.Horizontal r44, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-649335720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649335720, i, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:138)");
            }
            LazyGridItemProvider lazyGridItemProviderInvoke = function0.invoke();
            if (lazyGridItemProviderInvoke.getItemCount() > 0) {
                LazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyGridState, lazyGridItemProviderInvoke, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                LazyGridKt.ScrollPositionUpdater(function0, lazyGridState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, final Function2<? super Density, ? super Constraints, LazyGridSlots> function2, final PaddingValues paddingValues, final boolean z, final boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1292704639);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridMeasurePolicy)P(3,6,5!1,4,2)173@6918L8458:LazyGrid.kt#7791vq");
        final Arrangement.Horizontal horizontal2 = (i2 & 64) != 0 ? null : horizontal;
        final Arrangement.Vertical vertical2 = (i2 & 128) != 0 ? null : vertical;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292704639, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:156)");
        }
        Object[] objArr = {lazyGridState, function2, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal2, vertical2};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i3 = 0; i3 < 7; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m614invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r18v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* JADX WARN: Type inference failed for: r2v13, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m614invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i4;
                    int i5;
                    float spacing;
                    int iM4829getMaxWidthimpl;
                    long jIntOffset;
                    int firstVisibleItemScrollOffset;
                    int lineIndexOfItem;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m187checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i4 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(paddingValues.mo431calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(paddingValues.mo432calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i6 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(paddingValues.getTop());
                    int i7 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(paddingValues.getBottom());
                    final int i8 = i6 + i7;
                    final int i9 = i4 + i5;
                    boolean z3 = z2;
                    int i10 = z3 ? i8 : i9;
                    int i11 = (!z3 || z) ? (z3 && z) ? i7 : (z3 || z) ? i5 : i4 : i6;
                    final int i12 = i10 - i11;
                    long jM4845offsetNN6EwU = ConstraintsKt.m4845offsetNN6EwU(j, -i9, -i8);
                    final LazyGridItemProvider lazyGridItemProviderInvoke = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProviderInvoke.getSpanLayoutProvider();
                    final LazyGridSlots lazyGridSlotsInvoke = function2.invoke(lazyLayoutMeasureScope, Constraints.m4817boximpl(j));
                    int length = lazyGridSlotsInvoke.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(length);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyGridState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyGridState.setSlotsPerLine$foundation_release(length);
                    if (z2) {
                        Arrangement.Vertical vertical3 = vertical2;
                        if (vertical3 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical3.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal3 = horizontal2;
                        if (horizontal3 != null) {
                            spacing = horizontal3.getSpacing();
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    final int i13 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(spacing);
                    final int itemCount = lazyGridItemProviderInvoke.getItemCount();
                    if (z2) {
                        iM4829getMaxWidthimpl = Constraints.m4828getMaxHeightimpl(j) - i8;
                    } else {
                        iM4829getMaxWidthimpl = Constraints.m4829getMaxWidthimpl(j) - i9;
                    }
                    int i14 = iM4829getMaxWidthimpl;
                    if (!z || i14 > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(i4, i6);
                    } else {
                        boolean z4 = z2;
                        if (!z4) {
                            i4 += i14;
                        }
                        if (z4) {
                            i6 += i14;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(i4, i6);
                    }
                    final long j2 = jIntOffset;
                    final boolean z5 = z2;
                    final boolean z6 = z;
                    final int i15 = i11;
                    final ?? r18 = new LazyGridMeasuredItemProvider(lazyGridItemProviderInvoke, lazyLayoutMeasureScope, i13, z5, z6, i15, i12, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$isVertical = z5;
                            this.$reverseLayout = z6;
                            this.$beforeContentPadding = i15;
                            this.$afterContentPadding = i12;
                            this.$visualItemOffset = j2;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        public LazyGridMeasuredItem createItem(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, null);
                        }
                    };
                    final boolean z7 = z2;
                    final ?? r2 = new LazyGridMeasuredLineProvider(z7, lazyGridSlotsInvoke, itemCount, i13, r18, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z7, lazyGridSlotsInvoke, itemCount, i13, r18, spanLayoutProvider);
                            this.$isVertical = z7;
                            this.$resolvedSlots = lazyGridSlotsInvoke;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    lazyGridState.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int i16) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i16);
                            int firstItemIndex = lineConfiguration.getFirstItemIndex();
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r2;
                            int size = spans.size();
                            int i17 = 0;
                            for (int i18 = 0; i18 < size; i18++) {
                                int iM599getCurrentLineSpanimpl = GridItemSpan.m599getCurrentLineSpanimpl(spans.get(i18).getPackedValue());
                                arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m4817boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m620childConstraintsJhjzzOo$foundation_release(i17, iM599getCurrentLineSpanimpl))));
                                firstItemIndex++;
                                i17 += iM599getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    });
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState2 = lazyGridState;
                    Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                        try {
                            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProviderInvoke, lazyGridState2.getFirstVisibleItemIndex());
                            if (iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release < itemCount || itemCount <= 0) {
                                int lineIndexOfItem2 = spanLayoutProvider.getLineIndexOfItem(iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                                firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
                                lineIndexOfItem = lineIndexOfItem2;
                            } else {
                                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                                firstVisibleItemScrollOffset = 0;
                            }
                            Unit unit = Unit.INSTANCE;
                            snapshotCreateNonObservableSnapshot.dispose();
                            LazyGridMeasureResult lazyGridMeasureResultM615measureLazyGridZRKPzZ8 = LazyGridMeasureKt.m615measureLazyGridZRKPzZ8(itemCount, (LazyGridMeasuredLineProvider) r2, (LazyGridMeasuredItemProvider) r18, i14, i11, i12, i13, lineIndexOfItem, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), jM4845offsetNN6EwU, z2, vertical2, horizontal2, z, lazyLayoutMeasureScope2, lazyGridState.getPlacementAnimator(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProviderInvoke, lazyGridState.getPinnedItems(), lazyGridState.getBeyondBoundsInfo()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                    Intrinsics.checkNotNullParameter(placement, "placement");
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m4843constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m4842constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), placement);
                                }
                            });
                            lazyGridState.applyMeasureResult$foundation_release(lazyGridMeasureResultM615measureLazyGridZRKPzZ8);
                            return lazyGridMeasureResultM615measureLazyGridZRKPzZ8;
                        } finally {
                            snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        }
                    } catch (Throwable th) {
                        snapshotCreateNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function22;
    }
}
