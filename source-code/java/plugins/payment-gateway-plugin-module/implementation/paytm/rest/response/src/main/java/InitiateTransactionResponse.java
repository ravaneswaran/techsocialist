import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.InitiateTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateTransactionResponseHead;


public class InitiateTransactionResponse extends AbstractPaytmResponse{

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private InitiateTransactionResponseHead initiateTransactionResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private InitiateTransactionResponseBody initiateTransactionResponseBody;

    public InitiateTransactionResponseHead getInitiateTransactionResponseHead() {
        return initiateTransactionResponseHead;
    }

    public InitiateTransactionResponseBody getInitiateTransactionResponseBody() {
        return initiateTransactionResponseBody;
    }

    public boolean ok() {
        return this.initiateTransactionResponseBody.ok();
    }
}
