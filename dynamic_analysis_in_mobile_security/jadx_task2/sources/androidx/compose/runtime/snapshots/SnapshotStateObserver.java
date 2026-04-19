package androidx.compose.runtime.snapshots;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00014B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0001J)\u0010\u001f\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00130\u0003J\b\u0010!\u001a\u00020\u0013H\u0002J&\u0010\"\u001a\u00020\u0011\"\b\b\u0000\u0010#*\u00020\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001c\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010)\u001a\u00020\rJ?\u0010*\u001a\u00020\u0005\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H#2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final MutableVector<ObservedScopeMap> observedScopeMaps;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges;
    private final Function1<Object, Unit> readObserver;
    private boolean sendingNotifications;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor) {
        Intrinsics.checkNotNullParameter(onChangedExecutor, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor;
        this.pendingChanges = new AtomicReference<>(null);
        this.applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                invoke2(set, snapshot);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<? extends Object> applied, Snapshot snapshot) {
                Intrinsics.checkNotNullParameter(applied, "applied");
                Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                this.this$0.addChanges(applied);
                if (this.this$0.drainChanges()) {
                    this.this$0.sendNotifications();
                }
            }
        };
        this.readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (this.this$0.isPaused) {
                    return;
                }
                MutableVector mutableVector = this.this$0.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = this.this$0;
                synchronized (mutableVector) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    observedScopeMap.recordRead(state);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        z2 = content[i].recordInvalidation(setRemoveChanges) || z2;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
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
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        if (!snapshotStateObserver.sendingNotifications) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size > 0) {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } finally {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        block.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap observedScopeMapEnsureMap;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            observedScopeMapEnsureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(changes, snapshot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020\u0004J0\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010+J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0001J(\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0002J)\u00100\u001a\u00020\u00042!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0\u0003J\u0012\u00104\u001a\u00020\u00042\n\u00105\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private IdentityArrayIntMap currentScopeReads;
        private int currentToken;
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final IdentityArraySet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        private final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;
        private final MutableVector<DerivedState<?>> statesToReread;
        private final IdentityScopeMap<Object> valueToScopes;

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public ObservedScopeMap(Function1<Object, Unit> onChanged) {
            Intrinsics.checkNotNullParameter(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap<>();
            this.scopeToValues = new IdentityArrayMap<>(0, 1, null);
            this.invalidated = new IdentityArraySet<>();
            this.statesToReread = new MutableVector<>(new DerivedState[16], 0);
            this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
                @Override // androidx.compose.runtime.DerivedStateObserver
                public void start(DerivedState<?> derivedState) {
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    this.this$0.deriveStateScopeCount++;
                }

                @Override // androidx.compose.runtime.DerivedStateObserver
                public void done(DerivedState<?> derivedState) {
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
                    observedScopeMap.deriveStateScopeCount--;
                }
            };
            this.dependencyToDerivedStates = new IdentityScopeMap<>();
            this.recordedDerivedStateValues = new HashMap<>();
        }

        public final void recordRead(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap == null) {
                identityArrayIntMap = new IdentityArrayIntMap();
                this.currentScopeReads = identityArrayIntMap;
                this.scopeToValues.set(obj, identityArrayIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, identityArrayIntMap);
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, IdentityArrayIntMap recordedValues) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iAdd = recordedValues.add(value, currentToken);
            if ((value instanceof DerivedState) && iAdd != currentToken) {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                Object[] dependencies = currentRecord.getDependencies();
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
                identityScopeMap.removeScope(value);
                for (Object obj : dependencies) {
                    if (obj == null) {
                        break;
                    }
                    identityScopeMap.add(obj, value);
                }
            }
            if (iAdd == -1) {
                this.valueToScopes.add(value, currentScope);
            }
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(readObserver, "readObserver");
            Intrinsics.checkNotNullParameter(block, "block");
            Object obj = this.currentScope;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = identityArrayIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        public final void clearScopeObservations(Object scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            IdentityArrayIntMap identityArrayIntMapRemove = this.scopeToValues.remove(scope);
            if (identityArrayIntMapRemove == null) {
                return;
            }
            Object[] keys = identityArrayIntMapRemove.getKeys();
            int[] values = identityArrayIntMapRemove.getValues();
            int size = identityArrayIntMapRemove.getSize();
            for (int i = 0; i < size; i++) {
                Object obj = keys[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                int i2 = values[i];
                removeObservation(scope, obj);
            }
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if (!(value instanceof DerivedState) || this.valueToScopes.contains(value)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            IdentityScopeMap<Object> identityScopeMap = this.valueToScopes;
            int iFind = identityScopeMap.find(derivedState);
            if (iFind >= 0) {
                IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
                Object[] values = identityArraySetScopeSetAt.getValues();
                int size = identityArraySetScopeSetAt.size();
                for (int i = 0; i < size; i++) {
                    Object obj = values[i];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    IdentityArrayIntMap identityArrayIntMap = identityArrayMap.get(obj);
                    if (identityArrayIntMap == null) {
                        identityArrayIntMap = new IdentityArrayIntMap();
                        identityArrayMap.set(obj, identityArrayIntMap);
                        Unit unit = Unit.INSTANCE;
                    }
                    recordRead(derivedState, id, obj, identityArrayIntMap);
                }
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap != null) {
                Object[] keys = identityArrayIntMap.getKeys();
                int[] values = identityArrayIntMap.getValues();
                int size = identityArrayIntMap.getSize();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj = keys[i3];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                    int i4 = values[i3];
                    boolean z = i4 != i;
                    if (z) {
                        removeObservation(scope, obj);
                    }
                    if (!z) {
                        if (i2 != i3) {
                            keys[i2] = obj;
                            values[i2] = i4;
                        }
                        i2++;
                    }
                }
                for (int i5 = i2; i5 < size; i5++) {
                    keys[i5] = null;
                }
                identityArrayIntMap.size = i2;
            }
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int size = identityArrayMap.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = identityArrayMap.getKeys()[i2];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.getValues()[i2];
                Boolean boolInvoke = predicate.invoke(obj);
                if (boolInvoke.booleanValue()) {
                    Object[] keys = identityArrayIntMap.getKeys();
                    int[] values = identityArrayIntMap.getValues();
                    int size2 = identityArrayIntMap.getSize();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj2 = keys[i3];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                        int i4 = values[i3];
                        removeObservation(obj, obj2);
                    }
                }
                if (!boolInvoke.booleanValue()) {
                    if (i != i2) {
                        identityArrayMap.getKeys()[i] = obj;
                        identityArrayMap.getValues()[i] = identityArrayMap.getValues()[i2];
                    }
                    i++;
                }
            }
            if (identityArrayMap.getSize() > i) {
                int size3 = identityArrayMap.getSize();
                for (int i5 = i; i5 < size3; i5++) {
                    identityArrayMap.getKeys()[i5] = null;
                    identityArrayMap.getValues()[i5] = null;
                }
                ((IdentityArrayMap) identityArrayMap).size = i;
            }
        }

        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z;
            int iFind;
            int i;
            Object[] objArr;
            int iFind2;
            Intrinsics.checkNotNullParameter(changes, "changes");
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map = this.recordedDerivedStateValues;
            IdentityScopeMap<Object> identityScopeMap2 = this.valueToScopes;
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            if (changes instanceof IdentityArraySet) {
                IdentityArraySet identityArraySet2 = (IdentityArraySet) changes;
                Object[] values = identityArraySet2.getValues();
                int size = identityArraySet2.size();
                int i2 = 0;
                z = false;
                while (i2 < size) {
                    Object obj = values[i2];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (!identityScopeMap.contains(obj) || (iFind2 = identityScopeMap.find(obj)) < 0) {
                        i = size;
                        objArr = values;
                    } else {
                        IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind2);
                        Object[] values2 = identityArraySetScopeSetAt.getValues();
                        int size2 = identityArraySetScopeSetAt.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj2 = values2[i3];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState<?> derivedState = (DerivedState) obj2;
                            Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            int i4 = size;
                            Object obj3 = map.get(derivedState);
                            SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                            if (policy == null) {
                                policy = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            Object[] objArr2 = values;
                            boolean z2 = z;
                            if (!policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj3)) {
                                int iFind3 = identityScopeMap2.find(derivedState);
                                if (iFind3 >= 0) {
                                    IdentityArraySet identityArraySetScopeSetAt2 = identityScopeMap2.scopeSetAt(iFind3);
                                    Object[] values3 = identityArraySetScopeSetAt2.getValues();
                                    int size3 = identityArraySetScopeSetAt2.size();
                                    z = z2;
                                    int i5 = 0;
                                    while (i5 < size3) {
                                        Object obj4 = values3[i5];
                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj4);
                                        i5++;
                                        z = true;
                                    }
                                }
                                i3++;
                                size = i4;
                                values = objArr2;
                            } else {
                                this.statesToReread.add(derivedState);
                            }
                            z = z2;
                            i3++;
                            size = i4;
                            values = objArr2;
                        }
                        i = size;
                        objArr = values;
                    }
                    int iFind4 = identityScopeMap2.find(obj);
                    if (iFind4 >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt3 = identityScopeMap2.scopeSetAt(iFind4);
                        Object[] values4 = identityArraySetScopeSetAt3.getValues();
                        int size4 = identityArraySetScopeSetAt3.size();
                        int i6 = 0;
                        while (i6 < size4) {
                            Object obj5 = values4[i6];
                            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj5);
                            i6++;
                            z = true;
                        }
                    }
                    i2++;
                    size = i;
                    values = objArr;
                }
            } else {
                Iterator it = changes.iterator();
                z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (identityScopeMap.contains(next) && (iFind = identityScopeMap.find(next)) >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt4 = identityScopeMap.scopeSetAt(iFind);
                        Object[] values5 = identityArraySetScopeSetAt4.getValues();
                        int size5 = identityArraySetScopeSetAt4.size();
                        int i7 = 0;
                        while (i7 < size5) {
                            Object obj6 = values5[i7];
                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState<?> derivedState2 = (DerivedState) obj6;
                            Intrinsics.checkNotNull(derivedState2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            Object obj7 = map.get(derivedState2);
                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                            if (policy2 == null) {
                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            Iterator it2 = it;
                            if (!policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj7)) {
                                int iFind5 = identityScopeMap2.find(derivedState2);
                                if (iFind5 >= 0) {
                                    IdentityArraySet identityArraySetScopeSetAt5 = identityScopeMap2.scopeSetAt(iFind5);
                                    Object[] values6 = identityArraySetScopeSetAt5.getValues();
                                    int size6 = identityArraySetScopeSetAt5.size();
                                    int i8 = 0;
                                    while (i8 < size6) {
                                        Object obj8 = values6[i8];
                                        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj8);
                                        i8++;
                                        z = true;
                                    }
                                }
                            } else {
                                this.statesToReread.add(derivedState2);
                            }
                            i7++;
                            it = it2;
                        }
                    }
                    Iterator it3 = it;
                    int iFind6 = identityScopeMap2.find(next);
                    if (iFind6 >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt6 = identityScopeMap2.scopeSetAt(iFind6);
                        Object[] values7 = identityArraySetScopeSetAt6.getValues();
                        int size7 = identityArraySetScopeSetAt6.size();
                        int i9 = 0;
                        while (i9 < size7) {
                            Object obj9 = values7[i9];
                            Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj9);
                            i9++;
                            z = true;
                        }
                    }
                    it = it3;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size8 = mutableVector.getSize();
                if (size8 > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    int i10 = 0;
                    do {
                        rereadDerivedState(content[i10]);
                        i10++;
                    } while (i10 < size8);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                function1.invoke(obj);
            }
            identityArraySet.clear();
        }
    }

    public final void clear(Object scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].clearScopeObservations(scope);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].removeScopeIf(predicate);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (observedScopeMap.getOnChanged() == onChanged) {
                    break;
                }
                i++;
            } while (i < size);
            observedScopeMap = null;
        } else {
            observedScopeMap = null;
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }
}
