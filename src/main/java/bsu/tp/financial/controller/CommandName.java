package bsu.tp.financial.controller;

import bsu.tp.financial.controller.commandImpl.*;

public enum CommandName {
    SIGN_IN_BUTTON("/signIn", new SignInButton()),
    SIGN_UP_BUTTON("/signUp", new SignUpButton()),
    SIGN_OUT_BUTTON("/", new SignOutButton()),
    EDIT_PROFILE_BUTTON("/editProfile.jsp", new ChangePasswordButton()),
    UPDATE_MONEY_VALUE_BUTTON("/editBankAccountsMoneyValue", new UpdateMoneyValueButton()),
    DELETE_PROFILE_BUTTON("/deleteProfileButton", new DeleteProfileButton()),
    DELETE_USER_BY_ADMIN_BUTTON("deleteUserByAdminButton", new DeleteUserByAdminButton()),
//    EDIT_ADMIN_INFORMATION_BUTTON("/admin/profile", new EditAdminInformationButton()),
//    ADMIN_EDIT_SPECIALTY_EXAM_BUTTON("/admin/profile", new AdminUpdateSpecialtyExamsButton()),
//    ADMIN_UPDATE_PASSWORD_BUTTON("/admin/profile", new AdminUpdatePasswordButton()),
//    ADMIN_REQUESTS_BUTTON("/admin/requests", new AdminRequestsButton()),
//    //EDIT_ADMIN_INFORMATION("/adminEditInformation.jsp", new EditAdminInformation()),
    EDIT_BANK_ACCOUNT_BUTTON("/editBankAccount", new EditBankAccountButton()),
    CREATE_ADMIN_BUTTON("/admins", new CreateAdminButton()),
    ADMINS("/adminAdmins.jsp", new Admins()),
    ADMIN_PROFILE("/adminProfile", new SignInButton()),
    PROFILE("/profile", new Profile()),
    PERSONAL_INFO("/personalInfo.jsp", new Profile()),
    BANK_ACCOUNTS("/bankAccounts.jsp", new Profile()),
    BANK_ACCOUNTS_BUTTON("/profile/bankAccounts", new Profile()),
    RAINY_DAY("/rainyDay.jsp", new Profile()),
    STATEMENT("/statement.jsp", new Profile()),
    ADMIN_USERS("/adminUsers.jsp", new AdminUsers()),
    ADMIN_USERS_BUTTON("/users", new AdminUsers()),
    EDIT_BANK_ACCOUNT("/editBankAccount.jsp", new EditBankAccountButton()),
    UNIT_BANK_ACCOUNTS("/unitBankAccounts.jsp", new Profile()),
    EDIT_PROFILE("/editProfile.jsp", new Profile()),
    SEND_EMAIL_STATEMENT_BUTTON("/sendEmailStatementButton", new SendEmailStatementButton()),
    UNIT_BANKACCOUNTS_BUTTON("/profile" , new UnitBankAccountsButton());
//    FACULTY_PAGE("/faculty.jsp", new FacultyPage()),
//    //LANGUAGE_BUTTON("/language.jsp", new LanguageButton()),
//    ERROR("/error", new Error());
//    //MAIN_PAGE("/", new MainPage());


    private final String jspAddress;
    private final Command command;

    public String getJspAddress() {
        return jspAddress;
    }

    public Command getCommand() {
        return command;
    }

    CommandName(String jspAddress, Command command) {
        this.jspAddress = jspAddress;
        this.command = command;
    }
}
