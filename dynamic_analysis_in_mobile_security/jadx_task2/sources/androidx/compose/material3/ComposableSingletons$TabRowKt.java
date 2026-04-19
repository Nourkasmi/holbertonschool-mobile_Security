package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$TabRowKt {
    public static final ComposableSingletons$TabRowKt INSTANCE = new ComposableSingletons$TabRowKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f32lambda1 = ComposableLambdaKt.composableLambdaInstance(-711844679, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$TabRowKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C138@6786L9:TabRow.kt#uh7d8r");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-711844679, i, -1, "androidx.compose.material3.ComposableSingletons$TabRowKt.lambda-1.<anonymous> (TabRow.kt:137)");
            }
            DividerKt.m1176Divider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f33lambda2 = ComposableLambdaKt.composableLambdaInstance(-713969278, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$TabRowKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C239@11427L9:TabRow.kt#uh7d8r");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-713969278, i, -1, "androidx.compose.material3.ComposableSingletons$TabRowKt.lambda-2.<anonymous> (TabRow.kt:238)");
            }
            DividerKt.m1176Divider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1127getLambda1$material3_release() {
        return f32lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1128getLambda2$material3_release() {
        return f33lambda2;
    }
}
