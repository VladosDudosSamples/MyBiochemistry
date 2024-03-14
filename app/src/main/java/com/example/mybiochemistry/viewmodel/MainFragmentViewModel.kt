package com.example.mybiochemistry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mybiochemistry.app.App
import com.example.mybiochemistry.model.User
import com.example.mybiochemistry.utils.CurrentFragmentDrawer
import com.google.firebase.firestore.FirebaseFirestore

class MainFragmentViewModel : ViewModel() {
    private var store = FirebaseFirestore.getInstance()
    var currentUser = MutableLiveData(User("Adolf", "12/12/2025"))

    fun getSubscribeInfo() {
        var name: String
        var subscribeDate: String
        store.collection("Users").document(App.dm.decryptToken()).get()
            .addOnCompleteListener {
                name = it.result.get("name").toString()
                subscribeDate = it.result.get("subscribeDate").toString()
                currentUser.value = User(name, subscribeDate)
                CurrentFragmentDrawer.currentUser = currentUser.value!!
            }
    }
}