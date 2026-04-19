package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJn\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerTitle", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DateRangePickerTitle(final androidx.compose.material3.DateRangePickerState r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DateRangePickerHeadline(final androidx.compose.material3.DateRangePickerState r18, final androidx.compose.material3.DatePickerFormatter r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline(androidx.compose.material3.DateRangePickerState, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void DateRangePickerHeadline(final DateRangePickerState dateRangePickerState, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-861159957);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerHeadline)P(7!1,4,6,3,5,2)*379@16359L15,418@18064L168,417@18002L796:DateRangePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-861159957, i3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:368)");
            }
            StateData stateData = dateRangePickerState.getStateData();
            Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            String date$material3_release$default = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData.getSelectedStartDate().getValue(), stateData.getCalendarModel(), localeDefaultLocale, false, 8, null);
            String date$material3_release$default2 = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData.getSelectedEndDate().getValue(), stateData.getCalendarModel(), localeDefaultLocale, false, 8, null);
            String date$material3_release = datePickerFormatter.formatDate$material3_release(stateData.getSelectedStartDate().getValue(), stateData.getCalendarModel(), localeDefaultLocale, true);
            composerStartRestartGroup.startReplaceableGroup(-1212634278);
            String strM1465getStringNWtq28 = "";
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if (date$material3_release == null) {
                int value = stateData.getDisplayMode().getValue().getValue();
                if (DisplayMode.m1169equalsimpl0(value, DisplayMode.INSTANCE.m1174getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096411);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "398@17129L51");
                    date$material3_release = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1420getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1169equalsimpl0(value, DisplayMode.INSTANCE.m1173getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096500);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "399@17218L46");
                    date$material3_release = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1415getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-544548443);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            String date$material3_release2 = datePickerFormatter.formatDate$material3_release(stateData.getSelectedEndDate().getValue(), stateData.getCalendarModel(), localeDefaultLocale, true);
            composerStartRestartGroup.startReplaceableGroup(-1212633768);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if (date$material3_release2 == null) {
                int value2 = stateData.getDisplayMode().getValue().getValue();
                if (DisplayMode.m1169equalsimpl0(value2, DisplayMode.INSTANCE.m1174getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096919);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "409@17637L51");
                    strM1465getStringNWtq28 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1420getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1169equalsimpl0(value2, DisplayMode.INSTANCE.m1173getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922097008);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "410@17726L46");
                    strM1465getStringNWtq28 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1415getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-544532695);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                strM1465getStringNWtq28 = date$material3_release2;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final String str3 = str + ": " + date$material3_release;
            final String str4 = str2 + ": " + strM1465getStringNWtq28;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(str3) | composerStartRestartGroup.changed(str4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1$1
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
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        SemanticsPropertiesKt.m4259setLiveRegionhR3wRGc(clearAndSetSemantics, LiveRegionMode.INSTANCE.m4238getPolite0phEisY());
                        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str3 + ", " + str4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM391spacedBy0680j_4 = Arrangement.INSTANCE.m391spacedBy0680j_4(Dp.m4873constructorimpl(4));
            composerStartRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM391spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierClearAndSetSemantics);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2263constructorimpl = Updater.m2263constructorimpl(composerStartRestartGroup);
            Updater.m2270setimpl(composerM2263constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2270setimpl(composerM2263constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2270setimpl(composerM2263constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2270setimpl(composerM2263constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2254boximpl(SkippableUpdater.m2255constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 990390577, "C430@18586L16:DateRangePicker.kt#uh7d8r");
            if (date$material3_release$default != null) {
                composerStartRestartGroup.startReplaceableGroup(990390609);
                ComposerKt.sourceInformation(composerStartRestartGroup, "426@18452L31");
                composer2 = composerStartRestartGroup;
                TextKt.m1552Text4IGK_g(date$material3_release$default, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(990390686);
                ComposerKt.sourceInformation(composer2, "428@18529L22");
                function2.invoke(composer2, Integer.valueOf((i3 >> 15) & 14));
                composer2.endReplaceableGroup();
            }
            function23.invoke(composer2, Integer.valueOf((i3 >> 21) & 14));
            if (date$material3_release$default2 != null) {
                composer2.startReplaceableGroup(990390828);
                ComposerKt.sourceInformation(composer2, "432@18671L29");
                TextKt.m1552Text4IGK_g(date$material3_release$default2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(990390903);
                ComposerKt.sourceInformation(composer2, "434@18746L20");
                function22.invoke(composer2, Integer.valueOf((i3 >> 18) & 14));
                composer2.endReplaceableGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                DateRangePickerDefaults.this.DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, modifier, str, str2, function2, function22, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
