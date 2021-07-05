package com.group.oneflaregroupiedojo

import android.content.Context
import android.view.View
import com.group.oneflaregroupiedojo.databinding.ItemArtistBinding
import com.group.oneflaregroupiedojo.databinding.ItemSongBinding
import com.xwray.groupie.viewbinding.BindableItem


class SongItem(var  name: String, var  clickHandler : ((Int) -> Unit?)? ) :BindableItem<ItemSongBinding>(){
    override fun bind(viewBinding: ItemSongBinding, position: Int) {
        viewBinding.songName.text = name
        viewBinding.songName.setOnClickListener {
            name = "$name Clicked"
        }
    }

    override fun getLayout(): Int = R.layout.item_song

    override fun initializeViewBinding(view: View): ItemSongBinding = ItemSongBinding.bind(view)

}