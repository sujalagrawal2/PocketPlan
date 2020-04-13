package com.example.j7_003.fragments

import android.app.Activity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.j7_003.MainActivity

import com.example.j7_003.R
import kotlinx.android.synthetic.main.appbar_write_note.view.*
import kotlinx.android.synthetic.main.fragment_write_note.view.*

class WriteNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val database = MainActivity.database

        val myView = inflater.inflate(R.layout.fragment_write_note, container, false)

        val etNoteTitle = myView.etNoteTitle
        val etNoteContent = myView.etNoteContent

        etNoteTitle.requestFocus()

        MainActivity.myActivity.supportActionBar?.customView?.btnSaveNote?.setOnClickListener(){
            val noteTitle = etNoteTitle.text.toString()
            val noteContent = etNoteContent.text.toString()
            database.addNote(noteTitle, noteContent)
            MainActivity.myActivity.changeToNotes()

            //todo notify adapter of changed dataset
        }

        MainActivity.myActivity.supportActionBar?.customView?.btnDiscardNote?.setOnClickListener(){
           MainActivity.myActivity.changeToNotes()
        }

        return myView
    }


}
