package com.example.tugasmid.repo

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmid.data.RepoData

object RepoBinding {
    @BindingAdapter("app:repoList")
    @JvmStatic
    fun setRepoList(recyclerView: RecyclerView, repoData: MutableList<RepoData>) {
        with(recyclerView.adapter as RepoAdapter){
            replaceData(repoData)
        }
    }
}