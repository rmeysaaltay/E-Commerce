package com.example.e_commerce.ui

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_commerce.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButton2.setOnClickListener() {
            if (binding.editTextText4.text.isEmpty() || binding.editTextText5.text.isEmpty()) Toast.makeText(
                context,
                "Email ve şifre boş bırakılamaz",
                Toast.LENGTH_LONG
            ).show()
            if (binding.editTextText5.text.toString().length < 6) Toast.makeText(
                context,
                "şife 6 karakter ve daha uzun olmalıdır",
                Toast.LENGTH_LONG
            ).show()
            if (binding.editTextText4.text.toString().takeLast(9) == "@gmail.com") Toast.makeText(
                context,
                "emailiniz doğruluğunu kontrol edin",
                Toast.LENGTH_LONG
            ).show()
            else findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHome2())

        }
        binding.textView5.setOnClickListener{
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
