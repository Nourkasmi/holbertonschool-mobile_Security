package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a8\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\u0082\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0082\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRoot", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float stiffness, float dampingRatio, float initialVelocity, float initialDisplacement, float delta) {
        return estimateAnimationDurationMillis(stiffness, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double stiffness, double dampingRatio, double initialVelocity, double initialDisplacement, double delta) {
        double dampingCoefficient = 2.0d * dampingRatio * Math.sqrt(stiffness);
        double partialRoot = (dampingCoefficient * dampingCoefficient) - (4.0d * stiffness);
        double $this$plus$iv = -dampingCoefficient;
        ComplexDouble this_$iv = ComplexDoubleKt.complexSqrt(partialRoot);
        this_$iv._real += $this$plus$iv;
        this_$iv._real *= 0.5d;
        this_$iv._imaginary *= 0.5d;
        double $this$minus$iv = -dampingCoefficient;
        ComplexDouble other$iv = ComplexDoubleKt.complexSqrt(partialRoot);
        double d = -1;
        other$iv._real *= d;
        other$iv._imaginary *= d;
        other$iv._real += $this$minus$iv;
        other$iv._real *= 0.5d;
        other$iv._imaginary *= 0.5d;
        return estimateDurationInternal(this_$iv, other$iv, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double springConstant, double dampingCoefficient, double mass, double initialVelocity, double initialDisplacement, double delta) {
        double criticalDamping = Math.sqrt(springConstant * mass) * 2.0d;
        double dampingRatio = dampingCoefficient / criticalDamping;
        double partialRoot = (dampingCoefficient * dampingCoefficient) - ((4.0d * mass) * springConstant);
        double divisor = 1.0d / (2.0d * mass);
        double $this$plus$iv = -dampingCoefficient;
        ComplexDouble other$iv = ComplexDoubleKt.complexSqrt(partialRoot);
        other$iv._real += $this$plus$iv;
        other$iv._real *= divisor;
        other$iv._imaginary *= divisor;
        double $this$minus$iv = -dampingCoefficient;
        ComplexDouble other$iv2 = ComplexDoubleKt.complexSqrt(partialRoot);
        double d = -1;
        other$iv2._real *= d;
        other$iv2._imaginary *= d;
        other$iv2._real += $this$minus$iv;
        other$iv2._real *= divisor;
        other$iv2._imaginary *= divisor;
        return estimateDurationInternal(other$iv, other$iv2, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    private static final double estimateUnderDamped(ComplexDouble firstRoot, double p0, double v0, double delta) {
        double r = firstRoot.getReal();
        double c2 = (v0 - (r * p0)) / firstRoot.getImaginary();
        double c = Math.sqrt((p0 * p0) + (c2 * c2));
        return Math.log(delta / c) / r;
    }

    private static final double estimateCriticallyDamped(ComplexDouble firstRoot, double p0, double v0, double delta) {
        double tCurr;
        double tConcavChange;
        double tDelta;
        int iterations;
        double r = firstRoot.getReal();
        double c2 = v0 - (r * p0);
        double t1 = Math.log(Math.abs(delta / p0)) / r;
        int i = 0;
        double guess = Math.log(Math.abs(delta / c2));
        double t = guess;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 6) {
                break;
            }
            t = guess - Math.log(Math.abs(t / r));
            i2++;
            i = i3;
        }
        double t2 = t / r;
        boolean z = false;
        if (!((Double.isInfinite(t1) || Double.isNaN(t1)) ? false : true)) {
            tCurr = t2;
        } else {
            if (!Double.isInfinite(t2) && !Double.isNaN(t2)) {
                z = true;
            }
            tCurr = z ^ true ? t1 : Math.max(t1, t2);
        }
        double tInflection = (-((r * p0) + c2)) / (r * c2);
        double xInflection = (Math.exp(r * tInflection) * p0) + (c2 * tInflection * Math.exp(r * tInflection));
        if (Double.isNaN(tInflection) || tInflection <= 0.0d) {
            tConcavChange = -delta;
            tDelta = Double.MAX_VALUE;
            iterations = 0;
            while (tDelta > 0.001d && iterations < 100) {
                double tLast = tCurr;
                double t3 = tCurr;
                double dExp = ((p0 + (c2 * t3)) * Math.exp(r * t3)) + tConcavChange;
                double signedDelta = tConcavChange;
                double signedDelta2 = 1;
                tCurr -= dExp / (((((r * t3) + signedDelta2) * c2) + (p0 * r)) * Math.exp(r * t3));
                tDelta = Math.abs(tLast - tCurr);
                iterations++;
                tConcavChange = signedDelta;
            }
            return tCurr;
        }
        if (tInflection <= 0.0d || (-xInflection) >= delta) {
            double tConcavChange2 = (-(2.0d / r)) - (p0 / c2);
            tCurr = tConcavChange2;
            tConcavChange = delta;
        } else {
            if (c2 < 0.0d && p0 > 0.0d) {
                tCurr = 0.0d;
            }
            tConcavChange = -delta;
        }
        tDelta = Double.MAX_VALUE;
        iterations = 0;
        while (tDelta > 0.001d) {
            double tLast2 = tCurr;
            double t32 = tCurr;
            double dExp2 = ((p0 + (c2 * t32)) * Math.exp(r * t32)) + tConcavChange;
            double signedDelta3 = tConcavChange;
            double signedDelta22 = 1;
            tCurr -= dExp2 / (((((r * t32) + signedDelta22) * c2) + (p0 * r)) * Math.exp(r * t32));
            tDelta = Math.abs(tLast2 - tCurr);
            iterations++;
            tConcavChange = signedDelta3;
        }
        return tCurr;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r38, androidx.compose.animation.core.ComplexDouble r39, double r40, double r42, double r44) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double c1, double r1, double tInflection, double c2, double r2) {
        return (Math.exp(r1 * tInflection) * c1) + (Math.exp(r2 * tInflection) * c2);
    }

    private static final long estimateDurationInternal(ComplexDouble firstRoot, ComplexDouble secondRoot, double dampingRatio, double initialVelocity, double initialPosition, double delta) {
        double dEstimateCriticallyDamped;
        if (initialPosition == 0.0d) {
            if (initialVelocity == 0.0d) {
                return 0L;
            }
        }
        double v0 = initialPosition < 0.0d ? -initialVelocity : initialVelocity;
        double p0 = Math.abs(initialPosition);
        if (dampingRatio > 1.0d) {
            dEstimateCriticallyDamped = estimateOverDamped(firstRoot, secondRoot, p0, v0, delta);
        } else if (dampingRatio < 1.0d) {
            dEstimateCriticallyDamped = estimateUnderDamped(firstRoot, p0, v0, delta);
        } else {
            dEstimateCriticallyDamped = estimateCriticallyDamped(firstRoot, p0, v0, delta);
        }
        return (long) (dEstimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double x, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return x - (function1.invoke(Double.valueOf(x)).doubleValue() / function12.invoke(Double.valueOf(x)).doubleValue());
    }

    private static final boolean isNotFinite(double $this$isNotFinite) {
        return !((Double.isInfinite($this$isNotFinite) || Double.isNaN($this$isNotFinite)) ? false : true);
    }
}
