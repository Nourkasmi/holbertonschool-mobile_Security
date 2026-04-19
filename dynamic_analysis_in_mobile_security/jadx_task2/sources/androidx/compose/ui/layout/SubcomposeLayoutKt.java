package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "intermediateMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "measurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubcomposeLayoutKt {
    public static final void SubcomposeLayout(final Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeLayout)P(1)77@3566L36,76@3532L144:SubcomposeLayout.kt#80mrfh");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(measurePolicy) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:72)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SubcomposeLayoutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue;
            int i5 = i3 << 3;
            SubcomposeLayout(subcomposeLayoutState, modifier, measurePolicy, composerStartRestartGroup, (i5 & 112) | 8 | (i5 & 896), 0);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.2
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

            public final void invoke(Composer composer2, int i6) {
                SubcomposeLayoutKt.SubcomposeLayout(modifier, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(159215138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeLayout)P(2)139@6954L36,138@6920L207:SubcomposeLayout.kt#80mrfh");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(measurePolicy) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                function2 = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                        return m3959invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m3959invoke0kLqBqw(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeIntermediateMeasureScope, "$this$null");
                        return subcomposeIntermediateMeasureScope.getLookaheadMeasurePolicy().invoke(subcomposeIntermediateMeasureScope, Constraints.m4817boximpl(j));
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159215138, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:130)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SubcomposeLayoutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue;
            int i6 = i3 << 3;
            SubcomposeLayout(subcomposeLayoutState, modifier, function2, measurePolicy, composerStartRestartGroup, (i6 & 112) | 8 | (i6 & 896) | (i6 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function22 = function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.5
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

            public final void invoke(Composer composer2, int i7) {
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, function22, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState state, Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(-511989831);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeLayout)P(2,1)260@13431L80:SubcomposeLayout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511989831, i, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:254)");
        }
        SubcomposeLayout(state, modifier, new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                return m3960invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final MeasureResult m3960invoke0kLqBqw(SubcomposeIntermediateMeasureScope SubcomposeLayout, long j) {
                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                return SubcomposeLayout.getLookaheadMeasurePolicy().invoke(SubcomposeLayout, Constraints.m4817boximpl(j));
            }
        }, measurePolicy, composerStartRestartGroup, (i & 112) | 392 | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = modifier;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.7
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
                SubcomposeLayoutKt.SubcomposeLayout(state, modifier2, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState state, Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(2129414763);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeLayout)P(3,2)319@16791L23,320@16844L28,323@17000L604,344@17744L27,345@17799L89,345@17776L112:SubcomposeLayout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if ((i2 & 4) != 0) {
            function2 = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                    return m3961invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final MeasureResult m3961invoke0kLqBqw(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, long j) {
                    Intrinsics.checkNotNullParameter(subcomposeIntermediateMeasureScope, "$this$null");
                    return subcomposeIntermediateMeasureScope.getLookaheadMeasurePolicy().invoke(subcomposeIntermediateMeasureScope, Constraints.m4817boximpl(j));
                }
            };
        }
        final Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function22 = function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2129414763, i, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:310)");
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        final Function0<LayoutNode> constructor$ui_release = LayoutNode.INSTANCE.getConstructor$ui_release();
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    return constructor$ui_release.invoke();
                }
            });
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
        Updater.m2270setimpl(composerM2263constructorimpl, state, state.getSetRoot$ui_release());
        Updater.m2270setimpl(composerM2263constructorimpl, compositionContextRememberCompositionContext, state.getSetCompositionContext$ui_release());
        Updater.m2270setimpl(composerM2263constructorimpl, measurePolicy, state.getSetMeasurePolicy$ui_release());
        Updater.m2270setimpl(composerM2263constructorimpl, function22, state.getSetIntermediateMeasurePolicy$ui_release());
        Updater.m2270setimpl(composerM2263constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m2270setimpl(composerM2263constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM2263constructorimpl.getInserting() || !Intrinsics.areEqual(composerM2263constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2263constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2263constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-607836798);
        ComposerKt.sourceInformation(composerStartRestartGroup, "340@17650L65");
        if (!composerStartRestartGroup.getSkipping()) {
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.10
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    state.forceRecomposeChildren$ui_release();
                }
            }, composerStartRestartGroup, 0);
        }
        composerStartRestartGroup.endReplaceableGroup();
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(state, composerStartRestartGroup, 8);
        Unit unit = Unit.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final State<SubcomposeLayoutState> state2 = stateRememberUpdatedState;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            ((SubcomposeLayoutState) state2.getValue()).disposeCurrentNodes$ui_release();
                        }
                    };
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout.12
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
                SubcomposeLayoutKt.SubcomposeLayout(state, modifier2, function22, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int i) {
        return new FixedCountSubcomposeSlotReusePolicy(i);
    }
}
