package ecommerce.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ecommerce.dao.ProdutoDao;
import ecommerce.model.Produto;

public class LazyProdutoDataModel extends LazyDataModel<Produto>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao;
	private List<Produto> produtos;
	private String filtro;
	
	public LazyProdutoDataModel(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
		this.filtro = "";
	}
	
	@Override
	public Produto getRowData(String rowKey) {
		
		Integer id = Integer.valueOf(rowKey);
		
		for (Produto p : produtos) {
			if (id.equals(p.getIdproduto())) {
				return p;
			}
		}
		
		return null;
	}
	
	@Override
	public Object getRowKey(Produto produto) {
		return produto.getIdproduto();
}
	
	@Override
	public List<Produto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
//		if (filtro.trim().isEmpty()) {
//			produtos = produtoDao.listarTodos(first, pageSize);
//		} else {
//		}
		produtos = produtoDao.listar(first, pageSize);
		if (getRowCount()<=0) {
			setRowCount((int) produtoDao.getTotal(filtro));
		}
		this.setPageSize(pageSize);
		return produtos;
	}
	

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel):
         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
    
        }
    }

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		setRowCount(0);
		this.filtro = filtro;
	}

	public String filtrar() {
		return null;
	}
	
	public List<String> complete(){
		List<String> resultado = new ArrayList<String>();
		for (Produto p : produtoDao.listar(0, 10)){
			resultado.add(p.getNome());
		}
		
		
		return resultado;
	}
}
