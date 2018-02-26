
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Thoroughfare {

    @SerializedName("ThoroughfareName")
    @Expose
    public String thoroughfareName;
    @SerializedName("Premise")
    @Expose
    public Premise premise;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("thoroughfareName", thoroughfareName).append("premise", premise).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thoroughfareName).append(premise).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Thoroughfare) == false) {
            return false;
        }
        Thoroughfare rhs = ((Thoroughfare) other);
        return new EqualsBuilder().append(thoroughfareName, rhs.thoroughfareName).append(premise, rhs.premise).isEquals();
    }

}
