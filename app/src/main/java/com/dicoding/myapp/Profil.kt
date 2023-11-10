package com.dicoding.myapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Profil (
    val me: String,
    val akun: String,
    val foto: Int
) : Parcelable