package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiContentMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bç\u0080\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J5\u0010\u000b\u001a\u00020\f*\u00020\r2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MultiContentMeasurePolicy {
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    MeasureResult m4232measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j);

    default int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
        int $i$f$fastMap = 0;
        List target$iv = new ArrayList(list.size());
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        int $i$f$fastForEach = 0;
        int index$iv$iv = 0;
        int size = list2.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = list2.get(index$iv$iv);
            List list3 = target$iv;
            List<? extends IntrinsicMeasurable> list4 = (List) item$iv$iv;
            List<? extends List<? extends IntrinsicMeasurable>> list5 = list;
            ArrayList target$iv2 = new ArrayList(list4.size());
            List<? extends IntrinsicMeasurable> list6 = list4;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = list6.size();
            List<? extends List<? extends IntrinsicMeasurable>> list7 = list2;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                int i = $i$f$fastMap3;
                IntrinsicMeasurable it = (IntrinsicMeasurable) list6.get(index$iv$iv2);
                target$iv2.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
                index$iv$iv2++;
                list6 = list6;
                $i$f$fastMap3 = i;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                item$iv$iv = item$iv$iv;
            }
            list3.add(target$iv2);
            index$iv$iv++;
            list = list5;
            $i$f$fastMap = $i$f$fastMap2;
            list2 = list7;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$minIntrinsicWidth, $this$minIntrinsicWidth.getLayoutDirection());
        MeasureResult layoutResult = m4232measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getWidth();
    }

    default int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
        int $i$f$fastMap = 0;
        List target$iv = new ArrayList(list.size());
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        int $i$f$fastForEach = 0;
        int index$iv$iv = 0;
        int size = list2.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = list2.get(index$iv$iv);
            List list3 = target$iv;
            List<? extends IntrinsicMeasurable> list4 = (List) item$iv$iv;
            List<? extends List<? extends IntrinsicMeasurable>> list5 = list;
            ArrayList target$iv2 = new ArrayList(list4.size());
            List<? extends IntrinsicMeasurable> list6 = list4;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = list6.size();
            List<? extends List<? extends IntrinsicMeasurable>> list7 = list2;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                int i = $i$f$fastMap3;
                IntrinsicMeasurable it = (IntrinsicMeasurable) list6.get(index$iv$iv2);
                target$iv2.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
                index$iv$iv2++;
                list6 = list6;
                $i$f$fastMap3 = i;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                item$iv$iv = item$iv$iv;
            }
            list3.add(target$iv2);
            index$iv$iv++;
            list = list5;
            $i$f$fastMap = $i$f$fastMap2;
            list2 = list7;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$minIntrinsicHeight, $this$minIntrinsicHeight.getLayoutDirection());
        MeasureResult layoutResult = m4232measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
        int $i$f$fastMap = 0;
        List target$iv = new ArrayList(list.size());
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        int $i$f$fastForEach = 0;
        int index$iv$iv = 0;
        int size = list2.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = list2.get(index$iv$iv);
            List list3 = target$iv;
            List<? extends IntrinsicMeasurable> list4 = (List) item$iv$iv;
            List<? extends List<? extends IntrinsicMeasurable>> list5 = list;
            ArrayList target$iv2 = new ArrayList(list4.size());
            List<? extends IntrinsicMeasurable> list6 = list4;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = list6.size();
            List<? extends List<? extends IntrinsicMeasurable>> list7 = list2;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                int i = $i$f$fastMap3;
                IntrinsicMeasurable it = (IntrinsicMeasurable) list6.get(index$iv$iv2);
                target$iv2.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
                index$iv$iv2++;
                list6 = list6;
                $i$f$fastMap3 = i;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                item$iv$iv = item$iv$iv;
            }
            list3.add(target$iv2);
            index$iv$iv++;
            list = list5;
            $i$f$fastMap = $i$f$fastMap2;
            list2 = list7;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$maxIntrinsicWidth, $this$maxIntrinsicWidth.getLayoutDirection());
        MeasureResult layoutResult = m4232measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getWidth();
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
        int $i$f$fastMap = 0;
        List target$iv = new ArrayList(list.size());
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        int $i$f$fastForEach = 0;
        int index$iv$iv = 0;
        int size = list2.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = list2.get(index$iv$iv);
            List list3 = target$iv;
            List<? extends IntrinsicMeasurable> list4 = (List) item$iv$iv;
            List<? extends List<? extends IntrinsicMeasurable>> list5 = list;
            ArrayList target$iv2 = new ArrayList(list4.size());
            List<? extends IntrinsicMeasurable> list6 = list4;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = list6.size();
            List<? extends List<? extends IntrinsicMeasurable>> list7 = list2;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                int i = $i$f$fastMap3;
                IntrinsicMeasurable it = (IntrinsicMeasurable) list6.get(index$iv$iv2);
                target$iv2.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
                index$iv$iv2++;
                list6 = list6;
                $i$f$fastMap3 = i;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                item$iv$iv = item$iv$iv;
            }
            list3.add(target$iv2);
            index$iv$iv++;
            list = list5;
            $i$f$fastMap = $i$f$fastMap2;
            list2 = list7;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$maxIntrinsicHeight, $this$maxIntrinsicHeight.getLayoutDirection());
        MeasureResult layoutResult = m4232measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getHeight();
    }
}
