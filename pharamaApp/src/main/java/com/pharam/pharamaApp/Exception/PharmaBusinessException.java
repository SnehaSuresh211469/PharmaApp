package com.pharam.pharamaApp.Exception;

public class PharmaBusinessException extends  Exception{
    public  enum  PharmaBusinessExceptionCode{
        A(510), B(511), C(512),D(513),E(500);

        private int errorCodeMsg;
        PharmaBusinessExceptionCode(int errorCodeMsg) {
            this.errorCodeMsg = errorCodeMsg;
        }

        public int getErrorCodeMsg() {
            return errorCodeMsg;
        }

    }
    private  PharmaBusinessExceptionCode errorCode;

    public PharmaBusinessExceptionCode getErrorCode() {
        return errorCode;
    }

    public PharmaBusinessException(String message) {
        super(message);
    }
    public PharmaBusinessException(PharmaBusinessExceptionCode errorCode,String message) {
        super(errorCode.errorCodeMsg+" "+message);
        this.errorCode=errorCode;
    }
}
