package com.example.mybiochemistry.view.fragment

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mybiochemistry.R
import com.example.mybiochemistry.databinding.FragmentRegistrationBinding
import com.example.mybiochemistry.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class RegistrationFragment : Fragment() {

    private val binding: FragmentRegistrationBinding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }
    private var authFirebase: FirebaseAuth = FirebaseAuth.getInstance()
    private var store = FirebaseFirestore.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick(){
        binding.authorisationButton.setOnClickListener {
            registration()
        }
    }
    private fun makeToast(m: String) {
        Toast.makeText(activity, m, Toast.LENGTH_SHORT).show()
    }

    private fun registration() {
        val nick = binding.userNameEditText.text.toString()
        val mail = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        val userNew = User(
            nick,
            "01/01/1995 00:01"
        )

        if (checkInput()) {
            authFirebase.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = authFirebase.currentUser
                        updateUI(user)

                        store.collection("Users").document(user!!.uid).set(userNew)
                            .addOnCompleteListener(requireActivity()) { res ->
                                if (res.isSuccessful) {
                                    findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                                } else makeToast(res.exception!!.message.toString())
                            }
                    } else {
                        makeToast(task.exception.toString())
                        updateUI(null)
                    }
                }
        }
    }

    private fun updateUI(account: FirebaseUser?) {
        if (account != null)
            makeToast(getString(R.string.registered_successfully))
        else makeToast(getString(R.string.smth_went_wrong))
    }
    private fun checkInput(): Boolean {
        with(binding) {
            when {
                !Patterns.EMAIL_ADDRESS.matcher(emailEditText.text.toString())
                    .matches() -> makeToast(getString(R.string.enter_email))

                userNameEditText.text.isNullOrEmpty() -> makeToast(getString(R.string.nickname_is_empty))
                passwordEditText.text.isNullOrEmpty() -> makeToast(getString(R.string.enter_the_password))
                passwordEditText.text.toString().length < 6 -> makeToast(getString(R.string.password_must_be_6_symbols_at_least))
                emailEditText.text.isNullOrEmpty() -> makeToast(getString(R.string.enter_email))
                else -> return true
            }
            return false
        }
    }
}