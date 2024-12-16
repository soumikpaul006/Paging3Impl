package com.codegalaxy.pagingimpldec16.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codegalaxy.pagingimpldec16.databinding.FragmentProductBinding
import com.codegalaxy.pagingimpldec16.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding
    private val adapter = ProductAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        lifecycleScope.launch {
            viewModel.products.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        adapter.addLoadStateListener { loadState ->

            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading


            val errorState = loadState.source.refresh as? LoadState.Error
            errorState?.let {
                Toast.makeText(requireContext(), "Error: ${it.error.message}", Toast.LENGTH_SHORT).show()
                Log.e("ProductFragment", "Error: ${it.error.message}", it.error)
            }
        }
    }
}

