
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Point {

    @SerializedName("pos")
    @Expose
    public String pos;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pos", pos).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pos).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Point) == false) {
            return false;
        }
        Point rhs = ((Point) other);
        return new EqualsBuilder().append(pos, rhs.pos).isEquals();
    }

}
