package com.holberton.task3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f44lambda1 = ComposableLambdaKt.composableLambdaInstance(1142485955, false, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task3.ComposableSingletons$MainActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142485955, i, -1, "com.holberton.task3.ComposableSingletons$MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:25)");
            }
            MainActivityKt.FibonacciDecryptionScreen(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda2 = ComposableLambdaKt.composableLambdaInstance(-1276772760, false, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task3.ComposableSingletons$MainActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1276772760, i, -1, "com.holberton.task3.ComposableSingletons$MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:21)");
                }
                SurfaceKt.m1474SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1034getBackground0d7_KjU(), 0L, 0.0f, 0.0f, null, ComposableSingletons$MainActivityKt.INSTANCE.m5153getLambda1$app_release(), composer, 12582918, 122);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f46lambda3 = ComposableLambdaKt.composableLambdaInstance(973643708, false, new Function2<Composer, Integer, Unit>() { // from class: com.holberton.task3.ComposableSingletons$MainActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(973643708, i, -1, "com.holberton.task3.ComposableSingletons$MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:20)");
                }
                MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m5154getLambda2$app_release(), composer, 3072, 7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5153getLambda1$app_release() {
        return f44lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5154getLambda2$app_release() {
        return f45lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5155getLambda3$app_release() {
        return f46lambda3;
    }
}
