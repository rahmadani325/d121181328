package com.example.tugasmid.repo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import android.util.Log
import android.widget.Toast
import com.example.tugasmid.data.RepoData
import com.example.tugasmid.data.source.MainDataRepository
import com.example.tugasmid.data.source.MainDataSource
import com.example.tugasmid.util.SingleLiveEvent

class RepoViewModel (application: Application, private val mainDataRepository: MainDataRepository) : AndroidViewModel(application){
    val repoList: ObservableList<RepoData> = ObservableArrayList()
    internal val openRepo = SingleLiveEvent<String>()

    fun start() {
        getRepos()
    }

    private fun getRepos(){
        mainDataRepository.getRepoData(object : MainDataSource.GetRepoDataCallback{
            override fun onDataLoaded(repoData: MutableList<RepoData?>) {
                with(repoList){
                    clear()
                    addAll(repoData!!)
                }
            }

            override fun onNotAvailable() {
                Toast.makeText(getApplication(),"No Data Found", Toast.LENGTH_SHORT).show()
            }

            override fun onError(msg: String?) {
                Toast.makeText(getApplication(),"Error at - $msg", Toast.LENGTH_SHORT).show()
            }
        })
    }
}