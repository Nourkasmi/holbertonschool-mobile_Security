package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BeyondBoundsLayoutKt {
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m2305searchBeyondBoundsOMvw8(FocusTargetNode searchBeyondBounds, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        Modifier.Node nodePop;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int iM3852getBeforehoxUOeE;
        NodeChain nodes;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        FocusTargetNode focusTargetNode = searchBeyondBounds;
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
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM4081constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate;
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
                                                mutableVector.add(delegate);
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
        if ((focusTargetNode2 != null && Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), searchBeyondBounds.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        if (FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2326getUpdhqQ8s())) {
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3850getAbovehoxUOeE();
        } else if (FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2317getDowndhqQ8s())) {
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3853getBelowhoxUOeE();
        } else if (FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2321getLeftdhqQ8s())) {
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3854getLefthoxUOeE();
        } else if (FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2325getRightdhqQ8s())) {
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3855getRighthoxUOeE();
        } else if (FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2322getNextdhqQ8s())) {
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3851getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m2309equalsimpl0(i, FocusDirection.INSTANCE.m2324getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iM3852getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3852getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo634layouto7g1Pn8(iM3852getBeforehoxUOeE, block);
    }
}
