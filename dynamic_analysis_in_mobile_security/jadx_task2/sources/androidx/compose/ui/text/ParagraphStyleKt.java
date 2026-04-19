package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParagraphStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001aq\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-HtYhynw", "(Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle start, ParagraphStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(start.getTextAlign(), stop.getTextAlign(), f);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(start.getTextDirection(), stop.getTextDirection(), f);
        long jM4369lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m4369lerpTextUnitInheritableC3pnCVY(start.getLineHeight(), stop.getLineHeight(), f);
        TextIndent textIndent = start.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = stop.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, jM4369lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(start.getLineHeightStyle(), stop.getLineHeightStyle(), f), (LineBreak) SpanStyleKt.lerpDiscrete(start.getLineBreak(), stop.getLineBreak(), f), (Hyphens) SpanStyleKt.lerpDiscrete(start.getHyphens(), stop.getHyphens(), f), (TextMotion) SpanStyleKt.lerpDiscrete(start.getTextMotion(), stop.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle style, LayoutDirection direction) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(direction, "direction");
        TextAlign textAlignM4760boximpl = TextAlign.m4760boximpl(style.getTextAlignOrDefault());
        TextDirection textDirectionM4773boximpl = TextDirection.m4773boximpl(TextStyleKt.m4436resolveTextDirectionYj3eThk(direction, style.getTextDirection()));
        long lineHeight = TextUnitKt.m5072isUnspecifiedR2X_6o(style.getLineHeight()) ? DefaultLineHeight : style.getLineHeight();
        TextIndent textIndent = style.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = style.getPlatformStyle();
        LineHeightStyle lineHeightStyle = style.getLineHeightStyle();
        LineBreak lineBreakM4688boximpl = LineBreak.m4688boximpl(style.getLineBreakOrDefault());
        Hyphens hyphensM4679boximpl = Hyphens.m4679boximpl(style.getHyphensOrDefault());
        TextMotion textMotion = style.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(textAlignM4760boximpl, textDirectionM4773boximpl, lineHeight, textIndent2, platformStyle, lineHeightStyle, lineBreakM4688boximpl, hyphensM4679boximpl, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: fastMerge-HtYhynw, reason: not valid java name */
    public static final ParagraphStyle m4322fastMergeHtYhynw(ParagraphStyle fastMerge, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        long j2;
        TextAlign textAlign2 = textAlign;
        TextIndent textIndent2 = textIndent;
        Intrinsics.checkNotNullParameter(fastMerge, "$this$fastMerge");
        if (textAlign2 == null || Intrinsics.areEqual(textAlign2, fastMerge.getTextAlign())) {
            if (!TextUnitKt.m5072isUnspecifiedR2X_6o(j)) {
                j2 = j;
                if (TextUnit.m5051equalsimpl0(j2, fastMerge.getLineHeight())) {
                }
            } else {
                j2 = j;
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, fastMerge.getTextIndent())) && ((textDirection == null || Intrinsics.areEqual(textDirection, fastMerge.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, fastMerge.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, fastMerge.getLineHeightStyle())) && ((lineBreak == null || Intrinsics.areEqual(lineBreak, fastMerge.getLineBreak())) && ((hyphens == null || Intrinsics.areEqual(hyphens, fastMerge.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, fastMerge.getTextMotion())))))))) {
                return fastMerge;
            }
        } else {
            j2 = j;
        }
        long lineHeight = TextUnitKt.m5072isUnspecifiedR2X_6o(j) ? fastMerge.getLineHeight() : j2;
        if (textIndent2 == null) {
            textIndent2 = fastMerge.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (textAlign2 == null) {
            textAlign2 = fastMerge.getTextAlign();
        }
        return new ParagraphStyle(textAlign2, textDirection == null ? fastMerge.getTextDirection() : textDirection, lineHeight, textIndent3, mergePlatformStyle(fastMerge, platformParagraphStyle), lineHeightStyle == null ? fastMerge.getLineHeightStyle() : lineHeightStyle, lineBreak == null ? fastMerge.getLineBreak() : lineBreak, hyphens == null ? fastMerge.getHyphens() : hyphens, textMotion == null ? fastMerge.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
