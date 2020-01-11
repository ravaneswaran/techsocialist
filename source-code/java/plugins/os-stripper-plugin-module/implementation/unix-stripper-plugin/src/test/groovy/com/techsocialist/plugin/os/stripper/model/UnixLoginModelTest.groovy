package com.techsocialist.plugin.os.stripper.model

import spock.lang.Specification

class UnixLoginModelTest extends Specification{

    def "testing setter and getter of user id in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setUserId("")
        then :
            "" == unixLogin.getUserId()
    }

    def "testing setter and getter of user name in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setUserName("")
        then :
            "" == unixLogin.getUserName()
    }

    def "testing setter and getter of proc in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setPROC("")
        then :
            "" == unixLogin.getPROC()
    }

    def "testing setter and getter of pwd lock in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setPWDLock("")
        then :
            "" == unixLogin.getPWDLock()
    }

    def "testing setter and getter of pwd deny in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setPWDDeny("")
        then :
            "" == unixLogin.getPWDDeny()
    }

    def "testing setter and getter of last login in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setLastLogin("")
        then :
            "" == unixLogin.getLastLogin()
    }

    def "testing setter and getter of gecos in unix login model"(){
        setup :
            def unixLogin = new UnixLogin()
        when :
            unixLogin.setGECOS("")
        then :
            "" == unixLogin.getGECOS()
    }
}
