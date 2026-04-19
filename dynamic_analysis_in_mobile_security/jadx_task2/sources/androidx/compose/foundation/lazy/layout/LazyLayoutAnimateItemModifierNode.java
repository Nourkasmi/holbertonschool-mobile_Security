package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutAnimateItemModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001b\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0015J\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001fH\u0016R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R4\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R%\u0010\u001a\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "placementAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "<set-?>", "", "isAnimationInProgress", "()Z", "setAnimationInProgress", "(Z)V", "isAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "getPlacementAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setPlacementAnimationSpec", "placementDelta", "getPlacementDelta-nOcc-ac", "()J", "setPlacementDelta--gyyYBs", "(J)V", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "J", "animatePlacementDelta", "", "delta", "animatePlacementDelta--gyyYBs", "cancelAnimation", "onDetach", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutAnimateItemModifierNode extends Modifier.Node {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* JADX INFO: renamed from: isAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isAnimationInProgress;
    private FiniteAnimationSpec<IntOffset> placementAnimationSpec;

    /* JADX INFO: renamed from: placementDelta$delegate, reason: from kotlin metadata */
    private final MutableState placementDelta;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private long rawOffset;

    public final FiniteAnimationSpec<IntOffset> getPlacementAnimationSpec() {
        return this.placementAnimationSpec;
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getRawOffset() {
        return this.rawOffset;
    }

    public final void setPlacementAnimationSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "<set-?>");
        this.placementAnimationSpec = finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m627setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    public LazyLayoutAnimateItemModifierNode(FiniteAnimationSpec<IntOffset> placementAnimationSpec) {
        Intrinsics.checkNotNullParameter(placementAnimationSpec, "placementAnimationSpec");
        this.placementAnimationSpec = placementAnimationSpec;
        this.isAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.rawOffset = NotInitialized;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m4982boximpl(IntOffset.INSTANCE.m5001getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), null, null, 12, null);
        this.placementDelta = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m4982boximpl(IntOffset.INSTANCE.m5001getZeronOccac()), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationInProgress(boolean z) {
        this.isAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAnimationInProgress() {
        return ((Boolean) this.isAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m623setPlacementDeltagyyYBs(long j) {
        this.placementDelta.setValue(IntOffset.m4982boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m625getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$cancelAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutAnimateItemModifierNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$cancelAnimation$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimateItemModifierNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutAnimateItemModifierNode.this.placementDeltaAnimation.snapTo(IntOffset.m4982boximpl(IntOffset.INSTANCE.m5001getZeronOccac()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LazyLayoutAnimateItemModifierNode.this.m623setPlacementDeltagyyYBs(IntOffset.INSTANCE.m5001getZeronOccac());
            LazyLayoutAnimateItemModifierNode.this.setAnimationInProgress(false);
            return Unit.INSTANCE;
        }
    }

    public final void cancelAnimation() {
        if (isAnimationInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: animatePlacementDelta--gyyYBs, reason: not valid java name */
    public final void m624animatePlacementDeltagyyYBs(long delta) {
        long jM625getPlacementDeltanOccac = m625getPlacementDeltanOccac();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(jM625getPlacementDeltanOccac) - IntOffset.m4991getXimpl(delta), IntOffset.m4992getYimpl(jM625getPlacementDeltanOccac) - IntOffset.m4992getYimpl(delta));
        m623setPlacementDeltagyyYBs(jIntOffset);
        setAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this, jIntOffset, null), 3, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        m623setPlacementDeltagyyYBs(IntOffset.INSTANCE.m5001getZeronOccac());
        setAnimationInProgress(false);
        this.rawOffset = NotInitialized;
    }

    /* JADX INFO: compiled from: LazyLayoutAnimateItemModifierNode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m628getNotInitializednOccac() {
            return LazyLayoutAnimateItemModifierNode.NotInitialized;
        }
    }
}
