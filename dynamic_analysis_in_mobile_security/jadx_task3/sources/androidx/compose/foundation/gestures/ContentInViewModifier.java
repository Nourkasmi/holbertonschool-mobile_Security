package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: ContentInViewModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020&H\u0002J%\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u001dH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J \u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002J%\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\"\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0082\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\"\u0010;\u001a\u00020<*\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH\u0082\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010@J#\u0010B\u001a\u00020\u000b*\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\u00020\u001dX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "animationState", "Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChild", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "trackingFocusedChild", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationDistance", "leadingEdge", "trailingEdge", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    private final UpdatableAnimationState animationState;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private LayoutCoordinates coordinates;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private final Modifier modifier;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final CoroutineScope scope;
    private final ScrollableState scrollState;
    private boolean trackingFocusedChild;
    private long viewportSize;

    /* JADX INFO: compiled from: ContentInViewModifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(CoroutineScope scope, Orientation orientation, ScrollableState scrollState, boolean reverseDirection) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollState = scrollState;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = IntSize.INSTANCE.m5377getZeroYbymL2g();
        this.animationState = new UpdatableAnimationState();
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                this.this$0.focusedChild = it;
            }
        }), this);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        if (!(!IntSize.m5370equalsimpl0(this.viewportSize, IntSize.INSTANCE.m5377getZeroYbymL2g()))) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m247computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect rectInvoke = function0.invoke();
        boolean z = false;
        if (rectInvoke != null && !m249isMaxVisibleO0kMr_c$default(this, rectInvoke, 0L, 1, null)) {
            z = true;
        }
        if (!z) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        Request request = new Request(function0, continuation2);
        if (this.bringIntoViewRequests.enqueue(request) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo251onRemeasuredozmzZPI(long size) {
        Rect focusedChild;
        long oldSize = this.viewportSize;
        this.viewportSize = size;
        if (m245compareToTemP2vQ(size, oldSize) < 0 && (focusedChild = getFocusedChildBounds()) != null) {
            Rect previousFocusedChildBounds = this.focusedChildBoundsFromPreviousRemeasure;
            if (previousFocusedChildBounds == null) {
                previousFocusedChildBounds = focusedChild;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m248isMaxVisibleO0kMr_c(previousFocusedChildBounds, oldSize) && !m248isMaxVisibleO0kMr_c(focusedChild, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        LayoutCoordinates it;
        LayoutCoordinates coordinates = this.coordinates;
        if (coordinates != null) {
            if (!coordinates.isAttached()) {
                coordinates = null;
            }
            if (coordinates != null && (it = this.focusedChild) != null) {
                if (!it.isAttached()) {
                    it = null;
                }
                if (it != null) {
                    LayoutCoordinates focusedChild = it;
                    return coordinates.localBoundingBoxOf(focusedChild, false);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        if (!this.isAnimationRunning) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(null), 1, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentInViewModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ContentInViewModifier.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 anonymousClass1;
            CancellationException cancellationException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    Job animationJob = JobKt.getJob($this$launch.getCoroutineContext());
                    try {
                        ContentInViewModifier.this.isAnimationRunning = true;
                        this.label = 1;
                        if (ScrollableState.scroll$default(ContentInViewModifier.this.scrollState, null, new C00041(ContentInViewModifier.this, animationJob, null), this, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1 = this;
                        cancellationException = null;
                        ContentInViewModifier.this.bringIntoViewRequests.resumeAndRemoveAll();
                        ContentInViewModifier.this.isAnimationRunning = false;
                        ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewModifier.this.trackingFocusedChild = false;
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        e = e;
                        anonymousClass1 = this;
                        cancellationException = e;
                        throw e;
                    } catch (Throwable th) {
                        e = th;
                        anonymousClass1 = this;
                        cancellationException = null;
                        ContentInViewModifier.this.isAnimationRunning = false;
                        ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewModifier.this.trackingFocusedChild = false;
                        throw e;
                    }
                case 1:
                    anonymousClass1 = this;
                    cancellationException = null;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            ContentInViewModifier.this.bringIntoViewRequests.resumeAndRemoveAll();
                            ContentInViewModifier.this.isAnimationRunning = false;
                            ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                            ContentInViewModifier.this.trackingFocusedChild = false;
                            return Unit.INSTANCE;
                        } catch (CancellationException e2) {
                            e = e2;
                            cancellationException = e;
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        ContentInViewModifier.this.isAnimationRunning = false;
                        ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewModifier.this.trackingFocusedChild = false;
                        throw e;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ContentInViewModifier.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1", f = "ContentInViewModifier.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
        static final class C00041 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $animationJob;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewModifier this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00041(ContentInViewModifier contentInViewModifier, Job job, Continuation<? super C00041> continuation) {
                super(2, continuation);
                this.this$0 = contentInViewModifier;
                this.$animationJob = job;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00041 c00041 = new C00041(this.this$0, this.$animationJob, continuation);
                c00041.L$0 = obj;
                return c00041;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
                return ((C00041) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                        this.this$0.animationState.setValue(this.this$0.calculateScrollDelta());
                        UpdatableAnimationState updatableAnimationState = this.this$0.animationState;
                        final ContentInViewModifier contentInViewModifier = this.this$0;
                        final Job job = this.$animationJob;
                        Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float delta) {
                                float scrollMultiplier = contentInViewModifier.reverseDirection ? 1.0f : -1.0f;
                                float adjustedDelta = scrollMultiplier * delta;
                                float consumedScroll = $this$scroll.scrollBy(adjustedDelta) * scrollMultiplier;
                                if (consumedScroll < delta) {
                                    JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + consumedScroll + " < " + delta + ')', null, 2, null);
                                }
                            }
                        };
                        final ContentInViewModifier contentInViewModifier2 = this.this$0;
                        this.label = 1;
                        if (updatableAnimationState.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.2
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
                                BringIntoViewRequestPriorityQueue this_$iv = contentInViewModifier2.bringIntoViewRequests;
                                ContentInViewModifier contentInViewModifier3 = contentInViewModifier2;
                                while (true) {
                                    if (!this_$iv.requests.isNotEmpty()) {
                                        break;
                                    }
                                    Rect bounds = ((Request) this_$iv.requests.last()).getCurrentBounds().invoke();
                                    if (!(bounds == null ? true : ContentInViewModifier.m249isMaxVisibleO0kMr_c$default(contentInViewModifier3, bounds, 0L, 1, null))) {
                                        break;
                                    }
                                    MutableVector mutableVector = this_$iv.requests;
                                    MutableVector this_$iv$iv = this_$iv.requests;
                                    CancellableContinuation<Unit> continuation = ((Request) mutableVector.removeAt(this_$iv$iv.getSize() - 1)).getContinuation();
                                    Unit unit = Unit.INSTANCE;
                                    Result.Companion companion = Result.INSTANCE;
                                    continuation.resumeWith(Result.m5499constructorimpl(unit));
                                }
                                if (contentInViewModifier2.trackingFocusedChild) {
                                    Rect focusedChildBounds = contentInViewModifier2.getFocusedChildBounds();
                                    if (focusedChildBounds != null && ContentInViewModifier.m249isMaxVisibleO0kMr_c$default(contentInViewModifier2, focusedChildBounds, 0L, 1, null)) {
                                        contentInViewModifier2.trackingFocusedChild = false;
                                    }
                                }
                                contentInViewModifier2.animationState.setValue(contentInViewModifier2.calculateScrollDelta());
                            }
                        }, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta() {
        if (IntSize.m5370equalsimpl0(this.viewportSize, IntSize.INSTANCE.m5377getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectangleToMakeVisible = findBringIntoViewRequest();
        if (rectangleToMakeVisible == null) {
            rectangleToMakeVisible = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectangleToMakeVisible == null) {
                return 0.0f;
            }
        }
        long size = IntSizeKt.m5382toSizeozmzZPI(this.viewportSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return relocationDistance(rectangleToMakeVisible.getTop(), rectangleToMakeVisible.getBottom(), Size.m2774getHeightimpl(size));
            case 2:
                return relocationDistance(rectangleToMakeVisible.getLeft(), rectangleToMakeVisible.getRight(), Size.m2777getWidthimpl(size));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Rect findBringIntoViewRequest() {
        BringIntoViewRequestPriorityQueue this_$iv;
        int $i$f$forEachFromSmallest;
        Rect rect = null;
        BringIntoViewRequestPriorityQueue this_$iv2 = this.bringIntoViewRequests;
        int $i$f$forEachFromSmallest2 = 0;
        MutableVector this_$iv$iv = this_$iv2.requests;
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = size$iv$iv - 1;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            while (true) {
                Request it$iv = (Request) content$iv$iv[i$iv$iv];
                Rect bounds = it$iv.getCurrentBounds().invoke();
                if (bounds != null) {
                    this_$iv = this_$iv2;
                    $i$f$forEachFromSmallest = $i$f$forEachFromSmallest2;
                    if (m246compareToiLBOSCw(bounds.m2741getSizeNHjbRc(), IntSizeKt.m5382toSizeozmzZPI(this.viewportSize)) <= 0) {
                        rect = bounds;
                    } else {
                        return rect;
                    }
                } else {
                    this_$iv = this_$iv2;
                    $i$f$forEachFromSmallest = $i$f$forEachFromSmallest2;
                }
                i$iv$iv--;
                if (i$iv$iv < 0) {
                    break;
                }
                this_$iv2 = this_$iv;
                $i$f$forEachFromSmallest2 = $i$f$forEachFromSmallest;
            }
        }
        return rect;
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m247computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m2745translatek4lQ0M(Offset.m2717unaryMinusF1C5BW0(m250relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    static /* synthetic */ boolean m249isMaxVisibleO0kMr_c$default(ContentInViewModifier contentInViewModifier, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewModifier.viewportSize;
        }
        return contentInViewModifier.m248isMaxVisibleO0kMr_c(rect, j);
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m248isMaxVisibleO0kMr_c(Rect $this$isMaxVisible_u2dO0kMr_c, long size) {
        return Offset.m2705equalsimpl0(m250relocationOffsetBMxPBkI($this$isMaxVisible_u2dO0kMr_c, size), Offset.INSTANCE.m2724getZeroF1C5BW0());
    }

    /* JADX INFO: renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m250relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long size = IntSizeKt.m5382toSizeozmzZPI(containerSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return OffsetKt.Offset(0.0f, relocationDistance(childBounds.getTop(), childBounds.getBottom(), Size.m2774getHeightimpl(size)));
            case 2:
                return OffsetKt.Offset(relocationDistance(childBounds.getLeft(), childBounds.getRight(), Size.m2777getWidthimpl(size)), 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final float relocationDistance(float leadingEdge, float trailingEdge, float containerSize) {
        if (leadingEdge >= 0.0f && trailingEdge <= containerSize) {
            return 0.0f;
        }
        if (leadingEdge >= 0.0f || trailingEdge <= containerSize) {
            return Math.abs(leadingEdge) < Math.abs(trailingEdge - containerSize) ? leadingEdge : trailingEdge - containerSize;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m245compareToTemP2vQ(long $this$compareTo_u2dTemP2vQ, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Intrinsics.compare(IntSize.m5371getHeightimpl($this$compareTo_u2dTemP2vQ), IntSize.m5371getHeightimpl(other));
            case 2:
                return Intrinsics.compare(IntSize.m5372getWidthimpl($this$compareTo_u2dTemP2vQ), IntSize.m5372getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m246compareToiLBOSCw(long $this$compareTo_u2diLBOSCw, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Float.compare(Size.m2774getHeightimpl($this$compareTo_u2diLBOSCw), Size.m2774getHeightimpl(other));
            case 2:
                return Float.compare(Size.m2777getWidthimpl($this$compareTo_u2diLBOSCw), Size.m2777getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: ContentInViewModifier.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Request {
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> currentBounds, CancellableContinuation<? super Unit> continuation) {
            Intrinsics.checkNotNullParameter(currentBounds, "currentBounds");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.currentBounds = currentBounds;
            this.continuation = continuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r6.continuation
                kotlin.coroutines.CoroutineContext r0 = r0.get$context()
                kotlinx.coroutines.CoroutineName$Key r1 = kotlinx.coroutines.CoroutineName.INSTANCE
                kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.CoroutineName r0 = (kotlinx.coroutines.CoroutineName) r0
                if (r0 == 0) goto L17
                java.lang.String r0 = r0.getName()
                goto L18
            L17:
                r0 = 0
            L18:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                java.lang.StringBuilder r1 = r1.append(r2)
                int r2 = r6.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.checkRadix(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(this, checkRadix(radix))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                if (r0 == 0) goto L5a
                r2 = r0
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r5 = 91
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r4 = r4.append(r2)
                java.lang.String r5 = "]("
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r2 = r4.toString()
                if (r2 != 0) goto L5c
            L5a:
                java.lang.String r2 = "("
            L5c:
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = "currentBounds()="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r2 = r6.currentBounds
                java.lang.Object r2 = r2.invoke()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = ", continuation="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r2 = r6.continuation
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = 41
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewModifier.Request.toString():java.lang.String");
        }
    }
}
