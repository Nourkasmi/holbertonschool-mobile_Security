package com.holberton.task3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.holberton.task3.MainActivityKt$FibonacciDecryptionScreen$1$1$result$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainActivityKt$FibonacciDecryptionScreen$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    MainActivityKt$FibonacciDecryptionScreen$1$1$result$1(Continuation<? super MainActivityKt$FibonacciDecryptionScreen$1$1$result$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$FibonacciDecryptionScreen$1$1$result$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((MainActivityKt$FibonacciDecryptionScreen$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return MainActivityKt.performslowDecryption();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
