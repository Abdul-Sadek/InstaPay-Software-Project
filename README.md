# InstaPay Software System

This is a simple money transaction system simulating the real InstaPay application. The system allows users to perform money transfers or pay their bills conveniently.

## System Services

The services offered by the InstaPay Software System include:

a. Transfer to another Instapay account

b. Transfer to Bank Account

c. Transfer To a Mobile Wallet through wallet providers: Wallet providers can be telecommunication companies that provide wallets (e.g., Vodafone Cash), banks that provide wallets (e.g., CIB), or electronic payment companies (e.g., Fawry).

d. Paying utilities’ bills, where such bills can be for Gas, Electricity, or Water.

## System Requirements

1. The user should be able to signup to the app in two ways:
    - Register using his/her bank account and the registered mobile number on the bank so the app can verify it through the bank API.
    - Register using his mobile number with a wallet provided from a wallet provider as mentioned earlier; also, the mobile number should be verified first with the wallet provider.
      For both users, after verifying the bank account/wallet, the system should verify that the user owns the mobile number by sending OTP and then verifying it. Then he/she has to enter a username (unique through the system) and a complex password.

2. User will be able to sign in to the system using his Instapay username and password. After logging in, the user's profile will be loaded based on his type.

3. Both users have the option to:
    - Transfer to Wallet using the mobile number
    - Transfer to Another Instapay account
    - Inquire about his balance
    - Pay bills. Transferring to a bank account is only valid for users registered using their bank account.

4. Utility bill payment involves creating and deducting the bill from the user’s account.
   You need to make your assumptions about the bill contents and to support the creation and payment of the three bill types: Gas, Electricity, and Water. Bill contents vary based on the bill types.
