package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0086\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u007f\u0010(\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00100\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00101\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00102\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0002\u00107\u001a\u007f\u00108\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u007f\u00109\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a¦\u0001\u0010:\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001c2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a¸\u0001\u0010J\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u00020\u00012\u0011\u0010K\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010L\u001a\u0002042\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a+\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020<2\b\b\u0002\u0010T\u001a\u00020<2\b\b\u0002\u0010U\u001a\u00020<H\u0007¢\u0006\u0002\u0010V\u001aD\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020<2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010^H\u0082@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010_\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppBar.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {1622, 1638}, m = "settleAppBar", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C02461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02461(Continuation<? super C02461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TopAppBar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @kotlin.ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SmallTopAppBar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SmallTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CenterAlignedTopAppBar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.foundation.layout.WindowInsets r34, androidx.compose.material3.TopAppBarColors r35, androidx.compose.material3.TopAppBarScrollBehavior r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MediumTopAppBar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LargeTopAppBar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m978BottomAppBarSnr_uVM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m978BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m977BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.layout.WindowInsets r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m977BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TopAppBarState rememberTopAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1801969826);
        ComposerKt.sourceInformation(composer, "C(rememberTopAppBarState)P(2,1)799@38640L145,799@38593L192:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:794)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        Float fValueOf3 = Float.valueOf(f3);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(fValueOf) | composer.changed(fValueOf2) | composer.changed(fValueOf3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TopAppBarState invoke() {
                    return new TopAppBarState(f, f2, f3);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m2276rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SingleRowTopAppBar(androidx.compose.ui.Modifier r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final androidx.compose.ui.text.TextStyle r36, final boolean r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, final androidx.compose.foundation.layout.WindowInsets r40, final androidx.compose.material3.TopAppBarColors r41, final androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0131  */
    /* JADX INFO: renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m980TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier r39, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, final androidx.compose.ui.text.TextStyle r41, final float r42, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, final androidx.compose.ui.text.TextStyle r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, final androidx.compose.foundation.layout.WindowInsets r47, final androidx.compose.material3.TopAppBarColors r48, final float r49, final float r50, final androidx.compose.material3.TopAppBarScrollBehavior r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instruction units count: 959
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m980TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m979TopAppBarLayoutkXwM9vE(final Modifier modifier, final float f, final long j, final long j2, final long j3, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f2, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1296@58560L4308:AppBar.kt#uh7d8r");
        if ((i2 & 14) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(j3) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(vertical) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i2 & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        final int i6 = i4;
        if ((i3 & 14) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(i) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        if ((1533916891 & i6) != 306783378 || (i5 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i6, i5, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1280)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo11measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, final long j4) {
                    int iCoerceAtLeast;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                            final Placeable placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j4, 0, 0, 0, 0, 14, null));
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                                    final Placeable placeableMo3866measureBRTryo02 = measurable2.mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j4, 0, 0, 0, 0, 14, null));
                                    if (Constraints.m4829getMaxWidthimpl(j4) == Integer.MAX_VALUE) {
                                        iCoerceAtLeast = Constraints.m4829getMaxWidthimpl(j4);
                                    } else {
                                        iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m4829getMaxWidthimpl(j4) - placeableMo3866measureBRTryo0.getWidth()) - placeableMo3866measureBRTryo02.getWidth(), 0);
                                    }
                                    int i7 = iCoerceAtLeast;
                                    for (Measurable measurable3 : list) {
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                            final Placeable placeableMo3866measureBRTryo03 = measurable3.mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j4, 0, i7, 0, 0, 12, null));
                                            final int i8 = placeableMo3866measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? placeableMo3866measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                            final int iRoundToInt = MathKt.roundToInt(f);
                                            int iM4829getMaxWidthimpl = Constraints.m4829getMaxWidthimpl(j4);
                                            final Arrangement.Horizontal horizontal2 = horizontal;
                                            final Arrangement.Vertical vertical2 = vertical;
                                            final int i9 = i;
                                            return MeasureScope.layout$default(Layout, iM4829getMaxWidthimpl, iRoundToInt, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$measure$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    int iMax;
                                                    int i10;
                                                    int height;
                                                    int iMax2;
                                                    int height2;
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    Placeable placeable = placeableMo3866measureBRTryo0;
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, (iRoundToInt - placeable.getHeight()) / 2, 0.0f, 4, null);
                                                    Placeable placeable2 = placeableMo3866measureBRTryo03;
                                                    Arrangement.Horizontal horizontal3 = horizontal2;
                                                    if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getCenter())) {
                                                        iMax = (Constraints.m4829getMaxWidthimpl(j4) - placeableMo3866measureBRTryo03.getWidth()) / 2;
                                                    } else if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getEnd())) {
                                                        iMax = (Constraints.m4829getMaxWidthimpl(j4) - placeableMo3866measureBRTryo03.getWidth()) - placeableMo3866measureBRTryo02.getWidth();
                                                    } else {
                                                        iMax = Math.max(Layout.mo319roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeableMo3866measureBRTryo0.getWidth());
                                                    }
                                                    int i11 = iMax;
                                                    Arrangement.Vertical vertical3 = vertical2;
                                                    if (Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getCenter())) {
                                                        height2 = (iRoundToInt - placeableMo3866measureBRTryo03.getHeight()) / 2;
                                                    } else if (!Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getBottom())) {
                                                        i10 = 0;
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeable2, i11, i10, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo3866measureBRTryo02, Constraints.m4829getMaxWidthimpl(j4) - placeableMo3866measureBRTryo02.getWidth(), (iRoundToInt - placeableMo3866measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                    } else {
                                                        if (i9 == 0) {
                                                            height = iRoundToInt;
                                                            iMax2 = placeableMo3866measureBRTryo03.getHeight();
                                                        } else {
                                                            height = iRoundToInt - placeableMo3866measureBRTryo03.getHeight();
                                                            iMax2 = Math.max(0, (i9 - placeableMo3866measureBRTryo03.getHeight()) + i8);
                                                        }
                                                        height2 = height - iMax2;
                                                    }
                                                    i10 = height2;
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, i11, i10, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo3866measureBRTryo02, Constraints.m4829getMaxWidthimpl(j4) - placeableMo3866measureBRTryo02.getWidth(), (iRoundToInt - placeableMo3866measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                }
                                            }, 4, null);
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            int i7 = ((((i6 << 3) & 112) << 9) & 7168) | 6;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290535407, "C1298@58590L352,1308@58955L577,1322@59545L336:AppBar.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon");
            float f3 = TopAppBarHorizontalPadding;
            Modifier modifierM484paddingqDBjuR0$default = PaddingKt.m484paddingqDBjuR0$default(modifierLayoutId, f3, 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density2 = (Density) objConsume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl2 = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl2, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf2.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1090283935, "C1303@58765L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2619boximpl(j))}, function22, composerStartRestartGroup, ((i5 >> 3) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM482paddingVpY3zN4$default = PaddingKt.m482paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f3, 0.0f, 2, null);
            Modifier.Companion companionClearAndSetSemantics = Modifier.INSTANCE;
            if (z) {
                companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companionClearAndSetSemantics, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
            }
            Modifier modifierM2786graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m2786graphicsLayerAp8cVGQ$default(modifierM482paddingVpY3zN4$default.then(companionClearAndSetSemantics), 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density3 = (Density) objConsume7;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection3 = (LayoutDirection) objConsume8;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM2786graphicsLayerAp8cVGQ$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl3 = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf3.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1090283420, "C1315@59280L238:AppBar.kt#uh7d8r");
            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 824316656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    ComposerKt.sourceInformation(composer2, "C1316@59343L157:AppBar.kt#uh7d8r");
                    if ((i8 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(824316656, i8, -1, "androidx.compose.material3.TopAppBarLayout.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:1315)");
                        }
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2619boximpl(j2))}, function2, composer2, ((i6 >> 12) & 112) | 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, ((i6 >> 18) & 14) | 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM484paddingqDBjuR0$default2 = PaddingKt.m484paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume10 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density4 = (Density) objConsume10;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11 = composerStartRestartGroup.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection4 = (LayoutDirection) objConsume11;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume12 = composerStartRestartGroup.consume(localViewConfiguration4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume12;
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl4 = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl4, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf4.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1090282985, "C1327@59715L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2619boximpl(j3))}, function23, composerStartRestartGroup, ((i5 >> 6) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                AppBarKt.m979TopAppBarLayoutkXwM9vE(modifier, f, j, j2, j3, function2, textStyle, f2, vertical, horizontal, i, z, function22, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r22, float r23, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r24, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r26) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final long SingleRowTopAppBar$lambda$3(State<Color> state) {
        return state.getValue().m2639unboximpl();
    }

    private static final long TwoRowsTopAppBar_tjU4iQQ$lambda$8(State<Color> state) {
        return state.getValue().m2639unboximpl();
    }

    static {
        float f = 16;
        float f2 = 12;
        float fM4873constructorimpl = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f) - Dp.m4873constructorimpl(f2));
        BottomAppBarHorizontalPadding = fM4873constructorimpl;
        float fM4873constructorimpl2 = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f) - Dp.m4873constructorimpl(f2));
        BottomAppBarVerticalPadding = fM4873constructorimpl2;
        FABHorizontalPadding = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f) - fM4873constructorimpl);
        FABVerticalPadding = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f2) - fM4873constructorimpl2);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m4873constructorimpl(24);
        LargeTitleBottomPadding = Dp.m4873constructorimpl(28);
        float fM4873constructorimpl3 = Dp.m4873constructorimpl(4);
        TopAppBarHorizontalPadding = fM4873constructorimpl3;
        TopAppBarTitleInset = Dp.m4873constructorimpl(Dp.m4873constructorimpl(f) - fM4873constructorimpl3);
    }
}
