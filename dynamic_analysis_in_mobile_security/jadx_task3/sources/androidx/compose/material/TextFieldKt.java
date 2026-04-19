package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.Placeable;
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
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u009a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001a]\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aE\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m5212constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m5212constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m5212constructorimpl(4);

    public static final void TextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        CornerBasedShape shape2;
        int $dirty12;
        KeyboardActions keyboardActions4;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean singleLine2;
        int $dirty2;
        Modifier modifier3;
        TextFieldColors colors2;
        Shape shape3;
        boolean isError2;
        boolean enabled2;
        int $dirty13;
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
        Composer $composer3 = $composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)164@8542L7,176@9142L39,178@9224L6,179@9349L17,191@9767L24,201@10205L20,188@9669L1571:TextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty14 = $changed1;
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
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty14 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i12 = i & 16384;
        if (i12 != 0) {
            $dirty14 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty14 |= ((i & 32768) == 0 && $composer3.changed(maxLines)) ? 131072 : 65536;
        }
        int i13 = i & 65536;
        if (i13 != 0) {
            $dirty14 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 1048576 : 524288;
        }
        int i14 = i & 131072;
        if (i14 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty14 |= ((i & 262144) == 0 && $composer3.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0) {
                textFieldColors = colors;
                int i15 = $composer3.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty14 |= i15;
            } else {
                textFieldColors = colors;
            }
            $dirty14 |= i15;
        } else {
            textFieldColors = colors;
        }
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && $composer3.getSkipping()) {
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
                    $dirty1 = $dirty14 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty1 = $dirty14;
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
                    shape2 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    $dirty12 = $dirty1 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 524288) != 0) {
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function26 = function213;
                    function27 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    function28 = function212;
                    singleLine2 = singleLine4;
                    colors2 = TextFieldDefaults.INSTANCE.m1241textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    $dirty2 = $dirty12 & (-1879048193);
                    modifier3 = modifier2;
                    shape3 = shape2;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    $dirty13 = $dirty;
                    textStyle3 = textStyle2;
                } else {
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function26 = function213;
                    function27 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    function28 = function212;
                    singleLine2 = singleLine4;
                    $dirty2 = $dirty12;
                    modifier3 = modifier2;
                    colors2 = colors;
                    shape3 = shape2;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    $dirty13 = $dirty;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 8192) != 0) {
                    $dirty14 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty14 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty14 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                modifier3 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                function25 = function2;
                function28 = function22;
                function26 = function23;
                function27 = function24;
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
                int i16 = $dirty14;
                $dirty13 = $dirty3;
                $dirty2 = i16;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1504264404, $dirty13, $dirty2, "androidx.compose.material.TextField (TextField.kt:158)");
            }
            $composer3.startReplaceableGroup(-833027253);
            ComposerKt.sourceInformation($composer3, "*183@9518L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled2, $composer3, (($dirty13 >> 9) & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean z = enabled2;
            final boolean z2 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z3 = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function216 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function217 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function218 = function27;
            final TextFieldColors textFieldColors2 = colors2;
            final int i17 = $dirty13;
            final int i18 = $dirty2;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            $composer2 = $composer3;
            textStyle4 = textStyle3;
            enabled3 = enabled2;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m512defaultMinSizeVpY3zN4(TextFieldDefaults.m1229indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m159backgroundbw27NRU(modifier3, colors2.backgroundColor(enabled2, $composer3, (($dirty13 >> 9) & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl(), shape3), z, isError2, interactionSource3, colors2, 0.0f, 0.0f, 48, null), TextFieldDefaults.INSTANCE.m1236getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1235getMinHeightD9Ej5fM()), enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions4, singleLine2, maxLines2, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty2 & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C211@10686L538:TextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changedInstance(innerTextField) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(989834338, $dirty5, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:209)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z4 = z;
                        boolean z5 = z2;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean z6 = z3;
                        Function2<Composer, Integer, Unit> function219 = function215;
                        Function2<Composer, Integer, Unit> function220 = function216;
                        Function2<Composer, Integer, Unit> function221 = function217;
                        Function2<Composer, Integer, Unit> function222 = function218;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i19 = i17;
                        int i20 = i18;
                        textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z4, z5, visualTransformation6, mutableInteractionSource2, z6, function219, function220, function221, function222, textFieldColors3, null, $composer4, ((i20 >> 3) & 7168) | (i19 & 14) | (($dirty5 << 3) & 112) | ((i19 >> 3) & 896) | ((i20 << 9) & 57344) | ((i20 >> 6) & 458752) | ((i20 << 18) & 3670016) | ((i19 << 3) & 29360128) | ((i19 << 3) & 234881024) | ((i19 << 3) & 1879048192), ((i19 >> 27) & 14) | 3072 | ((i20 >> 24) & 112), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty13 & 14) | ($dirty13 & 112) | ($dirty13 & 7168) | ($dirty13 & 57344) | (($dirty2 << 12) & 3670016) | (($dirty2 << 12) & 29360128) | (($dirty2 << 12) & 234881024) | (($dirty2 << 12) & 1879048192), (($dirty2 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty2 & 112) | (($dirty2 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions2;
            keyboardActions5 = keyboardActions4;
            singleLine3 = singleLine2;
            function29 = function28;
            function210 = function26;
            function211 = function27;
            interactionSource4 = interactionSource3;
            visualTransformation3 = visualTransformation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z4 = enabled3;
        final boolean z5 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function219 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function220 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function221 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function222 = function211;
        final boolean z6 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions6 = keyboardActions5;
        final boolean z7 = singleLine3;
        final int i19 = maxLines2;
        final int i20 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
        final Shape shape5 = shape4;
        final TextFieldColors textFieldColors3 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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
                TextFieldKt.TextField(value, onValueChange, modifier6, z4, z5, textStyle5, function219, function220, function221, function222, z6, visualTransformation6, keyboardOptions5, keyboardActions6, z7, i19, i20, mutableInteractionSource2, shape5, textFieldColors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        TextStyle textStyle2;
        KeyboardActions keyboardActions2;
        int maxLines2;
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
        Composer $composer3 = $composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11593L7,251@12147L39,253@12229L6,254@12354L17,256@12380L408:TextField.kt#jmzs0o");
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
                    shape2 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
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
                    colors2 = TextFieldDefaults.INSTANCE.m1241textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
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
                ComposerKt.traceEventStart(-1690895095, $dirty2, $dirty1, "androidx.compose.material.TextField (TextField.kt:234)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource4, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | ($dirty1 & 57344) | ($dirty1 & 458752) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
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
                TextFieldKt.TextField(value, onValueChange, modifier5, z, z2, textStyle5, function2, function22, function23, function24, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i15, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        KeyboardActions keyboardActions4;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean singleLine2;
        int $dirty2;
        Modifier modifier3;
        TextFieldColors colors2;
        Shape shape3;
        boolean isError2;
        boolean enabled2;
        int $dirty13;
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
        Composer $composer3 = $composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)353@17674L7,365@18274L39,366@18352L14,367@18416L17,379@18834L24,389@19272L20,376@18736L1576:TextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty14 = $changed1;
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
            $dirty14 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty14 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty14 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty14 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty14 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty14 |= $composer3.changed(keyboardOptions) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            $dirty14 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i12 = i & 16384;
        if (i12 != 0) {
            $dirty14 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty14 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty14 |= ((i & 32768) == 0 && $composer3.changed(maxLines)) ? 131072 : 65536;
        }
        int i13 = i & 65536;
        if (i13 != 0) {
            $dirty14 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty14 |= $composer3.changed(minLines) ? 1048576 : 524288;
        }
        int i14 = i & 131072;
        if (i14 != 0) {
            $dirty14 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty14 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty14 |= ((i & 262144) == 0 && $composer3.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0) {
                textFieldColors = colors;
                int i15 = $composer3.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty14 |= i15;
            } else {
                textFieldColors = colors;
            }
            $dirty14 |= i15;
        } else {
            textFieldColors = colors;
        }
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty14) == 306783378 && $composer3.getSkipping()) {
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
                    $dirty1 = $dirty14 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty1 = $dirty14;
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
                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape($composer3, 6);
                    $dirty12 = $dirty1 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 524288) != 0) {
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function26 = function213;
                    function27 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    function28 = function212;
                    singleLine2 = singleLine4;
                    colors2 = TextFieldDefaults.INSTANCE.m1241textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    $dirty2 = $dirty12 & (-1879048193);
                    modifier3 = modifier2;
                    shape3 = shape2;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    $dirty13 = $dirty;
                    textStyle3 = textStyle2;
                } else {
                    keyboardActions4 = keyboardActions3;
                    interactionSource3 = interactionSource2;
                    function26 = function213;
                    function27 = function214;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    function28 = function212;
                    singleLine2 = singleLine4;
                    $dirty2 = $dirty12;
                    modifier3 = modifier2;
                    colors2 = colors;
                    shape3 = shape2;
                    isError2 = isError4;
                    enabled2 = enabled4;
                    $dirty13 = $dirty;
                    textStyle3 = textStyle2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 8192) != 0) {
                    $dirty14 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty14 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty14 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty14 &= -1879048193;
                }
                modifier3 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                function25 = function2;
                function28 = function22;
                function26 = function23;
                function27 = function24;
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
                int i16 = $dirty14;
                $dirty13 = $dirty3;
                $dirty2 = i16;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-359119489, $dirty13, $dirty2, "androidx.compose.material.TextField (TextField.kt:347)");
            }
            $composer3.startReplaceableGroup(-833018186);
            ComposerKt.sourceInformation($composer3, "*371@18585L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m4742getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2983getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled2, $composer3, (($dirty13 >> 9) & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean z = enabled2;
            final boolean z2 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z3 = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function216 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function217 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function218 = function27;
            final TextFieldColors textFieldColors2 = colors2;
            final int i17 = $dirty13;
            final int i18 = $dirty2;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            $composer2 = $composer3;
            textStyle4 = textStyle3;
            enabled3 = enabled2;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m512defaultMinSizeVpY3zN4(TextFieldDefaults.m1229indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m159backgroundbw27NRU(modifier3, colors2.backgroundColor(enabled2, $composer3, (($dirty13 >> 9) & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl(), shape3), z, isError2, interactionSource3, colors2, 0.0f, 0.0f, 48, null), TextFieldDefaults.INSTANCE.m1236getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1235getMinHeightD9Ej5fM()), enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions4, singleLine2, maxLines2, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty2 & 14) | (($dirty2 >> 24) & 112)).getValue().m2957unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C399@19753L543:TextField.kt#jmzs0o");
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
                        ComposerKt.traceEventStart(-126640971, $dirty5, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:397)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    boolean z4 = z;
                    boolean z5 = z2;
                    VisualTransformation visualTransformation6 = visualTransformation5;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    boolean z6 = z3;
                    Function2<Composer, Integer, Unit> function219 = function215;
                    Function2<Composer, Integer, Unit> function220 = function216;
                    Function2<Composer, Integer, Unit> function221 = function217;
                    Function2<Composer, Integer, Unit> function222 = function218;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    int i19 = ($dirty5 << 3) & 112;
                    int i20 = i17;
                    int i21 = i18;
                    textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z4, z5, visualTransformation6, mutableInteractionSource2, z6, function219, function220, function221, function222, textFieldColors3, null, $composer4, ((i21 >> 3) & 7168) | i19 | ((i20 >> 3) & 896) | ((i21 << 9) & 57344) | ((i21 >> 6) & 458752) | ((i21 << 18) & 3670016) | ((i20 << 3) & 29360128) | ((i20 << 3) & 234881024) | ((i20 << 3) & 1879048192), ((i20 >> 27) & 14) | 3072 | ((i21 >> 24) & 112), 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty13 & 14) | ($dirty13 & 112) | ($dirty13 & 7168) | ($dirty13 & 57344) | (($dirty2 << 12) & 3670016) | (($dirty2 << 12) & 29360128) | (($dirty2 << 12) & 234881024) | (($dirty2 << 12) & 1879048192), (($dirty2 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty2 & 112) | (($dirty2 >> 12) & 7168), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions3 = keyboardOptions2;
            keyboardActions5 = keyboardActions4;
            singleLine3 = singleLine2;
            function29 = function28;
            function210 = function26;
            function211 = function27;
            interactionSource4 = interactionSource3;
            visualTransformation3 = visualTransformation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z4 = enabled3;
        final boolean z5 = readOnly2;
        final TextStyle textStyle5 = textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function219 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function220 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function221 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function222 = function211;
        final boolean z6 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions6 = keyboardActions5;
        final boolean z7 = singleLine3;
        final int i19 = maxLines2;
        final int i20 = minLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
        final Shape shape5 = shape4;
        final TextFieldColors textFieldColors3 = colors3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.8
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
                TextFieldKt.TextField(value, onValueChange, modifier6, z4, z5, textStyle5, function219, function220, function221, function222, z6, visualTransformation6, keyboardOptions5, keyboardActions6, z7, i19, i20, mutableInteractionSource2, shape5, textFieldColors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)428@20681L7,439@21235L39,440@21313L14,441@21377L17,443@21403L408:TextField.kt#jmzs0o");
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
                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape($composer3, 6);
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
                    colors2 = TextFieldDefaults.INSTANCE.m1241textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
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
                ComposerKt.traceEventStart(-1576622884, $dirty2, $dirty1, "androidx.compose.material.TextField (TextField.kt:422)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource4, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | ($dirty1 & 57344) | ($dirty1 & 458752) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.10
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
                TextFieldKt.TextField(value, onValueChange, modifier5, z, z2, textStyle5, function2, function22, function23, function24, z3, visualTransformation4, keyboardOptions4, keyboardActions4, z4, i15, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextFieldLayout(final androidx.compose.ui.Modifier r52, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, final boolean r58, final float r59, final androidx.compose.foundation.layout.PaddingValues r60, androidx.compose.runtime.Composer r61, final int r62) {
        /*
            Method dump skipped, instruction units count: 2213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1253calculateWidthVsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int middleSection = Math.max(textFieldWidth, Math.max(labelWidth, placeholderWidth));
        int wrappedWidth = leadingWidth + middleSection + trailingWidth;
        return Math.max(wrappedWidth, Constraints.m5170getMinWidthimpl(constraints));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1252calculateHeightO3s9Psw(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, long constraints, float density, PaddingValues paddingValues) {
        float paddingToLabel = TextFieldTopPadding * density;
        float topPaddingValue = paddingValues.getTop() * density;
        float bottomPaddingValue = paddingValues.getBottom() * density;
        int inputFieldHeight = Math.max(textFieldHeight, placeholderHeight);
        float middleSectionHeight = hasLabel ? labelBaseline + paddingToLabel + inputFieldHeight + bottomPaddingValue : inputFieldHeight + topPaddingValue + bottomPaddingValue;
        return Math.max(MathKt.roundToInt(middleSectionHeight), Math.max(Math.max(leadingHeight, trailingHeight), Constraints.m5169getMinHeightimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int height, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int iRoundToInt;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                iRoundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = iRoundToInt;
            int distance = startPosition - labelEndPosition;
            int positionY = startPosition - MathKt.roundToInt(distance * animationProgress);
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, labelPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), positionY, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        int textVerticalPosition;
        int placeholderVerticalPosition;
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (singleLine) {
            textVerticalPosition = Alignment.INSTANCE.getCenterVertically().align(textPlaceable.getHeight(), height);
        } else {
            textVerticalPosition = topPadding;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                placeholderVerticalPosition = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter($this$drawIndicatorLine, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float strokeWidthDp = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt.drawIndicatorLine.1
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
                if (Dp.m5217equalsimpl0(strokeWidthDp, Dp.INSTANCE.m5230getHairlineD9Ej5fM())) {
                    return;
                }
                float strokeWidth = strokeWidthDp * drawWithContent.getDensity();
                float y = Size.m2774getHeightimpl(drawWithContent.mo3489getSizeNHjbRc()) - (strokeWidth / 2);
                DrawScope.m3475drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m2777getWidthimpl(drawWithContent.mo3489getSizeNHjbRc()), y), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
