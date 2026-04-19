package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SwipeableV2.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 s*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001sB\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010V\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u00002\b\b\u0002\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ%\u0010Z\u001a\u00028\u00002\u0006\u0010@\u001a\u00020\u00062\u0006\u0010(\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006J\u0013\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00028\u0000¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u000fH\u0002J\u0006\u0010b\u001a\u00020\u0006J\u0019\u0010c\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0019\u0010f\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010gJ9\u0010h\u001a\u00020W2\b\b\u0002\u0010i\u001a\u00020j2\u001c\u0010k\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0l\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010mJ\u0017\u0010n\u001a\u00020\f2\u0006\u0010Q\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u0010`J!\u0010p\u001a\u00020\f2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0002\brRC\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00168@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00109\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u00105R\u001b\u0010=\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b>\u00105R/\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bI\u00105R\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bR\u0010\"R\u001f\u0010\u0012\u001a\u00020\u0013X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010U\u001a\u0004\bT\u00105\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Landroidx/compose/material3/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$material3_release", "()Ljava/util/Map;", "setAnchors$material3_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material3_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "getPositionalThreshold$material3_release", "()Lkotlin/jvm/functions/Function2;", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "progress$delegate", "swipeDraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getSwipeDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "swipeMutex", "Landroidx/compose/material3/InternalMutatorMutex;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$material3_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snap", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swipe", "swipePriority", "Landroidx/compose/foundation/MutatePriority;", "action", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material3_release", "updateAnchors", "newAnchors", "updateAnchors$material3_release", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeableV2State<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* JADX INFO: renamed from: animationTarget$delegate, reason: from kotlin metadata */
    private final MutableState animationTarget;
    private final Function1<T, Boolean> confirmValueChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private Density density;

    /* JADX INFO: renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableState lastVelocity;

    /* JADX INFO: renamed from: maxOffset$delegate, reason: from kotlin metadata */
    private final State maxOffset;

    /* JADX INFO: renamed from: minOffset$delegate, reason: from kotlin metadata */
    private final State minOffset;

    /* JADX INFO: renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableState offset;
    private final Function2<Density, Float, Float> positionalThreshold;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;
    private final DraggableState swipeDraggableState;
    private final InternalMutatorMutex swipeMutex;

    /* JADX INFO: renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final float velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$animateTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableV2State", f = "SwipeableV2.kt", i = {0}, l = {350}, m = "animateTo", n = {"this"}, s = {"L$0"})
    static final class C03511 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03511(SwipeableV2State<T> swipeableV2State, Continuation<? super C03511> continuation) {
            super(continuation);
            this.this$0 = swipeableV2State;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateTo(null, 0.0f, this);
        }
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, Function2 function2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec, function1, function2, f);
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material3_release() {
        return this.confirmValueChange;
    }

    /* JADX INFO: renamed from: getDensity$material3_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$material3_release() {
        return this.positionalThreshold;
    }

    /* JADX INFO: renamed from: getSwipeDraggableState$material3_release, reason: from getter */
    public final DraggableState getSwipeDraggableState() {
        return this.swipeDraggableState;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3_release, reason: not valid java name and from getter */
    public final float getVelocityThreshold() {
        return this.velocityThreshold;
    }

    public final void setDensity$material3_release(Density density) {
        this.density = density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SwipeableV2State(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = f;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material3.SwipeableV2State$targetValue$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T t2 = (T) this.this$0.getAnimationTarget();
                if (t2 != null) {
                    return t2;
                }
                SwipeableV2State<T> swipeableV2State = this.this$0;
                Float offset = swipeableV2State.getOffset();
                if (offset != null) {
                    return (T) swipeableV2State.computeTarget(offset.floatValue(), swipeableV2State.getCurrentValue(), 0.0f);
                }
                return swipeableV2State.getCurrentValue();
            }
        });
        this.offset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.progress = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Float invoke() {
                /*
                    r6 = this;
                    androidx.compose.material3.SwipeableV2State<T> r0 = r6.this$0
                    java.util.Map r0 = r0.getAnchors$material3_release()
                    androidx.compose.material3.SwipeableV2State<T> r1 = r6.this$0
                    java.lang.Object r1 = r1.getCurrentValue()
                    java.lang.Object r0 = r0.get(r1)
                    java.lang.Float r0 = (java.lang.Float) r0
                    r1 = 0
                    if (r0 == 0) goto L1a
                    float r0 = r0.floatValue()
                    goto L1b
                L1a:
                    r0 = r1
                L1b:
                    androidx.compose.material3.SwipeableV2State<T> r2 = r6.this$0
                    java.util.Map r2 = r2.getAnchors$material3_release()
                    androidx.compose.material3.SwipeableV2State<T> r3 = r6.this$0
                    java.lang.Object r3 = r3.getTargetValue()
                    java.lang.Object r2 = r2.get(r3)
                    java.lang.Float r2 = (java.lang.Float) r2
                    if (r2 == 0) goto L34
                    float r2 = r2.floatValue()
                    goto L35
                L34:
                    r2 = r1
                L35:
                    float r2 = r2 - r0
                    float r3 = java.lang.Math.abs(r2)
                    r4 = 897988541(0x358637bd, float:1.0E-6)
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    r5 = 1065353216(0x3f800000, float:1.0)
                    if (r3 <= 0) goto L5a
                    androidx.compose.material3.SwipeableV2State<T> r3 = r6.this$0
                    float r3 = r3.requireOffset()
                    float r3 = r3 - r0
                    float r3 = r3 / r2
                    int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L50
                    goto L5b
                L50:
                    r0 = 1065353199(0x3f7fffef, float:0.999999)
                    int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                    if (r0 <= 0) goto L58
                    goto L5a
                L58:
                    r1 = r3
                    goto L5b
                L5a:
                    r1 = r5
                L5b:
                    java.lang.Float r0 = java.lang.Float.valueOf(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State$progress$2.invoke():java.lang.Float");
            }
        });
        this.lastVelocity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.minOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$minOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float fMinOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(fMinOrNull != null ? fMinOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$maxOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float fMaxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(fMaxOrNull != null ? fMaxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
    }

    public /* synthetic */ SwipeableV2State(Object obj, SpringSpec<Float> springSpec, AnonymousClass1 anonymousClass1, Function2 function2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableV2Defaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableV2State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }
        } : anonymousClass1, (i & 8) != 0 ? SwipeableV2Defaults.INSTANCE.getPositionalThreshold() : function2, (i & 16) != 0 ? SwipeableV2Defaults.INSTANCE.m1489getVelocityThresholdD9Ej5fM() : f, null);
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    public final Float getOffset() {
        return (Float) this.offset.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget.getValue();
    }

    public final Map<T, Float> getAnchors$material3_release() {
        return (Map) this.anchors.getValue();
    }

    public final boolean updateAnchors$material3_release(Map<T, Float> newAnchors) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean zIsEmpty = getAnchors$material3_release().isEmpty();
        setAnchors$material3_release(newAnchors);
        if (zIsEmpty) {
            T currentValue = getCurrentValue();
            boolean z = getAnchors$material3_release().get(currentValue) != null;
            if (z) {
                trySnapTo$material3_release(currentValue);
            }
            if (!z) {
                return true;
            }
        }
        return !zIsEmpty;
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material3_release().containsKey(value);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableV2State$snapTo$2", f = "SwipeableV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03522 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03522(SwipeableV2State<T> swipeableV2State, T t, Continuation<? super C03522> continuation) {
            super(1, continuation);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03522(this.this$0, this.$targetValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03522) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.snap(this.$targetValue);
            return Unit.INSTANCE;
        }
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object objSwipe$default = swipe$default(this, null, new C03522(this, t, null), continuation, 1, null);
        return objSwipe$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSwipe$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateTo(T r15, float r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$animateTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableV2State$animateTo$2", f = "SwipeableV2.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Float $targetOffset;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ float $velocity;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SwipeableV2State<T> swipeableV2State, T t, Float f, float f2, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
            this.$targetOffset = f;
            this.$velocity = f2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$targetValue, this.$targetOffset, this.$velocity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setAnimationTarget(this.$targetValue);
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                Float offset = this.this$0.getOffset();
                floatRef.element = offset != null ? offset.floatValue() : 0.0f;
                float f = floatRef.element;
                float fFloatValue = this.$targetOffset.floatValue();
                float f2 = this.$velocity;
                AnimationSpec<Float> animationSpec$material3_release = this.this$0.getAnimationSpec$material3_release();
                final SwipeableV2State<T> swipeableV2State = this.this$0;
                this.label = 1;
                if (SuspendAnimationKt.animate(f, fFloatValue, f2, animationSpec$material3_release, new Function2<Float, Float, Unit>() { // from class: androidx.compose.material3.SwipeableV2State.animateTo.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f3, Float f4) {
                        invoke(f3.floatValue(), f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f3, float f4) {
                        swipeableV2State.setOffset(Float.valueOf(f3));
                        floatRef.element = f3;
                        swipeableV2State.setLastVelocity(f4);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.setLastVelocity(0.0f);
            return Unit.INSTANCE;
        }
    }

    public final Object settle(float f, Continuation<? super Unit> continuation) throws Throwable {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        if (this.confirmValueChange.invoke(tComputeTarget).booleanValue()) {
            Object objAnimateTo = animateTo(tComputeTarget, f, continuation);
            return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
        }
        Object objAnimateTo2 = animateTo(currentValue, f, continuation);
        return objAnimateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        Float offset = getOffset();
        float fFloatValue = offset != null ? offset.floatValue() : 0.0f;
        float fCoerceIn = RangesKt.coerceIn(delta + fFloatValue, getMinOffset(), getMaxOffset()) - fFloatValue;
        if (Math.abs(fCoerceIn) >= 0.0f) {
            Float offset2 = getOffset();
            setOffset(Float.valueOf(RangesKt.coerceIn((offset2 != null ? offset2.floatValue() : 0.0f) + fCoerceIn, getMinOffset(), getMaxOffset())));
        }
        return fCoerceIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Object objClosestAnchor;
        Map<T, Float> anchors$material3_release = getAnchors$material3_release();
        Float f = anchors$material3_release.get(currentValue);
        Density densityRequireDensity = requireDensity();
        float fMo325toPx0680j_4 = densityRequireDensity.mo325toPx0680j_4(this.velocityThreshold);
        if (Intrinsics.areEqual(f, offset) || f == null) {
            return currentValue;
        }
        if (f.floatValue() < offset) {
            if (velocity >= fMo325toPx0680j_4) {
                return (T) SwipeableV2Kt.closestAnchor(anchors$material3_release, offset, true);
            }
            objClosestAnchor = SwipeableV2Kt.closestAnchor(anchors$material3_release, offset, true);
            if (offset < Math.abs(f.floatValue() + Math.abs(this.positionalThreshold.invoke(densityRequireDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(anchors$material3_release, objClosestAnchor)).floatValue() - f.floatValue()))).floatValue()))) {
                return currentValue;
            }
        } else {
            if (velocity <= (-fMo325toPx0680j_4)) {
                return (T) SwipeableV2Kt.closestAnchor(anchors$material3_release, offset, false);
            }
            objClosestAnchor = SwipeableV2Kt.closestAnchor(anchors$material3_release, offset, false);
            float fAbs = Math.abs(f.floatValue() - Math.abs(this.positionalThreshold.invoke(densityRequireDensity, Float.valueOf(Math.abs(f.floatValue() - ((Number) MapsKt.getValue(anchors$material3_release, objClosestAnchor)).floatValue()))).floatValue()));
            if (offset < 0.0f) {
                if (Math.abs(offset) < fAbs) {
                    return currentValue;
                }
            } else if (offset > fAbs) {
                return currentValue;
            }
        }
        return (T) objClosestAnchor;
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$swipe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableV2State$swipe$2", f = "SwipeableV2.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
    static final class C03532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
        final /* synthetic */ MutatePriority $swipePriority;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03532(SwipeableV2State<T> swipeableV2State, MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C03532> continuation) {
            super(2, continuation);
            this.this$0 = swipeableV2State;
            this.$swipePriority = mutatePriority;
            this.$action = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03532(this.this$0, this.$swipePriority, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (((SwipeableV2State) this.this$0).swipeMutex.mutate(this.$swipePriority, this.$action, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object swipe(MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C03532(this, mutatePriority, function1, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material3_release(final T targetValue) {
        return this.swipeMutex.tryMutate(new Function0<Unit>(this) { // from class: androidx.compose.material3.SwipeableV2State$trySnapTo$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.snap(targetValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snap(T targetValue) {
        Float f = getAnchors$material3_release().get(targetValue);
        if (f != null) {
            float fFloatValue = f.floatValue();
            Float offset = getOffset();
            dispatchRawDelta(fFloatValue - (offset != null ? offset.floatValue() : 0.0f));
            setCurrentValue(targetValue);
            setAnimationTarget(null);
            return;
        }
        setCurrentValue(targetValue);
    }

    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0089\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: Saver-eqLRuRQ, reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m1493SavereqLRuRQ(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmValueChange, final Function2<? super Density, ? super Float, Float> positionalThreshold, final float velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope Saver, SwipeableV2State<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SwipeableV2State<T> invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableV2State<>(it, animationSpec, confirmValueChange, positionalThreshold, velocityThreshold, null);
                }
            });
        }
    }

    private final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset.setValue(f);
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget.setValue(t);
    }

    public final void setAnchors$material3_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors.setValue(map);
    }
}
