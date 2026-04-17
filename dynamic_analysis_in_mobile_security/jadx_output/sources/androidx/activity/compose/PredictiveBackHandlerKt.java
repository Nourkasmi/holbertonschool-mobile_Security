package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PredictiveBackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u008a\u0084\u0002"}, d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBackHandlerKt {
    public static final void PredictiveBackHandler(boolean enabled, final Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2, Composer $composer, final int $changed, final int i) {
        final boolean enabled2;
        Object value$iv;
        boolean enabled3;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-642000585);
        ComposerKt.sourceInformation($composer2, "C(PredictiveBackHandler)77@3028L28,78@3079L24,81@3175L2013,128@5194L176,*136@5444L7,140@5632L7,142@5694L137,142@5645L186:PredictiveBackHandler.kt#q1dkbc");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            enabled2 = enabled;
        } else if (($changed & 6) == 0) {
            enabled2 = enabled;
            $dirty |= $composer2.changed(enabled2) ? 4 : 2;
        } else {
            enabled2 = enabled;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(function2) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            final boolean enabled4 = i2 != 0 ? true : enabled2;
            final State currentOnBack$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 3) & 14);
            $composer2.startReplaceableGroup(-723524056);
            ComposerKt.sourceInformation($composer2, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            $composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object value$iv$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv$iv);
            }
            $composer2.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            final CoroutineScope onBackScope = wrapper$iv.getCoroutineScope();
            $composer2.endReplaceableGroup();
            final Ref.ObjectRef onBackInstance = new Ref.ObjectRef();
            $composer2.startReplaceableGroup(-1071578855);
            ComposerKt.sourceInformation($composer2, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new OnBackPressedCallback(enabled4) { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.activity.compose.OnBackInstance] */
                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackStarted(BackEventCompat backEvent) {
                        super.handleOnBackStarted(backEvent);
                        OnBackInstance onBackInstance2 = onBackInstance.element;
                        if (onBackInstance2 != null) {
                            onBackInstance2.cancel();
                        }
                        onBackInstance.element = new OnBackInstance(onBackScope, true, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(currentOnBack$delegate));
                    }

                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackProgressed(BackEventCompat backEvent) {
                        super.handleOnBackProgressed(backEvent);
                        OnBackInstance onBackInstance2 = onBackInstance.element;
                        if (onBackInstance2 != null) {
                            ChannelResult.m7011boximpl(onBackInstance2.m6sendJP2dKIU(backEvent));
                        }
                    }

                    /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.activity.compose.OnBackInstance] */
                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackPressed() {
                        OnBackInstance $this$handleOnBackPressed_u24lambda_u240 = onBackInstance.element;
                        if ($this$handleOnBackPressed_u24lambda_u240 != null) {
                            Ref.ObjectRef<OnBackInstance> objectRef = onBackInstance;
                            if (!$this$handleOnBackPressed_u24lambda_u240.getIsPredictiveBack()) {
                                $this$handleOnBackPressed_u24lambda_u240.cancel();
                                objectRef.element = null;
                            }
                        }
                        if (onBackInstance.element == null) {
                            onBackInstance.element = new OnBackInstance(onBackScope, false, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(currentOnBack$delegate));
                        }
                        OnBackInstance onBackInstance2 = onBackInstance.element;
                        if (onBackInstance2 != null) {
                            onBackInstance2.close();
                        }
                        OnBackInstance onBackInstance3 = onBackInstance.element;
                        if (onBackInstance3 == null) {
                            return;
                        }
                        onBackInstance3.setPredictiveBack(false);
                    }

                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackCancelled() {
                        super.handleOnBackCancelled();
                        OnBackInstance onBackInstance2 = onBackInstance.element;
                        if (onBackInstance2 != null) {
                            onBackInstance2.cancel();
                        }
                        OnBackInstance onBackInstance3 = onBackInstance.element;
                        if (onBackInstance3 == null) {
                            return;
                        }
                        onBackInstance3.setPredictiveBack(false);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 backCallBack = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) value$iv;
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(Boolean.valueOf(enabled4), new AnonymousClass1(backCallBack, enabled4, onBackInstance, null), $composer2, $dirty & 14);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
            final OnBackPressedDispatcher backDispatcher = current.getOnBackPressedDispatcher();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
            $composer2.startReplaceableGroup(-1071576336);
            ComposerKt.sourceInformation($composer2, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(backDispatcher) | $composer2.changed(lifecycleOwner) | $composer2.changed(backCallBack);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
                enabled3 = enabled4;
            } else {
                enabled3 = enabled4;
                if (it$iv2 != Composer.INSTANCE.getEmpty()) {
                    value$iv2 = it$iv2;
                }
                $composer2.endReplaceableGroup();
                EffectsKt.DisposableEffect(lifecycleOwner, backDispatcher, (Function1) value$iv2, $composer2, 0);
                enabled2 = enabled3;
            }
            value$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    backDispatcher.addCallback(lifecycleOwner, backCallBack);
                    final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 = backCallBack;
                    return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            remove();
                        }
                    };
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            $composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, backDispatcher, (Function1) value$iv2, $composer2, 0);
            enabled2 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt.PredictiveBackHandler.3
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

                public final void invoke(Composer composer, int i3) {
                    PredictiveBackHandlerKt.PredictiveBackHandler(enabled2, function2, composer, $changed | 1, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1", f = "PredictiveBackHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Ref.ObjectRef<OnBackInstance> $onBackInstance;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, boolean z, Ref.ObjectRef<OnBackInstance> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$backCallBack = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
            this.$enabled = z;
            this.$onBackInstance = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$backCallBack, this.$enabled, this.$onBackInstance, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    setEnabled(this.$enabled);
                    if (!this.$enabled) {
                        OnBackInstance onBackInstance = this.$onBackInstance.element;
                        if (onBackInstance != null) {
                            Boxing.boxBoolean(onBackInstance.close());
                        }
                        this.$onBackInstance.element = null;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
