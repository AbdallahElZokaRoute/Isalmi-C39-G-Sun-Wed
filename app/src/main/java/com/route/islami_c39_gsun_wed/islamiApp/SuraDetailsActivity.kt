package com.route.islami_c39_gsun_wed.islamiApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.route.islami_c39_gsun_wed.R
import com.route.islami_c39_gsun_wed.databinding.ActivitySuraDetailsBinding
import com.route.islami_c39_gsun_wed.islamiApp.adapter.VersesAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iconBack.setOnClickListener {
            finish()
        }

        val title = intent.getStringExtra(Constants.EXTRA_SURA_NAME);
        val index = intent.getIntExtra(Constants.EXTRA_SURA_INDEX, -1)
        binding.titleToolbar.text = title
        adapter = VersesAdapter(null)
        binding.suraContentRecyclerView.adapter = adapter
        if (intent.getBooleanExtra(Constants.EXTRA_IS_SURA_CONTENT, true))
            readFileFromAssets(index)
        else {
            val list =
                intent.getStringExtra(Constants.HADETH_LIST_EXTRA)?.split("\n")?.toList()
                    ?: listOf()
            Log.e("TAG", "onCreate: $list ")
            adapter.updateData(
                list
            )
        }
    }

    //
    fun readFileFromAssets(index: Int) {
        val fileName = "$index.txt"
        val suraContentAsString = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val suraContentList = suraContentAsString.split("\n")
        adapter.updateData(suraContentList)
    }

}