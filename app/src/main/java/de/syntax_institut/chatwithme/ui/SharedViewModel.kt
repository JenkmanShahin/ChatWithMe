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
    private val _draftMessageState =  MutableLiveData<DraftState>(DraftState.DELETED)
    val draftMessageState: LiveData<DraftState>
    get() = _draftMessageState

    // Der Eingabe Text wird in einer Variablen gespeichert
    // TODO
    var inputText = MutableLiveData<String>()




    /**
     * Diese Funktion initialisiert den Chat und setzt die Variablen dementsprechend
     */
    fun initializeChat(contactIndex: Int) {
        // TODO
       _currentContact = contactList[contactIndex]
        inputText.value = ""
        _draftMessageState.value = DraftState.DELETED

    }

    /**
     * Diese Funktion schließt den Chat und setzt die Variablen dementsprechend
     */
    fun closeChat() {
        // TODO
        if (draftMessageState.value == DraftState.CREATED
            || draftMessageState.value == DraftState.CHANGED){

            currentContact.chatHistory.removeAt(0)
        }
        _draftMessageState.value = DraftState.DELETED

    }


    /**
     * Diese Funktion wird aufgerufen, wenn sich der Eingabe Text ändert.
     * Sie verwaltet die chatHistory und den Draft Zustand dementsprechend
     */
    fun inputTextChanged(text: String) {
        // TODO
        if (draftMessageState.value == DraftState.CREATED
            || draftMessageState.value == DraftState.CHANGED) {
            if (text != ""){

                _currentContact.chatHistory[0].messageText = text
                _draftMessageState.value = DraftState.CHANGED

            }
            else {
                _currentContact.chatHistory.removeAt(0)
                _draftMessageState.value = DraftState.DELETED
            }
        }
        else{
            if (text != "") {
                _currentContact.chatHistory.add(0, Message(text, true))
                _draftMessageState.value = DraftState.CREATED
            }
        }
    }


    /**
     * Diese Funktion "schickt die Draft Message ab",
     * indem die Variablen dementsprechend gesetzt werden
     */
    fun sendDraftMessage() {
        // TODO
        _currentContact.chatHistory[0].isDraft = false
        _draftMessageState.value = DraftState.SENT
        inputText.value = ""
    }
}
