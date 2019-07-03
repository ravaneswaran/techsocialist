Feature: Logout Action

Scenario: Successful LogOut
 Given User has logged in
 When User LogOut from the Application
 Then Message displayed LogOut Successfully