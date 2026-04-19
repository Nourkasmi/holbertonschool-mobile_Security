package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B,\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bB\u001c\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\rB\u0014\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000fJ>\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0016\u0010%\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001e\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0015\u0088\u0001\u000e\u0092\u0001\u00020\nø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class OrientationIndependentConstraints {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m446boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m448constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m452equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m4822equalsimpl0(j, ((OrientationIndependentConstraints) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m453equalsimpl0(long j, long j2) {
        return Constraints.m4822equalsimpl0(j, j2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m458hashCodeimpl(long j) {
        return Constraints.m4832hashCodeimpl(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m463toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m4834toStringimpl(j)) + ')';
    }

    public boolean equals(Object obj) {
        return m452equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m458hashCodeimpl(this.value);
    }

    public String toString() {
        return m463toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m457getMainAxisMinimpl(long j) {
        return Constraints.m4831getMinWidthimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m456getMainAxisMaximpl(long j) {
        return Constraints.m4829getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m455getCrossAxisMinimpl(long j) {
        return Constraints.m4830getMinHeightimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m454getCrossAxisMaximpl(long j) {
        return Constraints.m4828getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m447constructorimpl(int i, int i2, int i3, int i4) {
        return m448constructorimpl(ConstraintsKt.Constraints(i, i2, i3, i4));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m449constructorimpl(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return m447constructorimpl(orientation == LayoutOrientation.Horizontal ? Constraints.m4831getMinWidthimpl(j) : Constraints.m4830getMinHeightimpl(j), orientation == LayoutOrientation.Horizontal ? Constraints.m4829getMaxWidthimpl(j) : Constraints.m4828getMaxHeightimpl(j), orientation == LayoutOrientation.Horizontal ? Constraints.m4830getMinHeightimpl(j) : Constraints.m4831getMinWidthimpl(j), orientation == LayoutOrientation.Horizontal ? Constraints.m4828getMaxHeightimpl(j) : Constraints.m4829getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m462toBoxConstraintsOenEA2s(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m4831getMinWidthimpl(j), Constraints.m4829getMaxWidthimpl(j), Constraints.m4830getMinHeightimpl(j), Constraints.m4828getMaxHeightimpl(j));
        }
        return ConstraintsKt.Constraints(Constraints.m4830getMinHeightimpl(j), Constraints.m4828getMaxHeightimpl(j), Constraints.m4831getMinWidthimpl(j), Constraints.m4829getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m460maxWidthimpl(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m4829getMaxWidthimpl(j);
        }
        return Constraints.m4828getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m459maxHeightimpl(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m4828getMaxHeightimpl(j);
        }
        return Constraints.m4829getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m450copyyUG9Ft0(long j, int i, int i2, int i3, int i4) {
        return m447constructorimpl(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m461stretchCrossAxisq4ezo7Y(long j) {
        return m447constructorimpl(Constraints.m4831getMinWidthimpl(j), Constraints.m4829getMaxWidthimpl(j), Constraints.m4828getMaxHeightimpl(j) != Integer.MAX_VALUE ? Constraints.m4828getMaxHeightimpl(j) : Constraints.m4830getMinHeightimpl(j), Constraints.m4828getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m451copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = Constraints.m4831getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = Constraints.m4829getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = Constraints.m4830getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = Constraints.m4828getMaxHeightimpl(j);
        }
        return m450copyyUG9Ft0(j, i6, i7, i8, i4);
    }
}
