package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorScheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aµ\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aµ\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a)\u0010.\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\b*\u00020\u00042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\b*\u00020\u00042\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\b*\u000207H\u0001ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "lightColorScheme-G1PFc-w", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-Hht5A8o", "(Landroidx/compose/material3/ColorScheme;JF)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "toColor", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "updateColorSchemeFrom", "", "other", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ColorScheme invoke() {
            return ColorSchemeKt.m1416lightColorSchemeG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536870911, null);
        }
    });

    /* JADX INFO: compiled from: ColorScheme.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1416lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM2084getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2084getPrimary0d7_KjU() : j;
        return m1415lightColorSchemeG1PFcw(jM2084getPrimary0d7_KjU, (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2074getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2085getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2075getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2069getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2087getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2076getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2088getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2077getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2092getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2080getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2093getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2081getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2065getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2071getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2089getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2078getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2091getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2079getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM2084getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2070getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2068getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2066getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2072getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2067getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2073getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m2082getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m2083getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2086getScrim0d7_KjU() : j29);
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1415lightColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1414darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM2055getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2055getPrimary0d7_KjU() : j;
        return m1413darkColorSchemeG1PFcw(jM2055getPrimary0d7_KjU, (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2045getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2056getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2046getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2040getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2058getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2047getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2059getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2048getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2063getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2051getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2064getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2052getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2036getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2042getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2060getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2049getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2062getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2050getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM2055getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2041getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2039getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2037getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2043getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2038getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2044getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m2053getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m2054getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2057getScrim0d7_KjU() : j29);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1413darkColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1411contentColorFor4WTKRHQ(ColorScheme contentColorFor, long backgroundColor) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        return Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1371getPrimary0d7_KjU()) ? contentColorFor.m1361getOnPrimary0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1374getSecondary0d7_KjU()) ? contentColorFor.m1363getOnSecondary0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1379getTertiary0d7_KjU()) ? contentColorFor.m1367getOnTertiary0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1352getBackground0d7_KjU()) ? contentColorFor.m1358getOnBackground0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1353getError0d7_KjU()) ? contentColorFor.m1359getOnError0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1376getSurface0d7_KjU()) ? contentColorFor.m1365getOnSurface0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1378getSurfaceVariant0d7_KjU()) ? contentColorFor.m1366getOnSurfaceVariant0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1372getPrimaryContainer0d7_KjU()) ? contentColorFor.m1362getOnPrimaryContainer0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1375getSecondaryContainer0d7_KjU()) ? contentColorFor.m1364getOnSecondaryContainer0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1380getTertiaryContainer0d7_KjU()) ? contentColorFor.m1368getOnTertiaryContainer0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1354getErrorContainer0d7_KjU()) ? contentColorFor.m1360getOnErrorContainer0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1357getInverseSurface0d7_KjU()) ? contentColorFor.m1355getInverseOnSurface0d7_KjU() : Color.INSTANCE.m2983getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1412contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color)*474@21497L11,475@21581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, $changed, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long $this$takeOrElse_u2dDxMtmZc$iv = m1411contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme($composer, 6), backgroundColor);
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2983getUnspecified0d7_KjU())) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $this$takeOrElse_u2dDxMtmZc$iv = ((Color) objConsume).m2957unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    /* JADX INFO: renamed from: applyTonalElevation-Hht5A8o, reason: not valid java name */
    public static final long m1410applyTonalElevationHht5A8o(ColorScheme applyTonalElevation, long backgroundColor, float elevation) {
        Intrinsics.checkNotNullParameter(applyTonalElevation, "$this$applyTonalElevation");
        if (Color.m2948equalsimpl0(backgroundColor, applyTonalElevation.m1376getSurface0d7_KjU())) {
            return m1417surfaceColorAtElevation3ABfNKs(applyTonalElevation, elevation);
        }
        return backgroundColor;
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m1417surfaceColorAtElevation3ABfNKs(ColorScheme surfaceColorAtElevation, float elevation) {
        Intrinsics.checkNotNullParameter(surfaceColorAtElevation, "$this$surfaceColorAtElevation");
        if (Dp.m5217equalsimpl0(elevation, Dp.m5212constructorimpl(0))) {
            return surfaceColorAtElevation.m1376getSurface0d7_KjU();
        }
        float alpha = ((((float) Math.log(1 + elevation)) * 4.5f) + 2.0f) / 100.0f;
        long jM1377getSurfaceTint0d7_KjU = surfaceColorAtElevation.m1377getSurfaceTint0d7_KjU();
        return ColorKt.m2992compositeOverOWjLjI(Color.m2945copywmQWz5c(jM1377getSurfaceTint0d7_KjU, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1377getSurfaceTint0d7_KjU) : alpha, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1377getSurfaceTint0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1377getSurfaceTint0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1377getSurfaceTint0d7_KjU) : 0.0f), surfaceColorAtElevation.m1376getSurface0d7_KjU());
    }

    public static final void updateColorSchemeFrom(ColorScheme $this$updateColorSchemeFrom, ColorScheme other) {
        Intrinsics.checkNotNullParameter($this$updateColorSchemeFrom, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$updateColorSchemeFrom.m1400setPrimary8_81llA$material3_release(other.m1371getPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1390setOnPrimary8_81llA$material3_release(other.m1361getOnPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1401setPrimaryContainer8_81llA$material3_release(other.m1372getPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1391setOnPrimaryContainer8_81llA$material3_release(other.m1362getOnPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1385setInversePrimary8_81llA$material3_release(other.m1356getInversePrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1403setSecondary8_81llA$material3_release(other.m1374getSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m1392setOnSecondary8_81llA$material3_release(other.m1363getOnSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m1404setSecondaryContainer8_81llA$material3_release(other.m1375getSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1393setOnSecondaryContainer8_81llA$material3_release(other.m1364getOnSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1408setTertiary8_81llA$material3_release(other.m1379getTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m1396setOnTertiary8_81llA$material3_release(other.m1367getOnTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m1409setTertiaryContainer8_81llA$material3_release(other.m1380getTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1397setOnTertiaryContainer8_81llA$material3_release(other.m1368getOnTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1381setBackground8_81llA$material3_release(other.m1352getBackground0d7_KjU());
        $this$updateColorSchemeFrom.m1387setOnBackground8_81llA$material3_release(other.m1358getOnBackground0d7_KjU());
        $this$updateColorSchemeFrom.m1405setSurface8_81llA$material3_release(other.m1376getSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1394setOnSurface8_81llA$material3_release(other.m1365getOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1407setSurfaceVariant8_81llA$material3_release(other.m1378getSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1395setOnSurfaceVariant8_81llA$material3_release(other.m1366getOnSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1406setSurfaceTint8_81llA$material3_release(other.m1377getSurfaceTint0d7_KjU());
        $this$updateColorSchemeFrom.m1386setInverseSurface8_81llA$material3_release(other.m1357getInverseSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1384setInverseOnSurface8_81llA$material3_release(other.m1355getInverseOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1382setError8_81llA$material3_release(other.m1353getError0d7_KjU());
        $this$updateColorSchemeFrom.m1388setOnError8_81llA$material3_release(other.m1359getOnError0d7_KjU());
        $this$updateColorSchemeFrom.m1383setErrorContainer8_81llA$material3_release(other.m1354getErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1389setOnErrorContainer8_81llA$material3_release(other.m1360getOnErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1398setOutline8_81llA$material3_release(other.m1369getOutline0d7_KjU());
        $this$updateColorSchemeFrom.m1399setOutlineVariant8_81llA$material3_release(other.m1370getOutlineVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1402setScrim8_81llA$material3_release(other.m1373getScrim0d7_KjU());
    }

    public static final long fromToken(ColorScheme $this$fromToken, ColorSchemeKeyTokens value) {
        Intrinsics.checkNotNullParameter($this$fromToken, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return $this$fromToken.m1352getBackground0d7_KjU();
            case 2:
                return $this$fromToken.m1353getError0d7_KjU();
            case 3:
                return $this$fromToken.m1354getErrorContainer0d7_KjU();
            case 4:
                return $this$fromToken.m1355getInverseOnSurface0d7_KjU();
            case 5:
                return $this$fromToken.m1356getInversePrimary0d7_KjU();
            case 6:
                return $this$fromToken.m1357getInverseSurface0d7_KjU();
            case 7:
                return $this$fromToken.m1358getOnBackground0d7_KjU();
            case 8:
                return $this$fromToken.m1359getOnError0d7_KjU();
            case 9:
                return $this$fromToken.m1360getOnErrorContainer0d7_KjU();
            case 10:
                return $this$fromToken.m1361getOnPrimary0d7_KjU();
            case 11:
                return $this$fromToken.m1362getOnPrimaryContainer0d7_KjU();
            case 12:
                return $this$fromToken.m1363getOnSecondary0d7_KjU();
            case 13:
                return $this$fromToken.m1364getOnSecondaryContainer0d7_KjU();
            case 14:
                return $this$fromToken.m1365getOnSurface0d7_KjU();
            case 15:
                return $this$fromToken.m1366getOnSurfaceVariant0d7_KjU();
            case 16:
                return $this$fromToken.m1377getSurfaceTint0d7_KjU();
            case 17:
                return $this$fromToken.m1367getOnTertiary0d7_KjU();
            case 18:
                return $this$fromToken.m1368getOnTertiaryContainer0d7_KjU();
            case 19:
                return $this$fromToken.m1369getOutline0d7_KjU();
            case 20:
                return $this$fromToken.m1370getOutlineVariant0d7_KjU();
            case 21:
                return $this$fromToken.m1371getPrimary0d7_KjU();
            case 22:
                return $this$fromToken.m1372getPrimaryContainer0d7_KjU();
            case 23:
                return $this$fromToken.m1373getScrim0d7_KjU();
            case 24:
                return $this$fromToken.m1374getSecondary0d7_KjU();
            case 25:
                return $this$fromToken.m1375getSecondaryContainer0d7_KjU();
            case 26:
                return $this$fromToken.m1376getSurface0d7_KjU();
            case 27:
                return $this$fromToken.m1378getSurfaceVariant0d7_KjU();
            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                return $this$fromToken.m1379getTertiary0d7_KjU();
            case 29:
                return $this$fromToken.m1380getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long toColor(ColorSchemeKeyTokens $this$toColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$toColor, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1330949347, "C(toColor)612@27498L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, $changed, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $this$toColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return jFromToken;
    }
}
