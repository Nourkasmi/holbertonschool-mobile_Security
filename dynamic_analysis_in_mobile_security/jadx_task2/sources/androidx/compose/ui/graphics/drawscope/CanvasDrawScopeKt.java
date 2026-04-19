package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DefaultDensity", "Landroidx/compose/ui/unit/Density;", "asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasDrawScopeKt {
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo3102getSizeNHjbRc() {
                return drawContext.mo3097getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo3101getCenterF1C5BW0() {
                return SizeKt.m2469getCenteruvyYCjk(mo3102getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jSize = SizeKt.Size(Size.m2459getWidthimpl(mo3102getSizeNHjbRc()) - (right + left), Size.m2456getHeightimpl(mo3102getSizeNHjbRc()) - (bottom + top));
                if (Size.m2459getWidthimpl(jSize) < 0.0f || Size.m2456getHeightimpl(jSize) < 0.0f) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext2.mo3098setSizeuvyYCjk(jSize);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo3100clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                drawContext.getCanvas().mo2485clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo3099clipPathmtrdDE(Path path, int clipOp) {
                Intrinsics.checkNotNullParameter(path, "path");
                drawContext.getCanvas().mo2484clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                drawContext.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo3103rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m2390getXimpl(pivot), Offset.m2391getYimpl(pivot));
                canvas.rotate(degrees);
                canvas.translate(-Offset.m2390getXimpl(pivot), -Offset.m2391getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo3104scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m2390getXimpl(pivot), Offset.m2391getYimpl(pivot));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Offset.m2390getXimpl(pivot), -Offset.m2391getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo3105transform58bKbWc(float[] matrix) {
                Intrinsics.checkNotNullParameter(matrix, "matrix");
                drawContext.getCanvas().mo2486concat58bKbWc(matrix);
            }
        };
    }
}
