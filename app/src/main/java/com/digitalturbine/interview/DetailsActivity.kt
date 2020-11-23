package com.digitalturbine.interview

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.digitalturbine.interview.model.Ad
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

/**
 * Ad details activity.
 */
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Read the Ad object and set all the necessary values.
        intent.getParcelableExtra<Ad>(PARAM_AD)?.let { ad ->
            name.text = ad.productName
            desc.text = ad.productDescription
            rating.rating = ad.rating
            category.setValue(R.string.category_x, ad.categoryName)
            reviews.setValue(R.string.x_ratings, ad.numberOfRatings)
            downloads.setValue(R.string.x_downloads, ad.numberOfDownloads)
            minOsVer.setValue(R.string.min_os_ver_x, ad.minOSVersion)
            action.text = ad.callToAction
            action.setOnClickListener(::onCallToAction)
            ad.productThumbnail?.let {
                Picasso.get().load(it).into( thumb )
            }
        }
    }

    /**
     * Concat the vale to provided resId string and set the text to the text view.
     * If value is null then hide the text view.
     */
    private fun TextView.setValue(resId: Int, value: String?) {
        value?.let {
            text = getString(resId, it)
        } ?: run { visibility = View.GONE }
    }

    private fun onCallToAction (v: View) =
        Toast.makeText(applicationContext, "As soon as Digital Turbine hires me,\nyou will be able to perform this action.\nNo Problem!", Toast.LENGTH_LONG).show()

    companion object {
        const val PARAM_AD = "PARAM-AD"
    }
}