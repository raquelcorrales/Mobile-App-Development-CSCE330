package com.example.wordsdictionaryfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.room.Dao
import com.example.wordsdictionaryfinal.database.WordDao
import com.example.wordsdictionaryfinal.database.WordDatabase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //Inflating the overflow menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_leftbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.add_word -> {setContentView(R.layout.activity_main2)}
            //R.id.show_all -> { WordDao.getAllWords()}
            //R.id.active -> { WordDao.getActiveWords()}
            //R.id.inactive -> { WordDao.getInactiveWords()}
        }
        return true
    }

}