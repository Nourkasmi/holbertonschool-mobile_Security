package androidx.compose.material3;

import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IncludeFontPaddingHelper.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"copyAndSetFontPadding", "Landroidx/compose/ui/text/TextStyle;", "style", "includeFontPadding", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IncludeFontPaddingHelper_androidKt {
    public static final TextStyle copyAndSetFontPadding(TextStyle style, boolean includeFontPadding) {
        Intrinsics.checkNotNullParameter(style, "style");
        return TextStyle.m4729copyCXVQc50$default(style, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, new PlatformTextStyle(includeFontPadding), null, null, null, 3932159, null);
    }
}
