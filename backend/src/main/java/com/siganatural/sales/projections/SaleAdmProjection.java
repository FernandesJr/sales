package com.siganatural.sales.projections;

import java.time.Instant;

public interface SaleAdmProjection {

    Long getId();
    String getCnpj();
    String getPharmacy();
    String getSalesman();
    Instant getDate();
    String getFormPay();
    Double getAmount();
    Long getTicket();
    Long getNf();

}
