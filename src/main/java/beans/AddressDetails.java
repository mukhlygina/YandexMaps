
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressDetails {

    @SerializedName("Country")
    @Expose
    public Country country;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("country", country).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressDetails) == false) {
            return false;
        }
        AddressDetails rhs = ((AddressDetails) other);
        return new EqualsBuilder().append(country, rhs.country).isEquals();
    }

}
