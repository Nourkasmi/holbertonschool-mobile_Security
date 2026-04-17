package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0083\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001ø\u0001\u0000¢\u0006\u0002\u0010>\u001am\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001am\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a)\u0010X\u001a\u00020\r*\u00020\r2\u0006\u0010Y\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a\u009a\u0001\u0010\\\u001a\u00020\u0007*\u00020]2\u0006\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020%2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010a2\u0006\u0010e\u001a\u00020a2\b\u0010f\u001a\u0004\u0018\u00010a2\b\u0010g\u001a\u0004\u0018\u00010a2\u0006\u0010h\u001a\u00020a2\b\u0010i\u001a\u0004\u0018\u00010a2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010j\u001a\u00020k2\u0006\u0010<\u001a\u00020=H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006l"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "prefixPlaceableHeight", "suffixPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-DHJA7U0", "(IIIIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-DHJA7U0", "(IIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m5212constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5212constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        int maxLines2;
        boolean readOnly2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int minLines2;
        int $dirty;
        int $dirty1;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        Shape shape3;
        int $dirty2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        boolean isError2;
        int maxLines3;
        int $dirty3;
        int $dirty12;
        TextFieldColors colors2;
        TextStyle textStyle3;
        Object value$iv$iv;
        TextFieldColors colors3;
        TextStyle textStyle4;
        Composer $composer2;
        Shape shape4;
        MutableInteractionSource interactionSource5;
        int maxLines4;
        boolean isError3;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean enabled4;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)145@8187L7,160@8939L39,161@9025L5,162@9088L8,170@9450L15,170@9384L2436:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function25) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(function26) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function27) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty13 |= 3072;
            i2 = i14;
        } else {
            i2 = i14;
            if (($changed1 & 7168) == 0) {
                $dirty13 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i15 = i & 16384;
        if (i15 != 0) {
            $dirty13 |= 24576;
            i3 = i15;
        } else if (($changed1 & 57344) == 0) {
            i3 = i15;
            $dirty13 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        } else {
            i3 = i15;
        }
        int i16 = i & 32768;
        if (i16 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i17 = i & 65536;
        if (i17 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i18 = i & 131072;
        if (i18 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                maxLines2 = maxLines;
                int i19 = $composer3.changed(maxLines2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty13 |= i19;
            } else {
                maxLines2 = maxLines;
            }
            $dirty13 |= i19;
        } else {
            maxLines2 = maxLines;
        }
        int i20 = i & 524288;
        if (i20 != 0) {
            $dirty13 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i21 = i & 1048576;
        if (i21 != 0) {
            $dirty22 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty22 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            $dirty22 |= ((i & 2097152) == 0 && $composer3.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 896) == 0) {
            $dirty22 |= ((i & 4194304) == 0 && $composer3.changed(colors)) ? 256 : 128;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            function221 = function2;
            function220 = function22;
            function219 = function23;
            function218 = function24;
            function217 = function25;
            function216 = function26;
            function215 = function27;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            maxLines4 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i5 != 0 ? true : enabled;
                readOnly2 = i6 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    textStyle2 = textStyle;
                }
                Function2<? super Composer, ? super Integer, Unit> function222 = i7 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function223 = i8 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function224 = i9 != 0 ? null : function23;
                Function2<? super Composer, ? super Integer, Unit> function225 = i10 != 0 ? null : function24;
                Function2<? super Composer, ? super Integer, Unit> function226 = i11 != 0 ? null : function25;
                Function2<? super Composer, ? super Integer, Unit> function227 = i12 != 0 ? null : function26;
                Function2<? super Composer, ? super Integer, Unit> function228 = i13 != 0 ? null : function27;
                boolean isError4 = i2 != 0 ? false : isError;
                visualTransformation2 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i18 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                minLines2 = i20 != 0 ? 1 : minLines;
                if (i21 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    $dirty1 = $dirty13;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    $dirty1 = $dirty13;
                    interactionSource2 = interactionSource;
                }
                if ((2097152 & i) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-897);
                    function28 = function223;
                    function29 = function224;
                    function210 = function225;
                    function211 = function226;
                    function212 = function222;
                    function213 = function227;
                    function214 = function228;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1635colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle2;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    function28 = function223;
                    function29 = function224;
                    function210 = function225;
                    function211 = function226;
                    function212 = function222;
                    function213 = function227;
                    function214 = function228;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty22 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                function212 = function2;
                function28 = function22;
                function29 = function23;
                function210 = function24;
                function211 = function25;
                function213 = function26;
                function214 = function27;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty12 = $dirty13;
                $dirty2 = $dirty22;
                maxLines3 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922450045, $dirty3, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:139)");
            }
            $composer3.startReplaceableGroup(1663535868);
            ComposerKt.sourceInformation($composer3, "*166@9248L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Function2<? super Composer, ? super Integer, Unit> function229 = function212;
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i22 = $dirty12;
            final int i23 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final int $dirty5 = $dirty3;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            colors3 = colors2;
            final boolean z4 = singleLine2;
            textStyle4 = textStyle3;
            final int i24 = maxLines3;
            final int i25 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2<? super Composer, ? super Integer, Unit> function230 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function231 = function29;
            final Function2<? super Composer, ? super Integer, Unit> function232 = function210;
            final Function2<? super Composer, ? super Integer, Unit> function233 = function211;
            final Function2<? super Composer, ? super Integer, Unit> function234 = function213;
            final Function2<? super Composer, ? super Integer, Unit> function235 = function214;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function236 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2
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

                public final void invoke(Composer $composer4, int $changed3) {
                    Modifier modifierM485paddingqDBjuR0$default;
                    ComposerKt.sourceInformation($composer4, "C190@10308L20,171@9477L2337:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1886965181, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:170)");
                        }
                        if (function229 != null) {
                            modifierM485paddingqDBjuR0$default = PaddingKt.m485paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier6, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM485paddingqDBjuR0$default = modifier6;
                        }
                        Modifier modifierM512defaultMinSizeVpY3zN4 = SizeKt.m512defaultMinSizeVpY3zN4(modifierM485paddingqDBjuR0$default, OutlinedTextFieldDefaults.INSTANCE.m1639getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m1638getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.cursorColor$material3_release(z, $composer4, ((i22 >> 9) & 14) | ((i23 >> 3) & 112)).getValue().m2957unboximpl(), null);
                        final String str = value;
                        final boolean z5 = z2;
                        final boolean z6 = z4;
                        final VisualTransformation visualTransformation4 = visualTransformation3;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final boolean z7 = z;
                        final Function2<Composer, Integer, Unit> function237 = function229;
                        final Function2<Composer, Integer, Unit> function238 = function230;
                        final Function2<Composer, Integer, Unit> function239 = function231;
                        final Function2<Composer, Integer, Unit> function240 = function232;
                        final Function2<Composer, Integer, Unit> function241 = function233;
                        final Function2<Composer, Integer, Unit> function242 = function234;
                        final Function2<Composer, Integer, Unit> function243 = function235;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i26 = $dirty5;
                        final int i27 = i22;
                        final int i28 = i23;
                        final Shape shape6 = shape5;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer4, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function244, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function244, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer5, int $changed4) {
                                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                ComposerKt.sourceInformation($composer5, "C199@10744L1046:OutlinedTextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1474611661, $dirty7, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:198)");
                                    }
                                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                    String str2 = str;
                                    boolean z8 = z5;
                                    boolean z9 = z6;
                                    VisualTransformation visualTransformation5 = visualTransformation4;
                                    MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                    boolean z10 = z7;
                                    Function2<Composer, Integer, Unit> function244 = function237;
                                    Function2<Composer, Integer, Unit> function245 = function238;
                                    Function2<Composer, Integer, Unit> function246 = function239;
                                    Function2<Composer, Integer, Unit> function247 = function240;
                                    Function2<Composer, Integer, Unit> function248 = function241;
                                    Function2<Composer, Integer, Unit> function249 = function242;
                                    Function2<Composer, Integer, Unit> function250 = function243;
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    final boolean z11 = z5;
                                    final boolean z12 = z7;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final Shape shape7 = shape6;
                                    final int i29 = i26;
                                    final int i30 = i27;
                                    final int i31 = i28;
                                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer5, 2108828640, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed5) {
                                            ComposerKt.sourceInformation($composer6, "C216@11520L230:OutlinedTextField.kt#uh7d8r");
                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2108828640, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:215)");
                                                }
                                                OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = OutlinedTextFieldDefaults.INSTANCE;
                                                boolean z13 = z11;
                                                boolean z14 = z12;
                                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                                TextFieldColors textFieldColors5 = textFieldColors4;
                                                Shape shape8 = shape7;
                                                int i32 = ((i29 >> 9) & 14) | 12582912 | ((i30 >> 6) & 112);
                                                int i33 = i31;
                                                outlinedTextFieldDefaults2.m1634ContainerBoxnbWgWpA(z13, z14, mutableInteractionSource5, textFieldColors5, shape8, 0.0f, 0.0f, $composer6, i32 | ((i33 << 6) & 896) | ((i33 << 3) & 7168) | ((i33 << 9) & 57344), 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    });
                                    int i32 = i26;
                                    int i33 = i27;
                                    int i34 = i28;
                                    outlinedTextFieldDefaults.DecorationBox(str2, innerTextField, z8, z9, visualTransformation5, mutableInteractionSource3, z10, function244, function245, function246, function247, function248, function249, function250, textFieldColors3, null, composableLambda2, $composer5, (i32 & 14) | (($dirty7 << 3) & 112) | ((i32 >> 3) & 896) | ((i33 >> 12) & 7168) | (i33 & 57344) | ((i34 << 15) & 458752) | ((i33 << 9) & 3670016) | ((i32 << 3) & 29360128) | ((i32 << 3) & 234881024) | ((i32 << 3) & 1879048192), ((i32 >> 27) & 14) | 14155776 | ((i33 << 3) & 112) | ((i33 << 3) & 896) | ((i33 << 3) & 7168) | ((i34 << 6) & 57344), 32768);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        });
                        int i29 = $dirty5;
                        int i30 = (i29 & 57344) | (i29 & 14) | (i29 & 112) | (i29 & 7168);
                        int i31 = i22;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM512defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i24, i25, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, composableLambda, $composer4, i30 | ((i31 << 3) & 3670016) | ((i31 << 3) & 29360128) | ((i31 << 3) & 234881024) | ((i31 << 3) & 1879048192), ((i31 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i31 >> 9) & 112) | ((i23 << 9) & 7168), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            };
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, -1886965181, true, function236), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource5 = interactionSource4;
            maxLines4 = maxLines3;
            isError3 = isError2;
            function215 = function214;
            function216 = function213;
            function217 = function211;
            function218 = function210;
            function219 = function29;
            function220 = function28;
            function221 = function212;
            enabled4 = enabled3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final boolean z5 = enabled4;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function237 = function221;
        final Function2<? super Composer, ? super Integer, Unit> function238 = function220;
        final Function2<? super Composer, ? super Integer, Unit> function239 = function219;
        final Function2<? super Composer, ? super Integer, Unit> function240 = function218;
        final Function2<? super Composer, ? super Integer, Unit> function241 = function217;
        final Function2<? super Composer, ? super Integer, Unit> function242 = function216;
        final Function2<? super Composer, ? super Integer, Unit> function243 = function215;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z8 = singleLine2;
        final int i26 = maxLines4;
        final int i27 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.3
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

            public final void invoke(Composer composer, int i28) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier7, z5, z6, textStyle5, function237, function238, function239, function240, function241, function242, function243, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i26, i27, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        int maxLines2;
        boolean readOnly2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int minLines2;
        int $dirty;
        int $dirty1;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        Shape shape3;
        int $dirty2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        boolean isError2;
        int maxLines3;
        int $dirty3;
        int $dirty12;
        TextFieldColors colors2;
        TextStyle textStyle3;
        Object value$iv$iv;
        TextFieldColors colors3;
        TextStyle textStyle4;
        Composer $composer2;
        Shape shape4;
        MutableInteractionSource interactionSource5;
        int maxLines4;
        boolean isError3;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean enabled4;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)304@16929L7,319@17681L39,320@17767L5,321@17830L8,329@18192L15,329@18126L2441:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function25) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(function26) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(function27) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty13 |= 3072;
            i2 = i14;
        } else {
            i2 = i14;
            if (($changed1 & 7168) == 0) {
                $dirty13 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i15 = i & 16384;
        if (i15 != 0) {
            $dirty13 |= 24576;
            i3 = i15;
        } else if (($changed1 & 57344) == 0) {
            i3 = i15;
            $dirty13 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        } else {
            i3 = i15;
        }
        int i16 = i & 32768;
        if (i16 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i17 = i & 65536;
        if (i17 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i18 = i & 131072;
        if (i18 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                maxLines2 = maxLines;
                int i19 = $composer3.changed(maxLines2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty13 |= i19;
            } else {
                maxLines2 = maxLines;
            }
            $dirty13 |= i19;
        } else {
            maxLines2 = maxLines;
        }
        int i20 = i & 524288;
        if (i20 != 0) {
            $dirty13 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i21 = i & 1048576;
        if (i21 != 0) {
            $dirty22 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty22 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            $dirty22 |= ((i & 2097152) == 0 && $composer3.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 896) == 0) {
            $dirty22 |= ((i & 4194304) == 0 && $composer3.changed(colors)) ? 256 : 128;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            function221 = function2;
            function220 = function22;
            function219 = function23;
            function218 = function24;
            function217 = function25;
            function216 = function26;
            function215 = function27;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            maxLines4 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i5 != 0 ? true : enabled;
                readOnly2 = i6 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    textStyle2 = textStyle;
                }
                Function2<? super Composer, ? super Integer, Unit> function222 = i7 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function223 = i8 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function224 = i9 != 0 ? null : function23;
                Function2<? super Composer, ? super Integer, Unit> function225 = i10 != 0 ? null : function24;
                Function2<? super Composer, ? super Integer, Unit> function226 = i11 != 0 ? null : function25;
                Function2<? super Composer, ? super Integer, Unit> function227 = i12 != 0 ? null : function26;
                Function2<? super Composer, ? super Integer, Unit> function228 = i13 != 0 ? null : function27;
                boolean isError4 = i2 != 0 ? false : isError;
                visualTransformation2 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i18 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                minLines2 = i20 != 0 ? 1 : minLines;
                if (i21 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    $dirty1 = $dirty13;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    $dirty1 = $dirty13;
                    interactionSource2 = interactionSource;
                }
                if ((2097152 & i) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-897);
                    function28 = function223;
                    function29 = function224;
                    function210 = function225;
                    function211 = function226;
                    function212 = function222;
                    function213 = function227;
                    function214 = function228;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1635colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle2;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    function28 = function223;
                    function29 = function224;
                    function210 = function225;
                    function211 = function226;
                    function212 = function222;
                    function213 = function227;
                    function214 = function228;
                    isError2 = isError4;
                    maxLines3 = maxLines2;
                    $dirty3 = $dirty;
                    $dirty12 = $dirty1;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty22 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                function212 = function2;
                function28 = function22;
                function29 = function23;
                function210 = function24;
                function211 = function25;
                function213 = function26;
                function214 = function27;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty12 = $dirty13;
                $dirty2 = $dirty22;
                maxLines3 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1570442800, $dirty3, $dirty12, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:298)");
            }
            $composer3.startReplaceableGroup(1663544610);
            ComposerKt.sourceInformation($composer3, "*325@17990L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor$material3_release(enabled3, isError2, interactionSource4, $composer3, (($dirty3 >> 9) & 14) | (($dirty12 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null));
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            final Function2<? super Composer, ? super Integer, Unit> function229 = function212;
            final Modifier modifier6 = modifier3;
            final TextFieldColors textFieldColors = colors2;
            final boolean z = isError2;
            final int i22 = $dirty12;
            final int i23 = $dirty2;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly2;
            final int $dirty5 = $dirty3;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            colors3 = colors2;
            final boolean z4 = singleLine2;
            textStyle4 = textStyle3;
            final int i24 = maxLines3;
            final int i25 = minLines2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function2<? super Composer, ? super Integer, Unit> function230 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function231 = function29;
            final Function2<? super Composer, ? super Integer, Unit> function232 = function210;
            final Function2<? super Composer, ? super Integer, Unit> function233 = function211;
            final Function2<? super Composer, ? super Integer, Unit> function234 = function213;
            final Function2<? super Composer, ? super Integer, Unit> function235 = function214;
            final Shape shape5 = shape3;
            Function2<Composer, Integer, Unit> function236 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5
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

                public final void invoke(Composer $composer4, int $changed3) {
                    Modifier modifierM485paddingqDBjuR0$default;
                    ComposerKt.sourceInformation($composer4, "C349@19050L20,330@18219L2342:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1830921872, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:329)");
                        }
                        if (function229 != null) {
                            modifierM485paddingqDBjuR0$default = PaddingKt.m485paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier6, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM485paddingqDBjuR0$default = modifier6;
                        }
                        Modifier modifierM512defaultMinSizeVpY3zN4 = SizeKt.m512defaultMinSizeVpY3zN4(modifierM485paddingqDBjuR0$default, OutlinedTextFieldDefaults.INSTANCE.m1639getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m1638getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.cursorColor$material3_release(z, $composer4, ((i22 >> 9) & 14) | ((i23 >> 3) & 112)).getValue().m2957unboximpl(), null);
                        final TextFieldValue textFieldValue = value;
                        final boolean z5 = z2;
                        final boolean z6 = z4;
                        final VisualTransformation visualTransformation4 = visualTransformation3;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final boolean z7 = z;
                        final Function2<Composer, Integer, Unit> function237 = function229;
                        final Function2<Composer, Integer, Unit> function238 = function230;
                        final Function2<Composer, Integer, Unit> function239 = function231;
                        final Function2<Composer, Integer, Unit> function240 = function232;
                        final Function2<Composer, Integer, Unit> function241 = function233;
                        final Function2<Composer, Integer, Unit> function242 = function234;
                        final Function2<Composer, Integer, Unit> function243 = function235;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final int i26 = $dirty5;
                        final int i27 = i22;
                        final int i28 = i23;
                        final Shape shape6 = shape5;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer4, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function244, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function244, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer5, int $changed4) {
                                Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                                ComposerKt.sourceInformation($composer5, "C358@19486L1051:OutlinedTextField.kt#uh7d8r");
                                int $dirty6 = $changed4;
                                if (($changed4 & 14) == 0) {
                                    $dirty6 |= $composer5.changedInstance(innerTextField) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 91) == 18 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-757328870, $dirty7, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:357)");
                                }
                                OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                String text = textFieldValue.getText();
                                boolean z8 = z5;
                                boolean z9 = z6;
                                VisualTransformation visualTransformation5 = visualTransformation4;
                                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                boolean z10 = z7;
                                Function2<Composer, Integer, Unit> function244 = function237;
                                Function2<Composer, Integer, Unit> function245 = function238;
                                Function2<Composer, Integer, Unit> function246 = function239;
                                Function2<Composer, Integer, Unit> function247 = function240;
                                Function2<Composer, Integer, Unit> function248 = function241;
                                Function2<Composer, Integer, Unit> function249 = function242;
                                Function2<Composer, Integer, Unit> function250 = function243;
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                final boolean z11 = z5;
                                final boolean z12 = z7;
                                final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                final TextFieldColors textFieldColors4 = textFieldColors2;
                                final Shape shape7 = shape6;
                                final int i29 = i26;
                                final int i30 = i27;
                                final int i31 = i28;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer5, 255570733, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed5) {
                                        ComposerKt.sourceInformation($composer6, "C375@20267L230:OutlinedTextField.kt#uh7d8r");
                                        if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(255570733, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:374)");
                                            }
                                            OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = OutlinedTextFieldDefaults.INSTANCE;
                                            boolean z13 = z11;
                                            boolean z14 = z12;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            TextFieldColors textFieldColors5 = textFieldColors4;
                                            Shape shape8 = shape7;
                                            int i32 = ((i29 >> 9) & 14) | 12582912 | ((i30 >> 6) & 112);
                                            int i33 = i31;
                                            outlinedTextFieldDefaults2.m1634ContainerBoxnbWgWpA(z13, z14, mutableInteractionSource5, textFieldColors5, shape8, 0.0f, 0.0f, $composer6, i32 | ((i33 << 6) & 896) | ((i33 << 3) & 7168) | ((i33 << 9) & 57344), 96);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                });
                                int i32 = i26;
                                int i33 = i27;
                                int i34 = i28;
                                outlinedTextFieldDefaults.DecorationBox(text, innerTextField, z8, z9, visualTransformation5, mutableInteractionSource3, z10, function244, function245, function246, function247, function248, function249, function250, textFieldColors3, null, composableLambda2, $composer5, (($dirty7 << 3) & 112) | ((i32 >> 3) & 896) | ((i33 >> 12) & 7168) | (i33 & 57344) | ((i34 << 15) & 458752) | ((i33 << 9) & 3670016) | ((i32 << 3) & 29360128) | ((i32 << 3) & 234881024) | ((i32 << 3) & 1879048192), ((i32 >> 27) & 14) | 14155776 | ((i33 << 3) & 112) | ((i33 << 3) & 896) | ((i33 << 3) & 7168) | ((i34 << 6) & 57344), 32768);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i29 = $dirty5;
                        int i30 = (i29 & 57344) | (i29 & 14) | (i29 & 112) | (i29 & 7168);
                        int i31 = i22;
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifierM512defaultMinSizeVpY3zN4, z2, z3, mergedTextStyle, keyboardOptions3, keyboardActions3, z4, i24, i25, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, solidColor, composableLambda, $composer4, i30 | ((i31 << 3) & 3670016) | ((i31 << 3) & 29360128) | ((i31 << 3) & 234881024) | ((i31 << 3) & 1879048192), ((i31 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i31 >> 9) & 112) | ((i23 << 9) & 7168), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            };
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer2, 1830921872, true, function236), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            interactionSource5 = interactionSource4;
            maxLines4 = maxLines3;
            isError3 = isError2;
            function215 = function214;
            function216 = function213;
            function217 = function211;
            function218 = function210;
            function219 = function29;
            function220 = function28;
            function221 = function212;
            enabled4 = enabled3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final boolean z5 = enabled4;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function237 = function221;
        final Function2<? super Composer, ? super Integer, Unit> function238 = function220;
        final Function2<? super Composer, ? super Integer, Unit> function239 = function219;
        final Function2<? super Composer, ? super Integer, Unit> function240 = function218;
        final Function2<? super Composer, ? super Integer, Unit> function241 = function217;
        final Function2<? super Composer, ? super Integer, Unit> function242 = function216;
        final Function2<? super Composer, ? super Integer, Unit> function243 = function215;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z8 = singleLine2;
        final int i26 = maxLines4;
        final int i27 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.6
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

            public final void invoke(Composer composer, int i28) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier7, z5, z6, textStyle5, function237, function238, function239, function240, function241, function242, function243, z7, visualTransformation4, keyboardOptions4, keyboardActions4, z8, i26, i27, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        boolean singleLine2;
        int maxLines2;
        int $dirty1;
        int minLines2;
        int $dirty;
        int maxLines3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        int $dirty12;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        int maxLines4;
        TextFieldColors colors2;
        Shape shape3;
        int $dirty2;
        TextStyle textStyle3;
        Function2 leadingIcon2;
        Function2 placeholder2;
        Function2 trailingIcon2;
        Function2 supportingText2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 label2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean readOnly2;
        int $dirty3;
        int $dirty13;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1575225237);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)398@20920L7,411@21580L39,412@21666L5,413@21729L8,415@21746L771:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty14 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty14 |= 24576;
            i2 = i14;
        } else if (($changed1 & 57344) == 0) {
            i2 = i14;
            $dirty14 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
        } else {
            i2 = i14;
        }
        int i15 = i & 32768;
        if (i15 != 0) {
            $dirty14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            $dirty14 |= ((i & 65536) == 0 && $composer3.changed(maxLines)) ? 1048576 : 524288;
        }
        int i16 = i & 131072;
        if (i16 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i17 = i & 262144;
        if (i17 != 0) {
            $dirty14 |= 100663296;
        } else if (($changed1 & 234881024) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            $dirty14 |= ((i & 524288) == 0 && $composer3.changed(shape)) ? 536870912 : 268435456;
        }
        if (($changed2 & 14) == 0) {
            $dirty22 |= ((i & 1048576) == 0 && $composer3.changed(colors)) ? 4 : 2;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && ($dirty22 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines4 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i4 != 0 ? true : enabled;
                boolean readOnly3 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i6 != 0 ? null : label;
                Function2 placeholder3 = i7 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i8 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i9 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i10 != 0 ? null : supportingText;
                boolean isError3 = i11 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i12 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i13 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i2 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i15 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = $dirty14 & (-3670017);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty14;
                    $dirty1 = maxLines;
                }
                minLines2 = i16 != 0 ? 1 : minLines;
                if (i17 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    maxLines3 = $dirty1;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    maxLines3 = $dirty1;
                    interactionSource2 = interactionSource;
                }
                if ((i & 524288) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 = maxLines2 & (-1879048193);
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 1048576) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-15);
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1635colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    colors2 = colors;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty22 &= -15;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label2 = label;
                placeholder2 = placeholder;
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                supportingText2 = supportingText;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty13 = $dirty14;
                $dirty2 = $dirty22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575225237, $dirty3, $dirty13, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:392)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z = enabled3;
        final boolean z2 = readOnly2;
        final TextStyle textStyle4 = textStyle3;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final Function2 function25 = supportingText2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i18 = maxLines4;
        final int i19 = minLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.8
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

            public final void invoke(Composer composer, int i20) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i18, i19, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        boolean singleLine2;
        int maxLines2;
        int $dirty1;
        int minLines2;
        int $dirty;
        int maxLines3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        int $dirty12;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        int maxLines4;
        TextFieldColors colors2;
        Shape shape3;
        int $dirty2;
        TextStyle textStyle3;
        Function2 leadingIcon2;
        Function2 placeholder2;
        Function2 trailingIcon2;
        Function2 supportingText2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 label2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean readOnly2;
        int $dirty3;
        int $dirty13;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-989817544);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)451@22886L7,464@23546L39,465@23632L5,466@23695L8,468@23712L771:OutlinedTextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty14 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty14 |= 24576;
            i2 = i14;
        } else if (($changed1 & 57344) == 0) {
            i2 = i14;
            $dirty14 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
        } else {
            i2 = i14;
        }
        int i15 = i & 32768;
        if (i15 != 0) {
            $dirty14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            $dirty14 |= ((i & 65536) == 0 && $composer3.changed(maxLines)) ? 1048576 : 524288;
        }
        int i16 = i & 131072;
        if (i16 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i17 = i & 262144;
        if (i17 != 0) {
            $dirty14 |= 100663296;
        } else if (($changed1 & 234881024) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            $dirty14 |= ((i & 524288) == 0 && $composer3.changed(shape)) ? 536870912 : 268435456;
        }
        if (($changed2 & 14) == 0) {
            $dirty22 |= ((i & 1048576) == 0 && $composer3.changed(colors)) ? 4 : 2;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && ($dirty22 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines4 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i4 != 0 ? true : enabled;
                boolean readOnly3 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty4 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i6 != 0 ? null : label;
                Function2 placeholder3 = i7 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i8 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i9 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i10 != 0 ? null : supportingText;
                boolean isError3 = i11 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i12 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i13 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i2 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i15 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = $dirty14 & (-3670017);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty14;
                    $dirty1 = maxLines;
                }
                minLines2 = i16 != 0 ? 1 : minLines;
                if (i17 != 0) {
                    $dirty = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    maxLines3 = $dirty1;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty4;
                    maxLines3 = $dirty1;
                    interactionSource2 = interactionSource;
                }
                if ((i & 524288) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 = maxLines2 & (-1879048193);
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 1048576) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    shape3 = shape2;
                    $dirty2 = $dirty22 & (-15);
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.m1635colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    maxLines4 = maxLines3;
                    colors2 = colors;
                    shape3 = shape2;
                    $dirty2 = $dirty22;
                    textStyle3 = textStyle2;
                    leadingIcon2 = leadingIcon3;
                    placeholder2 = placeholder3;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    label2 = label3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly3;
                    $dirty3 = $dirty;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty22 &= -15;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                label2 = label;
                placeholder2 = placeholder;
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                supportingText2 = supportingText;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty3 = $dirty4;
                $dirty13 = $dirty14;
                $dirty2 = $dirty22;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-989817544, $dirty3, $dirty13, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:445)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, interactionSource4, shape3, colors2, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | ($dirty3 & 458752) | ($dirty3 & 3670016) | ($dirty3 & 29360128) | ($dirty3 & 234881024) | ($dirty3 & 1879048192), (($dirty13 << 6) & 896) | 54 | (($dirty13 << 6) & 7168) | (($dirty13 << 6) & 57344) | (($dirty13 << 6) & 458752) | (($dirty13 << 6) & 3670016) | (($dirty13 << 6) & 29360128) | (($dirty13 << 6) & 234881024) | (($dirty13 << 6) & 1879048192), (($dirty13 >> 24) & 14) | (($dirty13 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z = enabled3;
        final boolean z2 = readOnly2;
        final TextStyle textStyle4 = textStyle3;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final Function2 function25 = supportingText2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i18 = maxLines4;
        final int i19 = minLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.10
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

            public final void invoke(Composer composer, int i20) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle4, function2, function22, function23, function24, function25, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i18, i19, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
            }
        });
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final boolean singleLine, final float animationProgress, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> container, final Function2<? super Composer, ? super Integer, Unit> function26, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        Function2<? super Composer, ? super Integer, Unit> function27;
        PaddingValues paddingValues2;
        int $dirty1;
        Composer $composer2;
        LayoutDirection layoutDirection;
        String str;
        float startPadding;
        float endPadding;
        String str2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer $composer3 = $composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)518@25327L239,526@25614L7,527@25626L3534:OutlinedTextField.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(textField) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty |= $composer3.changed(animationProgress) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changedInstance(onLabelMeasured) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            function27 = container;
            $dirty12 |= $composer3.changedInstance(function27) ? 32 : 16;
        } else {
            function27 = container;
        }
        if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changedInstance(function26) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            paddingValues2 = paddingValues;
            $dirty12 |= $composer3.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int $dirty13 = $dirty12;
        if (($dirty2 & 1533916891) != 306783378 || ($dirty13 & 5851) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, $dirty2, $dirty13, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:502)");
            }
            Object[] keys$iv = {onLabelMeasured, Boolean.valueOf(singleLine), Float.valueOf(animationProgress), paddingValues2};
            $composer3.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            int length = keys$iv.length;
            int i = 0;
            while (i < length) {
                int i2 = length;
                Object key$iv = keys$iv[i];
                invalid$iv |= $composer3.changed(key$iv);
                i++;
                length = i2;
            }
            Object value$iv$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, singleLine, animationProgress, paddingValues2);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            $composer3.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy measurePolicy = (OutlinedTextFieldMeasurePolicy) value$iv$iv;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume;
            int $changed$iv = ($dirty2 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) objConsume4;
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
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1116455022, "C530@25695L11,600@28180L228:OutlinedTextField.kt#uh7d8r");
            function27.invoke($composer3, Integer.valueOf(($dirty13 >> 3) & 14));
            $composer3.startReplaceableGroup(1116455047);
            ComposerKt.sourceInformation($composer3, "533@25759L219");
            if (function22 == null) {
                $dirty1 = $dirty13;
                $composer2 = $composer3;
                layoutDirection = layoutDirection2;
            } else {
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv = (Density) objConsume5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = $composer3.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) objConsume6;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                $dirty1 = $dirty13;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = $composer3.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) objConsume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier$iv);
                int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
                layoutDirection = layoutDirection2;
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
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i4 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828313841, "C537@25951L9:OutlinedTextField.kt#uh7d8r");
                function22.invoke($composer3, Integer.valueOf(($dirty2 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1116455332);
            ComposerKt.sourceInformation($composer3, "541@26045L221");
            if (function23 == null) {
                str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            } else {
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = $composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) objConsume8;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = $composer3.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) objConsume9;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = $composer3.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) objConsume10;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = ((((48 << 3) & 112) << 9) & 7168) | 6;
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
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i6 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828313554, "C545@26238L10:OutlinedTextField.kt#uh7d8r");
                function23.invoke($composer3, Integer.valueOf(($dirty2 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            LayoutDirection layoutDirection3 = layoutDirection;
            float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection3);
            float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection3);
            if (function22 != null) {
                float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv2 = Dp.m5212constructorimpl(startTextFieldPadding - other$iv);
                float minimumValue$iv = Dp.m5212constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.m5212constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
                startPadding = $this$coerceAtLeast_u2dYgX7TsA$iv;
            } else {
                startPadding = startTextFieldPadding;
            }
            if (function23 != null) {
                float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv4 = Dp.m5212constructorimpl(endTextFieldPadding - other$iv3);
                float minimumValue$iv2 = Dp.m5212constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.m5212constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                endPadding = $this$coerceAtLeast_u2dYgX7TsA$iv2;
            } else {
                endPadding = endTextFieldPadding;
            }
            $composer3.startReplaceableGroup(1116456222);
            ComposerKt.sourceInformation($composer3, "564@26933L334");
            if (function24 != null) {
                Modifier modifier$iv3 = PaddingKt.m485paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m516heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), startPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                str2 = str;
                ComposerKt.sourceInformation($composer3, str2);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11 = $composer3.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv3 = (Density) objConsume11;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume12 = $composer3.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) objConsume12;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume13 = $composer3.consume(localViewConfiguration4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) objConsume13;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf4.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i8 = ($changed$iv$iv$iv3 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i9 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828312551, "C571@27241L8:OutlinedTextField.kt#uh7d8r");
                function24.invoke($composer3, Integer.valueOf(($dirty2 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            } else {
                str2 = str;
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1116456621);
            ComposerKt.sourceInformation($composer3, "575@27332L332");
            if (function25 != null) {
                Modifier modifier$iv4 = PaddingKt.m485paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m516heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, endPadding, 0.0f, 10, null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv4, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, str2);
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume14 = $composer3.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv4 = (Density) objConsume14;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume15 = $composer3.consume(localLayoutDirection6);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) objConsume15;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume16 = $composer3.consume(localViewConfiguration5);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) objConsume16;
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifier$iv4);
                int $changed$iv$iv$iv4 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor5);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf5.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i10 = ($changed$iv$iv$iv4 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828312154, "C582@27638L8:OutlinedTextField.kt#uh7d8r");
                function25.invoke($composer3, Integer.valueOf(($dirty2 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            Modifier textPadding = PaddingKt.m485paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m516heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function24 == null ? startPadding : Dp.m5212constructorimpl(0), 0.0f, function25 == null ? endPadding : Dp.m5212constructorimpl(0), 0.0f, 10, null);
            $composer3.startReplaceableGroup(1116457331);
            ComposerKt.sourceInformation($composer3, "595@28047L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(textPadding), $composer3, Integer.valueOf(($dirty2 >> 3) & 112));
            }
            $composer3.endReplaceableGroup();
            Modifier modifier$iv5 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(textPadding);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv5 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv5 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv5, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, str2);
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume17 = $composer3.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv5 = (Density) objConsume17;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume18 = $composer3.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv5 = (LayoutDirection) objConsume18;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume19 = $composer3.consume(localViewConfiguration6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv5 = (ViewConfiguration) objConsume19;
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifier$iv5);
            int $changed$iv$iv$iv5 = ((((384 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor6);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv5 = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv5, density$iv$iv5, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv5, layoutDirection$iv$iv5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv5, viewConfiguration$iv$iv5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            function3MaterializerOf6.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv5 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i12 = ($changed$iv$iv$iv5 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            int i13 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1828311409, "C606@28383L11:OutlinedTextField.kt#uh7d8r");
            textField.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1116457749);
            ComposerKt.sourceInformation($composer3, "610@28459L237");
            if (function2 != null) {
                Modifier modifier$iv6 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m516heightInVpY3zN4$default(Modifier.INSTANCE, DpKt.m5255lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0.0f, 2, null), null, false, 3, null), "Label");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv6 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv6 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv6, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, str2);
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume20 = $composer3.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv6 = (Density) objConsume20;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume21 = $composer3.consume(localLayoutDirection8);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv6 = (LayoutDirection) objConsume21;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume22 = $composer3.consume(localViewConfiguration7);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv6 = (ViewConfiguration) objConsume22;
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifier$iv6);
                int $changed$iv$iv$iv6 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor7);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv6 = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv6, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv6, density$iv$iv6, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv6, layoutDirection$iv$iv6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv6, viewConfiguration$iv$iv6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf7.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv6 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i14 = ($changed$iv$iv$iv6 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                int i15 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828311105, "C614@28687L7:OutlinedTextField.kt#uh7d8r");
                function2.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-2058764510);
            ComposerKt.sourceInformation($composer3, "619@28822L269");
            if (function26 != null) {
                Modifier modifier$iv7 = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m516heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m1836supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv7 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv7 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv7, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, str2);
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume23 = $composer3.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv7 = (Density) objConsume23;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume24 = $composer3.consume(localLayoutDirection9);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv7 = (LayoutDirection) objConsume24;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume25 = $composer3.consume(localViewConfiguration8);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv7 = (ViewConfiguration) objConsume25;
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifier$iv7);
                int $changed$iv$iv$iv7 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor8);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv7 = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv7, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv7, density$iv$iv7, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv7, layoutDirection$iv$iv7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2588setimpl($this$Layout_u24lambda_u2d0$iv$iv7, viewConfiguration$iv$iv7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                function3MaterializerOf8.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv7 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i16 = ($changed$iv$iv$iv7 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                int i17 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1828310715, "C624@29077L12:OutlinedTextField.kt#uh7d8r");
                function26.invoke($composer3, Integer.valueOf(($dirty1 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
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
            $dirty1 = $dirty13;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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

            public final void invoke(Composer composer, int i18) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, textField, function3, function2, function22, function23, function24, function25, singleLine, animationProgress, onLabelMeasured, container, function26, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m1644calculateWidthDHJA7U0(int leadingPlaceableWidth, int trailingPlaceableWidth, int prefixPlaceableWidth, int suffixPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, boolean isLabelInMiddleSection, long constraints, float density, PaddingValues paddingValues) {
        int affixTotalWidth = prefixPlaceableWidth + suffixPlaceableWidth;
        int focusedLabelWidth = 0;
        int middleSection = Math.max(textFieldPlaceableWidth + affixTotalWidth, Math.max(placeholderPlaceableWidth + affixTotalWidth, isLabelInMiddleSection ? labelPlaceableWidth : 0));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        if (!isLabelInMiddleSection) {
            float arg0$iv = paddingValues.mo432calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
            float other$iv = paddingValues.mo433calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
            float labelHorizontalPadding = Dp.m5212constructorimpl(arg0$iv + other$iv) * density;
            focusedLabelWidth = labelPlaceableWidth + MathKt.roundToInt(labelHorizontalPadding);
        }
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5170getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-DHJA7U0, reason: not valid java name */
    public static final int m1643calculateHeightDHJA7U0(int leadingPlaceableHeight, int trailingPlaceableHeight, int prefixPlaceableHeight, int suffixPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, int supportingPlaceableHeight, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, placeholderPlaceableHeight);
        float topPadding = paddingValues.getTop() * density;
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + bottomPadding + Math.max(topPadding, labelPlaceableHeight / 2.0f);
        return Math.max(Constraints.m5169getMinHeightimpl(constraints), ComparisonsKt.maxOf(leadingPlaceableHeight, trailingPlaceableHeight, prefixPlaceableHeight, suffixPlaceableHeight, MathKt.roundToInt(middleSectionHeight)) + supportingPlaceableHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iAlign;
        float fWidthOrZero;
        Placeable.PlacementScope.m4240place70tqf50$default($this$place, containerPlaceable, IntOffset.INSTANCE.m5340getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                iAlign = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                iAlign = topPadding;
            }
            int startPositionY = iAlign;
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                fWidthOrZero = 0.0f;
            } else {
                fWidthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress);
            }
            int positionX = MathKt.roundToInt(fWidthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, textFieldPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable $labelPlaceable, Placeable placeable) {
        int iAlign;
        if ($singleLine) {
            iAlign = Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        } else {
            iAlign = topPadding;
        }
        return Math.max(iAlign, TextFieldImplKt.heightOrZero($labelPlaceable) / 2);
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1645outlineCutout12SF9DM(Modifier outlineCutout, final long labelSize, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* JADX INFO: compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float right;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float labelWidth = Size.m2777getWidthimpl(labelSize);
                if (labelWidth > 0.0f) {
                    float innerPadding = drawWithContent.mo326toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float leftLtr = drawWithContent.mo326toPx0680j_4(paddingValues.mo432calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - innerPadding;
                    float f = 2;
                    float rightLtr = leftLtr + labelWidth + (f * innerPadding);
                    float left = WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1 ? Size.m2777getWidthimpl(drawWithContent.mo3489getSizeNHjbRc()) - rightLtr : RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        right = Size.m2777getWidthimpl(drawWithContent.mo3489getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    } else {
                        right = rightLtr;
                    }
                    float labelHeight = Size.m2774getHeightimpl(labelSize);
                    ContentDrawScope $this$clipRect_u2drOu3jXo$iv = drawWithContent;
                    float top$iv = (-labelHeight) / f;
                    float bottom$iv = labelHeight / f;
                    int clipOp$iv = ClipOp.INSTANCE.m2935getDifferencertfAjoo();
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3414getSizeNHjbRc();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                    DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                    $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo3417clipRectN_I0leg(left, top$iv, right, bottom$iv, clipOp$iv);
                    drawWithContent.drawContent();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo3415setSizeuvyYCjk(previousSize$iv$iv);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
