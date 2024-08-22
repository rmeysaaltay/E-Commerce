package com.example.e_commerce.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("UNREACHABLE_CODE")
class Home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // View Binding kullanarak layout'u inflate et
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  Bottom Navigation'a erişmek için binding kullan
        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController()

        //Bottom Navigation setup
        bottomNavigationView.setupWithNavController(navController)
    }
}

