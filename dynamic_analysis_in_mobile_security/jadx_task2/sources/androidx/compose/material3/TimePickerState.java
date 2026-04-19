package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010F\u001a\u00020GH\u0080@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0003H\u0000¢\u0006\u0002\bLJ%\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u0013H\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J3\u0010T\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020G2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020G2\u0006\u00100\u001a\u00020\u0003H\u0000¢\u0006\u0002\b[J\u0011\u0010\\\u001a\u00020GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJ%\u0010]\u001a\u00020G2\u0006\u0010K\u001a\u00020\u00132\b\b\u0002\u0010^\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\f\u0010a\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010#R+\u0010'\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b(\u0010#\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010#\"\u0004\b.\u0010*R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R+\u00102\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R4\u00109\u001a\u0002082\u0006\u0010\b\u001a\u0002088@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0010\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010<R$\u0010>\u001a\u00020?8@X\u0080\u0084\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b@\u0010\fR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimePickerState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: center$delegate, reason: from kotlin metadata */
    private final MutableState center;
    private final Animatable<Float, AnimationVector1D> currentAngle;

    /* JADX INFO: renamed from: hourAngle$delegate, reason: from kotlin metadata */
    private final MutableState hourAngle;
    private final boolean is24hour;

    /* JADX INFO: renamed from: isAfternoon$delegate, reason: from kotlin metadata */
    private final State isAfternoon;

    /* JADX INFO: renamed from: isAfternoonToggle$delegate, reason: from kotlin metadata */
    private final MutableState isAfternoonToggle;

    /* JADX INFO: renamed from: isInnerCircle$delegate, reason: from kotlin metadata */
    private final MutableState isInnerCircle;

    /* JADX INFO: renamed from: minuteAngle$delegate, reason: from kotlin metadata */
    private final MutableState minuteAngle;
    private final MutatorMutex mutex;

    /* JADX INFO: renamed from: selection$delegate, reason: from kotlin metadata */
    private final MutableState selection;

    /* JADX INFO: renamed from: selectorPos$delegate, reason: from kotlin metadata */
    private final State selectorPos;

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerState$settle$1, reason: invalid class name */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TimePickerState", f = "TimePicker.kt", i = {0, 0}, l = {616, 617}, m = "settle", n = {"this", "targetValue"}, s = {"L$0", "L$1"})
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
            return TimePickerState.this.settle(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float angle) {
        float f = angle + 1.5707964f;
        return f < 0.0f ? f + 6.2831855f : f;
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    /* JADX INFO: renamed from: is24hour, reason: from getter */
    public final boolean getIs24hour() {
        return this.is24hour;
    }

    public TimePickerState(int i, int i2, final boolean z) {
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (i < 0 || i >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = z;
        this.selectorPos = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<DpOffset>() { // from class: androidx.compose.material3.TimePickerState$selectorPos$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ DpOffset invoke() {
                return DpOffset.m4928boximpl(m1596invokeRKDOV3M());
            }

            /* JADX INFO: renamed from: invoke-RKDOV3M, reason: not valid java name */
            public final long m1596invokeRKDOV3M() {
                float f;
                boolean zIsInnerCircle$material3_release = this.this$0.isInnerCircle$material3_release();
                float f2 = 2;
                float fM4873constructorimpl = Dp.m4873constructorimpl(TimePickerTokens.INSTANCE.m2162getClockDialSelectorHandleContainerSizeD9Ej5fM() / f2);
                if (z && zIsInnerCircle$material3_release && Selection.m1375equalsimpl0(this.this$0.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1379getHourJiIwxys())) {
                    f = TimePickerKt.InnerCircleRadius;
                } else {
                    f = TimePickerKt.OuterCircleSizeRadius;
                }
                float fM4873constructorimpl2 = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f - fM4873constructorimpl) + fM4873constructorimpl);
                return DpKt.m4894DpOffsetYgX7TsA(Dp.m4873constructorimpl(Dp.m4873constructorimpl(((float) Math.cos(this.this$0.getCurrentAngle$material3_release().getValue().floatValue())) * fM4873constructorimpl2) + Dp.m4873constructorimpl(TimePickerTokens.INSTANCE.m2160getClockDialContainerSizeD9Ej5fM() / f2)), Dp.m4873constructorimpl(Dp.m4873constructorimpl(fM4873constructorimpl2 * ((float) Math.sin(this.this$0.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.m4873constructorimpl(TimePickerTokens.INSTANCE.m2160getClockDialContainerSizeD9Ej5fM() / f2)));
            }
        });
        this.center = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m4982boximpl(IntOffset.INSTANCE.m5001getZeronOccac()), null, 2, null);
        this.selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m1372boximpl(Selection.INSTANCE.m1379getHourJiIwxys()), null, 2, null);
        this.isAfternoonToggle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i > 12 && !z), null, 2, null);
        this.isInnerCircle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), null, 2, null);
        this.hourAngle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(((i * 0.5235988f) % 12) - 1.5707964f), null, 2, null);
        this.minuteAngle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((i2 * 0.10471976f) - 1.5707964f), null, 2, null);
        this.mutex = new MutatorMutex();
        this.isAfternoon = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerState.isAfternoon.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((TimePickerState.this.getIs24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
            }
        });
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCenter-nOcc-ac$material3_release, reason: not valid java name */
    public final long m1591getCenternOccac$material3_release() {
        return ((IntOffset) this.center.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: setCenter--gyyYBs$material3_release, reason: not valid java name */
    public final void m1594setCentergyyYBs$material3_release(long j) {
        this.center.setValue(IntOffset.m4982boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m1375equalsimpl0(m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1380getMinuteJiIwxys()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSelection-JiIwxys$material3_release, reason: not valid java name */
    public final int m1592getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection.getValue()).m1378unboximpl();
    }

    /* JADX INFO: renamed from: setSelection-iHAOin8$material3_release, reason: not valid java name */
    public final void m1595setSelectioniHAOin8$material3_release(int i) {
        this.selection.setValue(Selection.m1372boximpl(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getHourAngle$material3_release() {
        return ((Number) this.hourAngle.getValue()).floatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getMinuteAngle$material3_release() {
        return ((Number) this.minuteAngle.getValue()).floatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle.setValue(Float.valueOf(f));
    }

    public final void setMinute$material3_release(int minute) {
        setMinuteAngle$material3_release((minute * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int hour) {
        setInnerCircle$material3_release(hour > 12 || hour == 0);
        setHourAngle$material3_release(((hour * 0.5235988f) % 12) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float x, float y, float maxDist) {
        if (Selection.m1375equalsimpl0(m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1379getHourJiIwxys()) && this.is24hour) {
            setInnerCircle$material3_release(TimePickerKt.dist(x, y, IntOffset.m4991getXimpl(m1591getCenternOccac$material3_release()), IntOffset.m4992getYimpl(m1591getCenternOccac$material3_release())) < maxDist);
        }
    }

    public final boolean isSelected$material3_release(int value) {
        if (Selection.m1375equalsimpl0(m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1380getMinuteJiIwxys())) {
            if (value == getMinute()) {
                return true;
            }
        } else {
            if (getHour() == value + (isAfternoon() ? 12 : 0)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float f, boolean z, Continuation<? super Unit> continuation) {
        Object objMutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, f, z, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r11, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L41
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbf
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            float r1 = r6.F$0
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L96
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            int r12 = r11.m1592getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.INSTANCE
            int r1 = r1.m1379getHourJiIwxys()
            boolean r12 = androidx.compose.material3.Selection.m1375equalsimpl0(r12, r1)
            if (r12 == 0) goto L61
            float r12 = r11.getMinuteAngle$material3_release()
            float r1 = r11.getHourAngle$material3_release()
            kotlin.Pair r12 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
            goto L6d
        L61:
            float r12 = r11.getHourAngle$material3_release()
            float r1 = r11.getMinuteAngle$material3_release()
            kotlin.Pair r12 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
        L6d:
            java.lang.Object r1 = r12.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Object r12 = r12.component2()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r11.currentAngle
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r6.L$0 = r11
            r6.F$0 = r12
            r6.label = r3
            java.lang.Object r1 = r4.snapTo(r1, r6)
            if (r1 != r0) goto L94
            return r0
        L94:
            r3 = r11
            r1 = r12
        L96:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r3.currentAngle
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r5 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r6.L$0 = r7
            r6.label = r2
            r1 = r12
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r7 = r9
            r8 = r10
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto Lbf
            return r0
        Lbf:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int hour) {
        if (!this.is24hour || !isInnerCircle$material3_release() || hour != 0) {
            if (this.is24hour) {
                return hour % 24;
            }
            if (hour % 12 != 0) {
                return isAfternoon() ? hour - 12 : hour;
            }
        }
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((((double) f) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((((double) f) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto L99
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            java.lang.Object r1 = r6.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6e
        L43:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r11.currentAngle
            java.lang.Object r12 = r12.getValue()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            float r1 = r11.getMinuteAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r11.currentAngle
            java.lang.Object r4 = r1.getFirst()
            r6.L$0 = r11
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r12 = r12.snapTo(r4, r6)
            if (r12 != r0) goto L6d
            return r0
        L6d:
            r3 = r11
        L6e:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r3.currentAngle
            java.lang.Object r3 = r1.getSecond()
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r5 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r6.L$0 = r7
            r6.L$1 = r7
            r6.label = r2
            r1 = r12
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r7 = r9
            r8 = r10
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L99
            return r0
        L99:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onTap$material3_release(float r11, float r12, float r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerState, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Object> invoke(SaverScope Saver, TimePickerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return CollectionsKt.listOf(Integer.valueOf(it.getHour()), Integer.valueOf(it.getMinute()), Boolean.valueOf(it.getIs24hour()));
                }
            }, new Function1<List, TimePickerState>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimePickerState invoke(List list) {
                    return invoke2((List<? extends Object>) list);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TimePickerState invoke2(List<? extends Object> value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    Object obj = value.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = value.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = ((Integer) obj2).intValue();
                    Object obj3 = value.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerState(iIntValue, iIntValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: getSelectorPos-RKDOV3M$material3_release, reason: not valid java name */
    public final long m1593getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos.getValue()).getPackedValue();
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon.getValue()).booleanValue();
    }
}
