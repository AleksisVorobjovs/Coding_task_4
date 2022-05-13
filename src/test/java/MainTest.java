import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void multiplicationTableTest(){
        var multiplicationTable = new Main();
        int[][] testTable=multiplicationTable.multiplicationTableCreator(10,10);
        assertEquals(9,testTable[0][8]);
        assertEquals(8,testTable[7][0]);
        assertEquals(1,testTable[0][0]);
        assertEquals(100,testTable[testTable.length-1][testTable.length-1]);
        assertEquals(48,testTable[5][7]);
    }

    @Test
    void copyArray(){
        var copy = new Main();
        int[] array = {7,7,23,1,4};
        int[] testArray=copy.copyArray(array);
        assertEquals(Arrays.toString(array),Arrays.toString(testArray));
    }
    @Test//write a code which tries to deposit allowed amount
    void bankDeposit(){
        BankAccount myBank = new BankAccount();
        double amount = 4000;
        myBank.deposit(amount);
        assertEquals(amount,myBank.getBalance());
    }

    @Test//write a code which tries to deposit more than max limit (based on my true daily deposit)
    void bankDepositTooMuch(){
        BankAccount myBank = new BankAccount();
        double amount = 5001;
        myBank.deposit(amount);
        assertNotEquals(amount,myBank.getBalance());

    }
    @Test//write a code which tries to withdraw allowed amount
    void bankWithdraw(){
        BankAccount myBank = new BankAccount();
        double amount = 100;
        myBank.deposit(amount);
        myBank.withdraw(30);
        assertEquals(70,myBank.getBalance());
    }

    @Test//write a code which tries to withdraw more money than there is in bank account (tries to buy Tesla Model S)
    void bankWithdrawTooMuch(){
        BankAccount myBank = new BankAccount();
        double amount = 100;
        myBank.deposit(amount);
        myBank.withdraw(69420);
        assertEquals(amount,myBank.getBalance());
    }

    @Test//write a code which tries to transfer allowed amount
    void bankTransfer(){
        BankAccount myBank = new BankAccount();
        BankAccount notMyBank = new BankAccount();
        double amount = 100;
        myBank.deposit(amount);
        myBank.transferFrom(notMyBank,30);
        assertEquals(70,myBank.getBalance());
        assertEquals(30,notMyBank.getBalance());
    }

    @Test//write a code which tries to transfer more money from one account to another account than possible
    void bankTransferTooMuch(){
        BankAccount myBank = new BankAccount();
        BankAccount notMyBank = new BankAccount();
        double amount = 100;
        myBank.deposit(amount);
        myBank.transferFrom(notMyBank,200);
        assertEquals(amount,myBank.getBalance());
        assertEquals(0,notMyBank.getBalance());
    }

       // myBank.transferFrom(notMyBank,50);
}