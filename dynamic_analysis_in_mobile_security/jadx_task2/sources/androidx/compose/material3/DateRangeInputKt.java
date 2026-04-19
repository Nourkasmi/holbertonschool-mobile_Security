package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
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

/* JADX INFO: compiled from: DateRangeInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0001¢\u0006\u0002\u0010\r\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "stateData", "Landroidx/compose/material3/StateData;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m4873constructorimpl(8);

    public static final void DateRangeInputContent(final StateData stateData, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> dateValidator, Composer composer, final int i) {
        int i2;
        int i3;
        DateInputFormat dateInputFormat;
        String str;
        Locale locale;
        Composer composer2;
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(dateValidator, "dateValidator");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1163802470);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangeInputContent)P(2)37@1398L15,38@1440L97,41@1565L45,42@1645L44,43@1723L45,44@1797L50,45@1877L482,57@2364L1939:DateRangeInput.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(stateData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(dateFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(dateValidator) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1163802470, i4, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:31)");
            }
            Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(localeDefaultLocale);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = stateData.getCalendarModel().getDateInputFormat(localeDefaultLocale);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            DateInputFormat dateInputFormat2 = (DateInputFormat) objRememberedValue;
            String strM1465getStringNWtq28 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1411getDateInputInvalidForPatternadMyvUU(), composerStartRestartGroup, 6);
            String strM1465getStringNWtq282 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1413getDateInputInvalidYearRangeadMyvUU(), composerStartRestartGroup, 6);
            String strM1465getStringNWtq283 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1412getDateInputInvalidNotAllowedadMyvUU(), composerStartRestartGroup, 6);
            String strM1465getStringNWtq284 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1432getDateRangeInputInvalidRangeInputadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat2) | composerStartRestartGroup.changed(dateFormatter);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i3 = 6;
                dateInputFormat = dateInputFormat2;
                str = "CC(remember)P(1):Composables.kt#9igjgp";
                locale = localeDefaultLocale;
                DateInputValidator dateInputValidator = new DateInputValidator(stateData, dateInputFormat2, dateFormatter, dateValidator, strM1465getStringNWtq28, strM1465getStringNWtq282, strM1465getStringNWtq283, strM1465getStringNWtq284);
                composerStartRestartGroup.updateRememberedValue(dateInputValidator);
                objRememberedValue2 = dateInputValidator;
            } else {
                i3 = 6;
                dateInputFormat = dateInputFormat2;
                str = "CC(remember)P(1):Composables.kt#9igjgp";
                locale = localeDefaultLocale;
            }
            composerStartRestartGroup.endReplaceableGroup();
            DateInputValidator dateInputValidator2 = (DateInputValidator) objRememberedValue2;
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DateInputKt.getInputTextFieldPadding());
            Arrangement.HorizontalOrVertical horizontalOrVerticalM391spacedBy0680j_4 = Arrangement.INSTANCE.m391spacedBy0680j_4(TextFieldSpacing);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM391spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, i3);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1849028810, "C62@2625L56,74@3193L52,63@2690L763,80@3481L54,92@4041L50,81@3544L753:DateRangeInput.kt#uh7d8r");
            final String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            final String strM1465getStringNWtq285 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1438getDateRangePickerStartHeadlineadMyvUU(), composerStartRestartGroup, i3);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null);
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 576559191, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    ComposerKt.sourceInformation(composer3, "C67@2865L96,66@2794L168:DateRangeInput.kt#uh7d8r");
                    if ((i5 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(576559191, i5, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:65)");
                        }
                        String str2 = strM1465getStringNWtq285;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        final String str3 = strM1465getStringNWtq285;
                        final String str4 = upperCase;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged3 = composer3.changed(str3) | composer3.changed(str4);
                        Object objRememberedValue3 = composer3.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$1$1$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str3 + ", " + str4);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.m1552Text4IGK_g(str2, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue3, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1726391478, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    ComposerKt.sourceInformation(composer3, "C71@3006L59:DateRangeInput.kt#uh7d8r");
                    if ((i5 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1726391478, i5, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:71)");
                    }
                    TextKt.m1552Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$2.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            CalendarDate value = stateData.getSelectedStartDate().getValue();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            String str2 = str;
            ComposerKt.sourceInformation(composerStartRestartGroup, str2);
            boolean zChanged3 = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<CalendarDate, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CalendarDate calendarDate) {
                        invoke2(calendarDate);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CalendarDate calendarDate) {
                        stateData.getSelectedStartDate().setValue(calendarDate);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i5 = ((i4 << 9) & 7168) | 1075315120;
            composer2 = composerStartRestartGroup;
            DateInputKt.m1132DateInputTextFieldzm97o8M(modifierWeight$default, composableLambda, composableLambda2, stateData, value, (Function1) objRememberedValue3, InputIdentifier.INSTANCE.m1253getStartDateInputJ2x2o4M(), dateInputValidator2, dateInputFormat, locale, composerStartRestartGroup, i5);
            final String strM1465getStringNWtq286 = Strings_androidKt.m1465getStringNWtq28(Strings.INSTANCE.m1435getDateRangePickerEndHeadlineadMyvUU(), composer2, i3);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null);
            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -663502784, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C85@3717L94,84@3648L164:DateRangeInput.kt#uh7d8r");
                    if ((i6 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-663502784, i6, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:83)");
                        }
                        String str3 = strM1465getStringNWtq286;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        final String str4 = strM1465getStringNWtq286;
                        final String str5 = upperCase;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean zChanged4 = composer3.changed(str4) | composer3.changed(str5);
                        Object objRememberedValue4 = composer3.rememberedValue();
                        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$4$1$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str4 + ", " + str5);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.m1552Text4IGK_g(str3, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue4, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, 518729951, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C89@3856L59:DateRangeInput.kt#uh7d8r");
                    if ((i6 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(518729951, i6, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:89)");
                    }
                    TextKt.m1552Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$5.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            CalendarDate value2 = stateData.getSelectedEndDate().getValue();
            composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer2, str2);
            boolean zChanged4 = composer2.changed(stateData);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<CalendarDate, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$1$6$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CalendarDate calendarDate) {
                        invoke2(calendarDate);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CalendarDate calendarDate) {
                        stateData.getSelectedEndDate().setValue(calendarDate);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            DateInputKt.m1132DateInputTextFieldzm97o8M(modifierWeight$default2, composableLambda3, composableLambda4, stateData, value2, (Function1) objRememberedValue4, InputIdentifier.INSTANCE.m1251getEndDateInputJ2x2o4M(), dateInputValidator2, dateInputFormat, locale, composer2, i5);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt.DateRangeInputContent.2
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

            public final void invoke(Composer composer3, int i6) {
                DateRangeInputKt.DateRangeInputContent(stateData, dateFormatter, dateValidator, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
