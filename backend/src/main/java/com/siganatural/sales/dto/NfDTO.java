package com.siganatural.sales.dto;

import java.io.Serializable;

public class NfDTO implements Serializable {

    private Long id;
    private byte[] file;

    public NfDTO(){}

    public NfDTO(Long id, byte[] file) {
        this.id = id;
        this.file = file;
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
}
