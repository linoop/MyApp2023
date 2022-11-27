package com.linoop.myapp2023.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.linoop.myapp2023.R
import com.linoop.myapp2023.databinding.FragmentLoginBinding
import com.linoop.myapp2023.models.UserModel
import com.linoop.myapp2023.ui.MainActivity
import com.linoop.myapp2023.utils.showToast
import com.linoop.myapp2023.viewmodels.MainViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var viewModel: MainViewModel
    private lateinit var context: MainActivity
    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel

        binding.tvSignUp.setOnClickListener{
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }


        binding.btnLogin.setOnClickListener{
            login()
        }
    }

    private fun login() {
        with(binding) {
            viewModel.login(etUserName.text.toString(),etPassword.text.toString()).observe(viewLifecycleOwner) {
                it?.let {
                    if (it.status) {
                        context.showToast(it.message) }
                    else
                        context.showToast(it.message)
                } ?: context.showToast("Some Thing went wrong!")
            }
        }
    }
}