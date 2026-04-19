package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusTransactions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a!\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a!\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000e\u001a!\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean requestFocus(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[m2341performCustomRequestFocusMxy_nc0(focusTargetNode, FocusDirection.INSTANCE.m2318getEnterdhqQ8s()).ordinal()];
        if (i == 1) {
            return performRequestFocus(focusTargetNode);
        }
        if (i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        boolean z;
        NodeChain nodes;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return true;
        }
        Modifier.Node node = null;
        if (i == 3) {
            z = clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode);
            if (!z) {
                return z;
            }
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return z;
        }
        if (i == 4) {
            FocusTargetNode focusTargetNode2 = focusTargetNode;
            int iM4081constructorimpl = NodeKind.m4081constructorimpl(1024);
            if (!focusTargetNode2.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent = focusTargetNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM4081constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM4081constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = parent;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    node = nodePop;
                                    break loop0;
                                }
                                if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & iM4081constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
            FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
            if (focusTargetNode3 != null) {
                return requestFocusForChild(focusTargetNode3, focusTargetNode);
            }
            z = requestFocusForOwner(focusTargetNode) && grantFocus(focusTargetNode);
            if (!z) {
                return z;
            }
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Captured);
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return true;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            focusTargetNode.setFocusState(FocusStateImpl.Active);
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        } else {
            if (i == 2) {
                if (!z) {
                    return z;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (!z2) {
                    return z;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return z;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!clearChildFocus(focusTargetNode, z, z2)) {
                    return false;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
        }
        return true;
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt.grantFocus.1
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
                focusTargetNode.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Active);
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        Modifier.Node node;
        Modifier.Node nodePop;
        NodeChain nodes;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode3 = focusTargetNode2;
        int iM4081constructorimpl = NodeKind.m4081constructorimpl(1024);
        if (!focusTargetNode3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = focusTargetNode3.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode3);
        loop0: while (true) {
            node = null;
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM4081constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM4081constructorimpl) != 0) {
                        nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & iM4081constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
        }
        if (!Intrinsics.areEqual(nodePop, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1) {
            boolean zGrantFocus = grantFocus(focusTargetNode2);
            if (!zGrantFocus) {
                return zGrantFocus;
            }
            focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return zGrantFocus;
        }
        if (i2 == 2) {
            return false;
        }
        if (i2 == 3) {
            if (FocusTraversalKt.getActiveChild(focusTargetNode) == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            boolean z = clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2);
            if (z) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
            }
            return z;
        }
        if (i2 == 4) {
            FocusTargetNode focusTargetNode4 = focusTargetNode;
            int iM4081constructorimpl2 = NodeKind.m4081constructorimpl(1024);
            if (!focusTargetNode4.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent2 = focusTargetNode4.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode4);
            loop4: while (true) {
                if (layoutNodeRequireLayoutNode2 == null) {
                    break;
                }
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM4081constructorimpl2) != 0) {
                    while (parent2 != null) {
                        if ((parent2.getKindSet() & iM4081constructorimpl2) != 0) {
                            Modifier.Node nodePop2 = parent2;
                            MutableVector mutableVector2 = null;
                            while (nodePop2 != null) {
                                if (nodePop2 instanceof FocusTargetNode) {
                                    node = nodePop2;
                                    break loop4;
                                }
                                if ((nodePop2.getKindSet() & iM4081constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) nodePop2).getDelegate(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & iM4081constructorimpl2) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                nodePop2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop2);
                                                    }
                                                    nodePop2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                nodePop2 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent2 = parent2.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent2 = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            FocusTargetNode focusTargetNode5 = (FocusTargetNode) node;
            if (focusTargetNode5 == null && requestFocusForOwner(focusTargetNode)) {
                focusTargetNode.setFocusState(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return requestFocusForChild(focusTargetNode, focusTargetNode2);
            }
            if (focusTargetNode5 == null || !requestFocusForChild(focusTargetNode5, focusTargetNode)) {
                return false;
            }
            boolean zRequestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
            if (focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent) {
                return zRequestFocusForChild;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        Owner owner;
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator();
        if (coordinator$ui_release == null || (layoutNode = coordinator$ui_release.getLayoutNode()) == null || (owner = layoutNode.getOwner()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner.requestFocus();
    }

    /* JADX INFO: renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m2341performCustomRequestFocusMxy_nc0(FocusTargetNode performCustomRequestFocus, int i) {
        Modifier.Node nodePop;
        NodeChain nodes;
        Intrinsics.checkNotNullParameter(performCustomRequestFocus, "$this$performCustomRequestFocus");
        int i2 = WhenMappings.$EnumSwitchMapping$1[performCustomRequestFocus.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 == 3) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomRequestFocus);
            if (activeChild != null) {
                return m2338performCustomClearFocusMxy_nc0(activeChild, i);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (i2 == 4) {
            FocusTargetNode focusTargetNode = performCustomRequestFocus;
            int iM4081constructorimpl = NodeKind.m4081constructorimpl(1024);
            if (!focusTargetNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    nodePop = null;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM4081constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM4081constructorimpl) != 0) {
                            nodePop = parent;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    break loop0;
                                }
                                if ((nodePop.getKindSet() & iM4081constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & iM4081constructorimpl) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                nodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
            if (focusTargetNode2 == null) {
                return CustomDestinationResult.None;
            }
            int i4 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
            if (i4 == 1) {
                return m2339performCustomEnterMxy_nc0(focusTargetNode2, i);
            }
            if (i4 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i4 == 3) {
                return m2341performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
            }
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            CustomDestinationResult customDestinationResultM2341performCustomRequestFocusMxy_nc0 = m2341performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
            CustomDestinationResult customDestinationResult = customDestinationResultM2341performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? customDestinationResultM2341performCustomRequestFocusMxy_nc0 : null;
            return customDestinationResult == null ? m2339performCustomEnterMxy_nc0(focusTargetNode2, i) : customDestinationResult;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m2338performCustomClearFocusMxy_nc0(FocusTargetNode performCustomClearFocus, int i) {
        Intrinsics.checkNotNullParameter(performCustomClearFocus, "$this$performCustomClearFocus");
        int i2 = WhenMappings.$EnumSwitchMapping$1[performCustomClearFocus.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomClearFocus);
                if (activeChild == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                CustomDestinationResult customDestinationResultM2338performCustomClearFocusMxy_nc0 = m2338performCustomClearFocusMxy_nc0(activeChild, i);
                if (customDestinationResultM2338performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    customDestinationResultM2338performCustomClearFocusMxy_nc0 = null;
                }
                return customDestinationResultM2338performCustomClearFocusMxy_nc0 == null ? m2340performCustomExitMxy_nc0(performCustomClearFocus, i) : customDestinationResultM2338performCustomClearFocusMxy_nc0;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m2339performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2306boximpl(i));
                if (focusRequesterInvoke != FocusRequester.INSTANCE.getDefault()) {
                    if (focusRequesterInvoke == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m2340performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2306boximpl(i));
                if (focusRequesterInvoke != FocusRequester.INSTANCE.getDefault()) {
                    if (focusRequesterInvoke == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
