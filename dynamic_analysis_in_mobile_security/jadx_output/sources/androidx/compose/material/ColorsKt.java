package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u008b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u008b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001f\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            return ColorsKt.m1055lightColors2qZNXz8((4095 & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (4095 & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (4095 & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (4095 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (4095 & 16) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : 0L, (4095 & 32) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : 0L, (4095 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (4095 & 128) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : 0L, (4095 & 256) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : 0L, (4095 & 512) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : 0L, (4095 & 1024) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : 0L, (4095 & 2048) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : 0L);
        }
    });

    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1055lightColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, true, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m1054darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        return m1053darkColors2qZNXz8(jColor, jColor2, jColor3, (i & 8) != 0 ? jColor3 : j4, (i & 16) != 0 ? ColorKt.Color(4279374354L) : j5, (i & 32) != 0 ? ColorKt.Color(4279374354L) : j6, (i & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i & 128) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : j8, (i & 256) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : j9, (i & 512) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : j10, (i & 1024) != 0 ? Color.INSTANCE.m2984getWhite0d7_KjU() : j11, (i & 2048) != 0 ? Color.INSTANCE.m2973getBlack0d7_KjU() : j12);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1053darkColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, false, null);
    }

    public static final long getPrimarySurface(Colors $this$primarySurface) {
        Intrinsics.checkNotNullParameter($this$primarySurface, "<this>");
        return $this$primarySurface.isLight() ? $this$primarySurface.m1034getPrimary0d7_KjU() : $this$primarySurface.m1038getSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1051contentColorFor4WTKRHQ(Colors contentColorFor, long backgroundColor) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        if (!Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1034getPrimary0d7_KjU()) && !Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1035getPrimaryVariant0d7_KjU())) {
            if (!Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1036getSecondary0d7_KjU()) && !Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1037getSecondaryVariant0d7_KjU())) {
                return Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1027getBackground0d7_KjU()) ? contentColorFor.m1029getOnBackground0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1038getSurface0d7_KjU()) ? contentColorFor.m1033getOnSurface0d7_KjU() : Color.m2948equalsimpl0(backgroundColor, contentColorFor.m1028getError0d7_KjU()) ? contentColorFor.m1030getOnError0d7_KjU() : Color.INSTANCE.m2983getUnspecified0d7_KjU();
            }
            return contentColorFor.m1032getOnSecondary0d7_KjU();
        }
        return contentColorFor.m1031getOnPrimary0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1052contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 441849991, "C(contentColorFor)P(0:c#ui.graphics.Color)*296@11462L6,296@11533L7:Colors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, $changed, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long $this$takeOrElse_u2dDxMtmZc$iv = m1051contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors($composer, 6), backgroundColor);
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

    public static final void updateColorsFrom(Colors $this$updateColorsFrom, Colors other) {
        Intrinsics.checkNotNullParameter($this$updateColorsFrom, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$updateColorsFrom.m1046setPrimary8_81llA$material_release(other.m1034getPrimary0d7_KjU());
        $this$updateColorsFrom.m1047setPrimaryVariant8_81llA$material_release(other.m1035getPrimaryVariant0d7_KjU());
        $this$updateColorsFrom.m1048setSecondary8_81llA$material_release(other.m1036getSecondary0d7_KjU());
        $this$updateColorsFrom.m1049setSecondaryVariant8_81llA$material_release(other.m1037getSecondaryVariant0d7_KjU());
        $this$updateColorsFrom.m1039setBackground8_81llA$material_release(other.m1027getBackground0d7_KjU());
        $this$updateColorsFrom.m1050setSurface8_81llA$material_release(other.m1038getSurface0d7_KjU());
        $this$updateColorsFrom.m1040setError8_81llA$material_release(other.m1028getError0d7_KjU());
        $this$updateColorsFrom.m1043setOnPrimary8_81llA$material_release(other.m1031getOnPrimary0d7_KjU());
        $this$updateColorsFrom.m1044setOnSecondary8_81llA$material_release(other.m1032getOnSecondary0d7_KjU());
        $this$updateColorsFrom.m1041setOnBackground8_81llA$material_release(other.m1029getOnBackground0d7_KjU());
        $this$updateColorsFrom.m1045setOnSurface8_81llA$material_release(other.m1033getOnSurface0d7_KjU());
        $this$updateColorsFrom.m1042setOnError8_81llA$material_release(other.m1030getOnError0d7_KjU());
        $this$updateColorsFrom.setLight$material_release(other.isLight());
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
