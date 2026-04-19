package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0083\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001ø\u0001\u0000¢\u0006\u0002\u0010>\u001am\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001am\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a)\u0010X\u001a\u00020\r*\u00020\r2\u0006\u0010Y\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a\u009a\u0001\u0010\\\u001a\u00020\u0007*\u00020]2\u0006\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020%2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010a2\u0006\u0010e\u001a\u00020a2\b\u0010f\u001a\u0004\u0018\u00010a2\b\u0010g\u001a\u0004\u0018\u00010a2\u0006\u0010h\u001a\u00020a2\b\u0010i\u001a\u0004\u0018\u00010a2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010j\u001a\u00020k2\u0006\u0010<\u001a\u00020=H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006l"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "prefixPlaceableHeight", "suffixPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-DHJA7U0", "(IIIIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-DHJA7U0", "(IIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m4873constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m4873constructorimpl(8);

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:361:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final java.lang.String r120, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instruction units count: 1763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:361:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r120, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instruction units count: 1763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0138  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void OutlinedTextField(final java.lang.String r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instruction units count: 1477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0138  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instruction units count: 1477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final boolean z, final float f, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> container, final Function2<? super Composer, ? super Integer, Unit> function26, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        PaddingValues paddingValues2;
        int i3;
        int i4;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)518@25327L239,526@25614L7,527@25626L3534:OutlinedTextField.kt#uh7d8r");
        int i5 = (i & 14) == 0 ? (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        int i6 = (i2 & 14) == 0 ? (composerStartRestartGroup.changedInstance(onLabelMeasured) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(container) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            paddingValues2 = paddingValues;
            i6 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i5 & 1533916891) != 306783378 || (i6 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i5, i6, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:502)");
            }
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues2};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            int i7 = 0;
            boolean zChanged = false;
            for (int i8 = 4; i7 < i8; i8 = 4) {
                zChanged |= composerStartRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, z, f, paddingValues2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            int i9 = ((((i5 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m2270setimpl(composerM2263constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i9 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1116455022, "C530@25695L11,600@28180L228:OutlinedTextField.kt#uh7d8r");
            container.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            composerStartRestartGroup.startReplaceableGroup(1116455047);
            ComposerKt.sourceInformation(composerStartRestartGroup, "533@25759L219");
            if (function22 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density2 = (Density) objConsume5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume6;
                i3 = i6;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierThen);
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
                Updater.m2270setimpl(composerM2263constructorimpl2, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828313841, "C537@25951L9:OutlinedTextField.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                i3 = i6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1116455332);
            ComposerKt.sourceInformation(composerStartRestartGroup, "541@26045L221");
            if (function23 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density3 = (Density) objConsume8;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) objConsume9;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume10;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierThen2);
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
                Updater.m2270setimpl(composerM2263constructorimpl3, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828313554, "C545@26238L10:OutlinedTextField.kt#uh7d8r");
                function23.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            if (function22 != null) {
                i4 = 0;
                fCalculateStartPadding = Dp.m4873constructorimpl(RangesKt.coerceAtLeast(Dp.m4873constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4873constructorimpl(0)));
            } else {
                i4 = 0;
            }
            if (function23 != null) {
                fCalculateEndPadding = Dp.m4873constructorimpl(RangesKt.coerceAtLeast(Dp.m4873constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4873constructorimpl(i4)));
            }
            composerStartRestartGroup.startReplaceableGroup(1116456222);
            ComposerKt.sourceInformation(composerStartRestartGroup, "564@26933L334");
            if (function24 != null) {
                Modifier modifierM484paddingqDBjuR0$default = PaddingKt.m484paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), fCalculateStartPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density4 = (Density) objConsume11;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) objConsume12;
                f2 = fCalculateStartPadding;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localViewConfiguration4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume13;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default);
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
                Updater.m2270setimpl(composerM2263constructorimpl4, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf4.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828312551, "C571@27241L8:OutlinedTextField.kt#uh7d8r");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                f2 = fCalculateStartPadding;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1116456621);
            ComposerKt.sourceInformation(composerStartRestartGroup, "575@27332L332");
            if (function25 != null) {
                Modifier modifierM484paddingqDBjuR0$default2 = PaddingKt.m484paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, fCalculateEndPadding, 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density5 = (Density) objConsume14;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localLayoutDirection6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection6 = (LayoutDirection) objConsume15;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localViewConfiguration5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume16;
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default2);
                f3 = fCalculateEndPadding;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2263constructorimpl5 = Updater.m2263constructorimpl(composerStartRestartGroup);
                Updater.m2270setimpl(composerM2263constructorimpl5, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2270setimpl(composerM2263constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2270setimpl(composerM2263constructorimpl5, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl5, viewConfiguration5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf5.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828312154, "C582@27638L8:OutlinedTextField.kt#uh7d8r");
                function25.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                f3 = fCalculateEndPadding;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM484paddingqDBjuR0$default3 = PaddingKt.m484paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function24 == null ? f2 : Dp.m4873constructorimpl(0), 0.0f, function25 == null ? f3 : Dp.m4873constructorimpl(0), 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(1116457331);
            ComposerKt.sourceInformation(composerStartRestartGroup, "595@28047L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PlaceholderId).then(modifierM484paddingqDBjuR0$default3), composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(modifierM484paddingqDBjuR0$default3);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density6 = (Density) objConsume17;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume18 = composerStartRestartGroup.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection7 = (LayoutDirection) objConsume18;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume19 = composerStartRestartGroup.consume(localViewConfiguration6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume19;
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierThen3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl6 = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl6, measurePolicyRememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl6, density6, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl6, layoutDirection7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl6, viewConfiguration6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf6.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828311409, "C606@28383L11:OutlinedTextField.kt#uh7d8r");
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1116457749);
            ComposerKt.sourceInformation(composerStartRestartGroup, "610@28459L237");
            if (function2 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(Modifier.INSTANCE, DpKt.m4916lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.LabelId);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume20 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density7 = (Density) objConsume20;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume21 = composerStartRestartGroup.consume(localLayoutDirection8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection8 = (LayoutDirection) objConsume21;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume22 = composerStartRestartGroup.consume(localViewConfiguration7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration7 = (ViewConfiguration) objConsume22;
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierLayoutId);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor7);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2263constructorimpl7 = Updater.m2263constructorimpl(composerStartRestartGroup);
                Updater.m2270setimpl(composerM2263constructorimpl7, measurePolicyRememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2270setimpl(composerM2263constructorimpl7, density7, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2270setimpl(composerM2263constructorimpl7, layoutDirection8, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl7, viewConfiguration7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf7.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828311105, "C614@28687L7:OutlinedTextField.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-2058764510);
            ComposerKt.sourceInformation(composerStartRestartGroup, "619@28822L269");
            if (function26 != null) {
                Modifier modifierPadding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m1518supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume23 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density8 = (Density) objConsume23;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume24 = composerStartRestartGroup.consume(localLayoutDirection9);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection9 = (LayoutDirection) objConsume24;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume25 = composerStartRestartGroup.consume(localViewConfiguration8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) objConsume25;
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierPadding);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor8);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2263constructorimpl8 = Updater.m2263constructorimpl(composerStartRestartGroup);
                Updater.m2270setimpl(composerM2263constructorimpl8, measurePolicyRememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2270setimpl(composerM2263constructorimpl8, density8, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2270setimpl(composerM2263constructorimpl8, layoutDirection9, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2270setimpl(composerM2263constructorimpl8, viewConfiguration8, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf8.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1828310715, "C624@29077L12:OutlinedTextField.kt#uh7d8r");
                function26.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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

            public final void invoke(Composer composer2, int i10) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, textField, function3, function2, function22, function23, function24, function25, z, f, onLabelMeasured, container, function26, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m1326calculateWidthDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j, float f, PaddingValues paddingValues) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, z ? i6 : 0)) + i2, Math.max(z ? 0 : i6 + MathKt.roundToInt(Dp.m4873constructorimpl(paddingValues.mo431calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo432calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f), Constraints.m4831getMinWidthimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-DHJA7U0, reason: not valid java name */
    public static final int m1325calculateHeightDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f, PaddingValues paddingValues) {
        return Math.max(Constraints.m4830getMinHeightimpl(j), ComparisonsKt.maxOf(i, i2, i3, i4, MathKt.roundToInt(Math.max(i5, i7) + (paddingValues.getBottom() * f) + Math.max(paddingValues.getTop() * f, i6 / 2.0f))) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable.PlacementScope.m3923place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m5001getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f)) + iRoundToInt2, MathHelpersKt.lerp(z ? Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), iHeightOrZero) : iRoundToInt, -(placeable6.getHeight() / 2), f), 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable6, placeable3), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i2 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable6, placeable4), 0.0f, 4, null);
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, iWidthOrZero, place$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable6, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, iWidthOrZero, place$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable6, placeable7), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable, Placeable placeable2) {
        if (z) {
            i2 = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i2, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1327outlineCutout12SF9DM(Modifier outlineCutout, final long j, final PaddingValues paddingValues) {
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
                    } catch (NoSuchFieldError unused) {
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
                float fCoerceAtLeast;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float fM2459getWidthimpl = Size.m2459getWidthimpl(j);
                if (fM2459getWidthimpl > 0.0f) {
                    float f = drawWithContent.mo325toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float f2 = drawWithContent.mo325toPx0680j_4(paddingValues.mo431calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - f;
                    float f3 = 2;
                    float fM2459getWidthimpl2 = fM2459getWidthimpl + f2 + (f * f3);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        fCoerceAtLeast = Size.m2459getWidthimpl(drawWithContent.mo3172getSizeNHjbRc()) - fM2459getWidthimpl2;
                    } else {
                        fCoerceAtLeast = RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f4 = fCoerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        fM2459getWidthimpl2 = Size.m2459getWidthimpl(drawWithContent.mo3172getSizeNHjbRc()) - RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f5 = fM2459getWidthimpl2;
                    float fM2456getHeightimpl = Size.m2456getHeightimpl(j);
                    float f6 = (-fM2456getHeightimpl) / f3;
                    float f7 = fM2456getHeightimpl / f3;
                    int iM2617getDifferencertfAjoo = ClipOp.INSTANCE.m2617getDifferencertfAjoo();
                    DrawContext drawContext = drawWithContent.getDrawContext();
                    long jMo3097getSizeNHjbRc = drawContext.mo3097getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo3100clipRectN_I0leg(f4, f6, f5, f7, iM2617getDifferencertfAjoo);
                    drawWithContent.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo3098setSizeuvyYCjk(jMo3097getSizeNHjbRc);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }
}
