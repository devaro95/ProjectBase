package com.rmygym.presentation.extensions

import android.text.SpannableString
import android.text.TextUtils
import android.text.style.RelativeSizeSpan
import com.rmygym.presentation.config.StaticConfig
import com.rmygym.presentation.config.StaticConfig.Weight.decimalSeparator

enum class TypeScale(val scale: Float) {
    NO_SCALED(1f),
    HALF_SCALED(0.5f),
    THREE_QUARTERS_SCALED(0.75f)
}

fun Double.formattedWeight(proportion: TypeScale): CharSequence {
    val valueString = this.toString()

    if (valueString.isEmpty()) return valueString

    val position = valueString.indexOf(decimalSeparator.digit)
    val formatted = SpannableString(valueString)
    try {
        formatted.setSpan(RelativeSizeSpan(proportion.scale), position, formatted.length, 0)
    } catch (e: Exception) {
        return valueString
    }
    return formatted

}

fun Double.formattedWeightWithValue(proportion: TypeScale): CharSequence {
    val text = this.formattedWeight(proportion)
    val formatted = SpannableString(text)
    return TextUtils.concat(formatted, SEPARATOR_SPACE, StaticConfig.Weight.weightFormatValue)
}

enum class WeightFormatValue(val value: String){
    NO_WEIGHT(""),
    KILOGRAMS("kgs"),
    POUNDS("lbs")
}

const val SEPARATOR_SPACE = " "