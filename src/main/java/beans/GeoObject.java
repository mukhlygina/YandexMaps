
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GeoObject {

    @SerializedName("metaDataProperty")
    @Expose
    public MetaDataProperty_ metaDataProperty;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("boundedBy")
    @Expose
    public BoundedBy boundedBy;
    @SerializedName("Point")
    @Expose
    public Point point;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("metaDataProperty", metaDataProperty).append("description", description).append("name", name).append("boundedBy", boundedBy).append("point", point).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(description).append(metaDataProperty).append(point).append(boundedBy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeoObject) == false) {
            return false;
        }
        GeoObject rhs = ((GeoObject) other);
        return new EqualsBuilder().append(name, rhs.name).append(description, rhs.description).append(metaDataProperty, rhs.metaDataProperty).append(point, rhs.point).append(boundedBy, rhs.boundedBy).isEquals();
    }

}
