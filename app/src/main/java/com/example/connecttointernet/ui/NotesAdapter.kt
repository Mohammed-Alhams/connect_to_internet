package com.example.connecttointernet.ui

import com.example.connecttointernet.R
import com.example.connecttointernet.data.Note

class NotesAdapter(
    items: List<Note>,
    listener: IBaseInterActionListener
) : BaseAdapter<Note>(items, listener) {
    override val layoutId: Int = R.layout.item_note
}