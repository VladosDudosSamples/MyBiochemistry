package com.example.mybiochemistry.utils

import androidx.lifecycle.MutableLiveData
import com.example.mybiochemistry.R
import com.example.mybiochemistry.app.App
import com.example.mybiochemistry.model.User
import com.google.firebase.firestore.FirebaseFirestore

object CurrentFragmentDrawer {
    val fragmentName = mapOf(0 to R.string.main_name, 1 to R.string.biochemistry_list, 2 to R.string.more_about_course, 3 to R.string.settings, 4 to R.string.enter_promo)
    var currentUser = User("", "")
}