package androidx.compose.material3;

import android.view.View;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001aq\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u000726\u0010 \u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u0013H\u0003\u001a6\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010)\u001a3\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010,\u001a\u00020-H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a-\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020-2\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0\u0013H\u0007¢\u0006\u0002\u00103\u001aX\u00104\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00106\u001a\u00020%2,\u00107\u001a(\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0015H\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00069"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-xOkiWaM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ModalBottomSheet-EP0qOeE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetAnchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "Landroidx/compose/material3/SheetValue;", "state", "animateTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "target", "", "velocity", "snapTo", "ModalBottomSheetPopup", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "modalBottomSheetSwipeable", "anchorChangeHandler", "screenHeight", "onDragStopped", "Lkotlinx/coroutines/CoroutineScope;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheet_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e  */
    /* JADX INFO: renamed from: ModalBottomSheet-EP0qOeE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1280ModalBottomSheetEP0qOeE(final kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.ui.Modifier r35, androidx.compose.material3.SheetState r36, androidx.compose.ui.graphics.Shape r37, long r38, long r40, float r42, long r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.foundation.layout.WindowInsets r46, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m1280ModalBottomSheetEP0qOeE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use ModalBottomSheet overload with windowInset parameter.")
    /* JADX INFO: renamed from: ModalBottomSheet-xOkiWaM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m1281ModalBottomSheetxOkiWaM(final kotlin.jvm.functions.Function0 r33, androidx.compose.ui.Modifier r34, androidx.compose.material3.SheetState r35, androidx.compose.ui.graphics.Shape r36, long r37, long r39, float r41, long r42, kotlin.jvm.functions.Function2 r44, final kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m1281ModalBottomSheetxOkiWaM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(1)318@14402L69:ModalBottomSheet.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.rememberModalBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:315)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(z2, function12, SheetValue.Hidden, false, composer, (i & 14) | 384 | (i & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1282Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionClearAndSetSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)327@14631L121,346@15192L62,342@15086L168:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053897700, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:321)");
            }
            if (j != Color.INSTANCE.m2665getUnspecified0d7_KjU()) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                composerStartRestartGroup.startReplaceableGroup(-1858721447);
                ComposerKt.sourceInformation(composerStartRestartGroup, "333@14864L124");
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(function0);
                    ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1 modalBottomSheet_androidKt$Scrim$dismissSheet$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || modalBottomSheet_androidKt$Scrim$dismissSheet$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        modalBottomSheet_androidKt$Scrim$dismissSheet$1$1RememberedValue = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheet_androidKt$Scrim$dismissSheet$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheet_androidKt$Scrim$dismissSheet$1$1RememberedValue), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$dismissSheet$2
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    companionClearAndSetSemantics = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionClearAndSetSemantics);
                Color colorM2619boximpl = Color.m2619boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(colorM2619boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope Canvas) {
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            DrawScope.m3167drawRectnJ9OG0$default(Canvas, j, 0L, 0L, ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$2(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                ModalBottomSheet_androidKt.m1282Scrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier modalBottomSheetSwipeable(Modifier modifier, final SheetState sheetState, AnchorChangeHandler<SheetValue> anchorChangeHandler, final float f, Function2<? super CoroutineScope, ? super Float, Unit> function2) {
        return SwipeableV2Kt.swipeAnchors(DraggableKt.draggable(modifier, sheetState.getSwipeableState$material3_release().getSwipeDraggableState(), Orientation.Vertical, (188 & 4) != 0 ? true : sheetState.isVisible(), (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : sheetState.getSwipeableState$material3_release().isAnimationRunning(), (188 & 32) != 0 ? new DraggableKt.C01541(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new C03101(function2), (188 & 128) != 0 ? false : false), sheetState.getSwipeableState$material3_release(), SetsKt.setOf((Object[]) new SheetValue[]{SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded}), anchorChangeHandler, new Function2<SheetValue, IntSize, Float>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.modalBottomSheetSwipeable.2

            /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2$WhenMappings */
            /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(SheetValue sheetValue, IntSize intSize) {
                return m1286invokeO0kMr_c(sheetValue, intSize.getPackedValue());
            }

            /* JADX INFO: renamed from: invoke-O0kMr_c, reason: not valid java name */
            public final Float m1286invokeO0kMr_c(SheetValue value, long j) {
                Intrinsics.checkNotNullParameter(value, "value");
                int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
                if (i == 1) {
                    return Float.valueOf(f);
                }
                if (i == 2) {
                    if (IntSize.m5032getHeightimpl(j) >= f / 2 && !sheetState.getSkipPartiallyExpanded()) {
                        return Float.valueOf(f / 2.0f);
                    }
                    return null;
                }
                if (i == 3) {
                    if (IntSize.m5032getHeightimpl(j) != 0) {
                        return Float.valueOf(Math.max(0.0f, f - IntSize.m5032getHeightimpl(j)));
                    }
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C03101 extends FunctionReferenceImpl implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object>, SuspendFunction {
        C03101(Object obj) {
            super(3, obj, Intrinsics.Kotlin.class, "suspendConversion0", "modalBottomSheetSwipeable$suspendConversion0(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            return ModalBottomSheet_androidKt.modalBottomSheetSwipeable$suspendConversion0((Function2) this.receiver, coroutineScope, f, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object modalBottomSheetSwipeable$suspendConversion0(Function2 function2, CoroutineScope coroutineScope, float f, Continuation continuation) {
        function2.invoke(coroutineScope, Boxing.boxFloat(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchorChangeHandler<SheetValue> ModalBottomSheetAnchorChangeHandler(final SheetState sheetState, final Function2<? super SheetValue, ? super Float, Unit> function2, final Function1<? super SheetValue, Unit> function1) {
        return new AnchorChangeHandler<SheetValue>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetAnchorChangeHandler.1

            /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetAnchorChangeHandler$1$WhenMappings */
            /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(SheetValue previousTarget, Map<SheetValue, Float> previousAnchors, Map<SheetValue, Float> newAnchors) {
                SheetValue sheetValue;
                Intrinsics.checkNotNullParameter(previousTarget, "previousTarget");
                Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float f = previousAnchors.get(previousTarget);
                int i = WhenMappings.$EnumSwitchMapping$0[previousTarget.ordinal()];
                if (i == 1) {
                    sheetValue = SheetValue.Hidden;
                } else if (i == 2 || i == 3) {
                    if (newAnchors.containsKey(SheetValue.PartiallyExpanded)) {
                        sheetValue = SheetValue.PartiallyExpanded;
                    } else {
                        sheetValue = newAnchors.containsKey(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (Intrinsics.areEqual(((Number) MapsKt.getValue(newAnchors, sheetValue)).floatValue(), f)) {
                    return;
                }
                if (sheetState.getSwipeableState$material3_release().isAnimationRunning() || previousAnchors.isEmpty()) {
                    function2.invoke(sheetValue, Float.valueOf(sheetState.getSwipeableState$material3_release().getLastVelocity()));
                } else {
                    function1.invoke(sheetValue);
                }
            }
        };
    }

    public static final void ModalBottomSheetPopup(final Function0<Unit> onDismissRequest, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-627217336);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetPopup)P(1,2)420@17875L7,421@17896L38,422@17963L28,423@18018L29,424@18081L621,446@18708L217:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onDismissRequest) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627217336, i3, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:415)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View view = (View) objConsume;
            UUID id = (UUID) RememberSaveableKt.m2276rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, composerStartRestartGroup, 3080, 6);
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composerStartRestartGroup, (i3 >> 6) & 14);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ModalBottomSheetWindow modalBottomSheetWindow = new ModalBottomSheetWindow(onDismissRequest, view, id);
                modalBottomSheetWindow.setCustomContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(861223805, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1
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

                    public final void invoke(Composer composer2, int i4) {
                        ComposerKt.sourceInformation(composer2, "C433@18369L285:ModalBottomSheet.android.kt#uh7d8r");
                        if ((i4 & 11) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861223805, i4, -1, "androidx.compose.material3.ModalBottomSheetPopup.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:432)");
                            }
                            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(WindowInsetsPaddingKt.windowInsetsPadding(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.popup(semantics);
                                }
                            }, 1, null), windowInsets));
                            State<Function2<Composer, Integer, Unit>> state = stateRememberUpdatedState;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume2;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierImePadding);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composer2);
                            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 321876634, "C439@18616L16:ModalBottomSheet.android.kt#uh7d8r");
                            ModalBottomSheet_androidKt.ModalBottomSheetPopup$lambda$5(state).invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetWindow);
                obj = modalBottomSheetWindow;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final ModalBottomSheetWindow modalBottomSheetWindow2 = (ModalBottomSheetWindow) obj;
            EffectsKt.DisposableEffect(modalBottomSheetWindow2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetPopup.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    modalBottomSheetWindow2.show();
                    final ModalBottomSheetWindow modalBottomSheetWindow3 = modalBottomSheetWindow2;
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            modalBottomSheetWindow3.disposeComposition();
                            modalBottomSheetWindow3.dismiss();
                        }
                    };
                }
            }, composerStartRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetPopup.2
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

            public final void invoke(Composer composer2, int i4) {
                ModalBottomSheet_androidKt.ModalBottomSheetPopup(onDismissRequest, windowInsets, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$5(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
