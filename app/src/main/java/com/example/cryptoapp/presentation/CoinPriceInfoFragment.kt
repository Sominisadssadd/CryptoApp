package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CryptApplication
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.FragmentCoinPriceInfoBinding
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.example.cryptoapp.presentation.viewmodels.CoinInfoViewModel
import com.example.cryptoapp.presentation.viewmodels.CoinViewModelFactory
import com.squareup.picasso.Picasso
import javax.inject.Inject


class CoinPriceInfoFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private val viewModel: CoinInfoViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinInfoViewModel::class.java]
    }
    private var _binding: FragmentCoinPriceInfoBinding? = null
    private val binding: FragmentCoinPriceInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinPriceINfoBinding == null")

    private var currentCoin: CoinPriceInfo? = null


    private val componet by lazy {
        (requireActivity().application as CryptApplication)
            .injection
            .applciationSubComp()
            .create(currentCoin?.fromsymbol ?: "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentCoin = it.getSerializable(COIN_KEY) as CoinPriceInfo
        }
        componet.inject(this)
    }


    //от currentCoin получаем fSym

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCoinPriceInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.coiInfo.observe(viewLifecycleOwner) {
            updateFields(it)
        }
    }

    private fun updateFields(coinPriceInfo: CoinPriceInfo) {
        with(binding) {
            textViewNameCoinInfo.text = String.format(
                getString(R.string.text_view_coin_name_formatted),
                coinPriceInfo.fromsymbol,
                coinPriceInfo.tosymbol
            )
            textViewCostCoinInfo.text = String.format(
                getString(R.string.textViewCost),
                coinPriceInfo.price
            )
            textViewCostMin.text = String.format(
                getString(R.string.textMinDay),
                coinPriceInfo.low24hour
            )
            textViewCostMax.text = String.format(
                getString(R.string.textMaxDay),
                coinPriceInfo.high24hour
            )
            textViewLastDeal.text = String.format(
                getString(R.string.textViewDeal),
                coinPriceInfo.lastmarket
            )
            textViewLastUpdateCoinInfo.text = String.format(
                getString(R.string.textViewUpdate),
                coinPriceInfo.lastupdate
            )
            Picasso.get().load(coinPriceInfo.imageurl).into(imageViewCoinInfo)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        private const val COIN_KEY = "coin"

        @JvmStatic
        fun newInstance(coin: CoinPriceInfo) =
            CoinPriceInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(COIN_KEY, coin)
                }
            }

    }
}