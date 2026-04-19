package androidx.compose.runtime;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first;
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(Function0<? extends T> calculation, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    /* JADX INFO: compiled from: DerivedState.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u001a\u0010(\u001a\u00020)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u00060"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "_dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "get_dependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "set_dependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "result", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private IdentityArrayMap<StateObject, Integer> _dependencies;
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final IdentityArrayMap<StateObject, Integer> get_dependencies() {
            return this._dependencies;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public final void set_dependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this._dependencies = identityArrayMap;
        }

        /* JADX INFO: compiled from: DerivedState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord resultRecord = (ResultRecord) value;
            this._dependencies = resultRecord._dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object[] getDependencies() {
            Object[] keys;
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this._dependencies;
            return (identityArrayMap == null || (keys = identityArrayMap.getKeys()) == null) ? new Object[0] : keys;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean isValid(androidx.compose.runtime.DerivedState<?> r6, androidx.compose.runtime.snapshots.Snapshot r7) {
            /*
                r5 = this;
                java.lang.String r0 = "derivedState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "snapshot"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r0)
                int r1 = r5.validSnapshotId     // Catch: java.lang.Throwable -> L55
                int r2 = r7.getId()     // Catch: java.lang.Throwable -> L55
                r3 = 0
                r4 = 1
                if (r1 != r2) goto L25
                int r1 = r5.validSnapshotWriteCount     // Catch: java.lang.Throwable -> L55
                int r2 = r7.getWriteCount()     // Catch: java.lang.Throwable -> L55
                if (r1 == r2) goto L23
                goto L25
            L23:
                r1 = r3
                goto L26
            L25:
                r1 = r4
            L26:
                monitor-exit(r0)
                java.lang.Object r0 = r5.result
                java.lang.Object r2 = androidx.compose.runtime.DerivedSnapshotState.ResultRecord.Unset
                if (r0 == r2) goto L38
                if (r1 == 0) goto L37
                int r0 = r5.resultHash
                int r6 = r5.readableHash(r6, r7)
                if (r0 != r6) goto L38
            L37:
                r3 = r4
            L38:
                if (r3 == 0) goto L54
                if (r1 == 0) goto L54
                java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r6)
                int r0 = r7.getId()     // Catch: java.lang.Throwable -> L51
                r5.validSnapshotId = r0     // Catch: java.lang.Throwable -> L51
                int r7 = r7.getWriteCount()     // Catch: java.lang.Throwable -> L51
                r5.validSnapshotWriteCount = r7     // Catch: java.lang.Throwable -> L51
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L51
                monitor-exit(r6)
                goto L54
            L51:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            L54:
                return r3
            L55:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.ResultRecord.isValid(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):boolean");
        }

        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap<StateObject, Integer> identityArrayMap;
            StateRecord stateRecordCurrent;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                identityArrayMap = this._dependencies;
            }
            int iIdentityHashCode = 7;
            if (identityArrayMap != null) {
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = mutableVectorDerivedStateObservers.getSize();
                int i = 0;
                if (size > 0) {
                    DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
                    int i2 = 0;
                    do {
                        content[i2].start(derivedState);
                        i2++;
                    } while (i2 < size);
                }
                try {
                    int size2 = identityArrayMap.getSize();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj = identityArrayMap.getKeys()[i3];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) identityArrayMap.getValues()[i3]).intValue() == 1) {
                            if (stateObject instanceof DerivedSnapshotState) {
                                stateRecordCurrent = ((DerivedSnapshotState) stateObject).current(snapshot);
                            } else {
                                stateRecordCurrent = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            }
                            iIdentityHashCode = (((iIdentityHashCode * 31) + ActualJvm_jvmKt.identityHashCode(stateRecordCurrent)) * 31) + stateRecordCurrent.getSnapshotId();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    int size3 = mutableVectorDerivedStateObservers.getSize();
                    if (size3 > 0) {
                        DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content2[i].done(derivedState);
                            i++;
                        } while (i < size3);
                    }
                } catch (Throwable th) {
                    int size4 = mutableVectorDerivedStateObservers.getSize();
                    if (size4 > 0) {
                        DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content3[i].done(derivedState);
                            i++;
                        } while (i < size4);
                    }
                    throw th;
                }
            }
            return iIdentityHashCode;
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        SnapshotMutationPolicy<T> policy;
        DerivedSnapshotState<T> derivedSnapshotState = this;
        int i = 0;
        if (readable.isValid(derivedSnapshotState, snapshot)) {
            if (forceDependencyReads) {
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = mutableVectorDerivedStateObservers.getSize();
                if (size > 0) {
                    DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
                    int i2 = 0;
                    do {
                        content[i2].start(derivedSnapshotState);
                        i2++;
                    } while (i2 < size);
                }
                try {
                    IdentityArrayMap<StateObject, Integer> identityArrayMap = readable.get_dependencies();
                    Integer num = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    int iIntValue = num != null ? num.intValue() : 0;
                    if (identityArrayMap != null) {
                        int size2 = identityArrayMap.getSize();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Object obj = identityArrayMap.getKeys()[i3];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            StateObject stateObject = (StateObject) obj;
                            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(((Number) identityArrayMap.getValues()[i3]).intValue() + iIntValue));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                        }
                    }
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue));
                    Unit unit = Unit.INSTANCE;
                    int size3 = mutableVectorDerivedStateObservers.getSize();
                    if (size3 > 0) {
                        DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content2[i].done(derivedSnapshotState);
                            i++;
                        } while (i < size3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return readable;
        }
        Integer num2 = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        final int iIntValue2 = num2 != null ? num2.intValue() : 0;
        final IdentityArrayMap<StateObject, Integer> identityArrayMap2 = new IdentityArrayMap<>(0, 1, null);
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
        int size4 = mutableVectorDerivedStateObservers2.getSize();
        if (size4 > 0) {
            DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers2.getContent();
            int i4 = 0;
            do {
                content3[i4].start(derivedSnapshotState);
                i4++;
            } while (i4 < size4);
        }
        try {
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue2 + 1));
            Object objObserve = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1
                final /* synthetic */ DerivedSnapshotState<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    invoke2(obj2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it == this.this$0) {
                        throw new IllegalStateException("A derived state calculation cannot read itself".toString());
                    }
                    if (it instanceof StateObject) {
                        Object obj2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                        Intrinsics.checkNotNull(obj2);
                        int iIntValue3 = ((Number) obj2).intValue();
                        IdentityArrayMap<StateObject, Integer> identityArrayMap3 = identityArrayMap2;
                        int i5 = iIntValue3 - iIntValue2;
                        Integer num3 = identityArrayMap3.get(it);
                        identityArrayMap3.set(it, Integer.valueOf(Math.min(i5, num3 != null ? num3.intValue() : Integer.MAX_VALUE)));
                    }
                }
            }, null, calculation);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue2));
            int size5 = mutableVectorDerivedStateObservers2.getSize();
            if (size5 > 0) {
                DerivedStateObserver[] content4 = mutableVectorDerivedStateObservers2.getContent();
                do {
                    content4[i].done(derivedSnapshotState);
                    i++;
                } while (i < size5);
            }
            synchronized (SnapshotKt.getLock()) {
                Snapshot current = Snapshot.INSTANCE.getCurrent();
                if (readable.getResult() != ResultRecord.INSTANCE.getUnset() && (policy = getPolicy()) != 0 && policy.equivalent(objObserve, readable.getResult())) {
                    readable.set_dependencies(identityArrayMap2);
                    readable.setResultHash(readable.readableHash(this, current));
                    readable.setValidSnapshotId(snapshot.getId());
                    readable.setValidSnapshotWriteCount(snapshot.getWriteCount());
                } else {
                    readable = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                    readable.set_dependencies(identityArrayMap2);
                    readable.setResultHash(readable.readableHash(this, current));
                    readable.setValidSnapshotId(snapshot.getId());
                    readable.setValidSnapshotWriteCount(snapshot.getWriteCount());
                    readable.setResult(objObserve);
                }
            }
            if (iIntValue2 == 0) {
                Snapshot.INSTANCE.notifyObjectsInitialized();
            }
            return readable;
        } finally {
            int size6 = mutableVectorDerivedStateObservers2.getSize();
            if (size6 > 0) {
                DerivedStateObserver[] content5 = mutableVectorDerivedStateObservers2.getContent();
                do {
                    content5[i].done(derivedSnapshotState);
                    i++;
                } while (i < size6);
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.INSTANCE.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.INSTANCE.getCurrent(), true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.INSTANCE.getCurrent(), false, this.calculation);
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }
}
