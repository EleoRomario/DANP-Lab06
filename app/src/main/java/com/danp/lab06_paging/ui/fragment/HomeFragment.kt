package com.danp.lab06_paging.ui.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import com.danp.lab06_paging.R
import com.danp.lab06_paging.base.BaseFragment
import com.danp.lab06_paging.databinding.FragmentHomeBinding
import com.danp.lab06_paging.ui.adapter.PopularTvPagingAdapter
import com.danp.lab06_paging.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var popularTvPagingAdapter: PopularTvPagingAdapter

    override fun prepareView(savedInstanceState: Bundle?) {
        initAdapter()
        configureStateListener()
        pagingObserve()
    }

    private fun initAdapter() {
        binding.popularTvRecyclerView.adapter = popularTvPagingAdapter
    }

    @OptIn(ExperimentalPagingApi::class)
    private fun pagingObserve() {
        lifecycleScope.launch {
            viewModel.getAllPopularTv().collectLatest { response ->
                popularTvPagingAdapter.submitData(response)
            }
        }
    }

    private fun configureStateListener() {
        popularTvPagingAdapter.addLoadStateListener { loadState ->

            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error
            errorState?.let {
                Toast.makeText(activity, errorState.error.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}