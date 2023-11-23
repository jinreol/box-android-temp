package com.example.examplenavigate.ui.navigation

sealed class NavRoute(var path: String) {
    object Login: NavRoute("login")
    object Home: NavRoute("home")
    object Profile: NavRoute("profile") {
        const val id = "id"
        const val showDetails = "showDetails"
    }
    object Search: NavRoute("search") {
        const val query = "query"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }

}
