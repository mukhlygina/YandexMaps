
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Address {

    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("postal_code")
    @Expose
    public String postalCode;
    @SerializedName("formatted")
    @Expose
    public String formatted;
    @SerializedName("Components")
    @Expose
    public List<Component> components = new ArrayList<Component>();

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("countryCode", countryCode).append("postalCode", postalCode).append("formatted", formatted).append("components", components).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(components).append(countryCode).append(formatted).append(postalCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(components, rhs.components).append(countryCode, rhs.countryCode).append(formatted, rhs.formatted).append(postalCode, rhs.postalCode).isEquals();
    }

}
