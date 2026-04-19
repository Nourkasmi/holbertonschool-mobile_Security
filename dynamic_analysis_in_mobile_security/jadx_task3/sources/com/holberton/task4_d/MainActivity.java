package com.holberton.task4_d;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.holberton.task4_d.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/holberton/task4_d/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "<set-?>", "", "decodedFlag", "getDecodedFlag", "()Ljava/lang/String;", "setDecodedFlag", "(Ljava/lang/String;)V", "decodedFlag$delegate", "Landroidx/compose/runtime/MutableState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "retrieveEncryptedData", "onComplete", "Lkotlin/Function0;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: decodedFlag$delegate, reason: from kotlin metadata */
    private final MutableState decodedFlag = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDecodedFlag() {
        State $this$getValue$iv = this.decodedFlag;
        return (String) $this$getValue$iv.getValue();
    }

    private final void setDecodedFlag(String str) {
        MutableState $this$setValue$iv = this.decodedFlag;
        $this$setValue$iv.setValue(str);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-764306410, true, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task4_d.MainActivity.onCreate.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C35@1321L347:MainActivity.kt#5cyr7m");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-764306410, $changed, -1, "com.holberton.task4_d.MainActivity.onCreate.<anonymous> (MainActivity.kt:35)");
                    }
                    final MainActivity mainActivity = MainActivity.this;
                    ThemeKt.Task4_dTheme(false, false, ComposableLambdaKt.composableLambda($composer, -419059758, true, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task4_d.MainActivity.onCreate.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C39@1541L11,37@1435L219:MainActivity.kt#5cyr7m");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-419059758, $changed2, -1, "com.holberton.task4_d.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:37)");
                                }
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                long jM1352getBackground0d7_KjU = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).m1352getBackground0d7_KjU();
                                final MainActivity mainActivity2 = mainActivity;
                                SurfaceKt.m1792SurfaceT9BRK9s(modifierFillMaxSize$default, null, jM1352getBackground0d7_KjU, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer2, 1563516375, true, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task4_d.MainActivity.onCreate.1.1.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed3) {
                                        ComposerKt.sourceInformation($composer3, "C41@1604L32:MainActivity.kt#5cyr7m");
                                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1563516375, $changed3, -1, "com.holberton.task4_d.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:41)");
                                            }
                                            MainActivityKt.Greeting("Android", mainActivity2.getDecodedFlag(), null, $composer3, 6, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }), $composer2, 12582918, 122);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), $composer, 384, 3);
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

    /* JADX INFO: renamed from: com.holberton.task4_d.MainActivity$retrieveEncryptedData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.holberton.task4_d.MainActivity$retrieveEncryptedData$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05651(Function0<Unit> function0, Continuation<? super C05651> continuation) {
            super(2, continuation);
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05651(this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$onComplete.invoke();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void retrieveEncryptedData(Function0<Unit> onComplete) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05651(onComplete, null), 3, null);
    }
}
