package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentityScopeMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0011\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0002H\u0086\u0002J\u0012\u0010\"\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\fH\u0002J7\u0010&\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00022!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001f0(H\u0086\bø\u0001\u0000J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u001b\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010-\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010.J/\u0010/\u001a\u00020\u001f2!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001a0(H\u0086\bø\u0001\u0000J#\u00101\u001a\u00020\u001f2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u001f0(H\u0082\bJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00104\u001a\u00020\fH\u0002R<\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00052\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "<set-?>", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "scopeSets", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize", "()I", "setSize", "(I)V", "", "valueOrder", "getValueOrder", "()[I", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int index) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[index]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object value, T scope) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return getOrCreateIdentitySet(value).add(scope);
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return find(element) >= 0;
    }

    public final void forEachScopeOf(Object value, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(block, "block");
        int iFind = find(value);
        if (iFind >= 0) {
            IdentityArraySet identityArraySetScopeSetAt = scopeSetAt(iFind);
            Object[] values = identityArraySetScopeSetAt.getValues();
            int size = identityArraySetScopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                block.invoke(obj);
            }
        }
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object value) {
        int iFind;
        int i = this.size;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        if (i > 0) {
            iFind = find(value);
            if (iFind >= 0) {
                return scopeSetAt(iFind);
            }
        } else {
            iFind = -1;
        }
        int i2 = -(iFind + 1);
        if (i < iArr.length) {
            int i3 = iArr[i];
            objArr[i3] = value;
            IdentityArraySet<T> identityArraySet = identityArraySetArr[i3];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                identityArraySetArr[i3] = identityArraySet;
            }
            if (i2 < i) {
                ArraysKt.copyInto(iArr, iArr, i2 + 1, i2, i);
            }
            iArr[i2] = i3;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] objArrCopyOf = Arrays.copyOf(identityArraySetArr, length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        IdentityArraySet<T>[] identityArraySetArr2 = (IdentityArraySet[]) objArrCopyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        identityArraySetArr2[i] = identityArraySet2;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(this, newSize)");
        objArrCopyOf2[i] = value;
        int[] iArr2 = new int[length];
        for (int i4 = i + 1; i4 < length; i4++) {
            iArr2[i4] = i4;
        }
        if (i2 < i) {
            ArraysKt.copyInto(iArr, iArr2, i2 + 1, i2, i);
        }
        iArr2[i2] = i;
        if (i2 > 0) {
            ArraysKt.copyInto$default(iArr, iArr2, 0, 0, i2, 6, (Object) null);
        }
        this.scopeSets = identityArraySetArr2;
        this.values = objArrCopyOf2;
        this.valueOrder = iArr2;
        this.size++;
        return identityArraySet2;
    }

    public final void clear() {
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        int length = identityArraySetArr.length;
        for (int i = 0; i < length; i++) {
            IdentityArraySet<T> identityArraySet = identityArraySetArr[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            iArr[i] = i;
            objArr[i] = null;
        }
        this.size = 0;
    }

    public final boolean remove(Object value, T scope) {
        int i;
        IdentityArraySet<T> identityArraySet;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int iFind = find(value);
        int[] iArr = this.valueOrder;
        IdentityArraySet<T>[] identityArraySetArr = this.scopeSets;
        Object[] objArr = this.values;
        int i2 = this.size;
        if (iFind < 0 || (identityArraySet = identityArraySetArr[(i = iArr[iFind])]) == null) {
            return false;
        }
        boolean zRemove = identityArraySet.remove(scope);
        if (identityArraySet.size() == 0) {
            int i3 = iFind + 1;
            if (i3 < i2) {
                ArraysKt.copyInto(iArr, iArr, iFind, i3, i2);
            }
            int i4 = i2 - 1;
            iArr[i4] = i;
            objArr[i] = null;
            this.size = i4;
        }
        return zRemove;
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> removalOperation) {
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            removalOperation.invoke(identityArraySet);
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i4 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i4;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i5 = i; i5 < size2; i5++) {
            values[valueOrder[i5]] = null;
        }
        setSize(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int find(Object value) {
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        int i = this.size - 1;
        Object[] objArr = this.values;
        int[] iArr = this.valueOrder;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj = objArr[iArr[i3]];
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i2 = i3 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return value == obj ? i3 : findExactIndex(i3, value, iIdentityHashCode);
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        return -(r5 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r5, java.lang.Object r6, int r7) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.values
            int[] r1 = r4.valueOrder
            int r2 = r5 + (-1)
        L6:
            r3 = -1
            if (r3 >= r2) goto L1a
            r3 = r1[r2]
            r3 = r0[r3]
            if (r3 != r6) goto L10
            return r2
        L10:
            int r3 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r3)
            if (r3 == r7) goto L17
            goto L1a
        L17:
            int r2 = r2 + (-1)
            goto L6
        L1a:
            int r5 = r5 + 1
            int r2 = r4.size
        L1e:
            if (r5 >= r2) goto L34
            r3 = r1[r5]
            r3 = r0[r3]
            if (r3 != r6) goto L27
            return r5
        L27:
            int r3 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r3)
            if (r3 == r7) goto L31
        L2d:
            int r5 = r5 + 1
            int r5 = -r5
            return r5
        L31:
            int r5 = r5 + 1
            goto L1e
        L34:
            int r5 = r4.size
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.findExactIndex(int, java.lang.Object, int):int");
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            Object[] values2 = identityArraySet.getValues();
            int size2 = identityArraySet.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size2; i5++) {
                Object obj = values2[i5];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!predicate.invoke(obj).booleanValue()) {
                    if (i4 != i5) {
                        values2[i4] = obj;
                    }
                    i4++;
                }
            }
            for (int i6 = i4; i6 < size2; i6++) {
                values2[i6] = null;
            }
            ((IdentityArraySet) identityArraySet).size = i4;
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i7 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i7;
                }
                i++;
            }
        }
        int size3 = getSize();
        for (int i8 = i; i8 < size3; i8++) {
            values[valueOrder[i8]] = null;
        }
        setSize(i);
    }

    public final void removeScope(T scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int[] valueOrder = getValueOrder();
        IdentityArraySet<T>[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet<T> identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            identityArraySet.remove(scope);
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i4 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i4;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i5 = i; i5 < size2; i5++) {
            values[valueOrder[i5]] = null;
        }
        setSize(i);
    }
}
