package com.alfresco.client.api.core.model.body;

import com.google.gson.annotations.SerializedName;

/**
 * Company
 */
public class CompanyBody
{
    @SerializedName("organization")
    public final String organization;

    @SerializedName("address1")
    public final String address1;

    @SerializedName("address2")
    public final String address2;

    @SerializedName("address3")
    public final String address3;

    @SerializedName("postcode")
    public final String postcode;

    @SerializedName("telephone")
    public final String telephone;

    @SerializedName("fax")
    public final String fax;

    @SerializedName("email")
    public final String email;

    public CompanyBody(String organization, String address1, String address2, String address3, String postcode,
            String telephone, String fax, String email)
    {
        this.organization = organization;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.postcode = postcode;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
    }
}
