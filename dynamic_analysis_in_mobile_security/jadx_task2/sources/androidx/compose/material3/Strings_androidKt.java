package androidx.compose.material3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: Strings.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"getString", "", "string", "Landroidx/compose/material3/Strings;", "getString-NWtq2-8", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-iSCLEhQ", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Strings_androidKt {
    /* JADX INFO: renamed from: getString-NWtq2-8, reason: not valid java name */
    public static final String m1465getStringNWtq28(int i, Composer composer, int i2) {
        String string;
        ComposerKt.sourceInformationMarkerStart(composer, -176762646, "C(getString)P(0:c#material3.Strings)29@1061L7,30@1102L7:Strings.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-176762646, i2, -1, "androidx.compose.material3.getString (Strings.android.kt:28)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) objConsume).getResources();
        if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1445getNavigationMenuadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1407getCloseDraweradMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1408getCloseSheetadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1440getDefaultErrorMessageadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1442getExposedDropdownMenuadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1448getSliderRangeStartadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.range_start)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1447getSliderRangeEndadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.range_end)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1441getDialogadMyvUU())) {
            string = resources.getString(R.string.dialog);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(andr…aterial3.R.string.dialog)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1444getMenuExpandedadMyvUU())) {
            string = resources.getString(R.string.expanded);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(andr…erial3.R.string.expanded)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1443getMenuCollapsedadMyvUU())) {
            string = resources.getString(R.string.collapsed);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(andr…rial3.R.string.collapsed)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1449getSnackbarDismissadMyvUU())) {
            string = resources.getString(R.string.snackbar_dismiss);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …nackbar_dismiss\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1446getSearchBarSearchadMyvUU())) {
            string = resources.getString(R.string.search_bar_search);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …arch_bar_search\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1450getSuggestionsAvailableadMyvUU())) {
            string = resources.getString(R.string.suggestions_available);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(andr…ng.suggestions_available)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1429getDatePickerTitleadMyvUU())) {
            string = resources.getString(R.string.date_picker_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …te_picker_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1417getDatePickerHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_picker_headline);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …picker_headline\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1431getDatePickerYearPickerPaneTitleadMyvUU())) {
            string = resources.getString(R.string.date_picker_year_picker_pane_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …cker_pane_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1428getDatePickerSwitchToYearSelectionadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_year_selection);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_year_selection\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1424getDatePickerSwitchToDaySelectionadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_day_selection);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …o_day_selection\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1426getDatePickerSwitchToNextMonthadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_next_month);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …h_to_next_month\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1427getDatePickerSwitchToPreviousMonthadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_previous_month);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1419getDatePickerNavigateToYearDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_navigate_to_year_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ear_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1418getDatePickerHeadlineDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_headline_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1420getDatePickerNoSelectionDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_no_selection_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ion_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1430getDatePickerTodayDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_today_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …day_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1422getDatePickerScrollToShowLaterYearsadMyvUU())) {
            string = resources.getString(R.string.date_picker_scroll_to_later_years);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_to_later_years\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1421getDatePickerScrollToShowEarlierYearsadMyvUU())) {
            string = resources.getString(R.string.date_picker_scroll_to_earlier_years);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …o_earlier_years\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1416getDateInputTitleadMyvUU())) {
            string = resources.getString(R.string.date_input_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ate_input_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1409getDateInputHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_input_headline);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_input_headline\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1414getDateInputLabeladMyvUU())) {
            string = resources.getString(R.string.date_input_label);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ate_input_label\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1410getDateInputHeadlineDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_input_headline_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1415getDateInputNoInputDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_input_no_input_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …put_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1412getDateInputInvalidNotAllowedadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_not_allowed);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …lid_not_allowed\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1411getDateInputInvalidForPatternadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_for_pattern);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …lid_for_pattern\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1413getDateInputInvalidYearRangeadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_year_range);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …alid_year_range\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1423getDatePickerSwitchToCalendarModeadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_calendar_mode);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …o_calendar_mode\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1425getDatePickerSwitchToInputModeadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_input_mode);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …h_to_input_mode\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1439getDateRangePickerTitleadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ge_picker_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1438getDateRangePickerStartHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_start_headline);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_start_headline\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1435getDateRangePickerEndHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_end_headline);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …er_end_headline\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1436getDateRangePickerScrollToShowNextMonthadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_scroll_to_next_month);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …l_to_next_month\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1437getDateRangePickerScrollToShowPreviousMonthadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_scroll_to_previous_month);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1434getDateRangePickerDayInRangeadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_day_in_range);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …er_day_in_range\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1433getDateRangeInputTitleadMyvUU())) {
            string = resources.getString(R.string.date_range_input_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …nge_input_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1432getDateRangeInputInvalidRangeInputadMyvUU())) {
            string = resources.getString(R.string.date_range_input_invalid_range_input);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …lid_range_input\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1405getBottomSheetPaneTitleadMyvUU())) {
            string = resources.getString(R.string.m3c_bottom_sheet_pane_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …heet_pane_title\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1403getBottomSheetDragHandleDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_drag_handle_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …dle_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1406getBottomSheetPartialExpandDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_collapse_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …pse_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1402getBottomSheetDismissDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_dismiss_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …iss_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1404getBottomSheetExpandDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_expand_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …and_description\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1463getTooltipLongPressLabeladMyvUU())) {
            string = resources.getString(R.string.tooltip_long_press_label);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ong_press_label\n        )");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1452getTimePickerAMadMyvUU())) {
            string = resources.getString(R.string.time_picker_am);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   ….R.string.time_picker_am)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1461getTimePickerPMadMyvUU())) {
            string = resources.getString(R.string.time_picker_pm);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   ….R.string.time_picker_pm)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1462getTimePickerPeriodToggleadMyvUU())) {
            string = resources.getString(R.string.time_picker_period_toggle_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …eriod_toggle_description)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1458getTimePickerMinuteSelectionadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_selection);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …_picker_minute_selection)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1454getTimePickerHourSelectionadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_selection);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …me_picker_hour_selection)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1455getTimePickerHourSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_suffix);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   ….time_picker_hour_suffix)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1459getTimePickerMinuteSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_suffix);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ime_picker_minute_suffix)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1451getTimePicker24HourSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_24h_suffix);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …e_picker_hour_24h_suffix)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1453getTimePickerHouradMyvUU())) {
            string = resources.getString(R.string.time_picker_hour);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   ….string.time_picker_hour)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1457getTimePickerMinuteadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …tring.time_picker_minute)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1456getTimePickerHourTextFieldadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_text_field);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …e_picker_hour_text_field)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1460getTimePickerMinuteTextFieldadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_text_field);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …picker_minute_text_field)");
        } else if (Strings.m1398equalsimpl0(i, Strings.INSTANCE.m1464getTooltipPaneDescriptionadMyvUU())) {
            string = resources.getString(R.string.tooltip_pane_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …tooltip_pane_description)");
        } else {
            string = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    /* JADX INFO: renamed from: getString-iSCLEhQ, reason: not valid java name */
    public static final String m1466getStringiSCLEhQ(int i, Object[] formatArgs, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart(composer, -1126124681, "C(getString)P(1:c#material3.Strings)205@10113L17,207@10206L7:Strings.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126124681, i2, -1, "androidx.compose.material3.getString (Strings.android.kt:204)");
        }
        String strM1465getStringNWtq28 = m1465getStringNWtq28(i, composer, i2 & 14);
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Locale locale = ConfigurationCompat.getLocales((Configuration) objConsume).get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArrCopyOf = Arrays.copyOf(formatArgs, formatArgs.length);
        String str = String.format(locale, strM1465getStringNWtq28, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str;
    }
}
