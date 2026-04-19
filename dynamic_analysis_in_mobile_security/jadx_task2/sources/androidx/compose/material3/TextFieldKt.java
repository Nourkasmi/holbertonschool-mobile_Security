package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001au\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001aU\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\f*\u00020\f2\u0006\u0010V\u001a\u00020WH\u0000\u001a\u009a\u0001\u0010X\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u000206H\u0002\u001a\u0080\u0001\u0010h\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010i\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", TextFieldImplKt.TextFieldId, "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelFocused", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m4873constructorimpl(8);

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
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
    public static final void TextField(final java.lang.String r120, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instruction units count: 1763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final void TextField(final androidx.compose.ui.text.input.TextFieldValue r120, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instruction units count: 1763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final /* synthetic */ void TextField(final java.lang.String r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instruction units count: 1477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final /* synthetic */ void TextField(final androidx.compose.ui.text.input.TextFieldValue r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instruction units count: 1477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final boolean z, final float f, final Function2<? super Composer, ? super Integer, Unit> container, final Function2<? super Composer, ? super Integer, Unit> function26, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)512@24588L139,515@24775L7,516@24787L3994:TextField.kt#uh7d8r");
        if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(container) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            paddingValues2 = paddingValues;
            i4 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i3 & 1533916891) != 306783378 || (i4 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i3, i4, "androidx.compose.material3.TextFieldLayout (TextField.kt:497)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            Float fValueOf = Float.valueOf(f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(paddingValues2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
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
            int i7 = ((((i3 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m2270setimpl(composerM2263constructorimpl, textFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i7 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -95272033, "C522@25106L11,605@28102L229:TextField.kt#uh7d8r");
            container.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            composerStartRestartGroup.startReplaceableGroup(-95272008);
            ComposerKt.sourceInformation(composerStartRestartGroup, "525@25170L269");
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
                i5 = i4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219124082, "C531@25412L9:TextField.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                i5 = i4;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-95271673);
            ComposerKt.sourceInformation(composerStartRestartGroup, "535@25506L271");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219124419, "C541@25749L10:TextField.kt#uh7d8r");
                function23.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
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
                i6 = 0;
                fCalculateStartPadding = Dp.m4873constructorimpl(RangesKt.coerceAtLeast(Dp.m4873constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4873constructorimpl(0)));
            } else {
                i6 = 0;
            }
            if (function23 != null) {
                fCalculateEndPadding = Dp.m4873constructorimpl(RangesKt.coerceAtLeast(Dp.m4873constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4873constructorimpl(i6)));
            }
            composerStartRestartGroup.startReplaceableGroup(-95270733);
            ComposerKt.sourceInformation(composerStartRestartGroup, "560@26444L334");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219125422, "C567@26752L8:TextField.kt#uh7d8r");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-95270334);
            ComposerKt.sourceInformation(composerStartRestartGroup, "571@26843L332");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219125819, "C578@27149L8:TextField.kt#uh7d8r");
                function25.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-95269936);
            ComposerKt.sourceInformation(composerStartRestartGroup, "583@27240L347");
            if (function2 != null) {
                f3 = fCalculateStartPadding;
                Modifier modifierM484paddingqDBjuR0$default3 = PaddingKt.m484paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LabelId), DpKt.m4916lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), f3, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
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
                f2 = fCalculateEndPadding;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume19 = composerStartRestartGroup.consume(localViewConfiguration6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume19;
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM484paddingqDBjuR0$default3);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219126248, "C589@27578L7:TextField.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                f2 = fCalculateEndPadding;
                f3 = fCalculateStartPadding;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM484paddingqDBjuR0$default4 = PaddingKt.m484paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m515heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function24 == null ? f3 : Dp.m4873constructorimpl(0), 0.0f, function25 == null ? f2 : Dp.m4873constructorimpl(0), 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(-95269212);
            ComposerKt.sourceInformation(composerStartRestartGroup, "601@27970L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PlaceholderId).then(modifierM484paddingqDBjuR0$default4), composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(modifierM484paddingqDBjuR0$default4);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierThen3);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219126976, "C611@28306L11:TextField.kt#uh7d8r");
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(243142693);
            ComposerKt.sourceInformation(composerStartRestartGroup, "616@28443L269");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1219127368, "C621@28698L12:TextField.kt#uh7d8r");
                function26.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextFieldLayout.2
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
                TextFieldKt.TextFieldLayout(modifier, textField, function2, function3, function22, function23, function24, function25, z, f, container, function26, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m1549calculateWidthyeHjK3Y(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, i6)) + i2, Constraints.m4831getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m1548calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, long j, float f, PaddingValues paddingValues) {
        float fM4873constructorimpl;
        int iMax;
        boolean z2 = i2 > 0;
        if (!z2 || z) {
            fM4873constructorimpl = Dp.m4873constructorimpl(paddingValues.getTop() + paddingValues.getBottom());
        } else {
            fM4873constructorimpl = Dp.m4873constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2);
        }
        float f2 = f * fM4873constructorimpl;
        if (z2 && z) {
            f2 += i2;
            iMax = Math.max(i, i7);
        } else {
            iMax = Math.max(i2, Math.max(i, i7));
        }
        return Math.max(Constraints.m4830getMinHeightimpl(j), ComparisonsKt.maxOf(i3, i4, i5, i6, MathKt.roundToInt(f2 + iMax)) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z, int i3, int i4, float f, float f2) {
        int iRoundToInt;
        Placeable.PlacementScope.m3923place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m5001getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), iHeightOrZero);
            } else {
                iRoundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), iRoundToInt - MathKt.roundToInt((iRoundToInt - i3) * f), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i4, 0.0f, 4, null);
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iWidthOrZero, i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iWidthOrZero, i4, 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z, float f, PaddingValues paddingValues) {
        Placeable.PlacementScope.m3923place70tqf50$default(placementScope, placeable7, IntOffset.INSTANCE.m5001getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable8);
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable5), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable6), 0.0f, 4, null);
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable3) + TextFieldImplKt.widthOrZero(placeable5);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iWidthOrZero, placeWithoutLabel$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iWidthOrZero, placeWithoutLabel$calculateVerticalPosition(z, iHeightOrZero, iRoundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable) {
        return z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float width = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt.drawIndicatorLine.1
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
                drawWithContent.drawContent();
                if (Dp.m4878equalsimpl0(width, Dp.INSTANCE.m4891getHairlineD9Ej5fM())) {
                    return;
                }
                float density = width * drawWithContent.getDensity();
                float fM2456getHeightimpl = Size.m2456getHeightimpl(drawWithContent.mo3172getSizeNHjbRc()) - (density / 2);
                DrawScope.m3158drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, fM2456getHeightimpl), OffsetKt.Offset(Size.m2459getWidthimpl(drawWithContent.mo3172getSizeNHjbRc()), fM2456getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }
}
