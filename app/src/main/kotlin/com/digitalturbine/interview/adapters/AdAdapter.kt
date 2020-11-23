package com.digitalturbine.interview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalturbine.interview.R
import com.digitalturbine.interview.model.Ad
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.ad_item.view.*


/**
 * AdAdapter.
 */
class AdAdapter (private val items: List<Ad>, private val onClick: ((ad: Ad) -> Unit)? = null)
    : RecyclerView.Adapter<AdAdapter.AdRenderer>() {

    /**
     * Inflate a item row layout from XML and return the holder.
     */
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): AdRenderer {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the pod item row
        val itemView = inflater.inflate(R.layout.ad_item, parent, false)

        // Return the pod renderer holder instance
        return AdRenderer(itemView)
    }

    /**
     * Bind the data with the holder.
     */
    override fun onBindViewHolder (renderer: AdRenderer, position: Int) {
        renderer.bind(items[position])
    }

    /**
     * Returns the total count of items in the list.
     */
    override fun getItemCount (): Int {
        return items.size
    }

    /**
     * View holder - renderer class.
     */
    inner class AdRenderer (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        /**
         * Data binder
         */
        fun bind (ad : Ad) = containerView.apply {
            name.text  = ad.productName
            desc.text  = ad.productDescription
            rating.rating = ad.rating
            downloads.text = ad.numberOfDownloads

            Picasso.get().load(ad.productThumbnail).into( thumb )

            setOnClickListener{ onClick?.invoke(ad) }
        }

    }

}

