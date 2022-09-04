package com.example.corrutina.main.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.corrutina.R
import com.example.corrutina.databinding.ActivityMainBinding
import com.example.corrutina.main.data.ItemsProvider
import com.example.corrutina.main.presentation.adapters.MainAdapter
import com.example.corrutina.main.presentation.viewmodel.MainViewModel



class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainAdapter = MainAdapter()
    private val observer = { items: List<String> -> mainAdapter.setData(items)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ItemsProvider.startEmitting()
        ItemsProvider.observable.suscribe(observer)


        /*setContentView(R.layout.activity_login)
        initActions()
        initObservers()*/
        initRecyclerView()
    }

    override fun onDestroy(){
        ItemsProvider.observable.unsuscribe(observer)
        super.onDestroy()
    }

    private fun initRecyclerView(){
        binding.recyclerViewMain.adapter = mainAdapter
    }

    private fun initActions(){
        viewModel.requestData()
    }

    private fun initObservers(){
        viewModel.requestData.observe(this, ::handleData)
    }

    private fun handleData(response: String){

    }
}