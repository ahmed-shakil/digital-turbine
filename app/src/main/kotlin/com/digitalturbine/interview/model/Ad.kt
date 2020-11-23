package com.digitalturbine.interview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Ad - domain object.
 */
@Parcelize
@Root(name="ad", strict = false)
data class Ad @JvmOverloads constructor(
    @field:Element(name="appId") @param:Element(name="appId")
    val appId: String = "",

    @field:Element(name="averageRatingImageURL") @param:Element(name="averageRatingImageURL")
    val averageRatingImageURL: String? = null,

    @field:Element(name="bidRate") @param:Element(name="bidRate")
    val bidRate: Float = 0f,

    @field:Element(name="billingTypeId") @param:Element(name="billingTypeId")
    val billingTypeId: String? = null,

    @field:Element(name="callToAction") @param:Element(name="callToAction")
    val callToAction: String? = null,

    @field:Element(name="campaignDisplayOrder") @param:Element(name="campaignDisplayOrder")
    val campaignDisplayOrder: Int = 0,

    @field:Element(name="campaignId") @param:Element(name="campaignId")
    val campaignId: String? = null,

    @field:Element(name="campaignTypeId") @param:Element(name="campaignTypeId")
    val campaignTypeId: String? = null,

    @field:Element(name="categoryName") @param:Element(name="categoryName")
    val categoryName: String? = null,

    @field:Element(name="clickProxyURL") @param:Element(name="clickProxyURL")
    val clickProxyURL: String? = null,

    @field:Element(name="creativeId") @param:Element(name="creativeId")
    val creativeId: String? = null,

    @field:Element(name="homeScreen") @param:Element(name="homeScreen")
    val homeScreen: Boolean = false,

    @field:Element(name="impressionTrackingURL") @param:Element(name="impressionTrackingURL")
    val impressionTrackingURL: String? = null,

    @field:Element(name="isRandomPick") @param:Element(name="isRandomPick")
    val isRandomPick: Boolean = false,

    @field:Element(name="minOSVersion", required = false) @param:Element(name="minOSVersion", required = false)
    val minOSVersion: String? = null,

    @field:Element(name="numberOfRatings") @param:Element(name="numberOfRatings")
    val numberOfRatings: String? = null,

    @field:Element(name="productDescription") @param:Element(name="productDescription")
    val productDescription: String = "",

    @field:Element(name="productId") @param:Element(name="productId")
    val productId: String = "",

    @field:Element(name="productName") @param:Element(name="productName")
    val productName: String = "",

    @field:Element(name="productThumbnail") @param:Element(name="productThumbnail")
    val productThumbnail: String? = null,

    @field:Element(name="rating") @param:Element(name="rating")
    val rating: Float = 0f,

    @field:Element(name="numberOfDownloads") @param:Element(name="numberOfDownloads")
    val numberOfDownloads: String? = null
) : Parcelable

@Root(name = "ads", strict = false)
data class Ads(
    @field:ElementList(name="ad", inline=true)
    @param:ElementList(name="ad", inline=true)
    val items: List<Ad> = emptyList()
)
