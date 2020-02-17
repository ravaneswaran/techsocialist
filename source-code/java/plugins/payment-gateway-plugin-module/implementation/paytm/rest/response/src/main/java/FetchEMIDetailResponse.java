import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchEMIDetailResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchEMIDetailResponseHead;

public class FetchEMIDetailResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private FetchEMIDetailResponseHead fetchEMIDetailResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private FetchEMIDetailResponseBody fetchEMIDetailResponseBody;

    public FetchEMIDetailResponseHead getFetchEMIDetailResponseHead() {
        return fetchEMIDetailResponseHead;
    }

    public FetchEMIDetailResponseBody getFetchEMIDetailResponseBody() {
        return fetchEMIDetailResponseBody;
    }
}
