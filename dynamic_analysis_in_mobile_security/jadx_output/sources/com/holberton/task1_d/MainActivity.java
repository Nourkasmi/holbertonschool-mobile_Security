package com.holberton.task1_d;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.holberton.task1_d.ui.theme.ThemeKt;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\bX\u008a\u008e\u0002"}, d2 = {"Lcom/holberton/task1_d/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "obfuscatedFlagData", "", "", "[Ljava/lang/Integer;", "generateString", "", "seed", "generateStringFromSeed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug", "outputMessage"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final Integer[] obfuscatedFlagData;

    public MainActivity() {
        Integer numValueOf = Integer.valueOf(ComposerKt.providerKey);
        this.obfuscatedFlagData = new Integer[]{251, 43, 59, 148, 158, 214, 190, 87, 132, 190, 65, 210, 8, 89, 1, numValueOf, 148, 246, numValueOf, 47, 150, Integer.valueOf(ComposerKt.providerValuesKey), 71, 252, 121, 27, 125, 231, 212, 60, 129, 68, 238, 143, 3, 128, 163, 135, 145, 16, 185, 44, 187, 19, 180, 78, 25, 180, 152, 130, 62, 161, 138, 48, 235, 13, 84};
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-563286151, true, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task1_d.MainActivity.onCreate.1
            {
                super(2);
            }

            /* JADX INFO: renamed from: com.holberton.task1_d.MainActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: MainActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class C01171 extends Lambda implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ MainActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01171(MainActivity mainActivity) {
                    super(2);
                    this.this$0 = mainActivity;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                private static final String invoke$lambda$1(MutableState<String> mutableState) {
                    MutableState<String> $this$getValue$iv = mutableState;
                    return $this$getValue$iv.getValue();
                }

                public final void invoke(Composer $composer, int $changed) {
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer, "C27@1042L31,29@1091L662:MainActivity.kt#5cyozj");
                    if (($changed & 11) == 2 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1289612402, $changed, -1, "com.holberton.task1_d.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:27)");
                    }
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer.endReplaceableGroup();
                    final MutableState outputMessage$delegate = (MutableState) value$iv$iv;
                    Modifier modifier$iv = PaddingKt.m481padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m5212constructorimpl(16));
                    final MainActivity mainActivity = this.this$0;
                    $composer.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer, "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv = (6 << 3) & 112;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        $composer.createNode(constructor);
                    } else {
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2581constructorimpl($composer);
                    Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m2588setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    function3ModifierMaterializerOf.invoke(SkippableUpdater.m2572boximpl(SkippableUpdater.m2573constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                    $composer.startReplaceableGroup(2058660585);
                    int i = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276693570, "C77@3893L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i2 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -389916453, "C34@1258L56,36@1336L41,38@1399L225,45@1646L41,47@1709L26:MainActivity.kt#5cyozj");
                    TextKt.m1870Text4IGK_g("Welcome to the Dynamic Analysis Exercise!", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
                    SpacerKt.Spacer(SizeKt.m514height3ABfNKs(Modifier.INSTANCE, Dp.m5212constructorimpl(16)), $composer, 6);
                    ButtonKt.Button(new Function0<Unit>() { // from class: com.holberton.task1_d.MainActivity$onCreate$1$1$1$1
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
                            outputMessage$delegate.setValue(mainActivity.generateString(0));
                        }
                    }, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m5494getLambda1$app_debug(), $composer, 805306368, 510);
                    SpacerKt.Spacer(SizeKt.m514height3ABfNKs(Modifier.INSTANCE, Dp.m5212constructorimpl(16)), $composer, 6);
                    TextKt.m1870Text4IGK_g(invoke$lambda$1(outputMessage$delegate), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C25@959L808:MainActivity.kt#5cyozj");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-563286151, $changed, -1, "com.holberton.task1_d.MainActivity.onCreate.<anonymous> (MainActivity.kt:25)");
                    }
                    ThemeKt.Task1_dTheme(false, false, ComposableLambdaKt.composableLambda($composer, 1289612402, true, new C01171(MainActivity.this)), $composer, 384, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateString(int seed) {
        String generatedString = generateStringFromSeed(seed);
        return "Generated String: " + generatedString;
    }

    private final String generateStringFromSeed(int seed) {
        int length = this.obfuscatedFlagData.length;
        Random random = new Random(seed);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int obfuscatedValue = this.obfuscatedFlagData[i].intValue();
            int randomNum = random.nextInt(256);
            int generatedCharCode = obfuscatedValue ^ randomNum;
            char generatedChar = (char) generatedCharCode;
            stringBuilder.append(generatedChar);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
