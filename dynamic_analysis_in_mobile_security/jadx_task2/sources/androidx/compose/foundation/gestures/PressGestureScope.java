package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m306roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo318roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m307roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo319roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m308toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo320toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m309toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo321toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m310toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo322toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m311toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo323toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m312toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo324toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m313toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo325toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return PressGestureScope.super.toRect(receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m314toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo326toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m315toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo327toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m316toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo328toSpkPz2Gy4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m317toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo329toSpkPz2Gy4(i);
        }
    }
}
