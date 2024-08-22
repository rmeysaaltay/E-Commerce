package com.example.e_commerce.ui.signIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.e_commerce.databinding.FragmentSignInBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { SignInViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.text = viewModel.someFlow.value

        viewModel.updateData("benim adım name")


        // repeatOnLifecycle kullanımı
       /* viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.someFlow.collect { value ->
                    delay(2000)
                    binding.textView2.text = viewModel.someFlow.value

                    // UI'ı güncelle
                    // Örnek: textView.text = value
                }//
            }
        }*/

        binding.textView2.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        binding.imageButton.setOnClickListener() {
            if (binding.editTextText2.text.isEmpty() || binding.editTextText.text.isEmpty()) {
                Toast.makeText(context, "bu alanlar boş bırakılamaz", Toast.LENGTH_LONG).show()

            }
            if (binding.editTextText2.text.toString().length < 6) Toast.makeText(
                context,
                "şifre 6 karakter ve daha uzun olmalıdır",
                Toast.LENGTH_LONG
            ).show()
            if (binding.editTextText.text.toString()
                    .takeLast(9) == "@gmail.com"
            ) Toast.makeText(context, "emailiniz doğruluğunu kontrol edin", Toast.LENGTH_LONG)
                .show()
            else findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHome2())
        }
    }

}
