package com.group.oneflaregroupiedojo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var groupieAdapter = GroupieAdapter()
    var artistSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private val itemTouchHelper by lazy {
        val itemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or
                        ItemTouchHelper.DOWN or
                        ItemTouchHelper.LEFT or
                        ItemTouchHelper.RIGHT or
                        ItemTouchHelper.START or
                        ItemTouchHelper.END, 3) {
                override fun onMove(recyclerView: RecyclerView,
                                    viewHolder: RecyclerView.ViewHolder,
                                    target: RecyclerView.ViewHolder): Boolean {
                    val from = viewHolder.adapterPosition
                    val to = target.adapterPosition
                    groupieAdapter.notifyItemMoved(from, to)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                }
            }
        ItemTouchHelper(itemTouchCallback)
    }
    private fun setupUI() {

        artists_recycler.adapter = groupieAdapter


//        getSongs().forEach { songItem ->
//            groupieAdapter.add(ArtistItem(songItem.name, clickHandler = {
//
//            }))
//        }



//        groupieAdapter.add(TestItem("Aldwin"))
//        groupieAdapter.add(ArtistItem("Aldwin",null))
//        groupieAdapter.addAll(getArtistsList())



        //Using Sections
//        artistSection.addAll(getArtists())
//        groupieAdapter.addAll(artistSection.groups)


        //Groupie Onclick
        groupieAdapter.setOnItemClickListener { item, view ->
            when(item){
                is ArtistItem ->{
                    item.name

                }
                is TestItem -> {
                    item.name
                }
            }
        }

        groupieAdapter.updateAsync(artistSection.groups)


        //EXPANDABLE GROUP

        getArtists().forEach { artist ->
            var songSection = Section()

            val header = ExpandableGroup(artist)

            songSection = Section()
            songSection.addAll(songList())

            header.addAll(songSection.groups)

            groupieAdapter.add(header)
        }

        //Drag and drop
        itemTouchHelper.attachToRecyclerView(artists_recycler)
    }

    private fun getArtists(): MutableList<ArtistItem> {
        return mutableListOf(

            ArtistItem("Haider"),
            ArtistItem("Waylan")
        )
    }

//    private fun getArtistsList(): MutableList<TestItem> {
//        return mutableListOf(
//            TestItem("Aldwin", clickHandler = {
//
//            }),
//            TestItem("Jade"),
//            TestItem("Nak"),
//            TestItem("Haider"),
//            TestItem("Waylan")
//        )
//    }


    private fun songList() : MutableList<SongItem>{
        return mutableListOf(
            SongItem("Song 1", null),
            SongItem("Song 2", null),
            SongItem("Song 3", null)
        )
    }
    private fun getSongs(): MutableList<ArtistModel> {

        return mutableListOf(
            ArtistModel(1, "Song 1", mutableListOf()),
            ArtistModel(2, "Song 2", mutableListOf()),
            ArtistModel(3, "Song 3", mutableListOf())
        )
    }

    private fun doSomething(message: String) {
        Log.e("test", "$message")
    }
}