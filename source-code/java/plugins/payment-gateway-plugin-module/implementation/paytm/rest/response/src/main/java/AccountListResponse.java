import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.AccountListResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.AccountListResponseHead;

public class AccountListResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private AccountListResponseHead accountListResponseHead;

    @SerializedName("body")
    private AccountListResponseBody accountListResponseBody;

    public AccountListResponseHead getAccountListResponseHead() {
        return accountListResponseHead;
    }

    public AccountListResponseBody getAccountListResponseBody() {
        return accountListResponseBody;
    }
}
