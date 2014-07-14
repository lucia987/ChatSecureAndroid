package jni;

import java.util.HashSet;

import android.util.Log;

public class PrivateData {
    private static String newPassphrase;
    private static HashSet<PrivateDataHandler> handlers = new HashSet<PrivateDataHandler>();
    
    public static PrivateDataHandler add(Object obj) {

        Log.d("LUCIA", "PrivateData.add()");
        PrivateDataHandler handler = new PrivateDataHandler(obj);
        handlers.add(handler);
        return handler;
    }
    
    public static boolean LockScreenActivity$newEqualsConfirmation(
            PrivateDataHandler mHandler1, 
            PrivateDataHandler mHandler2) {

        Log.d("LUCIA", "PrivateData.newEqualsConfirmation");
        return ((String)mHandler1.getData()).equals(
                (String)mHandler2.getData());
    }

    public static boolean LockScreenActivity$isPasswordFieldEmpty(PrivateDataHandler mHandler) {

        Log.d("LUCIA", "PrivateData.isPasswordFieldEmpty");
        return ((String)mHandler.getData()).length() == 0;
    }

    public static PrivateDataHandler LockScreenActivity$isPasswordValid(
            PrivateDataHandler mHandler) {

        Log.d("LUCIA", "PrivateData.isPasswordValid");
        char[] tmp = ((String)mHandler.getData()).toCharArray();
        PrivateDataHandler tmpHandler = add(tmp);
        return tmpHandler;
    }

    public static boolean LockScreenActivity$validatePassword(
            PrivateDataHandler handler, int minPassLength) {

        Log.d("LUCIA", "PrivateData.validatePassword");
        char[] pass = (char[])handler.getData();
        return (pass.length < minPassLength && pass.length != 0);
    }

    public static boolean LockScreenActivity$initializeWithPassphrase1(
            PrivateDataHandler passphrase) {

        Log.d("LUCIA", "PrivateData.initializeWithPassphrase1");
        return ((String)passphrase.getData()).isEmpty();
    }

    public static PrivateDataHandler LockScreenActivity$initializeWithPassphrase2(
            PrivateDataHandler passphrase) {
        Log.d("LUCIA", "PrivateData.initializeWithPassphrase2");
        char[] tmp = ((String)passphrase.getData()).toCharArray();
        return add(tmp);
    }

    public static boolean LockScreenActivity$isConfirmationFieldEmpty(
            PrivateDataHandler mConfirmPassphraseHandler) {
        Log.d("LUCIA", "PrivateData.LockScreenActivity$isConfirmationFieldEmpty");
        return ((String)mConfirmPassphraseHandler.getData()).isEmpty();
    }
}

