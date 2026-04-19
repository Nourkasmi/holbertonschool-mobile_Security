package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutAnimateItemModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {0}, l = {97, 103}, m = "invokeSuspend", n = {"spec"}, s = {"L$0"})
final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, Continuation<? super LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SpringSpec placementAnimationSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.placementDeltaAnimation.isRunning() || (this.this$0.getPlacementAnimationSpec() instanceof SpringSpec)) {
                placementAnimationSpec = this.this$0.getPlacementAnimationSpec();
            } else {
                placementAnimationSpec = LazyLayoutAnimateItemModifierNodeKt.InterruptionSpec;
            }
            finiteAnimationSpec = placementAnimationSpec;
            if (!this.this$0.placementDeltaAnimation.isRunning()) {
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (this.this$0.placementDeltaAnimation.snapTo(IntOffset.m4982boximpl(this.$totalDelta), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.setAnimationInProgress(false);
                return Unit.INSTANCE;
            }
            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        long packedValue = ((IntOffset) this.this$0.placementDeltaAnimation.getValue()).getPackedValue();
        long j = this.$totalDelta;
        final long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(packedValue) - IntOffset.m4991getXimpl(j), IntOffset.m4992getYimpl(packedValue) - IntOffset.m4992getYimpl(j));
        Animatable animatable = this.this$0.placementDeltaAnimation;
        IntOffset intOffsetM4982boximpl = IntOffset.m4982boximpl(jIntOffset);
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = finiteAnimationSpec;
        final LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (Animatable.animateTo$default(animatable, intOffsetM4982boximpl, finiteAnimationSpec2, null, new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable2) {
                invoke2(animatable2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animatable<IntOffset, AnimationVector2D> animateTo) {
                Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode2 = lazyLayoutAnimateItemModifierNode;
                long packedValue2 = animateTo.getValue().getPackedValue();
                long j2 = jIntOffset;
                lazyLayoutAnimateItemModifierNode2.m623setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4991getXimpl(packedValue2) - IntOffset.m4991getXimpl(j2), IntOffset.m4992getYimpl(packedValue2) - IntOffset.m4992getYimpl(j2)));
            }
        }, this, 4, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
