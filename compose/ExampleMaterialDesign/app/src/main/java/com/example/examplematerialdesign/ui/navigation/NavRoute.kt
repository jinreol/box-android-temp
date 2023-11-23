package com.example.examplematerialdesign.ui.navigation

sealed class NavRoute(var path: String) {
    object Home : NavRoute("home")

    object AlertDialog : NavRoute("alertDialog")
    object AssistChip : NavRoute("assistChip")
    object Badge : NavRoute("badge")
    object BottomSheet : NavRoute("bottomSheet")
    object Button : NavRoute("button")
    object Card : NavRoute("card")
    object Carousel : NavRoute("carousel")
    object Checkbox : NavRoute("checkbox")
    object CircularProgressIndicator : NavRoute("circularProgressIndicator")
    object DatePicker : NavRoute("datePicker")
    object DatePickerDialog : NavRoute("datePickerDialog")
}
