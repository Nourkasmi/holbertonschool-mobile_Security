package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001aå\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u000204H\u0002\u001aÛ\u0001\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001aå\u0001\u00106\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010=\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0082\b\u001a\f\u0010A\u001a\u000204*\u00020\nH\u0002\u001a\f\u0010B\u001a\u00020\u0004*\u00020\nH\u0002\u001a!\u0010C\u001a\u00020\f*\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"ConsumeHorizontalFlingNestedScrollConnection", "Landroidx/compose/foundation/pager/ConsumeAllFlingOnDirection;", "ConsumeVerticalFlingNestedScrollConnection", "DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "pageCount", "HorizontalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerKt {
    private static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);
    private static final ConsumeAllFlingOnDirection ConsumeVerticalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Vertical);
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0116  */
    /* JADX INFO: renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m691HorizontalPagerxYaah8o(final androidx.compose.foundation.pager.PagerState r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.pager.PageSize r39, int r40, float r41, androidx.compose.ui.Alignment.Vertical r42, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r43, boolean r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r46, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r47, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m691HorizontalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @kotlin.ReplaceWith(expression = "HorizontalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* JADX INFO: renamed from: HorizontalPager-AlbwjTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m690HorizontalPagerAlbwjTQ(final int r35, androidx.compose.ui.Modifier r36, androidx.compose.foundation.pager.PagerState r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.pager.PageSize r39, int r40, float r41, androidx.compose.ui.Alignment.Vertical r42, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r43, boolean r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r46, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r47, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 1023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m690HorizontalPagerAlbwjTQ(int, androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0116  */
    /* JADX INFO: renamed from: VerticalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m693VerticalPagerxYaah8o(final androidx.compose.foundation.pager.PagerState r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.layout.PaddingValues r38, androidx.compose.foundation.pager.PageSize r39, int r40, float r41, androidx.compose.ui.Alignment.Horizontal r42, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r43, boolean r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r46, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r47, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m693VerticalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @kotlin.ReplaceWith(expression = "VerticalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* JADX INFO: renamed from: VerticalPager-AlbwjTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m692VerticalPagerAlbwjTQ(final int r34, androidx.compose.ui.Modifier r35, androidx.compose.foundation.pager.PagerState r36, androidx.compose.foundation.layout.PaddingValues r37, androidx.compose.foundation.pager.PageSize r38, int r39, float r40, androidx.compose.ui.Alignment.Horizontal r41, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r42, boolean r43, boolean r44, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r45, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r46, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 1023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m692VerticalPagerAlbwjTQ(int, androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final DecayAnimationSpec<Float> decayAnimationSpec, final float f) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.pager.PagerKt.SnapLayoutInfoProvider.1
            public final boolean isValidDistance(float f2) {
                return (f2 == Float.POSITIVE_INFINITY || f2 == Float.NEGATIVE_INFINITY) ? false : true;
            }

            public final PagerLayoutInfo getLayoutInfo() {
                return pagerState.getLayoutInfo$foundation_release();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(Density density, float f2) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                int size = visiblePagesInfo.size();
                float f3 = Float.NEGATIVE_INFINITY;
                float f4 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    PageInfo pageInfo = visiblePagesInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(density, PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), PagerStateKt.getSnapAlignmentStartToStart());
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f4) {
                        f4 = fCalculateDistanceToDesiredSnapPosition;
                    }
                }
                boolean zIsScrollingForward = PagerKt.isScrollingForward(pagerState);
                float fDragGestureDelta = (PagerKt.dragGestureDelta(pagerState) / getLayoutInfo().getPageSize()) - ((int) r2);
                float fSignum = Math.signum(f2);
                if (fSignum == 0.0f) {
                    f3 = Math.abs(fDragGestureDelta) > f ? f4 : f4;
                } else if (fSignum != 1.0f) {
                    if (fSignum != -1.0f) {
                        f3 = 0.0f;
                    }
                }
                if (isValidDistance(f3)) {
                    return f3;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(Density density) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                return getLayoutInfo().getPageSize();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(Density density, float f2) {
                int firstVisiblePage$foundation_release;
                PageInfo pageInfo;
                double dFloor;
                Intrinsics.checkNotNullParameter(density, "<this>");
                int pageSize$foundation_release = pagerState.getPageSize$foundation_release() + pagerState.getPageSpacing$foundation_release();
                float fCalculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, f2);
                if (f2 < 0.0f) {
                    firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release() + 1;
                } else {
                    firstVisiblePage$foundation_release = pagerState.getFirstVisiblePage$foundation_release();
                }
                List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                int size = visiblePagesInfo.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pageInfo = null;
                        break;
                    }
                    pageInfo = visiblePagesInfo.get(i);
                    if (pageInfo.getIndex() == firstVisiblePage$foundation_release) {
                        break;
                    }
                    i++;
                }
                PageInfo pageInfo2 = pageInfo;
                int offset = pageInfo2 != null ? pageInfo2.getOffset() : 0;
                float f3 = ((firstVisiblePage$foundation_release * pageSize$foundation_release) + fCalculateTargetValue) / pageSize$foundation_release;
                if (f2 > 0.0f) {
                    dFloor = Math.ceil(f3);
                } else {
                    dFloor = Math.floor(f3);
                }
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(firstVisiblePage$foundation_release, RangesKt.coerceIn((int) dFloor, 0, pagerState.getPageCount()), f2, pagerState.getPageSize$foundation_release(), pagerState.getPageSpacing$foundation_release()), 0, pagerState.getPageCount()) - firstVisiblePage$foundation_release) * pageSize$foundation_release) - Math.abs(offset), 0);
                return iCoerceAtLeast == 0 ? iCoerceAtLeast : iCoerceAtLeast * Math.signum(f2);
            }
        };
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState state, final boolean z, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation(composer, "C(pagerSemantics)P(1)843@38529L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, i, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:842)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1
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
                if (z) {
                    final PagerState pagerState = state;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.pageUp$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope2));
                        }
                    }, 1, null);
                    final PagerState pagerState2 = state;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.pageDown$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState2, coroutineScope3));
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState3 = state;
                final CoroutineScope coroutineScope4 = coroutineScope;
                SemanticsPropertiesKt.pageLeft$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState3, coroutineScope4));
                    }
                }, 1, null);
                final PagerState pagerState4 = state;
                final CoroutineScope coroutineScope5 = coroutineScope;
                SemanticsPropertiesKt.pageRight$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState4, coroutineScope5));
                    }
                }, 1, null);
            }
        }, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        return dragGestureDelta(pagerState) < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo$foundation_release().getOrientation() == Orientation.Horizontal) {
            return Offset.m2390getXimpl(pagerState.m701getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m2391getYimpl(pagerState.m701getUpDownDifferenceF1C5BW0$foundation_release());
    }
}
