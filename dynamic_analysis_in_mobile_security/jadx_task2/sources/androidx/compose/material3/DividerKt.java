package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DividerKt {
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public static final void m1176Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        int i3;
        float fM4873constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1562471785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)46@1862L5,53@2019L131:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(j)) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    f = DividerDefaults.INSTANCE.m1175getThicknessD9Ej5fM();
                }
                if ((i2 & 4) != 0) {
                    j = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562471785, i, -1, "androidx.compose.material3.Divider (Divider.kt:43)");
            }
            composerStartRestartGroup.startReplaceableGroup(1232935509);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*49@1958L7");
            if (Dp.m4878equalsimpl0(f, Dp.INSTANCE.m4891getHairlineD9Ej5fM())) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM4873constructorimpl = Dp.m4873constructorimpl(1.0f / ((Density) objConsume).getDensity());
            } else {
                fM4873constructorimpl = f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m159backgroundbw27NRU$default(SizeKt.m513height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), fM4873constructorimpl), j, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        final long j2 = j;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DividerKt$Divider$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                DividerKt.m1176Divider9IZ8Weo(modifier2, f2, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
