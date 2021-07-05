package com.group.oneflaregroupiedojo

import android.content.Context
import android.view.View
import com.group.oneflaregroupiedojo.databinding.ItemArtistBinding
import com.xwray.groupie.viewbinding.BindableItem

class TestItem(var context: Context,var  nameTest: String,var  clickHandler : (() -> Unit?) ) :BindableItem<ItemArtistBinding>(){
    override fun bind(viewBinding: ItemArtistBinding, position: Int) {
        viewBinding.artistName.text = nameTest
    }

    override fun getLayout(): Int = R.layout.item_artist

    override fun initializeViewBinding(view: View): ItemArtistBinding = ItemArtistBinding.bind(view)

}