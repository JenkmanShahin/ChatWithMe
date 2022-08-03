package de.syntax_institut.chatwithme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.chatwithme.adapter.MessageAdapter
import de.syntax_institut.chatwithme.databinding.FragmentChatBinding

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

        // Das übergebene Argument ("contact Index") wird in eine Variable gespeichert
        // TODO

        // Über die Funktion aus dem ViewModel wird der Chat initialisiert
        // TODO

        // Anhand der Informationen, die im currentContact im ViewModel gespeichert sind, wird das Profilbild und der Profilname gesetzt
        // TODO

        // Die Variable aus dem ViewModel, in der der TextInput gespeichert ist wird beobachtet
        // TODO

        // Der MessageAdapter für die RecyclerView wird erstellt und in einer Variablen gespeichert
        // TODO

        // Der Adapter wird der RecyclerView zugewiesen
        // TODO

        // Der draftMessageState aus dem ViewModel wird beobachtet um je nach Zustand den Adapter zu benachrichtigen
        // TODO

        // Der btnSend bekommt einen Click Listener
        // TODO

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
    }
}
