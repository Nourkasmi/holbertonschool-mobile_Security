package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\rH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public Node(Modifier.Node modifierNode) {
        Intrinsics.checkNotNullParameter(modifierNode, "modifierNode");
        this.modifierNode = modifierNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0263  */
    /* JADX WARN: Type inference failed for: r5v23 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean buildCache(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r34, androidx.compose.ui.layout.LayoutCoordinates r35, androidx.compose.ui.input.pointer.InternalPointerEvent r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m2387equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        Modifier.Node nodePop = this.modifierNode;
        int iM4081constructorimpl = NodeKind.m4081constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).onCancelPointerInput();
            } else if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i2 = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM4081constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(nodePop);
                                }
                                nodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i2 == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPressed() && (!internalPointerEvent.m3678issuesEnterExitEvent0FcD4WY(pointerInputChange.getId()) || !this.isIn)) {
                this.pointerIds.remove(PointerId.m3728boximpl(pointerInputChange.getId()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m3698equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m3703getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v18 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo3873getSizeYbymL2g = layoutCoordinates.mo3873getSizeYbymL2g();
        Modifier.Node nodePop = this.modifierNode;
        int iM4081constructorimpl = NodeKind.m4081constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).mo142onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo3873getSizeYbymL2g);
            } else if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM4081constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(nodePop);
                                }
                                nodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            int i2 = 0;
            do {
                Node node = content[i2];
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent, isInBounds);
                i2++;
            } while (i2 < size);
        }
        if (this.modifierNode.getIsAttached()) {
            Modifier.Node nodePop2 = this.modifierNode;
            int iM4081constructorimpl2 = NodeKind.m4081constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (nodePop2 != 0) {
                if (nodePop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) nodePop2).mo142onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo3873getSizeYbymL2g);
                } else if ((nodePop2.getKindSet() & iM4081constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                    int i3 = 0;
                    nodePop2 = nodePop2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & iM4081constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                nodePop2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nodePop2 != 0) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(nodePop2);
                                    }
                                    nodePop2 = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(delegate2);
                                }
                            }
                        }
                        delegate2 = delegate2.getChild();
                        nodePop2 = nodePop2;
                    }
                    if (i3 == 1) {
                    }
                }
                nodePop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jMo3873getSizeYbymL2g = layoutCoordinates.mo3873getSizeYbymL2g();
            Modifier.Node nodePop = this.modifierNode;
            int iM4081constructorimpl = NodeKind.m4081constructorimpl(16);
            MutableVector mutableVector = null;
            while (nodePop != 0) {
                if (nodePop instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) nodePop).mo142onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo3873getSizeYbymL2g);
                } else if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                    int i2 = 0;
                    nodePop = nodePop;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM4081constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
                                nodePop = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nodePop != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(nodePop);
                                    }
                                    nodePop = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        nodePop = nodePop;
                    }
                    if (i2 == 1) {
                    }
                }
                nodePop = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
