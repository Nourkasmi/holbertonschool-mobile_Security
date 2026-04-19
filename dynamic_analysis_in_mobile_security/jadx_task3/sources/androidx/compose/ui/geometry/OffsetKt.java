package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"!\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OffsetKt {
    /* JADX INFO: renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2726isFinitek4lQ0M$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2728isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2730isUnspecifiedk4lQ0M$annotations(long j) {
    }

    public static final long Offset(float x, float y) {
        long v1$iv = Float.floatToIntBits(x);
        long v2$iv = Float.floatToIntBits(y);
        return Offset.m2700constructorimpl((v1$iv << 32) | (4294967295L & v2$iv));
    }

    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m2731lerpWko1d7g(long start, long stop, float fraction) {
        return Offset(MathHelpersKt.lerp(Offset.m2708getXimpl(start), Offset.m2708getXimpl(stop), fraction), MathHelpersKt.lerp(Offset.m2709getYimpl(start), Offset.m2709getYimpl(stop), fraction));
    }

    /* JADX INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m2725isFinitek4lQ0M(long $this$isFinite) {
        float fM2708getXimpl = Offset.m2708getXimpl($this$isFinite);
        if ((Float.isInfinite(fM2708getXimpl) || Float.isNaN(fM2708getXimpl)) ? false : true) {
            float fM2709getYimpl = Offset.m2709getYimpl($this$isFinite);
            if ((Float.isInfinite(fM2709getYimpl) || Float.isNaN(fM2709getYimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2727isSpecifiedk4lQ0M(long $this$isSpecified) {
        return $this$isSpecified != Offset.INSTANCE.m2723getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2729isUnspecifiedk4lQ0M(long $this$isUnspecified) {
        return $this$isUnspecified == Offset.INSTANCE.m2723getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m2732takeOrElse3MmeM6k(long $this$takeOrElse_u2d3MmeM6k, Function0<Offset> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return m2727isSpecifiedk4lQ0M($this$takeOrElse_u2d3MmeM6k) ? $this$takeOrElse_u2d3MmeM6k : block.invoke().getPackedValue();
    }
}
