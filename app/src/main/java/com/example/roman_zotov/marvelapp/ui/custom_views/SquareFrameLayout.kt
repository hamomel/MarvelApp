package com.example.roman_zotov.marvelapp.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout


/**
 * Created by Roman_Zotov on 28-Mar-18.
 *
 */
class SquareFrameLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}