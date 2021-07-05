package com.group.oneflaregroupiedojo

import android.content.Context
import android.view.View
import com.group.oneflaregroupiedojo.databinding.ItemArtistBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem


class ArtistItem(var  name: String, var  clickHandler : (() -> Unit?)? = null ) : ExpandableItem, BindableItem<ItemArtistBinding>(){

    private lateinit var expandableGroup: ExpandableGroup
    override fun bind(viewBinding: ItemArtistBinding, position: Int) {
        viewBinding.artistName.text = name
        viewBinding.artistName.setOnClickListener {

            clickHandler?.invoke()
            expandableGroup.isExpanded = true
//            expandableGroup.onToggleExpanded()
            if (expandableGroup.isExpanded){

            }

        }


    }

    override fun getLayout(): Int = R.layout.item_artist

    override fun initializeViewBinding(view: View): ItemArtistBinding = ItemArtistBinding.bind(view)
    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {

        this.expandableGroup = onToggleListener
    }


//    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
//
//        this.expandableGroup = onToggleListener
//    }

}