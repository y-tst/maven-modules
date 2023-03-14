module application {

    requires transitive jmp.bank.api;
    requires jmp.dto;
    requires jmp.cloud.bank.impl;
    exports sorce.main.java;
}