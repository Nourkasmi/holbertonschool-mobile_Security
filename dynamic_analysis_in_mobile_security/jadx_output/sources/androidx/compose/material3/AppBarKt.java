package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
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
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
    static final class C03301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03301(Continuation<? super C03301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    public static final void TopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1422getLambda2$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        TopAppBarColors colors3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(5,2,3!1,6)125@6259L12,126@6321L17,132@6511L10,129@6400L374:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1422getLambda2$material3_release = function3;
        } else if (($changed & 7168) == 0) {
            function3M1422getLambda2$material3_release = function3;
            $dirty2 |= $composer3.changedInstance(function3M1422getLambda2$material3_release) ? 2048 : 1024;
        } else {
            function3M1422getLambda2$material3_release = function3;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                topAppBarColors = colors;
                int i6 = $composer3.changed(topAppBarColors) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                topAppBarColors = colors;
            }
            $dirty2 |= i6;
        } else {
            topAppBarColors = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if (($changed & 3670016) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if (($dirty2 & 2995931) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            function32 = function3M1422getLambda2$material3_release;
            windowInsets3 = windowInsets2;
            $composer2 = $composer3;
            scrollBehavior2 = topAppBarScrollBehavior;
            colors3 = topAppBarColors;
            modifier3 = modifier2;
            function23 = function22;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2M1418getLambda1$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1418getLambda1$material3_release() : function22;
                if (i4 != 0) {
                    function3M1422getLambda2$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m1422getLambda2$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    colors2 = TopAppBarDefaults.INSTANCE.m1994topAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    $dirty2 &= -458753;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1418getLambda1$material3_release;
                    colors3 = colors2;
                    scrollBehavior2 = null;
                    function32 = function3M1422getLambda2$material3_release;
                    windowInsets3 = windowInsets2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1418getLambda1$material3_release;
                    colors3 = colors2;
                    function32 = function3M1422getLambda2$material3_release;
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                function32 = function3M1422getLambda2$material3_release;
                windowInsets3 = windowInsets2;
                scrollBehavior2 = topAppBarScrollBehavior;
                colors3 = topAppBarColors;
                modifier3 = modifier2;
                function23 = function22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1906353009, $dirty, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:120)");
            }
            $composer2 = $composer3;
            SingleRowTopAppBar(modifier3, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function23, function32, windowInsets3, colors3, scrollBehavior2, $composer3, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
        final WindowInsets windowInsets4 = windowInsets3;
        final TopAppBarColors topAppBarColors2 = colors3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.TopAppBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.TopAppBar(title, modifier5, function24, function33, windowInsets4, topAppBarColors2, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    public static final void SmallTopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1424getLambda4$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        WindowInsets windowInsets3;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        WindowInsets windowInsets4;
        TopAppBarColors colors3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-1967617284);
        ComposerKt.sourceInformation($composer3, "C(SmallTopAppBar)P(5,2,3!1,6)188@9238L12,189@9300L17,191@9375L89:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1424getLambda4$material3_release = function3;
        } else if (($changed & 7168) == 0) {
            function3M1424getLambda4$material3_release = function3;
            $dirty2 |= $composer3.changedInstance(function3M1424getLambda4$material3_release) ? 2048 : 1024;
        } else {
            function3M1424getLambda4$material3_release = function3;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                topAppBarColors = colors;
                int i6 = $composer3.changed(topAppBarColors) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                topAppBarColors = colors;
            }
            $dirty2 |= i6;
        } else {
            topAppBarColors = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if (($changed & 3670016) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((2995931 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            function32 = function3M1424getLambda4$material3_release;
            $composer2 = $composer3;
            scrollBehavior2 = topAppBarScrollBehavior;
            colors3 = topAppBarColors;
            function23 = function22;
            windowInsets4 = windowInsets2;
            modifier3 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2M1423getLambda3$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1423getLambda3$material3_release() : function22;
                if (i4 != 0) {
                    function3M1424getLambda4$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m1424getLambda4$material3_release();
                }
                if ((i & 16) != 0) {
                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty2 &= -57345;
                } else {
                    windowInsets3 = windowInsets2;
                }
                if ((i & 32) != 0) {
                    colors2 = TopAppBarDefaults.INSTANCE.m1994topAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    $dirty2 &= -458753;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1423getLambda3$material3_release;
                    windowInsets4 = windowInsets3;
                    colors3 = colors2;
                    scrollBehavior2 = null;
                    function32 = function3M1424getLambda4$material3_release;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1423getLambda3$material3_release;
                    windowInsets4 = windowInsets3;
                    colors3 = colors2;
                    function32 = function3M1424getLambda4$material3_release;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                function32 = function3M1424getLambda4$material3_release;
                scrollBehavior2 = topAppBarScrollBehavior;
                colors3 = topAppBarColors;
                function23 = function22;
                windowInsets4 = windowInsets2;
                modifier3 = modifier2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1967617284, $dirty, -1, "androidx.compose.material3.SmallTopAppBar (AppBar.kt:183)");
            }
            $composer2 = $composer3;
            TopAppBar(title, modifier3, function23, function32, windowInsets4, colors3, scrollBehavior2, $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
        final WindowInsets windowInsets5 = windowInsets4;
        final TopAppBarColors topAppBarColors2 = colors3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SmallTopAppBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.SmallTopAppBar(title, modifier5, function24, function33, windowInsets5, topAppBarColors2, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void CenterAlignedTopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1426getLambda6$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        TopAppBarColors colors3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation($composer3, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)229@11657L12,230@11719L30,237@11930L10,233@11811L381:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1426getLambda6$material3_release = function3;
        } else if (($changed & 7168) == 0) {
            function3M1426getLambda6$material3_release = function3;
            $dirty2 |= $composer3.changedInstance(function3M1426getLambda6$material3_release) ? 2048 : 1024;
        } else {
            function3M1426getLambda6$material3_release = function3;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                topAppBarColors = colors;
                int i6 = $composer3.changed(topAppBarColors) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                topAppBarColors = colors;
            }
            $dirty2 |= i6;
        } else {
            topAppBarColors = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if (($changed & 3670016) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if (($dirty2 & 2995931) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            function32 = function3M1426getLambda6$material3_release;
            windowInsets3 = windowInsets2;
            $composer2 = $composer3;
            scrollBehavior2 = topAppBarScrollBehavior;
            colors3 = topAppBarColors;
            modifier3 = modifier2;
            function23 = function22;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2M1425getLambda5$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1425getLambda5$material3_release() : function22;
                if (i4 != 0) {
                    function3M1426getLambda6$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m1426getLambda6$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    colors2 = TopAppBarDefaults.INSTANCE.m1990centerAlignedTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    $dirty2 &= -458753;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1425getLambda5$material3_release;
                    colors3 = colors2;
                    scrollBehavior2 = null;
                    function32 = function3M1426getLambda6$material3_release;
                    windowInsets3 = windowInsets2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1425getLambda5$material3_release;
                    colors3 = colors2;
                    function32 = function3M1426getLambda6$material3_release;
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                function32 = function3M1426getLambda6$material3_release;
                windowInsets3 = windowInsets2;
                scrollBehavior2 = topAppBarScrollBehavior;
                colors3 = topAppBarColors;
                modifier3 = modifier2;
                function23 = function22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139286460, $dirty, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:224)");
            }
            $composer2 = $composer3;
            SingleRowTopAppBar(modifier3, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function23, function32, windowInsets3, colors3, scrollBehavior2, $composer3, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
        final WindowInsets windowInsets4 = windowInsets3;
        final TopAppBarColors topAppBarColors2 = colors3;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.CenterAlignedTopAppBar(title, modifier5, function24, function33, windowInsets4, topAppBarColors2, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void MediumTopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1428getLambda8$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        TopAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation($composer3, "C(MediumTopAppBar)P(5,2,3!1,6)284@14510L12,285@14572L23,291@14766L10,292@14868L10,288@14657L646:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1428getLambda8$material3_release = function3;
        } else if (($changed & 7168) == 0) {
            function3M1428getLambda8$material3_release = function3;
            $dirty2 |= $composer3.changedInstance(function3M1428getLambda8$material3_release) ? 2048 : 1024;
        } else {
            function3M1428getLambda8$material3_release = function3;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if (($changed & 3670016) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((2995931 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            function23 = function22;
            function32 = function3M1428getLambda8$material3_release;
            $composer2 = $composer3;
            scrollBehavior2 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2M1427getLambda7$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1427getLambda7$material3_release() : function22;
                if (i4 != 0) {
                    function3M1428getLambda8$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m1428getLambda8$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.m1992mediumTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1427getLambda7$material3_release;
                    scrollBehavior2 = null;
                    function32 = function3M1428getLambda8$material3_release;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1427getLambda7$material3_release;
                    function32 = function3M1428getLambda8$material3_release;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                function23 = function22;
                function32 = function3M1428getLambda8$material3_release;
                windowInsets3 = windowInsets2;
                colors3 = colors2;
                scrollBehavior2 = topAppBarScrollBehavior;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1805417862, $dirty, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:279)");
            }
            $composer2 = $composer3;
            m1298TwoRowsTopAppBartjU4iQQ(modifier3, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function32, windowInsets3, colors3, TopAppBarMediumTokens.INSTANCE.m2496getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m2506getContainerHeightD9Ej5fM(), scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets3;
            colors2 = colors3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
        final WindowInsets windowInsets4 = windowInsets2;
        final TopAppBarColors topAppBarColors = colors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.MediumTopAppBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.MediumTopAppBar(title, modifier5, function24, function33, windowInsets4, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void LargeTopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1419getLambda10$material3_release;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        TopAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation($composer3, "C(LargeTopAppBar)P(5,2,3!1,6)342@17613L12,343@17675L22,348@17839L10,349@17940L10,346@17759L643:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1419getLambda10$material3_release = function3;
        } else if (($changed & 7168) == 0) {
            function3M1419getLambda10$material3_release = function3;
            $dirty2 |= $composer3.changedInstance(function3M1419getLambda10$material3_release) ? 2048 : 1024;
        } else {
            function3M1419getLambda10$material3_release = function3;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if (($changed & 3670016) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((2995931 & $dirty2) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            function23 = function22;
            function32 = function3M1419getLambda10$material3_release;
            $composer2 = $composer3;
            scrollBehavior2 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                Function2<? super Composer, ? super Integer, Unit> function2M1429getLambda9$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1429getLambda9$material3_release() : function22;
                if (i4 != 0) {
                    function3M1419getLambda10$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m1419getLambda10$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.m1991largeTopAppBarColorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1429getLambda9$material3_release;
                    scrollBehavior2 = null;
                    function32 = function3M1419getLambda10$material3_release;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function23 = function2M1429getLambda9$material3_release;
                    function32 = function3M1419getLambda10$material3_release;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                function23 = function22;
                function32 = function3M1419getLambda10$material3_release;
                windowInsets3 = windowInsets2;
                colors3 = colors2;
                scrollBehavior2 = topAppBarScrollBehavior;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-474540752, $dirty, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:337)");
            }
            $composer2 = $composer3;
            m1298TwoRowsTopAppBartjU4iQQ(modifier3, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, title, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function32, windowInsets3, colors3, TopAppBarLargeTokens.INSTANCE.m2492getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m2506getContainerHeightD9Ej5fM(), scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets2 = windowInsets3;
            colors2 = colors3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
        final WindowInsets windowInsets4 = windowInsets2;
        final TopAppBarColors topAppBarColors = colors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.LargeTopAppBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.LargeTopAppBar(title, modifier5, function24, function33, windowInsets4, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    public static final void m1296BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, final int $changed, final int i) {
        final Function2<? super Composer, ? super Integer, Unit> function22;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        Modifier.Companion modifier2;
        PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        Modifier modifier3;
        PaddingValues contentPadding3;
        WindowInsets windowInsets3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        long containerColor3;
        float tonalElevation3;
        long contentColor3;
        Intrinsics.checkNotNullParameter(actions, "actions");
        Composer $composer2 = $composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)398@20365L14,399@20407L31,402@20633L12,403@20651L634:AppBar.kt#uh7d8r");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(actions) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function22 = function2;
        } else if (($changed & 896) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 458752) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty |= $composer2.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(windowInsets)) ? 8388608 : 4194304;
        }
        if (($dirty & 23967451) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            contentPadding3 = contentPadding;
            windowInsets3 = windowInsets;
            function23 = function22;
            containerColor3 = containerColor2;
            tonalElevation3 = tonalElevation2;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    function22 = null;
                }
                if ((i & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m1412contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i6 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1309getContainerElevationD9Ej5fM();
                }
                contentPadding2 = i7 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : contentPadding;
                if ((i & 128) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    windowInsets2 = windowInsets;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    $dirty &= -29360129;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141738945, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:394)");
            }
            m1295BottomAppBar1oL4kX8(modifier2, containerColor2, contentColor2, tonalElevation2, contentPadding2, windowInsets2, ComposableLambdaKt.composableLambda($composer2, 1974005449, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope BottomAppBar, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                    ComposerKt.sourceInformation($composer3, "C411@20874L9,413@20932L33,414@20974L303:AppBar.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(BottomAppBar) ? 4 : 2;
                    }
                    if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1974005449, $dirty2, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:410)");
                        }
                        actions.invoke(BottomAppBar, $composer3, Integer.valueOf(($dirty2 & 14) | (($dirty << 3) & 112)));
                        if (function22 != null) {
                            SpacerKt.Spacer(BottomAppBar.weight(Modifier.INSTANCE, 1.0f, true), $composer3, 0);
                            Modifier modifier$iv = PaddingKt.m485paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function24 = function22;
                            int i8 = $dirty;
                            $composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv = (54 << 3) & 112;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = $composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density density$iv$iv = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = $composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) objConsume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = $composer3.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) objConsume3;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor);
                            } else {
                                $composer3.useNode();
                            }
                            $composer3.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2581constructorimpl($composer3);
                            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer3.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer3.startReplaceableGroup(2058660585);
                            int i9 = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i10 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1859773471, "C423@21245L22:AppBar.kt#uh7d8r");
                            function24.invoke($composer3, Integer.valueOf((i8 >> 6) & 14));
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 1572864 | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentPadding3 = contentPadding2;
            windowInsets3 = windowInsets2;
            function23 = function22;
            containerColor3 = containerColor2;
            tonalElevation3 = tonalElevation2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
        final long j = containerColor3;
        final long j2 = contentColor3;
        final float f = tonalElevation3;
        final PaddingValues paddingValues = contentPadding3;
        final WindowInsets windowInsets4 = windowInsets3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.m1296BottomAppBarSnr_uVM(actions, modifier4, function24, j, j2, f, paddingValues, windowInsets4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0139  */
    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1295BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r27, long r28, long r30, float r32, androidx.compose.foundation.layout.PaddingValues r33, androidx.compose.foundation.layout.WindowInsets r34, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1295BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float r18, float r19, float r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r7 = r21
            r8 = r22
            r0 = 1801969826(0x6b67e0a2, float:2.8032266E26)
            r7.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTopAppBarState)P(2,1)799@38640L145,799@38593L192:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L18
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r9 = r1
            goto L1a
        L18:
            r9 = r18
        L1a:
            r1 = r23 & 2
            if (r1 == 0) goto L21
            r1 = 0
            r10 = r1
            goto L23
        L21:
            r10 = r19
        L23:
            r1 = r23 & 4
            if (r1 == 0) goto L2a
            r1 = 0
            r11 = r1
            goto L2c
        L2a:
            r11 = r20
        L2c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L38
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:794)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L38:
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            androidx.compose.material3.TopAppBarState$Companion r1 = androidx.compose.material3.TopAppBarState.INSTANCE
            androidx.compose.runtime.saveable.Saver r1 = r1.getSaver()
            java.lang.Float r3 = java.lang.Float.valueOf(r9)
            java.lang.Float r4 = java.lang.Float.valueOf(r10)
            java.lang.Float r5 = java.lang.Float.valueOf(r11)
            r6 = r8 & 14
            r12 = r8 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            r12 = r8 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            r12 = 0
            r13 = 1618982084(0x607fb4c4, float:7.370227E19)
            r7.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r13)
            boolean r13 = r7.changed(r3)
            boolean r14 = r7.changed(r4)
            r13 = r13 | r14
            boolean r14 = r7.changed(r5)
            r13 = r13 | r14
            r14 = r21
            r15 = 0
            java.lang.Object r2 = r14.rememberedValue()
            r16 = 0
            if (r13 != 0) goto L88
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.INSTANCE
            r19 = r3
            java.lang.Object r3 = r17.getEmpty()
            if (r2 != r3) goto L85
            goto L8a
        L85:
            r20 = r2
            goto L99
        L88:
            r19 = r3
        L8a:
            r3 = 0
            r20 = r2
            androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1 r2 = new androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L99:
            r21.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5 = 72
            r6 = 4
            r2 = 0
            r4 = r21
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.m2594rememberSaveable(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.material3.TopAppBarState r0 = (androidx.compose.material3.TopAppBarState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto Lb6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lb6:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberTopAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TopAppBarState");
    }

    static {
        float arg0$iv = Dp.m5212constructorimpl(16);
        float other$iv = Dp.m5212constructorimpl(12);
        BottomAppBarHorizontalPadding = Dp.m5212constructorimpl(arg0$iv - other$iv);
        float arg0$iv2 = Dp.m5212constructorimpl(16);
        float other$iv2 = Dp.m5212constructorimpl(12);
        BottomAppBarVerticalPadding = Dp.m5212constructorimpl(arg0$iv2 - other$iv2);
        float arg0$iv3 = Dp.m5212constructorimpl(16);
        float other$iv3 = BottomAppBarHorizontalPadding;
        FABHorizontalPadding = Dp.m5212constructorimpl(arg0$iv3 - other$iv3);
        float arg0$iv4 = Dp.m5212constructorimpl(12);
        float other$iv4 = BottomAppBarVerticalPadding;
        FABVerticalPadding = Dp.m5212constructorimpl(arg0$iv4 - other$iv4);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m5212constructorimpl(24);
        LargeTitleBottomPadding = Dp.m5212constructorimpl(28);
        TopAppBarHorizontalPadding = Dp.m5212constructorimpl(4);
        float arg0$iv5 = Dp.m5212constructorimpl(16);
        float other$iv5 = TopAppBarHorizontalPadding;
        TopAppBarTitleInset = Dp.m5212constructorimpl(arg0$iv5 - other$iv5);
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SingleRowTopAppBar(androidx.compose.ui.Modifier r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final androidx.compose.ui.text.TextStyle r39, final boolean r40, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, final androidx.compose.foundation.layout.WindowInsets r43, final androidx.compose.material3.TopAppBarColors r44, final androidx.compose.material3.TopAppBarScrollBehavior r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long SingleRowTopAppBar$lambda$3(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2957unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012a  */
    /* JADX INFO: renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1298TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final androidx.compose.ui.text.TextStyle r46, final float r47, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, final androidx.compose.ui.text.TextStyle r49, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, final androidx.compose.foundation.layout.WindowInsets r52, final androidx.compose.material3.TopAppBarColors r53, final float r54, final float r55, final androidx.compose.material3.TopAppBarScrollBehavior r56, androidx.compose.runtime.Composer r57, final int r58, final int r59, final int r60) {
        /*
            Method dump skipped, instruction units count: 1129
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1298TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final long TwoRowsTopAppBar_tjU4iQQ$lambda$8(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2957unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m1297TopAppBarLayoutkXwM9vE(final Modifier modifier, final float heightPx, final long navigationIconContentColor, final long titleContentColor, final long actionIconContentColor, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle titleTextStyle, final float titleAlpha, final Arrangement.Vertical titleVerticalArrangement, final Arrangement.Horizontal titleHorizontalArrangement, final int titleBottomPadding, final boolean hideTitleSemantics, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int $changed1) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Composer $composer2;
        final int $dirty;
        Composer $composer3 = $composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation($composer3, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1296@58560L4308:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(heightPx) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(navigationIconContentColor) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(titleContentColor) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changed(actionIconContentColor) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty2 |= $composer3.changed(titleTextStyle) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer3.changed(titleAlpha) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(titleVerticalArrangement) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changed(titleHorizontalArrangement) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(titleBottomPadding) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(hideTitleSemantics) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            function24 = function22;
            $dirty1 |= $composer3.changedInstance(function24) ? 256 : 128;
        } else {
            function24 = function22;
        }
        if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changedInstance(function23) ? 2048 : 1024;
        }
        int $dirty12 = $dirty1;
        if ((1533916891 & $dirty2) != 306783378 || ($dirty12 & 5851) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, $dirty2, $dirty12, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1280)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo12measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, final long constraints) {
                    int maxTitleWidth;
                    final int titleBaseline;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$first$iv = measurables;
                    for (Object element$iv : $this$first$iv) {
                        Measurable it = (Measurable) element$iv;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "navigationIcon")) {
                            final Placeable navigationIconPlaceable = ((Measurable) element$iv).mo4183measureBRTryo0(Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0));
                            List<? extends Measurable> $this$first$iv2 = measurables;
                            for (Object element$iv2 : $this$first$iv2) {
                                Measurable it2 = (Measurable) element$iv2;
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "actionIcons")) {
                                    final Placeable actionIconsPlaceable = ((Measurable) element$iv2).mo4183measureBRTryo0(Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0));
                                    if (Constraints.m5168getMaxWidthimpl(constraints) == Integer.MAX_VALUE) {
                                        maxTitleWidth = Constraints.m5168getMaxWidthimpl(constraints);
                                    } else {
                                        maxTitleWidth = RangesKt.coerceAtLeast((Constraints.m5168getMaxWidthimpl(constraints) - navigationIconPlaceable.getWidth()) - actionIconsPlaceable.getWidth(), 0);
                                    }
                                    List<? extends Measurable> $this$first$iv3 = measurables;
                                    for (Object element$iv3 : $this$first$iv3) {
                                        Measurable it3 = (Measurable) element$iv3;
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "title")) {
                                            final Placeable titlePlaceable = ((Measurable) element$iv3).mo4183measureBRTryo0(Constraints.m5158copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(constraints) : maxTitleWidth, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(constraints) : 0));
                                            if (titlePlaceable.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE) {
                                                titleBaseline = titlePlaceable.get(AlignmentLineKt.getLastBaseline());
                                            } else {
                                                titleBaseline = 0;
                                            }
                                            final int layoutHeight = MathKt.roundToInt(heightPx);
                                            int iM5168getMaxWidthimpl = Constraints.m5168getMaxWidthimpl(constraints);
                                            final Arrangement.Horizontal horizontal = titleHorizontalArrangement;
                                            final Arrangement.Vertical vertical = titleVerticalArrangement;
                                            final int i = titleBottomPadding;
                                            return MeasureScope.layout$default(Layout, iM5168getMaxWidthimpl, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$measure$1
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
                                                    int height;
                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                    Placeable placeable = navigationIconPlaceable;
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, (layoutHeight - placeable.getHeight()) / 2, 0.0f, 4, null);
                                                    Placeable placeable2 = titlePlaceable;
                                                    Arrangement.Horizontal horizontal2 = horizontal;
                                                    if (Intrinsics.areEqual(horizontal2, Arrangement.INSTANCE.getCenter())) {
                                                        iMax = (Constraints.m5168getMaxWidthimpl(constraints) - titlePlaceable.getWidth()) / 2;
                                                    } else if (!Intrinsics.areEqual(horizontal2, Arrangement.INSTANCE.getEnd())) {
                                                        iMax = Math.max(Layout.mo320roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), navigationIconPlaceable.getWidth());
                                                    } else {
                                                        iMax = (Constraints.m5168getMaxWidthimpl(constraints) - titlePlaceable.getWidth()) - actionIconsPlaceable.getWidth();
                                                    }
                                                    Arrangement.Vertical vertical2 = vertical;
                                                    if (Intrinsics.areEqual(vertical2, Arrangement.INSTANCE.getCenter())) {
                                                        height = (layoutHeight - titlePlaceable.getHeight()) / 2;
                                                    } else if (Intrinsics.areEqual(vertical2, Arrangement.INSTANCE.getBottom())) {
                                                        height = i == 0 ? layoutHeight - titlePlaceable.getHeight() : (layoutHeight - titlePlaceable.getHeight()) - Math.max(0, (i - titlePlaceable.getHeight()) + titleBaseline);
                                                    } else {
                                                        height = 0;
                                                    }
                                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, iMax, height, 0.0f, 4, null);
                                                    Placeable.PlacementScope.placeRelative$default(layout, actionIconsPlaceable, Constraints.m5168getMaxWidthimpl(constraints) - actionIconsPlaceable.getWidth(), (layoutHeight - actionIconsPlaceable.getHeight()) / 2, 0.0f, 4, null);
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
            int $changed$iv = ($dirty2 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -290535407, "C1298@58590L352,1308@58955L577,1322@59545L336:AppBar.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon");
            float f = TopAppBarHorizontalPadding;
            Modifier modifier$iv = PaddingKt.m485paddingqDBjuR0$default(modifierLayoutId, f, 0.0f, 0.0f, 0.0f, 14, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) objConsume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) objConsume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer3.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) objConsume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            function3MaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090283935, "C1303@58765L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2937boximpl(navigationIconContentColor))}, function24, $composer3, (($dirty12 >> 3) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifierM483paddingVpY3zN4$default = PaddingKt.m483paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f, 0.0f, 2, null);
            Modifier.Companion companionClearAndSetSemantics = Modifier.INSTANCE;
            if (hideTitleSemantics) {
                companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companionClearAndSetSemantics, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }
                });
            }
            Modifier modifier$iv2 = GraphicsLayerModifierKt.m3103graphicsLayerAp8cVGQ$default(modifierM483paddingVpY3zN4$default.then(companionClearAndSetSemantics), 0.0f, 0.0f, titleAlpha, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume7 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv2 = (Density) objConsume7;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume8 = $composer3.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) objConsume8;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume9 = $composer3.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) objConsume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor3);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            function3MaterializerOf3.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090283420, "C1315@59280L238:AppBar.kt#uh7d8r");
            TextKt.ProvideTextStyle(titleTextStyle, ComposableLambdaKt.composableLambda($composer3, 824316656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1316@59343L157:AppBar.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(824316656, $changed2, -1, "androidx.compose.material3.TopAppBarLayout.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:1315)");
                        }
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2937boximpl(titleContentColor))}, function2, $composer4, (($dirty >> 12) & 112) | 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty >> 18) & 14) | 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = PaddingKt.m485paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, f, 0.0f, 11, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume10 = $composer3.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv3 = (Density) objConsume10;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume11 = $composer3.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) objConsume11;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume12 = $composer3.consume(localViewConfiguration4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) objConsume12;
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = ((((6 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor4);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            function3MaterializerOf4.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i6 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i7 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090282985, "C1327@59715L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2937boximpl(actionIconContentColor))}, function23, $composer3, (($dirty12 >> 6) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $dirty = $dirty2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
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
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i8) {
                AppBarKt.m1297TopAppBarLayoutkXwM9vE(modifier, heightPx, navigationIconContentColor, titleContentColor, actionIconContentColor, function2, titleTextStyle, titleAlpha, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object settleAppBar(final androidx.compose.material3.TopAppBarState r23, float r24, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r25, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r27) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }
}
