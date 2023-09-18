package com.example.cryptoapp.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.databinding.FragmentCoinListInfoBinding
import com.example.cryptoapp.presentation.adapter.CoinInfoAdapter
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel


class CoinListInfoFragment : Fragment() {


    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }
    private var _binding: FragmentCoinListInfoBinding? = null
    private val binding: FragmentCoinListInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinListInfoBinding == null")

    private lateinit var coinAdapter: CoinInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCoinListInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        viewModel.listOfCoinInfo.observe(viewLifecycleOwner) {
            coinAdapter.submitList(it)
        }
    }

    private fun initRecyclerView() {
        coinAdapter = CoinInfoAdapter(requireContext())
        with(binding.recyclerViewOfCoinsPortrait) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coinAdapter
        }
        coinAdapter.onClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, CoinPriceInfoFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}