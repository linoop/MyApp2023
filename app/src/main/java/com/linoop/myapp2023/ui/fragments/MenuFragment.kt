package com.linoop.myapp2023.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.linoop.myapp2023.R
import com.linoop.myapp2023.databinding.FragmentMenuBinding


class MenuFragment:Fragment(R.layout.fragment_menu) {

    lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentMenuBinding.bind(view)
    }

}