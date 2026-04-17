package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierLocalModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    default ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    default <T> void provide(ModifierLocal<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(getProvidedValues() != EmptyMap.INSTANCE)) {
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        }
        if (!getProvidedValues().contains$ui_release(key)) {
            throw new IllegalArgumentException(("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + key + " was not found.").toString());
        }
        getProvidedValues().mo4279set$ui_release(key, value);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    default <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        ModifierLocalModifierNode modifierLocalModifierNode;
        int i;
        boolean z;
        NodeChain nodes;
        boolean z2;
        int i2;
        int i3;
        int i4;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        if (!getNode().getIsAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ModifierLocalModifierNode modifierLocalModifierNode2 = this;
        int iM4398constructorimpl = NodeKind.m4398constructorimpl(32);
        boolean z3 = false;
        if (!modifierLocalModifierNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = modifierLocalModifierNode2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(modifierLocalModifierNode2);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM4398constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM4398constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node nodePop = parent;
                        while (nodePop != null) {
                            ModifierLocalModifierNode modifierLocalModifierNode3 = modifierLocalModifierNode2;
                            if (nodePop instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode4 = (ModifierLocalModifierNode) nodePop;
                                z2 = z3;
                                if (modifierLocalModifierNode4.getProvidedValues().contains$ui_release(modifierLocal)) {
                                    return (T) modifierLocalModifierNode4.getProvidedValues().get$ui_release(modifierLocal);
                                }
                                i2 = iM4398constructorimpl;
                            } else {
                                z2 = z3;
                                int i5 = 1;
                                if (((nodePop.getKindSet() & iM4398constructorimpl) != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                    i2 = iM4398constructorimpl;
                                } else {
                                    int i6 = 0;
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                                    while (delegate$ui_release != null) {
                                        Modifier.Node node = delegate$ui_release;
                                        if (((node.getKindSet() & iM4398constructorimpl) != 0 ? i5 : 0) != 0) {
                                            i6++;
                                            if (i6 == i5) {
                                                nodePop = node;
                                                i3 = iM4398constructorimpl;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    i3 = iM4398constructorimpl;
                                                    i4 = i6;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    i3 = iM4398constructorimpl;
                                                    i4 = i6;
                                                    mutableVector = mutableVector2;
                                                }
                                                Modifier.Node node2 = nodePop;
                                                if (node2 != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node2);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                mutableVector2 = mutableVector;
                                                i6 = i4;
                                            }
                                        } else {
                                            i3 = iM4398constructorimpl;
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        iM4398constructorimpl = i3;
                                        i5 = 1;
                                    }
                                    i2 = iM4398constructorimpl;
                                    if (i6 == 1) {
                                        modifierLocalModifierNode2 = modifierLocalModifierNode3;
                                        z3 = z2;
                                        iM4398constructorimpl = i2;
                                    }
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                            modifierLocalModifierNode2 = modifierLocalModifierNode3;
                            z3 = z2;
                            iM4398constructorimpl = i2;
                        }
                    }
                    parent = parent.getParent();
                    modifierLocalModifierNode2 = modifierLocalModifierNode2;
                    z3 = z3;
                    iM4398constructorimpl = iM4398constructorimpl;
                }
                modifierLocalModifierNode = modifierLocalModifierNode2;
                i = iM4398constructorimpl;
                z = z3;
            } else {
                modifierLocalModifierNode = modifierLocalModifierNode2;
                i = iM4398constructorimpl;
                z = z3;
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            modifierLocalModifierNode2 = modifierLocalModifierNode;
            z3 = z;
            iM4398constructorimpl = i;
        }
        return modifierLocal.getDefaultFactory$ui_release().invoke();
    }
}
