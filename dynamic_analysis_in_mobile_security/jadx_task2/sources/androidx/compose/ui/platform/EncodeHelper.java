package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncodeHelper {
    private Parcel parcel;

    public EncodeHelper() {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final String encodedString() {
        String strEncodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return strEncodeToString;
    }

    public final void encode(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        if (!Color.m2630equalsimpl0(spanStyle.m4363getColor0d7_KjU(), Color.INSTANCE.m2665getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m4192encode8_81llA(spanStyle.m4363getColor0d7_KjU());
        }
        if (!TextUnit.m5051equalsimpl0(spanStyle.getFontSize(), TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m4189encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int iM4503unboximpl = fontStyle.m4503unboximpl();
            encode((byte) 4);
            m4194encodenzbMABs(iM4503unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int value = fontSynthesis.getValue();
            encode((byte) 5);
            m4191encode6p3vJLY(value);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m5051equalsimpl0(spanStyle.getLetterSpacing(), TextUnit.INSTANCE.m5065getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m4189encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM4666unboximpl = baselineShift.m4666unboximpl();
            encode((byte) 8);
            m4190encode4Dl_Bck(fM4666unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m2630equalsimpl0(spanStyle.getBackground(), Color.INSTANCE.m2665getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m4192encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m4192encode8_81llA(long color) {
        m4193encodeVKZWuLQ(color);
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m4189encodeR2X_6o(long textUnit) {
        long jM5053getTypeUIouoOA = TextUnit.m5053getTypeUIouoOA(textUnit);
        byte b = 0;
        if (!TextUnitType.m5082equalsimpl0(jM5053getTypeUIouoOA, TextUnitType.INSTANCE.m5088getUnspecifiedUIouoOA())) {
            if (TextUnitType.m5082equalsimpl0(jM5053getTypeUIouoOA, TextUnitType.INSTANCE.m5087getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m5082equalsimpl0(jM5053getTypeUIouoOA, TextUnitType.INSTANCE.m5086getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m5082equalsimpl0(TextUnit.m5053getTypeUIouoOA(textUnit), TextUnitType.INSTANCE.m5088getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m5054getValueimpl(textUnit));
    }

    public final void encode(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m4194encodenzbMABs(int fontStyle) {
        byte b = 0;
        if (!FontStyle.m4500equalsimpl0(fontStyle, FontStyle.INSTANCE.m4505getNormal_LCdwA()) && FontStyle.m4500equalsimpl0(fontStyle, FontStyle.INSTANCE.m4504getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m4191encode6p3vJLY(int fontSynthesis) {
        byte b = 0;
        if (!FontSynthesis.m4509equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m4516getNoneGVVA2EU())) {
            if (FontSynthesis.m4509equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m4515getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m4509equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m4518getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m4509equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m4517getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m4190encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m4192encode8_81llA(shadow.getColor());
        encode(Offset.m2390getXimpl(shadow.getOffset()));
        encode(Offset.m2391getYimpl(shadow.getOffset()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m4193encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.parcel.writeString(string);
    }
}
