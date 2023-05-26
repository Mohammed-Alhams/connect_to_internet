package com.example.connecttointernet.ui.notes

import com.example.connecttointernet.R
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.ui.base.BaseAdapter
import com.example.connecttointernet.ui.base.IBaseInterActionListener

class NotesAdapter(
    items: List<Note>,
    listener: IBaseInterActionListener
) : BaseAdapter<Note>(items, listener) {
    override val layoutId: Int = R.layout.item_note
}