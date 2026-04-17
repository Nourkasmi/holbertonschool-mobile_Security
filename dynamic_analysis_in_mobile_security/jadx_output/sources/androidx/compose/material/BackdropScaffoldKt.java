package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010?\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m5212constructorimpl(20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> function1, final SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation($composer, "C(rememberBackdropScaffoldState)P(2)171@6447L32,173@6518L538:BackdropScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m2594rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(initialValue, animationSpec, function1, snackbarHostState);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX INFO: renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    public static final void m971BackdropScaffoldBZszfkY(final Function2<? super Composer, ? super Integer, Unit> appBar, final Function2<? super Composer, ? super Integer, Unit> backLayerContent, final Function2<? super Composer, ? super Integer, Unit> frontLayerContent, Modifier modifier, BackdropScaffoldState scaffoldState, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        int i2;
        int i3;
        int i4;
        int $dirty;
        Shape shape;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32;
        int i5;
        int i6;
        int i7;
        int i8;
        BackdropScaffoldState scaffoldState2;
        boolean persistentAppBar2;
        boolean stickyFrontLayer2;
        int $dirty1;
        long backLayerBackgroundColor2;
        long backLayerContentColor2;
        int $dirty12;
        float peekHeight2;
        Shape frontLayerShape2;
        float frontLayerElevation2;
        long frontLayerBackgroundColor2;
        float headerHeight2;
        long frontLayerContentColor2;
        long frontLayerBackgroundColor3;
        long frontLayerBackgroundColor4;
        BackdropScaffoldState scaffoldState3;
        Shape frontLayerShape3;
        float frontLayerElevation3;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1058getLambda1$material_release;
        int $dirty13;
        long frontLayerScrimColor2;
        long frontLayerContentColor3;
        long frontLayerBackgroundColor5;
        long backLayerContentColor3;
        int $dirty2;
        boolean gesturesEnabled2;
        float peekHeight3;
        float headerHeight3;
        Object value$iv$iv;
        boolean persistentAppBar3;
        BackdropScaffoldState scaffoldState4;
        boolean gesturesEnabled3;
        float peekHeight4;
        float headerHeight4;
        Modifier modifier3;
        boolean stickyFrontLayer3;
        long backLayerBackgroundColor3;
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(backLayerContent, "backLayerContent");
        Intrinsics.checkNotNullParameter(frontLayerContent, "frontLayerContent");
        Composer $composer2 = $composer.startRestartGroup(1397420093);
        ComposerKt.sourceInformation($composer2, "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)260@11766L40,266@12093L6,267@12144L41,268@12241L15,270@12387L6,271@12439L42,272@12542L20,*275@12690L7,276@12764L7,288@13147L100,293@13271L3282:BackdropScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty14 = $changed1;
        int i9 = 2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changedInstance(appBar) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer2.changedInstance(backLayerContent) ? 32 : 16;
        }
        int i10 = 128;
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer2.changedInstance(frontLayerContent) ? 256 : 128;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i12 = 8192;
        if (($changed & 57344) == 0) {
            $dirty3 |= ((i & 16) == 0 && $composer2.changed(scaffoldState)) ? 16384 : 8192;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer2.changed(gesturesEnabled) ? 131072 : 65536;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changed(peekHeight) ? 1048576 : 524288;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty3 |= 12582912;
            i2 = i15;
        } else if (($changed & 29360128) == 0) {
            i2 = i15;
            $dirty3 |= $composer2.changed(headerHeight) ? 8388608 : 4194304;
        } else {
            i2 = i15;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty3 |= 100663296;
            i3 = i16;
        } else if (($changed & 234881024) == 0) {
            i3 = i16;
            $dirty3 |= $composer2.changed(persistentAppBar) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i17;
        } else {
            if (($changed & 1879048192) == 0) {
                i4 = i17;
                $dirty3 |= $composer2.changed(stickyFrontLayer) ? 536870912 : 268435456;
            } else {
                i4 = i17;
            }
            $dirty = $dirty3;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer2.changed(backLayerBackgroundColor)) {
                i9 = 4;
            }
            $dirty14 |= i9;
        }
        if (($changed1 & 112) == 0) {
            $dirty14 |= ((i & 2048) == 0 && $composer2.changed(backLayerContentColor)) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0) {
                shape = frontLayerShape;
                if ($composer2.changed(shape)) {
                    i10 = 256;
                }
            } else {
                shape = frontLayerShape;
            }
            $dirty14 |= i10;
        } else {
            shape = frontLayerShape;
        }
        int i18 = i & 8192;
        if (i18 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer2.changed(frontLayerElevation) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(frontLayerBackgroundColor)) {
                i12 = 16384;
            }
            $dirty14 |= i12;
        }
        if ((458752 & $changed1) == 0) {
            $dirty14 |= ((i & 32768) == 0 && $composer2.changed(frontLayerContentColor)) ? 131072 : 65536;
        }
        if ((3670016 & $changed1) == 0) {
            $dirty14 |= ((i & 65536) == 0 && $composer2.changed(frontLayerScrimColor)) ? 1048576 : 524288;
        }
        int i19 = i & 131072;
        if (i19 != 0) {
            $dirty14 |= 12582912;
            function32 = function3;
        } else if (($changed1 & 29360128) == 0) {
            function32 = function3;
            $dirty14 |= $composer2.changedInstance(function32) ? 8388608 : 4194304;
        } else {
            function32 = function3;
        }
        int $dirty15 = $dirty14;
        if (($dirty & 1533916891) == 306783378 && (23967451 & $dirty15) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            scaffoldState4 = scaffoldState;
            gesturesEnabled3 = gesturesEnabled;
            peekHeight4 = peekHeight;
            persistentAppBar3 = persistentAppBar;
            stickyFrontLayer3 = stickyFrontLayer;
            backLayerBackgroundColor3 = backLayerBackgroundColor;
            backLayerContentColor3 = backLayerContentColor;
            frontLayerElevation3 = frontLayerElevation;
            frontLayerBackgroundColor5 = frontLayerBackgroundColor;
            frontLayerContentColor3 = frontLayerContentColor;
            frontLayerScrimColor2 = frontLayerScrimColor;
            modifier3 = modifier2;
            frontLayerShape3 = shape;
            function3M1058getLambda1$material_release = function32;
            headerHeight4 = headerHeight;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 16) != 0) {
                    i5 = i18;
                    i6 = i2;
                    i7 = i3;
                    i8 = i4;
                    scaffoldState2 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, $composer2, 6, 14);
                    $dirty &= -57345;
                } else {
                    i5 = i18;
                    i6 = i2;
                    i7 = i3;
                    i8 = i4;
                    scaffoldState2 = scaffoldState;
                }
                boolean gesturesEnabled4 = i13 != 0 ? true : gesturesEnabled;
                float peekHeight5 = i14 != 0 ? BackdropScaffoldDefaults.INSTANCE.m970getPeekHeightD9Ej5fM() : peekHeight;
                float headerHeight5 = i6 != 0 ? BackdropScaffoldDefaults.INSTANCE.m969getHeaderHeightD9Ej5fM() : headerHeight;
                persistentAppBar2 = i7 != 0 ? true : persistentAppBar;
                stickyFrontLayer2 = i8 != 0 ? true : stickyFrontLayer;
                BackdropScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 1024) != 0) {
                    $dirty1 = $dirty15 & (-15);
                    backLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1034getPrimary0d7_KjU();
                } else {
                    $dirty1 = $dirty15;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
                if ((i & 2048) != 0) {
                    backLayerContentColor2 = ColorsKt.m1052contentColorForek8zF_U(backLayerBackgroundColor2, $composer2, $dirty1 & 14);
                    $dirty12 = $dirty1 & (-113);
                } else {
                    backLayerContentColor2 = backLayerContentColor;
                    $dirty12 = $dirty1;
                }
                boolean gesturesEnabled5 = gesturesEnabled4;
                if ((i & 4096) != 0) {
                    peekHeight2 = peekHeight5;
                    frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape($composer2, 6);
                    $dirty12 &= -897;
                } else {
                    peekHeight2 = peekHeight5;
                    frontLayerShape2 = frontLayerShape;
                }
                float frontLayerElevation4 = i5 != 0 ? BackdropScaffoldDefaults.INSTANCE.m968getFrontLayerElevationD9Ej5fM() : frontLayerElevation;
                Shape frontLayerShape4 = frontLayerShape2;
                if ((i & 16384) != 0) {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1038getSurface0d7_KjU();
                    $dirty12 &= -57345;
                } else {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerBackgroundColor2 = frontLayerBackgroundColor;
                }
                if ((i & 32768) != 0) {
                    headerHeight2 = headerHeight5;
                    frontLayerContentColor2 = ColorsKt.m1052contentColorForek8zF_U(frontLayerBackgroundColor2, $composer2, ($dirty12 >> 12) & 14);
                    $dirty12 &= -458753;
                } else {
                    headerHeight2 = headerHeight5;
                    frontLayerContentColor2 = frontLayerContentColor;
                }
                if ((i & 65536) != 0) {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor($composer2, 6);
                    $dirty12 &= -3670017;
                } else {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = frontLayerScrimColor;
                }
                if (i19 != 0) {
                    frontLayerShape3 = frontLayerShape4;
                    frontLayerElevation3 = frontLayerElevation2;
                    function3M1058getLambda1$material_release = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1058getLambda1$material_release();
                    $dirty13 = $dirty12;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    modifier2 = modifier4;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor3;
                    backLayerContentColor3 = backLayerContentColor2;
                    $dirty2 = $dirty;
                    scaffoldState3 = scaffoldState5;
                    gesturesEnabled2 = gesturesEnabled5;
                    peekHeight3 = peekHeight2;
                    headerHeight3 = headerHeight2;
                } else {
                    scaffoldState3 = scaffoldState5;
                    frontLayerShape3 = frontLayerShape4;
                    frontLayerElevation3 = frontLayerElevation2;
                    function3M1058getLambda1$material_release = function3;
                    $dirty13 = $dirty12;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    modifier2 = modifier4;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor3;
                    backLayerContentColor3 = backLayerContentColor2;
                    $dirty2 = $dirty;
                    gesturesEnabled2 = gesturesEnabled5;
                    peekHeight3 = peekHeight2;
                    headerHeight3 = headerHeight2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 1024) != 0) {
                    $dirty15 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty15 &= -113;
                }
                if ((i & 4096) != 0) {
                    $dirty15 &= -897;
                }
                if ((i & 16384) != 0) {
                    $dirty15 &= -57345;
                }
                if ((i & 32768) != 0) {
                    $dirty15 &= -458753;
                }
                if ((i & 65536) != 0) {
                    gesturesEnabled2 = gesturesEnabled;
                    peekHeight3 = peekHeight;
                    headerHeight3 = headerHeight;
                    persistentAppBar2 = persistentAppBar;
                    backLayerContentColor3 = backLayerContentColor;
                    frontLayerElevation3 = frontLayerElevation;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor;
                    frontLayerContentColor3 = frontLayerContentColor;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    $dirty13 = (-3670017) & $dirty15;
                    frontLayerShape3 = shape;
                    function3M1058getLambda1$material_release = function32;
                    $dirty2 = $dirty;
                    scaffoldState3 = scaffoldState;
                    stickyFrontLayer2 = stickyFrontLayer;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                } else {
                    scaffoldState3 = scaffoldState;
                    gesturesEnabled2 = gesturesEnabled;
                    peekHeight3 = peekHeight;
                    headerHeight3 = headerHeight;
                    persistentAppBar2 = persistentAppBar;
                    backLayerContentColor3 = backLayerContentColor;
                    frontLayerElevation3 = frontLayerElevation;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor;
                    frontLayerContentColor3 = frontLayerContentColor;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    frontLayerShape3 = shape;
                    function3M1058getLambda1$material_release = function32;
                    $dirty13 = $dirty15;
                    $dirty2 = $dirty;
                    stickyFrontLayer2 = stickyFrontLayer;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397420093, $dirty2, $dirty13, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u241 = (Density) objConsume;
            final float peekHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u241.mo326toPx0680j_4(peekHeight3);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u242 = (Density) objConsume2;
            final float headerHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u242.mo326toPx0680j_4(headerHeight3);
            final boolean z = persistentAppBar2;
            final BackdropScaffoldState backdropScaffoldState = scaffoldState3;
            final int i20 = $dirty2;
            boolean persistentAppBar4 = persistentAppBar2;
            final Function2 backLayer = ComposableLambdaKt.composableLambda($composer2, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1744778315, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
                        }
                        if (z) {
                            $composer3.startReplaceableGroup(-1017265331);
                            ComposerKt.sourceInformation($composer3, "280@12876L82");
                            Function2<Composer, Integer, Unit> function2 = appBar;
                            int i21 = i20;
                            Function2<Composer, Integer, Unit> function22 = backLayerContent;
                            $composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                function0 = constructor;
                                $composer3.createNode(function0);
                            } else {
                                function0 = constructor;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2581constructorimpl($composer3);
                            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer3.startReplaceableGroup(2058660585);
                            int i22 = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276693570, "C77@3893L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i23 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1993300203, "C281@12901L8,282@12926L18:BackdropScaffold.kt#jmzs0o");
                            function2.invoke($composer3, Integer.valueOf(i21 & 14));
                            function22.invoke($composer3, Integer.valueOf((i21 >> 3) & 14));
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(-1017265219);
                            ComposerKt.sourceInformation($composer3, "285@12988L72");
                            BackdropValue targetValue = backdropScaffoldState.getTargetValue();
                            Function2<Composer, Integer, Unit> function23 = appBar;
                            Function2<Composer, Integer, Unit> function24 = backLayerContent;
                            int i24 = i20;
                            BackdropScaffoldKt.BackLayerTransition(targetValue, function23, function24, $composer3, ((i24 << 3) & 896) | ((i24 << 3) & 112));
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
            });
            Object key1$iv = Float.valueOf(headerHeightPx);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                        return Constraints.m5156boximpl(m976invokeZezNO4M(constraints.getValue()));
                    }

                    /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
                    public final long m976invokeZezNO4M(long it) {
                        return ConstraintsKt.m5185offsetNN6EwU$default(Constraints.m5158copyZbe2FdA(it, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(it) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(it) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(it) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(it) : 0), 0, -MathKt.roundToInt(headerHeightPx), 1, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final Function1 calculateBackLayerConstraints = (Function1) value$iv$iv;
            final Modifier modifier5 = modifier2;
            final boolean z2 = stickyFrontLayer2;
            final boolean z3 = gesturesEnabled2;
            final BackdropScaffoldState backdropScaffoldState2 = scaffoldState3;
            final int i21 = $dirty2;
            final Shape shape2 = frontLayerShape3;
            final long j = frontLayerBackgroundColor5;
            final long j2 = frontLayerContentColor3;
            final float f = frontLayerElevation3;
            final int i22 = $dirty13;
            final float f2 = headerHeight3;
            final float f3 = peekHeight3;
            final long j3 = frontLayerScrimColor2;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33 = function3M1058getLambda1$material_release;
            BackdropScaffoldState scaffoldState6 = scaffoldState3;
            boolean gesturesEnabled6 = gesturesEnabled2;
            SurfaceKt.m1196SurfaceFjzlyU(null, null, backLayerBackgroundColor2, backLayerContentColor3, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1049909631, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
                        }
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        $composer3.endReplaceableGroup();
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function2 = backLayer;
                        Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints;
                        final float f4 = headerHeightPx;
                        final boolean z4 = z2;
                        final boolean z5 = z3;
                        final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldState2;
                        final float f5 = peekHeightPx;
                        final int i23 = i21;
                        final Shape shape3 = shape2;
                        final long j4 = j;
                        final long j5 = j2;
                        final float f6 = f;
                        final int i24 = i22;
                        final float f7 = f2;
                        final float f8 = f3;
                        final Function2<Composer, Integer, Unit> function22 = frontLayerContent;
                        final long j6 = j3;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function34 = function33;
                        BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda($composer3, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f9, Composer composer, Integer num) {
                                m974invokejYbf7pk(constraints.getValue(), f9.floatValue(), composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:48:0x01cc  */
                            /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void m974invokejYbf7pk(long r38, float r40, androidx.compose.runtime.Composer r41, int r42) {
                                /*
                                    Method dump skipped, instruction units count: 811
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m974invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer3, 3120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty13 << 6) & 896) | 1572864 | (($dirty13 << 6) & 7168), 51);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            persistentAppBar3 = persistentAppBar4;
            scaffoldState4 = scaffoldState6;
            gesturesEnabled3 = gesturesEnabled6;
            peekHeight4 = peekHeight3;
            headerHeight4 = headerHeight3;
            modifier3 = modifier2;
            stickyFrontLayer3 = stickyFrontLayer2;
            backLayerBackgroundColor3 = backLayerBackgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final BackdropScaffoldState backdropScaffoldState3 = scaffoldState4;
        final boolean z4 = gesturesEnabled3;
        final float f4 = peekHeight4;
        final float f5 = headerHeight4;
        final boolean z5 = persistentAppBar3;
        final boolean z6 = stickyFrontLayer3;
        final long j4 = backLayerBackgroundColor3;
        final long j5 = backLayerContentColor3;
        final Shape shape3 = frontLayerShape3;
        final float f6 = frontLayerElevation3;
        final long j6 = frontLayerBackgroundColor5;
        final long j7 = frontLayerContentColor3;
        final long j8 = frontLayerScrimColor2;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34 = function3M1058getLambda1$material_release;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
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

            public final void invoke(Composer composer, int i23) {
                BackdropScaffoldKt.m971BackdropScaffoldBZszfkY(appBar, backLayerContent, frontLayerContent, modifier6, backdropScaffoldState3, z4, f4, f5, z5, z6, j4, j5, shape3, f6, j6, j7, j8, function34, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m972Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)388@16708L121,401@17118L62,397@17009L171:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, $dirty2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (color != Color.INSTANCE.m2983getUnspecified0d7_KjU()) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                $composer2.startReplaceableGroup(1010547004);
                ComposerKt.sourceInformation($composer2, "393@16915L37");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    int i = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 value$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    }
                    $composer2.endReplaceableGroup();
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                Object key1$iv = Color.m2937boximpl(color);
                int i2 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(key1$iv) | $composer2.changed(stateAnimateFloatAsState);
                Object value$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv2 == key1$iv2) {
                    }
                    $composer2.endReplaceableGroup();
                    CanvasKt.Canvas(modifierThen, (Function1) value$iv$iv2, $composer2, 0);
                }
                value$iv$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        DrawScope.m3484drawRectnJ9OG0$default(Canvas, color, 0L, 0L, BackdropScaffoldKt.Scrim_3J_VO9M$lambda$4(stateAnimateFloatAsState), null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) value$iv$iv2, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                BackdropScaffoldKt.m972Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue target, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function02;
        Composer $composer2;
        Function0<ComposeUiNode> function03;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)421@17840L112,*424@18002L7,429@18176L486:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(target) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(target == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer3, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackLayerTransition_u24lambda_u248 = (Density) objConsume;
            float animationSlideOffset = $this$BackLayerTransition_u24lambda_u248.mo326toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float appBarFloat = RangesKt.coerceIn(BackLayerTransition$lambda$7(stateAnimateFloatAsState) - f, 0.0f, 1.0f);
            float contentFloat = RangesKt.coerceIn(f - BackLayerTransition$lambda$7(stateAnimateFloatAsState), 0.0f, 1.0f);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1538629162, "C430@18190L226,438@18425L231:BackdropScaffold.kt#jmzs0o");
            Modifier modifier$iv2 = GraphicsLayerModifierKt.m3103graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, appBarFloat), 0.0f, 0.0f, appBarFloat, 0.0f, (f - appBarFloat) * animationSlideOffset, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function02 = constructor2;
                $composer3.createNode(function02);
            } else {
                function02 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m2581constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481855289, "C436@18398L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = GraphicsLayerModifierKt.m3103graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, contentFloat), 0.0f, 0.0f, contentFloat, 0.0f, (f - contentFloat) * (-animationSlideOffset), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function03 = constructor3;
                $composer3.createNode(function03);
            } else {
                function03 = constructor3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
            }
            function3ModifierMaterializerOf3.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481855050, "C444@18637L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
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

            public final void invoke(Composer composer, int i7) {
                BackdropScaffoldKt.BackLayerTransition(target, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final float BackLayerTransition$lambda$7(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)457@18967L890,457@18940L917:BackdropScaffold.kt#jmzs0o");
        final int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            int i = (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(function2) | $composer2.changed(function1) | $composer2.changed(function4);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m977invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m977invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, final long constraints) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo4183measureBRTryo0(function1.invoke(Constraints.m5156boximpl(constraints)).getValue());
                        final float backLayerHeight = backLayerPlaceable.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        final int i2 = $dirty;
                        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C466@19305L40:BackdropScaffold.kt#jmzs0o");
                                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, $changed2, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:465)");
                                }
                                function42.invoke(Constraints.m5156boximpl(constraints), Float.valueOf(backLayerHeight), $composer3, Integer.valueOf((i2 >> 3) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        List target$iv = new ArrayList(listSubcompose.size());
                        int index$iv$iv = 0;
                        int size = listSubcompose.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = listSubcompose.get(index$iv$iv);
                            target$iv.add(((Measurable) item$iv$iv).mo4183measureBRTryo0(constraints));
                            index$iv$iv++;
                            backLayerHeight = backLayerHeight;
                            listSubcompose = listSubcompose;
                        }
                        final List placeables = target$iv;
                        int maxWidth = Math.max(Constraints.m5170getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
                        int maxHeight = Math.max(Constraints.m5169getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
                        int size2 = placeables.size();
                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                            Object item$iv = placeables.get(index$iv);
                            Placeable it = (Placeable) item$iv;
                            maxWidth = Math.max(maxWidth, it.getWidth());
                            maxHeight = Math.max(maxHeight, it.getHeight());
                        }
                        return MeasureScope.layout$default(SubcomposeLayout, maxWidth, maxHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Placeable.PlacementScope.placeRelative$default(layout, backLayerPlaceable, 0, 0, 0.0f, 4, null);
                                List<Placeable> list = placeables;
                                int size3 = list.size();
                                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                    Object item$iv2 = list.get(index$iv2);
                                    Placeable it2 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default(layout, it2, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
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

            public final void invoke(Composer composer, int i2) {
                BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
