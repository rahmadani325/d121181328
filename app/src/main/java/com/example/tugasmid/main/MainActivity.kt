package com.example.tugasmid.main

import androidx.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmid.R
import com.example.tugasmid.repo.RepoActivity
import com.example.tugasmid.util.replaceFragmentInActivity
import com.example.tugasmid.util.obtainViewModel
import com.example.tugasmid.util.ViewModelFactory


class MainActivity : AppCompatActivity() {


    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActivity = this

        setupFragment()
        setupViewModel()

    }


    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frameMain)
        MainFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frameMain)
        }
    }


    private fun setupViewModel() {
        viewModel = obtainViewModel().apply{
            openRepo.observe(this@MainActivity, Observer{
                startActivity(Intent(mActivity, RepoActivity::class.java))
            })
        }
    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)
}