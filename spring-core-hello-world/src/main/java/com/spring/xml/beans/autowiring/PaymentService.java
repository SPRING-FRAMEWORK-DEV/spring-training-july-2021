package com.spring.xml.beans.autowiring;

public class PaymentService {

    private PaymentDao paymentDao;

    public boolean isPaymentSuccess(String txnId) {
        return paymentDao.getPaymentObject(txnId) != null;
    }

    // autowire byType uses this
    public void setPaymentDao1(PaymentDao paymentDao) {
        System.out.println(this.getClass()+ "inside setter");
        this.paymentDao = paymentDao;
    }
}
