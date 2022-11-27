package com.linoop.myapp2023.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.linoop.myapp2023.R
import com.linoop.myapp2023.databinding.FragmentSignUpBinding
import com.linoop.myapp2023.models.UserModel
import com.linoop.myapp2023.ui.MainActivity
import com.linoop.myapp2023.utils.showToast
import com.linoop.myapp2023.viewmodels.MainViewModel

class RegisterFragment : Fragment(R.layout.fragment_sign_up) {
    lateinit var binding: FragmentSignUpBinding

    private lateinit var viewModel: MainViewModel
    private lateinit var context: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel

        binding.btnRegister.setOnClickListener {
            signup()
        }

    }


    private fun signup() {
        with(binding) {
            val userModel = UserModel(
                name = etName.text.toString().trim(),
                username = etUserName.text.toString().trim(),
                password = etPassword.text.toString().trim(),
                email = etEmail.text.toString().trim()
            )
            viewModel.signup(userModel).observe(viewLifecycleOwner) {
                it?.let {
                    if (it.status) {
                        context.showToast(it.message)
                        view?.findNavController()?.popBackStack()
                    }
                    else
                        context.showToast(it.message)
                } ?: context.showToast("Some Thing went wrong!")

            }
        }

    }

}