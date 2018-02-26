
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Response {

    @SerializedName("GeoObjectCollection")
    @Expose
    public GeoObjectCollection geoObjectCollection;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("geoObjectCollection", geoObjectCollection).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(geoObjectCollection).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Response) == false) {
            return false;
        }
        Response rhs = ((Response) other);
        return new EqualsBuilder().append(geoObjectCollection, rhs.geoObjectCollection).isEquals();
    }

}
