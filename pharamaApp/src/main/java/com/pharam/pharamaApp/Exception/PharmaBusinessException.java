package com.pharam.pharamaApp.Exception;

public class PharmaBusinessException extends  Exception{
    public  enum  PharmaBusinessExceptionCode{
        A(510), B(511), C(512),D(513);

        private int numVal;
        PharmaBusinessExceptionCode(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }

    }
    private  PharmaBusinessExceptionCode errorCode;
    public PharmaBusinessException(String message) {
        super(message);
    }
    public PharmaBusinessException(PharmaBusinessExceptionCode errorCode,String message) {
        super(message);
        this.errorCode=errorCode;
    }
}
