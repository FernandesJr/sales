package com.siganatural.sales.projections;

import java.time.Instant;

public interface TicketNoPaidProjection {

    Long getId();
    String getCnpj();
    String getPharmacy();
    Instant getDue();
    Double getAmount();
    Long getSale();
}
