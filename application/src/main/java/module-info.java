module application {

    requires transitive jmp.bank.api;
    requires jmp.dto;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    exports edu.javamentoring.application;
}