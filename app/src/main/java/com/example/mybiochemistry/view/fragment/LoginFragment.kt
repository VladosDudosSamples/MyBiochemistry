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

    private fun checkInput(): Boolean {
//        if (checkEmail(binding.editLogin.text.toString())) {
        if (!binding.passwordEditText.text.isNullOrEmpty()) {
            return true
        } else makeToast(getString(R.string.enter_the_password))
//        }
        return false
    }

    private fun makeToast(m: String) {
        Toast.makeText(activity, m, Toast.LENGTH_SHORT).show()
    }

    private fun updateUI(account: FirebaseUser?) {
        if (account != null) {
            makeToast(getString(R.string.you_have_been_successfully_authorised))
        } else {
            makeToast(getString(R.string.failed_to_authorize))
        }
    }

    private fun authorise() {
        val mail = binding.userNameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        if (checkInput()) {
            startActivity(
                Intent(
                    requireContext(),
                    DrawerActivity::class.java
                )
            )
//            auth.signInWithEmailAndPassword(mail, password)
//                .addOnCompleteListener(requireActivity()) { task ->
//                    if (task.isSuccessful) {
//                        Log.d(ContentValues.TAG, "signInWithEmail:success")
//                        val user = auth.currentUser
//                        updateUI(user)
//                        App.dm.setUserKey(user!!.uid)
//                        App.dm.passLogin()
//
            requireActivity().finish()
//        } else {
//            Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
//            makeToast(getString(R.string.smth_went_wrong))
//        }
//    }
        }
    }

//    private fun resetPassword() {
//        if (checkEmail(binding.editLogin.text.toString())) {
//            MaterialDialog(requireActivity())
//                .title(text = getString(R.string.do_you_want_to_reset_password_for))
//                .message(text = binding.editLogin.text.toString() + " ?")
//                .positiveButton(text = "Yes") {
//                    auth.sendPasswordResetEmail(binding.editLogin.text.toString())
//                        .addOnCompleteListener {
//                            if (!it.isSuccessful) {
//                                Toast.makeText(activity, getString(R.string.some_problems_went), Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//                        }
//                }
//                .show { }
//        } else Toast.makeText(activity, getString(R.string.your_email_must_be_correct), Toast.LENGTH_SHORT).show()
//    }
//    private fun checkEmail(email: String): Boolean {
//        when {
//            !Patterns.EMAIL_ADDRESS.matcher(binding.editLogin.text)
//                .matches() -> makeToast(getString(R.string.enter_correct_email))
//            binding.editLogin.text.isNullOrEmpty() -> makeToast(getString(R.string.enter_email))
//            else -> return true
//        }
//        return false
//    }
}