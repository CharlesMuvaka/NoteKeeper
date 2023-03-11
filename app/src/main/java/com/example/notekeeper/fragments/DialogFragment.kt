package com.example.notekeeper.fragments

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.notekeeper.R

class DialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.fragment_dialog, null))
                // Add action buttons
                .setPositiveButton("Read",
                    DialogInterface.OnClickListener { _, _ ->
                        // sign in the user ...
                    })
                .setNegativeButton("Purchase",
                    DialogInterface.OnClickListener { _, _ ->
                        dialog!!.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}