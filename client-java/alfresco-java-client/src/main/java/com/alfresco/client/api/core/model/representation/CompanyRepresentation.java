/*
 *   Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *   This file is part of Alfresco Java Client.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alfresco.client.api.core.model.representation;

import java.util.Objects;

import com.alfresco.client.api.common.representation.AbstractRepresentation;
import com.google.gson.annotations.SerializedName;

public class CompanyRepresentation extends AbstractRepresentation
{
    @SerializedName("organization")
    private String organization = null;

    @SerializedName("address1")
    private String address1 = null;

    @SerializedName("address2")
    private String address2 = null;

    @SerializedName("address3")
    private String address3 = null;

    @SerializedName("postcode")
    private String postcode = null;

    @SerializedName("telephone")
    private String telephone = null;

    @SerializedName("fax")
    private String fax = null;

    @SerializedName("email")
    private String email = null;

    // ///////////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Get organization
     * 
     * @return organization
     **/
    public String getOrganization()
    {
        return organization;
    }

    public void setOrganization(String organization)
    {
        this.organization = organization;
    }

    /**
     * Get address1
     * 
     * @return address1
     **/
    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    /**
     * Get address2
     * 
     * @return address2
     **/
    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    /**
     * Get address3
     * 
     * @return address3
     **/
    public String getAddress3()
    {
        return address3;
    }

    public void setAddress3(String address3)
    {
        this.address3 = address3;
    }

    /**
     * Get postcode
     * 
     * @return postcode
     **/
    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    /**
     * Get telephone
     * 
     * @return telephone
     **/
    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * Get fax
     * 
     * @return fax
     **/
    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    /**
     * Get email
     * 
     * @return email
     **/
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CompanyRepresentation company = (CompanyRepresentation) o;
        return Objects.equals(this.organization, company.organization)
                && Objects.equals(this.address1, company.address1) && Objects.equals(this.address2, company.address2)
                && Objects.equals(this.address3, company.address3) && Objects.equals(this.postcode, company.postcode)
                && Objects.equals(this.telephone, company.telephone) && Objects.equals(this.fax, company.fax)
                && Objects.equals(this.email, company.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(organization, address1, address2, address3, postcode, telephone, fax, email);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Company {\n");

        sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
        sb.append("    address1: ").append(toIndentedString(address1)).append("\n");
        sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
        sb.append("    address3: ").append(toIndentedString(address3)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
        sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
