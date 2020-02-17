import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchBinDetailsResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchBinDetailsResponseHead;

public class FetchBinDetailsResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private FetchBinDetailsResponseHead fetchBinDetailsResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private FetchBinDetailsResponseBody fetchBinDetailsResponseBody;

    public FetchBinDetailsResponseHead getFetchBinDetailsResponseHead() {
        return fetchBinDetailsResponseHead;
    }

    public FetchBinDetailsResponseBody getFetchBinDetailsResponseBody() {
        return fetchBinDetailsResponseBody;
    }

    @Override
    public boolean ok() {
        return this.fetchBinDetailsResponseBody.ok();
    }
}
