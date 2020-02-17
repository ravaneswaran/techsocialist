import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchAllOffersResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchAllOffersResponseHead;

public class FetchAllOffersResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private FetchAllOffersResponseHead fetchAllOffersResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private FetchAllOffersResponseBody fetchAllOffersResponseBody;

    public FetchAllOffersResponseHead getFetchAllOffersResponseHead() {
        return fetchAllOffersResponseHead;
    }

    public FetchAllOffersResponseBody getFetchAllOffersResponseBody() {
        return fetchAllOffersResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getFetchAllOffersResponseBody().ok();
    }
}
