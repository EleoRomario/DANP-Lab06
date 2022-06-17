package com.danp.lab06_paging.ui.fragment

import android.os.Bundle
import com.danp.lab06_paging.R
import com.danp.lab06_paging.base.BaseFragment
import com.danp.lab06_paging.databinding.FragmentFavoritesBinding

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_favorites

    override fun prepareView(savedInstanceState: Bundle?) {}
}