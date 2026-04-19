package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a:\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u00104\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a=\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010@\u001a;\u0010A\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ae\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00190I2\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a=\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001aQ\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020:2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010%\u001a\u00020&2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00190I¢\u0006\u0002\b\u001f¢\u0006\u0002\bZH\u0003¢\u0006\u0002\u0010[\u001a\u001d\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010]\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u0010^\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002\u001a(\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002\u001a-\u0010g\u001a\u00020h2\u0006\u0010J\u001a\u00020K2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0007H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a+\u0010m\u001a\u00020$2\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010i\u001a\u00020*H\u0007¢\u0006\u0002\u0010p\u001a`\u0010q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020G2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00190IH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a$\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0z2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u001c\u0010~\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0015\u0010\u007f\u001a\u00020h*\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\u0081\u0001\u001a\u00020\u001b*\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020*H\u0003\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\f\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\r\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000f\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0010\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0017\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0082\u0001"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "", "", "FullCircle", "", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "Landroidx/compose/material3/TimePickerState;", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/material3/TimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/Selection;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-lxUZ_iY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-uXwN82Y", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "is24Hour", "number", "numberContentDescription-YKJpE6Y", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "initialHour", "initialMinute", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "timeInputOnChange-gIWD5Rc", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "valuesForAnimation", "Lkotlin/Pair;", "current", "new", "clockDial", "drawSelector", "toLocalString", "minDigits", "visible", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimePickerKt {
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final List<Integer> Hours;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimeInputBottomPadding;
    private static final float OuterCircleSizeRadius = Dp.m4873constructorimpl(101);
    private static final float InnerCircleRadius = Dp.m4873constructorimpl(69);
    private static final float ClockDisplayBottomMargin = Dp.m4873constructorimpl(36);
    private static final float SupportLabelTop = Dp.m4873constructorimpl(7);
    private static final float MaxDistance = Dp.m4873constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m4873constructorimpl(48);
    private static final List<Integer> Minutes = CollectionsKt.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55});

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1567TimePickermT9BvqQ(final androidx.compose.material3.TimePickerState r42, androidx.compose.ui.Modifier r43, androidx.compose.material3.TimePickerColors r44, int r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m1567TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TimeInput(final androidx.compose.material3.TimePickerState r39, androidx.compose.ui.Modifier r40, androidx.compose.material3.TimePickerColors r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(final int i, final int i2, final boolean z, Composer composer, int i3, int i4) {
        composer.startReplaceableGroup(1237715277);
        ComposerKt.sourceInformation(composer, "C(rememberTimePickerState)441@21331L14,444@21424L133,442@21368L189:TimePicker.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = TimeFormat_androidKt.is24HourFormat(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i3, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:438)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerState, ?> Saver = TimePickerState.INSTANCE.Saver();
        Integer numValueOf = Integer.valueOf(i);
        Integer numValueOf2 = Integer.valueOf(i2);
        Boolean boolValueOf = Boolean.valueOf(z);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(numValueOf) | composer.changed(numValueOf2) | composer.changed(boolValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<TimePickerState>() { // from class: androidx.compose.material3.TimePickerKt$rememberTimePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TimePickerState invoke() {
                    return new TimePickerState(i, i2, z);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.m2276rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return timePickerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VerticalTimePicker(final androidx.compose.material3.TimePickerState r40, androidx.compose.ui.Modifier r41, androidx.compose.material3.TimePickerColors r42, final boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void HorizontalTimePicker(final androidx.compose.material3.TimePickerState r40, androidx.compose.ui.Modifier r41, androidx.compose.material3.TimePickerColors r42, final boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeInputImpl(final Modifier modifier, final TimePickerColors timePickerColors, final TimePickerState timePickerState, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeInputImpl)P(1)698@29965L92,698@29913L144,701@30133L84,701@30081L136,705@30223L3592:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        final int i3 = i2;
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i3, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:693)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(TimePickerKt.toLocalString(timePickerState.getHourForDisplay$material3_release(), 2), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 72, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.INSTANCE.getSaver();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(TimePickerKt.toLocalString(timePickerState.getMinute(), 2), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState mutableStateRememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 72, 4);
            composer2 = composerStartRestartGroup;
            Modifier modifierM484paddingqDBjuR0$default = PaddingKt.m484paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composer2);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composer2.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1230444741, "C709@30386L10,715@30597L2787:TimePicker.kt#uh7d8r");
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont());
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(textStyleFromToken.m4418copyCXVQc50((3653631 & 1) != 0 ? textStyleFromToken.spanStyle.m4363getColor0d7_KjU() : timePickerColors.m1563timeSelectorContentColorvNxB06k$material3_release(true), (3653631 & 2) != 0 ? textStyleFromToken.spanStyle.getFontSize() : 0L, (3653631 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (3653631 & 8) != 0 ? textStyleFromToken.spanStyle.getFontStyle() : null, (3653631 & 16) != 0 ? textStyleFromToken.spanStyle.getFontSynthesis() : null, (3653631 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (3653631 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (3653631 & 128) != 0 ? textStyleFromToken.spanStyle.getLetterSpacing() : 0L, (3653631 & 256) != 0 ? textStyleFromToken.spanStyle.getBaselineShift() : null, (3653631 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (3653631 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (3653631 & 2048) != 0 ? textStyleFromToken.spanStyle.getBackground() : 0L, (3653631 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (3653631 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (3653631 & 16384) != 0 ? textStyleFromToken.paragraphStyle.getTextAlign() : TextAlign.m4760boximpl(TextAlign.INSTANCE.m4767getCentere0LSkKk()), (3653631 & 32768) != 0 ? textStyleFromToken.paragraphStyle.getTextDirection() : null, (3653631 & 65536) != 0 ? textStyleFromToken.paragraphStyle.getLineHeight() : 0L, (3653631 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (3653631 & 262144) != 0 ? textStyleFromToken.platformStyle : null, (3653631 & 524288) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (3653631 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.getLineBreak() : null, (3653631 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.getHyphens() : null))}, ComposableLambdaKt.composableLambda(composer2, 1306700887, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C719@30761L411,731@31241L353,746@31903L38,717@30672L1318,749@32003L85,752@32197L376,765@32645L331,780@33287L38,750@32101L1273:TimePicker.kt#uh7d8r");
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1306700887, i4, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:715)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        final MutableState<TextFieldValue> mutableState = mutableStateRememberSaveable;
                        final TimePickerState timePickerState2 = timePickerState;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged3 = composer3.changed(mutableState) | composer3.changed(timePickerState2);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m1576invokeZmokQxo(keyEvent.m3604unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m1576invokeZmokQxo(android.view.KeyEvent event) {
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    int iM3617getUtf16CodePointZmokQxo = KeyEvent_androidKt.m3617getUtf16CodePointZmokQxo(event);
                                    if (48 <= iM3617getUtf16CodePointZmokQxo && iM3617getUtf16CodePointZmokQxo < 58 && TextRange.m4404getStartimpl(TimePickerKt.TimeInputImpl$lambda$5(mutableState).getSelection()) == 2 && TimePickerKt.TimeInputImpl$lambda$5(mutableState).getText().length() == 2) {
                                        timePickerState2.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1380getMinuteJiIwxys());
                                    }
                                    return false;
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) objRememberedValue3);
                        TextFieldValue textFieldValueTimeInputImpl$lambda$5 = TimePickerKt.TimeInputImpl$lambda$5(mutableStateRememberSaveable);
                        final TimePickerState timePickerState3 = timePickerState;
                        final MutableState<TextFieldValue> mutableState2 = mutableStateRememberSaveable;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged4 = composer3.changed(timePickerState3) | composer3.changed(mutableState2);
                        Object objRememberedValue4 = composer3.rememberedValue();
                        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                                    int iM1379getHourJiIwxys = Selection.INSTANCE.m1379getHourJiIwxys();
                                    TimePickerState timePickerState4 = timePickerState3;
                                    TextFieldValue textFieldValueTimeInputImpl$lambda$52 = TimePickerKt.TimeInputImpl$lambda$5(mutableState2);
                                    int i5 = timePickerState3.getIs24hour() ? 23 : 12;
                                    final MutableState<TextFieldValue> mutableState3 = mutableState2;
                                    TimePickerKt.m1575timeInputOnChangegIWD5Rc(iM1379getHourJiIwxys, timePickerState4, newValue, textFieldValueTimeInputImpl$lambda$52, i5, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState3.setValue(it);
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        Function1 function1 = (Function1) objRememberedValue4;
                        TimePickerState timePickerState4 = timePickerState;
                        int iM1379getHourJiIwxys = Selection.INSTANCE.m1379getHourJiIwxys();
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m4612getNumberPjHm6EE(), ImeAction.INSTANCE.m4566getNexteUduSuo(), 3, null);
                        final TimePickerState timePickerState5 = timePickerState;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean zChanged5 = composer3.changed(timePickerState5);
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                    invoke2(keyboardActionScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    timePickerState5.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1380getMinuteJiIwxys());
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        KeyboardActions keyboardActions = new KeyboardActions(null, null, (Function1) objRememberedValue5, null, null, null, 59, null);
                        TimePickerColors timePickerColors2 = timePickerColors;
                        int i5 = i3;
                        TimePickerKt.m1568TimePickerTextFieldlxUZ_iY(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$5, function1, timePickerState4, iM1379getHourJiIwxys, keyboardOptions, keyboardActions, timePickerColors2, composer3, ((i5 << 3) & 7168) | 24576 | ((i5 << 18) & 29360128), 0);
                        TimePickerKt.DisplaySeparator(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m2154getPeriodSelectorContainerHeightD9Ej5fM()), composer3, 6);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        final MutableState<TextFieldValue> mutableState3 = mutableStateRememberSaveable2;
                        final TimePickerState timePickerState6 = timePickerState;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged6 = composer3.changed(mutableState3) | composer3.changed(timePickerState6);
                        Object objRememberedValue6 = composer3.rememberedValue();
                        if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m1577invokeZmokQxo(keyEvent.m3604unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m1577invokeZmokQxo(android.view.KeyEvent event) {
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    boolean z = KeyEvent_androidKt.m3617getUtf16CodePointZmokQxo(event) == 0 && TextRange.m4404getStartimpl(TimePickerKt.TimeInputImpl$lambda$8(mutableState3).getSelection()) == 0;
                                    if (z) {
                                        timePickerState6.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1379getHourJiIwxys());
                                    }
                                    return Boolean.valueOf(z);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion2, (Function1) objRememberedValue6);
                        TextFieldValue textFieldValueTimeInputImpl$lambda$8 = TimePickerKt.TimeInputImpl$lambda$8(mutableStateRememberSaveable2);
                        final TimePickerState timePickerState7 = timePickerState;
                        final MutableState<TextFieldValue> mutableState4 = mutableStateRememberSaveable2;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged7 = composer3.changed(timePickerState7) | composer3.changed(mutableState4);
                        Object objRememberedValue7 = composer3.rememberedValue();
                        if (zChanged7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                                    int iM1380getMinuteJiIwxys = Selection.INSTANCE.m1380getMinuteJiIwxys();
                                    TimePickerState timePickerState8 = timePickerState7;
                                    TextFieldValue textFieldValueTimeInputImpl$lambda$82 = TimePickerKt.TimeInputImpl$lambda$8(mutableState4);
                                    final MutableState<TextFieldValue> mutableState5 = mutableState4;
                                    TimePickerKt.m1575timeInputOnChangegIWD5Rc(iM1380getMinuteJiIwxys, timePickerState8, newValue, textFieldValueTimeInputImpl$lambda$82, 59, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState5.setValue(it);
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        Function1 function12 = (Function1) objRememberedValue7;
                        TimePickerState timePickerState8 = timePickerState;
                        int iM1380getMinuteJiIwxys = Selection.INSTANCE.m1380getMinuteJiIwxys();
                        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m4612getNumberPjHm6EE(), ImeAction.INSTANCE.m4564getDoneeUduSuo(), 3, null);
                        final TimePickerState timePickerState9 = timePickerState;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean zChanged8 = composer3.changed(timePickerState9);
                        Object objRememberedValue8 = composer3.rememberedValue();
                        if (zChanged8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                    invoke2(keyboardActionScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    timePickerState9.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1380getMinuteJiIwxys());
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue8);
                        }
                        composer3.endReplaceableGroup();
                        KeyboardActions keyboardActions2 = new KeyboardActions(null, null, (Function1) objRememberedValue8, null, null, null, 59, null);
                        TimePickerColors timePickerColors3 = timePickerColors;
                        int i6 = i3;
                        TimePickerKt.m1568TimePickerTextFieldlxUZ_iY(modifierOnPreviewKeyEvent, textFieldValueTimeInputImpl$lambda$8, function12, timePickerState8, iM1380getMinuteJiIwxys, keyboardOptions2, keyboardActions2, timePickerColors3, composer3, ((i6 << 3) & 7168) | 24576 | ((i6 << 18) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 56);
            composer2.startReplaceableGroup(565119480);
            ComposerKt.sourceInformation(composer2, "786@33429L370");
            if (!timePickerState.getIs24hour()) {
                Modifier modifierM484paddingqDBjuR0$default2 = PaddingKt.m484paddingqDBjuR0$default(modifier, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composer2.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density2 = (Density) objConsume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composer2.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2263constructorimpl2 = Updater.m2263constructorimpl(composer2);
                Updater.m2270setimpl(composerM2263constructorimpl2, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2270setimpl(composerM2263constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2270setimpl(composerM2263constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1645137119, "C787@33497L288:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m2155getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m2154getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composer2, ((i3 >> 3) & 112) | 6 | ((i3 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.TimeInputImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                TimePickerKt.TimeInputImpl(modifier, timePickerColors, timePickerState, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalClockDisplay)P(1)802@33922L554:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:801)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -385990141, "C803@33981L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, (i2 & 14) | (i2 & 112));
            composerStartRestartGroup.startReplaceableGroup(-552398963);
            ComposerKt.sourceInformation(composerStartRestartGroup, "805@34059L401");
            if (!timePickerState.getIs24hour()) {
                Modifier modifierM484paddingqDBjuR0$default = PaddingKt.m484paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 34966463, "C806@34136L310:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m2166getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2165getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalClockDisplay.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                TimePickerKt.HorizontalClockDisplay(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalClockDisplay)P(1)821@34581L549:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:820)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1085478083, "C822@34639L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, (i2 & 14) | (i2 & 112));
            composerStartRestartGroup.startReplaceableGroup(952907597);
            ComposerKt.sourceInformation(composerStartRestartGroup, "824@34717L397");
            if (!timePickerState.getIs24hour()) {
                Modifier modifierM484paddingqDBjuR0$default = PaddingKt.m484paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1130526335, "C825@34796L304:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m2169getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2168getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalClockDisplay.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                TimePickerKt.VerticalClockDisplay(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockDisplayNumbers(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        final int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockDisplayNumbers)P(1)844@35316L10,843@35244L1047:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:839)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont()))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C846@35380L905:TimePicker.kt#uh7d8r");
                    if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-477913269, i3, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:845)");
                        }
                        TimePickerState timePickerState2 = timePickerState;
                        TimePickerColors timePickerColors2 = timePickerColors;
                        int i4 = i2;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composer2);
                        Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 94464085, "C847@35398L338,857@35749L181,863@35943L332:TimePicker.kt#uh7d8r");
                        int i5 = ((i4 << 9) & 57344) | ((i4 << 6) & 896) | 3078;
                        TimePickerKt.m1569TimeSelectoruXwN82Y(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m2172getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2171getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getHourForDisplay$material3_release(), timePickerState2, Selection.INSTANCE.m1379getHourJiIwxys(), timePickerColors2, composer2, i5);
                        TimePickerKt.DisplaySeparator(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m2168getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer2, 6);
                        TimePickerKt.m1569TimeSelectoruXwN82Y(SizeKt.m529sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m2172getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2171getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getMinute(), timePickerState2, Selection.INSTANCE.m1380getMinuteJiIwxys(), timePickerColors2, composer2, i5);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 56);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ClockDisplayNumbers(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPeriodToggle)P(1,2)883@36453L904,908@37404L9,910@37439L206:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:878)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo11measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        List<? extends Measurable> list = measurables;
                        for (Measurable measurable : list) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j, 0, MathKt.roundToInt(MeasurePolicy.mo325toPx0680j_4(TimePickerTokens.INSTANCE.m2167getPeriodSelectorOutlineWidthD9Ej5fM())), 0, 0, 12, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list) {
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    arrayList3.add(((Measurable) it.next()).mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j, 0, Constraints.m4829getMaxWidthimpl(j) / 2, 0, 0, 12, null)));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                return MeasureScope.layout$default(MeasurePolicy, Constraints.m4829getMaxWidthimpl(j), Constraints.m4828getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1
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
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(1), arrayList4.get(0).getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, placeableMo3866measureBRTryo0, arrayList4.get(0).getWidth() - (placeableMo3866measureBRTryo0.getWidth() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue;
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalPeriodToggle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.HorizontalPeriodToggle(modifier, timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalPeriodToggle(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalPeriodToggle)P(1,2)926@37805L911,951@38763L9,953@38798L207:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:921)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo11measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        List<? extends Measurable> list = measurables;
                        for (Measurable measurable : list) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable placeableMo3866measureBRTryo0 = measurable.mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, MathKt.roundToInt(MeasurePolicy.mo325toPx0680j_4(TimePickerTokens.INSTANCE.m2167getPeriodSelectorOutlineWidthD9Ej5fM())), 3, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list) {
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    arrayList3.add(((Measurable) it.next()).mo3866measureBRTryo0(Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, Constraints.m4828getMaxHeightimpl(j) / 2, 3, null)));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                return MeasureScope.layout$default(MeasurePolicy, Constraints.m4829getMaxWidthimpl(j), Constraints.m4828getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$measure$1
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
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(1), 0, arrayList4.get(0).getHeight(), 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, placeableMo3866measureBRTryo0, 0, arrayList4.get(0).getHeight() - (placeableMo3866measureBRTryo0.getHeight() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue;
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalPeriodToggle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.VerticalPeriodToggle(modifier, timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1374241901);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PeriodToggleImpl)P(3,5!1,2,4)977@39398L9,978@39457L41,981@39562L111,979@39503L1257:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:964)");
            }
            BorderStroke borderStrokeM186BorderStrokecXLIe8U = BorderStrokeKt.m186BorderStrokecXLIe8U(TimePickerTokens.INSTANCE.m2167getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.getPeriodSelectorBorderColor());
            Shape shape3 = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(shape3, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape3;
            final String strM1465getStringNWtq28 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1462getTimePickerPeriodToggleadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM1465getStringNWtq28);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        SemanticsPropertiesKt.setContainer(semantics, true);
                        SemanticsPropertiesKt.setContentDescription(semantics, strM1465getStringNWtq28);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null)).then(modifier), borderStrokeM186BorderStrokecXLIe8U, cornerBasedShape);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierBorder);
            int i3 = ((((i2 >> 3) & 896) << 9) & 7168) | 6;
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
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1654470848, "C993@39989L71,990@39863L303,1003@40399L9,998@40179L244,1009@40575L70,1005@40436L308:TimePicker.kt#uh7d8r");
            boolean z = !timePickerState.isAfternoonToggle$material3_release();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
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
                        timePickerState.setAfternoonToggle$material3_release(false);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i4 = (i2 << 3) & 7168;
            ToggleItem(z, shape, (Function0) objRememberedValue2, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.m1129getLambda1$material3_release(), composerStartRestartGroup, ((i2 >> 9) & 112) | 24576 | i4);
            SpacerKt.Spacer(BackgroundKt.m159backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.INSTANCE, "Spacer"), SeparatorZIndex), 0.0f, 1, null), ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor(), composerStartRestartGroup, 6), null, 2, null), composerStartRestartGroup, 0);
            boolean zIsAfternoonToggle$material3_release = timePickerState.isAfternoonToggle$material3_release();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
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
                        timePickerState.setAfternoonToggle$material3_release(true);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ToggleItem(zIsAfternoonToggle$material3_release, shape2, (Function0) objRememberedValue3, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.m1130getLambda2$material3_release(), composerStartRestartGroup, ((i2 >> 12) & 112) | 24576 | i4);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.PeriodToggleImpl.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                TimePickerKt.PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ToggleItem(final boolean z, final Shape shape, final Function0<Unit> function0, final TimePickerColors timePickerColors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleItem)P(!1,4,3)1033@41221L22,1038@41400L112,1029@41086L432:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((46811 & i2) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1019)");
            }
            long jM1561periodSelectorContentColorvNxB06k$material3_release = timePickerColors.m1561periodSelectorContentColorvNxB06k$material3_release(z);
            long jM1560periodSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1560periodSelectorContainerColorvNxB06k$material3_release(z);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, z ? 0.0f : 1.0f), 0.0f, 1, null);
            Boolean boolValueOf = Boolean.valueOf(z);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        SemanticsPropertiesKt.setSelected(semantics, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) objRememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m1013textButtonColorsro_MJ88(jM1560periodSelectorContainerColorvNxB06k$material3_release, jM1561periodSelectorContentColorvNxB06k$material3_release, 0L, 0L, composerStartRestartGroup, 24576, 12), null, null, PaddingKt.m473PaddingValues0680j_4(Dp.m4873constructorimpl(0)), null, function3, composerStartRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ToggleItem.2
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

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ToggleItem(z, shape, function0, timePickerColors, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisplaySeparator(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplaySeparator)1048@41655L7,1056@41916L245:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1046)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextStyle textStyle = (TextStyle) objConsume;
            TextStyle textStyleCopyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(textStyle.m4418copyCXVQc50((3653631 & 1) != 0 ? textStyle.spanStyle.m4363getColor0d7_KjU() : 0L, (3653631 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (3653631 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (3653631 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (3653631 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (3653631 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (3653631 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (3653631 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (3653631 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (3653631 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (3653631 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (3653631 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (3653631 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (3653631 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (3653631 & 16384) != 0 ? textStyle.paragraphStyle.getTextAlign() : TextAlign.m4760boximpl(TextAlign.INSTANCE.m4767getCentere0LSkKk()), (3653631 & 32768) != 0 ? textStyle.paragraphStyle.getTextDirection() : null, (3653631 & 65536) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (3653631 & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (3653631 & 262144) != 0 ? textStyle.platformStyle : null, (3653631 & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m4744getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m4756getBothEVpEnUU(), null), (3653631 & 1048576) != 0 ? textStyle.paragraphStyle.getLineBreak() : null, (3653631 & 2097152) != 0 ? textStyle.paragraphStyle.getHyphens() : null), false);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.1
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
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierClearAndSetSemantics);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -617594898, "C1062@42109L9,1060@42035L120:TimePicker.kt#uh7d8r");
            composer2 = composerStartRestartGroup;
            TextKt.m1552Text4IGK_g(":", (Modifier) null, ColorSchemeKt.toColor(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composerStartRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyleCopyAndSetFontPadding, composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i3) {
                TimePickerKt.DisplaySeparator(modifier, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TimeSelector-uXwN82Y, reason: not valid java name */
    public static final void m1569TimeSelectoruXwN82Y(final Modifier modifier, final int i, final TimePickerState timePickerState, final int i2, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        int iM1458getTimePickerMinuteSelectionadMyvUU;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(21099367);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeSelector)P(1,4,3,2:c#material3.Selection)1078@42456L176,1088@42784L24,1091@42898L124,1104@43327L9,1089@42813L1060:TimePicker.kt#uh7d8r");
        if ((i3 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        final int i5 = i4;
        if ((46811 & i5) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21099367, i5, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1070)");
            }
            boolean zM1375equalsimpl0 = Selection.m1375equalsimpl0(timePickerState.m1592getSelectionJiIwxys$material3_release(), i2);
            if (Selection.m1375equalsimpl0(i2, Selection.INSTANCE.m1379getHourJiIwxys())) {
                iM1458getTimePickerMinuteSelectionadMyvUU = Strings.INSTANCE.m1454getTimePickerHourSelectionadMyvUU();
            } else {
                iM1458getTimePickerMinuteSelectionadMyvUU = Strings.INSTANCE.m1458getTimePickerMinuteSelectionadMyvUU();
            }
            final String strM1465getStringNWtq28 = Strings_androidKt.m1465getStringNWtq28(iM1458getTimePickerMinuteSelectionadMyvUU, composerStartRestartGroup, 0);
            long jM1562timeSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1562timeSelectorContainerColorvNxB06k$material3_release(zM1375equalsimpl0);
            final long jM1563timeSelectorContentColorvNxB06k$material3_release = timePickerColors.m1563timeSelectorContentColorvNxB06k$material3_release(zM1375equalsimpl0);
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM1465getStringNWtq28);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        SemanticsPropertiesKt.m4260setRolekuIjeqM(semantics, Role.INSTANCE.m4250getRadioButtono7Vup1c());
                        SemanticsPropertiesKt.setContentDescription(semantics, strM1465getStringNWtq28);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1475Surfaced85dljk(zM1375equalsimpl0, new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2
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
                    if (Selection.m1375equalsimpl0(i2, timePickerState.m1592getSelectionJiIwxys$material3_release())) {
                        return;
                    }
                    timePickerState.m1595setSelectioniHAOin8$material3_release(i2);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(timePickerState, null), 3, null);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeSelector$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: TimePicker.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$TimeSelector$2$1", f = "TimePicker.kt", i = {}, l = {1100}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ TimePickerState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TimePickerState timePickerState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$state = timePickerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$state.animateToCurrent$material3_release(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue2), false, ShapesKt.toShape(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), composerStartRestartGroup, 6), jM1562timeSelectorContainerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1338709103, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C1108@43428L152,1114@43590L277:TimePicker.kt#uh7d8r");
                    if ((i6 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1338709103, i6, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1106)");
                        }
                        int i7 = i2;
                        boolean is24hour = timePickerState.getIs24hour();
                        int i8 = i;
                        int i9 = i5;
                        final String strM1574numberContentDescriptionYKJpE6Y = TimePickerKt.m1574numberContentDescriptionYKJpE6Y(i7, is24hour, i8, composer3, ((i9 << 3) & 896) | ((i9 >> 9) & 14));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        int i10 = i;
                        long j = jM1563timeSelectorContentColorvNxB06k$material3_release;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume = composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Density density = (Density) objConsume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composer3);
                        Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer3.enableReusing();
                        function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 992575728, "C1116@43697L48,1115@43645L212:TimePicker.kt#uh7d8r");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean zChanged2 = composer3.changed(strM1574numberContentDescriptionYKJpE6Y);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, strM1574numberContentDescriptionYKJpE6Y);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.m1552Text4IGK_g(TimePickerKt.toLocalString(i10, 2), SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue3, 1, null), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131064);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i6) {
                TimePickerKt.m1569TimeSelectoruXwN82Y(modifier, i, timePickerState, i2, timePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
            }
        });
    }

    public static final void ClockFace(final TimePickerState state, final TimePickerColors colors, final boolean z, Composer composer, final int i) {
        final int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1525091100);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockFace)P(2,1)1130@44011L1899:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1125)");
            }
            CrossfadeKt.Crossfade(state.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m527size3ABfNKs(BackgroundKt.m158backgroundbw27NRU(Modifier.INSTANCE, colors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m2160getClockDialContainerSizeD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContainer(semantics, false);
                    SemanticsPropertiesKt.selectableGroup(semantics);
                }
            }, 1, null), AnimationSpecKt.tween$default(350, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1628166511, true, new Function3<List<? extends Integer>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list, Composer composer2, Integer num) {
                    invoke((List<Integer>) list, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final List<Integer> screen, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(screen, "screen");
                    ComposerKt.sourceInformation(composer2, "C1141@44425L1479:TimePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1628166511, i3, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1140)");
                    }
                    Modifier modifierDrawSelector = TimePickerKt.drawSelector(SizeKt.m527size3ABfNKs(TimePickerKt.clockDial(Modifier.INSTANCE, state, z), TimePickerTokens.INSTANCE.m2160getClockDialContainerSizeD9Ej5fM()), state, colors);
                    float f = TimePickerKt.OuterCircleSizeRadius;
                    final TimePickerColors timePickerColors = colors;
                    final TimePickerState timePickerState = state;
                    final boolean z2 = z;
                    final int i4 = i2;
                    TimePickerKt.m1566CircularLayoutuFdPcIQ(modifierDrawSelector, f, ComposableLambdaKt.composableLambda(composer2, -1385633737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C1148@44687L1207:TimePicker.kt#uh7d8r");
                            if ((i5 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1385633737, i5, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1147)");
                                }
                                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2619boximpl(timePickerColors.m1555clockDialContentColorvNxB06k$material3_release(false)))};
                                final List<Integer> list = screen;
                                final TimePickerState timePickerState2 = timePickerState;
                                final boolean z3 = z2;
                                final int i6 = i4;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -2018362505, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i7) {
                                        int iIntValue;
                                        ComposerKt.sourceInformation(composer4, "C1161@45270L592:TimePicker.kt#uh7d8r");
                                        if ((i7 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2018362505, i7, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1150)");
                                            }
                                            composer4.startReplaceableGroup(-504302349);
                                            ComposerKt.sourceInformation(composer4, "*1157@45091L64");
                                            int size = list.size();
                                            TimePickerState timePickerState3 = timePickerState2;
                                            List<Integer> list2 = list;
                                            boolean z4 = z3;
                                            int i8 = i6;
                                            for (int i9 = 0; i9 < size; i9++) {
                                                if (!timePickerState3.getIs24hour() || Selection.m1375equalsimpl0(timePickerState3.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1380getMinuteJiIwxys())) {
                                                    iIntValue = list2.get(i9).intValue();
                                                } else {
                                                    iIntValue = list2.get(i9).intValue() % 12;
                                                }
                                                TimePickerKt.ClockText(timePickerState3, iIntValue, z4, composer4, (i8 & 14) | (i8 & 896));
                                            }
                                            composer4.endReplaceableGroup();
                                            if (Selection.m1375equalsimpl0(timePickerState2.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1379getHourJiIwxys()) && timePickerState2.getIs24hour()) {
                                                Modifier modifierM158backgroundbw27NRU = BackgroundKt.m158backgroundbw27NRU(SizeKt.m527size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m2160getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m2664getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                                float f2 = TimePickerKt.InnerCircleRadius;
                                                final TimePickerState timePickerState4 = timePickerState2;
                                                final boolean z5 = z3;
                                                final int i10 = i6;
                                                TimePickerKt.m1566CircularLayoutuFdPcIQ(modifierM158backgroundbw27NRU, f2, ComposableLambdaKt.composableLambda(composer4, -448649404, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i11) {
                                                        ComposerKt.sourceInformation(composer5, "C*1170@45750L64:TimePicker.kt#uh7d8r");
                                                        if ((i11 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-448649404, i11, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1167)");
                                                            }
                                                            int size2 = TimePickerKt.ExtraHours.size();
                                                            TimePickerState timePickerState5 = timePickerState4;
                                                            boolean z6 = z5;
                                                            int i12 = i10;
                                                            for (int i13 = 0; i13 < size2; i13++) {
                                                                TimePickerKt.ClockText(timePickerState5, ((Number) TimePickerKt.ExtraHours.get(i13)).intValue(), z6, composer5, (i12 & 14) | (i12 & 896));
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 432, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 432, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 24584, 8);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ClockFace(state, colors, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier drawSelector(Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt.drawSelector.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                long jOffset = OffsetKt.Offset(drawWithContent.mo325toPx0680j_4(DpOffset.m4934getXD9Ej5fM(timePickerState.m1593getSelectorPosRKDOV3M$material3_release())), drawWithContent.mo325toPx0680j_4(DpOffset.m4936getYD9Ej5fM(timePickerState.m1593getSelectorPosRKDOV3M$material3_release())));
                float f = 2;
                float f2 = drawWithContent.mo325toPx0680j_4(TimePickerTokens.INSTANCE.m2162getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
                long selectorColor = timePickerColors.getSelectorColor();
                ContentDrawScope contentDrawScope = drawWithContent;
                DrawScope.m3154drawCircleVaOC9Bg$default(contentDrawScope, Color.INSTANCE.m2655getBlack0d7_KjU(), f2, jOffset, 0.0f, null, null, BlendMode.INSTANCE.m2546getClear0nO6VwU(), 56, null);
                drawWithContent.drawContent();
                DrawScope.m3154drawCircleVaOC9Bg$default(contentDrawScope, selectorColor, f2, jOffset, 0.0f, null, null, BlendMode.INSTANCE.m2574getXor0nO6VwU(), 56, null);
                DrawScope.m3159drawLineNGM6Ib0$default(contentDrawScope, selectorColor, androidx.compose.ui.geometry.SizeKt.m2469getCenteruvyYCjk(drawWithContent.mo3172getSizeNHjbRc()), Offset.m2394minusMKHz9U(jOffset, OffsetKt.Offset(((float) Math.cos(timePickerState.getCurrentAngle$material3_release().getValue().floatValue())) * f2, ((float) Math.sin(timePickerState.getCurrentAngle$material3_release().getValue().floatValue())) * f2)), drawWithContent.mo325toPx0680j_4(TimePickerTokens.INSTANCE.m2163getClockDialSelectorTrackContainerWidthD9Ej5fM()), 0, null, 0.0f, null, BlendMode.INSTANCE.m2573getSrcOver0nO6VwU(), 240, null);
                DrawScope.m3154drawCircleVaOC9Bg$default(contentDrawScope, selectorColor, drawWithContent.mo325toPx0680j_4(TimePickerTokens.INSTANCE.m2161getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, androidx.compose.ui.geometry.SizeKt.m2469getCenteruvyYCjk(drawWithContent.mo3172getSizeNHjbRc()), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                DrawScope.m3154drawCircleVaOC9Bg$default(contentDrawScope, timePickerColors.m1555clockDialContentColorvNxB06k$material3_release(true), f2, jOffset, 0.0f, null, null, BlendMode.INSTANCE.m2556getDstOver0nO6VwU(), 56, null);
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C03812 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03812(TimePickerState timePickerState, boolean z) {
            super(3);
            this.$state = timePickerState;
            this.$autoSwitchToMinute = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$1(MutableState<Float> mutableState) {
            return mutableState.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<Float> mutableState, float f) {
            mutableState.setValue(Float.valueOf(f));
        }

        public final Modifier invoke(Modifier composed, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(composed, "$this$composed");
            composer.startReplaceableGroup(-1645090088);
            ComposerKt.sourceInformation(composer, "C1245@47844L31,1246@47895L31,1247@47945L43,1248@48005L24,*1249@48066L7,1252@48143L28:TimePicker.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645090088, i, -1, "androidx.compose.material3.clockDial.<anonymous> (TimePicker.kt:1244)");
            }
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m4982boximpl(IntOffset.INSTANCE.m5001getZeronOccac()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) objRememberedValue3;
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue4 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            composer.endReplaceableGroup();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            float fMo325toPx0680j_4 = ((Density) objConsume).mo325toPx0680j_4(TimePickerKt.MaxDistance);
            Modifier.Companion companion = Modifier.INSTANCE;
            final TimePickerState timePickerState = this.$state;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composer.changed(timePickerState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.TimePickerKt$clockDial$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m1578invokeozmzZPI(intSize.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m1578invokeozmzZPI(long j) {
                        timePickerState.m1594setCentergyyYBs$material3_release(IntSizeKt.m5039getCenterozmzZPI(j));
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue5), new Object[]{this.$state, IntOffset.m4982boximpl(invoke$lambda$7(mutableState3)), Float.valueOf(fMo325toPx0680j_4)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C00732(mutableState, mutableState2, coroutineScope, this.$state, fMo325toPx0680j_4, this.$autoSwitchToMinute, null)), new Object[]{this.$state, IntOffset.m4982boximpl(invoke$lambda$7(mutableState3)), Float.valueOf(fMo325toPx0680j_4)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass3(coroutineScope, this.$state, this.$autoSwitchToMinute, fMo325toPx0680j_4, mutableState, mutableState2, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$4(MutableState<Float> mutableState) {
            return mutableState.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$5(MutableState<Float> mutableState, float f) {
            mutableState.setValue(Float.valueOf(f));
        }

        private static final long invoke$lambda$7(MutableState<IntOffset> mutableState) {
            return mutableState.getValue().getPackedValue();
        }

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TimePicker.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2", f = "TimePicker.kt", i = {}, l = {1255}, m = "invokeSuspend", n = {}, s = {})
        static final class C00732 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ float $maxDist;
            final /* synthetic */ MutableState<Float> $offsetX$delegate;
            final /* synthetic */ MutableState<Float> $offsetY$delegate;
            final /* synthetic */ CoroutineScope $scope;
            final /* synthetic */ TimePickerState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00732(MutableState<Float> mutableState, MutableState<Float> mutableState2, CoroutineScope coroutineScope, TimePickerState timePickerState, float f, boolean z, Continuation<? super C00732> continuation) {
                super(2, continuation);
                this.$offsetX$delegate = mutableState;
                this.$offsetY$delegate = mutableState2;
                this.$scope = coroutineScope;
                this.$state = timePickerState;
                this.$maxDist = f;
                this.$autoSwitchToMinute = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00732 c00732 = new C00732(this.$offsetX$delegate, this.$offsetY$delegate, this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute, continuation);
                c00732.L$0 = obj;
                return c00732;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                return ((C00732) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: TimePicker.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$1", f = "TimePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<Float> $offsetX$delegate;
                final /* synthetic */ MutableState<Float> $offsetY$delegate;
                /* synthetic */ long J$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                    super(3, continuation);
                    this.$offsetX$delegate = mutableState;
                    this.$offsetY$delegate = mutableState2;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                    return m1579invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                }

                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m1579invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                    anonymousClass1.J$0 = j;
                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        long j = this.J$0;
                        C03812.invoke$lambda$2(this.$offsetX$delegate, Offset.m2390getXimpl(j));
                        C03812.invoke$lambda$5(this.$offsetY$delegate, Offset.m2391getYimpl(j));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, null);
                    final CoroutineScope coroutineScope = this.$scope;
                    final TimePickerState timePickerState = this.$state;
                    final float f = this.$maxDist;
                    final boolean z = this.$autoSwitchToMinute;
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, anonymousClass1, new Function1<Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1580invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1580invokek4lQ0M(long j) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(timePickerState, j, f, z, null), 3, null);
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1", f = "TimePicker.kt", i = {}, l = {1261}, m = "invokeSuspend", n = {}, s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ long $it;
                            final /* synthetic */ float $maxDist;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(TimePickerState timePickerState, long j, float f, boolean z, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$it = j;
                                this.$maxDist = f;
                                this.$autoSwitchToMinute = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$state, this.$it, this.$maxDist, this.$autoSwitchToMinute, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$state.onTap$material3_release(Offset.m2390getXimpl(this.$it), Offset.m2391getYimpl(this.$it), this.$maxDist, this.$autoSwitchToMinute, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, this, 3, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: TimePicker.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3", f = "TimePicker.kt", i = {}, l = {1266}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ float $maxDist;
            final /* synthetic */ MutableState<Float> $offsetX$delegate;
            final /* synthetic */ MutableState<Float> $offsetY$delegate;
            final /* synthetic */ CoroutineScope $scope;
            final /* synthetic */ TimePickerState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(CoroutineScope coroutineScope, TimePickerState timePickerState, boolean z, float f, MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$scope = coroutineScope;
                this.$state = timePickerState;
                this.$autoSwitchToMinute = z;
                this.$maxDist = f;
                this.$offsetX$delegate = mutableState;
                this.$offsetY$delegate = mutableState2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scope, this.$state, this.$autoSwitchToMinute, this.$maxDist, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    final CoroutineScope coroutineScope = this.$scope;
                    final TimePickerState timePickerState = this.$state;
                    final boolean z = this.$autoSwitchToMinute;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.1
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
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00751(timePickerState, z, null), 3, null);
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1", f = "TimePicker.kt", i = {}, l = {1270, 1272}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00751(TimePickerState timePickerState, boolean z, Continuation<? super C00751> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$autoSwitchToMinute = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00751(this.$state, this.$autoSwitchToMinute, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    if (Selection.m1375equalsimpl0(this.$state.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1379getHourJiIwxys()) && this.$autoSwitchToMinute) {
                                        this.$state.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1380getMinuteJiIwxys());
                                        this.label = 1;
                                        if (this.$state.animateToCurrent$material3_release(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else if (Selection.m1375equalsimpl0(this.$state.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1380getMinuteJiIwxys())) {
                                        this.label = 2;
                                        if (this.$state.settle(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                } else {
                                    if (i != 1 && i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    final CoroutineScope coroutineScope2 = this.$scope;
                    final TimePickerState timePickerState2 = this.$state;
                    final float f = this.$maxDist;
                    final MutableState<Float> mutableState = this.$offsetX$delegate;
                    final MutableState<Float> mutableState2 = this.$offsetY$delegate;
                    this.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, function0, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m1581invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m1581invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                            Intrinsics.checkNotNullParameter(pointerInputChange, "<anonymous parameter 0>");
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(j, timePickerState2, mutableState, mutableState2, null), 3, null);
                            timePickerState2.moveSelector$material3_release(C03812.invoke$lambda$1(mutableState), C03812.invoke$lambda$4(mutableState2), f);
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1", f = "TimePicker.kt", i = {}, l = {1279}, m = "invokeSuspend", n = {}, s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ long $dragAmount;
                            final /* synthetic */ MutableState<Float> $offsetX$delegate;
                            final /* synthetic */ MutableState<Float> $offsetY$delegate;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(long j, TimePickerState timePickerState, MutableState<Float> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$dragAmount = j;
                                this.$state = timePickerState;
                                this.$offsetX$delegate = mutableState;
                                this.$offsetY$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$dragAmount, this.$state, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    MutableState<Float> mutableState = this.$offsetX$delegate;
                                    C03812.invoke$lambda$2(mutableState, C03812.invoke$lambda$1(mutableState) + Offset.m2390getXimpl(this.$dragAmount));
                                    MutableState<Float> mutableState2 = this.$offsetY$delegate;
                                    C03812.invoke$lambda$5(mutableState2, C03812.invoke$lambda$4(mutableState2) + Offset.m2391getYimpl(this.$dragAmount));
                                    this.label = 1;
                                    if (TimePickerState.update$material3_release$default(this.$state, TimePickerKt.atan(C03812.invoke$lambda$4(this.$offsetY$delegate) - IntOffset.m4992getYimpl(this.$state.m1591getCenternOccac$material3_release()), C03812.invoke$lambda$1(this.$offsetX$delegate) - IntOffset.m4991getXimpl(this.$state.m1591getCenternOccac$material3_release())), false, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, this, 5, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText(final TimePickerState timePickerState, final int i, final boolean z, Composer composer, final int i2) {
        int i3;
        boolean zAreEqual;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1317232110);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockText)P(1,2)*1287@49593L10,1291@49736L7,1292@49786L40,1293@49843L24,1295@49905L142,1313@50500L39,1308@50299L758:TimePicker.kt#uh7d8r");
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1317232110, i3, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1286)");
            }
            TextStyle textStyleCopyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TimePickerTokens.INSTANCE.getClockDialLabelTextFont()), false);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo325toPx0680j_4 = ((Density) objConsume).mo325toPx0680j_4(MaxDistance);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2379boximpl(Offset.INSTANCE.m2406getZeroF1C5BW0()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            final String strM1574numberContentDescriptionYKJpE6Y = m1574numberContentDescriptionYKJpE6Y(timePickerState.m1592getSelectionJiIwxys$material3_release(), timePickerState.getIs24hour(), i, composerStartRestartGroup, (i3 << 3) & 896);
            String localString = toLocalString(i, 1);
            if (Selection.m1375equalsimpl0(timePickerState.m1592getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1380getMinuteJiIwxys())) {
                zAreEqual = Intrinsics.areEqual(toLocalString(timePickerState.getMinute(), 1), localString);
            } else {
                zAreEqual = Intrinsics.areEqual(toLocalString(timePickerState.getHour(), 1), localString);
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierM527size3ABfNKs = SizeKt.m527size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), MinimumInteractiveSize);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TimePickerKt.ClockText$lambda$30(mutableState, LayoutCoordinatesKt.boundsInParent(it).m2420getCenterF1C5BW0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierFocusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM527size3ABfNKs, (Function1) objRememberedValue3), false, null, 3, null);
            final boolean z2 = zAreEqual;
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFocusable$default, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockText.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final TimePickerState timePickerState2 = timePickerState;
                    final float f = fMo325toPx0680j_4;
                    final boolean z3 = z;
                    final MutableState<Offset> mutableState2 = mutableState;
                    SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerKt.ClockText.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00721(timePickerState2, f, z3, mutableState2, null), 3, null);
                            return true;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1", f = "TimePicker.kt", i = {}, l = {1318}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ MutableState<Offset> $center$delegate;
                            final /* synthetic */ float $maxDist;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00721(TimePickerState timePickerState, float f, boolean z, MutableState<Offset> mutableState, Continuation<? super C00721> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$maxDist = f;
                                this.$autoSwitchToMinute = z;
                                this.$center$delegate = mutableState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00721(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$state.onTap$material3_release(Offset.m2390getXimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate)), Offset.m2391getYimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate)), this.$maxDist, this.$autoSwitchToMinute, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, 1, null);
                    SemanticsPropertiesKt.setSelected(semantics, z2);
                }
            });
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSemantics);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 859623406, "C1324@50912L76,1323@50853L198:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM1574numberContentDescriptionYKJpE6Y);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, strM1574numberContentDescriptionYKJpE6Y);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue4);
            composer2 = composerStartRestartGroup;
            TextKt.m1552Text4IGK_g(localString, modifierClearAndSetSemantics, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyleCopyAndSetFontPadding, composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockText.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                TimePickerKt.ClockText(timePickerState, i, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        return mutableState.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m2379boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: timeInputOnChange-gIWD5Rc, reason: not valid java name */
    public static final void m1575timeInputOnChangegIWD5Rc(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, Function1<? super TextFieldValue, Unit> function1) {
        int iDigitToInt;
        if (Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
            return;
        }
        if (textFieldValue.getText().length() == 0) {
            if (Selection.m1375equalsimpl0(i, Selection.INSTANCE.m1379getHourJiIwxys())) {
                timePickerState.setHour$material3_release(0);
            } else {
                timePickerState.setMinute$material3_release(0);
            }
            function1.invoke(TextFieldValue.m4619copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (textFieldValue.getText().length() == 3 && TextRange.m4404getStartimpl(textFieldValue.getSelection()) == 1) {
                iDigitToInt = CharsKt.digitToInt(textFieldValue.getText().charAt(0));
            } else {
                iDigitToInt = Integer.parseInt(textFieldValue.getText());
            }
            if (iDigitToInt <= i2) {
                if (Selection.m1375equalsimpl0(i, Selection.INSTANCE.m1379getHourJiIwxys())) {
                    timePickerState.setHour$material3_release(iDigitToInt);
                    if (iDigitToInt > 1 && !timePickerState.getIs24hour()) {
                        timePickerState.m1595setSelectioniHAOin8$material3_release(Selection.INSTANCE.m1380getMinuteJiIwxys());
                    }
                } else {
                    timePickerState.setMinute$material3_release(iDigitToInt);
                }
                if (textFieldValue.getText().length() > 2) {
                    textFieldValue = TextFieldValue.m4619copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null);
                }
                function1.invoke(textFieldValue);
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
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
    /* JADX INFO: renamed from: TimePickerTextField-lxUZ_iY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1568TimePickerTextFieldlxUZ_iY(final androidx.compose.ui.Modifier r115, final androidx.compose.ui.text.input.TextFieldValue r116, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r117, final androidx.compose.material3.TimePickerState r118, final int r119, androidx.compose.foundation.text.KeyboardOptions r120, androidx.compose.foundation.text.KeyboardActions r121, final androidx.compose.material3.TimePickerColors r122, androidx.compose.runtime.Composer r123, final int r124, final int r125) {
        /*
            Method dump skipped, instruction units count: 1744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m1568TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularLayout-uFdPcIQ, reason: not valid java name */
    public static final void m1566CircularLayoutuFdPcIQ(Modifier modifier, final float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1502@56908L1669:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1497)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo11measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, final long j) {
                    Object next;
                    Object next2;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final float f2 = Layout.mo325toPx0680j_4(f);
                    long jM4820copyZbe2FdA$default = Constraints.m4820copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                    List<? extends Measurable> list = measurables;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        Measurable measurable = (Measurable) obj;
                        if (LayoutIdKt.getLayoutId(measurable) != LayoutId.Selector && LayoutIdKt.getLayoutId(measurable) != LayoutId.InnerCircle) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(((Measurable) it.next()).mo3866measureBRTryo0(jM4820copyZbe2FdA$default));
                    }
                    final ArrayList arrayList4 = arrayList3;
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        if (LayoutIdKt.getLayoutId((Measurable) next) == LayoutId.Selector) {
                            break;
                        }
                    }
                    Measurable measurable2 = (Measurable) next;
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                        if (LayoutIdKt.getLayoutId((Measurable) next2) == LayoutId.InnerCircle) {
                            break;
                        }
                    }
                    Measurable measurable3 = (Measurable) next2;
                    final float size = 6.2831855f / arrayList4.size();
                    final Placeable placeableMo3866measureBRTryo0 = measurable2 != null ? measurable2.mo3866measureBRTryo0(jM4820copyZbe2FdA$default) : null;
                    final Placeable placeableMo3866measureBRTryo02 = measurable3 != null ? measurable3.mo3866measureBRTryo0(jM4820copyZbe2FdA$default) : null;
                    return MeasureScope.layout$default(Layout, Constraints.m4831getMinWidthimpl(j), Constraints.m4830getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$measure$1
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
                            Placeable placeable = placeableMo3866measureBRTryo0;
                            if (placeable != null) {
                                Placeable.PlacementScope.place$default(layout, placeable, 0, 0, 0.0f, 4, null);
                            }
                            List<Placeable> list2 = arrayList4;
                            long j2 = j;
                            float f3 = f2;
                            float f4 = size;
                            Iterator it4 = list2.iterator();
                            int i5 = 0;
                            while (it4.hasNext()) {
                                Object next3 = it4.next();
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                Placeable placeable2 = (Placeable) next3;
                                double d = f3;
                                Iterator it5 = it4;
                                double d2 = ((double) (i5 * f4)) - 1.5707963267948966d;
                                Placeable.PlacementScope.place$default(layout, placeable2, MathKt.roundToInt((Math.cos(d2) * d) + ((double) ((Constraints.m4829getMaxWidthimpl(j2) / 2) - (placeable2.getWidth() / 2)))), MathKt.roundToInt((d * Math.sin(d2)) + ((double) ((Constraints.m4828getMaxHeightimpl(j2) / 2) - (placeable2.getHeight() / 2)))), 0.0f, 4, null);
                                i5 = i6;
                                it4 = it5;
                            }
                            Placeable placeable3 = placeableMo3866measureBRTryo02;
                            if (placeable3 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable3, (Constraints.m4831getMinWidthimpl(j) - placeableMo3866measureBRTryo02.getWidth()) / 2, (Constraints.m4830getMinHeightimpl(j) - placeableMo3866measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
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
            int i6 = ((i5 << 9) & 7168) | 6;
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
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i6 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
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

            public final void invoke(Composer composer2, int i7) {
                TimePickerKt.m1566CircularLayoutuFdPcIQ(modifier2, f, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX INFO: renamed from: numberContentDescription-YKJpE6Y, reason: not valid java name */
    public static final String m1574numberContentDescriptionYKJpE6Y(int i, boolean z, int i2, Composer composer, int i3) {
        int iM1455getTimePickerHourSuffixadMyvUU;
        ComposerKt.sourceInformationMarkerStart(composer, 1826155772, "C(numberContentDescription)P(2:c#material3.Selection)1555@58952L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1542)");
        }
        if (Selection.m1375equalsimpl0(i, Selection.INSTANCE.m1380getMinuteJiIwxys())) {
            iM1455getTimePickerHourSuffixadMyvUU = Strings.INSTANCE.m1459getTimePickerMinuteSuffixadMyvUU();
        } else if (z) {
            iM1455getTimePickerHourSuffixadMyvUU = Strings.INSTANCE.m1451getTimePicker24HourSuffixadMyvUU();
        } else {
            iM1455getTimePickerHourSuffixadMyvUU = Strings.INSTANCE.m1455getTimePickerHourSuffixadMyvUU();
        }
        String strM1466getStringiSCLEhQ = Strings_androidKt.m1466getStringiSCLEhQ(iM1455getTimePickerHourSuffixadMyvUU, new Object[]{Integer.valueOf(i2)}, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strM1466getStringiSCLEhQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Float, Float> valuesForAnimation(float f, float f2) {
        if (Math.abs(f - f2) <= 3.141592653589793d) {
            return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
        }
        double d = f;
        if (d > 3.141592653589793d && f2 < 3.141592653589793d) {
            f2 += FullCircle;
        } else if (d < 3.141592653589793d && f2 > 3.141592653589793d) {
            f += FullCircle;
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot(i - f, i2 - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float f, float f2) {
        float fAtan2 = ((float) Math.atan2(f, f2)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + FullCircle : fAtan2;
    }

    private static final Modifier visible(Modifier modifier, final boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
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
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("visible");
                inspectorInfo.getProperties().set("visible", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toLocalString(int i, int i2) {
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        integerInstance.setGroupingUsed(false);
        integerInstance.setMinimumIntegerDigits(i2);
        String str = integerInstance.format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(str, "formatter.format(this)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier clockDial(Modifier modifier, final TimePickerState timePickerState, boolean z) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$clockDial$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("clockDial");
                inspectorInfo.getProperties().set("state", timePickerState);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new C03812(timePickerState, z));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f = 24;
        ClockFaceBottomMargin = Dp.m4873constructorimpl(f);
        DisplaySeparatorWidth = Dp.m4873constructorimpl(f);
        TimeInputBottomPadding = Dp.m4873constructorimpl(f);
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        Hours = listListOf;
        List<Integer> list = listListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((((Number) it.next()).intValue() % 12) + 12));
        }
        ExtraHours = arrayList;
        PeriodToggleMargin = Dp.m4873constructorimpl(12);
    }
}
