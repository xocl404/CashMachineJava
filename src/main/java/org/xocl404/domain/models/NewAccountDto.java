package org.xocl404.domain.models;

public class NewAccountDto extends BaseDto {
    public final long accountNumber;

    public NewAccountDto(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
