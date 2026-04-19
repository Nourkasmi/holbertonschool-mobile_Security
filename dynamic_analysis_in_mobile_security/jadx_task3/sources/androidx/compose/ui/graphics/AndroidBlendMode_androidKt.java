package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidBlendMode_androidKt {
    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m2799isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m2860equalsimpl0($this$isSupported_u2ds9anfk8, BlendMode.INSTANCE.m2891getSrcOver0nO6VwU()) || m2801toPorterDuffModes9anfk8($this$isSupported_u2ds9anfk8) != PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m2801toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2864getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2887getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2870getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2891getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2874getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2889getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2872getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2890getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2873getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2888getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2871getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2892getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2883getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2885getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2882getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2868getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2878getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m2860equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m2880getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m2800toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        return BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2864getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2887getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2870getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2891getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2874getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2889getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2872getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2890getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2873getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2888getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2871getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2892getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2883getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2880getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2885getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2882getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2868getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2878getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2867getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2866getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2876getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2886getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2869getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2875getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2881getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2877getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2884getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2865getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m2860equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m2879getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }
}
