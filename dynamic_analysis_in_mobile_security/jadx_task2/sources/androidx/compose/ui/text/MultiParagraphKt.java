package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiParagraph.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a-\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0082\b¨\u0006\u000f"}, d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "fastBinarySearch", "T", "comparison", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> list, Function1<? super T, Integer> function1) {
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int iIntValue = function1.invoke(list.get(i2)).intValue();
            if (iIntValue < 0) {
                i = i2 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int findParagraphByIndex(List<ParagraphInfo> paragraphInfoList, int i) {
        byte b;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i3);
            if (paragraphInfo.getStartIndex() > i) {
                b = 1;
            } else {
                b = paragraphInfo.getEndIndex() <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByY(List<ParagraphInfo> paragraphInfoList, float f) {
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i2);
            byte b = paragraphInfo.getTop() > f ? (byte) 1 : paragraphInfo.getBottom() <= f ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int findParagraphByLineIndex(List<ParagraphInfo> paragraphInfoList, int i) {
        byte b;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i3);
            if (paragraphInfo.getStartLineIndex() > i) {
                b = 1;
            } else {
                b = paragraphInfo.getEndLineIndex() <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }
}
