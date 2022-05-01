package com.siganatural.sales.dto.nf;

import com.siganatural.sales.entities.Nf;

import java.io.Serializable;

public class NfDTO implements Serializable {

    private Long id;
    private byte[] file;
    private Long saleId;

    public NfDTO(){}

    public NfDTO(Long id, byte[] file, Long saleId) {
        this.id = id;
        this.file = file;
        this.saleId = saleId;
    }

    public NfDTO(Nf entity) {
        this.id = entity.getId();
        this.file = entity.getImage();
        this.saleId = entity.getSale().getId();
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
