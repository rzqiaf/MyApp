package com.dicoding.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rvBand: RecyclerView
    private val list = ArrayList<Band>()


    private fun showSelectedPlayers(players: Band) {
        Toast.makeText(this, "Kamu memilih " + players.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBand = findViewById(R.id.rv_players)
        rvBand.setHasFixedSize(true)

        list.addAll(getListBand())
        showRecyclerList()
    }

    private fun getListBand(): ArrayList<Band> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listBand = ArrayList<Band>()
        for (i in dataName.indices) {
            val band = Band(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listBand.add(band)
        }
        dataPhoto.recycle()
        return listBand
    }
    private fun showRecyclerList() {
        rvBand.layoutManager = LinearLayoutManager(this)
        val listBandAdapter = ListBandAdapter(list)


        listBandAdapter.setOnItemClickCallback(object : ListBandAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Band) {
                showSelectedPlayers(data)


                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, data)
                startActivity(intent)
            }
        })

        rvBand.adapter = listBandAdapter
    }


}
