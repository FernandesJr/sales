package com.siganatural.sales.projections;

import java.time.Instant;

public interface SaleByIdProjection {

    Long getId();
    String getPharmacy();
    String getCnpj();
    String getSalesman();
    Instant getDate();
    String getFormpay();
    Double getAmount();
    Long getNfid();
    byte[] getNffile();

}
