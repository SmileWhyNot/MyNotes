package com.example.mynotes.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.mynotes.database.DatabaseRepository
import com.example.mynotes.model.Note
import com.example.mynotes.utils.Constants.Keys.NOTE_SUBTITLE
import com.example.mynotes.utils.Constants.Keys.NOTE_TITLE
import com.example.mynotes.utils.EMAIL
import com.example.mynotes.utils.FIREBASE_ID
import com.example.mynotes.utils.PASSWORD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRepository : DatabaseRepository {

    private var firebaseAuth = FirebaseAuth.getInstance()
    private val database =
        Firebase.database.reference.child(firebaseAuth.currentUser?.uid.toString())


    override val readAll: LiveData<List<Note>> = AllNotesLiveData()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        val noteId = database.push().key.toString()
        val mapNotes = hashMapOf<String, Any>()

        mapNotes[FIREBASE_ID] = noteId
        mapNotes[NOTE_TITLE] = note.title
        mapNotes[NOTE_SUBTITLE] = note.subtitle

        database.child(noteId).updateChildren(mapNotes).addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("CheckData", "Failed to add new Note") }
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun sighOut() {
        firebaseAuth.signOut()
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                firebaseAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }
}