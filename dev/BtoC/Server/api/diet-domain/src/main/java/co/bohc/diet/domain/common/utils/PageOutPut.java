package co.bohc.diet.domain.common.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PageOutPut<T, S> extends PageImpl<T>{
	
	/**
	 * @author g_k
	 */
	private static final long serialVersionUID = 1L;
	
	private S info;

	public PageOutPut(List<T> content) {
		super(content);
	}
	
	public PageOutPut(List<T> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}
	
	public PageOutPut(Page<T> page, Pageable pageable ,S info) {
		super(page.getContent(), pageable, page.getTotalElements());
		this.info = info;
	}
	
	public PageOutPut(List<T> content, Pageable pageable, long total, S info) {
		super(content, pageable, total);
		this.info = info;
	}


	public S getInfo() {
		return info;
	}
	
}
