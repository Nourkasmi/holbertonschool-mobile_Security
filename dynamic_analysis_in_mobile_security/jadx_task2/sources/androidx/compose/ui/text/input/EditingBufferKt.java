package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4547updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM4400getLengthimpl;
        int iM4402getMinimpl = TextRange.m4402getMinimpl(j);
        int iM4401getMaximpl = TextRange.m4401getMaximpl(j);
        if (TextRange.m4406intersects5zctL8(j2, j)) {
            if (TextRange.m4394contains5zctL8(j2, j)) {
                iM4402getMinimpl = TextRange.m4402getMinimpl(j2);
                iM4401getMaximpl = iM4402getMinimpl;
            } else {
                if (TextRange.m4394contains5zctL8(j, j2)) {
                    iM4400getLengthimpl = TextRange.m4400getLengthimpl(j2);
                } else if (TextRange.m4395containsimpl(j2, iM4402getMinimpl)) {
                    iM4402getMinimpl = TextRange.m4402getMinimpl(j2);
                    iM4400getLengthimpl = TextRange.m4400getLengthimpl(j2);
                } else {
                    iM4401getMaximpl = TextRange.m4402getMinimpl(j2);
                }
                iM4401getMaximpl -= iM4400getLengthimpl;
            }
        } else if (iM4401getMaximpl > TextRange.m4402getMinimpl(j2)) {
            iM4402getMinimpl -= TextRange.m4400getLengthimpl(j2);
            iM4400getLengthimpl = TextRange.m4400getLengthimpl(j2);
            iM4401getMaximpl -= iM4400getLengthimpl;
        }
        return TextRangeKt.TextRange(iM4402getMinimpl, iM4401getMaximpl);
    }
}
