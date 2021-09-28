package main.java.pageObjects;

public interface LoginPageElements {
  String emailAddress = "body > p-dynamicdialog > div > div > div.p-dialog-content.ng-tns-c17-6 > po-signin-popup > div.formBox > form > div:nth-child(1) > input";
  String password = "body > p-dynamicdialog > div > div > div.p-dialog-content.ng-tns-c17-6 > po-signin-popup > div.formBox > form > div:nth-child(2) > input";
  String SigninButton = "body > p-dynamicdialog > div > div > div.p-dialog-content.ng-tns-c17-6 > po-signin-popup > div.formBox > form > div.signBtn.xl\\:mt-5 > button > span";

}
