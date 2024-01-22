package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_gsun_wed.islamiApp.Constants
import com.route.islami_c39_gsun_wed.islamiApp.SuraDetailsActivity
import com.route.islami_c39_gsun_wed.islamiApp.adapter.SuraNameAdapter
import com.route.islami_c39_gsun_wed.islamiApp.model.SuraNameIndex
import com.route.islami_c39_gsun_wed.islamiApp.model.suraNamesList

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: SuraNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // List<String>   -> item -> object ->
        val suraNameIndexList = suraNamesList.mapIndexed { index, suraName ->
            // UI -> 1 -> 114
            return@mapIndexed SuraNameIndex(suraName, index + 1)
        }
        adapter = SuraNameAdapter(suraNameIndexList)
        adapter.onSuraItemClickListener = object : SuraNameAdapter.OnSuraItemClickListener {
            override fun onSuraItemClick(suraName: String, index: Int) {
//                context
//                requireContext()
//                activity
//                requireActivity()
                val intent = Intent(requireContext(), SuraDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_SURA_NAME, suraName)
                intent.putExtra(Constants.EXTRA_SURA_INDEX, index)
                startActivity(intent)
            }
        }
        binding.suraNameIndexRecyclerView.adapter = adapter
    }

}
