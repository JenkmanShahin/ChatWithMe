package de.syntax_institut.chatwithme.ui

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.chatwithme.data.Repository
import de.syntax_institut.chatwithme.data.model.Contact
import de.syntax_institut.chatwithme.data.model.Message
import org.w3c.dom.Text

/**
 * Diese enum class repräsentiert den momentanen Zustand der Draft Message
 * @property CREATED Die Draft Message wurde erstellt
 * @property CHANGED Die Draft Message hat sich geändert
 * @property SENT Die Draft Message wurde abgeschickt
 * @property DELETED Die Draft Message wurde gelöscht
 */
enum class DraftState {
    CREATED,
    CHANGED,
    SENT,
    DELETED
}

/**
 * Das ViewModel kümmert sich um die Zustände und die Logik der App
 */
class SharedViewModel : ViewModel() {

    // Eine Instanz des Repository wird in einer Variablen gespeichert
    // TODO
    private val repository = Repository()

    // Die Liste aus Kontakten wird in einer verschachtelten Variable gespeichert
    // TODO
    private val _contactList = repository.contactList
    val contactList: List<Contact>
    get() = _contactList

    // Der aktuell ausgewählte Kontakt wird in einer verschachtelten Variable gespeichert
    // TODO



    private lateinit var _currentContact: Contact
    val currentContact: Contact
    get() = _currentContact

    // Der Zustand der Draft Message wird in einer verschachtelten Variable gespeichert
    // TODO
    private  val _draftMessageState =  MutableLiveData(DraftState.DELETED)
    val draftMessageState: LiveData<DraftState>
    get() = _draftMessageState


    // Der Eingabe Text wird in einer Variablen gespeichert
    // TODO
    private val _inputText = MutableLiveData(String.Companion)
    val inputText: LiveData<String.Companion>
    get() = _inputText


    /**
     * Diese Funktion initialisiert den Chat und setzt die Variablen dementsprechend
     */
    fun initializeChat(contactIndex: Int) {
        // TODO
    }

    /**
     * Diese Funktion schließt den Chat und setzt die Variablen dementsprechend
     */
    fun closeChat() {
        // TODO
    }

    /**
     * Diese Funktion wird aufgerufen, wenn sich der Eingabe Text ändert.
     * Sie verwaltet die chatHistory und den Draft Zustand dementsprechend
     */
    fun inputTextChanged(text: String) {
        // TODO
    }

    /**
     * Diese Funktion "schickt die Draft Message ab",
     * indem die Variablen dementsprechend gesetzt werden
     */
    fun sendDraftMessage() {
        // TODO
    }
}
