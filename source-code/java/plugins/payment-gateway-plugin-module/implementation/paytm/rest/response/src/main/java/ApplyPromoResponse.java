import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ApplyPromoResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ApplyPromoResponseHead;

public class ApplyPromoResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ApplyPromoResponseHead applyPromoResponseHead;

    @SerializedName("body")
    private ApplyPromoResponseBody applyPromoResponseBody;

    public ApplyPromoResponseHead getApplyPromoResponseHead() {
        return applyPromoResponseHead;
    }

    public ApplyPromoResponseBody getApplyPromoResponseBody() {
        return applyPromoResponseBody;
    }
}
