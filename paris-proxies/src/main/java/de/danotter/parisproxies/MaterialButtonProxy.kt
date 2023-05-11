package de.danotter.parisproxies

import android.content.res.ColorStateList
import androidx.annotation.Px
import androidx.core.view.ViewCompat
import com.airbnb.paris.annotations.AfterStyle
import com.airbnb.paris.annotations.Attr
import com.airbnb.paris.annotations.Styleable
import com.airbnb.paris.proxies.BaseProxy
import com.airbnb.paris.styles.Style
import com.google.android.material.button.MaterialButton

@Styleable("App_MaterialButton")
class MaterialButtonProxy(private val button: MaterialButton) :
    BaseProxy<MaterialButtonProxy, MaterialButton>(button) {

    @set:Attr(R2.styleable.App_MaterialButton_android_insetLeft)
    @setparam:Px
    var insetLeft: Int = 0

    @set:Attr(R2.styleable.App_MaterialButton_android_insetTop)
    @setparam:Px
    var insetTop: Int = 0

    @set:Attr(R2.styleable.App_MaterialButton_android_insetRight)
    @setparam:Px
    var insetRight: Int = 0

    @set:Attr(R2.styleable.App_MaterialButton_android_insetBottom)
    @setparam:Px
    var insetBottom: Int = 0

    @Attr(R2.styleable.App_MaterialButton_backgroundTint)
    fun setBackgroundTint(backgroundTintList: ColorStateList?) {
        button.backgroundTintList = backgroundTintList
    }

    @Attr(R2.styleable.App_MaterialButton_rippleColor)
    fun setRippleColor(rippleColor: ColorStateList?) {
        button.rippleColor = rippleColor
    }

    @Attr(R2.styleable.App_MaterialButton_strokeColor)
    fun setStrokeColor(strokeColor: ColorStateList?) {
        button.strokeColor = strokeColor
    }

    @Attr(R2.styleable.App_MaterialButton_strokeWidth)
    fun setStrokeWidth(@Px strokeWidth: Int) {
        button.strokeWidth = strokeWidth
    }

    @Attr(R2.styleable.App_MaterialButton_android_checkable)
    fun setCheckable(isCheckable: Boolean) {
        button.isCheckable = isCheckable
    }

    @Attr(R2.styleable.App_MaterialButton_elevation)
    fun setElevation(@Px elevation: Float) {
        button.elevation = elevation
    }

    @AfterStyle
    fun applyStyles(@Suppress("UNUSED_PARAMETER") style: Style?) {
        val materialButton = button

        val paddingStart = ViewCompat.getPaddingStart(materialButton)
        val paddingTop: Int = materialButton.paddingTop
        val paddingEnd = ViewCompat.getPaddingEnd(materialButton)
        val paddingBottom: Int = materialButton.paddingBottom

        ViewCompat.setPaddingRelative(
            materialButton,
            paddingStart + insetLeft,
            paddingTop + insetTop,
            paddingEnd + insetRight,
            paddingBottom + insetBottom
        )
    }
}
