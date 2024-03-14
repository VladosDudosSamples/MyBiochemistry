package com.example.mybiochemistry.view.fragment

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.app.App
import com.example.mybiochemistry.databinding.FragmentLoginBinding
import com.example.mybiochemistry.view.activity.DrawerActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        onClick()
    }

    private fun onClick() {
        binding.registerButton.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_registrationFragment) }
        binding.nextButton.setOnClickListener {
            authorise()
        }
    }

    private fun authorise() {
        with(binding) {
            val mail = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (checkInput()) {
                auth.signInWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            Log.d(ContentValues.TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                            App.dm.passLogin()
                            App.dm.encryptToken(user!!.uid)
                            startActivity(Intent(requireContext(), DrawerActivity::class.java))
                        } else {
                            Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                            makeToast(task.exception.toString())
                            updateUI(null)
                        }
                    }
            }
        }
    }

    private fun checkInput(): Boolean {
        when {
            !Patterns.EMAIL_ADDRESS.matcher(binding.userNameEditText.text)
                .matches() -> makeToast(getString(R.string.enter_email))

            binding.userNameEditText.text.isNullOrEmpty() -> makeToast(getString(R.string.enter_email))
            binding.passwordEditText.text.isNullOrEmpty() -> makeToast(getString(R.string.enter_the_password))
            binding.passwordEditText.text.toString().length < 6 -> makeToast(getString(R.string.password_must_be_6_symbols_at_least))

            else -> return true
        }
        return false
    }

    private fun makeToast(m: String) {
        Toast.makeText(activity, m, Toast.LENGTH_SHORT).show()
    }

    private fun updateUI(account: FirebaseUser?) {
        if (account != null)
            makeToast(getString(R.string.successfully_authorised))
        else makeToast(getString(R.string.smth_went_wrong))
    }
}