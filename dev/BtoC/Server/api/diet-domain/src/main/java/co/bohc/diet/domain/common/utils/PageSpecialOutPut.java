package co.bohc.diet.domain.common.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageSpecialOutPut<T, S, E> extends PageImpl<T>{
	
	private static final long serialVersionUID = 1L;
	
	private int size;
	
	private int number;
	
	private Sort sort;
	
	private long totalElements;
	
	private int totalPages;
	
	private int numberOfElements;
	
	private E info;
	
	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public PageSpecialOutPut(List<T> content) {
		super(content);
	}
	
	public PageSpecialOutPut(List<T> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}
	
	public PageSpecialOutPut(List<T> content, Page<S> page) {
		super(content);
		this.size = page.getSize();
		
		this.number =  page.getNumber();
		
		this.sort = page.getSort();
		
		this.totalElements = page.getTotalElements();
		
		this.totalPages = page.getTotalPages();
		
		this.numberOfElements = page.getNumberOfElements();
	}
	
	public PageSpecialOutPut(List<T> content, Page<S> page, long total, E info) {
		super(content);
		this.size = page.getSize();
		
		this.number =  page.getNumber();
		
		this.sort = page.getSort();
		
		this.totalElements = total;
		
		this.totalPages = page.getTotalPages();
		
		this.numberOfElements = page.getNumberOfElements();
		
		this.info = info;
	}
	
	public PageSpecialOutPut(List<T> content, Page<S> page, long total) {
		super(content);
		this.size = page.getSize();
		
		this.number =  page.getNumber();
		
		this.sort = page.getSort();
		
		this.totalElements = total;
		
		this.totalPages = page.getTotalPages();
		
		this.numberOfElements = page.getNumberOfElements();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	
	public boolean hasPreviousPage() {
		return getNumber() > 0;
	}

	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	public boolean hasNextPage() {
		return getNumber() + 1 < getTotalPages();
	}

	public boolean isLastPage() {
		return !hasNextPage();
	}

}
