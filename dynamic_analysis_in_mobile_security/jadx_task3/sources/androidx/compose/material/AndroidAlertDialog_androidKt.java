package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u00ad\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m957AlertDialog6oU6zVQ(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        long contentColor2;
        CornerBasedShape shape2;
        int $dirty;
        Modifier modifier2;
        long backgroundColor2;
        Modifier modifier3;
        DialogProperties properties2;
        long backgroundColor3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long contentColor3;
        Shape shape3;
        final int $dirty2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(confirmButton) ? 32 : 16;
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
            $dirty3 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function24 = function23;
        } else if (($changed & 458752) == 0) {
            function24 = function23;
            $dirty3 |= $composer3.changedInstance(function24) ? 131072 : 65536;
        } else {
            function24 = function23;
        }
        if (($changed & 3670016) == 0) {
            $dirty3 |= ((i & 64) == 0 && $composer3.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty3 |= ((i & 128) == 0 && $composer3.changed(backgroundColor)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty3 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(properties) ? 536870912 : 268435456;
        }
        if (($dirty3 & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            function28 = function2;
            function26 = function22;
            shape3 = shape;
            backgroundColor3 = backgroundColor;
            properties2 = properties;
            contentColor3 = contentColor2;
            function27 = function24;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                Function2<? super Composer, ? super Integer, Unit> function29 = i3 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function210 = i4 != 0 ? null : function22;
                Function2<? super Composer, ? super Integer, Unit> function211 = i5 != 0 ? null : function24;
                if ((i & 64) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                    $dirty3 &= -3670017;
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    $dirty = $dirty3 & (-29360129);
                    modifier2 = modifier4;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1038getSurface0d7_KjU();
                } else {
                    $dirty = $dirty3;
                    modifier2 = modifier4;
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1052contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 21) & 14);
                    $dirty &= -234881025;
                }
                if (i7 != 0) {
                    modifier3 = modifier2;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    backgroundColor3 = backgroundColor2;
                    function25 = function29;
                    function26 = function210;
                    function27 = function211;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                } else {
                    modifier3 = modifier2;
                    properties2 = properties;
                    backgroundColor3 = backgroundColor2;
                    function25 = function29;
                    function26 = function210;
                    function27 = function211;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier;
                    function26 = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    function27 = function24;
                    function25 = function2;
                    $dirty2 = (-234881025) & $dirty3;
                } else {
                    modifier3 = modifier;
                    function26 = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    function27 = function24;
                    function25 = function2;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty2, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            function28 = function25;
            $composer2 = $composer3;
            m958AlertDialogwqdebIU(onDismissRequest, ComposableLambdaKt.composableLambda($composer3, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                    ComposerKt.sourceInformation($composer4, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1849673151, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)");
                    }
                    Modifier modifier$iv = PaddingKt.m482paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5212constructorimpl(8), Dp.m5212constructorimpl(2));
                    final Function2<Composer, Integer, Unit> function212 = function25;
                    final int i8 = $dirty2;
                    final Function2<Composer, Integer, Unit> function213 = confirmButton;
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv = (6 << 3) & 112;
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
                    int i9 = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i10 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 350577093, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                    AlertDialogKt.m956AlertDialogFlowRowixp7dh8(Dp.m5212constructorimpl(8), Dp.m5212constructorimpl(12), ComposableLambdaKt.composableLambda($composer4, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                        public final void invoke(Composer $composer5, int $changed3) {
                            ComposerKt.sourceInformation($composer5, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1789213604, $changed3, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:83)");
                                }
                                Function2<Composer, Integer, Unit> function214 = function212;
                                $composer5.startReplaceableGroup(-1046483318);
                                ComposerKt.sourceInformation($composer5, "84@4101L8");
                                if (function214 != null) {
                                    function214.invoke($composer5, Integer.valueOf((i8 >> 9) & 14));
                                    Unit unit = Unit.INSTANCE;
                                }
                                $composer5.endReplaceableGroup();
                                function213.invoke($composer5, Integer.valueOf((i8 >> 3) & 14));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }), $composer4, 438);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), modifier3, function26, function27, shape3, backgroundColor3, contentColor3, properties2, $composer3, ($dirty2 & 14) | 48 | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & 57344) | (($dirty2 >> 3) & 458752) | (($dirty2 >> 3) & 3670016) | (($dirty2 >> 3) & 29360128) | (($dirty2 >> 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function212 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function213 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function214 = function27;
        final Shape shape4 = shape3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

            public final void invoke(Composer composer, int i8) {
                AndroidAlertDialog_androidKt.m957AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier5, function212, function213, function214, shape4, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m958AlertDialogwqdebIU(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        CornerBasedShape shape2;
        Modifier modifier2;
        Modifier modifier3;
        DialogProperties properties2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape3;
        long contentColor3;
        long backgroundColor3;
        final int $dirty;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer $composer2 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(buttons) ? 32 : 16;
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
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(shape)) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 8388608 : 4194304;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(properties) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function23 = function2;
            function24 = function22;
            shape3 = shape;
            properties2 = properties;
            contentColor3 = contentColor2;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                Function2<? super Composer, ? super Integer, Unit> function25 = i3 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function26 = i4 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier4;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1038getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                } else {
                    modifier2 = modifier4;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1052contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                }
                if (i7 != 0) {
                    modifier3 = modifier2;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    function23 = function25;
                    function24 = function26;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                } else {
                    modifier3 = modifier2;
                    properties2 = properties;
                    function23 = function25;
                    function24 = function26;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier;
                    function23 = function2;
                    function24 = function22;
                    shape3 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier3 = modifier;
                    function23 = function2;
                    function24 = function22;
                    shape3 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            final Modifier modifier5 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
            final Shape shape4 = shape3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            int $dirty3 = $dirty;
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
                        }
                        Function2<Composer, Integer, Unit> function29 = buttons;
                        Modifier modifier6 = modifier5;
                        Function2<Composer, Integer, Unit> function210 = function27;
                        Function2<Composer, Integer, Unit> function211 = function28;
                        Shape shape5 = shape4;
                        long j3 = j;
                        long j4 = j2;
                        int i8 = $dirty;
                        AlertDialogKt.m955AlertDialogContentWMdw5o4(function29, modifier6, function210, function211, shape5, j3, j4, $composer3, ((i8 >> 3) & 14) | ((i8 >> 3) & 112) | ((i8 >> 3) & 896) | ((i8 >> 3) & 7168) | ((i8 >> 3) & 57344) | ((i8 >> 3) & 458752) | ((i8 >> 3) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
        final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
        final Shape shape5 = shape3;
        final long j3 = backgroundColor3;
        final long j4 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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

            public final void invoke(Composer composer, int i8) {
                AndroidAlertDialog_androidKt.m958AlertDialogwqdebIU(onDismissRequest, buttons, modifier6, function29, function210, shape5, j3, j4, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
