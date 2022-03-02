package pw.bullseye.monitor.product;

import com.google.gson.annotations.SerializedName;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public class Product {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("link")
    private String link;

    @SerializedName("price")
    private String price;

    @SerializedName("sku")
    private String sku;

    @SerializedName("store")
    private String store;

    @SerializedName("store_url")
    private String storeURL;

    @SerializedName("region")
    private String region;

    @SerializedName("offer_id")
    private String offerID;

    @SerializedName("availability_id")
    private String availabilityID;

    @SerializedName("sku_id")
    private String skuID;

    public String getTitle() {
        return title;
    }

    public String getOfferID() {
        return offerID;
    }

    public String getAvailabilityID() {
        return availabilityID;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public String getStore() {
        return store;
    }

    public String getStoreURL() {
        return storeURL;
    }

    public String getRegion() {
        return region;
    }

    public String getSkuID() {
        return skuID;
    }
}
