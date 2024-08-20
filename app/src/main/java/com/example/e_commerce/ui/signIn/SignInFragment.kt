package com.example.e_commerce.ui.signIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_commerce.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView2.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment()) }

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
                ) Toast.makeText(context, "emailiniz doğruluğunu kontrol edin", Toast.LENGTH_LONG).show()
                else findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHome2())
            }
        }

    }
