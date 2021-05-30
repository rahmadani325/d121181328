package com.example.tugasmid.repo

import androidx.lifecycle.Observer
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.example.tugasmid.R
import com.example.tugasmid.data.RepoData
import com.example.tugasmid.util.obtainViewModel
import com.example.tugasmid.util.replaceFragmentInActivity
import com.example.tugasmid.repo.ReposItemActionListener

class RepoActivity : AppCompatActivity() {


    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)

        mActivity = this
        setupViewModel()
        setupFragment()
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel().apply{
            openRepo.observe(this@RepoActivity, Observer{
                onRepoClicked(it!!)
            })
        }
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frameRepo)
        RepoFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frameRepo)
        }
    }

    fun onRepoClicked(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        builder.setToolbarColor(ContextCompat.getColor(mActivity, R.color.colorPrimary))
        customTabsIntent.launchUrl(mActivity, Uri.parse(url))
    }

    fun obtainViewModel(): RepoViewModel = obtainViewModel(RepoViewModel::class.java)


}