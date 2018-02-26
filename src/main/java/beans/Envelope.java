
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Envelope {

    @SerializedName("lowerCorner")
    @Expose
    public String lowerCorner;
    @SerializedName("upperCorner")
    @Expose
    public String upperCorner;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lowerCorner", lowerCorner).append("upperCorner", upperCorner).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lowerCorner).append(upperCorner).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Envelope) == false) {
            return false;
        }
        Envelope rhs = ((Envelope) other);
        return new EqualsBuilder().append(lowerCorner, rhs.lowerCorner).append(upperCorner, rhs.upperCorner).isEquals();
    }

}
