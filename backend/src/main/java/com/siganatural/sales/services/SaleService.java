package com.siganatural.sales.services;

import com.siganatural.sales.dto.product.ProductSaleDTO;
import com.siganatural.sales.dto.sale.SaleAdmViewDTO;
import com.siganatural.sales.dto.sale.SaleByIdDTO;
import com.siganatural.sales.dto.sale.SaleInsertDTO;
import com.siganatural.sales.entities.*;
import com.siganatural.sales.projections.ProductForSaleProjection;
import com.siganatural.sales.projections.SaleAdmProjection;
import com.siganatural.sales.projections.SaleByIdProjection;
import com.siganatural.sales.repositories.*;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private SaleProductRepository saleProductRepository;

    @Transactional(readOnly = true)
    public Page<SaleAdmViewDTO> findSalesAdm(Pageable pageable, String cnpj, String noNf, String noTicket){
        Page<SaleAdmProjection> page = repository.findSalesAdm(pageable, cnpj, noNf, noTicket);
        return page.map(s -> new SaleAdmViewDTO(s));
    }

    @Transactional(readOnly = true)
    public SaleByIdDTO findSaleWithProductsAndTickets(Long id){

        SaleByIdProjection projection = repository.findSale(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        SaleByIdDTO dto = new SaleByIdDTO(projection);
        List<Ticket> tickets = ticketRepository.findBySale(new Sale(id));
        dto.insertTickets(tickets);
        List<ProductForSaleProjection> products = productRepository.findForSale(id);
        dto.insertProducts(products);
        return dto;
    }

    @Transactional
    public void insert(SaleInsertDTO dto){
        User user = authService.userAuthenticated();
        Salesman salesman = salesmanRepository.findByUser(user);
        Pharmacy pharmacy = pharmacyRepository.findByCnpj(dto.getCnpj());
        Instant date = Instant.now();
        Sale sale = new Sale();
        sale.setSalesman(salesman);
        sale.setPharmacy(pharmacy);
        sale.setDate(date);
        sale.setFormPay(dto.getFormPay());
        Double aux = 0D;
        for (ProductSaleDTO p : dto.getProducts()) {
            if(p.getQuantity() != 0){
                Product product = productRepository.findById(p.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Entity Product "+p.getProductId()+" not found"));
                aux += product.getPrice() * p.getQuantity();
                System.out.println(p);
            }
        }
        sale.setAmount(aux);
        sale = repository.save(sale);

        aux = 0D;
        for (ProductSaleDTO p : dto.getProducts()) {
            if(p.getQuantity() != 0){
                Product product = productRepository.findById(p.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Entity Product "+p.getProductId()+" not found"));
                SaleProduct saleProduct = new SaleProduct();
                saleProduct.setSale(sale);
                saleProduct.setProductId(product.getId());
                saleProduct.setPriceProduct(product.getPrice());
                saleProduct.setQuantityProduct(p.getQuantity());
                saleProductRepository.save(saleProduct);
            }
        }
    }
}
