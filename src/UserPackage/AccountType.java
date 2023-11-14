package UserPackage;

public enum AccountType {
    WALLET_ACCOUNT("Wallet_account"),
    BANK_ACCOUNT("Bank_account"),
    NORMAL_ACCOUNT("Normal_account");

    private final String label;

    AccountType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
