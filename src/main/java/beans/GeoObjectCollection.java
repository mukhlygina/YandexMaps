
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GeoObjectCollection {

    @SerializedName("metaDataProperty")
    @Expose
    public MetaDataProperty metaDataProperty;
    @SerializedName("featureMember")
    @Expose
    public List<FeatureMember> featureMember = new ArrayList<FeatureMember>();

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("metaDataProperty", metaDataProperty).append("featureMember", featureMember).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metaDataProperty).append(featureMember).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeoObjectCollection) == false) {
            return false;
        }
        GeoObjectCollection rhs = ((GeoObjectCollection) other);
        return new EqualsBuilder().append(metaDataProperty, rhs.metaDataProperty).append(featureMember, rhs.featureMember).isEquals();
    }

}
