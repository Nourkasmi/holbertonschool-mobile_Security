package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÄ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001ø\u0001\u0000¢\u0006\u0002\u0010;\u001a]\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a]\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010F\u001a)\u0010N\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a|\u0010R\u001a\u00020\t*\u00020S2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010\\\u001a\u00020W2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m5212constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5212constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean readOnly2;
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
        CornerBasedShape shape2;
        int $dirty12;
        boolean z;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int maxLines4;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        VisualTransformation visualTransformation2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        Modifier modifier3;
        boolean enabled3;
        int $dirty2;
        TextFieldColors colors2;
        TextStyle textStyle3;
        boolean isError2;
        Shape shape3;
        Object value$iv$iv;
        TextFieldColors colors3;
        Shape shape4;
        boolean isError3;
        Composer $composer2;
        TextStyle textStyle4;
        boolean enabled4;
        Modifier modifier4;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        int maxLines5;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        MutableInteractionSource interactionSource4;
        VisualTransformation visualTransformation3;
        Function2<? super Composer, ? super Integer, Unit> function212;
        int i2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)139@7767L7,151@8373L39,152@8447L6,153@8509L25,173@9280L24,182@9646L20,162@8837L2051:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty13 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty13 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty13 |= ((i & 32768) == 0 && $composer3.changed(maxLines)) ? 131072 : 65536;
        }
        int i15 = i & 65536;
        if (i15 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 1048576 : 524288;
        }
        int i16 = i & 131072;
        if (i16 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty13 |= ((i & 262144) == 0 && $composer3.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            $dirty13 |= ((i & 524288) == 0 && $composer3.changed(colors)) ? 536870912 : 268435456;
        }
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled4 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            function212 = function2;
            function29 = function22;
            function210 = function23;
            function211 = function24;
            isError3 = isError;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            singleLine2 = singleLine;
            maxLines5 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i4 != 0 ? true : enabled;
                readOnly2 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    textStyle2 = textStyle;
                }
                Function2<? super Composer, ? super Integer, Unit> function213 = i6 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function214 = i7 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function215 = i8 != 0 ? null : function23;
                Function2<? super Composer, ? super Integer, Unit> function216 = i9 != 0 ? null : function24;
                boolean isError4 = i10 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i11 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i12 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i13 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i14 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    maxLines2 = $dirty13 & (-458753);
                    $dirty1 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = $dirty13;
                    $dirty1 = maxLines;
                }
                minLines2 = i15 != 0 ? 1 : minLines;
                if (i16 != 0) {
                    $dirty = $dirty3;
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
                    $dirty = $dirty3;
                    maxLines3 = $dirty1;
                    interactionSource2 = interactionSource;
                }
                if ((262144 & i) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty12 = maxLines2 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = maxLines2;
                }
                if ((i & 524288) != 0) {
                    Function2<? super Composer, ? super Integer, Unit> function217 = function214;
                    z = true;
                    function25 = function217;
                    maxLines4 = maxLines3;
                    interactionSource3 = interactionSource2;
                    function26 = function215;
                    function27 = function216;
                    visualTransformation2 = visualTransformation4;
                    function28 = function213;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    colors2 = TextFieldDefaults.INSTANCE.m1239outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    textStyle3 = textStyle2;
                    isError2 = isError4;
                    shape3 = shape2;
                    $dirty13 = $dirty12 & (-1879048193);
                } else {
                    Function2<? super Composer, ? super Integer, Unit> function218 = function214;
                    z = true;
                    function25 = function218;
                    maxLines4 = maxLines3;
                    interactionSource3 = interactionSource2;
                    function26 = function215;
                    function27 = function216;
                    visualTransformation2 = visualTransformation4;
                    function28 = function213;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    colors2 = colors;
                    textStyle3 = textStyle2;
                    isError2 = isError4;
                    shape3 = shape2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    i2 = -458753;
                    $dirty3 &= -458753;
                } else {
                    i2 = -458753;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= i2;
                }
                if ((262144 & i) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                function28 = function2;
                function25 = function22;
                function26 = function23;
                function27 = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines4 = maxLines;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty2 = $dirty3;
                z = true;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-621914704, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:133)");
            }
            $composer3.startReplaceableGroup(1961395213);
            ComposerKt.sourceInformation($composer3, "*157@8686L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? z : false ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled3, $composer3, (($dirty2 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean z2 = enabled3;
            final boolean z3 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z4 = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function219 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function220 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function221 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function222 = function27;
            final TextFieldColors textFieldColors = colors2;
            final int i17 = $dirty2;
            final int i18 = $dirty13;
            final Shape shape5 = shape3;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            $composer2 = $composer3;
            textStyle4 = textStyle3;
            enabled4 = enabled3;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m512defaultMinSizeVpY3zN4(BackgroundKt.m159backgroundbw27NRU(function28 != null ? PaddingKt.m485paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled3, $composer3, (($dirty2 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1236getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1235getMinHeightD9Ej5fM()), enabled3, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty13 & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function223, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function223, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C191@10038L834:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changedInstance(innerTextField) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1710364390, $dirty5, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:190)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z5 = z2;
                        boolean z6 = z3;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean z7 = z4;
                        Function2<Composer, Integer, Unit> function223 = function219;
                        Function2<Composer, Integer, Unit> function224 = function220;
                        Function2<Composer, Integer, Unit> function225 = function221;
                        Function2<Composer, Integer, Unit> function226 = function222;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z8 = z2;
                        final boolean z9 = z4;
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                        final TextFieldColors textFieldColors3 = textFieldColors;
                        final Shape shape6 = shape5;
                        final int i19 = i17;
                        final int i20 = i18;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer4, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C205@10637L203:OutlinedTextField.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1823843281, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:204)");
                                    }
                                    TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                    boolean z10 = z8;
                                    boolean z11 = z9;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                    TextFieldColors textFieldColors4 = textFieldColors3;
                                    Shape shape7 = shape6;
                                    int i21 = ((i19 >> 9) & 14) | 12582912;
                                    int i22 = i20;
                                    textFieldDefaults2.m1233BorderBoxnbWgWpA(z10, z11, mutableInteractionSource4, textFieldColors4, shape7, 0.0f, 0.0f, $composer5, i21 | ((i22 << 3) & 112) | ((i22 >> 15) & 896) | ((i22 >> 18) & 7168) | ((i22 >> 12) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        });
                        int i21 = i17;
                        int i22 = i18;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z5, z6, visualTransformation6, mutableInteractionSource2, z7, function223, function224, function225, function226, textFieldColors2, null, composableLambda, $composer4, (i21 & 14) | (($dirty5 << 3) & 112) | ((i21 >> 3) & 896) | ((i22 >> 3) & 7168) | ((i22 << 9) & 57344) | ((i22 >> 6) & 458752) | ((i22 << 18) & 3670016) | ((i21 << 3) & 29360128) | ((i21 << 3) & 234881024) | (1879048192 & (i21 << 3)), ((i21 >> 27) & 14) | 27648 | ((i22 >> 24) & 112), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty13 << 12) & 3670016) | (($dirty13 << 12) & 29360128) | (($dirty13 << 12) & 234881024) | (($dirty13 << 12) & 1879048192), (($dirty13 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty13 & 112) | (($dirty13 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            maxLines5 = maxLines4;
            function29 = function25;
            function210 = function26;
            function211 = function27;
            interactionSource4 = interactionSource3;
            visualTransformation3 = visualTransformation2;
            function212 = function28;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z5 = enabled4;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function223 = function212;
        final Function2<? super Composer, ? super Integer, Unit> function224 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function225 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function226 = function211;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions5 = keyboardActions3;
        final boolean z8 = singleLine2;
        final int i19 = maxLines5;
        final int i20 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.4
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

            public final void invoke(Composer composer, int i21) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier6, z5, z6, textStyle5, function223, function224, function225, function226, z7, visualTransformation6, keyboardOptions5, keyboardActions5, z8, i19, i20, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        int $dirty;
        TextStyle textStyle3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        CornerBasedShape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        TextFieldColors colors2;
        TextStyle textStyle4;
        Shape shape3;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 placeholder2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        Function2 label2;
        boolean singleLine2;
        int maxLines2;
        boolean readOnly2;
        int $dirty2;
        int maxLines3;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)229@11249L7,240@11809L39,241@11883L6,242@11945L25,244@11979L416:OutlinedTextField.kt#jmzs0o");
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
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        int i12 = i & 8192;
        if (i12 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
        }
        int i13 = i & 16384;
        if (i13 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        int i14 = i & 32768;
        if (i14 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty1 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i15 = i & 65536;
        if (i15 != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty1 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty1 |= ((i & 262144) == 0 && $composer3.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty3 & 1533916891) == 306783378 && (191739611 & $dirty1) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                boolean readOnly3 = i4 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i5 != 0 ? null : label;
                Function2 placeholder3 = i6 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i7 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i8 != 0 ? null : trailingIcon;
                boolean isError3 = i9 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i11 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i12 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i13 != 0 ? false : singleLine;
                int maxLines4 = i14 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i15 != 0) {
                    $dirty = $dirty3;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    textStyle3 = textStyle2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty3;
                    textStyle3 = textStyle2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty1 &= -29360129;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.m1239outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    label2 = label3;
                    singleLine2 = singleLine3;
                    maxLines2 = maxLines4;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    maxLines3 = $dirty1 & (-234881025);
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    label2 = label3;
                    singleLine2 = singleLine3;
                    maxLines2 = maxLines4;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    maxLines3 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    maxLines3 = $dirty1 & (-234881025);
                } else {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    maxLines3 = $dirty1;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099955827, $dirty2, maxLines3, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:223)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, interactionSource4, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), (maxLines3 & 14) | 1572864 | (maxLines3 & 112) | (maxLines3 & 896) | (maxLines3 & 7168) | (maxLines3 & 57344) | (maxLines3 & 458752) | ((maxLines3 << 3) & 29360128) | ((maxLines3 << 3) & 234881024) | ((maxLines3 << 3) & 1879048192), 0);
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
        final TextStyle textStyle5 = textStyle4;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine2;
        final int i16 = maxLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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

            public final void invoke(Composer composer, int i17) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle5, function2, function22, function23, function24, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i16, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        TextFieldColors textFieldColors;
        boolean readOnly2;
        Modifier modifier2;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int $dirty1;
        KeyboardActions keyboardActions2;
        int maxLines2;
        int minLines2;
        int $dirty;
        KeyboardActions keyboardActions3;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty12;
        boolean z;
        Function2<? super Composer, ? super Integer, Unit> function26;
        KeyboardActions keyboardActions4;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        Modifier modifier3;
        int $dirty2;
        TextFieldColors colors2;
        boolean isError2;
        boolean enabled2;
        Shape shape3;
        TextStyle textStyle3;
        Object value$iv$iv;
        TextFieldColors colors3;
        Shape shape4;
        boolean isError3;
        Composer $composer2;
        TextStyle textStyle4;
        boolean enabled3;
        Modifier modifier4;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions5;
        boolean singleLine3;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        MutableInteractionSource interactionSource4;
        VisualTransformation visualTransformation3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)340@17319L7,352@17919L39,353@17997L22,354@18069L25,374@18840L24,383@19206L20,363@18397L2056:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
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
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty13 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty13 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i12 = i & 16384;
        if (i12 != 0) {
            $dirty13 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty13 |= ((i & 32768) == 0 && $composer3.changed(maxLines)) ? 131072 : 65536;
        }
        int i13 = i & 65536;
        if (i13 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 1048576 : 524288;
        }
        int i14 = i & 131072;
        if (i14 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty13 |= ((i & 262144) == 0 && $composer3.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0) {
                textFieldColors = colors;
                int i15 = $composer3.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty13 |= i15;
            } else {
                textFieldColors = colors;
            }
            $dirty13 |= i15;
        } else {
            textFieldColors = colors;
        }
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            function25 = function2;
            function29 = function22;
            function210 = function23;
            function211 = function24;
            isError3 = isError;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            keyboardActions5 = keyboardActions;
            singleLine3 = singleLine;
            maxLines2 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer2 = $composer3;
            colors3 = textFieldColors;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                readOnly2 = i4 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier2 = modifier5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    modifier2 = modifier5;
                    textStyle2 = textStyle;
                }
                function25 = i5 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function212 = i6 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function213 = i7 != 0 ? null : function23;
                Function2<? super Composer, ? super Integer, Unit> function214 = i8 != 0 ? null : function24;
                boolean isError4 = i9 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i11 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty1 = $dirty13 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty1 = $dirty13;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i12 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                minLines2 = i13 != 0 ? 1 : minLines;
                if (i14 != 0) {
                    $dirty = $dirty3;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    keyboardActions3 = keyboardActions2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty3;
                    keyboardActions3 = keyboardActions2;
                    interactionSource2 = interactionSource;
                }
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty12 = $dirty1 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 524288) != 0) {
                    Function2<? super Composer, ? super Integer, Unit> function215 = function212;
                    z = true;
                    function26 = function215;
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function27 = function213;
                    function28 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    colors2 = TextFieldDefaults.INSTANCE.m1239outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    shape3 = shape2;
                    textStyle3 = textStyle2;
                    $dirty13 = $dirty12 & (-1879048193);
                } else {
                    Function2<? super Composer, ? super Integer, Unit> function216 = function212;
                    z = true;
                    function26 = function216;
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function27 = function213;
                    function28 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                    colors2 = colors;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    shape3 = shape2;
                    textStyle3 = textStyle2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 8192) != 0) {
                    $dirty13 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                modifier3 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                function25 = function2;
                function26 = function22;
                function27 = function23;
                function28 = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions4 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty2 = $dirty3;
                z = true;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(237745923, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:334)");
            }
            $composer3.startReplaceableGroup(1961404773);
            ComposerKt.sourceInformation($composer3, "*358@18246L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? z : false ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean z2 = enabled2;
            final boolean z3 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z4 = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function217 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function218 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function219 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function220 = function28;
            final TextFieldColors textFieldColors2 = colors2;
            final int i16 = $dirty2;
            final int i17 = $dirty13;
            final Shape shape5 = shape3;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            $composer2 = $composer3;
            textStyle4 = textStyle3;
            enabled3 = enabled2;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m512defaultMinSizeVpY3zN4(BackgroundKt.m159backgroundbw27NRU(function25 != null ? PaddingKt.m485paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.8
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled2, $composer3, (($dirty2 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1236getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1235getMinHeightD9Ej5fM()), enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions4, singleLine2, maxLines2, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty13 & 14) | (($dirty13 >> 24) & 112)).getValue().m2957unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function221, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function221, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C392@19598L839:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changedInstance(innerTextField) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1001528775, $dirty5, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:391)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    boolean z5 = z2;
                    boolean z6 = z3;
                    VisualTransformation visualTransformation6 = visualTransformation5;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    boolean z7 = z4;
                    Function2<Composer, Integer, Unit> function221 = function217;
                    Function2<Composer, Integer, Unit> function222 = function218;
                    Function2<Composer, Integer, Unit> function223 = function219;
                    Function2<Composer, Integer, Unit> function224 = function220;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    final boolean z8 = z2;
                    final boolean z9 = z4;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                    final TextFieldColors textFieldColors4 = textFieldColors2;
                    final Shape shape6 = shape5;
                    final int i18 = i16;
                    final int i19 = i17;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer4, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer5, int $changed3) {
                            ComposerKt.sourceInformation($composer5, "C406@20202L203:OutlinedTextField.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-753611134, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:405)");
                                }
                                TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                boolean z10 = z8;
                                boolean z11 = z9;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                TextFieldColors textFieldColors5 = textFieldColors4;
                                Shape shape7 = shape6;
                                int i20 = ((i18 >> 9) & 14) | 12582912;
                                int i21 = i19;
                                textFieldDefaults2.m1233BorderBoxnbWgWpA(z10, z11, mutableInteractionSource4, textFieldColors5, shape7, 0.0f, 0.0f, $composer5, i20 | ((i21 << 3) & 112) | ((i21 >> 15) & 896) | ((i21 >> 18) & 7168) | ((i21 >> 12) & 57344), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    });
                    int i20 = i16;
                    int i21 = i17;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z5, z6, visualTransformation6, mutableInteractionSource2, z7, function221, function222, function223, function224, textFieldColors3, null, composableLambda, $composer4, (($dirty5 << 3) & 112) | ((i20 >> 3) & 896) | ((i21 >> 3) & 7168) | ((i21 << 9) & 57344) | ((i21 >> 6) & 458752) | ((i21 << 18) & 3670016) | ((i20 << 3) & 29360128) | ((i20 << 3) & 234881024) | (1879048192 & (i20 << 3)), ((i20 >> 27) & 14) | 27648 | ((i21 >> 24) & 112), 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty13 << 12) & 3670016) | (($dirty13 << 12) & 29360128) | (($dirty13 << 12) & 234881024) | (($dirty13 << 12) & 1879048192), (($dirty13 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty13 & 112) | (($dirty13 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions2;
            keyboardActions5 = keyboardActions4;
            singleLine3 = singleLine2;
            function29 = function26;
            function210 = function27;
            function211 = function28;
            interactionSource4 = interactionSource3;
            visualTransformation3 = visualTransformation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z5 = enabled3;
        final boolean z6 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function221 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function222 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function223 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function224 = function211;
        final boolean z7 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions6 = keyboardActions5;
        final boolean z8 = singleLine3;
        final int i18 = maxLines2;
        final int i19 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors3 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.10
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
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier6, z5, z6, textStyle5, function221, function222, function223, function224, z7, visualTransformation6, keyboardOptions5, keyboardActions6, z8, i18, i19, mutableInteractionSource2, shape6, textFieldColors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        KeyboardActions keyboardActions2;
        int maxLines2;
        int $dirty;
        TextStyle textStyle3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource4;
        TextFieldColors colors2;
        TextStyle textStyle4;
        Shape shape3;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 placeholder2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        Function2 label2;
        KeyboardActions keyboardActions3;
        boolean readOnly2;
        int $dirty2;
        int $dirty1;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)430@20830L7,441@21384L39,442@21462L22,443@21534L25,445@21568L416:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
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
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty12 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i12 = i & 16384;
        if (i12 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        int i13 = i & 32768;
        if (i13 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty12 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i14 = i & 65536;
        if (i14 != 0) {
            $dirty12 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty12 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty12 |= ((i & 262144) == 0 && $composer3.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty3 & 1533916891) == 306783378 && (191739611 & $dirty12) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                boolean readOnly3 = i4 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    modifier2 = modifier4;
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i5 != 0 ? null : label;
                Function2 placeholder3 = i6 != 0 ? null : placeholder;
                Function2 leadingIcon3 = i7 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i8 != 0 ? null : trailingIcon;
                boolean isError3 = i9 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i11 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    $dirty12 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine3 = i12 != 0 ? false : singleLine;
                maxLines2 = i13 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i14 != 0) {
                    $dirty = $dirty3;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    textStyle3 = textStyle2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty = $dirty3;
                    textStyle3 = textStyle2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty12 &= -29360129;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.m1239outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    singleLine2 = singleLine3;
                    label2 = label3;
                    keyboardActions3 = keyboardActions2;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty12 & (-234881025);
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource4 = interactionSource3;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError3;
                    visualTransformation2 = visualTransformation3;
                    placeholder2 = placeholder3;
                    keyboardOptions2 = keyboardOptions3;
                    singleLine2 = singleLine3;
                    label2 = label3;
                    keyboardActions3 = keyboardActions2;
                    readOnly2 = readOnly3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty12 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions3 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    $dirty1 = $dirty12 & (-234881025);
                } else {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    readOnly2 = readOnly;
                    textStyle4 = textStyle;
                    label2 = label;
                    placeholder2 = placeholder;
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions3 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource4 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty3;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288998816, $dirty2, $dirty1, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:424)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource4, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | ($dirty1 & 57344) | ($dirty1 & 458752) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
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
        final TextStyle textStyle5 = textStyle4;
        final Function2 function2 = label2;
        final Function2 function22 = placeholder2;
        final Function2 function23 = leadingIcon2;
        final Function2 function24 = trailingIcon2;
        final boolean z3 = isError2;
        final VisualTransformation visualTransformation4 = visualTransformation2;
        final KeyboardOptions keyboardOptions4 = keyboardOptions2;
        final KeyboardActions keyboardActions4 = keyboardActions3;
        final boolean z4 = singleLine2;
        final int i15 = maxLines2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Shape shape4 = shape3;
        final TextFieldColors textFieldColors = colors2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.12
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

            public final void invoke(Composer composer, int i16) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z, z2, textStyle5, function2, function22, function23, function24, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i15, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final boolean singleLine, final float animationProgress, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> border, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        int $dirty1;
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        float f;
        float f2;
        Function0<ComposeUiNode> function02;
        Function0<ComposeUiNode> function03;
        Function0<ComposeUiNode> function04;
        Function0<ComposeUiNode> function05;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer $composer3 = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)489@22705L239,497@22992L7,498@23004L2308:OutlinedTextField.kt#jmzs0o");
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
            $dirty |= $composer3.changed(singleLine) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(animationProgress) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onLabelMeasured) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(border) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(paddingValues) ? 4 : 2;
        }
        if ((1533916891 & $dirty) != 306783378 || ($dirty12 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, $dirty, $dirty12, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:476)");
            }
            Object[] keys$iv = {onLabelMeasured, Boolean.valueOf(singleLine), Float.valueOf(animationProgress), paddingValues};
            $dirty1 = $dirty12;
            $composer3.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            int length = keys$iv.length;
            int $changed$iv = 0;
            while ($changed$iv < length) {
                int i = length;
                Object key$iv = keys$iv[$changed$iv];
                invalid$iv |= $composer3.changed(key$iv);
                $changed$iv++;
                length = i;
            }
            Object value$iv$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, singleLine, animationProgress, paddingValues);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            $composer3.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy measurePolicy = (OutlinedTextFieldMeasurePolicy) value$iv$iv;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            int $changed$iv2 = ($dirty << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int $changed$iv$iv = (($changed$iv2 << 9) & 7168) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1169918054, "C506@23508L8,545@24956L182:OutlinedTextField.kt#jmzs0o");
            border.invoke($composer3, Integer.valueOf(($dirty >> 27) & 14));
            $composer3.startReplaceableGroup(1169918076);
            ComposerKt.sourceInformation($composer3, "509@23569L219");
            if (function22 == null) {
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
                $composer2 = $composer3;
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier$iv);
                int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function05 = constructor2;
                    $composer3.createNode(function05);
                } else {
                    function05 = constructor2;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                function3ModifierMaterializerOf2.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i3 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905297788, "C513@23761L9:OutlinedTextField.kt#jmzs0o");
                function22.invoke($composer3, Integer.valueOf(($dirty >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1169918361);
            ComposerKt.sourceInformation($composer3, "517@23855L221");
            if (function23 != null) {
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
                int $i$f$Box = ((48 >> 3) & 14) | ((48 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, $i$f$Box);
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = ((((48 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function04 = constructor3;
                    $composer3.createNode(function04);
                } else {
                    function04 = constructor3;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                function3ModifierMaterializerOf3.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905297501, "C521@24048L10:OutlinedTextField.kt#jmzs0o");
                function23.invoke($composer3, Integer.valueOf(($dirty >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function22 != null) {
                float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv2 = Dp.m5212constructorimpl(startTextFieldPadding - other$iv);
                float minimumValue$iv = Dp.m5212constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.m5212constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
                f = $this$coerceAtLeast_u2dYgX7TsA$iv;
            } else {
                f = startTextFieldPadding;
            }
            if (function23 != null) {
                float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv4 = Dp.m5212constructorimpl(endTextFieldPadding - other$iv3);
                float minimumValue$iv2 = Dp.m5212constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.m5212constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                f2 = $this$coerceAtLeast_u2dYgX7TsA$iv2;
            } else {
                f2 = endTextFieldPadding;
            }
            Modifier padding = PaddingKt.m485paddingqDBjuR0$default(companion, f, 0.0f, f2, 0.0f, 10, null);
            $composer3.startReplaceableGroup(1169919372);
            ComposerKt.sourceInformation($composer3, "542@24869L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(padding), $composer3, Integer.valueOf(($dirty >> 3) & 112));
            }
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(padding);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = ((((384 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function02 = constructor4;
                $composer3.createNode(function02);
            } else {
                function02 = constructor4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m2581constructorimpl($composer3);
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
            }
            function3ModifierMaterializerOf4.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -905296436, "C549@25113L11:OutlinedTextField.kt#jmzs0o");
            textField.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-614207951);
            ComposerKt.sourceInformation($composer3, "553@25189L54");
            if (function2 != null) {
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv4, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifier$iv4);
                int $changed$iv$iv$iv4 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function03 = constructor5;
                    $composer3.createNode(function03);
                } else {
                    function03 = constructor5;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m2581constructorimpl($composer3);
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash5);
                }
                function3ModifierMaterializerOf5.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i9 = ($changed$iv$iv$iv4 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                int i10 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905296315, "C553@25234L7:OutlinedTextField.kt#jmzs0o");
                function2.invoke($composer3, Integer.valueOf(($dirty >> 9) & 14));
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
            $dirty1 = $dirty12;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, textField, function3, function2, function22, function23, singleLine, animationProgress, onLabelMeasured, border, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1144calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int middleSection = Math.max(textFieldPlaceableWidth, Math.max(MathHelpersKt.lerp(labelPlaceableWidth, 0, animationProgress), placeholderPlaceableWidth));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        float arg0$iv = paddingValues.mo432calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        float other$iv = paddingValues.mo433calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        float labelHorizontalPadding = Dp.m5212constructorimpl(arg0$iv + other$iv) * density;
        int focusedLabelWidth = MathKt.roundToInt((labelPlaceableWidth + labelHorizontalPadding) * animationProgress);
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5170getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1143calculateHeightO3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, Math.max(placeholderPlaceableHeight, MathHelpersKt.lerp(labelPlaceableHeight, 0, animationProgress)));
        float topPadding = paddingValues.getTop() * density;
        float actualTopPadding = MathHelpersKt.lerp(topPadding, Math.max(topPadding, labelPlaceableHeight / 2.0f), animationProgress);
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + actualTopPadding + bottomPadding;
        return Math.max(Constraints.m5169getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(middleSectionHeight))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iAlign;
        int iAlign2;
        int iAlign3;
        float fWidthOrZero;
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
                iAlign3 = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                iAlign3 = topPadding;
            }
            int startPositionY = iAlign3;
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                fWidthOrZero = 0.0f;
            } else {
                fWidthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress);
            }
            int positionX = MathKt.roundToInt(fWidthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (singleLine) {
            iAlign = Alignment.INSTANCE.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            iAlign = topPadding;
        }
        int textVerticalPosition = Math.max(iAlign, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                iAlign2 = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                iAlign2 = topPadding;
            }
            int placeholderVerticalPosition = Math.max(iAlign2, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m4240place70tqf50$default($this$place, borderPlaceable, IntOffset.INSTANCE.m5340getZeronOccac(), 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1145outlineCutout12SF9DM(Modifier outlineCutout, final long labelSize, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

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
