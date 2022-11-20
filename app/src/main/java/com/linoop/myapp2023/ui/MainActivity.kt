package com.linoop.myapp2023.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.linoop.myapp2023.R
import com.linoop.myapp2023.databinding.ActivityMainBinding
import com.linoop.myapp2023.models.Item
import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.storage.MyDatabase
import com.linoop.myapp2023.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var myDatabase: MyDatabase
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveRecord.setOnClickListener {
            myDatabase.saveRecord(Item("My item"))
        }

        binding.downloadData.setOnClickListener { downloadData() }
        binding.uploadData.setOnClickListener { uploadData() }
        collectData()
    }

    private fun collectData() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.response.collectLatest {
                binding.status.text = it.toString()
            }
        }
    }

    private fun downloadData() {
        viewModel.downloadData()
    }
    private fun uploadData(){
        viewModel.uploadData(MyData(data = ""))
    }
}