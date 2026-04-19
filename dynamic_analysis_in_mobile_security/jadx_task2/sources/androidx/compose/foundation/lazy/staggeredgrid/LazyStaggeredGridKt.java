package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyStaggeredGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridKt {
    /* JADX INFO: renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    public static final void m656LazyStaggeredGridLJWHXA8(final LazyStaggeredGridState state, final Orientation orientation, final Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> slots, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> content, Composer composer, final int i, final int i2, final int i3) {
        FlingBehavior flingBehavior2;
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1320541636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)53@2453L15,63@2869L18,65@2918L55,66@2998L218,76@3241L60,78@3307L48,84@3506L277,92@3847L172,101@4243L7,80@3361L1366:LazyStaggeredGrid.kt#fzvcnm");
        Modifier modifier2 = (i3 & 8) != 0 ? Modifier.INSTANCE : modifier;
        PaddingValues paddingValuesM473PaddingValues0680j_4 = (i3 & 16) != 0 ? PaddingKt.m473PaddingValues0680j_4(Dp.m4873constructorimpl(0)) : paddingValues;
        boolean z3 = (i3 & 32) != 0 ? false : z;
        if ((i3 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
            i4 = i & (-3670017);
        } else {
            flingBehavior2 = flingBehavior;
            i4 = i;
        }
        boolean z4 = (i3 & 128) != 0 ? true : z2;
        float fM4873constructorimpl = (i3 & 256) != 0 ? Dp.m4873constructorimpl(0) : f;
        float fM4873constructorimpl2 = (i3 & 512) != 0 ? Dp.m4873constructorimpl(0) : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1320541636, i4, i2, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
        Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(state, content, composerStartRestartGroup, ((i2 << 3) & 112) | 8);
        int i5 = i4 >> 6;
        int i6 = i4 >> 9;
        int i7 = i4;
        final boolean z5 = z3;
        final Modifier modifier3 = modifier2;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2M665rememberStaggeredGridMeasurePolicynbWgWpA = LazyStaggeredGridMeasurePolicyKt.m665rememberStaggeredGridMeasurePolicynbWgWpA(state, function0RememberStaggeredGridItemProviderLambda, paddingValuesM473PaddingValues0680j_4, z3, orientation, fM4873constructorimpl, fM4873constructorimpl2, slots, composerStartRestartGroup, (i5 & 7168) | (i5 & 896) | 8 | ((i4 << 9) & 57344) | (i6 & 458752) | (3670016 & i6) | ((i4 << 15) & 29360128));
        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(state, z5, composerStartRestartGroup, ((i7 >> 12) & 112) | 8);
        ScrollPositionUpdater(function0RememberStaggeredGridItemProviderLambda, state, composerStartRestartGroup, 64);
        int i8 = (i7 << 6) & 7168;
        Modifier modifierOverscroll = OverscrollKt.overscroll(LazyStaggeredGridBeyondBoundsModifierKt.lazyStaggeredGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState, orientation, z4, z5, composerStartRestartGroup, (i6 & 57344) | i8 | (i7 & 458752)), orientation), state, z5, orientation, composerStartRestartGroup, (i6 & 896) | 64 | i8), overscrollEffect);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda, ScrollableKt.scrollable(modifierOverscroll, state, orientation, overscrollEffect, z4, scrollableDefaults.reverseDirection((LayoutDirection) objConsume, orientation, z5), flingBehavior2, state.getMutableInteractionSource()), state.getPrefetchState(), function2M665rememberStaggeredGridMeasurePolicynbWgWpA, composerStartRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final PaddingValues paddingValues2 = paddingValuesM473PaddingValues0680j_4;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        final boolean z6 = z4;
        final float f3 = fM4873constructorimpl;
        final float f4 = fM4873constructorimpl2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
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

            public final void invoke(Composer composer2, int i9) {
                LazyStaggeredGridKt.m656LazyStaggeredGridLJWHXA8(state, orientation, slots, modifier3, paddingValues2, z5, flingBehavior3, z6, f3, f4, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0<? extends LazyLayoutItemProvider> function0, final LazyStaggeredGridState lazyStaggeredGridState, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(661612410);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyStaggeredGrid.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661612410, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:120)");
        }
        LazyLayoutItemProvider lazyLayoutItemProviderInvoke = function0.invoke();
        if (lazyLayoutItemProviderInvoke.getItemCount() > 0) {
            LazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyStaggeredGridState, lazyLayoutItemProviderInvoke, null, 2, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.ScrollPositionUpdater.1
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

            public final void invoke(Composer composer2, int i2) {
                LazyStaggeredGridKt.ScrollPositionUpdater(function0, lazyStaggeredGridState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
