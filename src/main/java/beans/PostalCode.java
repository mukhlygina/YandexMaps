
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PostalCode {

    @SerializedName("PostalCodeNumber")
    @Expose
    public String postalCodeNumber;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("postalCodeNumber", postalCodeNumber).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(postalCodeNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostalCode) == false) {
            return false;
        }
        PostalCode rhs = ((PostalCode) other);
        return new EqualsBuilder().append(postalCodeNumber, rhs.postalCodeNumber).isEquals();
    }

}
