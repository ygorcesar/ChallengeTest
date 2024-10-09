package com.example.challenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.challenge.adapter.DataItemAdapter
import com.example.challenge.databinding.MainActivityBinding
import com.example.challenge.model.Data
import com.example.challenge.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }
    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()
        viewModel.getData()
    }

    private fun setupObservers() {
        viewModel.data.observe(this, ::handleData)
    }

    private fun onDataClick(data: Data) {
        Toast.makeText(this, "Data clicked: $data", Toast.LENGTH_SHORT).show()
    }

    private fun handleData(data: List<Data>) {
        val adapter = DataItemAdapter(
            dataEntries = data,
            onItemClick = ::onDataClick,
        )
        binding.recyclerView.adapter = adapter
    }
}
