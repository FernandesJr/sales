package com.siganatural.sales.dto.sale;

import com.siganatural.sales.dto.nf.NfDTO;
import com.siganatural.sales.dto.product.ProductForSaleDTO;
import com.siganatural.sales.dto.ticket.TicketDTO;
import com.siganatural.sales.entities.Ticket;
import com.siganatural.sales.projections.ProductForSaleProjection;
import com.siganatural.sales.projections.SaleByIdProjection;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaleByIdDTO implements Serializable {

    private Long id;
    private String pharmacyName;
    private String pharmacyCnpj;
    private String salesmanName;
    private Double amount;
    private Instant date;
    private String formPay;
    private Set<ProductForSaleDTO> productsDto = new HashSet<>();
    private NfDTO nfDTO;
    private Set<TicketDTO> tickets = new HashSet<>();

    public SaleByIdDTO(){}

    public SaleByIdDTO(Long id, String pharmacyName, String salesmanName,
                       Double amount, Instant date, String formPay, NfDTO nfDTO, String pharmacyCnpj) {
        this.id = id;
        this.pharmacyName = pharmacyName;
        this.salesmanName = salesmanName;
        this.amount = amount;
        this.date = date;
        this.formPay = formPay;
        this.nfDTO = nfDTO;
        this.pharmacyCnpj = pharmacyCnpj;
    }

    public SaleByIdDTO(SaleByIdProjection projection) {
        this.id = projection.getId();
        this.pharmacyName = projection.getPharmacy();
        this.pharmacyCnpj = projection.getCnpj();
        this.salesmanName = projection.getSalesman();
        this.amount = projection.getAmount();
        this.date = projection.getDate();
        this.formPay = projection.getFormpay();
        this.nfDTO = new NfDTO(projection.getNfid(), projection.getNffile(), projection.getId());
    }

    public void insertTickets(List<Ticket> tickets){
        tickets.forEach(t -> this.tickets.add(new TicketDTO(t)));
    }

    public void insertProducts(List<ProductForSaleProjection> products){
        products.forEach(p -> this.productsDto.add(new ProductForSaleDTO(p)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyCnpj() {
        return pharmacyCnpj;
    }

    public void setPharmacyCnpj(String pharmacyCnpj) {
        this.pharmacyCnpj = pharmacyCnpj;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Set<ProductForSaleDTO> getProductsDto() {
        return productsDto;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getFormPay() {
        return formPay;
    }

    public void setFormPay(String formPay) {
        this.formPay = formPay;
    }

    public NfDTO getNfDTO() {
        return nfDTO;
    }

    public void setNfDTO(NfDTO nfDTO) {
        this.nfDTO = nfDTO;
    }

    public Set<TicketDTO> getTickets() {
        return tickets;
    }
}
