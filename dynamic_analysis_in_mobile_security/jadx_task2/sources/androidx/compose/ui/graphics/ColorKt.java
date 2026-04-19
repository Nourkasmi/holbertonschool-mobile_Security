package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a2\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0082\b\u001a-\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a!\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010+\u001a\u00020,*\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorKt {
    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m2677isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m2679isUnspecified8_81llA$annotations(long j) {
    }

    private static final float saturate(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = 1.0f;
            if (f < 1.0f) {
                return f;
            }
        }
        return f2;
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float minValue = colorSpace.getMinValue(0);
        if (f <= colorSpace.getMaxValue(0) && minValue <= f) {
            float minValue2 = colorSpace.getMinValue(1);
            if (f2 <= colorSpace.getMaxValue(1) && minValue2 <= f2) {
                float minValue3 = colorSpace.getMinValue(2);
                if (f3 <= colorSpace.getMaxValue(2) && minValue3 <= f3 && 0.0f <= f4 && f4 <= 1.0f) {
                    if (colorSpace.getIsSrgb()) {
                        return Color.m2625constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl((((((int) ((f * 255.0f) + 0.5f)) << 16) | (((int) ((f4 * 255.0f) + 0.5f)) << 24)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((f3 * 255.0f) + 0.5f))) & 4294967295L) << 32));
                    }
                    if (colorSpace.getComponentCount() != 3) {
                        throw new IllegalArgumentException("Color only works with ColorSpaces with 3 components".toString());
                    }
                    int id$ui_graphics_release = colorSpace.getId();
                    if (id$ui_graphics_release == -1) {
                        throw new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces".toString());
                    }
                    short sM2733constructorimpl = Float16.m2733constructorimpl(f);
                    return Color.m2625constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(Float16.m2733constructorimpl(f2)) & 65535) << 32) | ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(sM2733constructorimpl) & 65535) << 48)) | ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(Float16.m2733constructorimpl(f3)) & 65535) << 16)) | ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6)) | ULong.m5335constructorimpl(ULong.m5335constructorimpl(id$ui_graphics_release) & 63)));
                }
            }
        }
        throw new IllegalArgumentException(("red = " + f + ", green = " + f2 + ", blue = " + f3 + ", alpha = " + f4 + " outside the range for " + colorSpace).toString());
    }

    public static final long Color(int i) {
        return Color.m2625constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m2625constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(ULong.m5335constructorimpl(j) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m2680lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM2626convertvNxB06k = Color.m2626convertvNxB06k(j, oklab);
        long jM2626convertvNxB06k2 = Color.m2626convertvNxB06k(j2, oklab);
        float fM2631getAlphaimpl = Color.m2631getAlphaimpl(jM2626convertvNxB06k);
        float fM2635getRedimpl = Color.m2635getRedimpl(jM2626convertvNxB06k);
        float fM2634getGreenimpl = Color.m2634getGreenimpl(jM2626convertvNxB06k);
        float fM2632getBlueimpl = Color.m2632getBlueimpl(jM2626convertvNxB06k);
        float fM2631getAlphaimpl2 = Color.m2631getAlphaimpl(jM2626convertvNxB06k2);
        float fM2635getRedimpl2 = Color.m2635getRedimpl(jM2626convertvNxB06k2);
        float fM2634getGreenimpl2 = Color.m2634getGreenimpl(jM2626convertvNxB06k2);
        float fM2632getBlueimpl2 = Color.m2632getBlueimpl(jM2626convertvNxB06k2);
        return Color.m2626convertvNxB06k(Color(MathHelpersKt.lerp(fM2635getRedimpl, fM2635getRedimpl2, f), MathHelpersKt.lerp(fM2634getGreenimpl, fM2634getGreenimpl2, f), MathHelpersKt.lerp(fM2632getBlueimpl, fM2632getBlueimpl2, f), MathHelpersKt.lerp(fM2631getAlphaimpl, fM2631getAlphaimpl2, f), oklab), Color.m2633getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m2674compositeOverOWjLjI(long j, long j2) {
        long jM2626convertvNxB06k = Color.m2626convertvNxB06k(j, Color.m2633getColorSpaceimpl(j2));
        float fM2631getAlphaimpl = Color.m2631getAlphaimpl(j2);
        float fM2631getAlphaimpl2 = Color.m2631getAlphaimpl(jM2626convertvNxB06k);
        float f = 1.0f - fM2631getAlphaimpl2;
        float f2 = (fM2631getAlphaimpl * f) + fM2631getAlphaimpl2;
        return Color(f2 == 0.0f ? 0.0f : ((Color.m2635getRedimpl(jM2626convertvNxB06k) * fM2631getAlphaimpl2) + ((Color.m2635getRedimpl(j2) * fM2631getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m2634getGreenimpl(jM2626convertvNxB06k) * fM2631getAlphaimpl2) + ((Color.m2634getGreenimpl(j2) * fM2631getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m2632getBlueimpl(jM2626convertvNxB06k) * fM2631getAlphaimpl2) + ((Color.m2632getBlueimpl(j2) * fM2631getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m2633getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m2675getComponents8_81llA(long j) {
        return new float[]{Color.m2635getRedimpl(j), Color.m2634getGreenimpl(j), Color.m2632getBlueimpl(j), Color.m2631getAlphaimpl(j)};
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m2681luminance8_81llA(long j) {
        ColorSpace colorSpaceM2633getColorSpaceimpl = Color.m2633getColorSpaceimpl(j);
        if (!ColorModel.m3029equalsimpl0(colorSpaceM2633getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m3036getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m3032toStringimpl(colorSpaceM2633getColorSpaceimpl.getModel()))).toString());
        }
        Intrinsics.checkNotNull(colorSpaceM2633getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM2633getColorSpaceimpl).getEotfFunc();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m2635getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m2634getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m2632getBlueimpl(j)) * 0.0722d)));
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m2683toArgb8_81llA(long j) {
        return (int) ULong.m5335constructorimpl(Color.m2626convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m2676isSpecified8_81llA(long j) {
        return j != Color.INSTANCE.m2665getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m2678isUnspecified8_81llA(long j) {
        return j == Color.INSTANCE.m2665getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m2682takeOrElseDxMtmZc(long j, Function0<Color> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return j != Color.INSTANCE.m2665getUnspecified0d7_KjU() ? j : block.invoke().m2639unboximpl();
    }
}
