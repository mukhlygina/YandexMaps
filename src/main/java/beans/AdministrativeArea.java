
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AdministrativeArea {

    @SerializedName("AdministrativeAreaName")
    @Expose
    public String administrativeAreaName;
    @SerializedName("Locality")
    @Expose
    public Locality locality;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("administrativeAreaName", administrativeAreaName).append("locality", locality).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locality).append(administrativeAreaName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdministrativeArea) == false) {
            return false;
        }
        AdministrativeArea rhs = ((AdministrativeArea) other);
        return new EqualsBuilder().append(locality, rhs.locality).append(administrativeAreaName, rhs.administrativeAreaName).isEquals();
    }

}
