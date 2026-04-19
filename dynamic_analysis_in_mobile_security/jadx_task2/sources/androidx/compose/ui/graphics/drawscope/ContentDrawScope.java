package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* JADX INFO: compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m3121drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap image, long j, long j2, long j3, long j4, float f, DrawStyle style, ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(style, "style");
            ContentDrawScope.super.mo3078drawImageAZ2fEMs(image, j, j2, j3, j4, f, style, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3122getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo3171getCenterF1C5BW0();
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3123getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo3172getSizeNHjbRc();
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3124roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo318roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3125roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo319roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3126toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo320toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3127toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo321toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3128toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo322toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3129toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo323toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3130toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo324toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3131toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo325toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return ContentDrawScope.super.toRect(receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3132toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo326toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3133toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo327toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3134toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo328toSpkPz2Gy4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3135toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo329toSpkPz2Gy4(i);
        }
    }
}
