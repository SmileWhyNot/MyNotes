package com.example.mynotes.database.firebase

import androidx.lifecycle.LiveData
import com.example.mynotes.database.DatabaseRepository
import com.example.mynotes.model.Note
import com.example.mynotes.utils.EMAIL
import com.example.mynotes.utils.PASSWORD
import com.google.firebase.auth.FirebaseAuth

class FirebaseRepository : DatabaseRepository {

    private var firebaseAuth = FirebaseAuth.getInstance()

    override val readAll: LiveData<List<Note>>
        get() = TODO("Not yet implemented")

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
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