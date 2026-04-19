package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aS\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0010\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0019\u0010\u0013\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX WARN: Removed duplicated region for block: B:115:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0315 A[LOOP:0: B:122:0x0313->B:123:0x0315, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x033d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x044a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x062b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Switch(final boolean r44, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, boolean r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.material.SwitchColors r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope $this$SwitchImpl, final boolean checked, final boolean enabled, final SwitchColors colors, final Function0<Float> function0, final InteractionSource interactionSource, Composer $composer, final int $changed) {
        Object value$iv$iv;
        SwitchKt$SwitchImpl$1$1 value$iv$iv2;
        float f;
        Object value$iv$iv3;
        String str;
        int i;
        long jSwitchImpl$lambda$18;
        Object value$iv$iv4;
        Composer $composer2 = $composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation($composer2, "C(SwitchImpl)P(!1,2!1,4)219@8983L46,221@9069L614,221@9035L648,240@9886L28,244@10009L81,241@9919L171,247@10120L28,248@10198L7,*249@10257L7,251@10368L6,250@10307L228,260@10627L43,263@10780L59,257@10540L475:Switch.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$SwitchImpl) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(checked) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, $dirty2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:212)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
            int i2 = (($dirty2 >> 15) & 14) | 48;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(interactionSource) | $composer2.changed(interactions);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SwitchKt$SwitchImpl$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer2, (($dirty2 >> 15) & 14) | 64);
            boolean hasInteraction = !interactions.isEmpty();
            if (hasInteraction) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float elevation = f;
            final State<Color> stateTrackColor = colors.trackColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default($this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(stateTrackColor);
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
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
                        SwitchKt.m1210drawTrackRPmYEkk(Canvas, SwitchKt.SwitchImpl$lambda$16(stateTrackColor), Canvas.mo326toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo326toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) value$iv$iv3, $composer2, 0);
            State<Color> stateThumbColor = colors.thumbColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((Dp) objConsume2).m5226unboximpl();
            float arg0$iv2 = Dp.m5212constructorimpl(arg0$iv + elevation);
            $composer2.startReplaceableGroup(-539243578);
            ComposerKt.sourceInformation($composer2, "252@10443L36");
            if (Color.m2948equalsimpl0(SwitchImpl$lambda$18(stateThumbColor), MaterialTheme.INSTANCE.getColors($composer2, 6).m1038getSurface0d7_KjU()) && elevationOverlay != null) {
                str = "CC(remember)P(1):Composables.kt#9igjgp";
                i = 1157296644;
                jSwitchImpl$lambda$18 = elevationOverlay.mo1068apply7g2Lkgo(SwitchImpl$lambda$18(stateThumbColor), arg0$iv2, $composer2, 0);
            } else {
                str = "CC(remember)P(1):Composables.kt#9igjgp";
                i = 1157296644;
                jSwitchImpl$lambda$18 = SwitchImpl$lambda$18(stateThumbColor);
            }
            $composer2.endReplaceableGroup();
            State<Color> stateM69animateColorAsStateeuL9pac = SingleValueAnimationKt.m69animateColorAsStateeuL9pac(jSwitchImpl$lambda$18, null, null, null, $composer2, 0, 14);
            Modifier modifierAlign = $this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            int i3 = ($dirty2 >> 12) & 14;
            $composer2.startReplaceableGroup(i);
            ComposerKt.sourceInformation($composer2, str);
            boolean invalid$iv$iv3 = $composer2.changed(function0);
            Object it$iv$iv4 = $composer2.rememberedValue();
            if (invalid$iv$iv3 || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m5321boximpl(m1211invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1211invokeBjo55l4(Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(function0.invoke().floatValue()), 0);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m159backgroundbw27NRU(ShadowKt.m2619shadows4CzXII(SizeKt.m520requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) value$iv$iv4), interactionSource, RippleKt.m1284rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, (24 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (24 & 4) != 0 ? Dp.m5211compareTo0680j_4(24, Dp.m5212constructorimpl((float) 0)) > 0 : false, (24 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (24 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L), SwitchImpl$lambda$19(stateM69animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                SwitchKt.SwitchImpl($this$SwitchImpl, checked, enabled, colors, function0, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$16(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2957unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2957unboximpl();
    }

    private static final long SwitchImpl$lambda$19(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2957unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1210drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / 2;
        DrawScope.m3476drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, androidx.compose.ui.geometry.OffsetKt.Offset(strokeRadius, Offset.m2709getYimpl($this$drawTrack_u2dRPmYEkk.mo3488getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(trackWidth - strokeRadius, Offset.m2709getYimpl($this$drawTrack_u2dRPmYEkk.mo3488getCenterF1C5BW0())), strokeWidth, StrokeCap.INSTANCE.m3293getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    static {
        float fM5212constructorimpl = Dp.m5212constructorimpl(34);
        TrackWidth = fM5212constructorimpl;
        TrackStrokeWidth = Dp.m5212constructorimpl(14);
        float fM5212constructorimpl2 = Dp.m5212constructorimpl(20);
        ThumbDiameter = fM5212constructorimpl2;
        ThumbRippleRadius = Dp.m5212constructorimpl(24);
        DefaultSwitchPadding = Dp.m5212constructorimpl(2);
        SwitchWidth = fM5212constructorimpl;
        SwitchHeight = fM5212constructorimpl2;
        float arg0$iv = TrackWidth;
        float other$iv = ThumbDiameter;
        ThumbPathLength = Dp.m5212constructorimpl(arg0$iv - other$iv);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m5212constructorimpl(1);
        ThumbPressedElevation = Dp.m5212constructorimpl(6);
        SwitchVelocityThreshold = Dp.m5212constructorimpl(125);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
