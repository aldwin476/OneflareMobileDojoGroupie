package com.group.oneflaregroupiedojo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var groupieAdapter = GroupieAdapter()
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

    private fun setupUI(){

        artists_recycler.adapter = groupieAdapter

        groupieAdapter.addAll(getArtists())

        groupieAdapter.setOnItemClickListener { item, view ->
            when(item){
                is ArtistItem ->{
                    var artistItem = item
                    artistItem.name

                }
                is TestItem -> {
                    item.nameTest

                }
            }
        }
    }

    private fun getArtists(): MutableList<ArtistItem> {
        return mutableListOf(
            ArtistItem("Aldwin") {
                doSomething(it)
            },
            ArtistItem("Jade", null),
            ArtistItem("Nak", null),
            ArtistItem("Haider", null),
            ArtistItem("Waylan", null)
        )
    }


    private fun getArtistsList(): MutableList<ArtistModel> {
        val listOfSongs: MutableList<ArtistModel> = mutableListOf()
        for (i in 0..10){
            listOfSongs.add(ArtistModel(i,"Name $i", getSongs()))
        }
        return listOfSongs
    }


    private fun getSongs(): MutableList<String> {

        return mutableListOf("Song 1", "Song 2", "Song 3")
    }
    private fun doSomething(pos: Int) {
        Log.e("test", "test")
    }
}