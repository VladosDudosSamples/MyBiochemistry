package com.example.mybiochemistry.utils

import android.provider.Telephony.Mms.Part
import com.example.mybiochemistry.R
import com.example.mybiochemistry.model.PartListModel

object Destination {
    val listParts = listOf(
        PartListModel(R.drawable.protein_list_img, "Белки"),
        PartListModel(R.drawable.ferments_list_img, "Ферменты"),
        PartListModel(R.drawable.vitamins_list_img, "Витамины"),
        PartListModel(R.drawable.carbohydrates_list_img, "Углеводы"),
        PartListModel(R.drawable.lipides_list_img, "Липиды"),
        PartListModel(R.drawable.hormones_list_img, "Гормоны"),
        PartListModel(R.drawable.change_list_img, "Обмен б."),
        PartListModel(R.drawable.blood_list_img, "Кровь")
    )
    var isDrawerGraph = false
}