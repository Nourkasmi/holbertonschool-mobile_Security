package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1", f = "Scrollable.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
final class MouseWheelScrollNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MouseWheelScrollNode$pointerInputNode$1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super MouseWheelScrollNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this.this$0, continuation);
        mouseWheelScrollNode$pointerInputNode$1.L$0 = obj;
        return mouseWheelScrollNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1", f = "Scrollable.kt", i = {0}, l = {338}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MouseWheelScrollNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mouseWheelScrollNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        
            r4 = r0.this$0.getMouseWheelScrollConfig();
            r5 = r0.this$0;
            r7 = r4.mo243calculateMouseWheelScroll8xgXZGE(r3, r12, r3.mo3662getSizeYbymL2g());
            r4 = r5.getScrollingLogicState().getValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
        
            if (r4.getScrollableState().dispatchRawDelta(r4.reverseIfNeeded(r4.m343toFloatk4lQ0M(r7))) != 0.0f) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
        
            r12 = r12.getChanges();
            r4 = r12.size();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
        
            if (r6 >= r4) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
        
            r12.get(r6).consume();
            r6 = r6 + 1;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0059 A[EDGE_INSN: B:27:0x0059->B:19:0x0059 BREAK  A[LOOP:0: B:14:0x0046->B:18:0x0056], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:13:0x003a). Please report as a decompilation issue!!! */
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
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r3 = r1
                r1 = r0
                r0 = r11
                goto L3a
            L16:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                r1 = r12
                r12 = r11
            L27:
                r3 = r12
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r12.L$0 = r1
                r12.label = r2
                java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r1, r3)
                if (r3 != r0) goto L35
                return r0
            L35:
                r10 = r0
                r0 = r12
                r12 = r3
                r3 = r1
                r1 = r10
            L3a:
                androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                java.util.List r4 = r12.getChanges()
                int r5 = r4.size()
                r6 = 0
                r7 = r6
            L46:
                if (r7 >= r5) goto L59
                java.lang.Object r8 = r4.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                boolean r8 = r8.isConsumed()
                r8 = r8 ^ r2
                if (r8 != 0) goto L56
                goto La2
            L56:
                int r7 = r7 + 1
                goto L46
            L59:
                androidx.compose.foundation.gestures.MouseWheelScrollNode r4 = r0.this$0
                androidx.compose.foundation.gestures.ScrollConfig r4 = r4.getMouseWheelScrollConfig()
                androidx.compose.foundation.gestures.MouseWheelScrollNode r5 = r0.this$0
                r7 = r3
                androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
                long r8 = r3.mo3662getSizeYbymL2g()
                long r7 = r4.mo243calculateMouseWheelScroll8xgXZGE(r7, r12, r8)
                androidx.compose.runtime.State r4 = r5.getScrollingLogicState()
                java.lang.Object r4 = r4.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
                float r5 = r4.m343toFloatk4lQ0M(r7)
                float r5 = r4.reverseIfNeeded(r5)
                androidx.compose.foundation.gestures.ScrollableState r4 = r4.getScrollableState()
                float r4 = r4.dispatchRawDelta(r5)
                r5 = 0
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L8c
                goto La2
            L8c:
                java.util.List r12 = r12.getChanges()
                int r4 = r12.size()
            L94:
                if (r6 >= r4) goto La2
                java.lang.Object r5 = r12.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                r5.consume()
                int r6 = r6 + 1
                goto L94
            La2:
                r12 = r0
                r0 = r1
                r1 = r3
                goto L27
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
}
