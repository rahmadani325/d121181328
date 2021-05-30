package com.example.tugasmid.util

import android.content.Context
import android.preference.PreferenceManager
import com.example.tugasmid.data.source.MainDataRepository
import com.example.tugasmid.data.source.local.MainDataLocalSource
import com.example.tugasmid.data.source.remote.MainDataRemoteSource

object Injection {
    fun providedMainDataRepository(context: Context) = MainDataRepository.getInstance(MainDataRemoteSource, MainDataLocalSource.getInstance(PreferenceManager.getDefaultSharedPreferences(context)))
}