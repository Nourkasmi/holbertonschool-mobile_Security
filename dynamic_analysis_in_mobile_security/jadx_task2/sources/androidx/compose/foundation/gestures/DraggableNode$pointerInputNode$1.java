package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1", f = "Draggable.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
final class DraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableNode$pointerInputNode$1(DraggableNode draggableNode, Continuation<? super DraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, continuation);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.this$0.enabled) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {326}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, DraggableNode draggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = draggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {305, 307, 309, 316, 318, 321}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
        static final class C00071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00071(DraggableNode draggableNode, Continuation<? super C00071> continuation) {
                super(2, continuation);
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00071 c00071 = new C00071(this.this$0, continuation);
                c00071.L$0 = obj;
                return c00071;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00d2 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00d3  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[Catch: CancellationException -> 0x0112, TryCatch #0 {CancellationException -> 0x0112, blocks: (B:37:0x00d4, B:39:0x00da, B:42:0x00f6, B:44:0x00fc), top: B:58:0x00d4 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00f6 A[Catch: CancellationException -> 0x0112, TryCatch #0 {CancellationException -> 0x0112, blocks: (B:37:0x00d4, B:39:0x00da, B:42:0x00f6, B:44:0x00fc), top: B:58:0x00d4 }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0127 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0128  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x012e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010f -> B:21:0x0065). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x012a -> B:21:0x0065). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    Method dump skipped, instruction units count: 324
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00071.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1", f = "Draggable.kt", i = {0}, l = {312}, m = "invokeSuspend", n = {"$this$drag"}, s = {"L$0"})
            static final class C00081 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ DraggableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00081(Ref.ObjectRef<DragEvent> objectRef, DraggableNode draggableNode, Continuation<? super C00081> continuation) {
                    super(2, continuation);
                    this.$event = objectRef;
                    this.this$0 = draggableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00081 c00081 = new C00081(this.$event, this.this$0, continuation);
                    c00081.L$0 = obj;
                    return c00081;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                    return ((C00081) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0073 -> B:23:0x0079). Please report as a decompilation issue!!! */
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
                        androidx.compose.foundation.gestures.DragScope r3 = (androidx.compose.foundation.gestures.DragScope) r3
                        kotlin.ResultKt.throwOnFailure(r9)
                        r4 = r3
                        r3 = r1
                        r1 = r0
                        r0 = r8
                        goto L79
                    L1b:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L23:
                        kotlin.ResultKt.throwOnFailure(r9)
                        java.lang.Object r9 = r8.L$0
                        androidx.compose.foundation.gestures.DragScope r9 = (androidx.compose.foundation.gestures.DragScope) r9
                        r3 = r9
                        r9 = r8
                    L2c:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        T r1 = r1.element
                        boolean r1 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                        if (r1 != 0) goto L7f
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        T r1 = r1.element
                        boolean r1 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                        if (r1 != 0) goto L7f
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        T r1 = r1.element
                        boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                        if (r4 == 0) goto L47
                        androidx.compose.foundation.gestures.DragEvent$DragDelta r1 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r1
                        goto L48
                    L47:
                        r1 = 0
                    L48:
                        if (r1 == 0) goto L5b
                        androidx.compose.foundation.gestures.DraggableNode r4 = r9.this$0
                        long r5 = r1.getDelta()
                        androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.DraggableNode.access$getOrientation$p(r4)
                        float r1 = androidx.compose.foundation.gestures.DraggableKt.m285access$toFloat3MmeM6k(r5, r1)
                        r3.dragBy(r1)
                    L5b:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
                        androidx.compose.foundation.gestures.DraggableNode r4 = r9.this$0
                        kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.DraggableNode.access$getChannel$p(r4)
                        r5 = r9
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        r9.L$0 = r3
                        r9.L$1 = r1
                        r9.label = r2
                        java.lang.Object r4 = r4.receive(r5)
                        if (r4 != r0) goto L73
                        return r0
                    L73:
                        r7 = r0
                        r0 = r9
                        r9 = r4
                        r4 = r3
                        r3 = r1
                        r1 = r7
                    L79:
                        r3.element = r9
                        r9 = r0
                        r0 = r1
                        r3 = r4
                        goto L2c
                    L7f:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00071.C00081.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
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
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r11.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L13
                goto L5b
            L13:
                r12 = move-exception
                goto L55
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
                r4 = 0
                kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1 r1 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1
                androidx.compose.foundation.gestures.DraggableNode r3 = r11.this$0
                r9 = 0
                r1.<init>(r3, r9)
                r6 = r1
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r7 = 1
                r8 = 0
                r3 = r12
                kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                androidx.compose.ui.input.pointer.PointerInputScope r1 = r11.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L51
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2     // Catch: java.util.concurrent.CancellationException -> L51
                androidx.compose.foundation.gestures.DraggableNode r4 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> L51
                r3.<init>(r12, r4, r9)     // Catch: java.util.concurrent.CancellationException -> L51
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: java.util.concurrent.CancellationException -> L51
                r4 = r11
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.util.concurrent.CancellationException -> L51
                r11.L$0 = r12     // Catch: java.util.concurrent.CancellationException -> L51
                r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L51
                java.lang.Object r12 = r1.awaitPointerEventScope(r3, r4)     // Catch: java.util.concurrent.CancellationException -> L51
                if (r12 != r0) goto L5b
                return r0
            L51:
                r0 = move-exception
                r10 = r0
                r0 = r12
                r12 = r10
            L55:
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                if (r0 == 0) goto L5e
            L5b:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L5e:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2", f = "Draggable.kt", i = {0, 1, 1}, l = {328, 336}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "isDragSuccessful"}, s = {"L$0", "L$0", "I$0"})
        static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CoroutineScope coroutineScope, DraggableNode draggableNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$coroutineScope, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:26|(1:76)|27|28|74|29|(1:31)(7:32|72|33|(0)(0)|54|18|(2:66|67)(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x010d, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x010f, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x0110, code lost:
            
                r12 = r2;
                r2 = r15;
                r11 = r20;
                r10 = r13;
                r14 = r22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x011c, code lost:
            
                r11 = r20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x0137, code lost:
            
                r0 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0142 A[Catch: all -> 0x0143, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0143, blocks: (B:51:0x012d, B:55:0x0142), top: B:70:0x012d }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0169  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0176  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x017f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d5 -> B:72:0x00de). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0176 -> B:18:0x0052). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 386
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }
}
