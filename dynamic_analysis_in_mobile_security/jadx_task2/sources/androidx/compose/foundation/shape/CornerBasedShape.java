package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CornerBasedShape.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getBottomEnd", "()Landroidx/compose/foundation/shape/CornerSize;", "getBottomStart", "getTopEnd", "getTopStart", "copy", "all", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart);

    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo716createOutlineLjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, LayoutDirection layoutDirection);

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public CornerBasedShape(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo208createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float fMo724toPxTmRCtEA = this.topStart.mo724toPxTmRCtEA(size, density);
        float fMo724toPxTmRCtEA2 = this.topEnd.mo724toPxTmRCtEA(size, density);
        float fMo724toPxTmRCtEA3 = this.bottomEnd.mo724toPxTmRCtEA(size, density);
        float fMo724toPxTmRCtEA4 = this.bottomStart.mo724toPxTmRCtEA(size, density);
        float fM2458getMinDimensionimpl = Size.m2458getMinDimensionimpl(size);
        float f = fMo724toPxTmRCtEA + fMo724toPxTmRCtEA4;
        if (f > fM2458getMinDimensionimpl) {
            float f2 = fM2458getMinDimensionimpl / f;
            fMo724toPxTmRCtEA *= f2;
            fMo724toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo724toPxTmRCtEA4;
        float f4 = fMo724toPxTmRCtEA2 + fMo724toPxTmRCtEA3;
        if (f4 > fM2458getMinDimensionimpl) {
            float f5 = fM2458getMinDimensionimpl / f4;
            fMo724toPxTmRCtEA2 *= f5;
            fMo724toPxTmRCtEA3 *= f5;
        }
        if (fMo724toPxTmRCtEA < 0.0f || fMo724toPxTmRCtEA2 < 0.0f || fMo724toPxTmRCtEA3 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fMo724toPxTmRCtEA + ", topEnd = " + fMo724toPxTmRCtEA2 + ", bottomEnd = " + fMo724toPxTmRCtEA3 + ", bottomStart = " + f3 + ")!").toString());
        }
        return mo716createOutlineLjSzlW0(size, fMo724toPxTmRCtEA, fMo724toPxTmRCtEA2, fMo724toPxTmRCtEA3, f3, layoutDirection);
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public final CornerBasedShape copy(CornerSize all) {
        Intrinsics.checkNotNullParameter(all, "all");
        return copy(all, all, all, all);
    }
}
