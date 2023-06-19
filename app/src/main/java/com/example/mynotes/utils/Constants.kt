package com.example.mynotes.utils

import com.example.mynotes.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository
lateinit var EMAIL: String
lateinit var PASSWORD: String

object Constants {
    object Keys {
        const val NOTE_DATABASE = "note_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new Note"
        const val ADD_NOTE = "Add note"
        const val NOTE_TITLE = "Title"
        const val NOTE_SUBTITLE = "SubTitle"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val LOCAL_SAVING = "Local saving"
        const val REMOTE_SAVING = "Remote saving"
        const val ID = "id"
        const val NONE = "NONE"
        const val UPDATE = "Update"
        const val DELETE = "Delete"
        const val NAV_BACK = "NAV_BACK"
        const val EDIT_NOTE = "Edit note"
        const val EMPTY = ""
        const val SIGN_IN = "Sign in"
        const val AUTHORISATION = "Authorisation"
        const val EMAIL_TEXT = "Email"
        const val PASSWORD_TEXT = "Password"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"
    }
}