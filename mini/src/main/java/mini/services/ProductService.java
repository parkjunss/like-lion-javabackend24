package mini.services;

import mini.DAO.ProductDAO;
import mini.DTO.ProductDTO;
import mini.DTO.UserDTO;
import mini.utils.AppException;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void registerProduct(ProductDTO productDTO, UserDTO userDTO) {
        if(productDTO.getProductName() == null || productDTO.getProductName().trim().isEmpty()) throw new AppException("상품명은 필수 입력 항목입니다.");
        if(productDTO.getProductPrice() < 0) throw new AppException("가격은 0원 이상이어야 합니다.");
        if(productDTO.getQuantity() < 0) throw new AppException("재고는 0개 이상이어야 합니다.");
        if (productDTO.getUserDTO() == null || productDTO.getUserDTO().getId() == 0) {
            throw new AppException("판매자 정보가 누락되었습니다.");
        }

        int result = productDAO.insertProduct(productDTO);
        if (result <= 0) throw new AppException("상품 등록에 실패했습니다.");
    }

    public void editProduct(ProductDTO productDTO) {
        int result = productDAO.updateProduct(productDTO);
        if (result <= 0) throw new AppException("상품 수정에 실패했습니다.");
    }

    public void deleteMyProduct(ProductDTO productDTO, long loginUserId) {
        ProductDTO product = productDAO.getProduct(productDTO);

        if (product == null) {
            throw new AppException("[삭제 실패] 해당 상품이 존재하지 않습니다.");
        }

        if (product.getUserDTO() == null || product.getUserDTO().getId() != loginUserId) {
            throw new AppException("[삭제 실패] 본인이 등록한 상품만 삭제할 수 있습니다.");
        }

        int result = productDAO.deleteProductWithOwner(product.getId(), loginUserId);
        if (result <= 0) throw new AppException("상품 삭제에 실패했습니다.");
    }

    public List<ProductDTO> searchProducts(String name) {
        List<ProductDTO> list = productDAO.getProductsByName(name);
        if (list.isEmpty()) {
            throw new AppException("검색 결과가 없습니다.");
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