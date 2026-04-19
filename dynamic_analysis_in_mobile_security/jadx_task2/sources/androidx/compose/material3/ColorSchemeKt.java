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
            return ColorSchemeKt.m1098lightColorSchemeG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536870911, null);
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
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1098lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM1766getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m1766getPrimary0d7_KjU() : j;
        return m1097lightColorSchemeG1PFcw(jM1766getPrimary0d7_KjU, (i & 2) != 0 ? ColorLightTokens.INSTANCE.m1756getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorLightTokens.INSTANCE.m1767getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorLightTokens.INSTANCE.m1757getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorLightTokens.INSTANCE.m1751getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorLightTokens.INSTANCE.m1769getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorLightTokens.INSTANCE.m1758getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorLightTokens.INSTANCE.m1770getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorLightTokens.INSTANCE.m1759getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorLightTokens.INSTANCE.m1774getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m1762getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m1775getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m1763getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m1747getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m1753getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m1771getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m1760getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m1773getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m1761getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM1766getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m1752getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m1750getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m1748getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m1754getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m1749getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m1755getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m1764getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m1765getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m1768getScrim0d7_KjU() : j29);
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1097lightColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1096darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM1737getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m1737getPrimary0d7_KjU() : j;
        return m1095darkColorSchemeG1PFcw(jM1737getPrimary0d7_KjU, (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m1727getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m1738getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m1728getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m1722getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m1740getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m1729getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m1741getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m1730getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m1745getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m1733getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m1746getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m1734getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m1718getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m1724getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m1742getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m1731getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m1744getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m1732getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? jM1737getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m1723getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m1721getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m1719getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m1725getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m1720getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m1726getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m1735getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m1736getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m1739getScrim0d7_KjU() : j29);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1095darkColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, null);
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1093contentColorFor4WTKRHQ(ColorScheme contentColorFor, long j) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        return Color.m2630equalsimpl0(j, contentColorFor.m1053getPrimary0d7_KjU()) ? contentColorFor.m1043getOnPrimary0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1056getSecondary0d7_KjU()) ? contentColorFor.m1045getOnSecondary0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1061getTertiary0d7_KjU()) ? contentColorFor.m1049getOnTertiary0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1034getBackground0d7_KjU()) ? contentColorFor.m1040getOnBackground0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1035getError0d7_KjU()) ? contentColorFor.m1041getOnError0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1058getSurface0d7_KjU()) ? contentColorFor.m1047getOnSurface0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1060getSurfaceVariant0d7_KjU()) ? contentColorFor.m1048getOnSurfaceVariant0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1054getPrimaryContainer0d7_KjU()) ? contentColorFor.m1044getOnPrimaryContainer0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1057getSecondaryContainer0d7_KjU()) ? contentColorFor.m1046getOnSecondaryContainer0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1062getTertiaryContainer0d7_KjU()) ? contentColorFor.m1050getOnTertiaryContainer0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1036getErrorContainer0d7_KjU()) ? contentColorFor.m1042getOnErrorContainer0d7_KjU() : Color.m2630equalsimpl0(j, contentColorFor.m1039getInverseSurface0d7_KjU()) ? contentColorFor.m1037getInverseOnSurface0d7_KjU() : Color.INSTANCE.m2665getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1094contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color)*474@21497L11,475@21581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long jM1093contentColorFor4WTKRHQ = m1093contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (jM1093contentColorFor4WTKRHQ == Color.INSTANCE.m2665getUnspecified0d7_KjU()) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM1093contentColorFor4WTKRHQ = ((Color) objConsume).m2639unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM1093contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: applyTonalElevation-Hht5A8o, reason: not valid java name */
    public static final long m1092applyTonalElevationHht5A8o(ColorScheme applyTonalElevation, long j, float f) {
        Intrinsics.checkNotNullParameter(applyTonalElevation, "$this$applyTonalElevation");
        return Color.m2630equalsimpl0(j, applyTonalElevation.m1058getSurface0d7_KjU()) ? m1099surfaceColorAtElevation3ABfNKs(applyTonalElevation, f) : j;
    }

    public static final void updateColorSchemeFrom(ColorScheme colorScheme, ColorScheme other) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        colorScheme.m1082setPrimary8_81llA$material3_release(other.m1053getPrimary0d7_KjU());
        colorScheme.m1072setOnPrimary8_81llA$material3_release(other.m1043getOnPrimary0d7_KjU());
        colorScheme.m1083setPrimaryContainer8_81llA$material3_release(other.m1054getPrimaryContainer0d7_KjU());
        colorScheme.m1073setOnPrimaryContainer8_81llA$material3_release(other.m1044getOnPrimaryContainer0d7_KjU());
        colorScheme.m1067setInversePrimary8_81llA$material3_release(other.m1038getInversePrimary0d7_KjU());
        colorScheme.m1085setSecondary8_81llA$material3_release(other.m1056getSecondary0d7_KjU());
        colorScheme.m1074setOnSecondary8_81llA$material3_release(other.m1045getOnSecondary0d7_KjU());
        colorScheme.m1086setSecondaryContainer8_81llA$material3_release(other.m1057getSecondaryContainer0d7_KjU());
        colorScheme.m1075setOnSecondaryContainer8_81llA$material3_release(other.m1046getOnSecondaryContainer0d7_KjU());
        colorScheme.m1090setTertiary8_81llA$material3_release(other.m1061getTertiary0d7_KjU());
        colorScheme.m1078setOnTertiary8_81llA$material3_release(other.m1049getOnTertiary0d7_KjU());
        colorScheme.m1091setTertiaryContainer8_81llA$material3_release(other.m1062getTertiaryContainer0d7_KjU());
        colorScheme.m1079setOnTertiaryContainer8_81llA$material3_release(other.m1050getOnTertiaryContainer0d7_KjU());
        colorScheme.m1063setBackground8_81llA$material3_release(other.m1034getBackground0d7_KjU());
        colorScheme.m1069setOnBackground8_81llA$material3_release(other.m1040getOnBackground0d7_KjU());
        colorScheme.m1087setSurface8_81llA$material3_release(other.m1058getSurface0d7_KjU());
        colorScheme.m1076setOnSurface8_81llA$material3_release(other.m1047getOnSurface0d7_KjU());
        colorScheme.m1089setSurfaceVariant8_81llA$material3_release(other.m1060getSurfaceVariant0d7_KjU());
        colorScheme.m1077setOnSurfaceVariant8_81llA$material3_release(other.m1048getOnSurfaceVariant0d7_KjU());
        colorScheme.m1088setSurfaceTint8_81llA$material3_release(other.m1059getSurfaceTint0d7_KjU());
        colorScheme.m1068setInverseSurface8_81llA$material3_release(other.m1039getInverseSurface0d7_KjU());
        colorScheme.m1066setInverseOnSurface8_81llA$material3_release(other.m1037getInverseOnSurface0d7_KjU());
        colorScheme.m1064setError8_81llA$material3_release(other.m1035getError0d7_KjU());
        colorScheme.m1070setOnError8_81llA$material3_release(other.m1041getOnError0d7_KjU());
        colorScheme.m1065setErrorContainer8_81llA$material3_release(other.m1036getErrorContainer0d7_KjU());
        colorScheme.m1071setOnErrorContainer8_81llA$material3_release(other.m1042getOnErrorContainer0d7_KjU());
        colorScheme.m1080setOutline8_81llA$material3_release(other.m1051getOutline0d7_KjU());
        colorScheme.m1081setOutlineVariant8_81llA$material3_release(other.m1052getOutlineVariant0d7_KjU());
        colorScheme.m1084setScrim8_81llA$material3_release(other.m1055getScrim0d7_KjU());
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens value) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return colorScheme.m1034getBackground0d7_KjU();
            case 2:
                return colorScheme.m1035getError0d7_KjU();
            case 3:
                return colorScheme.m1036getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1037getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1038getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1039getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1040getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1041getOnError0d7_KjU();
            case 9:
                return colorScheme.m1042getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1043getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1044getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1045getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1046getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1047getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1048getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1059getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1049getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1050getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1051getOutline0d7_KjU();
            case 20:
                return colorScheme.m1052getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1053getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1054getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1055getScrim0d7_KjU();
            case 24:
                return colorScheme.m1056getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1057getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1058getSurface0d7_KjU();
            case 27:
                return colorScheme.m1060getSurfaceVariant0d7_KjU();
            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                return colorScheme.m1061getTertiary0d7_KjU();
            case 29:
                return colorScheme.m1062getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final long toColor(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorSchemeKeyTokens, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 1330949347, "C(toColor)612@27498L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, i, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jFromToken;
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m1099surfaceColorAtElevation3ABfNKs(ColorScheme surfaceColorAtElevation, float f) {
        Intrinsics.checkNotNullParameter(surfaceColorAtElevation, "$this$surfaceColorAtElevation");
        if (Dp.m4878equalsimpl0(f, Dp.m4873constructorimpl(0))) {
            return surfaceColorAtElevation.m1058getSurface0d7_KjU();
        }
        return ColorKt.m2674compositeOverOWjLjI(Color.m2628copywmQWz5c$default(surfaceColorAtElevation.m1059getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), surfaceColorAtElevation.m1058getSurface0d7_KjU());
    }
}
