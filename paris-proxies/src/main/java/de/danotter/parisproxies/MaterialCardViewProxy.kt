package de.danotter.parisproxies

import android.view.ViewGroup
import androidx.annotation.Px
import androidx.core.view.updateLayoutParams
import com.airbnb.paris.annotations.AfterStyle
import com.airbnb.paris.annotations.Attr
import com.airbnb.paris.annotations.Styleable
import com.airbnb.paris.proxies.BaseProxy
import com.airbnb.paris.styles.Style
import com.google.android.material.card.MaterialCardView
import de.danotter.parisproxies.R2

@Styleable("App_MaterialCardView")
class MaterialCardViewProxy(private val cardView: MaterialCardView) :
    BaseProxy<MaterialCardViewProxy, MaterialCardView>(cardView) {

    @set:Attr(R2.styleable.App_MaterialCardView_android_layout_marginStart)
    @setparam:Px
    var marginStart: Int = 0

    @set:Attr(R2.styleable.App_MaterialCardView_android_layout_marginEnd)
    @setparam:Px
    var marginEnd: Int = 0

    @Attr(R2.styleable.App_MaterialCardView_elevation)
    fun setElevation(@Px elevation: Float) {
        cardView.elevation = elevation
    }

    @Attr(R2.styleable.App_MaterialCardView_cornerRadius)
    fun setRadius(@Px radius: Float) {
        cardView.radius = radius
    }

    // add more properties if needed..

    @AfterStyle
    fun applyStyles(@Suppress("UNUSED_PARAMETER") style: Style?) {
        cardView.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginStart = this@MaterialCardViewProxy.marginStart
            marginEnd = this@MaterialCardViewProxy.marginEnd
        }
    }
}
