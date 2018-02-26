
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Country {

    @SerializedName("AddressLine")
    @Expose
    public String addressLine;
    @SerializedName("CountryNameCode")
    @Expose
    public String countryNameCode;
    @SerializedName("CountryName")
    @Expose
    public String countryName;
    @SerializedName("AdministrativeArea")
    @Expose
    public AdministrativeArea administrativeArea;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("addressLine", addressLine).append("countryNameCode", countryNameCode).append("countryName", countryName).append("administrativeArea", administrativeArea).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(countryName).append(addressLine).append(administrativeArea).append(countryNameCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Country) == false) {
            return false;
        }
        Country rhs = ((Country) other);
        return new EqualsBuilder().append(countryName, rhs.countryName).append(addressLine, rhs.addressLine).append(administrativeArea, rhs.administrativeArea).append(countryNameCode, rhs.countryNameCode).isEquals();
    }

}
