package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jç\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ=\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJç\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ=\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ=\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010XJM\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m5212constructorimpl(56);
    private static final float MinWidth = Dp.m5212constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m5212constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m5212constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1235getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1236getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1117199624, "C215@7733L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:215)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return cornerBasedShapeCopy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1899109048, "C224@8035L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:224)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return small;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1237getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1234getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1229indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedBorderThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedBorderThickness;
        }
        return textFieldDefaults.m1238indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1238indicatorLinegv0btCI(Modifier indicatorLine, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        Intrinsics.checkNotNullParameter(indicatorLine, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
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
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", Dp.m5210boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", Dp.m5210boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1398930845);
                ComposerKt.sourceInformation($composer, "C281@10437L217:TextFieldDefaults.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, $changed, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:280)");
                }
                State stroke = TextFieldDefaultsKt.m1245animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1233BorderBoxnbWgWpA(final boolean r22, final boolean r23, final androidx.compose.foundation.interaction.InteractionSource r24, final androidx.compose.material.TextFieldColors r25, androidx.compose.ui.graphics.Shape r26, float r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.m1233BorderBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1231textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1242textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1242textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m477PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1232textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1243textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1243textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m477PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1230outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1240outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1240outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m477PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1241textFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        $composer.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)377@14111L7,377@14142L7,378@14215L8,379@14273L6,380@14366L6,381@14430L6,383@14509L6,383@14550L4,385@14624L6,386@14776L8,387@14838L6,389@14912L6,390@15041L8,393@15170L6,394@15301L8,395@15366L6,397@15441L6,397@15482L4,398@15540L6,398@15575L6,399@15658L8,400@15716L6,401@15778L6,401@15813L6,402@15899L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM2957unboximpl = ((Color) objConsume).m2957unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m2945copywmQWz5c(jM2957unboximpl, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM2957unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m2953getRedimpl(jM2957unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM2957unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM2957unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            long j = textColor2;
            disabledTextColor2 = Color.m2945copywmQWz5c(j, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) != 0) {
            long jM1033getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            backgroundColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU) : 0.0f);
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1034getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU();
            focusedIndicatorColor2 = Color.m2945copywmQWz5c(jM1034getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1034getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1034getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1034getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1034getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            long jM1033getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            unfocusedIndicatorColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU2) : 0.42f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU2) : 0.0f);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            long j2 = unfocusedIndicatorColor2;
            disabledIndicatorColor2 = Color.m2945copywmQWz5c(j2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j2) : 0.0f);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            long jM1033getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU3) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long j3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m2945copywmQWz5c(j3, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1033getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU4) : 0.54f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU4) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long j4 = trailingIconColor2;
            disabledTrailingIconColor2 = Color.m2945copywmQWz5c(j4, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j4) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j4) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1034getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m2945copywmQWz5c(jM1034getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1034getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1034getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1034getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1034getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1033getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU5) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long j5 = unfocusedLabelColor2;
            disabledLabelColor2 = Color.m2945copywmQWz5c(j5, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j5) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j5) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1033getOnSurface0d7_KjU6 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            placeholderColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU6, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU6) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU6) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU6) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU6) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long j6 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m2945copywmQWz5c(j6, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j6) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j6) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j6) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:376)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1239outlinedTextFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        $composer.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)435@17427L7,435@17458L7,436@17531L8,438@17637L6,439@17701L6,441@17777L6,441@17818L4,443@17889L6,443@17932L8,444@18027L8,445@18086L6,447@18160L6,448@18289L8,451@18418L6,452@18549L8,453@18614L6,455@18689L6,455@18730L4,456@18788L6,456@18823L6,457@18906L8,458@18964L6,459@19026L6,459@19061L6,460@19147L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM2957unboximpl = ((Color) objConsume).m2957unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m2945copywmQWz5c(jM2957unboximpl, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM2957unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m2953getRedimpl(jM2957unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM2957unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM2957unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            long j = textColor2;
            disabledTextColor2 = Color.m2945copywmQWz5c(j, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m2982getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1034getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU();
            focusedBorderColor2 = Color.m2945copywmQWz5c(jM1034getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1034getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1034getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1034getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1034getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            long jM1033getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            unfocusedBorderColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU) : 0.0f);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            long j2 = unfocusedBorderColor2;
            disabledBorderColor2 = Color.m2945copywmQWz5c(j2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j2) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            long jM1033getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU2) : 0.54f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU2) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long j3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m2945copywmQWz5c(j3, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1033getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU3) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long j4 = trailingIconColor2;
            disabledTrailingIconColor2 = Color.m2945copywmQWz5c(j4, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j4) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j4) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1034getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1034getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m2945copywmQWz5c(jM1034getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1034getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1034getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1034getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1034getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1033getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU4) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU4) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long j5 = unfocusedLabelColor2;
            disabledLabelColor2 = Color.m2945copywmQWz5c(j5, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j5) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j5) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1028getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1033getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1033getOnSurface0d7_KjU();
            placeholderColor2 = Color.m2945copywmQWz5c(jM1033getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m2949getAlphaimpl(jM1033getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(jM1033getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(jM1033getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(jM1033getOnSurface0d7_KjU5) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long j6 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m2945copywmQWz5c(j6, (14 & 1) != 0 ? Color.m2949getAlphaimpl(j6) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m2953getRedimpl(j6) : 0.0f, (14 & 4) != 0 ? Color.m2952getGreenimpl(j6) : 0.0f, (14 & 8) != 0 ? Color.m2950getBlueimpl(j6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:434)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void TextFieldDecorationBox(final java.lang.String r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final boolean r70, final boolean r71, final androidx.compose.ui.text.input.VisualTransformation r72, final androidx.compose.foundation.interaction.InteractionSource r73, boolean r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, androidx.compose.material.TextFieldColors r79, androidx.compose.foundation.layout.PaddingValues r80, androidx.compose.runtime.Composer r81, final int r82, final int r83, final int r84) {
        /*
            Method dump skipped, instruction units count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OutlinedTextFieldDecorationBox(final java.lang.String r67, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final boolean r69, final boolean r70, final androidx.compose.ui.text.input.VisualTransformation r71, final androidx.compose.foundation.interaction.InteractionSource r72, boolean r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, androidx.compose.material.TextFieldColors r78, androidx.compose.foundation.layout.PaddingValues r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, androidx.compose.runtime.Composer r81, final int r82, final int r83, final int r84) {
        /*
            Method dump skipped, instruction units count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
