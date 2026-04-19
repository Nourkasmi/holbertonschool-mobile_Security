package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0019\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J)\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != Size.INSTANCE.m2467getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo237measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(m2300modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measure, placeableMo3866measureBRTryo0.getWidth(), placeableMo3866measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3866measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM2300modifyConstraintsZezNO4M = m2300modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m4831getMinWidthimpl(jM2300modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM2300modifyConstraintsZezNO4M = m2300modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m4831getMinWidthimpl(jM2300modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM2300modifyConstraintsZezNO4M = m2300modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m4830getMinHeightimpl(jM2300modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM2300modifyConstraintsZezNO4M = m2300modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m4830getMinHeightimpl(jM2300modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m2297calculateScaledSizeE7KxVPU(long dstSize) {
        float fM2459getWidthimpl;
        float fM2456getHeightimpl;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m2299hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            fM2459getWidthimpl = Size.m2459getWidthimpl(dstSize);
        } else {
            fM2459getWidthimpl = Size.m2459getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m2298hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            fM2456getHeightimpl = Size.m2456getHeightimpl(dstSize);
        } else {
            fM2456getHeightimpl = Size.m2456getHeightimpl(this.painter.getIntrinsicSize());
        }
        long jSize = SizeKt.Size(fM2459getWidthimpl, fM2456getHeightimpl);
        if (Size.m2459getWidthimpl(dstSize) != 0.0f && Size.m2456getHeightimpl(dstSize) != 0.0f) {
            return ScaleFactorKt.m3957timesUQTWf7w(jSize, this.contentScale.mo3857computeScaleFactorH7hwNQA(jSize, dstSize));
        }
        return Size.INSTANCE.m2468getZeroNHjbRc();
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m2300modifyConstraintsZezNO4M(long constraints) {
        int iM4831getMinWidthimpl;
        int iM4830getMinHeightimpl;
        boolean z = Constraints.m4825getHasBoundedWidthimpl(constraints) && Constraints.m4824getHasBoundedHeightimpl(constraints);
        boolean z2 = Constraints.m4827getHasFixedWidthimpl(constraints) && Constraints.m4826getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m4820copyZbe2FdA$default(constraints, Constraints.m4829getMaxWidthimpl(constraints), 0, Constraints.m4828getMaxHeightimpl(constraints), 0, 10, null);
        }
        long jMo3241getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        if (m2299hasSpecifiedAndFiniteWidthuvyYCjk(jMo3241getIntrinsicSizeNHjbRc)) {
            iM4831getMinWidthimpl = MathKt.roundToInt(Size.m2459getWidthimpl(jMo3241getIntrinsicSizeNHjbRc));
        } else {
            iM4831getMinWidthimpl = Constraints.m4831getMinWidthimpl(constraints);
        }
        if (m2298hasSpecifiedAndFiniteHeightuvyYCjk(jMo3241getIntrinsicSizeNHjbRc)) {
            iM4830getMinHeightimpl = MathKt.roundToInt(Size.m2456getHeightimpl(jMo3241getIntrinsicSizeNHjbRc));
        } else {
            iM4830getMinHeightimpl = Constraints.m4830getMinHeightimpl(constraints);
        }
        long jM2297calculateScaledSizeE7KxVPU = m2297calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m4843constrainWidthK40F9xA(constraints, iM4831getMinWidthimpl), ConstraintsKt.m4842constrainHeightK40F9xA(constraints, iM4830getMinHeightimpl)));
        return Constraints.m4820copyZbe2FdA$default(constraints, ConstraintsKt.m4843constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m2459getWidthimpl(jM2297calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m4842constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m2456getHeightimpl(jM2297calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float fM2459getWidthimpl;
        float fM2456getHeightimpl;
        long jM2468getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long jMo3241getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        if (m2299hasSpecifiedAndFiniteWidthuvyYCjk(jMo3241getIntrinsicSizeNHjbRc)) {
            fM2459getWidthimpl = Size.m2459getWidthimpl(jMo3241getIntrinsicSizeNHjbRc);
        } else {
            fM2459getWidthimpl = Size.m2459getWidthimpl(contentDrawScope.mo3172getSizeNHjbRc());
        }
        if (m2298hasSpecifiedAndFiniteHeightuvyYCjk(jMo3241getIntrinsicSizeNHjbRc)) {
            fM2456getHeightimpl = Size.m2456getHeightimpl(jMo3241getIntrinsicSizeNHjbRc);
        } else {
            fM2456getHeightimpl = Size.m2456getHeightimpl(contentDrawScope.mo3172getSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM2459getWidthimpl, fM2456getHeightimpl);
        if (Size.m2459getWidthimpl(contentDrawScope.mo3172getSizeNHjbRc()) != 0.0f && Size.m2456getHeightimpl(contentDrawScope.mo3172getSizeNHjbRc()) != 0.0f) {
            jM2468getZeroNHjbRc = ScaleFactorKt.m3957timesUQTWf7w(jSize, this.contentScale.mo3857computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo3172getSizeNHjbRc()));
        } else {
            jM2468getZeroNHjbRc = Size.INSTANCE.m2468getZeroNHjbRc();
        }
        long j = jM2468getZeroNHjbRc;
        long jMo2280alignKFBX0sM = this.alignment.mo2280alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2459getWidthimpl(j)), MathKt.roundToInt(Size.m2456getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2459getWidthimpl(contentDrawScope.mo3172getSizeNHjbRc())), MathKt.roundToInt(Size.m2456getHeightimpl(contentDrawScope.mo3172getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM4991getXimpl = IntOffset.m4991getXimpl(jMo2280alignKFBX0sM);
        float fM4992getYimpl = IntOffset.m4992getYimpl(jMo2280alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(fM4991getXimpl, fM4992getYimpl);
        this.painter.m3247drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM4991getXimpl, -fM4992getYimpl);
        contentDrawScope.drawContent();
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m2299hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m2455equalsimpl0(j, Size.INSTANCE.m2467getUnspecifiedNHjbRc())) {
            float fM2459getWidthimpl = Size.m2459getWidthimpl(j);
            if (!Float.isInfinite(fM2459getWidthimpl) && !Float.isNaN(fM2459getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m2298hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m2455equalsimpl0(j, Size.INSTANCE.m2467getUnspecifiedNHjbRc())) {
            float fM2456getHeightimpl = Size.m2456getHeightimpl(j);
            if (!Float.isInfinite(fM2456getHeightimpl) && !Float.isNaN(fM2456getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
