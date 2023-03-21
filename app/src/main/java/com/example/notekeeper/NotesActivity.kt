package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.adapters.NotesRecAdapter
import com.example.notekeeper.databinding.ActivityNotesBinding
import com.example.notekeeper.databinding.HeaderBinding
import com.google.android.material.navigation.NavigationView

class NotesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bind: ActivityNotesBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val navHost:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController:NavController = findNavController(R.id.fragment)
        appBarConfiguration = AppBarConfiguration(navHost.navController.graph, bind.drawerLayout)
        val drawer = findViewById<NavigationView>(R.id.drawer)
        val header = HeaderBinding.inflate(layoutInflater)
        bind.drawer.addHeaderView(header.root)
        drawer.setupWithNavController(navHost.navController)
        bind.drawer.bringToFront()


        setupActionBarWithNavController(navHost.navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController:NavController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}