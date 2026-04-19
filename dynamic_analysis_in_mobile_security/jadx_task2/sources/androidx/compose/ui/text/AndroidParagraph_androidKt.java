package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidParagraph.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u001d\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0006*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency-0_XeFpE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m4274toLayoutAlignAMY3VfE(TextAlign textAlign) {
        int iM4770getLefte0LSkKk = TextAlign.INSTANCE.m4770getLefte0LSkKk();
        if (textAlign != null && TextAlign.m4763equalsimpl0(textAlign.getValue(), iM4770getLefte0LSkKk)) {
            return 3;
        }
        int iM4771getRighte0LSkKk = TextAlign.INSTANCE.m4771getRighte0LSkKk();
        if (textAlign != null && TextAlign.m4763equalsimpl0(textAlign.getValue(), iM4771getRighte0LSkKk)) {
            return 4;
        }
        int iM4767getCentere0LSkKk = TextAlign.INSTANCE.m4767getCentere0LSkKk();
        if (textAlign != null && TextAlign.m4763equalsimpl0(textAlign.getValue(), iM4767getCentere0LSkKk)) {
            return 2;
        }
        int iM4772getStarte0LSkKk = TextAlign.INSTANCE.m4772getStarte0LSkKk();
        if (textAlign == null || !TextAlign.m4763equalsimpl0(textAlign.getValue(), iM4772getStarte0LSkKk)) {
            int iM4768getEnde0LSkKk = TextAlign.INSTANCE.m4768getEnde0LSkKk();
            if (textAlign != null && TextAlign.m4763equalsimpl0(textAlign.getValue(), iM4768getEnde0LSkKk)) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency-0_XeFpE, reason: not valid java name */
    public static final int m4276toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        int iM4686getAutovmbZdU8 = Hyphens.INSTANCE.m4686getAutovmbZdU8();
        if (hyphens != null && Hyphens.m4682equalsimpl0(hyphens.getValue(), iM4686getAutovmbZdU8)) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        int iM4687getNonevmbZdU8 = Hyphens.INSTANCE.m4687getNonevmbZdU8();
        if (hyphens != null) {
            Hyphens.m4682equalsimpl0(hyphens.getValue(), iM4687getNonevmbZdU8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m4275toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        int iM4713getSimplefcGXIks = LineBreak.Strategy.INSTANCE.m4713getSimplefcGXIks();
        if (strategy != null && LineBreak.Strategy.m4707equalsimpl0(strategy.getValue(), iM4713getSimplefcGXIks)) {
            return 0;
        }
        int iM4712getHighQualityfcGXIks = LineBreak.Strategy.INSTANCE.m4712getHighQualityfcGXIks();
        if (strategy != null && LineBreak.Strategy.m4707equalsimpl0(strategy.getValue(), iM4712getHighQualityfcGXIks)) {
            return 1;
        }
        return (strategy != null && LineBreak.Strategy.m4707equalsimpl0(strategy.getValue(), LineBreak.Strategy.INSTANCE.m4711getBalancedfcGXIks())) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-4a2g8L8, reason: not valid java name */
    public static final int m4277toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        int iM4721getDefaultusljTpc = LineBreak.Strictness.INSTANCE.m4721getDefaultusljTpc();
        if (strictness != null && LineBreak.Strictness.m4717equalsimpl0(strictness.getValue(), iM4721getDefaultusljTpc)) {
            return 0;
        }
        int iM4722getLooseusljTpc = LineBreak.Strictness.INSTANCE.m4722getLooseusljTpc();
        if (strictness != null && LineBreak.Strictness.m4717equalsimpl0(strictness.getValue(), iM4722getLooseusljTpc)) {
            return 1;
        }
        int iM4723getNormalusljTpc = LineBreak.Strictness.INSTANCE.m4723getNormalusljTpc();
        if (strictness != null && LineBreak.Strictness.m4717equalsimpl0(strictness.getValue(), iM4723getNormalusljTpc)) {
            return 2;
        }
        return (strictness != null && LineBreak.Strictness.m4717equalsimpl0(strictness.getValue(), LineBreak.Strictness.INSTANCE.m4724getStrictusljTpc())) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m4278toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        int iM4732getDefaultjp8hJ3c = LineBreak.WordBreak.INSTANCE.m4732getDefaultjp8hJ3c();
        if (wordBreak != null && LineBreak.WordBreak.m4728equalsimpl0(wordBreak.getValue(), iM4732getDefaultjp8hJ3c)) {
            return 0;
        }
        return (wordBreak != null && LineBreak.WordBreak.m4728equalsimpl0(wordBreak.getValue(), LineBreak.WordBreak.INSTANCE.m4733getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m5051equalsimpl0(textStyle.m4430getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5051equalsimpl0(textStyle.m4430getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE()) || textStyle.m4433getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign textAlignM4433getTextAlignbuA522U = textStyle.m4433getTextAlignbuA522U();
        int iM4772getStarte0LSkKk = TextAlign.INSTANCE.m4772getStarte0LSkKk();
        if (textAlignM4433getTextAlignbuA522U != null && TextAlign.m4763equalsimpl0(textAlignM4433getTextAlignbuA522U.getValue(), iM4772getStarte0LSkKk)) {
            return false;
        }
        TextAlign textAlignM4433getTextAlignbuA522U2 = textStyle.m4433getTextAlignbuA522U();
        return textAlignM4433getTextAlignbuA522U2 == null || !TextAlign.m4763equalsimpl0(textAlignM4433getTextAlignbuA522U2.getValue(), TextAlign.INSTANCE.m4769getJustifye0LSkKk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}
