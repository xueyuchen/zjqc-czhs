package co.bohc.diet.domain.service.accessory;

import java.util.List;

public class LucenePage {
    private Integer size;
    private Integer totalElements;
    private Integer page;
    private List<LuceneOutput> content;

    
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public List<LuceneOutput> getContent() {
        return content;
    }

    public void setContent(List<LuceneOutput> content) {
        this.content = content;
    }

}
