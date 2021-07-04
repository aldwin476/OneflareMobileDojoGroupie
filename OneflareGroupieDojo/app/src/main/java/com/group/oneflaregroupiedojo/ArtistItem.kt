package com.group.oneflaregroupiedojo

import android.content.Context
import android.view.View
import com.group.oneflaregroupiedojo.databinding.ItemArtistBinding
import com.xwray.groupie.viewbinding.BindableItem


class ArtistItem(var  name: String,var  clickHandler : ((Int) -> Unit?)? ) :BindableItem<ItemArtistBinding>(){
    override fun bind(viewBinding: ItemArtistBinding, position: Int) {
        viewBinding.artistName.text = name
        viewBinding.artistName.setOnClickListener {
            clickHandler?.invoke(position)
        }


        name ="Aldwin Test"
    }

    override fun getLayout(): Int = R.layout.item_artist

    override fun initializeViewBinding(view: View): ItemArtistBinding = ItemArtistBinding.bind(view)

}