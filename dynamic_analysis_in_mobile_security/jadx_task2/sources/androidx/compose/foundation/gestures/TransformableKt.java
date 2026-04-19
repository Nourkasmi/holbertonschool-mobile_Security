package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a6\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransformableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {169, 171, 215}, m = "detectZoom", n = {"$this$detectZoom", "panZoomLock", "channel", "canPan", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "panZoomLock", "channel", "canPan", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "panZoomLock", "channel", "canPan", NotificationCompat.CATEGORY_EVENT, "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, null, null, null, this);
        }
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState state, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return transformable(modifier, state, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt.transformable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function0 function0, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function0, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ad, code lost:
    
        if (r5 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02af, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02b4 A[EDGE_INSN: B:100:0x02b4->B:89:0x02b4 BREAK  A[LOOP:0: B:83:0x029f->B:88:0x02b1], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0281 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0282 -> B:82:0x0292). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r29, androidx.compose.runtime.State<java.lang.Boolean> r30, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r31, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instruction units count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, kotlinx.coroutines.channels.Channel, androidx.compose.runtime.State, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Modifier transformable(Modifier modifier, final TransformableState state, final Function0<Boolean> canPan, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canPan, "canPan");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("transformable");
                inspectorInfo.getProperties().set("state", state);
                inspectorInfo.getProperties().set("canPan", canPan);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.TransformableKt.transformable.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(298661433);
                ComposerKt.sourceInformation(composer, "C98@4744L43,99@4816L28,100@4867L66,121@5860L524:Transformable.kt#8bwon0");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(298661433, i, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:97)");
                }
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composer, 0);
                State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(canPan, composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                Channel channel = (Channel) objRememberedValue;
                composer.startReplaceableGroup(-2015615917);
                ComposerKt.sourceInformation(composer, "102@4969L822");
                if (z2) {
                    EffectsKt.LaunchedEffect(state, new AnonymousClass1(channel, state, null), composer, 64);
                }
                composer.endReplaceableGroup();
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                TransformableKt$transformable$3$block$1$1 transformableKt$transformable$3$block$1$1RememberedValue = composer.rememberedValue();
                if (transformableKt$transformable$3$block$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transformableKt$transformable$3$block$1$1RememberedValue = new TransformableKt$transformable$3$block$1$1(stateRememberUpdatedState, channel, stateRememberUpdatedState2, null);
                    composer.updateRememberedValue(transformableKt$transformable$3$block$1$1RememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier.Companion companionPointerInput = z2 ? SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, channel, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) transformableKt$transformable$3$block$1$1RememberedValue) : Modifier.INSTANCE;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return companionPointerInput;
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1", f = "Transformable.kt", i = {0, 0, 1}, l = {105, 108}, m = "invokeSuspend", n = {"$this$LaunchedEffect", NotificationCompat.CATEGORY_EVENT, "$this$LaunchedEffect"}, s = {"L$0", "L$1", "L$0"})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Channel<TransformEvent> $channel;
                final /* synthetic */ TransformableState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Channel<TransformEvent> channel, TransformableState transformableState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$channel = channel;
                    this.$state = transformableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channel, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Transformable.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1", f = "Transformable.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"$this$transform"}, s = {"L$0"})
                static final class C00151 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Channel<TransformEvent> $channel;
                    final /* synthetic */ Ref.ObjectRef<TransformEvent> $event;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00151(Ref.ObjectRef<TransformEvent> objectRef, Channel<TransformEvent> channel, Continuation<? super C00151> continuation) {
                        super(2, continuation);
                        this.$event = objectRef;
                        this.$channel = channel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00151 c00151 = new C00151(this.$event, this.$channel, continuation);
                        c00151.L$0 = obj;
                        return c00151;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
                        return ((C00151) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x006b). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                        /*
                            r8 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r8.label
                            r2 = 1
                            if (r1 == 0) goto L23
                            if (r1 != r2) goto L1b
                            java.lang.Object r1 = r8.L$1
                            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                            java.lang.Object r3 = r8.L$0
                            androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                            kotlin.ResultKt.throwOnFailure(r9)
                            r4 = r3
                            r3 = r1
                            r1 = r0
                            r0 = r8
                            goto L6b
                        L1b:
                            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r9.<init>(r0)
                            throw r9
                        L23:
                            kotlin.ResultKt.throwOnFailure(r9)
                            java.lang.Object r9 = r8.L$0
                            androidx.compose.foundation.gestures.TransformScope r9 = (androidx.compose.foundation.gestures.TransformScope) r9
                            r3 = r9
                            r9 = r8
                        L2c:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r1 = r9.$event
                            T r1 = r1.element
                            boolean r1 = r1 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                            if (r1 != 0) goto L71
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r1 = r9.$event
                            T r1 = r1.element
                            boolean r4 = r1 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                            if (r4 == 0) goto L3f
                            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r1 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r1
                            goto L40
                        L3f:
                            r1 = 0
                        L40:
                            if (r1 == 0) goto L51
                            float r4 = r1.getZoomChange()
                            long r5 = r1.getPanChange()
                            float r1 = r1.getRotationChange()
                            r3.mo251transformByd4ec7I(r4, r5, r1)
                        L51:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r1 = r9.$event
                            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r4 = r9.$channel
                            r5 = r9
                            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                            r9.L$0 = r3
                            r9.L$1 = r1
                            r9.label = r2
                            java.lang.Object r4 = r4.receive(r5)
                            if (r4 != r0) goto L65
                            return r0
                        L65:
                            r7 = r0
                            r0 = r9
                            r9 = r4
                            r4 = r3
                            r3 = r1
                            r1 = r7
                        L6b:
                            r3.element = r9
                            r9 = r0
                            r0 = r1
                            r3 = r4
                            goto L2c
                        L71:
                            kotlin.Unit r9 = kotlin.Unit.INSTANCE
                            return r9
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass3.AnonymousClass1.C00151.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0086 -> B:14:0x0039). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                    /*
                        r11 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r11.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L31
                        if (r1 == r3) goto L1f
                        if (r1 != r2) goto L17
                        java.lang.Object r1 = r11.L$0
                        kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                        kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L15
                    L15:
                        r12 = r1
                        goto L38
                    L17:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    L1f:
                        java.lang.Object r1 = r11.L$2
                        kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                        java.lang.Object r4 = r11.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                        java.lang.Object r5 = r11.L$0
                        kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                        kotlin.ResultKt.throwOnFailure(r12)
                        r6 = r4
                        r4 = r11
                        goto L5e
                    L31:
                        kotlin.ResultKt.throwOnFailure(r12)
                        java.lang.Object r12 = r11.L$0
                        kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
                    L38:
                        r1 = r11
                    L39:
                        boolean r4 = kotlinx.coroutines.CoroutineScopeKt.isActive(r12)
                        if (r4 == 0) goto L89
                        kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
                        r4.<init>()
                        kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r5 = r1.$channel
                        r6 = r1
                        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                        r1.L$0 = r12
                        r1.L$1 = r4
                        r1.L$2 = r4
                        r1.label = r3
                        java.lang.Object r5 = r5.receive(r6)
                        if (r5 != r0) goto L58
                        return r0
                    L58:
                        r6 = r4
                        r4 = r1
                        r1 = r6
                        r10 = r5
                        r5 = r12
                        r12 = r10
                    L5e:
                        r1.element = r12
                        T r12 = r6.element
                        boolean r12 = r12 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                        if (r12 == 0) goto L86
                        androidx.compose.foundation.gestures.TransformableState r12 = r4.$state     // Catch: java.util.concurrent.CancellationException -> L86
                        androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.UserInput     // Catch: java.util.concurrent.CancellationException -> L86
                        androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1 r7 = new androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1     // Catch: java.util.concurrent.CancellationException -> L86
                        kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r8 = r4.$channel     // Catch: java.util.concurrent.CancellationException -> L86
                        r9 = 0
                        r7.<init>(r6, r8, r9)     // Catch: java.util.concurrent.CancellationException -> L86
                        kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.util.concurrent.CancellationException -> L86
                        r6 = r4
                        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.util.concurrent.CancellationException -> L86
                        r4.L$0 = r5     // Catch: java.util.concurrent.CancellationException -> L86
                        r4.L$1 = r9     // Catch: java.util.concurrent.CancellationException -> L86
                        r4.L$2 = r9     // Catch: java.util.concurrent.CancellationException -> L86
                        r4.label = r2     // Catch: java.util.concurrent.CancellationException -> L86
                        java.lang.Object r12 = r12.transform(r1, r7, r6)     // Catch: java.util.concurrent.CancellationException -> L86
                        if (r12 != r0) goto L86
                        return r0
                    L86:
                        r1 = r4
                        r12 = r5
                        goto L39
                    L89:
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        });
    }
}
