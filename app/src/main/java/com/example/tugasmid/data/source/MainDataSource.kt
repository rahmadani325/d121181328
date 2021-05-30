package com.example.tugasmid.data.source

import com.example.tugasmid.data.MainData
import com.example.tugasmid.data.RepoData

interface MainDataSource{
    fun getMainData(callback: GetMainDataCallback)
    fun getRepoData(callback: GetRepoDataCallback)

    interface GetMainDataCallback{
        fun onDataLoaded(mainData: MainData?)
        fun onNotAvailable()
        fun onError(msg: String?)
    }

    interface  GetRepoDataCallback{
        fun onDataLoaded(repoData: MutableList<RepoData?>)
        fun onNotAvailable()
        fun onError(msg: String?)
    }
}