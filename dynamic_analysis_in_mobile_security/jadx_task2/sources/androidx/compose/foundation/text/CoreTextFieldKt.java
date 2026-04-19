package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a \u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0002\u001a0\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0002\u001a\u0010\u00106\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a5\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00101\u001a\u000202H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "state", "Landroidx/compose/foundation/text/TextFieldState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "onBlur", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:107:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0783  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:315:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r46, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r47, androidx.compose.ui.Modifier r48, androidx.compose.ui.text.TextStyle r49, androidx.compose.ui.text.input.VisualTransformation r50, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.ui.graphics.Brush r53, boolean r54, int r55, int r56, androidx.compose.ui.text.input.ImeOptions r57, androidx.compose.foundation.text.KeyboardActions r58, boolean r59, boolean r60, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 2199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextFieldRootBox)P(2,1)702@31477L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:697)");
        }
        int i2 = (i & 14) | 384;
        composerStartRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
        int i3 = i2 >> 3;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, (i3 & 112) | (i3 & 14));
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i4 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
        Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2270setimpl(composerM2263constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM2263constructorimpl.getInserting() || !Intrinsics.areEqual(composerM2263constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2263constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2263constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 112));
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1087270836, "C703@31533L33:CoreTextField.kt#423gt5");
        composerStartRestartGroup.startReplaceableGroup(-1985516685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5");
        function2.invoke(composerStartRestartGroup, Integer.valueOf(((((i >> 3) & 112) | 8) >> 3) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                CoreTextFieldKt.CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final TextFieldState textFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m756invokeZmokQxo(keyEvent.m3604unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m756invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                if (textFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m758cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m941deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (inputSession = textFieldState.getInputSession()) == null) {
                return;
            }
            inputSession.showSoftwareKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        if (textFieldState.getHasFocus()) {
            textFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
            notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
        } else {
            onBlur(textFieldState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlur(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m4401getMaximpl(textFieldValue.getSelection()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else if (iOriginalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m5032getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionToolbarAndHandles)1044@45268L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1025)");
        }
        if (z) {
            TextFieldState state = textFieldSelectionManager.getState();
            TextLayoutResult textLayoutResult = null;
            if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                if (!(textFieldSelectionManager.getState() != null ? r3.getIsLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m4398getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                    int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m4404getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m4399getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                    composerStartRestartGroup.startReplaceableGroup(-498389736);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1037@44945L203");
                    TextFieldState state2 = textFieldSelectionManager.getState();
                    if (state2 != null && state2.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, 518);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldState state3 = textFieldSelectionManager.getState();
                    if (state3 != null && state3.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, 518);
                    }
                }
                TextFieldState state4 = textFieldSelectionManager.getState();
                if (state4 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state4.setShowFloatingToolbar(false);
                    }
                    if (state4.getHasFocus()) {
                        if (state4.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager manager, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)1070@46313L50,1071@46426L7,1078@46683L205,1072@46443L483:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1068)");
        }
        TextFieldState state = manager.getState();
        if (state != null && state.getShowCursorHandle()) {
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(manager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = manager.cursorDragObserver$foundation_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final long jM946getCursorPositiontuRUvjQ$foundation_release = manager.m946getCursorPositiontuRUvjQ$foundation_release((Density) objConsume);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, textDragObserver, new C02261(textDragObserver, null));
            Offset offsetM2379boximpl = Offset.m2379boximpl(jM946getCursorPositiontuRUvjQ$foundation_release);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(offsetM2379boximpl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        semantics.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, jM946getCursorPositiontuRUvjQ$foundation_release, null));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m736CursorHandleULxng0E(jM946getCursorPositiontuRUvjQ$foundation_release, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue2, 1, null), null, composerStartRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                CoreTextFieldKt.TextFieldCursorHandle(manager, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot snapshotCreateNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = textFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, textFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            snapshotCreateNonObservableSnapshot.dispose();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1", f = "CoreTextField.kt", i = {}, l = {1077}, m = "invokeSuspend", n = {}, s = {})
    static final class C02261 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02261(TextDragObserver textDragObserver, Continuation<? super C02261> continuation) {
            super(2, continuation);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02261 c02261 = new C02261(this.$observer, continuation);
            c02261.L$0 = obj;
            return c02261;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C02261) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver((PointerInputScope) this.L$0, this.$observer, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
