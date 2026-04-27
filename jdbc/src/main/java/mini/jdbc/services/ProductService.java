package mini.jdbc.services;

import mini.jdbc.DAO.ProductDAO;
import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void registerProduct(ProductDTO productDTO) {
        int result = productDAO.insertProduct(productDTO);
        if (result > 0) System.out.println("상품 등록 성공!");
    }

    public boolean editProduct(ProductDTO productDTO) {
        return productDAO.updateProduct(productDTO) > 0;
    }

    public boolean deleteMyProduct(ProductDTO productDTO, long loginUserId) {
        ProductDTO product = productDAO.getProduct(productDTO);

        if (product == null) {
            System.out.println("[삭제 실패] 해당 상품이 존재하지 않습니다.");
            return false;
        }

        if (product.getUserDTO() == null || product.getUserDTO().getId() != loginUserId) {
            System.out.println("[삭제 실패] 본인이 등록한 상품만 삭제할 수 있습니다.");
            return false;
        }

        int result = productDAO.deleteProductWithOwner(product.getId(), loginUserId);
        if (result > 0) {
            System.out.println("[성공] 상품이 정상적으로 삭제되었습니다.");
            return true;
        }
        return false;
    }

    public List<ProductDTO> searchProducts(String name) {
        List<ProductDTO> list = productDAO.getProductsByName(name);
        if (list.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        }
        return list;
    }

    public ProductDTO getProduct(long productId) {
        return productDAO.getProduct(productId);
    }

    public List<ProductDTO> getMyProducts(UserDTO userDTO) {
        return productDAO.getUserProducts(userDTO);
    }

    public List<ProductDTO> getAllProducts() {
        return productDAO.getAllProducts();
    }
}