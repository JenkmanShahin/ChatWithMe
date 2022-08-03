package de.syntax_institut.chatwithme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.chatwithme.R
import de.syntax_institut.chatwithme.data.model.Contact
import de.syntax_institut.chatwithme.ui.HomeFragmentDirections

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class ContactAdapter(
    private val dataset: List<Contact>
) : RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPicture: ImageView = itemView.findViewById(R.id.ivContactPicture)
        val tvName: TextView = itemView.findViewById(R.id.tvContactName)
        val tvLastMessage: TextView = itemView.findViewById(R.id.tvContactLastMessage)
        val clContact: ConstraintLayout = itemView.findViewById(R.id.clContact)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_contact, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Der aktuelle Kontakt wird aus dem Dataset geholt
        // TODO
        val contact = dataset[position]


        // Das Profilbild und der Profilname werden gesetzt
        // TODO
        holder.ivPicture.setImageResource(contact.imageResId)
        holder.tvName.text = contact.name

        // Falls Nachrichten in der Liste des Kontakts existieren wird die neuste Nachricht angezeigt
        // TODO
        if (contact.chatHistory.size > 0) {
           holder.tvLastMessage.text = contact.chatHistory[0].messageText
        }

        // Das komplette ConstraintLayout bekommt einen Click Listener, in dem zum ChatFragment navigiert wird
        // TODO
        holder.clContact.setOnClickListener{
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToChatFragment(position))
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
