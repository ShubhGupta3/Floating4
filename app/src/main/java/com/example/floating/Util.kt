package com.example.floating

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.floating.FriendName
import com.example.floating.R

val i = 1
fun formatNames(names: List<FriendName>, resources: Resources): Spanned {
    val sb = StringBuilder()

    sb.apply {
        append(resources.getString(R.string.list_header))
        names.forEach {
            append("<br>")
            append(it.frnnaam)

        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
fun formatBadNames(names: List<BadFriendName>, resources: Resources): Spanned {
    val sb = StringBuilder()

    sb.apply {
        append(resources.getString(R.string.list_header_bad))
        names.forEach {
            append("<br>")
            append(it.badFrnNaam)

        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}