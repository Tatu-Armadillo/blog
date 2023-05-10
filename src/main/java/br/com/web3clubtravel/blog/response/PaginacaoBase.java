package br.com.web3clubtravel.blog.response;

import org.springframework.data.domain.Page;

public class PaginacaoBase {

    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    public PaginacaoBase() { }

    public <T> PaginacaoBase(final Page<T> page) {
        this.setPageNumber(page.getNumber());
        this.setPageSize(page.getSize());
        this.setTotalPages(page.getTotalPages());
        this.setTotalElements(page.getTotalElements());
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(final int pageNumber) {
        this.pageNumber = (pageNumber + 1);
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public void setTotalElements(final long totalElements) {
        this.totalElements = totalElements;
    }

}
