package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class UserProfileSarvatraTest extends Specification{

    def "test UserProfileSarvatra instance"(){
        when:
        UserProfileSarvatra userProfileSarvatra = new UserProfileSarvatra()

        then:
        null != userProfileSarvatra
    }

}
