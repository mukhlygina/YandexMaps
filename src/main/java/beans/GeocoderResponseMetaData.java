
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GeocoderResponseMetaData {

    @SerializedName("request")
    @Expose
    public String request;
    @SerializedName("found")
    @Expose
    public String found;
    @SerializedName("results")
    @Expose
    public String results;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("request", request).append("found", found).append("results", results).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(request).append(found).append(results).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeocoderResponseMetaData) == false) {
            return false;
        }
        GeocoderResponseMetaData rhs = ((GeocoderResponseMetaData) other);
        return new EqualsBuilder().append(request, rhs.request).append(found, rhs.found).append(results, rhs.results).isEquals();
    }

}
