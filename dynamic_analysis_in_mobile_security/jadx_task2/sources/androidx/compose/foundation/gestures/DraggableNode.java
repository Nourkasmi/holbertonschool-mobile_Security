package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÓ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012<\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a\u0012<\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a\u0012\u0006\u0010\u001e\u001a\u00020\bø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J-\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107JÙ\u0001\u00108\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2<\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a2<\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001a2\u0006\u0010\u001e\u001a\u00020\bø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0015\u00109\u001a\u00020\u0018*\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010:J\u001d\u0010;\u001a\u00020\u0018*\u00020\u00122\u0006\u0010<\u001a\u00020=H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u0018*\u00020\u00122\u0006\u0010<\u001a\u00020@H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010\u0010\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010'RL\u0010\u001b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011¢\u0006\u0002\b\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "Lkotlin/Function0;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "_canDrag", "_startDragImmediately", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "Lkotlin/jvm/functions/Function3;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "disposeInteractionSource", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "update", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DraggableNode extends DelegatingNode implements PointerInputModifierNode {
    private final Function1<PointerInputChange, Boolean> _canDrag;
    private final Function0<Boolean> _startDragImmediately;
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private final Channel<DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private Orientation orientation;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean reverseDirection;
    private Function0<Boolean> startDragImmediately;
    private DraggableState state;
    private final VelocityTracker velocityTracker;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", i = {0, 0}, l = {451, 454}, m = "processDragCancel", n = {"this", "$this$processDragCancel"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableNode.this.processDragCancel(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {433, 436, 438}, m = "processDragStart", n = {"this", "$this$processDragStart", NotificationCompat.CATEGORY_EVENT, "this", "$this$processDragStart", NotificationCompat.CATEGORY_EVENT, "interaction"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C01551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C01551(Continuation<? super C01551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableNode.this.processDragStart(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", i = {0, 0, 0}, l = {443, 446}, m = "processDragStop", n = {"this", "$this$processDragStop", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1", "L$2"})
    static final class C01561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01561(Continuation<? super C01561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableNode.this.processDragStop(null, null, this);
        }
    }

    public DraggableNode(DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean z2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        this.state = state;
        this.canDrag = canDrag;
        this.orientation = orientation;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.reverseDirection = z2;
        this._canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableNode$_canDrag$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (Boolean) this.this$0.canDrag.invoke(it);
            }
        };
        this._startDragImmediately = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableNode$_startDragImmediately$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return (Boolean) this.this$0.startDragImmediately.invoke();
            }
        };
        this.velocityTracker = new VelocityTracker();
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DraggableNode$pointerInputNode$1(this, null)));
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo142onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.pointerInputNode.mo142onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    public final void update(DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, Function0<Boolean> startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        boolean z;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        boolean z2 = true;
        if (Intrinsics.areEqual(this.state, state)) {
            z = false;
        } else {
            this.state = state;
            z = true;
        }
        this.canDrag = canDrag;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
            }
        } else {
            z2 = z;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else if (!z2) {
            return;
        }
        this.pointerInputNode.resetPointerInputHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStart(kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStarted r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DraggableNode.C01551
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DraggableNode.C01551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStart$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L60
            if (r2 == r5) goto L4d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc3
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            java.lang.Object r9 = r0.L$3
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.gestures.DraggableNode r4 = (androidx.compose.foundation.gestures.DraggableNode) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto La2
        L4d:
            java.lang.Object r9 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r9 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DraggableNode r2 = (androidx.compose.foundation.gestures.DraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L82
        L60:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = r8.dragInteraction
            if (r11 == 0) goto L81
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L81
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r11)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L81
            return r1
        L81:
            r2 = r8
        L82:
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r11.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            if (r5 == 0) goto La5
            r6 = r11
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r4
            java.lang.Object r4 = r5.emit(r6, r0)
            if (r4 != r1) goto L9f
            return r1
        L9f:
            r4 = r2
            r2 = r9
            r9 = r11
        La2:
            r11 = r9
            r9 = r2
            r2 = r4
        La5:
            r2.dragInteraction = r11
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.geometry.Offset, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r11 = r2.onDragStarted
            long r4 = r10.getStartPoint()
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m2379boximpl(r4)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r9 = r11.invoke(r9, r10, r0)
            if (r9 != r1) goto Lc3
            return r1
        Lc3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragStart(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStop(kotlinx.coroutines.CoroutineScope r10, androidx.compose.foundation.gestures.DragEvent.DragStopped r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DraggableNode.C01561
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DraggableNode.C01561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStop$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L88
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            java.lang.Object r10 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStopped r10 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r10
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DraggableNode r2 = (androidx.compose.foundation.gestures.DraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L6b
        L49:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.foundation.interaction.DragInteraction$Start r12 = r9.dragInteraction
            if (r12 == 0) goto L6e
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r9.interactionSource
            if (r2 == 0) goto L6a
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r12)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r12 = r2.emit(r6, r0)
            if (r12 != r1) goto L6a
            return r1
        L6a:
            r2 = r9
        L6b:
            r2.dragInteraction = r5
            goto L6f
        L6e:
            r2 = r9
        L6f:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r12 = r2.onDragStopped
            long r6 = r11.getVelocity()
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m5089boximpl(r6)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r10 = r12.invoke(r10, r11, r0)
            if (r10 != r1) goto L88
            return r1
        L88:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragStop(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragCancel(kotlinx.coroutines.CoroutineScope r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DraggableNode.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DraggableNode.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7f
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DraggableNode r2 = (androidx.compose.foundation.gestures.DraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L62
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = r8.dragInteraction
            if (r10 == 0) goto L65
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L61
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r2.emit(r6, r0)
            if (r10 != r1) goto L61
            return r1
        L61:
            r2 = r8
        L62:
            r2.dragInteraction = r5
            goto L66
        L65:
            r2 = r8
        L66:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10 = r2.onDragStopped
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r6 = r2.m5109getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m5089boximpl(r6)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r10.invoke(r9, r2, r0)
            if (r9 != r1) goto L7f
            return r1
        L7f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.processDragCancel(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }
}
