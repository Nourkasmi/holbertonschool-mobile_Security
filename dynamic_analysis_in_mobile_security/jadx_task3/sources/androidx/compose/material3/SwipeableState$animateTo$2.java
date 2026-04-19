package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SwipeableState$animateTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((Map) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00ea: IGET (r9 I:androidx.compose.material3.SwipeableState<T>) = 
      (r8 I:androidx.compose.material3.SwipeableState$animateTo$2 A[D('this' androidx.compose.material3.SwipeableState$animateTo$2)])
     androidx.compose.material3.SwipeableState$animateTo$2.this$0 androidx.compose.material3.SwipeableState, block:B:39:0x00ea */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.material3.SwipeableState, androidx.compose.material3.SwipeableState<T>] */
    /* JADX WARN: Type update failed for variable: r8v0 androidx.compose.material3.SwipeableState$animateTo$2, new type: androidx.compose.material3.SwipeableState$animateTo$2
    jadx.core.utils.exceptions.JadxRuntimeException: Can't change type for register without SSA variable: (r8 I:androidx.compose.material3.SwipeableState$animateTo$2 A[D('this' androidx.compose.material3.SwipeableState$animateTo$2)])
    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:50)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.lambda$applyUpdates$1(TypeUpdateInfo.java:56)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.applyUpdates(TypeUpdateInfo.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:98)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:58)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertCasts(FixTypesVisitor.java:477)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableState$animateTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
