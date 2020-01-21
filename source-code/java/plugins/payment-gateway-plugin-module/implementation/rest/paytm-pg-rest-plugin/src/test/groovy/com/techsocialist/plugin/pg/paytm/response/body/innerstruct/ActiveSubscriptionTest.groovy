package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class ActiveSubscriptionTest extends Specification{

    def "test ActiveSubscription instance"(){
        when:
        ActiveSubscription activeSubscription = new ActiveSubscription();

        then:
        null != activeSubscription
    }
}
