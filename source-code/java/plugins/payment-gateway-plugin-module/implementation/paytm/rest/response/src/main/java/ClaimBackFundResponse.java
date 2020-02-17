import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ClaimBackFundResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ClaimBackFundResponseHead;

public class ClaimBackFundResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ClaimBackFundResponseHead claimBackFundResponseHead;

    @SerializedName("body")
    private ClaimBackFundResponseBody claimBackFundResponseBody;

    public ClaimBackFundResponseHead getClaimBackFundResponseHead() {
        return claimBackFundResponseHead;
    }

    public ClaimBackFundResponseBody getClaimBackFundResponseBody() {
        return claimBackFundResponseBody;
    }
}
