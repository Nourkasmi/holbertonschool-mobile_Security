package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0010*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "SemanticsNode", "layoutNode", "mergingEnabled", "", "outerSemanticsNode", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsNodeKt {
    /* JADX WARN: Removed duplicated region for block: B:39:0x007e A[LOOP:0: B:5:0x001b->B:39:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083 A[EDGE_INSN: B:44:0x0083->B:40:0x0083 BREAK  A[LOOP:0: B:5:0x001b->B:39:0x007e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.semantics.SemanticsNode SemanticsNode(androidx.compose.ui.node.LayoutNode r10, boolean r11) {
        /*
            java.lang.String r0 = "layoutNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.node.NodeChain r0 = r10.getNodes()
            r1 = 8
            int r1 = androidx.compose.ui.node.NodeKind.m4081constructorimpl(r1)
            int r2 = androidx.compose.ui.node.NodeChain.access$getAggregateChildKindSet(r0)
            r2 = r2 & r1
            r3 = 0
            if (r2 == 0) goto L83
            androidx.compose.ui.Modifier$Node r0 = r0.getHead()
        L1b:
            if (r0 == 0) goto L83
            int r2 = r0.getKindSet()
            r2 = r2 & r1
            if (r2 == 0) goto L77
            r2 = r0
            r4 = r3
        L26:
            if (r2 == 0) goto L77
            boolean r5 = r2 instanceof androidx.compose.ui.node.SemanticsModifierNode
            if (r5 == 0) goto L2e
            r3 = r2
            goto L83
        L2e:
            int r5 = r2.getKindSet()
            r5 = r5 & r1
            if (r5 == 0) goto L72
            boolean r5 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L72
            r5 = r2
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.getDelegate()
            r6 = 0
            r7 = r6
        L42:
            r8 = 1
            if (r5 == 0) goto L6f
            int r9 = r5.getKindSet()
            r9 = r9 & r1
            if (r9 == 0) goto L6a
            int r7 = r7 + 1
            if (r7 != r8) goto L52
            r2 = r5
            goto L6a
        L52:
            if (r4 != 0) goto L5d
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            r8 = 16
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r8]
            r4.<init>(r8, r6)
        L5d:
            if (r2 == 0) goto L65
            if (r4 == 0) goto L64
            r4.add(r2)
        L64:
            r2 = r3
        L65:
            if (r4 == 0) goto L6a
            r4.add(r5)
        L6a:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild()
            goto L42
        L6f:
            if (r7 != r8) goto L72
            goto L26
        L72:
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r4)
            goto L26
        L77:
            int r2 = r0.getAggregateChildKindSet()
            r2 = r2 & r1
            if (r2 == 0) goto L83
            androidx.compose.ui.Modifier$Node r0 = r0.getChild()
            goto L1b
        L83:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.ui.node.SemanticsModifierNode r3 = (androidx.compose.ui.node.SemanticsModifierNode) r3
            androidx.compose.ui.Modifier$Node r0 = r3.getNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r10.getCollapsedSemantics$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.ui.semantics.SemanticsNode r2 = new androidx.compose.ui.semantics.SemanticsNode
            r2.<init>(r0, r11, r10, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNodeKt.SemanticsNode(androidx.compose.ui.node.LayoutNode, boolean):androidx.compose.ui.semantics.SemanticsNode");
    }

    public static /* synthetic */ SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        }
        return SemanticsNode(semanticsModifierNode, z, layoutNode);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode outerSemanticsNode, boolean z, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Modifier.Node node = outerSemanticsNode.getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release == null) {
            collapsedSemantics$ui_release = new SemanticsConfiguration();
        }
        return new SemanticsNode(node, z, layoutNode, collapsedSemantics$ui_release);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0087 A[LOOP:0: B:5:0x001b->B:41:0x0087, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c A[EDGE_INSN: B:46:0x008c->B:42:0x008c BREAK  A[LOOP:0: B:5:0x001b->B:41:0x0087], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.node.SemanticsModifierNode getOuterMergingSemantics(androidx.compose.ui.node.LayoutNode r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.compose.ui.node.NodeChain r9 = r9.getNodes()
            r0 = 8
            int r0 = androidx.compose.ui.node.NodeKind.m4081constructorimpl(r0)
            int r1 = androidx.compose.ui.node.NodeChain.access$getAggregateChildKindSet(r9)
            r1 = r1 & r0
            r2 = 0
            if (r1 == 0) goto L8c
            androidx.compose.ui.Modifier$Node r9 = r9.getHead()
        L1b:
            if (r9 == 0) goto L8c
            int r1 = r9.getKindSet()
            r1 = r1 & r0
            if (r1 == 0) goto L80
            r1 = r9
            r3 = r2
        L26:
            if (r1 == 0) goto L80
            boolean r4 = r1 instanceof androidx.compose.ui.node.SemanticsModifierNode
            if (r4 == 0) goto L37
            r4 = r1
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            boolean r4 = r4.getShouldMergeDescendantSemantics()
            if (r4 == 0) goto L7b
            r2 = r1
            goto L8c
        L37:
            int r4 = r1.getKindSet()
            r4 = r4 & r0
            if (r4 == 0) goto L7b
            boolean r4 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L7b
            r4 = r1
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate()
            r5 = 0
            r6 = r5
        L4b:
            r7 = 1
            if (r4 == 0) goto L78
            int r8 = r4.getKindSet()
            r8 = r8 & r0
            if (r8 == 0) goto L73
            int r6 = r6 + 1
            if (r6 != r7) goto L5b
            r1 = r4
            goto L73
        L5b:
            if (r3 != 0) goto L66
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            r7 = 16
            androidx.compose.ui.Modifier$Node[] r7 = new androidx.compose.ui.Modifier.Node[r7]
            r3.<init>(r7, r5)
        L66:
            if (r1 == 0) goto L6e
            if (r3 == 0) goto L6d
            r3.add(r1)
        L6d:
            r1 = r2
        L6e:
            if (r3 == 0) goto L73
            r3.add(r4)
        L73:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild()
            goto L4b
        L78:
            if (r6 != r7) goto L7b
            goto L26
        L7b:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r3)
            goto L26
        L80:
            int r1 = r9.getAggregateChildKindSet()
            r1 = r1 & r0
            if (r1 == 0) goto L8c
            androidx.compose.ui.Modifier$Node r9 = r9.getChild()
            goto L1b
        L8c:
            androidx.compose.ui.node.SemanticsModifierNode r2 = (androidx.compose.ui.node.SemanticsModifierNode) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNodeKt.getOuterMergingSemantics(androidx.compose.ui.node.LayoutNode):androidx.compose.ui.node.SemanticsModifierNode");
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> selector) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (selector.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
