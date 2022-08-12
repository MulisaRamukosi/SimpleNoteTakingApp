package com.puzzle.industries.simplenotetakingapp.navigation.constants

 open class Routes(val path: String) {

    object Home: Routes(MainScreens.Home.name)
    object Note: Routes("${MainScreens.Notes.name}?noteId={${RouteParamKeys.NoteId.name}}")


    fun addParam(key: String, value: String) : Routes{
        val newPath = path.replace("{$key}", value)
        return Routes(newPath)
    }
}



