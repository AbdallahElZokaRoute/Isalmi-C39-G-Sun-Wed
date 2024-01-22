package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentAhadethBinding
import com.route.islami_c39_gsun_wed.islamiApp.Constants
import com.route.islami_c39_gsun_wed.islamiApp.SuraDetailsActivity
import com.route.islami_c39_gsun_wed.islamiApp.adapter.VersesAdapter

class HadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    lateinit var adapter: VersesAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = VersesAdapter(null)
        binding.hadethRecyclerView.adapter = adapter
        readHadethFromAssetsFile()
    }

    fun readHadethFromAssetsFile() {
        val fileName = "ahadeeth.txt"
        val fileHadethContentAsString =
            requireContext().assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        val hadethList = fileHadethContentAsString.trim().split("#")
        val hadethTitleList = mutableListOf<String>()
        val hadethDescriptionList = mutableListOf<String>()
        hadethList.forEach { hadeth ->
            val hadethAndDescription = hadeth.trim().split("\n").toMutableList()
            hadethTitleList.add(hadethAndDescription.get(0))
            hadethAndDescription.removeAt(0)
            // 5 lines ->
            hadethDescriptionList.add(hadethAndDescription.joinToString("\n"))
        }
        Log.e("TAG", "readHadethFromAssetsFile:  $hadethDescriptionList")
        adapter.updateData(hadethTitleList)
        adapter.onHadethItemClickListener = object : VersesAdapter.OnHadethItemClickListener {
            override fun onHadethItemClick(index: Int) {
                val intent = Intent(requireContext(), SuraDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_SURA_NAME, hadethTitleList.get(index))
                intent.putExtra(Constants.EXTRA_IS_SURA_CONTENT, false)
                intent.putExtra(Constants.HADETH_LIST_EXTRA, hadethDescriptionList.get(index))
                startActivity(intent)
            }
        }
    }


}
