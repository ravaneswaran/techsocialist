import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchInstrumentResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchInstrumentResponseHead;

public class FetchInstrumentResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private FetchInstrumentResponseHead fetchInstrumentResponseHead;

    @SerializedName("body")
    private FetchInstrumentResponseBody fetchInstrumentResponseBody;

    public FetchInstrumentResponseHead getFetchInstrumentResponseHead() {
        return fetchInstrumentResponseHead;
    }

    public FetchInstrumentResponseBody getFetchInstrumentResponseBody() {
        return fetchInstrumentResponseBody;
    }
}
