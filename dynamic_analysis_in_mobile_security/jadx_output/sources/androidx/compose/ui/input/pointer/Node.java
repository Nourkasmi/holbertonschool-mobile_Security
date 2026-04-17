package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\rH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;

    /* JADX INFO: renamed from: modifierNode, reason: from kotlin metadata and from toString */
    private final Modifier.Node pointerInputFilter;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(Modifier.Node modifierNode) {
        Intrinsics.checkNotNullParameter(modifierNode, "modifierNode");
        this.pointerInputFilter = modifierNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX INFO: renamed from: getModifierNode, reason: from getter */
    public final Modifier.Node getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        MutableVector<Node> children;
        int size$iv;
        Node this_$iv;
        int count$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        Node this_$iv2 = this;
        if (this_$iv2.relevantChanges.isEmpty() || !this_$iv2.pointerInputFilter.getIsAttached()) {
            return false;
        }
        PointerEvent event = this.pointerEvent;
        Intrinsics.checkNotNull(event);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long size = layoutCoordinates.mo4190getSizeYbymL2g();
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.pointerInputFilter;
        int iM4398constructorimpl = NodeKind.m4398constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                PointerInputModifierNode it = (PointerInputModifierNode) nodePop;
                this_$iv = this_$iv2;
                it.mo143onPointerEventH0pRuoY(event, PointerEventPass.Initial, size);
            } else {
                this_$iv = this_$iv2;
                Modifier.Node this_$iv$iv = nodePop;
                if (((this_$iv$iv.getKindSet() & iM4398constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                    int count$iv2 = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                    for (Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate(); node$iv$iv != null; node$iv$iv = node$iv$iv.getChild()) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & iM4398constructorimpl) != 0) {
                            count$iv2++;
                            if (count$iv2 == 1) {
                                nodePop = next$iv;
                            } else {
                                if (mutableVector2 != null) {
                                    count$iv = count$iv2;
                                    mutableVector = mutableVector2;
                                } else {
                                    count$iv = count$iv2;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = nodePop;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                                count$iv2 = count$iv;
                            }
                        }
                    }
                    if (count$iv2 == 1) {
                        this_$iv2 = this_$iv;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            this_$iv2 = this_$iv;
        }
        if (this.pointerInputFilter.getIsAttached() && (size$iv = (children = getChildren()).getSize()) > 0) {
            int i$iv = 0;
            Object[] content$iv = children.getContent();
            while (true) {
                Node it2 = (Node) content$iv[i$iv];
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                MutableVector<Node> mutableVector3 = children;
                it2.dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent, isInBounds);
                i$iv++;
                if (i$iv >= size$iv) {
                    break;
                }
                children = mutableVector3;
            }
        }
        if (!this.pointerInputFilter.getIsAttached()) {
            z = true;
        } else {
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2 = this.pointerInputFilter;
            int iM4398constructorimpl2 = NodeKind.m4398constructorimpl(16);
            MutableVector mutableVector4 = null;
            Modifier.Node nodePop2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
            while (nodePop2 != null) {
                if (nodePop2 instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it3 = (PointerInputModifierNode) nodePop2;
                    it3.mo143onPointerEventH0pRuoY(event, PointerEventPass.Main, size);
                } else {
                    Modifier.Node this_$iv$iv3 = nodePop2;
                    if (((this_$iv$iv3.getKindSet() & iM4398constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                        int count$iv3 = 0;
                        DelegatingNode this_$iv$iv4 = (DelegatingNode) nodePop2;
                        for (Modifier.Node node$iv$iv2 = this_$iv$iv4.getDelegate(); node$iv$iv2 != null; node$iv$iv2 = node$iv$iv2.getChild()) {
                            Modifier.Node next$iv2 = node$iv$iv2;
                            if ((next$iv2.getKindSet() & iM4398constructorimpl2) != 0) {
                                count$iv3++;
                                if (count$iv3 == 1) {
                                    nodePop2 = next$iv2;
                                } else {
                                    mutableVector4 = mutableVector4 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector4;
                                    Modifier.Node theNode$iv2 = nodePop2;
                                    if (theNode$iv2 != null) {
                                        if (mutableVector4 != null) {
                                            mutableVector4.add(theNode$iv2);
                                        }
                                        nodePop2 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(next$iv2);
                                    }
                                }
                            }
                        }
                        if (count$iv3 == 1) {
                        }
                    }
                }
                nodePop2 = DelegatableNodeKt.pop(mutableVector4);
            }
            z = true;
        }
        return z;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z;
        boolean z2;
        MutableVector<Node> children;
        int size$iv;
        Node this_$iv;
        int $i$f$dispatchIfNeeded;
        int i;
        Node this_$iv2;
        int $i$f$dispatchIfNeeded2;
        int i2;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        Node this_$iv3 = this;
        int $i$f$dispatchIfNeeded3 = 0;
        if (!this_$iv3.relevantChanges.isEmpty() && this_$iv3.pointerInputFilter.getIsAttached()) {
            int i3 = 0;
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.mo4190getSizeYbymL2g();
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.pointerInputFilter;
            int iM4398constructorimpl = NodeKind.m4398constructorimpl(16);
            MutableVector mutableVector2 = null;
            Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv;
            while (true) {
                int i4 = 1;
                if (nodePop == null) {
                    break;
                }
                if (nodePop instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it = (PointerInputModifierNode) nodePop;
                    it.mo143onPointerEventH0pRuoY(event, PointerEventPass.Final, size);
                    this_$iv = this_$iv3;
                    $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                    i = i3;
                } else {
                    Modifier.Node this_$iv$iv = nodePop;
                    if (!((this_$iv$iv.getKindSet() & iM4398constructorimpl) != 0) || !(nodePop instanceof DelegatingNode)) {
                        this_$iv = this_$iv3;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                        i = i3;
                    } else {
                        int count$iv = 0;
                        DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                        Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (((next$iv.getKindSet() & iM4398constructorimpl) != 0 ? i4 : 0) == 0) {
                                this_$iv2 = this_$iv3;
                                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                i2 = i3;
                            } else {
                                count$iv++;
                                if (count$iv == i4) {
                                    nodePop = next$iv;
                                    this_$iv2 = this_$iv3;
                                    $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                    i2 = i3;
                                } else {
                                    if (mutableVector2 != null) {
                                        this_$iv2 = this_$iv3;
                                        $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                        i2 = i3;
                                        mutableVector = mutableVector2;
                                    } else {
                                        this_$iv2 = this_$iv3;
                                        $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                        i2 = i3;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    mutableVector2 = mutableVector;
                                    Modifier.Node theNode$iv = nodePop;
                                    if (theNode$iv != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(theNode$iv);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(next$iv);
                                    }
                                }
                            }
                            node$iv$iv = node$iv$iv.getChild();
                            this_$iv3 = this_$iv2;
                            $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded2;
                            i3 = i2;
                            i4 = 1;
                        }
                        this_$iv = this_$iv3;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                        i = i3;
                        if (count$iv == 1) {
                            this_$iv3 = this_$iv;
                            $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded;
                            i3 = i;
                        }
                    }
                }
                nodePop = DelegatableNodeKt.pop(mutableVector2);
                this_$iv3 = this_$iv;
                $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded;
                i3 = i;
            }
            if (!this.pointerInputFilter.getIsAttached() || (size$iv = (children = getChildren()).getSize()) <= 0) {
                z = true;
            } else {
                int i$iv = 0;
                Object[] content$iv = children.getContent();
                do {
                    Node it2 = (Node) content$iv[i$iv];
                    it2.dispatchFinalEventPass(internalPointerEvent);
                    z = true;
                    i$iv++;
                } while (i$iv < size$iv);
            }
            z2 = z;
        } else {
            z2 = false;
        }
        boolean result = z2;
        cleanUpHits(internalPointerEvent);
        clearCache();
        return result;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object it$iv;
        boolean z;
        boolean z2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int kind$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int kind$iv2;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean childChanged = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        int i = 1;
        if (!this.pointerInputFilter.getIsAttached()) {
            return true;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3 = this.pointerInputFilter;
        int kind$iv3 = NodeKind.m4398constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv3;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) nodePop);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                kind$iv = kind$iv3;
            } else {
                Modifier.Node this_$iv$iv = nodePop;
                if (((this_$iv$iv.getKindSet() & kind$iv3) != 0 ? i : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    kind$iv = kind$iv3;
                } else {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet() & kind$iv3) != 0 ? i : 0) != 0) {
                            count$iv++;
                            if (count$iv == i) {
                                nodePop = next$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                kind$iv2 = kind$iv3;
                            } else {
                                if (mutableVector2 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                    kind$iv2 = kind$iv3;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                    kind$iv2 = kind$iv3;
                                    mutableVector = mutableVector2;
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = nodePop;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            kind$iv2 = kind$iv3;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        kind$iv3 = kind$iv2;
                        i = 1;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    kind$iv = kind$iv3;
                    if (count$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        kind$iv3 = kind$iv;
                        i = 1;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
            kind$iv3 = kind$iv;
            i = 1;
        }
        Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<PointerId, PointerInputChange> next = it.next();
            long key = next.getKey().m4051unboximpl();
            PointerInputChange change = next.getValue();
            long keyValue = key;
            boolean keyInPointerIds = false;
            int i2 = 0;
            int size = this.pointerIds.getSize() - 1;
            if (0 <= size) {
                while (true) {
                    if (this.pointerIds.getContent()[i2].m4051unboximpl() == keyValue) {
                        keyInPointerIds = true;
                        break;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            if (keyInPointerIds) {
                ArrayList historical = new ArrayList(change.getHistorical().size());
                List<HistoricalChange> historical2 = change.getHistorical();
                int size2 = historical2.size();
                Iterator<Map.Entry<PointerId, PointerInputChange>> it2 = it;
                int index$iv = 0;
                while (index$iv < size2) {
                    Object item$iv = historical2.get(index$iv);
                    HistoricalChange it3 = (HistoricalChange) item$iv;
                    long uptimeMillis = it3.getUptimeMillis();
                    LayoutCoordinates layoutCoordinates = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates);
                    historical.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo4191localPositionOfR5De75A(parentCoordinates, it3.getPosition()), null));
                    index$iv++;
                    size2 = size2;
                    keyValue = keyValue;
                    keyInPointerIds = keyInPointerIds;
                }
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                PointerId pointerIdM4045boximpl = PointerId.m4045boximpl(key);
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                long jMo4191localPositionOfR5De75A = layoutCoordinates2.mo4191localPositionOfR5De75A(parentCoordinates, change.getPreviousPosition());
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                map.put(pointerIdM4045boximpl, PointerInputChange.m4055copyOHpmEuE$default(change, 0L, 0L, layoutCoordinates3.mo4191localPositionOfR5De75A(parentCoordinates, change.getPosition()), false, 0L, jMo4191localPositionOfR5De75A, false, 0, historical, 0L, 731, null));
                it = it2;
            }
        }
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int i3 = this.pointerIds.getSize() - 1; -1 < i3; i3--) {
            long pointerId = this.pointerIds.getContent()[i3].m4051unboximpl();
            if (!changes.containsKey(PointerId.m4045boximpl(pointerId))) {
                this.pointerIds.removeAt(i3);
            }
        }
        PointerEvent event = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent);
        List<PointerInputChange> changes2 = event.getChanges();
        int index$iv$iv = 0;
        int size3 = changes2.size();
        while (true) {
            if (index$iv$iv >= size3) {
                it$iv = null;
                break;
            }
            Object item$iv$iv = changes2.get(index$iv$iv);
            it$iv = item$iv$iv;
            if (internalPointerEvent.m3995issuesEnterExitEvent0FcD4WY(((PointerInputChange) it$iv).getId())) {
                break;
            }
            index$iv$iv++;
        }
        PointerInputChange enterExitChange = (PointerInputChange) it$iv;
        if (enterExitChange != null) {
            if (isInBounds) {
                z = false;
                if (this.isIn) {
                    z2 = true;
                } else if (enterExitChange.getPressed() || enterExitChange.getPreviousPressed()) {
                    LayoutCoordinates layoutCoordinates4 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates4);
                    long size4 = layoutCoordinates4.mo4190getSizeYbymL2g();
                    z2 = true;
                    this.isIn = !PointerEventKt.m4010isOutOfBoundsO0kMr_c(enterExitChange, size4);
                } else {
                    z2 = true;
                }
            } else {
                z = false;
                this.isIn = false;
                z2 = true;
            }
            if (this.isIn != this.wasIn && (PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4021getMove7fucELk()) || PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4019getEnter7fucELk()) || PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4020getExit7fucELk()))) {
                event.m4009setTypeEhbLWgg$ui_release(this.isIn ? PointerEventType.INSTANCE.m4019getEnter7fucELk() : PointerEventType.INSTANCE.m4020getExit7fucELk());
            } else if (PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4019getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                event.m4009setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m4021getMove7fucELk());
            } else if (PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4020getExit7fucELk()) && this.isIn && enterExitChange.getPressed()) {
                event.m4009setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m4021getMove7fucELk());
            }
        } else {
            z = false;
            z2 = true;
        }
        boolean changed = (childChanged || !PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4021getMove7fucELk()) || hasPositionChanged(this.pointerEvent, event)) ? z2 : z;
        this.pointerEvent = event;
        return changed;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            PointerInputChange old = oldEvent.getChanges().get(i);
            PointerInputChange current = newEvent.getChanges().get(i);
            if (!Offset.m2705equalsimpl0(old.getPosition(), current.getPosition())) {
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
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        int i;
        MutableVector mutableVector;
        MutableVector<Node> children = getChildren();
        int size$iv = children.getSize();
        int i2 = 1;
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = children.getContent();
            do {
                Node it = (Node) content$iv[i$iv];
                it.dispatchCancel();
                i$iv++;
            } while (i$iv < size$iv);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.pointerInputFilter;
        int iM4398constructorimpl = NodeKind.m4398constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                PointerInputModifierNode it2 = (PointerInputModifierNode) nodePop;
                it2.onCancelPointerInput();
                i = i2;
            } else {
                Modifier.Node this_$iv$iv = nodePop;
                if (((this_$iv$iv.getKindSet() & iM4398constructorimpl) != 0 ? i2 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                    i = i2;
                } else {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet() & iM4398constructorimpl) != 0 ? i2 : 0) != 0) {
                            count$iv++;
                            if (count$iv == i2) {
                                nodePop = next$iv;
                            } else {
                                if (mutableVector2 != null) {
                                    mutableVector = mutableVector2;
                                } else {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = nodePop;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        i2 = 1;
                    }
                    i = 1;
                    if (count$iv == 1) {
                        i2 = 1;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            i2 = i;
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent event = this.pointerEvent;
        if (event == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = event.getChanges();
        int index$iv = 0;
        int size = changes.size();
        while (true) {
            boolean remove = false;
            if (index$iv >= size) {
                this.isIn = false;
                this.hasExited = PointerEventType.m4015equalsimpl0(event.getType(), PointerEventType.INSTANCE.m4020getExit7fucELk());
                return;
            }
            Object item$iv = changes.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (!change.getPressed() && (!internalPointerEvent.m3995issuesEnterExitEvent0FcD4WY(change.getId()) || !this.isIn)) {
                remove = true;
            }
            if (remove) {
                this.pointerIds.remove(PointerId.m4045boximpl(change.getId()));
            }
            index$iv++;
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
