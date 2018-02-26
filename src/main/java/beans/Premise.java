
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Premise {

    @SerializedName("PremiseNumber")
    @Expose
    public String premiseNumber;
    @SerializedName("PostalCode")
    @Expose
    public PostalCode postalCode;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("premiseNumber", premiseNumber).append("postalCode", postalCode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(premiseNumber).append(postalCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Premise) == false) {
            return false;
        }
        Premise rhs = ((Premise) other);
        return new EqualsBuilder().append(premiseNumber, rhs.premiseNumber).append(postalCode, rhs.postalCode).isEquals();
    }

}
