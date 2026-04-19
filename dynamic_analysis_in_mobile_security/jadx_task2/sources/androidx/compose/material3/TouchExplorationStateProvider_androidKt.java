package androidx.compose.material3;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchExplorationStateProvider.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0003\u001a7\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"touchExplorationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "ObserveState", "", "Landroidx/lifecycle/Lifecycle;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TouchExplorationStateProvider_androidKt {
    public static final State<Boolean> touchExplorationState(Composer composer, int i) {
        composer.startReplaceableGroup(-906157724);
        ComposerKt.sourceInformation(composer, "C(touchExplorationState)41@1687L7,42@1726L104,46@1851L23,48@1900L7,48@1918L273,59@2204L52:TouchExplorationStateProvider.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-906157724, i, -1, "androidx.compose.material3.touchExplorationState (TouchExplorationStateProvider.android.kt:40)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object systemService = context.getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            objRememberedValue = (AccessibilityManager) systemService;
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        final AccessibilityManager accessibilityManager = (AccessibilityManager) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Listener();
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        final Listener listener = (Listener) objRememberedValue2;
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ObserveState(((LifecycleOwner) objConsume2).getLifecycle(), new Function1<Lifecycle.Event, Unit>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.touchExplorationState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Lifecycle.Event event) {
                invoke2(event);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_RESUME) {
                    listener.register(accessibilityManager);
                }
            }
        }, new Function0<Unit>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.touchExplorationState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                listener.unregister(accessibilityManager);
            }
        }, composer, 8, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(listener.isEnabled());
                }
            });
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        State<Boolean> state = (State) objRememberedValue3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ObserveState(final Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1703772404);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ObserveState)67@2396L288:TouchExplorationStateProvider.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            function1 = new Function1<Lifecycle.Event, Unit>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.ObserveState.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Lifecycle.Event it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Lifecycle.Event event) {
                    invoke2(event);
                    return Unit.INSTANCE;
                }
            };
        }
        final Function1<? super Lifecycle.Event, Unit> function12 = function1;
        if ((i2 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.ObserveState.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        final Function0<Unit> function02 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703772404, i, -1, "androidx.compose.material3.ObserveState (TouchExplorationStateProvider.android.kt:63)");
        }
        EffectsKt.DisposableEffect(lifecycle, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.ObserveState.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final Function1<Lifecycle.Event, Unit> function13 = function12;
                final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$observer$1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(event, "event");
                        function13.invoke(event);
                    }
                };
                lifecycle.addObserver(lifecycleEventObserver);
                final Function0<Unit> function03 = function02;
                final Lifecycle lifecycle2 = lifecycle;
                return new DisposableEffectResult() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        function03.invoke();
                        lifecycle2.removeObserver(lifecycleEventObserver);
                    }
                };
            }
        }, composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt.ObserveState.4
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
                TouchExplorationStateProvider_androidKt.ObserveState(lifecycle, function12, function02, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
