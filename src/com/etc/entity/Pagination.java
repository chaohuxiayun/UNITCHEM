package com.etc.entity;

public class Pagination {

    private static final String KEY_PAGE_SIZE = "pagination.size";
    
    private int totalCount;//数据量
    private int pagesize;//每页的数据
    private int pageCount;//有多少页
    public int getPagesize() {
        this.pagesize =8; 
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
      /**  
        if(pagesize == 0)
        {
            String size = PropertyUtil.get
        }
        */
    }
    private int currentPage;//当前页
    private int offset;//偏移量
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageCount() { 
        if(totalCount<1){
            pageCount = 0;
            return pageCount;
        }
        pageCount = (totalCount - 1)/getPagesize() +1;
        return pageCount;
    }
    
    public int getCurrentPage() {
        
        if(currentPage<1){
            currentPage =1 ;
        }
        if(currentPage > getPageCount()) {
            currentPage = getPageCount();
        }
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getOffset() {
        offset = (getCurrentPage() - 1) * getPagesize();
        if(offset<0){
        	offset = 0;
        }
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public boolean isFirstPage(){
        if(this.currentPage<=1){
            return true;
        }
        return false;
    }
    public boolean isLastPage()
    {
        if(this.currentPage>=this.getPageCount()){
            return true;
        }
        return false;
    }
}
