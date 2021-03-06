package com.vaniala.notesprovider

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vaniala.notesprovider.database.NotesDataBaseHelper.Companion.DESCRIPTION_NOTES
import com.vaniala.notesprovider.database.NotesDataBaseHelper.Companion.TITLE_NOTES

class NotesAdapter(
    private val listener: NoteClickedListener
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var mCursor: Cursor? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder =
        NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.notes_item, parent, false)
        )

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
       mCursor?.moveToPosition(position)
        holder.noteTitle.text = mCursor?.getString(mCursor?.getColumnIndex(TITLE_NOTES) as Int)
        holder.noteDescription.text = mCursor?.getString(mCursor?.getColumnIndex(DESCRIPTION_NOTES) as Int)

        holder.noteButtonRemove.setOnClickListener {
            mCursor?.moveToPosition(position)
            listener.noteRemoveItem(mCursor)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener {
            mCursor?.moveToPosition(position)
            listener.noteClickItem(mCursor!!)
        }
    }

    override fun getItemCount(): Int = if (mCursor!= null) mCursor?.count as Int else 0

    fun setCursor(newCursor: Cursor?){
        mCursor = newCursor
        notifyDataSetChanged()
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val noteTitle = itemView.findViewById<TextView>(R.id.note_title)
        val noteDescription = itemView.findViewById<TextView>(R.id.note_description)
        val noteButtonRemove = itemView.findViewById<Button>(R.id.note_button_remove)
    }
}