package com.example.demo.subdemo4.shopdto.bankdto;

import lombok.Data;

@Data
public class BankPagation {
    int currentPage;
    int pageSize;
    int demoTotal;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDemoTotal() {
        return demoTotal;
    }

    public void setDemoTotal(int demoTotal) {
        this.demoTotal = demoTotal;
    }

    @Override
    public String toString() {
        return "BankPagation{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", demoTotal=" + demoTotal +
                '}';
    }
}
