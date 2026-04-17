package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0080\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u008a\u0002\u0010?\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001aÆ\u0001\u0010D\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020E2\b\b\u0002\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0018\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0013\u0010\u001b\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0013\u0010\u001c\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0019\u0010\u001d\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0019\u0010\u001f\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-rpjkMjA", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Id_Pb_0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedActiveTableMinHeight;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius;
    private static final float SearchBarIconOffsetX;
    private static final float SearchBarMaxWidth;
    private static final float SearchBarMinWidth;
    private static final float SearchBarVerticalPadding;

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0717  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x071a  */
    /* JADX INFO: renamed from: SearchBar-Id_Pb_0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1686SearchBarId_Pb_0(final java.lang.String r49, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r50, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r51, final boolean r52, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r53, androidx.compose.ui.Modifier r54, boolean r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.ui.graphics.Shape r59, androidx.compose.material3.SearchBarColors r60, float r61, androidx.compose.foundation.layout.WindowInsets r62, androidx.compose.foundation.interaction.MutableInteractionSource r63, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 1877
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m1686SearchBarId_Pb_0(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchBar_Id_Pb_0$lambda$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: renamed from: DockedSearchBar-rpjkMjA, reason: not valid java name */
    public static final void m1685DockedSearchBarrpjkMjA(final String query, final Function1<? super String, Unit> onQueryChange, final Function1<? super String, Unit> onSearch, final boolean active, final Function1<? super Boolean, Unit> onActiveChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors colors, float tonalElevation, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        SearchBarColors colors2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape3;
        int $dirty1;
        MutableInteractionSource interactionSource2;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        boolean enabled2;
        float tonalElevation2;
        SearchBarColors colors3;
        Modifier modifier2;
        Object value$iv$iv;
        Composer $composer2;
        Modifier modifier3;
        Object value$iv$iv2;
        SearchBarColors colors4;
        float tonalElevation3;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape4;
        boolean enabled3;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Intrinsics.checkNotNullParameter(onSearch, "onSearch");
        Intrinsics.checkNotNullParameter(onActiveChange, "onActiveChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-451213062);
        ComposerKt.sourceInformation($composer3, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,14,12!1,13:c#ui.unit.Dp,4)353@17339L11,354@17400L8,356@17514L39,359@17649L7,364@17756L38,361@17662L1564,406@19232L306,415@19574L37,415@19544L67:SearchBar.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(query) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onQueryChange) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(onSearch) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(active) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(onActiveChange) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(enabled) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty12 |= ((i & 1024) == 0 && $composer3.changed(shape)) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty12 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        int i7 = i & 4096;
        if (i7 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(tonalElevation) ? 256 : 128;
        }
        int i8 = i & 8192;
        if (i8 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 2048 : 1024;
        }
        if ((i & 16384) != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer3.changedInstance(content) ? 16384 : 8192;
        }
        if ((1533916891 & $dirty) == 306783378 && (46811 & $dirty12) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            function210 = function2;
            function28 = function22;
            function29 = function23;
            shape4 = shape;
            colors4 = colors;
            tonalElevation3 = tonalElevation;
            interactionSource3 = interactionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                Function2<? super Composer, ? super Integer, Unit> function211 = i4 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function212 = i5 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function213 = i6 != 0 ? null : function23;
                if ((i & 1024) != 0) {
                    function24 = function211;
                    shape2 = SearchBarDefaults.INSTANCE.getDockedShape($composer3, 6);
                    $dirty12 &= -15;
                } else {
                    function24 = function211;
                    shape2 = shape;
                }
                if ((i & 2048) != 0) {
                    colors2 = SearchBarDefaults.INSTANCE.m1680colorsKlgxPg(0L, 0L, null, $composer3, 3072, 7);
                    $dirty12 &= -113;
                } else {
                    colors2 = colors;
                }
                float tonalElevation4 = i7 != 0 ? SearchBarDefaults.INSTANCE.m1681getElevationD9Ej5fM() : tonalElevation;
                if (i8 != 0) {
                    Shape shape5 = shape2;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    int $dirty13 = $dirty12;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    function25 = function24;
                    shape3 = shape5;
                    $dirty1 = $dirty13;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    function26 = function212;
                    function27 = function213;
                    enabled2 = enabled4;
                    tonalElevation2 = tonalElevation4;
                    colors3 = colors2;
                    modifier2 = modifier4;
                } else {
                    function25 = function24;
                    shape3 = shape2;
                    $dirty1 = $dirty12;
                    interactionSource2 = interactionSource;
                    function26 = function212;
                    function27 = function213;
                    enabled2 = enabled4;
                    tonalElevation2 = tonalElevation4;
                    colors3 = colors2;
                    modifier2 = modifier4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i & 2048) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    function25 = function2;
                    function26 = function22;
                    function27 = function23;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty12 & (-113);
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    function25 = function2;
                    function26 = function22;
                    function27 = function23;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    interactionSource2 = interactionSource;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-451213062, $dirty, $dirty1, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:342)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) objConsume;
            long containerColor = colors3.getContainerColor();
            long jM1412contentColorForek8zF_U = ColorSchemeKt.m1412contentColorForek8zF_U(colors3.getContainerColor(), $composer3, 0);
            final int $dirty2 = $dirty;
            $composer2 = $composer3;
            final boolean z = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function214 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function216 = function27;
            final SearchBarColors searchBarColors = colors3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final int $dirty14 = $dirty1;
            modifier3 = modifier2;
            SurfaceKt.m1792SurfaceT9BRK9s(SizeKt.m533width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth), shape3, containerColor, jM1412contentColorForek8zF_U, tonalElevation2, 0.0f, null, ComposableLambdaKt.composableLambda($composer2, -1764436203, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$2
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
                    ComposerKt.sourceInformation($composer4, "C370@17943L1277:SearchBar.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1764436203, $changed2, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:369)");
                        }
                        String str = query;
                        Function1<String, Unit> function1 = onQueryChange;
                        Function1<String, Unit> function12 = onSearch;
                        boolean z2 = active;
                        Function1<Boolean, Unit> function13 = onActiveChange;
                        boolean z3 = z;
                        Function2<Composer, Integer, Unit> function217 = function214;
                        Function2<Composer, Integer, Unit> function218 = function215;
                        Function2<Composer, Integer, Unit> function219 = function216;
                        final SearchBarColors searchBarColors2 = searchBarColors;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        int i9 = $dirty2;
                        final int i10 = $dirty14;
                        final Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                        $composer4.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer4, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer4.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density density$iv$iv = (Density) objConsume2;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = $composer4.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) objConsume3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = $composer4.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) objConsume4;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor);
                        } else {
                            $composer4.useNode();
                        }
                        $composer4.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2581constructorimpl($composer4);
                        Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer4.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i11 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                        ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1253284504, "C371@17964L502,385@18480L730:SearchBar.kt#uh7d8r");
                        SearchBarKt.SearchBarInputField(str, function1, function12, z2, function13, null, z3, function217, function218, function219, searchBarColors2.getInputFieldColors(), mutableInteractionSource2, $composer4, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (1879048192 & i9), (i10 >> 6) & 112, 32);
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, z2, (Modifier) null, SearchBarKt.DockedEnterTransition, SearchBarKt.DockedExitTransition, (String) null, ComposableLambdaKt.composableLambda($composer4, 393964167, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed3) {
                                Object value$iv$iv3;
                                Object value$iv$iv4;
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C*390@18696L7,391@18754L115,394@18902L110,398@19030L166:SearchBar.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(393964167, $changed3, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:389)");
                                }
                                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = $composer5.consume(localConfiguration);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                int $this$dp$iv = ((Configuration) objConsume5).screenHeightDp;
                                float screenHeight = Dp.m5212constructorimpl($this$dp$iv);
                                Object key1$iv = Dp.m5210boximpl(screenHeight);
                                $composer5.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer5, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean invalid$iv$iv = $composer5.changed(key1$iv);
                                Object it$iv$iv2 = $composer5.rememberedValue();
                                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                    float other$iv = Dp.m5212constructorimpl(screenHeight * 0.6666667f);
                                    value$iv$iv3 = Dp.m5210boximpl(other$iv);
                                    $composer5.updateRememberedValue(value$iv$iv3);
                                } else {
                                    value$iv$iv3 = it$iv$iv2;
                                }
                                $composer5.endReplaceableGroup();
                                float maxHeight = ((Dp) value$iv$iv3).m5226unboximpl();
                                Object key1$iv2 = Dp.m5210boximpl(maxHeight);
                                $composer5.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer5, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean invalid$iv$iv2 = $composer5.changed(key1$iv2);
                                Object it$iv$iv3 = $composer5.rememberedValue();
                                if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv4 = Dp.m5210boximpl(((Dp) RangesKt.coerceAtMost(Dp.m5210boximpl(SearchBarKt.getDockedActiveTableMinHeight()), Dp.m5210boximpl(maxHeight))).m5226unboximpl());
                                    $composer5.updateRememberedValue(value$iv$iv4);
                                } else {
                                    value$iv$iv4 = it$iv$iv3;
                                }
                                $composer5.endReplaceableGroup();
                                float minHeight = ((Dp) value$iv$iv4).m5226unboximpl();
                                Modifier modifier$iv2 = SizeKt.m515heightInVpY3zN4(Modifier.INSTANCE, minHeight, maxHeight);
                                SearchBarColors searchBarColors3 = searchBarColors2;
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                int i12 = i10;
                                $composer5.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer5, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv2 = (0 << 3) & 112;
                                $composer5.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = $composer5.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Density density$iv$iv2 = (Density) objConsume6;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume7 = $composer5.consume(localLayoutDirection2);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) objConsume7;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume8 = $composer5.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) objConsume8;
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    $composer5.createNode(constructor2);
                                } else {
                                    $composer5.useNode();
                                }
                                $composer5.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2581constructorimpl($composer5);
                                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                $composer5.enableReusing();
                                function3MaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                $composer5.startReplaceableGroup(2058660585);
                                int i13 = ($changed$iv$iv$iv2 >> 9) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                                int $changed4 = ((0 >> 6) & 112) | 6;
                                ColumnScope $this$invoke_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1001846230, "C399@19112L36,400@19169L9:SearchBar.kt#uh7d8r");
                                DividerKt.m1494Divider9IZ8Weo(null, 0.0f, searchBarColors3.getDividerColor(), $composer5, 0, 3);
                                function32.invoke($this$invoke_u24lambda_u242, $composer5, Integer.valueOf(($changed4 & 14) | ((i12 >> 9) & 112)));
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endReplaceableGroup();
                                $composer5.endNode();
                                $composer5.endReplaceableGroup();
                                $composer5.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer4, ((((0 >> 6) & 112) | 6) & 14) | 1600512 | ((i9 >> 6) & 112), 18);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty14 << 3) & 112) | 12582912 | (($dirty14 << 6) & 57344), 96);
            EffectsKt.LaunchedEffect(Boolean.valueOf(active), new SearchBarKt$DockedSearchBar$3(active, focusManager, null), $composer2, (($dirty2 >> 9) & 14) | 64);
            int i9 = ($dirty2 >> 12) & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(onActiveChange);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new Function0<Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        onActiveChange.invoke(false);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(active, (Function0) value$iv$iv2, $composer2, ($dirty2 >> 9) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            tonalElevation3 = tonalElevation2;
            interactionSource3 = interactionSource2;
            function28 = function26;
            function29 = function27;
            shape4 = shape3;
            enabled3 = enabled2;
            function210 = function25;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled3;
        final Function2<? super Composer, ? super Integer, Unit> function217 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function218 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function219 = function29;
        final Shape shape6 = shape4;
        final SearchBarColors searchBarColors2 = colors4;
        final float f = tonalElevation3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$5
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

            public final void invoke(Composer composer, int i10) {
                SearchBarKt.m1685DockedSearchBarrpjkMjA(query, onQueryChange, onSearch, active, onActiveChange, modifier5, z2, function217, function218, function219, shape6, searchBarColors2, f, mutableInteractionSource2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SearchBarInputField(final java.lang.String r80, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r81, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r82, final boolean r83, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.foundation.interaction.MutableInteractionSource r91, androidx.compose.runtime.Composer r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instruction units count: 1509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.SearchBarInputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        float arg0$iv = SearchBarDefaults.INSTANCE.m1682getInputFieldHeightD9Ej5fM();
        SearchBarCornerRadius = Dp.m5212constructorimpl(arg0$iv / 2);
        DockedActiveTableMinHeight = Dp.m5212constructorimpl(240);
        SearchBarMinWidth = Dp.m5212constructorimpl(360);
        SearchBarMaxWidth = Dp.m5212constructorimpl(720);
        SearchBarVerticalPadding = Dp.m5212constructorimpl(8);
        SearchBarIconOffsetX = Dp.m5212constructorimpl(4);
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tweenSpecTween = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tweenSpecTween;
        TweenSpec tweenSpecTween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tweenSpecTween2;
        TweenSpec tweenSpecTween3 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tweenSpecTween3;
        TweenSpec tweenSpecTween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tweenSpecTween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tweenSpecTween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tweenSpecTween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tweenSpecTween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tweenSpecTween4, null, false, null, 14, null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}
