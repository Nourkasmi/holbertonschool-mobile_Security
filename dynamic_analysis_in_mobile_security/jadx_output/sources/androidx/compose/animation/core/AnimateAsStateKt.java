package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: AnimateAsState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aU\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010$\u001aM\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%\u001aK\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aU\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aK\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001aU\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010*\u001aK\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001aU\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010*\u001aC\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00102\u001aM\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00103\u001aK\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u0010(\u001aU\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010*\u001as\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010=\u001a}\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006(\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002²\u0006 \u0010A\u001a\b\u0012\u0004\u0012\u0002H80\u0015\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-HyPO7BM", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateIntSizeAsState-4goxYXU", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateOffsetAsState-7362WCg", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateSizeAsState-YLp_XPw", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release", "listener", "animSpec"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m5210boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m2765boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2697boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5321boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5364boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 3, null);

    public static final State<Float> animateFloatAsState(float targetValue, AnimationSpec<Float> animationSpec, float visibilityThreshold, String label, Function1<? super Float, Unit> function1, Composer $composer, int $changed, int i) {
        AnimationSpec<Float> animationSpec2;
        Object key1$iv;
        $composer.startReplaceableGroup(668842840);
        ComposerKt.sourceInformation($composer, "C(animateFloatAsState)P(3!1,4,2)75@3368L173:AnimateAsState.kt#pdpnli");
        AnimationSpec<Float> animationSpec3 = (i & 2) != 0 ? defaultAnimation : animationSpec;
        float visibilityThreshold2 = (i & 4) != 0 ? 0.01f : visibilityThreshold;
        String label2 = (i & 8) != 0 ? "FloatAnimation" : label;
        Function1<? super Float, Unit> function12 = (i & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, $changed, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:62)");
        }
        $composer.startReplaceableGroup(841393662);
        ComposerKt.sourceInformation($composer, "71@3220L83");
        if (animationSpec3 == defaultAnimation) {
            Object key1$iv2 = Float.valueOf(visibilityThreshold2);
            int i2 = ($changed >> 6) & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(key1$iv2);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                key1$iv = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(visibilityThreshold2), 3, null);
                $composer.updateRememberedValue(key1$iv);
            } else {
                key1$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) key1$iv;
        } else {
            animationSpec2 = animationSpec3;
        }
        $composer.endReplaceableGroup();
        State<Float> stateAnimateValueAsState = animateValueAsState(Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec2, Float.valueOf(visibilityThreshold2), label2, function12, $composer, ($changed & 14) | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State<Dp> m81animateDpAsStateAjpBEmI(float targetValue, AnimationSpec<Dp> animationSpec, String label, Function1<? super Dp, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1407150062);
        ComposerKt.sourceInformation($composer, "C(animateDpAsState)P(3:c#ui.unit.Dp!1,2)114@5081L165:AnimateAsState.kt#pdpnli");
        AnimationSpec<Dp> animationSpec2 = (i & 2) != 0 ? dpDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "DpAnimation" : label;
        Function1<? super Dp, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, $changed, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:108)");
        }
        State<Dp> stateAnimateValueAsState = animateValueAsState(Dp.m5210boximpl(targetValue), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateSizeAsState-YLp_XPw, reason: not valid java name */
    public static final State<Size> m90animateSizeAsStateYLp_XPw(long targetValue, AnimationSpec<Size> animationSpec, String label, Function1<? super Size, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1374633148);
        ComposerKt.sourceInformation($composer, "C(animateSizeAsState)P(3:c#ui.geometry.Size!1,2)155@6928L167:AnimateAsState.kt#pdpnli");
        AnimationSpec<Size> animationSpec2 = (i & 2) != 0 ? sizeDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "SizeAnimation" : label;
        Function1<? super Size, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1374633148, $changed, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:149)");
        }
        State<Size> stateAnimateValueAsState = animateValueAsState(Size.m2765boximpl(targetValue), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateOffsetAsState-7362WCg, reason: not valid java name */
    public static final State<Offset> m87animateOffsetAsState7362WCg(long targetValue, AnimationSpec<Offset> animationSpec, String label, Function1<? super Offset, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(357896800);
        ComposerKt.sourceInformation($composer, "C(animateOffsetAsState)P(3:c#ui.geometry.Offset!1,2)195@8761L169:AnimateAsState.kt#pdpnli");
        AnimationSpec<Offset> animationSpec2 = (i & 2) != 0 ? offsetDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "OffsetAnimation" : label;
        Function1<? super Offset, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357896800, $changed, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:189)");
        }
        State<Offset> stateAnimateValueAsState = animateValueAsState(Offset.m2697boximpl(targetValue), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect targetValue, AnimationSpec<Rect> animationSpec, String label, Function1<? super Rect, Unit> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        $composer.startReplaceableGroup(536062978);
        ComposerKt.sourceInformation($composer, "C(animateRectAsState)P(3!1,2)236@10633L167:AnimateAsState.kt#pdpnli");
        AnimationSpec<Rect> animationSpec2 = (i & 2) != 0 ? rectDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "RectAnimation" : label;
        Function1<? super Rect, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(536062978, $changed, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:230)");
        }
        State<Rect> stateAnimateValueAsState = animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int targetValue, AnimationSpec<Integer> animationSpec, String label, Function1<? super Integer, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(428074472);
        ComposerKt.sourceInformation($composer, "C(animateIntAsState)P(3!1,2)274@12363L166:AnimateAsState.kt#pdpnli");
        AnimationSpec<Integer> animationSpec2 = (i & 2) != 0 ? intDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "IntAnimation" : label;
        Function1<? super Integer, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428074472, $changed, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:268)");
        }
        State<Integer> stateAnimateValueAsState = animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateIntOffsetAsState-HyPO7BM, reason: not valid java name */
    public static final State<IntOffset> m84animateIntOffsetAsStateHyPO7BM(long targetValue, AnimationSpec<IntOffset> animationSpec, String label, Function1<? super IntOffset, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-696782904);
        ComposerKt.sourceInformation($composer, "C(animateIntOffsetAsState)P(3:c#ui.unit.IntOffset!1,2)314@14224L172:AnimateAsState.kt#pdpnli");
        AnimationSpec<IntOffset> animationSpec2 = (i & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "IntOffsetAnimation" : label;
        Function1<? super IntOffset, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696782904, $changed, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:308)");
        }
        State<IntOffset> stateAnimateValueAsState = animateValueAsState(IntOffset.m5321boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateIntSizeAsState-4goxYXU, reason: not valid java name */
    public static final State<IntSize> m85animateIntSizeAsState4goxYXU(long targetValue, AnimationSpec<IntSize> animationSpec, String label, Function1<? super IntSize, Unit> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(582576328);
        ComposerKt.sourceInformation($composer, "C(animateIntSizeAsState)P(3:c#ui.unit.IntSize!1,2)352@16009L170:AnimateAsState.kt#pdpnli");
        AnimationSpec<IntSize> animationSpec2 = (i & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        String label2 = (i & 4) != 0 ? "IntSizeAnimation" : label;
        Function1<? super IntSize, Unit> function12 = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(582576328, $changed, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:346)");
        }
        State<IntSize> stateAnimateValueAsState = animateValueAsState(IntSize.m5364boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, label2, function12, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T t, TwoWayConverter<T, V> typeConverter, AnimationSpec<T> animationSpec, T t2, String label, Function1<? super T, Unit> function1, Composer $composer, int $changed, int i) {
        AnimationSpec<T> animationSpec2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-1994373980);
        ComposerKt.sourceInformation($composer, "C(animateValueAsState)P(3,4!1,5,2)393@18031L21,399@18213L44,400@18279L79,401@18379L38,402@18456L339,413@18814L42,414@18861L55,417@18921L721:AnimateAsState.kt#pdpnli");
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) value$iv$iv2;
        } else {
            animationSpec2 = animationSpec;
        }
        Object visibilityThreshold = (i & 8) != 0 ? null : t2;
        String label2 = (i & 16) != 0 ? "ValueAnimation" : label;
        Function1<? super T, Unit> function12 = (i & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, $changed, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:390)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MutableState toolingOverride = (MutableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object value$iv$iv3 = $composer.rememberedValue();
        if (value$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = new Animatable(t, typeConverter, visibilityThreshold, label2);
            $composer.updateRememberedValue(value$iv$iv3);
        }
        $composer.endReplaceableGroup();
        Animatable animatable = (Animatable) value$iv$iv3;
        State listener$delegate = SnapshotStateKt.rememberUpdatedState(function12, $composer, ($changed >> 15) & 14);
        AnimationSpec<T> animationSpec3 = animationSpec2;
        State animSpec$delegate = SnapshotStateKt.rememberUpdatedState((visibilityThreshold == null || !(animationSpec3 instanceof SpringSpec) || Intrinsics.areEqual(((SpringSpec) animationSpec3).getVisibilityThreshold(), visibilityThreshold)) ? animationSpec3 : AnimationSpecKt.spring(((SpringSpec) animationSpec3).getDampingRatio(), ((SpringSpec) animationSpec3).getStiffness(), visibilityThreshold), $composer, 0);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object value$iv$iv4 = $composer.rememberedValue();
        if (value$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = ChannelKt.Channel$default(-1, null, null, 6, null);
            $composer.updateRememberedValue(value$iv$iv4);
        }
        $composer.endReplaceableGroup();
        final Channel channel = (Channel) value$iv$iv4;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt.animateValueAsState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                channel.mo7001trySendJP2dKIU(t);
            }
        }, $composer, 0);
        EffectsKt.LaunchedEffect(channel, new AnonymousClass3(channel, animatable, animSpec$delegate, listener$delegate, null), $composer, 72);
        State<T> stateAsState = (State) toolingOverride.getValue();
        if (stateAsState == null) {
            stateAsState = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> state) {
        Object thisObj$iv = state.getValue();
        return (AnimationSpec) thisObj$iv;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float targetValue, AnimationSpec animationSpec, float visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1091643291);
        ComposerKt.sourceInformation($composer, "C(animateFloatAsState)P(2!1,3)446@20047L143:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = defaultAnimation;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            visibilityThreshold = 0.01f;
        }
        if ((i & 8) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1091643291, $changed, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:441)");
        }
        State<Float> stateAnimateFloatAsState = animateFloatAsState(targetValue, animationSpec, visibilityThreshold, null, finishedListener, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateFloatAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateDpAsState-Kz89ssw, reason: not valid java name */
    public static final /* synthetic */ State m82animateDpAsStateKz89ssw(float targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(704104481);
        ComposerKt.sourceInformation($composer, "C(animateDpAsState)P(2:c#ui.unit.Dp)463@20491L142:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = dpDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704104481, $changed, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:458)");
        }
        State stateAnimateValueAsState = animateValueAsState(Dp.m5210boximpl(targetValue), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateSizeAsState-LjSzlW0, reason: not valid java name */
    public static final /* synthetic */ State m89animateSizeAsStateLjSzlW0(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(875212471);
        ComposerKt.sourceInformation($composer, "C(animateSizeAsState)P(2:c#ui.geometry.Size)481@20948L144:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? sizeDefaultSpring : animationSpec;
        Function1 finishedListener2 = (i & 4) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875212471, $changed, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:476)");
        }
        State stateAnimateValueAsState = animateValueAsState(Size.m2765boximpl(targetValue), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateOffsetAsState-N6fFfp4, reason: not valid java name */
    public static final /* synthetic */ State m88animateOffsetAsStateN6fFfp4(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-456513133);
        ComposerKt.sourceInformation($composer, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)499@21419L122:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? offsetDefaultSpring : animationSpec;
        Function1 finishedListener2 = (i & 4) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-456513133, $changed, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:494)");
        }
        State stateAnimateValueAsState = animateValueAsState(Offset.m2697boximpl(targetValue), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        $composer.startReplaceableGroup(-782613967);
        ComposerKt.sourceInformation($composer, "C(animateRectAsState)P(2)514@21856L120:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = rectDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782613967, $changed, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:509)");
        }
        State stateAnimateValueAsState = animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-842612981);
        ComposerKt.sourceInformation($composer, "C(animateIntAsState)P(2)529@22285L119:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = intDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-842612981, $changed, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:524)");
        }
        State stateAnimateValueAsState = animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntOffsetAsState-8f6pmRE, reason: not valid java name */
    public static final /* synthetic */ State m83animateIntOffsetAsState8f6pmRE(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1010307371);
        ComposerKt.sourceInformation($composer, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)544@22749L125:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        Function1 finishedListener2 = (i & 4) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010307371, $changed, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:539)");
        }
        State stateAnimateValueAsState = animateValueAsState(IntOffset.m5321boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntSizeAsState-zTRF_AQ, reason: not valid java name */
    public static final /* synthetic */ State m86animateIntSizeAsStatezTRF_AQ(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1749239765);
        ComposerKt.sourceInformation($composer, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)559@23207L123:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        Function1 finishedListener2 = (i & 4) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749239765, $changed, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:554)");
        }
        State stateAnimateValueAsState = animateValueAsState(IntSize.m5364boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object targetValue, TwoWayConverter typeConverter, AnimationSpec animationSpec, Object visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i) {
        AnimationSpec animationSpec2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-846382129);
        ComposerKt.sourceInformation($composer, "C(animateValueAsState)P(2,3!1,4)572@23613L21,575@23730L240:AnimateAsState.kt#pdpnli");
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) value$iv$iv;
        } else {
            animationSpec2 = animationSpec;
        }
        Object visibilityThreshold2 = (i & 8) != 0 ? null : visibilityThreshold;
        Function1 finishedListener2 = (i & 16) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846382129, $changed, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:569)");
        }
        State stateAnimateValueAsState = animateValueAsState(targetValue, typeConverter, animationSpec2, visibilityThreshold2, "ValueAnimation", finishedListener2, $composer, ($changed & 8) | 24576 | ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed & 8) << 9) | ($changed & 7168) | (($changed << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimateAsState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", f = "AnimateAsState.kt", i = {0}, l = {419}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ Channel<T> $channel;
        final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Channel<T> channel, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnimateAsState.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
            final /* synthetic */ Animatable<T, V> $animatable;
            final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
            final /* synthetic */ T $newTarget;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(T t, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$newTarget = t;
                this.$animatable = animatable;
                this.$animSpec$delegate = state;
                this.$listener$delegate = state2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r11.label
                    switch(r1) {
                        case 0: goto L16;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L11:
                    r0 = r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L45
                L16:
                    kotlin.ResultKt.throwOnFailure(r12)
                    r1 = r11
                    T r2 = r1.$newTarget
                    androidx.compose.animation.core.Animatable<T, V> r3 = r1.$animatable
                    java.lang.Object r3 = r3.getTargetValue()
                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
                    if (r2 != 0) goto L57
                    androidx.compose.animation.core.Animatable<T, V> r3 = r1.$animatable
                    T r4 = r1.$newTarget
                    androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r2 = r1.$animSpec$delegate
                    androidx.compose.animation.core.AnimationSpec r5 = androidx.compose.animation.core.AnimateAsStateKt.access$animateValueAsState$lambda$6(r2)
                    r6 = 0
                    r7 = 0
                    r8 = r1
                    kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                    r9 = 12
                    r10 = 0
                    r2 = 1
                    r1.label = r2
                    java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
                    if (r2 != r0) goto L44
                    return r0
                L44:
                    r0 = r1
                L45:
                    androidx.compose.runtime.State<kotlin.jvm.functions.Function1<T, kotlin.Unit>> r1 = r0.$listener$delegate
                    kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.core.AnimateAsStateKt.access$animateValueAsState$lambda$4(r1)
                    if (r1 == 0) goto L56
                    androidx.compose.animation.core.Animatable<T, V> r2 = r0.$animatable
                    java.lang.Object r2 = r2.getValue()
                    r1.invoke(r2)
                L56:
                    r1 = r0
                L57:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004d -> B:12:0x0051). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r20
                int r2 = r1.label
                switch(r2) {
                    case 0: goto L26;
                    case 1: goto L13;
                    default: goto Lb;
                }
            Lb:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L13:
                r2 = r20
                r3 = r21
                java.lang.Object r4 = r2.L$1
                kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
                java.lang.Object r5 = r2.L$0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.ResultKt.throwOnFailure(r3)
                r12 = r5
                r5 = r4
                r4 = r3
                goto L51
            L26:
                kotlin.ResultKt.throwOnFailure(r21)
                r2 = r20
                r3 = r21
                java.lang.Object r4 = r2.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlinx.coroutines.channels.Channel<T> r5 = r2.$channel
                kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
                r19 = r5
                r5 = r4
                r4 = r19
            L3c:
                r6 = r2
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2.L$0 = r5
                r2.L$1 = r4
                r7 = 1
                r2.label = r7
                java.lang.Object r6 = r4.hasNext(r6)
                if (r6 != r0) goto L4d
                return r0
            L4d:
                r12 = r5
                r5 = r4
                r4 = r3
                r3 = r6
            L51:
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L8d
                java.lang.Object r3 = r5.next()
                kotlinx.coroutines.channels.Channel<T> r6 = r2.$channel
                java.lang.Object r6 = r6.mo7006tryReceivePtdJZtk()
                java.lang.Object r6 = kotlinx.coroutines.channels.ChannelResult.m7016getOrNullimpl(r6)
                if (r6 != 0) goto L6b
                r14 = r3
                goto L6c
            L6b:
                r14 = r6
            L6c:
                r7 = 0
                r8 = 0
                androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 r3 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1
                androidx.compose.animation.core.Animatable<T, V> r15 = r2.$animatable
                androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r6 = r2.$animSpec$delegate
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<T, kotlin.Unit>> r9 = r2.$listener$delegate
                r18 = 0
                r13 = r3
                r16 = r6
                r17 = r9
                r13.<init>(r14, r15, r16, r17, r18)
                r9 = r3
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r10 = 3
                r11 = 0
                r6 = r12
                kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
                r3 = r4
                r4 = r5
                r5 = r12
                goto L3c
            L8d:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
