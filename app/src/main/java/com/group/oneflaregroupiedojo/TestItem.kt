package com.group.oneflaregroupiedojo

import android.content.Context
import android.view.View
import com.group.oneflaregroupiedojo.databinding.ItemArtistBinding
import com.group.oneflaregroupiedojo.databinding.ItemSongBinding
import com.xwray.groupie.viewbinding.BindableItem

class TestItem(var name: String, var clickHandler : ((Int)-> Unit)) : BindableItem<ItemSongBinding>(){
    override fun bind(viewBinding: ItemSongBinding, position: Int) {

        viewBinding.songName .text = name

        viewBinding.songName.setOnClickListener {
            clickHandler.invoke(position)
        }
    }

    override fun getLayout(): Int = R.layout.item_artist

    override fun initializeViewBinding(view: View): ItemSongBinding = ItemSongBinding.bind(view)
}