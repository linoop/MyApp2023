package com.linoop.myapp2023.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.linoop.myapp2023.databinding.ActivityMainBinding
import com.linoop.myapp2023.storage.MyDatabase
import com.linoop.myapp2023.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var myDatabase: MyDatabase
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}