

import android.os.Parcelable
import kotlinx. parcelize.Parcelize

@Parcelize
data class Data(
    val Image: Int,
    val Title: String,
    val Des: String
) : Parcelable