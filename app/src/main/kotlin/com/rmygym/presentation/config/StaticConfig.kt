package com.rmygym.presentation.config

import com.rmygym.presentation.extensions.WeightFormatValue

fun initStaticConfig() {
    initWeight()
}

private fun initWeight(){
    StaticConfig.Weight.apply {
        groupingSeparator  = GroupingSeparator.Dot
        decimalSeparator = DecimalSeparator.Dot //TEMPORARY, later will be COMMA
        weightFormatValue = WeightFormatValue.KILOGRAMS.value
    }
}

class StaticConfig {

    object Weight {
        @JvmStatic var groupingSeparator: GroupingSeparator = GroupingSeparator.Dot

        @JvmStatic var decimalSeparator: DecimalSeparator = DecimalSeparator.Comma

        @JvmStatic var weightFormatValue = WeightFormatValue.KILOGRAMS.value
    }
}

sealed class DecimalSeparator(val digit: Char) {
    object Comma : DecimalSeparator(',')
    object Dot : DecimalSeparator('.')

    override fun toString() = digit.toString()
}

sealed class GroupingSeparator(val digit: Char) {
    object Comma : GroupingSeparator(',')
    object Dot : GroupingSeparator('.')
    object Space : GroupingSeparator(' ')

    override fun toString() = digit.toString()
}
