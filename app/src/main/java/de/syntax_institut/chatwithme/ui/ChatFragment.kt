package de.syntax_institut.chatwithme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import de.syntax_institut.chatwithme.adapter.MessageAdapter
import de.syntax_institut.chatwithme.data.model.Contact
import de.syntax_institut.chatwithme.databinding.FragmentChatBinding
import kotlin.contracts.contract

class ChatFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    // TODO
    private val viewModel: SharedViewModel by activityViewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentChatBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mit binding wird das ViewModel und der viewLifecycleOwner dem Layout zugewiesen
        // TODO
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Das übergebene Argument ("contact Index") wird in eine Variable gespeichert
        // TODO
        val contactIndex = requireArguments().getInt("contactIndex")

        // Über die Funktion aus dem ViewModel wird der Chat initialisiert
        // TODO
        viewModel.initializeChat(contactIndex)

        // Anhand der Informationen, die im currentContact im ViewModel gespeichert sind, wird das Profilbild und der Profilname gesetzt
        // TODO
        binding.ivContactPicture.setImageResource(viewModel.currentContact.imageResId)
        binding.tvContactName.text = viewModel.currentContact.name

        // Die Variable aus dem ViewModel, in der der TextInput gespeichert ist wird beobachtet
        // TODO
        viewModel.inputText.observe(
            viewLifecycleOwner
        ){
            viewModel.inputTextChanged(it)
        }

        // Der MessageAdapter für die RecyclerView wird erstellt und in einer Variablen gespeichert
        // TODO
        val messageAdapter = MessageAdapter(viewModel.currentContact.chatHistory, requireContext())

        // Der Adapter wird der RecyclerView zugewiesen
        // TODO
        binding.rvMessages.adapter = messageAdapter

        // Der draftMessageState aus dem ViewModel wird beobachtet um je nach Zustand den Adapter zu benachrichtigen
        // TODO
        viewModel.draftMessageState.observe(
            viewLifecycleOwner
        ){
            if (DraftState.CREATED == it){
                messageAdapter.notifyItemInserted(0)
                binding.rvMessages.scrollToPosition(0)
            }
            if (DraftState.CHANGED == it){
                messageAdapter.notifyItemChanged(0, Unit)
            }
            if (DraftState.SENT == it) {
                messageAdapter.notifyItemChanged(0, Unit)
            }
            if (DraftState.DELETED == it){
                messageAdapter.notifyItemRemoved(0)
            }
        }

        // Der btnSend bekommt einen Click Listener
        // TODO
        binding.btnSend.setOnClickListener{
            viewModel.sendDraftMessage()
        }

        // Der BtnBack bekommt einen Click Listener
        // TODO
        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    /**
     * Lifecycle Funktion onDestroy
     * Diese Funktion wird aufgerufen wenn das Fragment beendet wird
     */
    override fun onDestroy() {
        super.onDestroy()

        // Über die ViewModel Funktion wird der Chat geschlossen
        // TODO
        viewModel.closeChat()
    }
}
