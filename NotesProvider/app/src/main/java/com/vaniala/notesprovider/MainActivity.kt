package com.vaniala.notesprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns._ID
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vaniala.notesprovider.database.NotesDataBaseHelper.Companion.TITLE_NOTES
import com.vaniala.notesprovider.database.NotestProvider.Companion.URI_NOTES

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    private lateinit var noteRecycler: RecyclerView
    private lateinit var noteAdd: FloatingActionButton
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.notes_add)
        noteRecycler = findViewById(R.id.notes_recycler)
        noteAdd.setOnClickListener {

            NotesDetailsFragment().show(supportFragmentManager, "dialog")
        }
        notesAdapter = NotesAdapter(object : NoteClickedListener {

            override fun noteClickItem(cursor: Cursor) {
                val id = cursor.getLong(cursor.getColumnIndex(_ID))

                val fragment = NotesDetailsFragment.newInstance(id)
                fragment.show(supportFragmentManager, "dialog")
            }

            override fun noteRemoveItem(cursor: Cursor?) {
                val id = cursor?.getLong(cursor.getColumnIndex(_ID))
                contentResolver.delete(Uri.withAppendedPath(URI_NOTES, id.toString()), null, null)

            }

        })
        notesAdapter.setHasStableIds(true)
        noteRecycler.layoutManager = LinearLayoutManager(this)
        noteRecycler.adapter = notesAdapter

        LoaderManager.getInstance(this).initLoader(0, null, this)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if (data != null) {
            notesAdapter.setCursor(data)
        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        notesAdapter.setCursor(null)
    }
}