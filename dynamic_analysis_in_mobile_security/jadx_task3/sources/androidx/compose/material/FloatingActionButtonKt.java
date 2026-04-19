package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0089\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ar\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m5212constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m5212constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m5212constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m5212constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:112:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127  */
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1112FloatingActionButtonbogVsAg(final kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, androidx.compose.material.FloatingActionButtonElevation r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 757
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.FloatingActionButtonKt.m1112FloatingActionButtonbogVsAg(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material.FloatingActionButtonElevation, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1111ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> text, final Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        MutableInteractionSource interactionSource2;
        long backgroundColor2;
        int $dirty;
        FloatingActionButtonElevation floatingActionButtonElevation;
        CornerBasedShape shape2;
        long contentColor2;
        Shape shape3;
        long contentColor3;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource interactionSource3;
        long backgroundColor3;
        final int $dirty2;
        Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Object value$iv$iv;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Composer $composer2;
        int $dirty3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation($composer3, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)151@7254L39,152@7328L6,153@7416L6,154@7460L32,155@7570L11,157@7590L849:FloatingActionButton.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changedInstance(text) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            function22 = function2;
        } else if (($changed & 7168) == 0) {
            function22 = function2;
            $dirty4 |= $composer3.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= 24576;
            interactionSource2 = interactionSource;
        } else if (($changed & 57344) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 458752) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(shape)) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer3.changed(backgroundColor2) ? 1048576 : 524288;
                $dirty4 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty4 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer3.changed(contentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                floatingActionButtonElevation = elevation;
                int i7 = $composer3.changed(floatingActionButtonElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty |= i7;
            } else {
                floatingActionButtonElevation = elevation;
            }
            $dirty |= i7;
        } else {
            floatingActionButtonElevation = elevation;
        }
        if (($dirty & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shape3 = shape;
            contentColor3 = contentColor;
            function24 = function22;
            elevation2 = floatingActionButtonElevation;
            interactionSource3 = interactionSource2;
            backgroundColor3 = backgroundColor2;
            $composer2 = $composer3;
            modifier3 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    function22 = null;
                }
                if (i4 != 0) {
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
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1036getSecondary0d7_KjU();
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1052contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 256) != 0) {
                    int i8 = $dirty & (-234881025);
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    modifier3 = modifier2;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1110elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    function23 = function22;
                    $dirty2 = i8;
                } else {
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    function23 = function22;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i9 = $dirty & (-234881025);
                    shape3 = shape;
                    contentColor3 = contentColor;
                    modifier3 = modifier2;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = i9;
                    function23 = function22;
                } else {
                    shape3 = shape;
                    contentColor3 = contentColor;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    function23 = function22;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, $dirty2, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:146)");
            }
            float f = ExtendedFabSize;
            Modifier modifierM532sizeInqDBjuR0$default = SizeKt.m532sizeInqDBjuR0$default(modifier3, f, f, 0.0f, 0.0f, 12, null);
            Function2 icon = ComposableLambdaKt.composableLambda($composer3, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer4, "C170@8058L375:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, $changed2, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:168)");
                        }
                        float startPadding = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier modifier$iv = PaddingKt.m485paddingqDBjuR0$default(Modifier.INSTANCE, startPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        int i10 = $dirty2;
                        Function2<Composer, Integer, Unit> function26 = text;
                        $composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2581constructorimpl($composer4);
                        Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i11 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326682417, "C78@3887L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i12 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1435223598, "C181@8417L6:FloatingActionButton.kt#jmzs0o");
                        $composer4.startReplaceableGroup(-1435223598);
                        ComposerKt.sourceInformation($composer4, "178@8321L6,179@8344L46");
                        if (function25 != null) {
                            function25.invoke($composer4, Integer.valueOf((i10 >> 9) & 14));
                            SpacerKt.Spacer(SizeKt.m533width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), $composer4, 6);
                        }
                        $composer4.endReplaceableGroup();
                        function26.invoke($composer4, Integer.valueOf(i10 & 14));
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
            });
            function24 = function23;
            $composer2 = $composer3;
            m1112FloatingActionButtonbogVsAg(onClick, modifierM532sizeInqDBjuR0$default, interactionSource3, shape3, backgroundColor3, contentColor3, elevation2, icon, $composer3, (($dirty2 >> 3) & 14) | 12582912 | (($dirty2 >> 6) & 896) | (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Shape shape4 = shape3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final FloatingActionButtonElevation floatingActionButtonElevation2 = elevation2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                FloatingActionButtonKt.m1111ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier4, function25, mutableInteractionSource, shape4, j, j2, floatingActionButtonElevation2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
