package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Message
import com.example.kindergardenmanager.data.model.User
import java.text.SimpleDateFormat
import java.util.*

class MessageAdapter(
    private val context: Context,
    private var messages: List<Message> = emptyList(),
    private val senderMap: Map<Long, User>,
    private val onMessageClick: (Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvSender: TextView = itemView.findViewById(R.id.tvSender)
        private val tvTimestamp: TextView = itemView.findViewById(R.id.tvTimestamp)
        private val tvContent: TextView = itemView.findViewById(R.id.tvContent)

        fun bind(message: Message) {
            tvTitle.text = message.title
            tvContent.text = message.content
            tvTimestamp.text = dateFormat.format(message.timestamp)

            val sender = senderMap[message.senderId]
            tvSender.text = "From: ${sender?.firstName} ${sender?.lastName}"

            if (!message.isRead) {
                tvTitle.setTypeface(null, android.graphics.Typeface.BOLD)
            }

            itemView.setOnClickListener {
                onMessageClick(message)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount() = messages.size

    fun updateMessages(newMessages: List<Message>) {
        messages = newMessages
        notifyDataSetChanged()
    }
}
