package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b(\u0010$J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J'\u00101\u001a\u00020**\u0002022\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020**\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010-J\n\u00108\u001a\u00020:*\u00020:J\u0017\u0010;\u001a\u00020**\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010-J\u0017\u0010=\u001a\u00020!*\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010-J\u0017\u0010?\u001a\u00020:*\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010?\u001a\u00020:*\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010AJ\u001a\u0010C\u001a\u00020**\u00020:ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020!*\u00020!2\u0006\u0010G\u001a\u00020:ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010IR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001b\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "availableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    public ScrollingLogic(Orientation orientation, boolean z, State<NestedScrollDispatcher> nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        this.isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m344toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m2406getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m340singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2384copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m2384copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m343toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2390getXimpl(j) : Offset.m2391getYimpl(j);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m342toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5098getXimpl(j) : Velocity.m5099getYimpl(j);
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m341singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5094copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m5094copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m345updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5094copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m5094copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m339reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m2397timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m335dispatchScroll3eAAhYA(final ScrollScope dispatchScroll, long j, final int i) {
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        long jM340singleAxisOffsetMKHz9U = m340singleAxisOffsetMKHz9U(j);
        Function1<Offset, Offset> function1 = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                return Offset.m2379boximpl(m346invokeMKHz9U(offset.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
            public final long m346invokeMKHz9U(long j2) {
                NestedScrollDispatcher value = this.this$0.getNestedScrollDispatcher().getValue();
                long jM3636dispatchPreScrollOzD1aCk = value.m3636dispatchPreScrollOzD1aCk(j2, i);
                long jM2394minusMKHz9U = Offset.m2394minusMKHz9U(j2, jM3636dispatchPreScrollOzD1aCk);
                ScrollingLogic scrollingLogic = this.this$0;
                long jM339reverseIfNeededMKHz9U = scrollingLogic.m339reverseIfNeededMKHz9U(scrollingLogic.m344toOffsettuRUvjQ(dispatchScroll.scrollBy(scrollingLogic.m343toFloatk4lQ0M(scrollingLogic.m339reverseIfNeededMKHz9U(jM2394minusMKHz9U)))));
                return Offset.m2395plusMKHz9U(Offset.m2395plusMKHz9U(jM3636dispatchPreScrollOzD1aCk, jM339reverseIfNeededMKHz9U), value.m3634dispatchPostScrollDzOQY0M(jM339reverseIfNeededMKHz9U, Offset.m2394minusMKHz9U(jM2394minusMKHz9U, jM339reverseIfNeededMKHz9U), i));
            }
        };
        if (this.overscrollEffect != null && getShouldDispatchOverscroll()) {
            return this.overscrollEffect.mo154applyToScrollRhakbz0(jM340singleAxisOffsetMKHz9U, i, function1);
        }
        return function1.invoke(Offset.m2379boximpl(jM340singleAxisOffsetMKHz9U)).getPackedValue();
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m338performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m2406getZeroF1C5BW0();
        }
        return m344toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m343toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m337onDragStoppedsFctU(long r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r6 = (androidx.compose.foundation.gestures.ScrollingLogic) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r5.registerNestedFling(r4)
            long r6 = r5.m341singleAxisVelocityAH228Gc(r6)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r8 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r2 = 0
            r8.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.foundation.OverscrollEffect r2 = r5.overscrollEffect
            if (r2 == 0) goto L65
            boolean r2 = r5.getShouldDispatchOverscroll()
            if (r2 == 0) goto L65
            androidx.compose.foundation.OverscrollEffect r2 = r5.overscrollEffect
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r2.mo153applyToFlingBMRW4eQ(r6, r8, r0)
            if (r6 != r1) goto L63
            return r1
        L63:
            r6 = r5
            goto L74
        L65:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m5089boximpl(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r8.invoke(r6, r0)
            if (r6 != r1) goto L63
            return r1
        L74:
            r7 = 0
            r6.registerNestedFling(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m337onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m336doFlingAnimationQWom1Mo(long r13, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L19:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L61
        L2f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L37:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r13 = r11
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r13
            java.lang.Object r13 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L60
            return r0
        L60:
            r13 = r15
        L61:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m5089boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m336doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        OverscrollEffect overscrollEffect;
        return this.scrollableState.isScrollInProgress() || this.isNestedFlinging.getValue().booleanValue() || ((overscrollEffect = this.overscrollEffect) != null && overscrollEffect.isInProgress());
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }
}
