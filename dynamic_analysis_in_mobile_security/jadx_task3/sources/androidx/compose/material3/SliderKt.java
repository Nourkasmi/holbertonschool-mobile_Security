package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u007f\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010.\u001aÈ\u0001\u0010/\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00100\u001a³\u0001\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$2\u0019\b\u0002\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00104\u001a}\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$H\u0007¢\u0006\u0002\u00105\u001a\u0099\u0001\u00106\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020$2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00107\u001a1\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a \u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002\u001a0\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a<\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a(\u0010J\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a\u0010\u0010O\u001a\u00020L2\u0006\u0010+\u001a\u00020,H\u0002\u001a;\u0010P\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\b\u0018\u00010Q*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0098\u0001\u0010Z\u001a\u00020\u0001*\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020,2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0\\2\u001e\u0010`\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160a0\\H\u0002\u001a\\\u0010b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,H\u0002\u001ad\u0010c\u001a\u00020\u0001*\u00020\u00012\u0006\u00109\u001a\u00020:2\u0006\u00102\u001a\u00020$2\u0006\u0010N\u001a\u00020,2\u0006\u0010^\u001a\u00020\u001d2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0012\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\\2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Slider", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbDefaultElevation;
    private static final float ThumbHeight;
    private static final float ThumbPressedElevation;
    private static final long ThumbSize;
    private static final float ThumbWidth;
    private static final float TickSize;
    private static final float TrackHeight;

    public static final void Slider(final float value, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i2;
        Function0<Unit> function02;
        SliderColors colors2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        Modifier modifier2;
        final boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int steps2;
        final SliderColors colors3;
        Function0<Unit> function03;
        final int $dirty;
        final MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        MutableInteractionSource interactionSource3;
        SliderColors colors4;
        boolean enabled3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation($composer3, "C(Slider)P(7,4,3,1,8,6,5)155@7443L8,156@7503L39,160@7603L705:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                int i5 = $composer3.changed(closedFloatingPointRange2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            $dirty2 |= i5;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = steps;
        } else if (($changed & 458752) == 0) {
            i2 = steps;
            $dirty2 |= $composer3.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            function02 = function0;
        } else if (($changed & 3670016) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i8 = $composer3.changed(colors2) ? 8388608 : 4194304;
                $dirty2 |= i8;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i8;
        } else {
            colors2 = colors;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = enabled;
            interactionSource3 = interactionSource;
            colors4 = colors2;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            function03 = function02;
            $composer2 = $composer3;
            steps2 = i2;
            modifier2 = modifier;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i4 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                int steps3 = i6 != 0 ? 0 : i2;
                Function0<Unit> function04 = i7 != 0 ? null : function02;
                if ((i & 128) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1700colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                    $dirty2 &= -29360129;
                }
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    enabled2 = enabled4;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                    steps2 = steps3;
                    colors3 = colors2;
                    function03 = function04;
                    $dirty = $dirty3;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    enabled2 = enabled4;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                    steps2 = steps3;
                    colors3 = colors2;
                    function03 = function04;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    colors3 = colors2;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function03 = function02;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    colors3 = colors2;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function03 = function02;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202044027, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:146)");
            }
            if (!(steps2 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            interactionSource3 = interactionSource2;
            colors4 = colors3;
            enabled3 = enabled2;
            $composer2 = $composer3;
            SliderImpl(modifier2, enabled2, interactionSource2, onValueChange, function03, steps2, value, closedFloatingPointRange3, ComposableLambdaKt.composableLambda($composer3, -1522452856, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C170@7936L142:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1522452856, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:169)");
                        }
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        MutableInteractionSource mutableInteractionSource = interactionSource2;
                        SliderColors sliderColors = colors3;
                        boolean z = enabled2;
                        int i10 = $dirty;
                        sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors, z, 0L, $composer4, ((i10 >> 24) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i10 >> 15) & 896) | (i10 & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, 686671625, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                    ComposerKt.sourceInformation($composer4, "C177@8154L138:Slider.kt#uh7d8r");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(sliderPositions) ? 4 : 2;
                    }
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(686671625, $dirty4, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:176)");
                        }
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        SliderColors sliderColors = colors3;
                        boolean z = enabled2;
                        int i10 = $dirty;
                        sliderDefaults.Track(sliderPositions, null, sliderColors, z, $composer4, ($dirty4 & 14) | 24576 | ((i10 >> 15) & 896) | (i10 & 7168), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty >> 6) & 14) | 905969664 | (($dirty >> 6) & 112) | (($dirty >> 18) & 896) | (($dirty << 6) & 7168) | (($dirty >> 6) & 57344) | (458752 & $dirty) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
        final int i10 = steps2;
        final Function0<Unit> function05 = function03;
        final SliderColors sliderColors = colors4;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.5
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

            public final void invoke(Composer composer, int i11) {
                SliderKt.Slider(value, onValueChange, modifier4, z, closedFloatingPointRange4, i10, function05, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void Slider(final float value, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, int steps, Composer $composer, final int $changed, final int $changed1, final int i) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        final SliderColors colors2;
        Modifier modifier2;
        final MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        boolean z;
        ComposableLambda composableLambda;
        int steps2;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function34;
        boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Function0<Unit> function02;
        SliderColors colors3;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        int $dirty;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(251663723);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(9,4,3,1,10,5!2,7,8)250@11737L8,251@11797L39,271@12381L338:Slider.kt#uh7d8r");
        final int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                int i4 = $composer2.changed(closedFloatingPointRange2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            $dirty2 |= i4;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(colors)) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer2.changedInstance(function32) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changed(steps) ? 4 : 2;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            function02 = function0;
            colors3 = colors;
            interactionSource4 = interactionSource;
            function33 = function3;
            function34 = function32;
            steps2 = steps;
            closedFloatingPointRange3 = closedFloatingPointRange2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled3 = i3 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                Function0<Unit> function03 = i5 != 0 ? null : function0;
                if ((i & 64) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1700colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = colors;
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    modifier2 = modifier4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                }
                if (i7 != 0) {
                    Function3<SliderPositions, Composer, Integer, Unit> function35 = new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                            invoke(sliderPositions, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderPositions it, Composer $composer3, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer3, "C253@11914L126:Slider.kt#uh7d8r");
                            if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1998248322, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:252)");
                                }
                                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                MutableInteractionSource mutableInteractionSource = interactionSource2;
                                SliderColors sliderColors = colors2;
                                boolean z2 = enabled3;
                                int i10 = $dirty2;
                                sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors, z2, 0L, $composer3, ((i10 >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i10 >> 12) & 896) | (i10 & 7168), 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    };
                    interactionSource3 = interactionSource2;
                    z = true;
                    composableLambda = ComposableLambdaKt.composableLambda($composer2, 1998248322, true, function35);
                } else {
                    interactionSource3 = interactionSource2;
                    z = true;
                    composableLambda = function3;
                }
                ComposableLambda composableLambda2 = i8 != 0 ? ComposableLambdaKt.composableLambda($composer2, 1543282935, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions sliderPositions, Composer $composer3, int $changed2) {
                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                        ComposerKt.sourceInformation($composer3, "C260@12143L122:Slider.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty3 |= $composer3.changed(sliderPositions) ? 4 : 2;
                        }
                        if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1543282935, $dirty3, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:259)");
                            }
                            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                            SliderColors sliderColors = colors2;
                            boolean z2 = enabled3;
                            int i10 = $dirty2;
                            sliderDefaults.Track(sliderPositions, null, sliderColors, z2, $composer3, ($dirty3 & 14) | 24576 | ((i10 >> 12) & 896) | (i10 & 7168), 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }) : function32;
                if (i9 != 0) {
                    function33 = composableLambda;
                    function34 = composableLambda2;
                    steps2 = 0;
                    enabled2 = enabled3;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                    function02 = function03;
                    colors3 = colors2;
                    interactionSource4 = interactionSource3;
                    modifier3 = modifier2;
                    $dirty = $dirty2;
                } else {
                    steps2 = steps;
                    function33 = composableLambda;
                    function34 = composableLambda2;
                    enabled2 = enabled3;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                    function02 = function03;
                    colors3 = colors2;
                    interactionSource4 = interactionSource3;
                    modifier3 = modifier2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    function02 = function0;
                    colors3 = colors;
                    interactionSource4 = interactionSource;
                    function33 = function3;
                    function34 = function32;
                    steps2 = steps;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    $dirty = (-3670017) & $dirty2;
                    z = true;
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    function02 = function0;
                    colors3 = colors;
                    interactionSource4 = interactionSource;
                    function33 = function3;
                    function34 = function32;
                    steps2 = steps;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    z = true;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(251663723, $dirty, $dirty1, "androidx.compose.material3.Slider (Slider.kt:243)");
            }
            if (!(steps2 >= 0 ? z : false)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            SliderImpl(modifier3, enabled2, interactionSource4, onValueChange, function02, steps2, value, closedFloatingPointRange3, function33, function34, $composer2, (($dirty >> 6) & 14) | (($dirty >> 6) & 112) | (($dirty >> 15) & 896) | (($dirty << 6) & 7168) | (($dirty >> 3) & 57344) | (($dirty1 << 15) & 458752) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled2;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
        final Function0<Unit> function04 = function02;
        final SliderColors sliderColors = colors3;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function36 = function33;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function37 = function34;
        final int i10 = steps2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.10
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

            public final void invoke(Composer composer, int i11) {
                SliderKt.Slider(value, onValueChange, modifier5, z2, closedFloatingPointRange4, function04, sliderColors, mutableInteractionSource, function36, function37, i10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> value, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int steps2;
        Function0<Unit> function02;
        SliderColors sliderColors;
        Modifier modifier2;
        final int $dirty;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        Function0<Unit> function03;
        int steps3;
        final boolean enabled3;
        final SliderColors colors2;
        Object value$iv$iv;
        Object value$iv$iv2;
        SliderColors colors3;
        boolean enabled4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)328@15054L8,330@15126L39,331@15223L39,335@15320L988:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                int i4 = $composer3.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            $dirty2 |= i4;
        } else {
            closedFloatingPointRangeRangeTo = closedFloatingPointRange;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            steps2 = steps;
        } else if (($changed & 458752) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            function02 = function0;
        } else if (($changed & 3670016) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                sliderColors = colors;
                int i7 = $composer3.changed(sliderColors) ? 8388608 : 4194304;
                $dirty2 |= i7;
            } else {
                sliderColors = colors;
            }
            $dirty2 |= i7;
        } else {
            sliderColors = colors;
        }
        if (($dirty2 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled4 = enabled2;
            colors3 = sliderColors;
            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
            function03 = function02;
            steps3 = steps2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i5 != 0) {
                    steps2 = 0;
                }
                if (i6 != 0) {
                    function02 = null;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & (-29360129);
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    function03 = function02;
                    steps3 = steps2;
                    colors2 = SliderDefaults.INSTANCE.m1700colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                    enabled3 = enabled2;
                } else {
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    function03 = function02;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    $dirty = $dirty2 & (-29360129);
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    function03 = function02;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    function03 = function02;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743091416, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:319)");
            }
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            final MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv$iv2;
            if (!(steps3 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            colors3 = colors2;
            enabled4 = enabled3;
            $composer2 = $composer3;
            RangeSliderImpl(modifier2, value, onValueChange, enabled3, closedFloatingPointRange2, steps3, function03, startInteractionSource, endInteractionSource, ComposableLambdaKt.composableLambda($composer3, 1361279243, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C346@15726L147:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1361279243, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:345)");
                        }
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        MutableInteractionSource mutableInteractionSource = startInteractionSource;
                        SliderColors sliderColors2 = colors2;
                        boolean z = enabled3;
                        int i8 = $dirty;
                        sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors2, z, 0L, $composer4, ((i8 >> 15) & 896) | 196614 | (i8 & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, 741565023, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C353@15933L145:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(741565023, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:352)");
                        }
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        MutableInteractionSource mutableInteractionSource = endInteractionSource;
                        SliderColors sliderColors2 = colors2;
                        boolean z = enabled3;
                        int i8 = $dirty;
                        sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors2, z, 0L, $composer4, ((i8 >> 15) & 896) | 196614 | (i8 & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, -298726816, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                    ComposerKt.sourceInformation($composer4, "C360@16154L138:Slider.kt#uh7d8r");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(sliderPositions) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-298726816, $dirty3, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:359)");
                        }
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        SliderColors sliderColors2 = colors2;
                        boolean z = enabled3;
                        int i8 = $dirty;
                        sliderDefaults.Track(sliderPositions, null, sliderColors2, z, $composer4, ($dirty3 & 14) | 24576 | ((i8 >> 15) & 896) | (i8 & 7168), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 6) & 14) | 918552576 | (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRange2;
        final int i8 = steps3;
        final Function0<Unit> function04 = function03;
        final SliderColors sliderColors2 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.5
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

            public final void invoke(Composer composer, int i9) {
                SliderKt.RangeSlider(value, onValueChange, modifier4, z, closedFloatingPointRange3, i8, function04, sliderColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> value, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function0<Unit> function0, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33, int steps, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final int $dirty;
        final SliderColors colors2;
        final MutableInteractionSource startInteractionSource2;
        final MutableInteractionSource endInteractionSource2;
        MutableInteractionSource startInteractionSource3;
        boolean z;
        ComposableLambda composableLambda;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int steps2;
        MutableInteractionSource endInteractionSource3;
        SliderColors colors3;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function34;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function35;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function36;
        boolean enabled2;
        Function0<Unit> function02;
        MutableInteractionSource startInteractionSource4;
        Modifier modifier3;
        int $dirty2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2;
        int steps3;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function37;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function38;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function39;
        MutableInteractionSource endInteractionSource4;
        MutableInteractionSource endInteractionSource5;
        SliderColors colors4;
        Function0<Unit> function03;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        boolean enabled3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)435@20161L8,436@20226L39,437@20320L39,464@21150L445:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty3 |= ((i & 16) == 0 && $composer3.changed(closedFloatingPointRange)) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty3 |= ((i & 64) == 0 && $composer3.changed(colors)) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changed(startInteractionSource) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changed(endInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 536870912 : 268435456;
        }
        int i8 = i & 1024;
        if (i8 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function32) ? 4 : 2;
        }
        int i9 = i & 2048;
        if (i9 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(function33) ? 32 : 16;
        }
        int i10 = i & 4096;
        if (i10 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(steps) ? 256 : 128;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty1 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled3 = enabled;
            closedFloatingPointRange4 = closedFloatingPointRange;
            function03 = function0;
            colors4 = colors;
            endInteractionSource5 = startInteractionSource;
            endInteractionSource4 = endInteractionSource;
            function39 = function3;
            function38 = function32;
            function37 = function33;
            steps3 = steps;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled4 = i3 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    modifier2 = modifier5;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty3 &= -57345;
                } else {
                    modifier2 = modifier5;
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                Function0<Unit> function04 = i4 != 0 ? null : function0;
                if ((i & 64) != 0) {
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    $dirty = $dirty3 & (-3670017);
                    colors2 = SliderDefaults.INSTANCE.m1700colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    $dirty = $dirty3;
                    colors2 = colors;
                }
                if (i5 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    startInteractionSource2 = (MutableInteractionSource) value$iv$iv2;
                } else {
                    startInteractionSource2 = startInteractionSource;
                }
                if (i6 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer3.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv2;
                    }
                    $composer3.endReplaceableGroup();
                    endInteractionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    endInteractionSource2 = endInteractionSource;
                }
                if (i7 != 0) {
                    Function3<SliderPositions, Composer, Integer, Unit> function310 = new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                            invoke(sliderPositions, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer4, "C439@20442L131:Slider.kt#uh7d8r");
                            if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(585242822, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                }
                                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                MutableInteractionSource mutableInteractionSource = startInteractionSource2;
                                SliderColors sliderColors = colors2;
                                boolean z2 = enabled4;
                                int i11 = $dirty;
                                sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors, z2, 0L, $composer4, ((i11 >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i11 >> 12) & 896) | (i11 & 7168), 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    };
                    startInteractionSource3 = startInteractionSource2;
                    z = true;
                    composableLambda = ComposableLambdaKt.composableLambda($composer3, 585242822, true, function310);
                } else {
                    startInteractionSource3 = startInteractionSource2;
                    z = true;
                    composableLambda = function3;
                }
                ComposableLambda composableLambda2 = i8 != 0 ? ComposableLambdaKt.composableLambda($composer3, 1397395775, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer4, "C446@20660L129:Slider.kt#uh7d8r");
                        if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1397395775, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                            }
                            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                            MutableInteractionSource mutableInteractionSource = endInteractionSource2;
                            SliderColors sliderColors = colors2;
                            boolean z2 = enabled4;
                            int i11 = $dirty;
                            sliderDefaults.m1699Thumb9LiSoMs(mutableInteractionSource, null, sliderColors, z2, 0L, $composer4, ((i11 >> 24) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i11 >> 12) & 896) | (i11 & 7168), 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }) : function32;
                ComposableLambda composableLambda3 = i9 != 0 ? ComposableLambdaKt.composableLambda($composer3, -2139066097, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                        ComposerKt.sourceInformation($composer4, "C453@20896L138:Slider.kt#uh7d8r");
                        int $dirty4 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty4 |= $composer4.changed(sliderPositions) ? 4 : 2;
                        }
                        if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2139066097, $dirty4, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:452)");
                            }
                            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                            SliderColors sliderColors = colors2;
                            boolean z2 = enabled4;
                            int i11 = $dirty;
                            sliderDefaults.Track(sliderPositions, null, sliderColors, z2, $composer4, ($dirty4 & 14) | 24576 | ((i11 >> 12) & 896) | (i11 & 7168), 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }) : function33;
                if (i10 != 0) {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    endInteractionSource3 = endInteractionSource2;
                    colors3 = colors2;
                    function34 = composableLambda;
                    function35 = composableLambda2;
                    function36 = composableLambda3;
                    steps2 = 0;
                    enabled2 = enabled4;
                    function02 = function04;
                    startInteractionSource4 = startInteractionSource3;
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    steps2 = steps;
                    endInteractionSource3 = endInteractionSource2;
                    colors3 = colors2;
                    function34 = composableLambda;
                    function35 = composableLambda2;
                    function36 = composableLambda3;
                    enabled2 = enabled4;
                    function02 = function04;
                    startInteractionSource4 = startInteractionSource3;
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    closedFloatingPointRange3 = closedFloatingPointRange;
                    function02 = function0;
                    colors3 = colors;
                    startInteractionSource4 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    function34 = function3;
                    function35 = function32;
                    function36 = function33;
                    steps2 = steps;
                    $dirty2 = (-3670017) & $dirty3;
                    z = true;
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    closedFloatingPointRange3 = closedFloatingPointRange;
                    function02 = function0;
                    colors3 = colors;
                    startInteractionSource4 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    function34 = function3;
                    function35 = function32;
                    function36 = function33;
                    steps2 = steps;
                    $dirty2 = $dirty3;
                    z = true;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048796133, $dirty2, $dirty1, "androidx.compose.material3.RangeSlider (Slider.kt:428)");
            }
            if (!(steps2 >= 0 ? z : false)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            $composer2 = $composer3;
            RangeSliderImpl(modifier3, value, onValueChange, enabled2, closedFloatingPointRange3, steps2, function02, startInteractionSource4, endInteractionSource3, function34, function35, function36, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty1 << 9) & 458752) | (($dirty2 << 3) & 3670016) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty1 & 14) | ($dirty1 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            steps3 = steps2;
            function37 = function36;
            function38 = function35;
            function39 = function34;
            endInteractionSource4 = endInteractionSource3;
            endInteractionSource5 = startInteractionSource4;
            colors4 = colors3;
            function03 = function02;
            closedFloatingPointRange4 = closedFloatingPointRange3;
            enabled3 = enabled2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z2 = enabled3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRange4;
        final Function0<Unit> function05 = function03;
        final SliderColors sliderColors = colors4;
        final MutableInteractionSource mutableInteractionSource = endInteractionSource5;
        final MutableInteractionSource mutableInteractionSource2 = endInteractionSource4;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function311 = function39;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function312 = function38;
        final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function313 = function37;
        final int i11 = steps3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.12
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

            public final void invoke(Composer composer, int i12) {
                SliderKt.RangeSlider(value, onValueChange, modifier6, z2, closedFloatingPointRange5, function05, sliderColors, mutableInteractionSource, mutableInteractionSource2, function311, function312, function313, i11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderImpl(final Modifier modifier, final boolean enabled, final MutableInteractionSource interactionSource, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final int steps, final float value, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, final Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        int $dirty;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(851260148);
        ComposerKt.sourceInformation($composer3, "C(SliderImpl)P(2!5,8,9)493@22061L74,493@22023L112,499@22161L59,503@22243L45,504@22310L30,512@22682L7,513@22733L57,514@22813L31,518@23040L77,524@23249L492,535@23770L217,558@24427L40,563@24569L2021:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= $composer3.changed(steps) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty2 |= $composer3.changed(value) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer3.changed(closedFloatingPointRange) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function32) ? 536870912 : 268435456;
        }
        if ((1533916891 & $dirty2) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851260148, $dirty2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:481)");
            }
            Object key1$iv = Float.valueOf(value);
            int i = (($dirty2 >> 18) & 14) | (($dirty2 >> 6) & 112);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(key1$iv) | $composer3.changed(function1);
            Object value$iv$iv3 = $composer3.rememberedValue();
            if (invalid$iv$iv || value$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float it) {
                        if (!(it == value)) {
                            function1.invoke(Float.valueOf(it));
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv$iv3);
            }
            $composer3.endReplaceableGroup();
            final State onValueChangeState = SnapshotStateKt.rememberUpdatedState(value$iv$iv3, $composer3, 0);
            Object key1$iv2 = Integer.valueOf(steps);
            int i2 = ($dirty2 >> 15) & 14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer3.changed(key1$iv2);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = stepsToTickFractions(steps);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final float[] tickFractions = (float[]) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv4 = $composer3.rememberedValue();
            if (value$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(getThumbWidth()), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv4);
            }
            $composer3.endReplaceableGroup();
            final MutableState thumbWidth = (MutableState) value$iv$iv4;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv5 = $composer3.rememberedValue();
            if (value$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv5);
            }
            $composer3.endReplaceableGroup();
            final MutableState totalWidth = (MutableState) value$iv$iv5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isRtl = objConsume == LayoutDirection.Rtl;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv6 = $composer3.rememberedValue();
            if (value$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(SliderImpl$scaleToOffset(closedFloatingPointRange, 0.0f, 0.0f, value)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv6);
            }
            $composer3.endReplaceableGroup();
            final MutableState rawOffset = (MutableState) value$iv$iv6;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv7 = $composer3.rememberedValue();
            if (value$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv7);
            }
            $composer3.endReplaceableGroup();
            final MutableState pressOffset = (MutableState) value$iv$iv7;
            float coerced = RangesKt.coerceIn(value, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
            final float positionFraction = calcFraction(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), coerced);
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv8 = $composer3.rememberedValue();
            if (value$iv$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv8 = new SliderPositions(RangesKt.rangeTo(0.0f, positionFraction), tickFractions);
                $composer3.updateRememberedValue(value$iv$iv8);
            }
            $composer3.endReplaceableGroup();
            SliderPositions sliderPositions = (SliderPositions) value$iv$iv8;
            sliderPositions.setActiveRange$material3_release(RangesKt.rangeTo(0.0f, positionFraction));
            sliderPositions.setTickFractions$material3_release(tickFractions);
            int i3 = ($dirty2 >> 21) & 14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer3.changed(closedFloatingPointRange);
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (invalid$iv$iv3 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                $dirty = $dirty2;
                value$iv$iv2 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float it) {
                        float f = 2;
                        float maxPx = Math.max(totalWidth.getValue().floatValue() - (thumbWidth.getValue().floatValue() / f), 0.0f);
                        float minPx = Math.min(thumbWidth.getValue().floatValue() / f, maxPx);
                        MutableState<Float> mutableState = rawOffset;
                        mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + it + pressOffset.getValue().floatValue()));
                        pressOffset.setValue(Float.valueOf(0.0f));
                        float offsetInTrack = SliderKt.snapValueToTick(rawOffset.getValue().floatValue(), tickFractions, minPx, maxPx);
                        onValueChangeState.getValue().invoke(Float.valueOf(SliderKt.SliderImpl$scaleToUserValue(closedFloatingPointRange, minPx, maxPx, offsetInTrack)));
                    }
                });
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                $dirty = $dirty2;
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            final SliderDraggableState draggableState = (SliderDraggableState) value$iv$iv2;
            State gestureEndAction = SnapshotStateKt.rememberUpdatedState(new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1
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
                    Function0<Unit> function02;
                    if (draggableState.isDragging() || (function02 = function0) == null) {
                        return;
                    }
                    function02.invoke();
                }
            }, $composer3, 0);
            Modifier press = sliderTapModifier(Modifier.INSTANCE, draggableState, interactionSource, ((Number) totalWidth.getValue()).intValue(), isRtl, rawOffset, gestureEndAction, pressOffset, enabled);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = draggableState.isDragging();
            Modifier.Companion companion2 = companion;
            SliderDraggableState sliderDraggableState = draggableState;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv4 = $composer3.changed(gestureEndAction);
            SliderKt$SliderImpl$drag$1$1 value$iv$iv9 = $composer3.rememberedValue();
            if (invalid$iv$iv4 || value$iv$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv9 = new SliderKt$SliderImpl$drag$1$1(gestureEndAction, null);
                $composer3.updateRememberedValue(value$iv$iv9);
            }
            $composer3.endReplaceableGroup();
            boolean z = isRtl;
            $composer2 = $composer3;
            Modifier drag = DraggableKt.draggable(companion2, sliderDraggableState, orientation, (188 & 4) != 0 ? true : enabled, (188 & 8) != 0 ? null : interactionSource, (188 & 16) != 0 ? false : zIsDragging, (188 & 32) != 0 ? new DraggableKt.C01831(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : (Function3) value$iv$iv9, (188 & 128) != 0 ? false : z);
            Modifier modifier$iv = FocusableKt.focusable(sliderSemantics(SizeKt.m524requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderTokens.INSTANCE.m2433getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m2432getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), value, enabled, function1, function0, closedFloatingPointRange, steps), enabled, interactionSource).then(press).then(drag);
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt.SliderImpl.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo12measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$first$iv = measurables;
                    for (Object element$iv : $this$first$iv) {
                        Measurable it = (Measurable) element$iv;
                        if (LayoutIdKt.getLayoutId(it) == SliderComponents.THUMB) {
                            final Placeable thumbPlaceable = ((Measurable) element$iv).mo4183measureBRTryo0(constraints);
                            List<? extends Measurable> $this$first$iv2 = measurables;
                            for (Object element$iv2 : $this$first$iv2) {
                                Measurable it2 = (Measurable) element$iv2;
                                if (LayoutIdKt.getLayoutId(it2) == SliderComponents.TRACK) {
                                    long jM5185offsetNN6EwU$default = ConstraintsKt.m5185offsetNN6EwU$default(constraints, -thumbPlaceable.getWidth(), 0, 2, null);
                                    final Placeable trackPlaceable = ((Measurable) element$iv2).mo4183measureBRTryo0(Constraints.m5158copyZbe2FdA(jM5185offsetNN6EwU$default, (11 & 1) != 0 ? Constraints.m5170getMinWidthimpl(jM5185offsetNN6EwU$default) : 0, (11 & 2) != 0 ? Constraints.m5168getMaxWidthimpl(jM5185offsetNN6EwU$default) : 0, (11 & 4) != 0 ? Constraints.m5169getMinHeightimpl(jM5185offsetNN6EwU$default) : 0, (11 & 8) != 0 ? Constraints.m5167getMaxHeightimpl(jM5185offsetNN6EwU$default) : 0));
                                    int sliderWidth = thumbPlaceable.getWidth() + trackPlaceable.getWidth();
                                    int sliderHeight = Math.max(trackPlaceable.getHeight(), thumbPlaceable.getHeight());
                                    thumbWidth.setValue(Float.valueOf(thumbPlaceable.getWidth()));
                                    totalWidth.setValue(Integer.valueOf(sliderWidth));
                                    final int trackOffsetX = thumbPlaceable.getWidth() / 2;
                                    final int thumbOffsetX = MathKt.roundToInt(trackPlaceable.getWidth() * positionFraction);
                                    final int trackOffsetY = (sliderHeight - trackPlaceable.getHeight()) / 2;
                                    final int thumbOffsetY = (sliderHeight - thumbPlaceable.getHeight()) / 2;
                                    return MeasureScope.layout$default(Layout, sliderWidth, sliderHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$measure$1
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
                                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                            Placeable.PlacementScope.placeRelative$default(layout, trackPlaceable, trackOffsetX, trackOffsetY, 0.0f, 4, null);
                                            Placeable.PlacementScope.placeRelative$default(layout, thumbPlaceable, thumbOffsetX, thumbOffsetY, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) objConsume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2581constructorimpl($composer2);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1541256180, "C565@24599L84,566@24696L84:Slider.kt#uh7d8r");
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) objConsume5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer2.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) objConsume6;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume7 = $composer2.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) objConsume7;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor2);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2581constructorimpl($composer2);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            function3MaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1819487535, "C565@24659L22:Slider.kt#uh7d8r");
            function3.invoke(sliderPositions, $composer2, Integer.valueOf((($dirty >> 21) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume8 = $composer2.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv2 = (Density) objConsume8;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume9 = $composer2.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) objConsume9;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume10 = $composer2.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) objConsume10;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier$iv3);
            int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor3);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2581constructorimpl($composer2);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            function3MaterializerOf3.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i8 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1819487438, "C566@24756L22:Slider.kt#uh7d8r");
            function32.invoke(sliderPositions, $composer2, Integer.valueOf((($dirty >> 24) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.SliderImpl.3
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

            public final void invoke(Composer composer, int i9) {
                SliderKt.SliderImpl(modifier, enabled, interactionSource, function1, function0, steps, value, closedFloatingPointRange, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float offset) {
        return scale(minPx, maxPx, offset, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float userValue) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0610 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x068b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0839  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0849 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0a15 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0ae5  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0c4d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0c59  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0c5d  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0d17  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0d20  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0d23  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSliderImpl(final androidx.compose.ui.Modifier r75, final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r76, final kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r77, final boolean r78, final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r79, int r80, final kotlin.jvm.functions.Function0<kotlin.Unit> r81, final androidx.compose.foundation.interaction.MutableInteractionSource r82, final androidx.compose.foundation.interaction.MutableInteractionSource r83, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90) {
        /*
            Method dump skipped, instruction units count: 3414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSliderImpl(androidx.compose.ui.Modifier, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$25(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$26(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$28(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$29(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int RangeSliderImpl$lambda$31(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$32(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> RangeSliderImpl$scaleToUserValue$33(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return scale(minPx, maxPx, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$scaleToOffset$34(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float userValue) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.collections.IntIterator] */
    public static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        Float fValueOf;
        if (tickFractions.length == 0) {
            fValueOf = null;
        } else {
            float minElem$iv = tickFractions[0];
            int lastIndex$iv = ArraysKt.getLastIndex(tickFractions);
            if (lastIndex$iv == 0) {
                fValueOf = Float.valueOf(minElem$iv);
            } else {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, minElem$iv) - current);
                ?? it = new IntRange(1, lastIndex$iv).iterator();
                while (it.hasNext()) {
                    int i$iv = it.nextInt();
                    float e$iv = tickFractions[i$iv];
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, e$iv) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                }
                fValueOf = Float.valueOf(minElem$iv);
            }
        }
        if (fValueOf == null) {
            return current;
        }
        float $this$snapValueToTick_u24lambda_u2449 = fValueOf.floatValue();
        return MathHelpersKt.lerp(minPx, maxPx, $this$snapValueToTick_u24lambda_u2449);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m1702awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L19:
            r12 = r0
            java.lang.Object r6 = r12.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r12.label
            switch(r0) {
                case 0: goto L36;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            java.lang.Object r8 = r12.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r6
            goto L56
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r8
            r1 = r9
            r3 = r11
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r9 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r9.<init>()
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r12.L$0 = r8
            r10 = 1
            r12.label = r10
            r4 = r9
            r5 = r12
            java.lang.Object r9 = androidx.compose.material3.DragGestureDetectorCopyKt.m1495awaitHorizontalPointerSlopOrCancellationgDDlDlE(r0, r1, r3, r4, r5)
            if (r9 != r7) goto L56
            return r7
        L56:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L65
            float r10 = r8.element
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r9, r10)
            goto L66
        L65:
            r10 = 0
        L66:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m1702awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int steps) {
        if (steps == 0) {
            return new float[0];
        }
        int i = steps + 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = i2 / (steps + 1);
        }
        return fArr;
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    private static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> closedFloatingPointRange, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, closedFloatingPointRange.getStart().floatValue(), a2, b2), scale(a1, b1, closedFloatingPointRange.getEndInclusive().floatValue(), a2, b2));
    }

    private static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, final boolean enabled, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int steps) {
        final float coerced = RangesKt.coerceIn(value, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (!enabled) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i = steps;
                final float f = coerced;
                final Function1<Float, Unit> function12 = function1;
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f2) {
                        return invoke(f2.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        int i2 = i;
                        boolean z = true;
                        if (i2 > 0) {
                            float distance = newValue;
                            int i3 = 0;
                            int i4 = i2 + 1;
                            if (0 <= i4) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue(), i3 / (i + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i3 == i4) {
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == f) {
                            z = false;
                        } else {
                            function12.invoke(Float.valueOf(resolvedValue));
                            Function0<Unit> function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), value, closedFloatingPointRange, steps);
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, final DraggableState draggableState, final MutableInteractionSource interactionSource, final int maxPx, final boolean isRtl, final State<Float> state, final State<? extends Function0<Unit>> state2, final MutableState<Float> mutableState, final boolean enabled) {
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("sliderTapModifier");
                $this$null.getProperties().set("draggableState", draggableState);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("maxPx", Integer.valueOf(maxPx));
                $this$null.getProperties().set("isRtl", Boolean.valueOf(isRtl));
                $this$null.getProperties().set("rawOffset", state);
                $this$null.getProperties().set("gestureEndAction", state2);
                $this$null.getProperties().set("pressOffset", mutableState);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Modifier modifierPointerInput;
                Object value$iv$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(2040469710);
                ComposerKt.sourceInformation($composer, "C1173@48923L24:Slider.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2040469710, $changed, -1, "androidx.compose.material3.sliderTapModifier.<anonymous> (Slider.kt:1171)");
                }
                if (enabled) {
                    $composer.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                        $composer.updateRememberedValue(value$iv$iv$iv);
                    } else {
                        value$iv$iv$iv = it$iv$iv$iv;
                    }
                    $composer.endReplaceableGroup();
                    CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                    CoroutineScope scope = wrapper$iv.getCoroutineScope();
                    $composer.endReplaceableGroup();
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, interactionSource, Integer.valueOf(maxPx), Boolean.valueOf(isRtl)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(isRtl, maxPx, mutableState, state, scope, draggableState, state2, null));
                } else {
                    modifierPointerInput = composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifierPointerInput;
            }

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", i = {}, l = {1176}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ int $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(boolean z, int i, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function0<Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = i;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                    this.$scope = coroutineScope;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", i = {}, l = {1181}, m = "invokeSuspend", n = {}, s = {})
                static final class C00911 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ int $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00911(boolean z, int i, MutableState<Float> mutableState, State<Float> state, Continuation<? super C00911> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = i;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m1703invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m1703invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        C00911 c00911 = new C00911(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        c00911.L$0 = pressGestureScope;
                        c00911.J$0 = j;
                        return c00911.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        C00911 c00911;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                PressGestureScope $this$detectTapGestures = (PressGestureScope) this.L$0;
                                long pos = this.J$0;
                                float to = this.$isRtl ? this.$maxPx - Offset.m2708getXimpl(pos) : Offset.m2708getXimpl(pos);
                                this.$pressOffset.setValue(Boxing.boxFloat(to - this.$rawOffset.getValue().floatValue()));
                                try {
                                    this.label = 1;
                                    break;
                                } catch (GestureCancellationException e) {
                                    c00911 = this;
                                    c00911.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                }
                                if ($this$detectTapGestures.awaitRelease(this) != coroutine_suspended) {
                                    return Unit.INSTANCE;
                                }
                                return coroutine_suspended;
                            case 1:
                                c00911 = this;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    break;
                                } catch (GestureCancellationException e2) {
                                    c00911.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                }
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            C00911 c00911 = new C00911(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                            final CoroutineScope coroutineScope = this.$scope;
                            final DraggableState draggableState = this.$draggableState;
                            final State<Function0<Unit>> state = this.$gestureEndAction;
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1704invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1704invokek4lQ0M(long it) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00931(draggableState, state, null), 3, null);
                                }

                                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: Slider.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", i = {}, l = {1188}, m = "invokeSuspend", n = {}, s = {})
                                static final class C00931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DraggableState $draggableState;
                                    final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    C00931(DraggableState draggableState, State<? extends Function0<Unit>> state, Continuation<? super C00931> continuation) {
                                        super(2, continuation);
                                        this.$draggableState = draggableState;
                                        this.$gestureEndAction = state;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00931(this.$draggableState, this.$gestureEndAction, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                    /* JADX INFO: compiled from: Slider.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    static final class C00941 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                        private /* synthetic */ Object L$0;
                                        int label;

                                        C00941(Continuation<? super C00941> continuation) {
                                            super(2, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            C00941 c00941 = new C00941(continuation);
                                            c00941.L$0 = obj;
                                            return c00941;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                                            return ((C00941) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure(obj);
                                                    DragScope $this$drag = (DragScope) this.L$0;
                                                    $this$drag.dragBy(0.0f);
                                                    return Unit.INSTANCE;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        C00931 c00931;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$draggableState.drag(MutatePriority.UserInput, new C00941(null), this) != coroutine_suspended) {
                                                    c00931 = this;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                c00931 = this;
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        c00931.$gestureEndAction.getValue().invoke();
                                        return Unit.INSTANCE;
                                    }
                                }
                            };
                            this.label = 1;
                            if (TapGestureDetectorKt.detectTapGestures($this$pointerInput, (3 & 1) != 0 ? null : null, (3 & 2) != 0 ? null : null, (3 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : c00911, (3 & 8) != 0 ? null : function1, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$animateToTarget$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {1221}, m = "invokeSuspend", n = {}, s = {})
    static final class C04162 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04162(float f, float f2, float f3, Continuation<? super C04162> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04162 c04162 = new C04162(this.$current, this.$target, this.$velocity, continuation);
            c04162.L$0 = obj;
            return c04162;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((C04162) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final DragScope $this$drag = (DragScope) this.L$0;
                    final Ref.FloatRef latestValue = new Ref.FloatRef();
                    latestValue.element = this.$current;
                    this.label = 1;
                    if (AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null).animateTo(Boxing.boxFloat(this.$target), SliderKt.SliderToTickAnimation, Boxing.boxFloat(this.$velocity), new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.SliderKt.animateToTarget.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                            invoke2(animatable);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<Float, AnimationVector1D> animateTo) {
                            Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                            $this$drag.dragBy(animateTo.getValue().floatValue() - latestValue.element);
                            latestValue.element = animateTo.getValue().floatValue();
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new C04162(current, target, velocity, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", i = {}, l = {1249}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ int $maxPx;
        final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, int i, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z;
            this.$maxPx = i;
            this.$gestureEndAction = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new C00881($this$pointerInput, this.$isRtl, this.$maxPx, rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {1250}, m = "invokeSuspend", n = {}, s = {})
        static final class C00881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ int $maxPx;
            final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00881(PointerInputScope pointerInputScope, boolean z, int i, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00881> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z;
                this.$maxPx = i;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00881 c00881 = new C00881(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                c00881.L$0 = obj;
                return c00881;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {1251, 1261, 1280}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
            static final class C00891 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ int $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00891(boolean z, int i, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00891> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = i;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = coroutineScope;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00891 c00891 = new C00891(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c00891.L$0 = obj;
                    return c00891;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00891) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00ea A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00f3  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x019b A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:59:0x019c  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x01ac A[Catch: CancellationException -> 0x01bd, TryCatch #1 {CancellationException -> 0x01bd, blocks: (B:60:0x01a3, B:62:0x01ac, B:63:0x01b4), top: B:75:0x01a3 }] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x01b4 A[Catch: CancellationException -> 0x01bd, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x01bd, blocks: (B:60:0x01a3, B:62:0x01ac, B:63:0x01b4), top: B:75:0x01a3 }] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                    /*
                        Method dump skipped, instruction units count: 512
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.AnonymousClass1.C00881.C00891.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {1297}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Ref.BooleanRef $draggingStart;
                    final /* synthetic */ DragInteraction $finishInteraction;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$draggingStart = booleanRef;
                        this.$finishInteraction = dragInteraction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C00891(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, $this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> state, State<Float> state2, boolean enabled, boolean isRtl, int maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Integer.valueOf(maxPx), Boolean.valueOf(isRtl), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(startInteractionSource, endInteractionSource, state, state2, state4, isRtl, maxPx, state3, null));
        }
        return $this$rangeSliderPressDragModifier;
    }

    static {
        float fM2433getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m2433getHandleWidthD9Ej5fM();
        ThumbWidth = fM2433getHandleWidthD9Ej5fM;
        float fM2432getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m2432getHandleHeightD9Ej5fM();
        ThumbHeight = fM2432getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m5234DpSizeYgX7TsA(fM2433getHandleWidthD9Ej5fM, fM2432getHandleHeightD9Ej5fM);
        ThumbDefaultElevation = Dp.m5212constructorimpl(1);
        ThumbPressedElevation = Dp.m5212constructorimpl(6);
        TickSize = SliderTokens.INSTANCE.m2439getTickMarksContainerSizeD9Ej5fM();
        TrackHeight = SliderTokens.INSTANCE.m2434getInactiveTrackHeightD9Ej5fM();
        float fM5212constructorimpl = Dp.m5212constructorimpl(48);
        SliderHeight = fM5212constructorimpl;
        float fM5212constructorimpl2 = Dp.m5212constructorimpl(144);
        SliderMinWidth = fM5212constructorimpl2;
        DefaultSliderConstraints = SizeKt.m516heightInVpY3zN4$default(SizeKt.m535widthInVpY3zN4$default(Modifier.INSTANCE, fM5212constructorimpl2, 0.0f, 2, null), 0.0f, fM5212constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
