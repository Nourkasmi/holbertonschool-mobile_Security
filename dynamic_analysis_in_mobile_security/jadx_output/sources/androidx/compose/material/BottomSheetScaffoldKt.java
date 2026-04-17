package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u009c\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2-\u0010\u000b\u001a)\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aá\u0002\u0010\"\u001a\u00020\u00062\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020%2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u00012 \b\u0002\u0010.\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u00012\b\b\u0002\u00102\u001a\u00020\u00182\b\b\u0002\u00103\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u00182\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00182\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120;2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0002\u001aÈ\u0001\u0010>\u001a\u00020\u00062\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2&\u0010?\u001a\"\u0012\u0013\u0012\u001107¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2&\u0010A\u001a\"\u0012\u0013\u0012\u00110B¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2\u0013\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00060'¢\u0006\u0002\b\u001e2\u0006\u0010-\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130'2\u0006\u0010E\u001a\u00020\bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a4\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007\u001a>\u0010M\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010N\u001a\u00020O2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0014\b\u0002\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007\u001a\u001c\u0010Q\u001a\u00020R2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030S2\u0006\u0010T\u001a\u00020UH\u0002\u001a+\u0010V\u001a\u00020%2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020\b2\b\b\u0002\u0010Z\u001a\u00020)H\u0007¢\u0006\u0002\u0010[\u001a;\u0010\\\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007¢\u0006\u0002\u0010]\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006^"}, d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "calculateAnchors", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "sheetSize", "", "Landroidx/compose/material/BottomSheetValue;", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "BottomSheetState", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m5212constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m5212constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m5212constructorimpl(125);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, animationSpec, function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        return new BottomSheetState(initialValue, animationSpec, confirmStateChange);
    }

    public static /* synthetic */ BottomSheetState BottomSheetState$default(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetState BottomSheetState(BottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        BottomSheetState it = new BottomSheetState(initialValue, animationSpec, confirmValueChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetState)P(2)308@11241L7,309@11260L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:303)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m2594rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1, density), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return BottomSheetScaffoldKt.BottomSheetState(initialValue, density, animationSpec, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)P(1)351@12567L39,352@12649L35,353@12729L32,355@12803L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer, 6, 6);
        }
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:350)");
        }
        int i2 = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(drawerState) | $composer.changed(bottomSheetState) | $composer.changed(snackbarHostState);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    public static final void m992BottomSheetScaffoldbGncdBI(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        int $dirty2;
        int i6;
        int i7;
        int i8;
        BottomSheetScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean sheetGesturesEnabled2;
        CornerBasedShape sheetShape2;
        float sheetElevation2;
        int $dirty;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        boolean drawerGesturesEnabled2;
        long sheetBackgroundColor3;
        CornerBasedShape drawerShape2;
        Shape drawerShape3;
        float drawerElevation2;
        long drawerBackgroundColor2;
        float sheetPeekHeight2;
        long drawerContentColor2;
        long drawerBackgroundColor3;
        int i9;
        long drawerScrimColor2;
        long drawerScrimColor3;
        long backgroundColor2;
        int $dirty22;
        int $dirty3;
        Shape drawerShape4;
        float drawerElevation3;
        float sheetPeekHeight3;
        long contentColor2;
        long backgroundColor3;
        int $dirty23;
        int $dirty24;
        int $dirty1;
        final BottomSheetScaffoldState scaffoldState3;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        long drawerScrimColor4;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        int floatingActionButtonPosition2;
        float sheetPeekHeight4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean sheetGesturesEnabled3;
        Shape sheetShape3;
        Shape drawerShape5;
        float sheetElevation3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        boolean drawerGesturesEnabled3;
        float drawerElevation4;
        long sheetContentColor3;
        long drawerScrimColor5;
        long drawerContentColor3;
        long sheetBackgroundColor4;
        long drawerBackgroundColor4;
        long backgroundColor4;
        long contentColor3;
        BottomSheetScaffoldState scaffoldState4;
        Modifier modifier3;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(46422755);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)417@16492L34,423@16861L6,425@16992L6,426@17039L37,430@17296L6,432@17411L6,433@17459L38,434@17544L10,435@17599L6,436@17644L32,*447@18055L7,499@20525L713:BottomSheetScaffold.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty12 = $changed1;
        int $dirty25 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer2.changedInstance(sheetContent) ? 4 : 2;
        }
        int i10 = i & 2;
        if (i10 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            $dirty4 |= ((i & 4) == 0 && $composer2.changed(scaffoldState)) ? 256 : 128;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty4 |= 3072;
            function23 = function2;
        } else if (($changed & 7168) == 0) {
            function23 = function2;
            $dirty4 |= $composer2.changedInstance(function23) ? 2048 : 1024;
        } else {
            function23 = function2;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty4 |= $composer2.changedInstance(function22) ? 131072 : 65536;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty4 |= 12582912;
            i2 = i15;
        } else if (($changed & 29360128) == 0) {
            i2 = i15;
            $dirty4 |= $composer2.changed(sheetGesturesEnabled) ? 8388608 : 4194304;
        } else {
            i2 = i15;
        }
        if (($changed & 234881024) == 0) {
            $dirty4 |= ((i & 256) == 0 && $composer2.changed(sheetShape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty4 |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty4 |= $composer2.changed(sheetElevation) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        if (($changed1 & 14) == 0) {
            $dirty12 |= ((i & 1024) == 0 && $composer2.changed(sheetBackgroundColor)) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty12 |= ((i & 2048) == 0 && $composer2.changed(sheetContentColor)) ? 32 : 16;
        }
        int i17 = i & 4096;
        if (i17 != 0) {
            $dirty12 |= 384;
            i4 = i17;
        } else {
            i4 = i17;
            if (($changed1 & 896) == 0) {
                $dirty12 |= $composer2.changed(sheetPeekHeight) ? 256 : 128;
            }
        }
        int i18 = i & 8192;
        if (i18 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changedInstance(function32) ? 2048 : 1024;
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty12 |= 24576;
            i5 = i19;
        } else if (($changed1 & 57344) == 0) {
            i5 = i19;
            $dirty12 |= $composer2.changed(drawerGesturesEnabled) ? 16384 : 8192;
        } else {
            i5 = i19;
        }
        if (($changed1 & 458752) == 0) {
            $dirty12 |= ((i & 32768) == 0 && $composer2.changed(drawerShape)) ? 131072 : 65536;
        }
        int i20 = i & 65536;
        if (i20 != 0) {
            $dirty12 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty12 |= $composer2.changed(drawerElevation) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty12 |= ((i & 131072) == 0 && $composer2.changed(drawerBackgroundColor)) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty12 |= ((i & 262144) == 0 && $composer2.changed(drawerContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            $dirty12 |= ((i & 524288) == 0 && $composer2.changed(drawerScrimColor)) ? 536870912 : 268435456;
        }
        int $dirty13 = $dirty12;
        if (($changed2 & 14) == 0) {
            $dirty25 |= ((i & 1048576) == 0 && $composer2.changed(backgroundColor)) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            if ((2097152 & i) == 0) {
                j = contentColor;
                int i21 = $composer2.changed(j) ? 32 : 16;
                $dirty25 |= i21;
            } else {
                j = contentColor;
            }
            $dirty25 |= i21;
        } else {
            j = contentColor;
        }
        if ((4194304 & i) != 0) {
            $dirty25 |= 384;
        } else if (($changed2 & 896) == 0) {
            $dirty25 |= $composer2.changedInstance(content) ? 256 : 128;
        }
        if ((1533916891 & $dirty4) == 306783378 && ($dirty13 & 1533916891) == 306783378 && ($dirty25 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            scaffoldState4 = scaffoldState;
            function35 = function3;
            function25 = function22;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            sheetGesturesEnabled3 = sheetGesturesEnabled;
            sheetShape3 = sheetShape;
            sheetElevation3 = sheetElevation;
            sheetBackgroundColor4 = sheetBackgroundColor;
            sheetContentColor3 = sheetContentColor;
            sheetPeekHeight4 = sheetPeekHeight;
            function36 = function32;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerShape5 = drawerShape;
            drawerElevation4 = drawerElevation;
            drawerBackgroundColor4 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
            drawerScrimColor5 = drawerScrimColor;
            backgroundColor4 = backgroundColor;
            function26 = function23;
            contentColor3 = j;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 = $dirty25;
                    i8 = i4;
                    i6 = i2;
                    i7 = i3;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, null, $composer2, 0, 7);
                    $dirty4 &= -897;
                } else {
                    $dirty2 = $dirty25;
                    i6 = i2;
                    i7 = i3;
                    i8 = i4;
                    scaffoldState2 = scaffoldState;
                }
                Function2<? super Composer, ? super Integer, Unit> function27 = i11 != 0 ? null : function2;
                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1059getLambda1$material_release = i12 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1059getLambda1$material_release() : function3;
                function24 = i13 != 0 ? null : function22;
                int floatingActionButtonPosition3 = i14 != 0 ? FabPosition.INSTANCE.m1105getEnd5ygKITE() : floatingActionButtonPosition;
                sheetGesturesEnabled2 = i6 != 0 ? true : sheetGesturesEnabled;
                BottomSheetScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 256) != 0) {
                    sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty4 &= -234881025;
                } else {
                    sheetShape2 = sheetShape;
                }
                sheetElevation2 = i7 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m989getSheetElevationD9Ej5fM() : sheetElevation;
                if ((i & 1024) != 0) {
                    $dirty = $dirty4;
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1038getSurface0d7_KjU();
                    $dirty13 &= -15;
                } else {
                    $dirty = $dirty4;
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                Function2<? super Composer, ? super Integer, Unit> function28 = function27;
                if ((i & 2048) != 0) {
                    sheetContentColor2 = ColorsKt.m1052contentColorForek8zF_U(sheetBackgroundColor2, $composer2, $dirty13 & 14);
                    $dirty13 &= -113;
                } else {
                    sheetContentColor2 = sheetContentColor;
                }
                float sheetPeekHeight5 = i8 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m990getSheetPeekHeightD9Ej5fM() : sheetPeekHeight;
                function33 = i18 != 0 ? null : function32;
                drawerGesturesEnabled2 = i5 != 0 ? true : drawerGesturesEnabled;
                if ((i & 32768) != 0) {
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty13 &= -458753;
                } else {
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    drawerShape2 = drawerShape;
                }
                float drawerElevation5 = i20 != 0 ? DrawerDefaults.INSTANCE.m1074getElevationD9Ej5fM() : drawerElevation;
                if ((i & 131072) != 0) {
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation5;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1038getSurface0d7_KjU();
                    $dirty13 &= -29360129;
                } else {
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation5;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 262144) != 0) {
                    sheetPeekHeight2 = sheetPeekHeight5;
                    drawerContentColor2 = ColorsKt.m1052contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty13 >> 21) & 14);
                    $dirty13 &= -234881025;
                } else {
                    sheetPeekHeight2 = sheetPeekHeight5;
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 524288) != 0) {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    i9 = 6;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty13 &= -1879048193;
                } else {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    i9 = 6;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((i & 1048576) != 0) {
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, i9).m1027getBackground0d7_KjU();
                    $dirty22 = $dirty2 & (-15);
                } else {
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor2 = backgroundColor;
                    $dirty22 = $dirty2;
                }
                if ((i & 2097152) != 0) {
                    Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37 = function3M1059getLambda1$material_release;
                    long contentColor4 = ColorsKt.m1052contentColorForek8zF_U(backgroundColor2, $composer2, $dirty22 & 14);
                    $dirty3 = $dirty;
                    drawerShape4 = drawerShape3;
                    drawerElevation3 = drawerElevation2;
                    sheetPeekHeight3 = sheetPeekHeight2;
                    $dirty23 = $dirty22 & (-113);
                    $dirty24 = floatingActionButtonPosition3;
                    $dirty1 = $dirty13;
                    contentColor2 = contentColor4;
                    drawerScrimColor4 = drawerScrimColor3;
                    function23 = function28;
                    backgroundColor3 = backgroundColor2;
                    scaffoldState3 = scaffoldState5;
                    function34 = function37;
                } else {
                    Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function38 = function3M1059getLambda1$material_release;
                    $dirty3 = $dirty;
                    drawerShape4 = drawerShape3;
                    drawerElevation3 = drawerElevation2;
                    sheetPeekHeight3 = sheetPeekHeight2;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    $dirty23 = $dirty22;
                    $dirty24 = floatingActionButtonPosition3;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState5;
                    function34 = function38;
                    drawerScrimColor4 = drawerScrimColor3;
                    function23 = function28;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i & 1024) != 0) {
                    $dirty13 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty13 &= -113;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty13 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty25 &= -15;
                }
                if ((2097152 & i) != 0) {
                    int i22 = $dirty25 & (-113);
                    function24 = function22;
                    $dirty24 = floatingActionButtonPosition;
                    sheetElevation2 = sheetElevation;
                    sheetBackgroundColor3 = sheetBackgroundColor;
                    sheetContentColor2 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    function33 = function32;
                    drawerGesturesEnabled2 = drawerGesturesEnabled;
                    drawerShape4 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor3 = drawerBackgroundColor;
                    drawerContentColor2 = drawerContentColor;
                    backgroundColor3 = backgroundColor;
                    $dirty3 = $dirty4;
                    $dirty23 = i22;
                    contentColor2 = j;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState;
                    function34 = function3;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetShape2 = sheetShape;
                    drawerScrimColor4 = drawerScrimColor;
                } else {
                    function34 = function3;
                    function24 = function22;
                    sheetElevation2 = sheetElevation;
                    sheetBackgroundColor3 = sheetBackgroundColor;
                    sheetContentColor2 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    function33 = function32;
                    drawerGesturesEnabled2 = drawerGesturesEnabled;
                    drawerShape4 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor3 = drawerBackgroundColor;
                    drawerContentColor2 = drawerContentColor;
                    backgroundColor3 = backgroundColor;
                    $dirty3 = $dirty4;
                    $dirty23 = $dirty25;
                    contentColor2 = j;
                    $dirty1 = $dirty13;
                    scaffoldState3 = scaffoldState;
                    $dirty24 = floatingActionButtonPosition;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetShape2 = sheetShape;
                    drawerScrimColor4 = drawerScrimColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46422755, $dirty3, $dirty1, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:414)");
            }
            $composer2.startReplaceableGroup(1207995830);
            ComposerKt.sourceInformation($composer2, "441@17907L7,442@17934L72,442@17923L83");
            if (scaffoldState3.getBottomSheetState().getDensity() == null) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Density density = (Density) objConsume;
                int i23 = ($dirty3 >> 6) & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(scaffoldState3) | $composer2.changed(density);
                Object it$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            scaffoldState3.getBottomSheetState().setDensity$material_release(density);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) value$iv$iv, $composer2, 0);
            }
            $composer2.endReplaceableGroup();
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BottomSheetScaffold_bGncdBI_u24lambda_u244 = (Density) objConsume2;
            final float peekHeightPx = $this$BottomSheetScaffold_bGncdBI_u24lambda_u244.mo326toPx0680j_4(sheetPeekHeight3);
            final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState3;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
            final float f = sheetPeekHeight3;
            final int i24 = $dirty24;
            final int i25 = $dirty3;
            final int i26 = $dirty23;
            final int i27 = $dirty1;
            final boolean z = sheetGesturesEnabled2;
            final Shape shape = sheetShape2;
            final float f2 = sheetElevation2;
            final long j2 = sheetBackgroundColor3;
            final long j3 = sheetContentColor2;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function34;
            Function2<Composer, Integer, Unit> function211 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1
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

                /* JADX WARN: Removed duplicated region for block: B:21:0x010d  */
                /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r32, int r33) {
                    /*
                        Method dump skipped, instruction units count: 273
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            };
            Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function34;
            final Function2 child = ComposableLambdaKt.composableLambda($composer2, 893101063, true, function211);
            int floatingActionButtonPosition4 = $dirty24;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function311 = function33;
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState3;
            final boolean z2 = drawerGesturesEnabled2;
            final Shape shape2 = drawerShape4;
            final float f3 = drawerElevation3;
            final long j4 = drawerBackgroundColor3;
            final long j5 = drawerContentColor2;
            final long j6 = drawerScrimColor4;
            final int i28 = $dirty1;
            BottomSheetScaffoldState scaffoldState6 = scaffoldState3;
            SurfaceKt.m1196SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, backgroundColor3, contentColor2, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, 1273816607, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                public final void invoke(Composer $composer3, int $changed3) {
                    ComposerKt.sourceInformation($composer3, "C:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1273816607, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:504)");
                        }
                        if (function311 == null) {
                            $composer3.startReplaceableGroup(-249540336);
                            ComposerKt.sourceInformation($composer3, "506@20705L7");
                            child.invoke($composer3, 6);
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(-249540299);
                            ComposerKt.sourceInformation($composer3, "508@20742L480");
                            Function3<ColumnScope, Composer, Integer, Unit> function312 = function311;
                            DrawerState drawerState = bottomSheetScaffoldState2.getDrawerState();
                            boolean z3 = z2;
                            Shape shape3 = shape2;
                            float f4 = f3;
                            long j7 = j4;
                            long j8 = j5;
                            long j9 = j6;
                            Function2<Composer, Integer, Unit> function212 = child;
                            int i29 = i28;
                            DrawerKt.m1077ModalDrawerGs3lGvM(function312, null, drawerState, z3, shape3, f4, j7, j8, j9, function212, $composer3, ((i29 >> 9) & 14) | 805306368 | ((i29 >> 3) & 7168) | ((i29 >> 3) & 57344) | ((i29 >> 3) & 458752) | ((i29 >> 3) & 3670016) | ((i29 >> 3) & 29360128) | ((i29 >> 3) & 234881024), 2);
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
            }), $composer2, (($dirty23 << 6) & 896) | 1572864 | (($dirty23 << 6) & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function35 = function310;
            floatingActionButtonPosition2 = floatingActionButtonPosition4;
            sheetPeekHeight4 = sheetPeekHeight3;
            function25 = function24;
            function26 = function23;
            sheetGesturesEnabled3 = sheetGesturesEnabled2;
            sheetShape3 = sheetShape2;
            drawerShape5 = drawerShape4;
            sheetElevation3 = sheetElevation2;
            function36 = function33;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            drawerElevation4 = drawerElevation3;
            sheetContentColor3 = sheetContentColor2;
            drawerScrimColor5 = drawerScrimColor4;
            drawerContentColor3 = drawerContentColor2;
            sheetBackgroundColor4 = sheetBackgroundColor3;
            drawerBackgroundColor4 = drawerBackgroundColor3;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor2;
            scaffoldState4 = scaffoldState6;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final BottomSheetScaffoldState bottomSheetScaffoldState3 = scaffoldState4;
        final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function35;
        final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
        final int i29 = floatingActionButtonPosition2;
        final boolean z3 = sheetGesturesEnabled3;
        final Shape shape3 = sheetShape3;
        final float f4 = sheetElevation3;
        final long j7 = sheetBackgroundColor4;
        final long j8 = sheetContentColor3;
        final float f5 = sheetPeekHeight4;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function313 = function36;
        final boolean z4 = drawerGesturesEnabled3;
        final Shape shape4 = drawerShape5;
        final float f6 = drawerElevation4;
        final long j9 = drawerBackgroundColor4;
        final long j10 = drawerContentColor3;
        final long j11 = drawerScrimColor5;
        final long j12 = backgroundColor4;
        final long j13 = contentColor3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$3
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

            public final void invoke(Composer composer, int i30) {
                BottomSheetScaffoldKt.m992BottomSheetScaffoldbGncdBI(sheetContent, modifier4, bottomSheetScaffoldState3, function212, function312, function213, i29, z3, shape3, f4, j7, j8, f5, function313, z4, shape4, f6, j9, j10, j11, j12, j13, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0296  */
    /* JADX INFO: renamed from: BottomSheet-0cLKjW4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m991BottomSheet0cLKjW4(final androidx.compose.material.BottomSheetState r30, final boolean r31, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.IntSize, ? extends java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float>> r32, final androidx.compose.ui.graphics.Shape r33, final float r34, final long r35, final long r37, androidx.compose.ui.Modifier r39, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m991BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m993BottomSheetScaffoldLayoutKCBPh4w(final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final float sheetPeekHeight, final int floatingActionButtonPosition, final Function0<Float> function0, final BottomSheetState sheetState, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)612@24340L2821,612@24323L2838:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((191739611 & $dirty) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, $dirty, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:601)");
            }
            Object[] keys$iv = {function32, function0, function2, function3, Dp.m5210boximpl(sheetPeekHeight), function22, FabPosition.m1097boximpl(floatingActionButtonPosition), function23, sheetState};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                final int i2 = $dirty;
                value$iv$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1

                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BottomSheetValue.values().length];
                            try {
                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m998invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x0214  */
                    /* JADX WARN: Removed duplicated region for block: B:78:0x0268  */
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.compose.ui.layout.MeasureResult m998invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope r40, long r41) {
                        /*
                            Method dump skipped, instruction units count: 1008
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.m998invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                i = 0;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv$iv, $composer2, i, 1);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
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

            public final void invoke(Composer composer, int i3) {
                BottomSheetScaffoldKt.m993BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, sheetPeekHeight, floatingActionButtonPosition, function0, sheetState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C02741 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C02741(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo335onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m3957equalsimpl0(source, NestedScrollSource.INSTANCE.m3962getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m2724getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo334onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m3957equalsimpl0(source, NestedScrollSource.INSTANCE.m3962getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m2724getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object mo558onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                r0.<init>(r6, r9)
            L19:
                r9 = r0
                java.lang.Object r0 = r9.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                switch(r2) {
                    case 0: goto L33;
                    case 1: goto L2d;
                    default: goto L25;
                }
            L25:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2d:
                long r7 = r9.J$0
                kotlin.ResultKt.throwOnFailure(r0)
                goto L5e
            L33:
                kotlin.ResultKt.throwOnFailure(r0)
                r2 = r6
                float r3 = r2.velocityToFloat(r7)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r4 = r4.requireOffset()
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 >= 0) goto L5f
                androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
                float r5 = r5.getMinOffset()
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 <= 0) goto L5f
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                r9.J$0 = r7
                r5 = 1
                r9.label = r5
                java.lang.Object r2 = r4.settle(r3, r9)
                if (r2 != r1) goto L5e
                return r1
            L5e:
                goto L65
            L5f:
                androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r7 = r7.m5448getZero9UxMQ8M()
            L65:
                androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m5428boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C02741.mo558onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object mo333onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
            /*
                r4 = this;
                boolean r5 = r9 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                r5.<init>(r4, r9)
            L19:
                java.lang.Object r6 = r5.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                switch(r0) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2c:
                long r7 = r5.J$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                r0 = r4
                androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
                float r2 = r0.velocityToFloat(r7)
                r5.J$0 = r7
                r3 = 1
                r5.label = r3
                java.lang.Object r0 = r1.settle(r2, r5)
                if (r0 != r9) goto L48
                return r9
            L48:
                androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m5428boximpl(r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C02741.mo333onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m5437getXimpl($this$toFloat) : Velocity.m5438getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m2708getXimpl($this$toFloat) : Offset.m2709getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C02741(anchoredDraggableState, orientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> BottomSheetScaffoldAnchorChangeCallback(final BottomSheetState state, final CoroutineScope scope) {
        return new AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffoldAnchorChangeCallback.1

            /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$WhenMappings */
            /* JADX INFO: compiled from: BottomSheetScaffold.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BottomSheetValue.values().length];
                    try {
                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(BottomSheetValue prevTarget, Map<BottomSheetValue, Float> prevAnchors, Map<BottomSheetValue, Float> newAnchors) {
                BottomSheetValue newTarget;
                Intrinsics.checkNotNullParameter(prevTarget, "prevTarget");
                Intrinsics.checkNotNullParameter(prevAnchors, "prevAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = prevAnchors.get(prevTarget);
                switch (WhenMappings.$EnumSwitchMapping$0[prevTarget.ordinal()]) {
                    case 1:
                        newTarget = BottomSheetValue.Collapsed;
                        break;
                    case 2:
                        newTarget = !newAnchors.containsKey(BottomSheetValue.Expanded) ? BottomSheetValue.Collapsed : BottomSheetValue.Expanded;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                float newTargetOffset = ((Number) MapsKt.getValue(newAnchors, newTarget)).floatValue();
                if (!Intrinsics.areEqual(newTargetOffset, previousTargetOffset)) {
                    if (state.isAnimationRunning$material_release()) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$1(state, newTarget, null), 3, null);
                        return;
                    }
                    boolean didSnapSynchronously = state.trySnapTo$material_release(newTarget);
                    if (!didSnapSynchronously) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2(state, newTarget, null), 3, null);
                    }
                }
            }
        };
    }
}
